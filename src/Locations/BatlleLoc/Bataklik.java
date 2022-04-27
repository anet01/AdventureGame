package Locations.BatlleLoc;

import Monsters.*;
import Player.Player;

import java.util.Random;

public class Bataklik extends BattleZone{
    Random random = new Random();
    Monsters ayi = new Ayi();
    public Bataklik(Player player) {
        super(player, "\n\nBataklığa hoşgeldin!");
        System.out.println(createBear() + " Adet ayi etrafını çevirdi!");
        battle();
    }


    private int createBear() {

        int count = random.nextInt(3) + 1;
        ayi.setMonsterCount(count);
        return count;
    }

    @Override
    public void battle() {
        int randomNumber = random.nextInt(2) + 1;
        ayi.setHealth(ayi.getHealth() * ayi.getMonsterCount());

        //randomNumber 1 ise Oyuncu başlıyor diğer durumda yaratık
        if(randomNumber == 1){
            while (getPlayer().getHealth() >= 0) {

                System.out.println(getPlayer().getName() + " Saldırıyor...");
                ayi.setHealth(ayi.getHealth() - (getPlayer().getDamage() + getPlayer().getInventory().getWeaponDamage()));
                if (ayi.getHealth() <= 0) {
                    System.out.println("Ayı öldü! Kazandınız!");
                    getPlayer().setMoney(getPlayer().getMoney() + ayi.getValue());
                    getPlayer().setFireWood();
                    break;
                }

                System.out.println("Ayı Saldırıyor...");
                getPlayer().setHealth(getPlayer().getHealth() - ayi.getDamage());
                if (getPlayer().getHealth() <= 0) {
                    System.out.println("Öldünüz!");
                    break;

                }
                System.out.println("Ayıların Kalan Canı: " + ayi.getHealth() + "\n" +
                        getPlayer().getName() + " Kalan canı: " + getPlayer().getHealth());


            }
        }
        else {
            while (getPlayer().getHealth() >= 0) {



                System.out.println("Ayı Saldırıyor...");
                getPlayer().setHealth(getPlayer().getHealth() - ayi.getDamage());
                if (getPlayer().getHealth() <= 0) {
                    System.out.println("Öldünüz!");
                    break;

                }

                System.out.println(getPlayer().getName() + " Saldırıyor...");
                ayi.setHealth(ayi.getHealth() - (getPlayer().getDamage() + getPlayer().getInventory().getWeaponDamage()));
                if (ayi.getHealth() <= 0) {
                    System.out.println("Ayı öldü! Kazandınız!");
                    getPlayer().setMoney(getPlayer().getMoney() + ayi.getValue());
                    getPlayer().setFireWood();
                    break;
                }


                System.out.println("Ayıların Kalan Canı: " + ayi.getHealth() + "\n" +
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
