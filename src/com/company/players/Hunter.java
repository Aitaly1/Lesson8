package com.company.players;

public class Hunter extends Hero {

    private int revert;

    public Hunter(int health, int damage,int revert) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
        this.revert = revert;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (this != heroes[i] && heroes[i].getHealth() > 0) {
                boss.setHealth(boss.getHealth() - revert);
            }
        }
    }
}
