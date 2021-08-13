package com.example.lesson1and3.ui;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.lesson1and3.data.Card;
import com.example.lesson1and3.data.Game;

import java.util.ArrayList;
import java.util.List;

public class EmojiiGame {


    private final Game<String> game;

    @RequiresApi(api = Build.VERSION_CODES.R)
    public  EmojiiGame(){
        List<String> contens = List.of("❤","🎃","👹","😎","👽");

        game = new Game<>(contens);
    }
    public void choose(Card<String>card){
        game.checkMatches(card);
    }
  public  List<Card<String>> getCards(){
        return game.getCards();
  }
}
