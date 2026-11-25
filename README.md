# Music Player (Android)

A simple Android music player written in Kotlin. It plays a short playlist of three songs, shows the cover and title of the current song, and moves to the next song automatically when one ends.

## Features

- Play and pause buttons
- Cover image and a "Now Playing" title that change with each song
- Playlist of three songs that starts the next one when the current one finishes, and loops back to the first
- Uses Android's `MediaPlayer`, and releases it properly when a song changes and when the app closes

## Requirements

- Android Studio (a recent version)
- An emulator or phone running **Android 10 (API 29) or newer**
- Built with compile SDK 35 and target SDK 35

## Run it

1. Clone the repository, then open the `MusicPlayer` folder in Android Studio (File, Open).
2. Wait for the Gradle sync to finish.
3. The songs are not included because of copyright. Put your own three audio files in `app/src/main/res/raw/` and name them `song1.mp3`, `song2.mp3` and `song3.mp3`.
4. Select an emulator or a connected phone and press Run.

## How it works

`MainActivity` keeps the three songs, three covers and three titles in arrays (`songResIds`, `coverResIds` and `titles`). Pressing Play calls `playSong(index)`, which releases the previous player, creates a new `MediaPlayer` for the song, starts it, and updates the image and the title. A completion listener moves the index to the next song, using `(index + 1) % 3` to wrap around, and plays it.

## Project structure

| Path | Purpose |
| --- | --- |
| `app/src/main/java/com/example/musicplayer/MainActivity.kt` | The whole app logic |
| `app/src/main/res/layout/activity_main.xml` | The screen layout |
| `app/src/main/res/raw/` | The audio files |
| `app/src/main/res/drawable/` | The cover images |

## Limitations and ideas

- The playlist is fixed in code.
- Ideas: a seek bar, loading songs from the phone's storage, and a notification with playback controls.

## Tech

Kotlin, Android SDK (minSdk 29, targetSdk 35), `MediaPlayer`, AppCompat, Gradle (Kotlin DSL)
