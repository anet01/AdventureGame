package Locations.NormalLoc;

import Inventory.Inventory;
import Player.Player;

import java.util.Scanner;

public class ToolStore extends NormalLoc {

    Scanner input = new Scanner(System.in);
    Inventory inventory = new Inventory();

    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya Hoşgeldin." + getPlayer().getName() + "\n");
        super.onLocation();
        categorys();
        return super.onLocation();
    }

    public void categorys() {
        System.out.println("Mağazaya Hoşgeldin." + getPlayer().getName() + "\n" +
                "Ne Almak İstersin?\n" +
                "1. Silah\n" +
                "2. Zırh");
        int category = input.nextInt();
        switch (category) {
            case 1:
                weapons();
                break;
            case 2:
                armors();
                break;
        }

    }

    /**
     * Tabanca 1 2 25
     * Kılıç   2 3 35
     * Tüfek   3 7 45
     */
    public void weapons() {
        System.out.println("Silahçıya Hoşgeldiniz.\n Hangi Silahı Almak istersiniz?");
        System.out.println(" *************\n" +
                " * Tabanca   *\n" +
                " * ID:    1  *\n" +
                " * HASAR: 2  *\n" +
                " * PARA:  25 *\n" +
                " *************\n"
                +
                " * Kılıç     *\n" +
                " * ID:    2  *\n" +
                " * HASAR: 3  *\n" +
                " * PARA:  35 *\n" +
                " *************\n"
                +
                " * Tüfek   *\n" +
                " * ID:    3  *\n" +
                " * HASAR: 7  *\n" +
                " * PARA:  45 *\n" +
                " *************");

        int id = input.nextInt();
        switch (id) {
            case 1:
                checkMoney(25, 2, "weapon" );
                break;
            case 2:
                checkMoney(35, 3, "weapon");
                break;
            case 3:
                checkMoney(45, 7, "weapon");
                break;
        }
    }

    /**
     * Hafif    1   2   25
     * Orta     2   3   35
     * Ağır     3   7   45
     */
    public void armors() {
        System.out.println("Zırhçıya Hoşgeldiniz.\n Hangi Zırhı Almak istersiniz?");
        System.out.println(" *************\n" +
                " * Hafif Zırh *\n" +
                " * ID:    1   *\n" +
                " * DEFANS: 2  *\n" +
                " * PARA:  25  *\n" +
                " *************\n"
                +
                " * Orta Zırh  *\n" +
                " * ID:     2  *\n" +
                " * DEFANS: 3  *\n" +
                " * PARA:  35  *\n" +
                " *************\n"
                +
                " * Ağır Zırh  *\n" +
                " * ID:     3  *\n" +
                " * DEFANS: 7  *\n" +
                " * PARA:   45 *\n" +
                " *************");

        int id = input.nextInt();

        switch (id) {
            case 1:
                checkMoney(25, 2, "armor");
                break;
            case 2:
                checkMoney(35, 3, "armor");
                break;
            case 3:
                checkMoney(45, 7, "armor");
                break;
        }


    }

    public void checkMoney(int price, int value, String tur) {

        if(tur.equals("weapon")){
            if (getPlayer().getMoney() >= price) {
                getPlayer().setMoney(getPlayer().getMoney() - price);
                getPlayer().setDamage(value + getPlayer().getDamage());
                getPlayer().setInventoryWeponDamgeAndName(value,tur);

                System.out.println("Silah alındı.\n" +
                        "Güncel Hasarınız: " + getPlayer().getPlayerAndCharacterDamage());
            }
            else {
                System.out.println("Bakiyeniz az olduğu için bu ürünü alamazsınız!");
            }
        }else {
            if (getPlayer().getMoney() >= price) {
                getPlayer().setMoney(getPlayer().getMoney() - price);
                getPlayer().setHealth(value + getPlayer().getHealth());
                getPlayer().setInventoryArmorDefenceAndName(value, tur);
                System.out.println("Zırh alındı.\n" +
                        "Güncel Defansınız: " + getPlayer().getPlayerAndCharacterDefence());
            }
            else {
                System.out.println("Bakiyeniz az olduğu için bu ürünü alamazsınız!");
            }
        }


    }
}
