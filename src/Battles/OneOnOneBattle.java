package Battles;

import DroidManager.DroidTeam;

public class OneOnOneBattle extends TeamBattle {

    public OneOnOneBattle(DroidTeam team1, DroidTeam team2) {
        super(team1,team2);
    }

    public void outputVictory(DroidTeam team){
        inOutPut.victory(team);
        inOutPut.teamOutput(team);
    }
}
