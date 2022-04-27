package Monsters;

import java.util.Random;

public class Yilan extends Monsters {


    public Yilan() {
        super("Yılan", getYilanCount(), 12, getYilanDamage(), 0);
    }

    private static int getYilanDamage() {
        Random random = new Random();
        int count = random.nextInt(6) + 3;
        return count;
    }

    private static int getYilanCount() {
        Random random = new Random();
        int count = random.nextInt(5) + 1;
        return count;
    }
}
