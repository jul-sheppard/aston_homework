package homework_1;

import homework_1.enemies.impl.Skeleton;
import homework_1.enemies.impl.Spider;
import homework_1.enemies.impl.Zombie;
import homework_1.heroes.*;

public abstract class TrainingGround {
        public static void main(String[] args) {
                Warrior myWarrior = new Warrior("Воин Олег");
                Mage myMage = new Mage("Маг Сережа");
                Archer myArcher = new Archer("Лучник Жуля");
                Spider mySpider = new Spider(50);
                Skeleton mySkeleton = new Skeleton(35);
                Zombie myZombie = new Zombie(80);

                myWarrior.setStrength(20);

                myWarrior.attackEnemy(mySpider);
                System.out.printf("У противника %s осталось %d здоворья \n", mySpider.getName(), mySpider.getHealth());
                myMage.attackEnemy(mySkeleton);
                System.out.printf("У противника %s осталось %d здоворья \n", mySkeleton.getName(), mySkeleton.getHealth());
                myArcher.attackEnemy(myZombie);
                System.out.printf("У противника %s осталось %d здоворья \n", myZombie.getName(), myZombie.getHealth());
        }
}
