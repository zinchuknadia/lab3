import Additional.InOutPut;
import Battles.OneOnOneBattle;
import Battles.TeamBattle;
import DroidManager.DroidTeam;
import DroidManager.Droids.*;

private static final DroidTeam droidTeam1=new DroidTeam();
private static final DroidTeam droidTeam2=new DroidTeam();


public static void main(String[] args) {
    InOutPut inOutPut = new InOutPut();
    while (true) {
        switch (inOutPut.getOptionChoice()) {
            case 0:{
                droidTeam1.addPlayer(new Tutor("Marta"));
                droidTeam1.addPlayer(new Smartypants("Dana"));
                droidTeam1.addPlayer(new Normis("Nadiia"));
                droidTeam1.addPlayer(new Normis("Vadim"));
                droidTeam1.addPlayer(new Slouch("Ledentsow"));
                droidTeam1.addPlayer(new Slouch("Yurii"));
                droidTeam1.setName("team 1");

                droidTeam2.addPlayer(new Tutor("Shpak"));
                droidTeam2.addPlayer(new Smartypants("Maikle"));
                droidTeam2.addPlayer(new Smartypants("Ostap"));
                droidTeam2.addPlayer(new Normis("marta"));
                droidTeam2.addPlayer(new Slouch("Orest"));
                droidTeam2.setName("team 2");
                break;
            }
            case 1: {
                createDroid(droidTeam1);
                if(droidTeam1.getSize()>1){
                    droidTeam1.setName(inOutPut.getTeamName());
                }
                break;
            }
            case 2: {
                createDroid(droidTeam2);
                if(droidTeam2.getSize()>1){
                    droidTeam2.setName(inOutPut.getTeamName());
                }
                break;
            }
            case 3: {

                if(droidTeam1.isDead()&&droidTeam2.isDead()){
                    inOutPut.noOneToBattle();
                    break;
                }
                if(droidTeam1.getSize()>1||droidTeam2.getSize()>1) {
                    droidTeam1.setName("team1");
                    droidTeam2.setName("team2");
                    TeamBattle battle = new TeamBattle(droidTeam1, droidTeam2);
                    battle.battle();
                }else {
                    OneOnOneBattle battle = new OneOnOneBattle(droidTeam1, droidTeam2);
                    battle.battle();
                }
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
                break;
            }
            case 4: {
                inOutPut.teamOutput(droidTeam1);
                inOutPut.teamOutput(droidTeam2);
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
                break;
            }
            case 5:{
                inOutPut.ReadFile();
                break;
            }
            case 6: {
                System.exit(0);
            }
            default: {
                System.out.println("Try again");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            }
        }

    }

}

public static void createDroid(DroidTeam droids) {
    InOutPut inOutPut = new InOutPut();
    while (true) {
        switch (inOutPut.getDroidChoice()) {
            case 1: {
                Tutor tutor = new Tutor(inOutPut.getDroidName());
                droids.addPlayer(tutor);
                return;
            }
            case 2: {
                Smartypants smartypants = new Smartypants(inOutPut.getDroidName());
                droids.addPlayer(smartypants);
                return;
            }
            case 3: {
                Normis normis = new Normis(inOutPut.getDroidName());
                droids.addPlayer(normis);
                return;
            }
            case 4: {
                Slouch slouch = new Slouch(inOutPut.getDroidName());
                droids.addPlayer(slouch);
                return;
            }
            default: {
                System.out.println("Try again.\n");
            }
        }
    }
}