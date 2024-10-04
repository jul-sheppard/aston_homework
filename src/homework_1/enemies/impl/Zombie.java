package homework_1.enemies.impl;

import homework_1.enemies.Enemy;

public class Zombie extends Enemy {
    public Zombie(int health) {
        super(health, "Зомби", 30);
    }

    @Override
    public void takeDamage(int damage) {
        if (getHealth() - damage <= 0) {
            double chance = Math.random();
            if (chance < 0.5) {
                setHealth(85);
                System.out.printf("<<<Зомби воскрес c %d HP>>> \n", getHealth() );
            } else {
                setHealth(0);
            }
        } else {
            setHealth(getHealth() - damage);
        }
    }
}
