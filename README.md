# Mancala Game

## Overview

This package implements a GUI‑based Mancala game in Java, using a custom circular linked list to model the board.  
Players take turns distributing stones, capturing opposite pits, and trying to collect more stones in their store (Mancala) than their opponent.

## Project Structure

- **`Mancala.Main`**  
  Entry point: sets up the Swing `JFrame` and launches the game UI.
- **`Mancala.Game`**  
  Core game logic, turn management, victory checking, and event handling.
- **`Mancala.Node`**  
  Represents a single pit or store on the board; holds an integer count and a `next` pointer.
- **`Mancala.LinkedList`**  
  Simple singly‑linked list implementation (not used in the main game but included as exercise).

## Requirements

- Java 8 or higher
- Swing (bundled with standard JDK)
- No external dependencies

## Build & Run

1. Open a terminal in the project root:

   ```shell
   cd "File directory"
   ```

2. Compile Mancala sources:

   ```shell
   javac -d out src\Mancala\*.java
   ```

3. Launch the game:

   ```shell
   java -cp out Mancala.Main
   ```

## How to Play

1. The board consists of 14 spots (12 pits + 2 stores).
2. Player 1’s pits are on the top row; Player 2’s on the bottom.
3. Click any non‑empty pit on your side to sow its stones clockwise.
4. If your last stone lands in your store, you get another turn.
5. If your last stone lands in an empty pit on your side, you capture that stone and all stones in the opposite pit.
6. The game ends when one side’s pits are all empty. The player with the most stones in their store wins.

## License
