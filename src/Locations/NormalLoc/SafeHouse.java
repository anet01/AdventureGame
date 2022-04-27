package Locations.NormalLoc;

import Characters.Characters;
import Player.Player;

public class SafeHouse extends NormalLoc {


    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli Evdesiniz.\nCanınız Yenilendi.");
        getPlayer().setHealth(getPlayer().getInventoryArmorDefenceAndPlayerHealth());

        System.out.println("\n\n" +
                "Güncel durumunuz;\n" +
                "Can: " + getPlayer().getHealth()+ "\n" +
                "Para: " + getPlayer().getMoney()+
                "\n\n");

        return super.onLocation();
    }
}
