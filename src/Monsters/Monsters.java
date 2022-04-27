package Monsters;

public abstract class Monsters {

    private int monsterCount;
    private int health;
    private int damage;
    private int value;
    private String monsterName;

    public Monsters(String monsterName, int monsterCount, int health, int damage, int value) {
        this.monsterCount = monsterCount;
        this.health = health;
        this.damage = damage;
        this.value = value;
        this.monsterName = monsterName;
    }


    public int getMonsterCount() {
        return monsterCount;
    }

    public void setMonsterCount(int monsterCount) {
        this.monsterCount = monsterCount;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }
}
