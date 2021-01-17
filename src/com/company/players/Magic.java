package com.company.players;

public class Magic extends Hero{

    public int boost;

    public Magic(int health, int damage,int boost){
        super(health, damage,SuperAbility.BOOST);
        this.boost = boost;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if(this != heroes[i] && heroes[i].getHealth() > 0){
                heroes[i].setDamage(heroes[i].getDamage() + boost);
            }

        }
    }
}
