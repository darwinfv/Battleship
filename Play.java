import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Darwin Vaz on 12/27/2016.
 */

public class Play extends Game {

    //The variables which keep track of the player's and the bot's statistics
    static int playerHit = 0;
    static int playerMiss = 0;
    static int playerMoves = 0;
    static int botHit = 0;
    static int botMiss = 0;
    static int botMoves = 0;

    //The arrays which keep track of which ships the player has hit
    static ArrayList<Integer> collect = new ArrayList<>(17);
    static int[] number = new int[5];

    //The arrays which keep track of which ships the player has hit
    static ArrayList<Integer> collage = new ArrayList<>(17);
    static int[] no = new int[5];

    //The method that counts how many parts of the ship have been hit
    public static int countOccurences(int a, ArrayList<Integer> c) {
        int counter = 0;
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i) == a) {
                counter++;
            }
        }
        return counter;
    }

    //The method which checks if the player's ships have been destroyed
    public static void checkPlayer(int a) {

        if(RED.equals(player[a].getBackground())) {
            collage.add(1);
        }
        if(RED2.equals(player[a].getBackground())) {
            collage.add(2);
        }
        if(RED3.equals(player[a].getBackground())) {
            collage.add(3);
        }
        if(RED4.equals(player[a].getBackground())) {
            collage.add(4);
        }
        if(RED5.equals(player[a].getBackground())) {
            collage.add(5);
        }
        if(no[0] == 0) {
            if(countOccurences(1, collage) == 2) {
                no[0] = 1;
                playerShip.setText("Ships: " + --playerCount);
            }
        }
        if(no[1] == 0) {
            if(countOccurences(2, collage) == 3) {
                no[1] = 1;
                playerShip.setText("Ships: " + --playerCount);
            }
        }
        if(no[2] == 0) {
            if(countOccurences(3, collage) == 3) {
                no[2] = 1;
                playerShip.setText("Ships: " + --playerCount);
            }
        }
        if(no[3] == 0) {
            if(countOccurences(4, collage) == 4) {
                no[3] = 1;
                playerShip.setText("Ships: " + --playerCount);
            }
        }
        if(no[4] == 0) {
            if(countOccurences(5, collage) == 5) {
                no[4] = 1;
                playerShip.setText("Ships: " + --playerCount);
            }
        }
        if(playerCount == 0) {
            game = "opponentwins";
            setInstructions("YOU LOST");
            endGame();
        }

    }

    //The method which checks if the opponent's ships have been destroyed
    public static void checkOpponent(int a) {

        collect.add(Bot.pieces[a]);
        if(number[0] == 0) {
            if(countOccurences(1, collect) == 2) {
                number[0] = 1;
                opponentShip.setText("Ships: " + --opponentCount);
            }
        }
        if(number[1] == 0) {
            if(countOccurences(2, collect) == 3) {
                number[1] = 1;
                opponentShip.setText("Ships: " + --opponentCount);
            }
        }
        if(number[2] == 0) {
            if(countOccurences(3, collect) == 3) {
                number[2] = 1;
                opponentShip.setText("Ships: " + --opponentCount);
            }
        }
        if(number[3] == 0) {
            if(countOccurences(4, collect) == 4) {
                number[3] = 1;
                opponentShip.setText("Ships: " + --opponentCount);
            }
        }
        if(number[4] == 0) {
            if(countOccurences(5, collect) == 5) {
                number[4] = 1;
                opponentShip.setText("Ships: " + --opponentCount);
            }
        }
        if(opponentCount == 0) {
            game = "playerwins";
            setInstructions("YOU WON!");
            endGame();
        }

    }

    //The method which begins the game and flow of control
    public static void beginGame() {

        int x = Bot.random(2);
        if(x == 0) {
            game = "player";
            setInstructions("You get the first shot. Click on the opponent's board to attack.");
        }
        else {
            setInstructions("The bot begins the game.");
            Play.delay();
            game = "opponent";
            Bot.attack();
        }

    }

    //The method which delays the game by a maximum of 3 seconds
    public static void delay() {
        try {
            TimeUnit.MILLISECONDS.sleep(Bot.random(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //The method which displays the endgame statistics
    public static void endGame() {

        jf.getContentPane().removeAll();

        JLabel screen = new JLabel(instructions.getText(), SwingConstants.CENTER);
        screen.setFont(new Font("Helvetica", Font.BOLD, 100));

        JPanel statPane = new JPanel(new GridLayout(4, 1));
        statPane.setBackground(new Color(41, 255, 1));
        JPanel statPane2 = new JPanel(new GridLayout(4, 1));
        statPane2.setBackground(new Color(41, 255, 1));
        JLabel[] stats = new JLabel[8];
        stats[0] = new JLabel("Opponent", SwingConstants.CENTER);
        stats[0].setFont(new Font("Arial", Font.BOLD, 24));
        stats[1] = new JLabel("Player", SwingConstants.RIGHT);
        stats[1].setFont(new Font("Arial", Font.BOLD, 24));
        stats[2] = new JLabel("Hits: " + botHit, SwingConstants.LEFT);
        stats[4] = new JLabel("Misses: " + botMiss, SwingConstants.LEFT);
        stats[6] = new JLabel("Hit Percentage: " + (botHit * 100 / botMoves) + "%", SwingConstants.LEFT);
        stats[3] = new JLabel("Hits: " + playerHit, SwingConstants.RIGHT);
        stats[5] = new JLabel("Misses: " + playerMiss, SwingConstants.RIGHT);
        stats[7] = new JLabel("Hit Percentage: " + (playerHit * 100 / playerMoves) + "%", SwingConstants.RIGHT);
        for (int i = 0; i < 8; i++) {
            if(i % 2 == 0) {
                statPane.add(stats[i]);
            }
            else {
                statPane2.add(stats[i]);
            }
        }

        JPanel pane = new JPanel(new GridBagLayout());
        pane.setBackground(new Color(41, 255, 1));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridy = c.gridx = 0;
        c.gridwidth = 2;
        pane.add(screen, c);
        c.gridwidth = 1;
        c.gridy++;
        c.insets = new Insets(20, 60, 0, 0);
        pane.add(statPane, c);
        c.gridx++;
        c.insets = new Insets(20, 0, 0, 60);
        pane.add(statPane2, c);

        jf.add(pane);

    }

}
