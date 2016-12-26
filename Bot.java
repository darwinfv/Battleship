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

        //Places ship 1
        pieces[n = random(64)] = 1;
        a = findButton2(n);
        pieces[a[random(a.length)]] = 1;

        //Places ship 2
        pieces[]

    }

    //The method which returns a random integer [0, argument - 1]
    public static int random(int a) {
        int r = (int) (Math.random() * a);
        return r;
    }

}
