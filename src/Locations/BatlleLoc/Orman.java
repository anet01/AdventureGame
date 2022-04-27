package Locations.BatlleLoc;

import Monsters.Monsters;
import Monsters.Vampire;
import Player.Player;

import java.util.Random;

public class Orman extends BattleZone{
    Random random = new Random();
    Monsters vampire = new Vampire();
    public Orman(Player player) {
        super(player, "\n\nOrmana Hoşgeldin\nVampirler etrafını sardı dikkatli ol! ");
        System.out.println(createVampir() + " Adet vampir etrafını çevirdi!");
        battle();
    }


    private int createVampir() {

        int count = random.nextInt(3) + 1;
        vampire.setMonsterCount(count);
        return count;
    }

    @Override
    public void battle() {
        int randomNumber = random.nextInt(2) + 1;
        vampire.setHealth(vampire.getHealth() * vampire.getMonsterCount());

        //randomNumber 1 ise Oyuncu başlıyor diğer durumda yaratık
        if(randomNumber == 1){
            while (getPlayer().getHealth() >= 0) {

                System.out.println(getPlayer().getName() + " Saldırıyor...");
                vampire.setHealth(vampire.getHealth() - (getPlayer().getDamage() + getPlayer().getInventory().getWeaponDamage()));
                if (vampire.getHealth() <= 0) {
                    System.out.println("Vampir öldü! Kazandınız!");
                    getPlayer().setMoney(getPlayer().getMoney() + vampire.getValue());
                    getPlayer().setFireWood();
                    break;
                }

                System.out.println("Vampir Saldırıyor...");
                getPlayer().setHealth(getPlayer().getHealth() - vampire.getDamage());
                if (getPlayer().getHealth() <= 0) {
                    System.out.println("Öldünüz!");
                    break;

                }
                System.out.println("Vampirlerin Kalan Canı: " + vampire.getHealth() + "\n" +
                        getPlayer().getName() + " Kalan canı: " + getPlayer().getHealth());


            }
        }
        else {
            while (getPlayer().getHealth() >= 0) {



                System.out.println("Vampir Saldırıyor...");
                getPlayer().setHealth(getPlayer().getHealth() - vampire.getDamage());
                if (getPlayer().getHealth() <= 0) {
                    System.out.println("Öldünüz!");
                    break;

                }

                System.out.println(getPlayer().getName() + " Saldırıyor...");
                vampire.setHealth(vampire.getHealth() - (getPlayer().getDamage() + getPlayer().getInventory().getWeaponDamage()));
                if (vampire.getHealth() <= 0) {
                    System.out.println("Vampir öldü! Kazandınız!");
                    getPlayer().setMoney(getPlayer().getMoney() + vampire.getValue());
                    getPlayer().setFireWood();
                    break;
                }


                System.out.println("Vampirlerin Kalan Canı: " + vampire.getHealth() + "\n" +
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
