package Player;

import Characters.*;
import Inventory.Inventory;
import Locations.BatlleLoc.Bataklik;
import Locations.BatlleLoc.Maden;
import Locations.BatlleLoc.Magara;
import Locations.BatlleLoc.Orman;
import Locations.Location;
import Locations.NormalLoc.SafeHouse;
import Locations.NormalLoc.ToolStore;

import java.util.Scanner;


public class Player {
    private int health;
    private int damage;
    private int money;
    private String name;
    private Characters characters;
    private Inventory inventory = new Inventory();
    private Location location;

    private Scanner input = new Scanner(System.in);

    public Player(int health, int damage, int money, String name) {
        this.health = health;
        this.damage = damage;
        this.money = money;
        this.name = name;
    }

    public Player() {
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

    public int getPlayerAndCharacterDamage() {

        return this.damage + characters.getDamage();
    }

    public int getPlayerAndCharacterDefence() {

        return this.health + characters.getHealth();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventoryWeponDamgeAndName(int damage, String name) {
        this.inventory.setWeaponDamage(damage);
        this.inventory.setWeaponName(name);
    }

    public void setInventoryArmorDefenceAndName(int defence, String name) {
        this.inventory.setArmorDefence(damage);
        this.inventory.setArmorName(name);
    }

    public int getInventoryArmorDefenceAndPlayerHealth() {
        return characters.getHealth() + inventory.getArmorDefence();
    }

    /**
     * private boolean water;
     * private boolean food;
     * private boolean fireWood;
     */
    public void setWater() {
        inventory.setWater(true);
    }

    public void setFood() {
        inventory.setFood(true);
    }

    public void setFireWood() {
        inventory.setFireWood(true);
    }

    public void getwater() {
        inventory.isWater();
    }

    public void getFood() {
        inventory.isFood();
    }

    public void getFireWood() {
        inventory.isFireWood();
    }


    //Karakter bilgilerini ekrana yazdırır
    public void selectChar() {
        System.out.println(" *************\n" +
                " * Samuray   *\n" +
                " * ID:    1  *\n" +
                " * HASAR: 5  *\n" +
                " * CAN:   21 *\n" +
                " * PARA:  15 *\n" +
                " *************\n"
                +
                " * Okçu      *\n" +
                " * ID:    2  *\n" +
                " * HASAR: 7  *\n" +
                " * CAN:   18 *\n" +
                " * PARA:  20 *\n" +
                " *************\n"
                +
                " * Şovalye   *\n" +
                " * ID:    3  *\n" +
                " * HASAR: 8  *\n" +
                " * CAN:   24 *\n" +
                " * PARA:   5 *\n" +
                " *************");
    }

    //Karakter Seçme Kısmı
    public void selectedChar(int id) {

        switch (id) {
            case 1:
                characters = new Samuray();
                System.out.println("Samuray Seçildi..");
                break;
            case 2:
                characters = new Okcu();
                System.out.println("Okcu Seçildi..");
                break;
            case 3:
                characters = new Sovalye();
                System.out.println("Şovalye Seçildi..");
                break;
            default:
                System.out.println("Hatalı giriş yaptınız, varsayılan karakter olarak samuray seçildi.");
                characters = new Samuray();

        }
        setValuesMonstersToCharecter();
    }

    //Location seçimi
    public void selectLocation() {
        System.out.println("Gitmek istediğiniz yeri seçiniz\n" +
                "1. Güvenli Ev\n" +
                "2. Mağaza\n" +
                "3. Savaş Alanı");
        int selectedLoc = input.nextInt();
        switch (selectedLoc) {
            case 1:
                location = new SafeHouse(this);
                break;
            case 2:
                location = new ToolStore(this);
                break;
            case 3:
                if (health <= 0) {
                    System.out.println("Canınız çok az buraya giremezsiniz. Güvenli eve gidip dinlensen iyi olur...");
                    break;
                } else {
                    battleZone();
                    break;
                }

            default:
                location = new SafeHouse(this);
                break;
        }

        location.onLocation();
    }

    private void battleZone() {
        System.out.println("Savaş Alanına Hoş Geldin\nNereye Gitmek istiyorsun?");
        System.out.println(
                "1. Mağara\n" +
                        "2. Bataklık\n" +
                        "3. Orman\n" +
                        "4. Maden");
        int selectedLoc = input.nextInt();

        switch (selectedLoc) {
            case 1:
                if (inventory.isFireWood()) {
                    System.out.println("Burayı zaten temizlemişsin içeride hiç düşman yok");
                    break;
                } else {
                    location = new Magara(this);
                    break;
                }

            case 2:
                if (inventory.isFireWood()) {
                    System.out.println("Burayı zaten temizlemişsin içeride hiç düşman yok");
                    break;
                } else {
                    location = new Bataklik(this);
                    break;
                }

            case 3:
                if (inventory.isFireWood()) {
                    System.out.println("Burayı zaten temizlemişsin içeride hiç düşman yok");
                    break;
                } else {
                    location = new Orman(this);
                    break;

                }
            case 4:
                location = new Maden(this);
                break;
        }
    }

    private void setValuesMonstersToCharecter() {
        setHealth(characters.getHealth());
        setDamage(characters.getDamage());
        setMoney(characters.getMoney());
    }
}
