package com.github.zipcodewilmington.casino;

public abstract class Game {

    public abstract void run() throws InterruptedException;
    public abstract Player add(Player player);
//# removePlayer(player): Player
//# run(): void
//# checkTurn() : player
//# checkWin() : Integer
}
