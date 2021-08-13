package com.example.lesson1and3.data;

public class Card <CardContent> {
    private boolean isFaceAp ;
    private boolean isMatch ;
    private int id ;

    private CardContent  content;

    public Card(boolean isFaceAp, boolean isMatch, int id, CardContent content) {
        this.isFaceAp = isFaceAp;
        this.isMatch = isMatch;
        this.id = id;
        this.content = content;
    }

    public boolean isFaceAp() {
        return isFaceAp;
    }

    public void setFaceAp(boolean faceAp) {
        isFaceAp = faceAp;
    }

    public boolean isMatch() {
        return isMatch;
    }

    public void setMatch(boolean match) {
        isMatch = match;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CardContent getContent() {
        return content;
    }

    public void setContent(CardContent content) {
        this.content = content;
    }

}
