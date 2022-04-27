import Characters.Characters;
import Player.Player;

import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);

    public void start() {
        Player player = new Player();
        System.out.println("Oyun Başlıyor...");
        System.out.print("Karakter Adınızı Giriniz: ");
        player.setName(input.nextLine());
        System.out.println("Hoş geldin " + player.getName());
        System.out.println("Hangi karakteri seçmek istiyorsun?");

        player.selectChar();

        player.selectedChar(input.nextInt());
        while (true) {
            player.selectLocation();
            System.out.println("Bitti");
        }


    }
}
