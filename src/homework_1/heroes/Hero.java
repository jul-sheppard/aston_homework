package homework_1.heroes;

import homework_1.Mortal;
import homework_1.enemies.Enemy;

public abstract class Hero implements Mortal {
    private final String name;
    private int strength;
    private int health;

    public Hero(String name, int strength, int health) {
        this.name = name;
        this.strength = strength;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        if (health < 0){
            return 0;
        }
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void takeDamage(int damage) {
        health = health - damage;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    public void attackEnemy(Enemy enemy){
        System.out.printf("    %s наносит %d урона противнику %s \n", this.getName(), this.getStrength(), enemy.getName());
        enemy.takeDamage(this.getStrength());
    }
}
