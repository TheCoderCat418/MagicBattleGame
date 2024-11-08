package com.thecodercat418.MBG;

public class TurnManager {
    private static Turn whosTurn = Turn.PLAYER;
    public static RunningPlacement runningPlacement = RunningPlacement.BEFORE_TURN;
    
    public static void playerFinishTurn(){};

    public static void enemyFinishTurn(){};

    

    public static String getCurrentTurn(){
        if(whosTurn == Turn.PLAYER){
            return "P";
        }else if(whosTurn == Turn.ENEMY){
            return "E";
        }
        return null;
    }
}
enum Turn{
    PLAYER,
    ENEMY
}
