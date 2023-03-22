package com.github.zipcodewilmington.casino.games.slots;
import java.util.Random;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame {
    private String[] outcome = {"ZCW", "Bar", "cherry", "7", "coal", "bunny", "$"};
    private int rollCount = 200;
    int a, b, c;
    Random rand;
    public String pullSlots(){
        rand = new Random();
        for (int i = 0; i < rollCount; i++) {
            a = rand.nextInt(outcome.length);
            b = rand.nextInt(outcome.length);
            c = rand.nextInt(outcome.length);
            System.out.print("[" + outcome[a] + ":" + outcome[b] + ":" + outcome[c] + "]");
        }
        return null;
    }
    public void run() {
        String pullSlot = pullSlots();

    }
}
