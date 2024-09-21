package Java;

import Java.enemies.Enemy;
import Java.enemies.impl.Skeleton;
import Java.enemies.impl.Spider;
import Java.enemies.impl.Zombie;
import Java.heroes.Hero;
import Java.heroes.Warrior;

import java.util.ArrayList;

public class BattleGround {
    public static void main(String[] args) {
        Warrior myWarroir1 = new Warrior("Воин Филипп");
        Spider mySpider1 = new Spider(100);
        Zombie myZombie1 = new Zombie(120);
        Skeleton mySkeleton1 = new Skeleton(90);

        ArrayList<Enemy> enemiesList = new ArrayList<>();
        enemiesList.add(mySpider1);
        enemiesList.add(myZombie1);
        enemiesList.add(mySkeleton1);

        myWarroir1.setStrength(30);

        for (Enemy enemy : enemiesList) {
            if (Battle(myWarroir1, enemy) == false) {
                System.out.println("  ...Герой мёртв...");
                break;
            }
            System.out.println("  !!! Герой победил !!!  ");
        }
    }

    public static boolean Battle(Hero hero, Enemy enemy) {
        System.out.println("  Битва началась  ");
        System.out.printf("%s имеет %d здоровья и %d урона \n", hero.getName(), hero.getHealth(), hero.getStrength());
        System.out.printf("Противник %s имеет %d здоровья и %d урона \n", enemy.getName(), enemy.getHealth(), enemy.getStrength());
        while (hero.isAlive() && enemy.isAlive()) {
            hero.attackEnemy(enemy);
            System.out.printf("HP %s: %d \n", enemy.getName(), enemy.getHealth());
            enemy.attackHero(hero);
            System.out.printf("HP %s: %d \n", hero.getName(), hero.getHealth());
        }
        System.out.println(".....Битва закончилась.....");
        return hero.isAlive();
    }
}
