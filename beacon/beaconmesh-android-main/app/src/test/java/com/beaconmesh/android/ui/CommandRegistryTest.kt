package com.bitchat.android.ui

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

/**
 * The registry is the single source of truth for both the composer autocomplete and `/help`,
 * so these tests pin the properties that keep the two honest.
 */
class CommandRegistryTest {

    private val meshTimeline = CommandContext(
        inPrivateChat = false,
        inChannel = false,
        inPublicGeohash = false
    )
    private val meshChannel = meshTimeline.copy(inChannel = true)
    private val privateChat = meshTimeline.copy(inPrivateChat = true)
    private val publicGeohash = meshTimeline.copy(inPublicGeohash = true)

    @Test
    fun `every command name resolves to exactly one definition`() {
        CommandRegistry.definitions.forEach { definition ->
            assertEquals(
                "duplicate definition for ${definition.command}",
                1,
                CommandRegistry.definitions.count { it.matches(definition.command) }
            )
            definition.aliases.forEach { alias ->
                assertTrue(
                    "${definition.command} alias $alias does not resolve",
                    CommandRegistry.find(alias) == definition
                )
            }
        }
    }

    @Test
    fun `no two commands claim the same alias`() {
        val names = CommandRegistry.definitions.flatMap { it.names }
        assertEquals(names.size, names.distinct().size)
    }

    @Test
    fun `unknown command resolves to nothing`() {
        assertEquals(null, CommandRegistry.find("/definitely-not-a-command"))
        assertEquals(null, CommandRegistry.find("/"))
    }

    @Test
    fun `lookup is case insensitive through the caller's normalization`() {
        assertEquals("/sos", CommandRegistry.find("/sos")?.command)
        assertEquals("/help", CommandRegistry.find("/help")?.command)
    }

    @Test
    fun `removed commands are not offered`() {
        val removed = listOf("/block", "/unblock", "/m", "/msg", "/w", "/who", "/j", "/join", "/channels", "/channel", "/save")
        removed.forEach { cmd ->
            assertEquals("command $cmd should not be registered", null, CommandRegistry.find(cmd))
            assertFalse("command $cmd should not be available in timeline", CommandRegistry.available(meshTimeline).any { it.matches(cmd) })
            assertFalse("command $cmd should not be available in channel", CommandRegistry.available(meshChannel).any { it.matches(cmd) })
        }
    }

    @Test
    fun `channel commands are offered only inside a channel`() {
        val timelineCommands = CommandRegistry.available(meshTimeline).map { it.command }
        val channelCommands = CommandRegistry.available(meshChannel).map { it.command }

        listOf("/pass", "/transfer").forEach { command ->
            assertFalse("$command should be hidden outside a channel", timelineCommands.contains(command))
            assertTrue("$command should be offered inside a channel", channelCommands.contains(command))
        }
    }

    @Test
    fun `pay stays hidden in a public location channel`() {
        val commands = CommandRegistry.available(publicGeohash).map { it.command }
        assertFalse(commands.contains("/pay"))
        assertTrue(CommandRegistry.available(privateChat).any { it.command == "/pay" })
    }

    @Test
    fun `help lists every command available in that context`() {
        val help = CommandRegistry.helpText(meshChannel)
        val offered = CommandRegistry.available(meshChannel).map { it.command }

        assertTrue("help must start with its header", help.startsWith("commands:"))
        offered.forEach { command ->
            assertTrue("help is missing $command", help.contains(command))
        }
        assertFalse(
            "help must not advertise channel commands outside a channel",
            CommandRegistry.helpText(meshTimeline).contains("/transfer")
        )
    }

    @Test
    fun `help covers each command exactly once per line`() {
        val help = CommandRegistry.helpText(meshChannel)
        val commandLines = help.lines().drop(1)

        assertEquals(CommandRegistry.available(meshChannel).size, commandLines.size)
        commandLines.forEach { line ->
            val command = line.substringBefore(" ")
            assertEquals(
                "help lists $command more than once",
                1,
                commandLines.count { it.substringBefore(" ") == command }
            )
        }
    }

    @Test
    fun `help names syntax and omits removed commands`() {
        val help = CommandRegistry.helpText(meshTimeline)

        assertTrue("hug syntax must be shown", help.contains("/hug <nickname>"))
        assertTrue("pay syntax must be shown", help.contains("/pay <token> [public]"))
        assertTrue("sos syntax must be shown", help.contains("/sos [note]"))

        val removed = listOf("/block", "/unblock", "/m", "/msg", "/w", "/who", "/j", "/join", "/channels", "/channel")
        removed.forEach { cmd ->
            assertFalse("help must not contain $cmd", help.contains(cmd))
        }
    }

    @Test
    fun `help states the mesh restriction for sos`() {
        val help = CommandRegistry.helpText(meshTimeline)
        assertTrue(help.lines().single { it.startsWith("/sos") }.contains("mesh only"))
    }

    @Test
    fun `mesh context is only the timeline and mesh channels`() {
        assertTrue(meshTimeline.isMesh)
        assertTrue(meshChannel.isMesh)
        assertFalse(privateChat.isMesh)
        assertFalse(publicGeohash.isMesh)
    }
}