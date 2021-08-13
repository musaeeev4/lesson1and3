package com.example.lesson1and3.data;

import android.provider.CalendarContract;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game<CardContent> {
    private final List<Card<CardContent>> cards = new ArrayList<>();

    public Game(List<CardContent> contents) {
        for (int i = 0; i < contents.size(); i++) {
            cards.add(new Card<>(false, false, i + 1, contents.get(i)));
            cards.add(new Card<>(false, false, (i + 1) * 2, contents.get(i)));

        }
        Collections.shuffle(cards);
    }

//
//    public void choose(Card<CardContent> card) {
//        card.setFaceAp((!card.isFaceAp()));
//        checkMatches(card);
//    }

    public void checkMatches(Card<CardContent> card) {
        card.setFaceAp(!card.isFaceAp());
        for (Card<CardContent> anotherCard : cards) {
            if (anotherCard.isFaceAp()
                    && anotherCard.getId() != card.getId()
                    && anotherCard.getContent().equals(card.getContent())) {
                card.setMatch(true);
                anotherCard.setMatch(true);
            }
            if (anotherCard.isFaceAp()
                    && anotherCard.getId() != card.getId()
                    && !anotherCard.getContent().equals(card.getContent())) {
                anotherCard.setFaceAp(false);
            }
        }

    }

    public void cardClick(Card<CardContent> card) {
        card.setFaceAp(!card.isFaceAp());
        for (Card<CardContent> currentCard : cards) {
            if (currentCard.getId() != card.getId() && currentCard.isFaceAp()
                    && card.getContent().equals(currentCard.getContent())) {
                card.setMatch(true);
                currentCard.setMatch(true);
            }
            if (currentCard.getId() != card.getId() && currentCard.isFaceAp() && !card.getContent().equals(currentCard.getContent())) {
                currentCard.setFaceAp(false);
            }
        }
    }

    public List<Card<CardContent>> getCards() {
        return cards;
    }
}



