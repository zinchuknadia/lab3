package DroidManager;

import Additional.RandomNumberGenerator;
import DroidManager.Droids.Droid;

import java.util.ArrayList;

public class DroidTeam {
    private String name="";
    private ArrayList<Droid> team= new ArrayList<>();

    public DroidTeam(ArrayList<Droid> team,String teamName){
        this.name =teamName;
        this.team=team;
    }
    public DroidTeam(){
    }

    public void setName(String teamName){
        this.name=teamName;
    }
    public String getName(){
        return name;
    }
    public int getSize(){
        return team.size();
    }

    public void addPlayer(Droid player){
        team.add(player);
    }

    public boolean isDead(){
        for(Droid droid:team){
            if(droid.isAlive()){
                return false;
            }
        }
        return true;
    }

    public Droid getPlayer(){
        return team.get(RandomNumberGenerator.generateRandomNumber(0, team.size() - 1));
    }

    public DroidTeam alivePart(){
        ArrayList<Droid> alive=new ArrayList<>();
        for(Droid droid:team){
            if(droid.isAlive()){
                alive.add(droid);
            }
        }
        return new DroidTeam(alive,name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(name);
        for (Droid droid : team) {
            sb.append("\n").append(droid);
        }
        return sb.toString();
    }
}
