package com.company.players;

public abstract class GameEntity {
    private int Health;
    private int Damage;

    public GameEntity(int health, int damage) {
        this.Health = health;
        this.Damage = damage;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        if (Health < 0){
            this.Health = 0;
        }else {
             this.Health = health;
        }

    }

    public int getDamage() {
        return Damage;
    }

    public void setDamage(int damage) {
        this.Damage = damage;
    }


}
