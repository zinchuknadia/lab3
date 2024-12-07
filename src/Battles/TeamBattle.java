package Battles;

import Additional.InOutPut;
import Additional.RandomNumberGenerator;
import DroidManager.DroidTeam;
import DroidManager.Droids.Droid;

public class TeamBattle {

//    RandomNumberGenerator randomNumber=new RandomNumberGenerator();
    protected InOutPut inOutPut=new InOutPut();
    private DroidTeam team1;
    private DroidTeam team2;

    public TeamBattle (DroidTeam team1, DroidTeam team2){
        this.team1=team1;
        this.team2=team2;
    }

    public void battle() {
        while(true) {
            if(team1.isDead()){
                outputVictory(team2);
                return;
            }
            if(team2.isDead()){
                outputVictory(team1);
                return;
            }
            fight();
        }
    }
    public void outputVictory(DroidTeam team){
        inOutPut.victory(team);
        inOutPut.teamOutput(team.alivePart());
    }

    public void fight(){
        Droid player1=team1.alivePart().getPlayer();
        Droid player2=team2.alivePart().getPlayer();
        if (RandomNumberGenerator.generateRandomNumber(1,2)==1) {
            makeMove(player1,player2,team2);
        }else {
            makeMove(player2,player1,team1);
        }
    }

    public void makeMove(Droid player1, Droid player2, DroidTeam team2) {
        if (RandomNumberGenerator.generateRandomNumber(1, 3) == 1) {
            if (player1.healItself()) {
                inOutPut.playerHealed(player1);
                return;
            }
        }
        attack(player1,player2,team2);
    }

    public void attack(Droid player1, Droid player2, DroidTeam team2) {
        player2.setDamage(modifyAttack(player1,player2));
        inOutPut.droidAttack(player1, player2);
        if (!player2.isAlive()) {
            inOutPut.playerDied(player2);
            if(!team2.isDead()) {
                inOutPut.teamOutput(team2.alivePart());
            }
        }
    }

    public int modifyAttack(Droid player1,Droid player2){
        if(player1.getType().equals("Slouch")){
            if (RandomNumberGenerator.generateRandomNumber(1,3) == 1) {
                return player1.getAttack();
            }else{
                return 0;
            }
        }
        if(player1.getType().equals("Tutor")){
            if(player2.getType().equals("Slouch")){
                return player1.getAttack()*3;
            }
        }
        return player1.getAttack();
    }

}