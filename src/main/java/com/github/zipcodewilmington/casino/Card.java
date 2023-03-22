package com.github.zipcodewilmington.casino;
import com.github.zipcodewilmington.casino.Number;
import com.github.zipcodewilmington.casino.Suits;
public class Card {

    private Suits suit;
    private Number rank;


    public Card(Suits suit, Number rank){
        this.rank = rank;
        this.suit = suit;
    }

    public int getValue(){
        return rank.rankValue;
    }

    public Suits getSuit(){
        return suit;
    }

    public Number getRank(){
        return rank;
    }
}
