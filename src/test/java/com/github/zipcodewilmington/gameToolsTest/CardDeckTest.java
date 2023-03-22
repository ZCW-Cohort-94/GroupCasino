package com.github.zipcodewilmington.gameToolsTest;

import org.junit.Assert;
import org.junit.Test;
import com.github.zipcodewilmington.casino.gameTools.CardDeck;

public class CardDeckTest {
    //test to see if all 52 cards are created
    @Test
    public void createCardDeckTest(){
        //given
        CardDeck cardDeck = new CardDeck();
        //when
        int expectedNumber = 52;
        int actualNumber = cardDeck.createCardDeck().size();
//        //then
        Assert.assertEquals(expectedNumber, actualNumber);
    }

    //test to see if all cards do not repeat
}
