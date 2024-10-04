package homework_1.enemies;

import homework_1.Mortal;
import homework_1.heroes.Hero;

public abstract class Enemy implements Mortal {
    private int health;
    private final String name;
    private int strength;

    public String getName(){
        return name;
    }

    public Enemy(int health, String name, int strength) {
        this.health = health;
        this.name = name;
        this.strength = strength;
    }

    public int getHealth() {
       if (health < 0){
           return 0;
       }
       return health;
    }

    public int getStrength() {
        return strength;
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

    public void attackHero(Hero hero) {
        System.out.printf("    %s наносит %d урона %s \n", this.getName(), this.getStrength() ,hero.getName());
        hero.takeDamage(this.getStrength());
    }
}

