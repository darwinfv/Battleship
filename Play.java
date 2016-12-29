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

}
