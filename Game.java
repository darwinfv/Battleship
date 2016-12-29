import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

/**
 * Created by Darwin Vaz on 12/20/2016.
 */

public class Game {

    //The string which tells us the status of the game
    static String game;

    //The main frame (game screen)
    static JFrame jf = new JFrame("Battleship");

    //Opponent's board
    static JPanel opponentPane = new JPanel(new GridLayout(8, 8));

    //Opponent's buttons
    static JButton[] opponent = new JButton[64];

    //Player's board
    static JPanel boardPane = new JPanel(new GridLayout(8, 8));

    //Player's buttons
    static JButton[] player = new JButton[64];

    //Reusable border
    static Border border;

    //The color of a button with a ship of length 2 on it
    final static Color RED = new Color(250, 82, 15);

    //The color of a button with the first ship of length 3 on it
    final static Color RED2 = new Color(255, 27, 30);

    //The color of a button with the second ship of length 3 on it
    final static Color RED3 = new Color(217, 0, 57);

    //The color of a button with a ship of length 4 on it
    final static Color RED4 = new Color(234, 0, 167);

    //The color of a button with a ship of length 5 on it
    final static Color RED5 = new Color(134, 7, 139);

    //The color a a button which can potentially have the remaining parts of a ship placed there
    final static Color PINK = new Color(255, 162, 165);

    //The button with one end of the ship
    static int end;

    //Instructions
    static JLabel instructions = new JLabel("Waiting for bot to place ships...");

    public static void main(String[] args) {

        //Creation of the main frame (game screen)
        jf.setSize(800, 520);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        game = "randomize";
        //randomize means that the opponent is placing his ships
        //init means the board has been setup and is ready to receive commands from the user
        //twopart means the user has clicked a button for the first time and a ship will be placed there
        //three means the second ship is going to be placed next
        //threepart means that one end of the ship of length 3 has been placed
        //third means the second ship of length 3 is going to be placed next
        //thirdpart means that one end of the second ship of length 3 has been placed
        //four means the fourth ship is going to be placed next
        //fourpart means that one end of the ship of length 4 has been placed
        //five means the fifth ship is going to be placed next
        //fivepart means that one end of the ship of length 5 has been placed
        //player means it is the player's turn
        //opponent means it is the bot's turn

        initialize();
        listenPlayer();

        //Instruction pane
        JPanel ipane = new JPanel();
        border = BorderFactory.createTitledBorder(null, "INSTRUCTIONS", TitledBorder.CENTER, 0, null, new Color(181, 94, 25));
        ipane.setBorder(border);
        ipane.add(instructions);
        ipane.setBackground(new Color(0, 200, 220));

        //Main pane
        JPanel pane = new JPanel(new GridBagLayout());
        pane.setBackground(new Color(41, 255, 1));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridy = c.gridx = 0;
        c.ipady = 100;
        pane.add(opponentPane, c);
        c.insets = new Insets(0, 20, 0, 0);
        c.gridx++;
        pane.add(boardPane, c);
        c.gridy++;
        c.gridx--;
        c.gridwidth = 2;
        c.ipady = 10;
        c.insets = new Insets(20, 80, 0, 80);
        pane.add(ipane, c);

        //Ending code for frame
        jf.add(pane);
        jf.setVisible(true);

        Bot.place();
        setInstructions("Click anywhere to place the Destroyer.");
        game = "init";

    }

    //The method which creates the game setup
    public static void initialize() {

        //Setup opponent's border
        border = BorderFactory.createMatteBorder(20, 20, 20, 20, new Color(214, 0, 0));
        opponentPane.setBorder(border);

        //Setup opponent's button
        for(int i = 0; i < 64; i++) {
            opponent[i] = new JButton(" ");
            opponentPane.add(opponent[i]);
        }
        Bot.listenOpponent();

        //Setup player's border
        border = BorderFactory.createMatteBorder(20, 20, 20, 20, new Color(0, 200, 220));
        boardPane.setBorder(border);

        //Setup player's buttons
        for(int i = 0; i < 64; i++) {
            player[i] = new JButton(" ");
            boardPane.add(player[i]);
        }

    }

    //The method which checks if the color of a button matches the specified color (which is the color of another
    // button (needed for collisions and interceptions))
    public static boolean matchingColor(JButton b) {
        if (!RED.equals(b.getBackground()) && !RED2.equals(b.getBackground()) && !RED3.equals(b.getBackground()) &&
                !RED4.equals(b.getBackground()) && !RED5.equals(b.getBackground())) {
            return true;
        }
        else {
            return false;
        }
    }

    //The method which sets all the buttons' colors to null if no match can be found
    public static void setButtons(Color c) {
        for (int i = 0; i < 64; i++) {
            if(c.equals(player[i].getBackground())) {
                player[i].setBackground(null);
            }
        }
    }

    //The method which sets the instructions in the instruction box
    public static void setInstructions(String s) {
        if (s == null) {
            instructions.setText("Click on one of the highlighted buttons to place the other end of the ship.");
        }
        else if (s.equals("1")) {
            instructions.setText("Your ship cannot fit there. Choose another location.");
        }
        else if (" ".equals(s.substring(0, 1))) {
            instructions.setText(instructions.getText() + s);
        }
        else {
            instructions.setText(s);
        }
    }

    //The method which returns the possible buttons for placing your ship of length 2 when the player has selected a
    // single button
    public static int[] findButton2(int a) {

        if (a == 0) {
            int[] n = new int[2];
            n[0] = a + 1;
            n[1] = a + 8;
            return n;
        }
        if (a > 0 && a < 7) {
            int[] n = new int[3];
            n[0] = a + 8;
            n[1] = a - 1;
            n[2] = a + 1;
            return n;
        }
        if (a == 7) {
            int[] n = new int[2];
            n[0] = a - 1;
            n[1] = a + 8;
            return n;
        }
        if (a == 8 || a == 16 || a == 24 || a == 32 || a == 40 || a == 48) {
            int[] n = new int[3];
            n[0] = a + 1;
            n[1] = a - 8;
            n[2] = a + 8;
            return n;
        }
        if (a == 15 || a == 23 || a == 31 || a == 39 || a == 47 || a == 55) {
            int[] n = new int[3];
            n[0] = a - 1;
            n[1] = a - 8;
            n[2] = a + 8;
            return n;
        }
        if (a == 56) {
            int[] n = new int[2];
            n[0] = a - 8;
            n[1] = a + 1;
            return n;
        }
        if (a > 56 && a < 63) {
            int[] n = new int[3];
            n[0] = a - 8;
            n[1] = a - 1;
            n[2] = a + 1;
            return n;
        }
        if (a == 63) {
            int[] n = new int[2];
            n[0] = a - 8;
            n[1] = a - 1;
            return n;
        }
        else {
            int[] n = new int[4];
            n[0] = a - 8;
            n[1] = a - 1;
            n[2] = a + 1;
            n[3] = a + 8;
            return n;
        }

    }

    //The method which returns the possible buttons for placing your ship of length 3 when the player has selected a
    // single button
    public static int[] findButton3(int a) {

        if (a == 0 || a == 1 || a == 8 || a == 9) {
            int[] n = new int[2];
            n[0] = a + 2;
            n[1] = a + 16;
            return n;
        }
        if ((a > 1 && a < 6) || (a > 9 && a < 14)) {
            int[] n = new int[3];
            n[0] = a + 16;
            n[1] = a - 2;
            n[2] = a + 2;
            return n;
        }
        if (a == 6 || a == 7 || a == 14 || a == 15) {
            int[] n = new int[2];
            n[0] = a - 2;
            n[1] = a + 16;
            return n;
        }
        if (a == 16 || a == 24 || a == 32 || a == 40 || a == 17 || a == 25 || a == 33 || a == 41) {
            int[] n = new int[3];
            n[0] = a + 2;
            n[1] = a - 16;
            n[2] = a + 16;
            return n;
        }
        if (a == 23 || a == 31 || a == 39 || a == 47 || a == 22 || a == 30 || a == 38 || a == 46) {
            int[] n = new int[3];
            n[0] = a - 2;
            n[1] = a - 16;
            n[2] = a + 16;
            return n;
        }
        if (a == 48 || a == 49 || a == 56 || a == 57) {
            int[] n = new int[2];
            n[0] = a - 16;
            n[1] = a + 2;
            return n;
        }
        if ((a > 49 && a < 54) || (a > 57 && a < 62)) {
            int[] n = new int[3];
            n[0] = a - 16;
            n[1] = a - 2;
            n[2] = a + 2;
            return n;
        }
        if (a == 54 || a == 55 || a == 62 || a == 63) {
            int[] n = new int[2];
            n[0] = a - 16;
            n[1] = a - 2;
            return n;
        }
        else {
            int[] n = new int[4];
            n[0] = a - 16;
            n[1] = a - 2;
            n[2] = a + 2;
            n[3] = a + 16;
            return n;
        }

    }

    //The method which returns the possible buttons for placing your ship of length 4 when the player has selected a
    // single button
    public static int[] findButton4(int a) {

        if (a < 3 || (a > 7 && a < 11) || (a > 15 && a < 19)) {
            int[] n = new int[2];
            n[0] = a + 3;
            n[1] = a + 24;
            return n;
        }
        if (a == 3 || a == 4 || a == 11 || a == 12 || a == 19 || a == 20) {
            int[] n = new int[3];
            n[0] = a - 3;
            n[1] = a + 3;
            n[2] = a + 24;
            return n;
        }
        if ((a > 4 && a < 8) || (a > 12 && a < 16) || (a > 20 && a < 24)) {
            int[] n = new int[2];
            n[0] = a - 3;
            n[1] = a + 24;
            return n;
        }
        if ((a > 23 && a < 27) || (a > 31 && a < 35)) {
            int[] n = new int[3];
            n[0] = a - 24;
            n[1] = a + 3;
            n[2] = a + 24;
            return n;
        }
        if ((a > 28 && a < 32) || (a > 36 && a < 40)) {
            int[] n = new int[3];
            n[0] = a - 24;
            n[1] = a - 3;
            n[2] = a + 24;
            return n;
        }
        if ((a > 39 && a < 43) || (a > 47 && a < 51) || (a > 55 && a < 59)) {
            int[] n = new int[2];
            n[0] = a - 24;
            n[1] = a + 3;
            return n;
        }
        if (a == 43 || a == 44 || a == 51 || a == 52 || a == 59 || a == 60) {
            int[] n = new int[3];
            n[0] = a - 3;
            n[1] = a - 24;
            n[2] = a + 3;
            return n;
        }
        if ((a > 44 && a < 48) || (a > 52 && a < 56) || (a > 60 && a < 64)) {
            int[] n = new int[2];
            n[0] = a - 3;
            n[1] = a - 24;
            return n;
        }
        else {
            int[] n = new int[4];
            n[0] = a - 3;
            n[1] = a - 24;
            n[2] = a + 3;
            n[3] = a + 24;
            return n;
        }

    }

    //The method which returns the possible buttons for placing your ship of length 5 when the player has selected a
    // single button
    public static int[] findButton5(int a) {

        int[] n = new int[2];
        if (a < 4 || (a > 7 && a < 12) || (a > 15 && a < 20) || (a > 23 && a < 28)) {
            n[0] = a + 4;
            n[1] = a + 32;
            return n;
        }
        if ((a > 3 && a < 8) || (a > 11 && a < 16) || (a > 19 && a < 24) || (a > 27 && a < 32)) {
            n[0] = a - 4;
            n[1] = a + 32;
            return n;
        }
        if ((a > 31 && a < 36) || (a > 39 && a < 44) || (a > 47 && a < 52) || (a > 55 && a < 60)) {
            n[0] = a + 4;
            n[1] = a - 32;
            return n;
        }
        else {
            n[0] = a - 4;
            n[1] = a - 32;
            return n;
        }

    }

    //The method which invokes the appropriate findButton for the ship based on the game status and handles the
    // coloring and uncoloring of buttons accordingly
    public static void highlight(int a) {

        if(game.equals("twopart")) {
            int[] n = findButton2(a);
            for(int i = 0; i < n.length; i++) {
                player[n[i]].setBackground(PINK);
            }
        }
        if(game.equals("threepart") || game.equals("thirdpart")) {
            int[] n = findButton3(a);
            int possibleCounter = n.length;
            for (int i = 0; i < n.length; i++) {
                if(matchingColor(player[n[i]]) && matchingColor(player[(n[i] + end) / 2])) {
                    player[n[i]].setBackground(PINK);
                }
                else {
                    possibleCounter--;
                }
            }
            if(possibleCounter == 0) {
                setInstructions("1");
                if(game.equals("threepart")) {
                    setButtons(RED2);
                }
                if(game.equals("thirdpart")) {
                    setButtons(RED3);
                }
                game = game.substring(0, 5);
            }
        }
        if(game.equals("fourpart")) {
            int[] n = findButton4(a);
            int possibleCounter = n.length;
            for (int i = 0; i < n.length; i++) {
                if(Math.abs(n[i] - end) == 3) {
                    if(matchingColor(player[n[i]]) && matchingColor(player[(n[i] + end) / 2]) && matchingColor(player[(n[i] + end) / 2 + 1])) {
                        player[n[i]].setBackground(PINK);
                    }
                    else {
                        possibleCounter--;
                    }
                }
                if(Math.abs(n[i] - end) == 24) {
                    if(matchingColor(player[n[i]]) && matchingColor(player[(n[i] + end) / 2 - 4]) && matchingColor(player[(n[i] + end) / 2 + 4])) {
                        player[n[i]].setBackground(PINK);
                    }
                    else {
                        possibleCounter--;
                    }
                }
            }
            if(possibleCounter == 0) {
                setInstructions("1");
                setButtons(RED4);
                game = "four";
            }
        }
        if(game.equals("fivepart")) {
            int[] n = findButton5(a);
            int possibleCounter = n.length;
            for (int i = 0; i < n.length; i++) {
                if(matchingColor(player[n[i]]) && matchingColor(player[(n[i] + end) / 2]) && matchingColor(player[(
                        (n[i] + end) / 2 + n[i]) / 2]) && matchingColor(player[((n[i] + end) / 2 + end) / 2])) {
                    player[n[i]].setBackground(PINK);
                }
                else {
                    possibleCounter--;
                }
            }
            if(possibleCounter == 0) {
                setInstructions("1");
                setButtons(RED5);
                game = "five";
            }
        }

    }

    //The method which does the actual work when a button is clicked
    public static void buttonWork(int buttonNumber) {

        if(game.equals("init")) {
            player[buttonNumber].setBackground(RED);
            game = "twopart";
            setInstructions(null);
            highlight(buttonNumber);
        }
        else if(game.equals("twopart") && PINK.equals(player[buttonNumber].getBackground())) {
            player[buttonNumber].setBackground(RED);
            game = "three";
            setInstructions("Click anywhere to place the Submarine.");
            setButtons(PINK);
        }
        else if(game.equals("three") && matchingColor(player[buttonNumber])) {
            player[buttonNumber].setBackground(RED2);
            end = buttonNumber;
            game = "threepart";
            setInstructions(null);
            highlight(buttonNumber);
        }
        else if(game.equals("threepart") && PINK.equals(player[buttonNumber].getBackground())) {
            player[buttonNumber].setBackground(RED2);
            player[(buttonNumber + end) / 2].setBackground(RED2);
            game = "third";
            setInstructions("Click anywhere to place the Cruiser.");
            setButtons(PINK);
        }
        else if(game.equals("third") && matchingColor(player[buttonNumber])) {
            player[buttonNumber].setBackground(RED3);
            end = buttonNumber;
            game = "thirdpart";
            setInstructions(null);
            highlight(buttonNumber);
        }
        else if(game.equals("thirdpart") && PINK.equals(player[buttonNumber].getBackground())) {
            player[buttonNumber].setBackground(RED3);
            player[(buttonNumber + end) / 2].setBackground(RED3);
            game = "four";
            setInstructions("Click anywhere to place the Battlsehip.");
            setButtons(PINK);
        }
        else if(game.equals("four") && matchingColor(player[buttonNumber])) {
            player[buttonNumber].setBackground(RED4);
            end = buttonNumber;
            game = "fourpart";
            setInstructions(null);
            highlight(buttonNumber);
        }
        else if(game.equals("fourpart") && PINK.equals(player[buttonNumber].getBackground())) {
            player[buttonNumber].setBackground(RED4);
            if(Math.abs(buttonNumber - end) == 3) {
                player[(buttonNumber + end) / 2].setBackground(RED4);
                player[(buttonNumber + end) / 2 + 1].setBackground(RED4);
            }
            else {
                player[(buttonNumber + end) / 2 - 4].setBackground(RED4);
                player[(buttonNumber + end) / 2 + 4].setBackground(RED4);
            }
            game = "five";
            setInstructions("Click anywhere to place the Carrier.");
            setButtons(PINK);
        }
        else if(game.equals("five") && matchingColor(player[buttonNumber])) {
            player[buttonNumber].setBackground(RED5);
            end = buttonNumber;
            game = "fivepart";
            setInstructions(null);
            highlight(buttonNumber);
        }
        else if(game.equals("fivepart") && PINK.equals(player[buttonNumber].getBackground())) {
            player[buttonNumber].setBackground(RED5);
            player[(buttonNumber + end) / 2].setBackground(RED5);
            player[((buttonNumber + end) / 2 + buttonNumber) / 2].setBackground(RED5);
            player[((buttonNumber + end) / 2 + end) / 2].setBackground(RED5);
            setButtons(PINK);
            Play.beginGame();
        }

    }

    //The method which creates the listener's for the player's buttons
    public static void listenPlayer() {

        player[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(0);
            }
        });
        player[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(1);
            }
        });
        player[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(2);
            }
        });
        player[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(3);
            }
        });
        player[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(4);
            }
        });
        player[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(5);
            }
        });
        player[6].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(6);
            }
        });

        player[7].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(7);
            }
        });
        player[8].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(8);
            }
        });

        player[9].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(9);
            }
        });
        player[10].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(10);
            }
        });
        player[11].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(11);
            }
        });
        player[12].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(12);
            }
        });
        player[13].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(13);
            }
        });
        player[14].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(14);
            }
        });
        player[15].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(15);
            }
        });
        player[16].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(16);
            }
        });
        player[17].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(17);
            }
        });
        player[18].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(18);
            }
        });
        player[19].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(19);
            }
        });
        player[20].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(20);
            }
        });
        player[21].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(21);
            }
        });
        player[22].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(22);
            }
        });
        player[23].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(23);
            }
        });
        player[24].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(24);
            }
        });
        player[25].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(25);
            }
        });
        player[26].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(26);
            }
        });
        player[27].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(27);
            }
        });
        player[28].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(28);
            }
        });
        player[29].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(29);
            }
        });
        player[30].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(30);
            }
        });
        player[31].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(31);
            }
        });
        player[32].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(32);
            }
        });
        player[33].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(33);
            }
        });
        player[34].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(34);
            }
        });
        player[35].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(35);
            }
        });
        player[36].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(36);
            }
        });
        player[37].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(37);
            }
        });
        player[38].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(38);
            }
        });
        player[39].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(39);
            }
        });
        player[40].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               buttonWork(40);
            }
        });
        player[41].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(41);
            }
        });
        player[42].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(42);
            }
        });
        player[43].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(43);
            }
        });
        player[44].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(44);
            }
        });
        player[45].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(45);
            }
        });
        player[46].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(46);
            }
        });
        player[47].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(47);
            }
        });
        player[48].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(48);
            }
        });
        player[49].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(49);
            }
        });
        player[50].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(50);
            }
        });
        player[51].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(51);
            }
        });
        player[52].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(52);
            }
        });
        player[53].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(53);
            }
        });
        player[54].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(54);
            }
        });
        player[55].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(55);
            }
        });
        player[56].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(56);
            }
        });
        player[57].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(57);
            }
        });
        player[58].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(58);
            }
        });
        player[59].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(59);
            }
        });
        player[60].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(60);
            }
        });
        player[61].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(61);
            }
        });
        player[62].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(62);
            }
        });
        player[63].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonWork(63);
            }
        });

    }

}
