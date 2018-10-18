package com.starhood.game.sprites;

/**
 * Created by starhood on 16/10/18.
 */

public class Score {
    private static int score =0;

    public static String getScore() {
        return Integer.toString(score);
    }

    public static void addScore() {
        score ++;
    }

    public static void clearScore()
    {
        score=0;
    }

    public static void printScore(){
        System.out.println(score);
    }
}
