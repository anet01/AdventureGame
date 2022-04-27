package Characters;

import Player.Player;

public abstract class Characters {

    private int health;
    private int damage;
    private int money;
    private String charName;

    public Characters(int health, int damage, int money, String charName) {
        this.health = health;
        this.damage = damage;
        this.money = money;
        this.charName = charName;

    }

    public Characters() {

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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

}
