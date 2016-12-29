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

    //The method which decides whose turn it is to play
    public static void choose() {

        if(game.equals("opponent")) {
            setInstructions("Waiting for bot to make move...");
            delay();
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

    //The method which delays the game by exactly 2 seconds and invokes choose
    public static void delay2() {
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        choose();
    }

}
