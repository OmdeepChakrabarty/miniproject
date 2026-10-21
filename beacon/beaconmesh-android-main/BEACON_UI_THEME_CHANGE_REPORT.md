# BEACON / DisasterMesh — UI Theme Change Report
**Document Version:** 1.0.0  
**Project:** BEACON / DisasterMesh (Android Jetpack Compose Offline Disaster Communication Mesh Network)  
**Target Scope:** Strictly Visual / Presentation / Theme Overhaul  
**Functionality Impact:** **0% (Zero Functional Logic Changes)**

---

## 1. Current UI Analysis

### 1.1 Architecture & Visual Structure
The existing application is built using **Jetpack Compose (Material 3)** in Kotlin. The current presentation architecture relies on a centralized token system (`BitchatPalette`, `ChatVisualTokens`, `Typography`, `Theme`, `MessageBubbleStyle`, and `PeerColors`).

### 1.2 Current Visual Identity
* **Generic iOS/Consumer Messenger Styling:** The current UI closely resembles a minimalist consumer chat client (inspired by iOS Messages and flat dark mode).
* **Color Palette:**
  * Dark Theme: Pure `#000000` pitch black background, `#1C1C1E` dark grey container surfaces, and iOS standard `#0A84FF` / `#007AFF` blue tint.
  * Light Theme: Pure `#FFFFFF` white background with generic Apple-style blue accents (`#007AFF`).
  * Outgoing Bubbles: Monolithic bright consumer blue (`#0A84FF` / `#1B8AFB`).
  * Incoming Bubbles: Neutral low-contrast grey (`#26262A` / `#E5E5EA`).
* **Visual Hierarchy:**
  * Flat, hairline-separated headers and composer with minimal emergency affordances.
  * SOS messages are identified only by an emoji/text prefix (`🆘 SOS`) within standard bubble styling.
  * Peer list and mesh connection states read as basic contacts rather than an active multi-hop RF/BLE emergency mesh topology.
  * Status badges lack rugged mission-readiness and tactical field legibility.

---

## 2. Proposed Disaster Communication Theme

### 2.1 Theme Identity: *Tactical Disaster Emergency Mesh (BEACON)*
The new visual direction transforms the application into an **authentic, mission-critical, offline emergency disaster response console** designed for rapid field operation when cellular towers and internet infrastructure are down.

### 2.2 Core Visual Pillars
1. **Emergency Preparedness & Response:**
   * High-contrast tactical dark foundation (**Carbon & Deep Slate: `#0B0F14`, `#111822`, `#1A2332`**) optimized for extreme outdoor daylight and battery-saving field operations.
   * **Beacon Safety Orange (`#FF5722` / `#FF6D00`)** as the primary high-visibility action and brand color.
   * **Distress Beacon Red (`#FF2A4D` / `#D32F2F`)** reserved exclusively for SOS alerts, critical emergency broadcasts, and distress channels.
2. **Offline Mesh Connectivity & Telemetry:**
   * **Active Tactical Cyan / Radio Green (`#00E5FF` / `#00E676`)** for verified offline BLE peer links, active radio discovery, and direct mesh hops.
   * **Relay Amber / Mesh Gold (`#FFB300`)** for multi-hop mesh relays, network routing hops, and battery preservation states.
3. **Field Reliability & Tactical Legibility:**
   * Ruggedized panel styling with crisp precision borders (`#1E293B` / `#2D3B4F`), tactical corner geometry, and clear contrast.
   * Distinct mission-critical status indicators (Signal RSSI dBm bars, Hop counts `1-HOP DIRECT` vs `MULTI-HOP RELAY`, Encryption Safety Badges).
   * Monospace/Technical accent typography for identifiers, radio frequencies, geohashes, and coordinates.

---

## 3. UI Changes Planned

| UI Element | Current Design | Proposed BEACON DisasterMesh Design |
| :--- | :--- | :--- |
| **Color Palette (Dark)** | Flat `#000000` black + `#0A84FF` consumer blue | Tactical Deep Carbon (`#0B0F14`) + Field Slate (`#121924`) + Beacon Amber/Orange (`#FF6D00`) + Tactical Cyan (`#00E5FF`) |
| **Color Palette (Light)** | Generic white (`#FFFFFF`) + consumer blue | High-Contrast Field Day Mode (`#F0F4F8` / `#FFFFFF`) + Tactical Navy (`#0F172A`) + Safety Orange (`#E65100`) |
| **SOS & Distress Callouts** | Regular chat bubble with emoji prefix | High-visibility emergency callout container with distress red border (`#FF2A4D`), tactical warning banner, emergency badge, and pulse highlight |
| **Chat Top Header** | Plain flat bar with blue text buttons | Mission status header with offline mesh status indicator (`● MESH ACTIVE`), tactical node count pill, radar icon, and precision hairline separator |
| **Message Bubbles (Outgoing)** | Solid bright blue bubble | Tactical dark slate panel (`#152438`) with Beacon Orange/Cyan accent border, high-contrast crisp text, and delivery telemetry |
| **Message Bubbles (Incoming)** | Flat neutral grey bubble | Tactical field container (`#121924`) with subtle structural border (`#1F2C3F`) and clear peer attribution badge |
| **Message Composer** | Standard rounded text field | Tactical command input console with high-contrast border (`#2A3B52`), emergency quick `/sos` broadcast highlight, and glowing beacon send button |
| **Peer & Mesh Sheets** | Standard contact list | Tactical Node Radar list: Direct BLE connections (`1-HOP DIRECT` in tactical green), Multi-hop mesh relays (`RELAYED` in amber), RSSI signal strength bars |
| **Geohash & Location Channels** | Plain list rows | Tactical Grid Zones: Sector channel cards with range radius badges (`150m LOCAL`, `1km SECTOR`, `20km DISTRICT`) and radar beacon styling |
| **Verification & Safety Numbers**| Standard text/QR screen | Cryptographic Identity Shield: Tactical verification badges, high-contrast monospace security fingerprints, verified node seals |
| **Action Buttons & Badges** | iOS-style text links / plain blue buttons | High-visibility emergency response buttons (`BitChatBrandButton`, `OnboardingPrimaryButton`) in Beacon Safety Orange / Tactical Dark |
| **Onboarding & Setup** | Plain minimalist screens | Mission Readiness Checklist: Emergency hardware setup styling for Bluetooth, Location permissions, and background mesh relaying |
| **Empty States & Indicators** | Muted grey text | Tactical standby monitors ("SCANNING OFFLINE BLE MESH FREQUENCIES...", "READY FOR EMERGENCY TRAFFIC") |

---

## 4. Files That Will Be Modified

All modifications are strictly limited to **styling, theme tokens, color palettes, typography styling, and presentation composables**. No business logic, coroutines, state management, or network flows will be changed.

| File Path | What Visual / UI Change Will Be Made |
| :--- | :--- |
| `app/src/main/java/com/bitchat/android/ui/theme/BitchatPalette.kt` | **Redefine color tokens:** Update `DarkBitchatPalette` and `LightBitchatPalette` with tactical disaster theme colors (Beacon Orange primary tint `#FF6D00`, Tactical Cyan `#00E5FF`, Distress Red `#FF2A4D`, Deep Carbon backgrounds, tactical input borders, and emergency bubble tones). |
| `app/src/main/java/com/bitchat/android/ui/theme/Theme.kt` | **Material 3 Color Scheme:** Update `DarkBitchatColorScheme` and `LightBitchatColorScheme` to align with the emergency disaster palette, surface hierarchy, and tactical contrast rules. |
| `app/src/main/java/com/bitchat/android/ui/theme/ChatVisualTokens.kt` | **Visual Tokens Tuning:** Refine border radii, tactical hairline weights, padding rhythms, and badge geometry for emergency field legibility. |
| `app/src/main/java/com/bitchat/android/ui/theme/MessageBubbleStyle.kt` | **Bubble Styling:** Update bubble fills, outlines, and text colors to use the new tactical disaster theme. |
| `app/src/main/java/com/bitchat/android/ui/theme/PeerColors.kt` | **Peer Hue Tuning:** Calibrate deterministic peer color saturation and luminance for optimal readability against tactical carbon surfaces. |
| `app/src/main/java/com/bitchat/android/ui/theme/Typography.kt` | **Typography Scale:** Fine-tune font weights and line heights for maximum field readability under emergency conditions. |
| `app/src/main/java/com/bitchat/android/ui/ChatHeader.kt` | **Header Visual Styling:** Refine visual rendering of header bar, offline mesh connectivity indicator, peer count badge, and tactical channel selector. |
| `app/src/main/java/com/bitchat/android/ui/MessageComponents.kt` | **Message & SOS Presentation:** Enhance message bubble rendering with tactical panel styling, high-visibility emergency alert callouts for `/sos` broadcasts, and clear delivery indicators. |
| `app/src/main/java/com/bitchat/android/ui/InputComponents.kt` | **Composer Presentation:** Restyle message input field with tactical borders, emergency `/sos` command highlight, and beacon send action styling. |
| `app/src/main/java/com/bitchat/android/ui/MeshPeerListSheet.kt` | **Peer List Visual Presentation:** Refine node list visual presentation (RSSI signal meters, direct vs multi-hop badges, verified safety icon styling). |
| `app/src/main/java/com/bitchat/android/ui/LocationChannelsSheet.kt` | **Location Channels Visual Presentation:** Restyle geohash sector cards with emergency radar range badges. |
| `app/src/main/java/com/bitchat/android/ui/AboutSheet.kt` & `AboutSections.kt` | **Diagnostic & Info Sheet Presentation:** Apply tactical panel styling and emergency diagnostic formatting. |
| `app/src/main/java/com/bitchat/android/ui/VerificationSheet.kt` & `SecurityVerificationSheet.kt` | **Cryptographic Verification Presentation:** Apply tactical verification styling, high-contrast safety number boxes, and QR code frame styling. |
| `app/src/main/java/com/bitchat/android/core/ui/component/button/BitChatBrandButton.kt` & `CloseButton.kt` | **Button Styling:** Update button tinting and press feedback to match the emergency beacon design system. |
| `app/src/main/java/com/bitchat/android/core/ui/component/sheet/BitchatBottomSheet.kt` & `BitchatSheetTopBar.kt` | **Sheet Chrome:** Update bottom sheet container styling, headers, and separator hairlines. |
| `app/src/main/java/com/bitchat/android/onboarding/OnboardingScreenLayout.kt` & onboarding UI screens | **Onboarding Presentation:** Apply emergency field readiness styling to permission and status setup screens. |

---

## 5. Files That Will NOT Be Modified

The following functional and architectural files will remain **100% untouched**:

* **BLE Mesh & Networking:**
  * `com.bitchat.android.mesh.*` (`BluetoothMeshService.kt`, `BluetoothLeScanner.kt`, `GattServer.kt`, `MeshService.kt`, `PacketRouter.kt`, etc.)
  * `com.bitchat.android.wifiaware.*` (`WifiAwareMeshService.kt`, `WifiAwareController.kt`, `WifiAwareConnectionTracker.kt`, etc.)
  * `com.bitchat.android.protocol.*` (`BitchatPacket.kt`, packet serialization and framing)
  * `com.bitchat.android.net.*` (`ArtiTorManager.kt`, socket management)
* **Cryptography & Security:**
  * `com.bitchat.android.crypto.*` (Noise protocol, Secp256k1, encryption/decryption, hashing)
  * `com.bitchat.android.identity.SecureIdentityStateManager.kt`
* **Data Models & State Handlers:**
  * `com.bitchat.android.model.*` (`BitchatMessage.kt`, `DeliveryStatus.kt`, `PeerIdentity.kt`, `Channel.kt`, `BitchatFilePacket.kt`)
  * `com.bitchat.android.ui.ChatViewModel.kt`, `MainViewModel.kt`, `GeohashViewModel.kt`, `ApkDownloadViewModel.kt`
  * `com.bitchat.android.ui.DataManager.kt`, `MessageManager.kt`, `ChannelManager.kt`, `PrivateChatManager.kt`, `VerificationHandler.kt`, `MediaSendingManager.kt`, `CommandProcessor.kt`, `CommandRegistry.kt`
* **Database & Services:**
  * `com.bitchat.android.services.*` (`ContactDirectory.kt`, persistence, background services)
  * `com.bitchat.android.favorites.*` (`FavoritesPersistenceService.kt`)
  * `com.bitchat.android.geohash.*` (`LocationChannelManager.kt`, geohash mathematical calculations)
* **Native & System:**
  * Native JNI libraries (`src/main/jniLibs/*`, Tor/Arti native bridges)
  * `AndroidManifest.xml` (all permissions, hardware features, and service declarations)
  * `build.gradle.kts`, `settings.gradle.kts`, `gradle.properties`, dependency locks
  * C/Rust bindings and APK packaging configurations

---

## 6. Functionality Protection Plan

To ensure that **no functional logic is accidentally modified or degraded**:

1. **Strict Compositional Separation:** All changes are restricted to Jetpack Compose color variables, modifier styles, shape definitions, text styles, and visual container decorations.
2. **Preservation of Event Callbacks:** Every button, clickable row, list gesture, swipe handler, and text input listener (`onClick`, `onLongPress`, `onValueChange`, `onAnnotationClick`, `onDismiss`) retains its exact lambda signature, parameters, and invocation logic.
3. **Preservation of ViewModels & State Flows:** All `StateFlow` and `SharedFlow` subscriptions (`collectAsStateWithLifecycle`) remain completely untouched.
4. **Zero Protocol Changes:** Message formatting functions will preserve all underlying message type discriminators (`BitchatMessageType`), delivery status states (`DeliveryStatus.Pending`, `PartiallyDelivered`, `Delivered`, `Read`), and packet headers.
5. **SOS Broadcast Integrity:** `/sos` command parsing, broadcast dispatching to the BLE mesh, and packet transmission remain 100% identical.

---

## 7. Risk Assessment & Mitigation

| Potential Risk | Root Cause | Mitigation Strategy |
| :--- | :--- | :--- |
| **Touch Target Reduction** | Custom tactical button shapes or padding changes | Preserve minimum `44.dp` tap targets (`HeaderTapTarget`) across all interactive components. |
| **Contrast & Outdoor Unreadability** | Low contrast on dark backgrounds | Adhere strictly to WCAG AA/AAA contrast ratios: high-luminance text (`#FFFFFF` / `#E2E8F0`) against `#0B0F14` / `#121924` surfaces. |
| **Recomposition / Performance Jitter** | Unstable color objects or unnecessary state recreation | Use `@Immutable` data structures, Compose `remember` blocks, and draw-layer modifiers (`Modifier.graphicsLayer`) without altering layout composition passes. |
| **Accidental State Desynchronization** | Altering parameters in composable signatures | Keep all existing function signatures and default arguments intact. |

---

## 8. Validation Plan

Following approval and implementation of the UI changes:
1. **Compilation & Build Gate:** Execute Gradle build (`gradlew assembleDebug`) to verify clean compilation with zero Kotlin or Compose compiler warnings.
2. **Visual Inspection:** Verify contrast, padding, and layout rendering across all screens:
   * Main Chat Screen & Header
   * Message Bubbles & SOS Callouts
   * Command Autocomplete Bar
   * Mesh Peer List Sheet
   * Location Grid Channels Sheet
   * Cryptographic Safety Verification Sheet
   * Onboarding & Permissions Screens
3. **Interaction & State Verification:**
   * Verify message input and command dispatching (`/sos`, `/msg`, `/nick`).
   * Verify sheet presentation and dismissal animations.
   * Verify peer status display (direct vs relay).
   * Verify voice note waveform rendering and image/file bubble layouts.
4. **Final Deliverable:** Generate `BEACON_UI_THEME_FINAL_REPORT.md` documenting the executed UI enhancements and build validation results.

---

### STOP & AWAIT APPROVAL
**This report has been prepared for user review. No code modifications have been made. Awaiting your explicit approval to proceed with STEP 3.**
