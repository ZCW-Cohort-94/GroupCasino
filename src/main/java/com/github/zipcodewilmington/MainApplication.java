package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;

public class MainApplication {
    public static void main(String[] args) {
        CasinoAccountManager main = new CasinoAccountManager();

        main.mainMenu();

    }
}