# Entropy: Chaos Mod
Entropy is a Chaos Mod where random events happen every 30 seconds. The events are selected randomly from a pool of 111 (and growing) events that can be anything from meteor rain, physics changes and much more.

Event and timer duration can be configured from the Settings menu!

Entropy was heavily inspired on the excellent work of pongo1231's [Chaos Mod V](https://github.com/gta-chaos-mod/ChaosModV) for Grand Theft Auto V!

## Multiplayer:
Play Entropy with friends! Each random event happens around each player. Each connected client can configure Twitch Integrations independently and will send poll results to the server.
To change Entropy Settings on multiplayer, please change the parameters inside the config/entropy.json file in the server folder.

## Twitch Integration:
Entropy includes integration with Twitch! Viewers of a streamer can vote the next event using the stream chat! (Integration for more platforms like Youtube streaming and Discord is planned).

To enable Twitch Integration you'll need a Twitch OAuth Access token, you can generate using [this tool](https://twitchtokengenerator.com/) (or any other OAuth token generator tool).
Write your OAuth Access Token and your channel name in Entropy Settings.
## YouTube Integration:
In a similar fashion to the twitch integration, Entropy also includes the ability for YouTube streamers to connect with their YouTube Live Chat for event voting.

It requires the creation of a Google Cloud Platform project and some configuration. [Click here](https://youtu.be/i2cn_IXLoFE) for a video tutorial, there's also a written guide in that video's description
## Discord Integration:
Users of a discord server can vote the next event by using the Entropy Discord integration. TUTORIAL: https://www.youtube.com/watch?v=waj82ownAKw
## Gameplay:
Click Image to watch the videos.

[![Entropy: Chaos Mod - slicedlime vs chat](https://img.youtube.com/vi/qGuIEfpSfto/0.jpg)](https://www.youtube.com/watch?v=qGuIEfpSfto "Entropy: Chaos Mod - slicedlime vs chat")
[![Can You Beat Minecraft With A Random Effect Every 30 Seconds? - Minecraft Chaos Mod (Entropy)](https://img.youtube.com/vi/zi2_laF_qxU/0.jpg)](https://www.youtube.com/watch?v=zi2_laF_qxU "Can You Beat Minecraft With A Random Effect Every 30 Seconds? - Minecraft Chaos Mod (Entropy)")

## ScreenShots:

![Demo 1 - Twitch Chat Integration](https://github.com/juancarloscp52/Entropy/blob/master/readme%20images/img4.png)
![Demo 2 - Blur](https://github.com/juancarloscp52/Entropy/blob/master/readme%20images/img1.png)
![Demo 3 - Upside Down](https://github.com/juancarloscp52/Entropy/blob/master/readme%20images/img2.png)
![Demo 4 - Meteor Rain](https://github.com/juancarloscp52/Entropy/blob/master/readme%20images/img3.png)
![Demo 5 - Settings](https://github.com/juancarloscp52/Entropy/blob/master/readme%20images/img5.png)

## Installation:
This mod requires [Fabric](https://fabricmc.net/use/) and [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api). You can download Entropy from the _[releases](https://github.com/juancarloscp52/Entropy/releases)_ tab in github or through the CurseForge page.
Drop Entropy and Fabric API JARs inside the mods folder.

## Building from source:
Linux / Mac OS
```shell script
git clone https://github.com/juancarloscp52/Entropy/
cd Entropy
./gradlew build
```
Windows
```shell script
git clone https://github.com/juancarloscp52/Entropy/
cd Entropy
gradlew build
```
You can find the built JARs inside Entropy/build/libs

## Copyright

Copyright (C) 2022 juancarloscp52 and the Entropy contributors

Entropy is released under [GPL-3.0-or-later],
a free software and Open Source license.

[GPL-3.0-or-later]: COPYING "SPDX-License-Identifier: GPL-3.0-or-later"
