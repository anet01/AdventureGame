package Locations.BatlleLoc;

import Monsters.Monsters;
import Monsters.Zombi;
import Player.Player;

import java.util.Random;

public class Magara extends BattleZone {
    Random random = new Random();
    Monsters zombi = new Zombi();

    public Magara(Player player) {
        super(player, "Mağara");
        System.out.println("\n\nMağaraya Hoşgeldin!\nZombiler hızlı koşamaz ama sayıları fazladır.");

        System.out.println(createZombie() + " Adet zombi etrafını çevirdi!");

        battle();

    }

    private int createZombie() {

        int count = random.nextInt(3) + 1;
        zombi.setMonsterCount(count);
        return count;
    }

    @Override
    public void battle() {
        int randomNumber = random.nextInt(2) + 1;
        zombi.setHealth(zombi.getHealth() * zombi.getMonsterCount());

        //randomNumber 1 ise Oyuncu başlıyor diğer durumda yaratık
        if(randomNumber == 1){
            while (getPlayer().getHealth() >= 0) {

                System.out.println(getPlayer().getName() + " Saldırıyor...");
                zombi.setHealth(zombi.getHealth() - (getPlayer().getDamage() + getPlayer().getInventory().getWeaponDamage()));
                if (zombi.getHealth() <= 0) {
                    System.out.println("Zombi öldü! Kazandınız!");
                    getPlayer().setMoney(getPlayer().getMoney() + zombi.getValue());
                    getPlayer().setFireWood();
                    break;
                }

                System.out.println("Zombi Saldırıyor...");
                getPlayer().setHealth(getPlayer().getHealth() - zombi.getDamage());
                if (getPlayer().getHealth() <= 0) {
                    System.out.println("Öldünüz!");
                    break;

                }
                System.out.println("Zombilerin Kalan Canı: " + zombi.getHealth() + "\n" +
                        getPlayer().getName() + " Kalan canı: " + getPlayer().getHealth());


            }
        }
        else {
            while (getPlayer().getHealth() >= 0) {



                System.out.println("Zombi Saldırıyor...");
                getPlayer().setHealth(getPlayer().getHealth() - zombi.getDamage());
                if (getPlayer().getHealth() <= 0) {
                    System.out.println("Öldünüz!");
                    break;

                }

                System.out.println(getPlayer().getName() + " Saldırıyor...");
                zombi.setHealth(zombi.getHealth() - (getPlayer().getDamage() + getPlayer().getInventory().getWeaponDamage()));
                if (zombi.getHealth() <= 0) {
                    System.out.println("Zombi öldü! Kazandınız!");
                    getPlayer().setMoney(getPlayer().getMoney() + zombi.getValue());
                    getPlayer().setFireWood();
                    break;
                }


                System.out.println("Zombilerin Kalan Canı: " + zombi.getHealth() + "\n" +
                        getPlayer().getName() + " Kalan canı: " + getPlayer().getHealth());


            }
        }

        System.out.println("\n\n" +
                "Güncel durumunuz;\n" +
                "Can: " + getPlayer().getHealth()+ "\n" +
                "Para: " + getPlayer().getMoney()+
                "\n\n");
    }
}
