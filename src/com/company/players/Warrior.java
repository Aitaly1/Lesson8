package com.company.players;

import java.util.Random;

public class Warrior extends Hero {

    public int[] randomNum ={2,3,4};

    public int chanceHero(){
        Random random = new Random();
        return random.nextInt(randomNum.length);
    }

    public Warrior(int health, int damage) {
        super(health, damage,SuperAbility.CRITICAL_DAMAGE );
    }



    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if(this != heroes[i] && heroes[i].getHealth() > 0){
                this.setDamage(getDamage() * chanceHero());
            }
        }
    }


}
