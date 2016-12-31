import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Darwin Vaz on 12/26/2016.
 */

public class Bot extends Game {

    //The color of a button if the player missed a ship
    final static Color GREY = new Color(162, 162, 162);

    //The color of a button where the opponent's ship has been hit
    final static Color ORANGE = new Color(200, 100, 21);

    //The color of a button where the player's ship has been hit
    final static Color BLUE = new Color(32, 32, 31);

    //The array that keeps track of what each button of the opponent's board refers to
    static int[] pieces = new int[64];

    //The ArrayList that keeps track of which positions the bot has attacked
    static ArrayList<Integer> options = new ArrayList<>();

    //The method which randomly places ships to the opponent's board
    public static void place() {

        int n;
        int end;
        int[] a;
        int count = 0;

        //Places ship 1
        pieces[n = random(64)] = 1;
        a = findButton2(n);
        pieces[a[random(a.length)]] = 1;

        //Places ship 2
        do {
            n = random(64);
            a = findButton3(n);
            for (int i = 0; i < a.length; i++) {
                if (pieces[n] == 0 && pieces[a[i]] == 0 && pieces[(a[i] + n) / 2] == 0) {
                    pieces[n] = 2;
                    pieces[a[i]] = 2;
                    pieces[(a[i] + n) / 2] = 2;
                    count++;
                    break;
                }
            }
        } while (count != 1);

        //Places ship 3
        do {
            n = random(64);
            a = findButton3(n);
            for (int i = 0; i < a.length; i++) {
                if (pieces[n] == 0 && pieces[a[i]] == 0 && pieces[(a[i] + n) / 2] == 0) {
                    pieces[n] = 3;
                    pieces[a[i]] = 3;
                    pieces[(a[i] + n) / 2] = 3;
                    count++;
                    break;
                }
            }
        } while (count != 2);

        //Places ship 3
        do {
            n = random(64);
            a = findButton4(n);
            for (int i = 0; i < a.length; i++) {
                if (Math.abs(n - a[i]) == 3) {
                    if (pieces[n] == 0 && pieces[a[i]] == 0 && pieces[(a[i] + n) / 2] == 0 && pieces[(a[i] + n) / 2 +
                            1] == 0) {
                        pieces[n] = 4;
                        pieces[a[i]] = 4;
                        pieces[(a[i] + n) / 2] = 4;
                        pieces[(a[i] + n) / 2 + 1] = 4;
                        count++;
                        break;
                    }
                }
                else {
                    if (pieces[n] == 0 && pieces[a[i]] == 0 && pieces[(a[i] + n) / 2 - 4] == 0 && pieces[(a[i] + n) /
                            2 + 4] == 0) {
                        pieces[n] = 4;
                        pieces[a[i]] = 4;
                        pieces[(a[i] + n) / 2 - 4] = 4;
                        pieces[(a[i] + n) / 2 + 4] = 4;
                        count++;
                        break;
                    }
                }
            }
        } while (count != 3);

        //Places ship 5
        do {
            n = random(64);
            a = findButton5(n);
            for (int i = 0; i < a.length; i++) {
                if (pieces[n] == 0 && pieces[a[i]] == 0 && pieces[(a[i] + n) / 2] == 0 && pieces[((a[i] + n) / 2 + n)
                        / 2] == 0 && pieces[((a[i] + n) / 2 + a[i]) / 2] == 0) {
                    pieces[n] = 5;
                    pieces[a[i]] = 5;
                    pieces[(a[i] + n) / 2] = 5;
                    pieces[((a[i] + n) / 2 + n) / 2] = 5;
                    pieces[((a[i] + n) / 2 + a[i]) / 2] = 5;
                    count++;
                    break;
                }
            }
        } while (count != 4);

        Play.delay();

        test();

    }

    //The method which tests the bot to see if it correctly randomized placing of the ships
    public static void test() {

        for (int i = 0; i < 64; i++) {
            opponent[i].setText(pieces[i] + "");
        }

    }

    //The method which returns a random integer [0, argument - 1]
    public static int random(int a) {
        int r = (int) (Math.random() * a);
        return r;
    }

    //The method which controls the bot's attacking of the player
    public static void attack() {

        if(game.equals("opponent")) {
            int x;
            while (true) {
                x = random(64);
                if (-1 == options.indexOf(x)) {
                    break;
                }
            }
            options.add(x);
            Play.botMoves++;
            if (matchingColor(player[x])) {
                setInstructions(" The bot missed your ships!");
                player[x].setBackground(GREY);
                Play.botMiss++;
            } else {
                setInstructions(" The bot hit your ship!");
                Play.checkPlayer(x);
                player[x].setBackground(BLUE);
                Play.botHit++;
            }
            game = "player";
        }

    }

    //The method which does the actual work when a button is selected
    public static void buttonMash(int buttonNumber) {

        if(game.equals("player") && !game.equals("opponentwins")) {
            if(GREY.equals(opponent[buttonNumber].getBackground()) || ORANGE.equals(opponent[buttonNumber].getBackground())) {
                setInstructions("You have already attacked that location. Choose another.");
            }
            else {
                Play.playerMoves++;
                if(pieces[buttonNumber] != 0) {
                    setInstructions("You hit the opponent's ship!");
                    opponent[buttonNumber].setBackground(ORANGE);
                    Play.playerHit++;
                    Play.checkOpponent(buttonNumber);
                }
                else {
                    setInstructions("You missed the opponent's ships!");
                    opponent[buttonNumber].setBackground(GREY);
                    Play.playerMiss++;
                }
                if(!game.equals("playerwins")) {
                    game = "opponent";
                    Bot.attack();
                }
            }
        }

    }

    //The method which creates the listener's for the opponent's buttons
    public static void listenOpponent() {

        opponent[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(0);
            }
        });
        opponent[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(1);
            }
        });
        opponent[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(2);
            }
        });
        opponent[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(3);
            }
        });
        opponent[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(4);
            }
        });
        opponent[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(5);
            }
        });
        opponent[6].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(6);
            }
        });

        opponent[7].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(7);
            }
        });
        opponent[8].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(8);
            }
        });

        opponent[9].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(9);
            }
        });
        opponent[10].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(10);
            }
        });
        opponent[11].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(11);
            }
        });
        opponent[12].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(12);
            }
        });
        opponent[13].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(13);
            }
        });
        opponent[14].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(14);
            }
        });
        opponent[15].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(15);
            }
        });
        opponent[16].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(16);
            }
        });
        opponent[17].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(17);
            }
        });
        opponent[18].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(18);
            }
        });
        opponent[19].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(19);
            }
        });
        opponent[20].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(20);
            }
        });
        opponent[21].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(21);
            }
        });
        opponent[22].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(22);
            }
        });
        opponent[23].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(23);
            }
        });
        opponent[24].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(24);
            }
        });
        opponent[25].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(25);
            }
        });
        opponent[26].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(26);
            }
        });
        opponent[27].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(27);
            }
        });
        opponent[28].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(28);
            }
        });
        opponent[29].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(29);
            }
        });
        opponent[30].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(30);
            }
        });
        opponent[31].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(31);
            }
        });
        opponent[32].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(32);
            }
        });
        opponent[33].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(33);
            }
        });
        opponent[34].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(34);
            }
        });
        opponent[35].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(35);
            }
        });
        opponent[36].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(36);
            }
        });
        opponent[37].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(37);
            }
        });
        opponent[38].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(38);
            }
        });
        opponent[39].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(39);
            }
        });
        opponent[40].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(40);
            }
        });
        opponent[41].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(41);
            }
        });
        opponent[42].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(42);
            }
        });
        opponent[43].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(43);
            }
        });
        opponent[44].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(44);
            }
        });
        opponent[45].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(45);
            }
        });
        opponent[46].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(46);
            }
        });
        opponent[47].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(47);
            }
        });
        opponent[48].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(48);
            }
        });
        opponent[49].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(49);
            }
        });
        opponent[50].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(50);
            }
        });
        opponent[51].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(51);
            }
        });
        opponent[52].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(52);
            }
        });
        opponent[53].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(53);
            }
        });
        opponent[54].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(54);
            }
        });
        opponent[55].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(55);
            }
        });
        opponent[56].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(56);
            }
        });
        opponent[57].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(57);
            }
        });
        opponent[58].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(58);
            }
        });
        opponent[59].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(59);
            }
        });
        opponent[60].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(60);
            }
        });
        opponent[61].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(61);
            }
        });
        opponent[62].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(62);
            }
        });
        opponent[63].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMash(63);
            }
        });
        
    }

}
