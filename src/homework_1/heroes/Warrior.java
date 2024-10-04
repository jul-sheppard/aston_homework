package homework_1.heroes;

public class Warrior extends Hero {

    private int armor;

    public Warrior(String name) {
        super(name, 10, 130);
        this.armor = 40;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    /**
     * Метод блокирования урона
     * <p>
     * Если броня больше урона, то есть шанс блокирования
     * <p>
     * В противном случае урон наносится без блокирования
     *
     * @param damage
     */
    @Override
    public void takeDamage(int damage) {
        double chance = Math.random();
        if (chance < 0.5) {
            if (armor > damage) {
                damage = 1;
            } else {
                damage = damage - armor;
            }
        }
        setHealth(getHealth() - damage);
    }
}
