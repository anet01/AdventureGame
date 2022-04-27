package Locations.BatlleLoc;

import Locations.Location;
import Monsters.Monsters;
import Player.Player;

public abstract class BattleZone extends Location {

    Monsters monsters;

    public BattleZone(Player player, String name) {
        super(player, name);
    }

    @Override
    public boolean onLocation() {
        return true;
    }

    public void battle(){

    }
}
