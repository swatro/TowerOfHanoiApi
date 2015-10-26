package com.example.app.java;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize
public class Game {
    private  Tower tower1;
    private  Tower tower2;
    private  Tower tower3;

    public Tower getTower3() {
        return tower3;
    }

    public Tower getTower2() {
        return tower2;
    }

    public Tower getTower1() {
        return tower1;
    }

    public Game(Tower tower1, Tower tower2, Tower tower3) {
        this.tower1 = tower1;
        this.tower2 = tower2;
        this.tower3 = tower3;
    }
}
