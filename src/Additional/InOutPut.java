package Additional;

import DroidManager.DroidTeam;
import DroidManager.Droids.Droid;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;


public class InOutPut {
    private static final String RED="\u001B[0;31m";
    private static final String WHITE="\u001B[0;37m";
    private static final String GREEN="\u001B[0;92m";
    private static final String RESET="\u001B[0m";
    private static final String YELLOW="\u001B[0;33m";
    private static final String PURPLE="\u001B[0;35m";

    String filePath = "D:\\юнівер\\java\\lab3_pp\\output.txt"; // Шлях до файлу

    public int getOptionChoice(){
        System.out.println(YELLOW+"------------MENU-----------"+RESET);
        System.out.println("Choose:\n0.Initialize teams\n1.Create droid for 1 team\n2.Create droid for 2 team\n3.Battle droids\n4.Output droids\n5.Output file\n6.Exit");
        System.out.println(YELLOW+"---------------------------"+RESET);
        return InputCheck();
    }
    public int getDroidChoice(){
        System.out.println("Choose droid:\n1.Tutor\n2.Smartypants\n3.Normis\n4.Slouch");
        return InputCheck();
    }
    public String getTeamName(){
        System.out.println("Enter teams name:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public String getDroidName() {
        System.out.println("Enter name:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void victory(DroidTeam team){
        String text="\n"+"WINNER";
        writeAndPrint(text, filePath);
    }

    public void playerDied(Droid player){
        String text=player.getType()+" "+player.getName()+RED+" died"+RESET;
        writeAndPrint(text, filePath);
    }

    public void playerHealed(Droid player){
        String text=WHITE+"=========================================="+RESET;
        writeAndPrint(text, filePath);
        if(player.isVaccinated()){
            text= "Droid "+player.getName()+GREEN+" vaccinated"+RESET+" itself\n"+player.getType()+" "+player.getName()+" health="+player.getHealth();
            writeAndPrint(text, filePath);
            return;
        }
        text= "Droid "+player.getName()+GREEN+" healed"+RESET+" itself\n"+player.getType()+" "+player.getName()+" health="+player.getHealth();
        writeAndPrint(text, filePath);
    }

    public void droidAttack(Droid player1, Droid player2){
        String text=WHITE+"=========================================="+RESET;
        writeAndPrint(text, filePath);
        text=player1.getType()+" "+player1.getName()+PURPLE+" attacked "+RESET+player2.getType()+" "+player2.getName();
        writeAndPrint(text, filePath);
        if(!player2.isAlive()){
            player2.setHealth(0);
        }
        text=player2.getType()+" "+player2.getName()+" health="+player2.getHealth();
        writeAndPrint(text, filePath);
    }

    public void noOneToBattle(){
        System.out.println("Battle can't start until there are participants.\n");
    }

    public void teamOutput(DroidTeam team){
        String text;
        if(team.isDead()){
            text=team.getName()+" is dead";
            writeAndPrint(text, filePath);
        }else {
            text=team.alivePart().toString();
            writeAndPrint(text, filePath);
        }
    }

    public static void writeAndPrint(String text, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            System.out.println(text);
            writer.write(text);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void ReadFile() {
        System.out.println("File data:");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int InputCheck() {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                number = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Not the required type. Try again.");
                scanner.next();
            }
        }
        return number;
    }
}
