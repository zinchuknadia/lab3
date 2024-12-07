package DroidManager.Droids;

import Additional.RandomNumberGenerator;

public class Droid {
    private String type;
    private String name;
    private int primaryHealth;
    private int damage;
    private int attackStrength;
    private double sensitivity;
    private boolean canHealItself=false;

    public Droid(String type, String name, int health, int damageLimit, double sensitivity) {
        this.type=type;
        this.name=name;
        this.primaryHealth=health;
        this.attackStrength =damageLimit;
        this.sensitivity=sensitivity;
        this.damage=0;
    }

    public void setHealth(int health) {
        this.damage = primaryHealth-health;
    }
    public void setDamage(int damage){
        this.damage+=damage*sensitivity;
    }
    public int getAttack(){
        return RandomNumberGenerator.generateRandomNumber(attackStrength/2,attackStrength);
        //return (int)(Math.random()*(attackStrength -(attackStrength/2)+1))+(attackStrength/2);
    }
    public String getType(){
        return type;
    }
    public String getName(){
        return name;
    }
    public int getHealth(){
        return primaryHealth-damage;
    }
    public boolean canHealItself(){
        return this.canHealItself;
    }

    public boolean healItself(){
        if(canHealItself()){
            this.damage-=((int)(Math.random()*(10-1+1))+1);
            return true;
        }else{
            return false;
        }
    }

    public boolean isVaccinated(){
        return damage<0;
    }

    public boolean isAlive(){
        return getHealth() > 0;
    }

    @Override
    public String toString() {
        return   type + " " + name +
                ", health=" + getHealth() +
                ", attack=" + attackStrength;
    }
}
