package Locations.BatlleLoc;

import Monsters.*;
import Player.Player;

import java.util.Random;

public class Maden extends BattleZone {
    Monsters yilan = new Yilan();
    Random random = new Random();

    public Maden(Player player) {
        super(player, "Maden");

        System.out.println("\n\nMadene Hoşgeldin!\nYılanlar sinsidir dikkali olmalısın!");

        System.out.println(yilan.getMonsterCount() + " Adet yilan etrafını çevirdi!");

        battle();
    }

    @Override
    public void battle() {
        int randomNumber = random.nextInt(2) + 1;
        yilan.setHealth(yilan.getHealth() * yilan.getMonsterCount());

        //randomNumber 1 ise Oyuncu başlıyor diğer durumda yaratık
        if (randomNumber == 1) {
            while (getPlayer().getHealth() >= 0) {

                System.out.println(getPlayer().getName() + " Saldırıyor...");
                yilan.setHealth(yilan.getHealth() - (getPlayer().getDamage() + getPlayer().getInventory().getWeaponDamage()));
                if (yilan.getHealth() <= 0) {
                    System.out.println("Yılan öldü! Kazandınız!");
                    getPlayer().setMoney(getPlayer().getMoney() + yilan.getValue());
                    getPlayer().setFireWood();
                    break;
                }

                System.out.println("Yılan Saldırıyor...");
                getPlayer().setHealth(getPlayer().getHealth() - yilan.getDamage());
                if (getPlayer().getHealth() <= 0) {
                    System.out.println("Öldünüz!");
                    break;

                }
                System.out.println("Yılanların Kalan Canı: " + yilan.getHealth() + "\n" +
                        getPlayer().getName() + " Kalan canı: " + getPlayer().getHealth());


            }
        } else {
            while (getPlayer().getHealth() >= 0) {


                System.out.println("Yılan Saldırıyor...");
                getPlayer().setHealth(getPlayer().getHealth() - yilan.getDamage());
                if (getPlayer().getHealth() <= 0) {
                    System.out.println("Öldünüz!");
                    break;

                }

                System.out.println(getPlayer().getName() + " Saldırıyor...");
                yilan.setHealth(yilan.getHealth() - (getPlayer().getDamage() + getPlayer().getInventory().getWeaponDamage()));
                if (yilan.getHealth() <= 0) {
                    System.out.println("Yılan öldü! Kazandınız!");
                    getPlayer().setMoney(getPlayer().getMoney() + yilan.getValue());
                    getPlayer().setFireWood();
                    getPrize();
                    break;
                }


                System.out.println("Yılanların Kalan Canı: " + yilan.getHealth() + "\n" +
                        getPlayer().getName() + " Kalan canı: " + getPlayer().getHealth());


            }
        }

        System.out.println("\n\n" +
                "Güncel durumunuz;\n" +
                "Can: " + getPlayer().getHealth() + "\n" +
                "Para: " + getPlayer().getMoney() +
                "\n\n");
    }


    private void getPrize() {
        int category = random.nextInt(100) + 1;
        int prize = random.nextInt(100) + 1;

        if (category <= 15) {
            //Silah

            if(prize <= 20){
                getPlayer().setDamage(7 + getPlayer().getDamage());
                getPlayer().setInventoryWeponDamgeAndName(7,"Tüfek");
                System.out.println("Tüfek Kazandınız");
            }else if(prize >= 21 && prize <= 30){
                getPlayer().setDamage(3 + getPlayer().getDamage());
                getPlayer().setInventoryWeponDamgeAndName(3,"Kılıç");
                System.out.println("Kılıç Kazandınız");
            }else {
                getPlayer().setDamage(2 + getPlayer().getDamage());
                getPlayer().setInventoryWeponDamgeAndName(2,"Tabanca");
                System.out.println("Tabanca Kazandınız");
            }

        } else if (category >= 16 && category <= 30) {
            //Zırh

            if(prize <= 20){
                getPlayer().setHealth(7 + getPlayer().getHealth());
                getPlayer().setInventoryArmorDefenceAndName(7, "Ağır Zırh");
                System.out.println("Ağır Zırh Kazandınız");
            }else if(prize >= 21 && prize <= 30){
                getPlayer().setHealth(3 + getPlayer().getHealth());
                getPlayer().setInventoryArmorDefenceAndName(3, "Orta Zırh");
                System.out.println("Orta Zırh Kazandınız");
            }else {
                getPlayer().setHealth(2 + getPlayer().getHealth());
                getPlayer().setInventoryArmorDefenceAndName(2, "Hafif Zırh");
                System.out.println("Hafif Zırh Kazandınız");
            }
        } else if (category >= 31 && category <= 55) {
            //Para
            if(prize <= 20){
                getPlayer().setMoney(getPlayer().getMoney() + 10);
                System.out.println("10 Altın Kazandınız");
            }else if(prize >= 21 && prize <= 30){
                getPlayer().setMoney(getPlayer().getMoney() + 5);
                System.out.println("5 Altın Kazandınız");
            }else {
                getPlayer().setMoney(getPlayer().getMoney() + 1);
                System.out.println("1 Altın Kazandınız");
            }
        } else {
            //Nothing
            System.out.println("Bir şey kazanamadınız! ");
        }

    }

}
