import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pig {

    private static Scanner scan;

    public static void main(String[] args) {
        scan = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>();
        String name = "*@(!";
        List<Player> players = new ArrayList<>();
        Player player;

        PigGame pig;
        int score = 0;
        int size = 0;
        int cap;
        boolean finish = false;

        System.out.println("Welcome to the game Pig");
        System.out.println("Enter the Pig Limit to be used for all players");
        cap = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter your name for the scoreboard (Press enter to quit)");
        name = scan.nextLine();

        while (name.compareTo("") != 0) {
            finish = false;

            while (!finish) {
                if (!names.contains(name)) {
                    pig = new PigGame(cap);
                    score = pig.play();

                    names.add(name);
                    player = new Player(name, score);
                    players.add(player);
                    System.out.println("Next person enter your name for the scoreboard (Press enter to quit)");
                    name = scan.nextLine();
                    finish = true;
                } else {
                    System.out.println("That name is already taken, enter a new one.");
                    name = scan.nextLine();
                }
            }

        }

        System.out.println("SCOREBOARD \n---------------");
        for (Player player1 : players) {
            System.out.println(player1.getName() + ": " + player1.getScore());
        }

    }
}
