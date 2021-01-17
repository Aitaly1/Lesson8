package com.company.game;

import com.company.players.*;

public class RPG_Game {
    public static void start(){
        Boss boss = new Boss(1000,50);
        Warrior warrior = new Warrior(220,25);
        Hunter hunter = new Hunter(250,30,15);
        Magic magic = new Magic(210,20,5);
        Medic medic = new Medic(200,15,15);
        Hero[] heroes = {warrior,hunter,magic,medic};

        printStatistics(boss,heroes);
        while (!isGameFinished(boss, heroes)){
            round(boss,heroes);
        }

    }

    private static void printStatistics(Boss boss,Hero[] heroes){
        System.out.println("-------");
        System.out.println("Boss health: " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() + " Health: " + heroes[i].getHealth() );
        }
        System.out.println("--------");
    }

    private static void round(Boss boss,Hero[] heroes){
        if (boss.getHealth() > 0){
            bossHits(boss,heroes);
        }
        heroesHits(boss,heroes);
        applySuper(boss,heroes);
        printStatistics(boss,heroes);
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes){
        if (boss.getHealth() <= 0){
            System.out.println("Heroes WoN");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0){
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead){
            System.out.println("Boss WON!!!");
        }
        return allHeroesDead;
    }

    private static void bossHits(Boss boss, Hero[] heroes){
        for (int i = 0; i < heroes.length; i++) {

            if (heroes[i].getHealth() > 0){
                if (heroes[i].getHealth() - boss.getDamage() < 0 ) heroes[i].setHealth(0);
               else heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage()) ;
            }
        }
    }

    private static void heroesHits(Boss boss, Hero[] heroes){
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0 && heroes[i].getHealth() > 0){
                if (boss.getHealth() - heroes[i].getDamage() < 0) boss.setHealth(0);
                else boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    private static void applySuper(Boss boss, Hero[] heroes){
        for (int i = 0; i < heroes.length; i++) {
          if (heroes[i].getHealth() > 0){
              heroes[i].applySuperAbility(boss,heroes);
          }
        }
    }
}
