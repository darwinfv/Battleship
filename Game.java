import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public static void main(String[] args) {

        //Creation of the main frame (game screen)
        jf.setSize(800, 500);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        game = "init";
        //nit means the board is being setup
        //twopart means the user has clicked a button for the first time and a ship will be placed there

        initialize();
        listenPlayer();

        //Main pane
        JPanel pane = new JPanel(new GridBagLayout());
        pane.setBackground(new Color(0, 250, 0));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridy = c.gridx = 0;
        c.ipady = 100;
        pane.add(opponentPane, c);
        c.gridx++;
        pane.add(boardPane, c);

        //Ending code for frame
        jf.add(pane);
        jf.setVisible(true);

    }

    //The method which creates the game setup
    public static void initialize() {

        //Setup opponent's border
        border = BorderFactory.createMatteBorder(20, 20, 20, 20, new Color(200, 0, 0));
        opponentPane.setBorder(border);

        //Setup opponent's button
        for(int i = 0; i < 64; i++) {
            opponent[i] = new JButton(" ");
            opponent[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                }
            });
            opponentPane.add(opponent[i]);
        }

        //Setup player's border
        border = BorderFactory.createMatteBorder(20, 20, 20, 20, new Color(0, 200, 220));
        boardPane.setBorder(border);

        //Setup player's buttons
        for(int i = 0; i < 64; i++) {
            player[i] = new JButton(" ");
            boardPane.add(player[i]);
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
        int[] n = new int[4];
        n[0] = a - 8;
        n[1] = a - 1;
        n[2] = a + 1;
        n[3] = a + 8;
        return n;

    }

    //The method which invokes the appropriate findButton for the ship based on the game status
    public static void highlight(int a) {

        if(game.equals("twopart")) {
            int[] n = findButton2(a);
            for(int i = 0; i < n.length; i++) {
                player[n[i]].setBackground(new Color(255, 107, 104));
            }
        }

    }

    //The method which creates the listener's for the player's buttons
    public static void listenPlayer() {

        player[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[0].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(0);
                }
            }
        });
        player[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[1].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(1);
                }
            }
        });
        player[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[2].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(2);
                }
            }
        });
        player[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[3].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(3);
                }
            }
        });
        player[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[4].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(4);
                }
            }
        });
        player[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[5].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(5);
                }
            }
        });
        player[6].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[6].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(6);
                }
            }
        });

        player[7].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[7].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(7);
                }
            }
        });
        player[8].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[8].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(8);
                }
            }
        });

        player[9].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[9].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(9);
                }
            }
        });
        player[10].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[10].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(10);
                }
            }
        });
        player[11].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[11].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(11);
                }
            }
        });
        player[12].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[12].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(12);
                }
            }
        });
        player[13].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[13].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(13);
                }
            }
        });
        player[14].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[14].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(14);
                }
            }
        });
        player[15].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[15].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(15);
                }
            }
        });
        player[16].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[16].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(16);
                }
            }
        });
        player[17].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[17].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(17);
                }
            }
        });
        player[18].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[18].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(18);
                }
            }
        });
        player[19].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[19].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(19);
                }
            }
        });
        player[20].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[20].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(20);
                }
            }
        });
        player[21].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[21].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(21);
                }
            }
        });
        player[22].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[22].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(22);
                }
            }
        });
        player[23].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[23].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(23);
                }
            }
        });
        player[24].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[24].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(24);
                }
            }
        });
        player[25].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[25].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(25);
                }
            }
        });
        player[26].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[26].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(26);
                }
            }
        });
        player[27].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[27].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(27);
                }
            }
        });
        player[28].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[28].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(28);
                }
            }
        });
        player[29].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[29].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(29);
                }
            }
        });
        player[30].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[30].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(30);
                }
            }
        });
        player[31].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[31].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(31);
                }
            }
        });
        player[32].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[32].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(32);
                }
            }
        });
        player[33].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[33].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(33);
                }
            }
        });
        player[34].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[34].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(34);
                }
            }
        });
        player[35].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[35].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(35);
                }
            }
        });
        player[36].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[36].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(36);
                }
            }
        });
        player[37].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[37].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(37);
                }
            }
        });
        player[38].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[38].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(38);
                }
            }
        });
        player[39].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[39].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(39);
                }
            }
        });
        player[40].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[40].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(40);
                }
            }
        });
        player[41].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[41].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(41);
                }
            }
        });
        player[42].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[42].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(42);
                }
            }
        });
        player[43].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[43].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(43);
                }
            }
        });
        player[44].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[44].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(44);
                }
            }
        });
        player[45].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[45].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(45);
                }
            }
        });
        player[46].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[46].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(46);
                }
            }
        });
        player[47].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[47].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(47);
                }
            }
        });
        player[48].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[48].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(48);
                }
            }
        });
        player[49].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[49].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(49);
                }
            }
        });
        player[50].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[50].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(50);
                }
            }
        });
        player[51].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[51].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(51);
                }
            }
        });
        player[52].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[52].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(52);
                }
            }
        });
        player[53].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[53].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(53);
                }
            }
        });
        player[54].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[54].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(54);
                }
            }
        });
        player[55].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[55].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(55);
                }
            }
        });
        player[56].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[56].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(56);
                }
            }
        });
        player[57].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[57].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(57);
                }
            }
        });
        player[58].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[58].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(58);
                }
            }
        });
        player[59].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[59].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(59);
                }
            }
        });
        player[60].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[60].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(60);
                }
            }
        });
        player[61].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[61].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(61);
                }
            }
        });
        player[62].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[62].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(62);
                }
            }
        });
        player[63].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {
                    player[63].setBackground(new Color(212, 15, 15));
                    game = "twopart";
                    highlight(63);
                }
            }
        });

    }

}
