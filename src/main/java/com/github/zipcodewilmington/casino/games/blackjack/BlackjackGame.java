package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.BettingGame;
import com.github.zipcodewilmington.casino.Game;
import com.github.zipcodewilmington.casino.Player;

import java.util.ArrayList;

public class BlackjackGame implements Game, BettingGame {
    @Override
    public void add(Player player) {

    }

    @Override
    public void remove(Player player) {

    }

    @Override
    public ArrayList<Player> getPlayers() {
        return null;
    }

    @Override
    public void run() {

    }

    @Override
    public boolean bet(Player player, int amount, int minimum) {
        return false;
    }
}