import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Darwin Vaz on 12/20/2016.
 */

public class Game {

    public static void main(String[] args) {

        JFrame jf = new JFrame("Battleship");
        jf.setSize(800, 500);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        String game = "init";

        String[] symbol = new String[64];
        for (int i = 0; i < 64; i++) {
            symbol[i] = " ";
        }

        JPanel opponentPane = new JPanel(new GridLayout(8, 8));
        Border border = BorderFactory.createMatteBorder(20, 20, 20, 20, new Color(200, 0, 0));
        opponentPane.setBorder(border);

        JButton opponent0 = new JButton(symbol[0]);
        opponent0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent0);

        JButton opponent1 = new JButton(symbol[1]);
        opponent1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent1);

        JButton opponent2 = new JButton(symbol[2]);
        opponent2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent2);

        JButton opponent3 = new JButton(symbol[3]);
        opponent3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent3);

        JButton opponent4 = new JButton(symbol[4]);
        opponent4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent4);

        JButton opponent5 = new JButton(symbol[5]);
        opponent5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent5);

        JButton opponent6 = new JButton(symbol[6]);
        opponent6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent6);

        JButton opponent7 = new JButton(symbol[7]);
        opponent7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent7);

        JButton opponent8 = new JButton(symbol[8]);
        opponent8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent8);

        JButton opponent9 = new JButton(symbol[9]);
        opponent9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent9);

        JButton opponent10 = new JButton(symbol[10]);
        opponent10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent10);

        JButton opponent11 = new JButton(symbol[11]);
        opponent11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent11);

        JButton opponent12 = new JButton(symbol[12]);
        opponent12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent12);

        JButton opponent13 = new JButton(symbol[13]);
        opponent13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent13);

        JButton opponent14 = new JButton(symbol[14]);
        opponent14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent14);

        JButton opponent15 = new JButton(symbol[15]);
        opponent15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent15);

        JButton opponent16 = new JButton(symbol[16]);
        opponent16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent16);

        JButton opponent17 = new JButton(symbol[17]);
        opponent17.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent17);

        JButton opponent18 = new JButton(symbol[18]);
        opponent18.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent18);

        JButton opponent19 = new JButton(symbol[19]);
        opponent19.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent19);

        JButton opponent20 = new JButton(symbol[20]);
        opponent20.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent20);

        JButton opponent21 = new JButton(symbol[21]);
        opponent21.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent21);

        JButton opponent22 = new JButton(symbol[22]);
        opponent22.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent22);

        JButton opponent23 = new JButton(symbol[23]);
        opponent23.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent23);

        JButton opponent24 = new JButton(symbol[24]);
        opponent24.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent24);

        JButton opponent25 = new JButton(symbol[25]);
        opponent25.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent25);

        JButton opponent26 = new JButton(symbol[26]);
        opponent26.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent26);

        JButton opponent27 = new JButton(symbol[27]);
        opponent27.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent27);

        JButton opponent28 = new JButton(symbol[28]);
        opponent28.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent28);

        JButton opponent29 = new JButton(symbol[29]);
        opponent29.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent29);

        JButton opponent30 = new JButton(symbol[30]);
        opponent30.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent30);

        JButton opponent31 = new JButton(symbol[31]);
        opponent31.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent31);

        JButton opponent32 = new JButton(symbol[32]);
        opponent32.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent32);

        JButton opponent33 = new JButton(symbol[33]);
        opponent33.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent33);

        JButton opponent34 = new JButton(symbol[34]);
        opponent34.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent34);

        JButton opponent35 = new JButton(symbol[35]);
        opponent35.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent35);

        JButton opponent36 = new JButton(symbol[36]);
        opponent36.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent36);

        JButton opponent37 = new JButton(symbol[37]);
        opponent37.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent37);

        JButton opponent38 = new JButton(symbol[38]);
        opponent38.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent38);

        JButton opponent39 = new JButton(symbol[39]);
        opponent39.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent39);

        JButton opponent40 = new JButton(symbol[40]);
        opponent40.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent40);

        JButton opponent41 = new JButton(symbol[41]);
        opponent41.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent41);

        JButton opponent42 = new JButton(symbol[42]);
        opponent42.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent42);

        JButton opponent43 = new JButton(symbol[43]);
        opponent43.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent43);

        JButton opponent44 = new JButton(symbol[44]);
        opponent44.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent44);

        JButton opponent45 = new JButton(symbol[45]);
        opponent45.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent45);

        JButton opponent46 = new JButton(symbol[46]);
        opponent46.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent46);

        JButton opponent47 = new JButton(symbol[47]);
        opponent47.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent47);

        JButton opponent48 = new JButton(symbol[48]);
        opponent48.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent48);

        JButton opponent49 = new JButton(symbol[49]);
        opponent49.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent49);

        JButton opponent50 = new JButton(symbol[50]);
        opponent50.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent50);

        JButton opponent51 = new JButton(symbol[51]);
        opponent51.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent51);

        JButton opponent52 = new JButton(symbol[52]);
        opponent52.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent52);

        JButton opponent53 = new JButton(symbol[53]);
        opponent53.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent53);

        JButton opponent54 = new JButton(symbol[54]);
        opponent54.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent54);

        JButton opponent55 = new JButton(symbol[55]);
        opponent55.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent55);

        JButton opponent56 = new JButton(symbol[56]);
        opponent56.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent56);

        JButton opponent57 = new JButton(symbol[57]);
        opponent57.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent57);

        JButton opponent58 = new JButton(symbol[58]);
        opponent58.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent58);

        JButton opponent59 = new JButton(symbol[59]);
        opponent59.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent59);

        JButton opponent60 = new JButton(symbol[60]);
        opponent60.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent60);

        JButton opponent61 = new JButton(symbol[61]);
        opponent61.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent61);

        JButton opponent62 = new JButton(symbol[62]);
        opponent62.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent62);

        JButton opponent63 = new JButton(symbol[63]);
        opponent63.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        opponentPane.add(opponent63);

        JPanel boardPane = new JPanel(new GridLayout(8, 8));
        border = BorderFactory.createMatteBorder(20, 20, 20, 20, new Color(0, 200, 220));
        boardPane.setBorder(border);

        JButton[] player = new JButton[64];
        for(int i = 0; i < 64; i++) {
            player[i] = new JButton(symbol[i]);
            boardPane.add(player[i]);
        }

        /*JButton player0 = new JButton(symbol[0]);
        player0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(game.equals("init")) {

                }
            }
        });
        boardPane.add(player0);

        JButton player1 = new JButton(symbol[1]);
        player1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player1);

        JButton player2 = new JButton(symbol[2]);
        player2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player2);

        JButton player3 = new JButton(symbol[3]);
        player3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player3);

        JButton player4 = new JButton(symbol[4]);
        player4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player4);

        JButton player5 = new JButton(symbol[5]);
        player5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player5);

        JButton player6 = new JButton(symbol[6]);
        player6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player6);

        JButton player7 = new JButton(symbol[7]);
        player7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player7);

        JButton player8 = new JButton(symbol[8]);
        player8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player8);

        JButton player9 = new JButton(symbol[9]);
        player9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player9);

        JButton player10 = new JButton(symbol[10]);
        player10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player10);

        JButton player11 = new JButton(symbol[11]);
        player11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player11);

        JButton player12 = new JButton(symbol[12]);
        player12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player12);

        JButton player13 = new JButton(symbol[13]);
        player13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player13);

        JButton player14 = new JButton(symbol[14]);
        player14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player14);

        JButton player15 = new JButton(symbol[15]);
        player15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player15);

        JButton player16 = new JButton(symbol[16]);
        player16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player16);

        JButton player17 = new JButton(symbol[17]);
        player17.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player17);

        JButton player18 = new JButton(symbol[18]);
        player18.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player18);

        JButton player19 = new JButton(symbol[19]);
        player19.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player19);

        JButton player20 = new JButton(symbol[20]);
        player20.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player20);

        JButton player21 = new JButton(symbol[21]);
        player21.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player21);

        JButton player22 = new JButton(symbol[22]);
        player22.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player22);

        JButton player23 = new JButton(symbol[23]);
        player23.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player23);

        JButton player24 = new JButton(symbol[24]);
        player24.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player24);

        JButton player25 = new JButton(symbol[25]);
        player25.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player25);

        JButton player26 = new JButton(symbol[26]);
        player26.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player26);

        JButton player27 = new JButton(symbol[27]);
        player27.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player27);

        JButton player28 = new JButton(symbol[28]);
        player28.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player28);

        JButton player29 = new JButton(symbol[29]);
        player29.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player29);

        JButton player30 = new JButton(symbol[30]);
        player30.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player30);

        JButton player31 = new JButton(symbol[31]);
        player31.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player31);

        JButton player32 = new JButton(symbol[32]);
        player32.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player32);

        JButton player33 = new JButton(symbol[33]);
        player33.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player33);

        JButton player34 = new JButton(symbol[34]);
        player34.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player34);

        JButton player35 = new JButton(symbol[35]);
        player35.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player35);

        JButton player36 = new JButton(symbol[36]);
        player36.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player36);

        JButton player37 = new JButton(symbol[37]);
        player37.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player37);

        JButton player38 = new JButton(symbol[38]);
        player38.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player38);

        JButton player39 = new JButton(symbol[39]);
        player39.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player39);

        JButton player40 = new JButton(symbol[40]);
        player40.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player40);

        JButton player41 = new JButton(symbol[41]);
        player41.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player41);

        JButton player42 = new JButton(symbol[42]);
        player42.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player42);

        JButton player43 = new JButton(symbol[43]);
        player43.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player43);

        JButton player44 = new JButton(symbol[44]);
        player44.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player44);

        JButton player45 = new JButton(symbol[45]);
        player45.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player45);

        JButton player46 = new JButton(symbol[46]);
        player46.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player46);

        JButton player47 = new JButton(symbol[47]);
        player47.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player47);

        JButton player48 = new JButton(symbol[48]);
        player48.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player48);

        JButton player49 = new JButton(symbol[49]);
        player49.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player49);

        JButton player50 = new JButton(symbol[50]);
        player50.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player50);

        JButton player51 = new JButton(symbol[51]);
        player51.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player51);

        JButton player52 = new JButton(symbol[52]);
        player52.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player52);

        JButton player53 = new JButton(symbol[53]);
        player53.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player53);

        JButton player54 = new JButton(symbol[54]);
        player54.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player54);

        JButton player55 = new JButton(symbol[55]);
        player55.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player55);

        JButton player56 = new JButton(symbol[56]);
        player56.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player56);

        JButton player57 = new JButton(symbol[57]);
        player57.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player57);

        JButton player58 = new JButton(symbol[58]);
        player58.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player58);

        JButton player59 = new JButton(symbol[59]);
        player59.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player59);

        JButton player60 = new JButton(symbol[60]);
        player60.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player60);

        JButton player61 = new JButton(symbol[61]);
        player61.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player61);

        JButton player62 = new JButton(symbol[62]);
        player62.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player62);

        JButton player63 = new JButton(symbol[63]);
        player63.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        boardPane.add(player63);*/

        JPanel pane = new JPanel(new GridBagLayout());
        pane.setBackground(new Color(0, 250, 0));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridy = c.gridx = 0;
        c.ipady = 100;
        pane.add(opponentPane, c);
        c.gridx++;
        pane.add(boardPane, c);

        jf.add(pane);
        jf.setVisible(true);



    }

}
