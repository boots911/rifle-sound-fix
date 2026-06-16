# Rifle Sound Fix

A small **client-side** Minecraft **1.8.9** (Forge 11.15.1.2318) mod.

On Hypixel, the large firework explosion sound is sent as `minecraft:fireworks.largeblast`,
but Minecraft 1.8.9 registers that sound as `fireworks.largeBlast`. The lookup is
case-sensitive, so the vanilla client can't find it and the sound never plays. This mod
catches that one sound and plays the correct vanilla `fireworks.largeBlast` instead, so you
can hear firework explosions again. Nothing else is affected.

## Install

1. Install Minecraft Forge **11.15.1.2318** for 1.8.9.
2. Download `rifle-sound-fix-1.0.0.jar` from the [Releases](../../releases) page.
3. Put the jar in your `.minecraft/mods` folder.

Client-side only — it is never required on a server.
