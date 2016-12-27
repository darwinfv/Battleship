import java.util.concurrent.TimeUnit;

/**
 * Created by Darwin Vaz on 12/26/2016.
 */

public class Bot extends Game{

    //The array that keeps track of what each button of the opponent's board refers to
    static int[] pieces = new int[64];

    //The method which randomly places ships to the opponent's board
    public static void place() {

        int n;
        int end;
        int[] a;
        int count = 0;

        //Places ship 1
        pieces[n = random(64)] = 2;
        a = findButton2(n);
        pieces[a[random(a.length)]] = 2;

        //Places ship 2 and 3
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

        try {
            TimeUnit.MILLISECONDS.sleep(random(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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

}
