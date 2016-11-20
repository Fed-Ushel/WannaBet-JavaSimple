import java.io.Console;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by F_Aredakov on 16.11.2016.
 */
public class RunGame {

    private static final String INPUT_COUNT_OF_PLAYERS = "Введите количество игроков";

    public static void main (String[] args)  {

        WannaBetGame game = new WannaBetGame(GameHelper.ReadInt(INPUT_COUNT_OF_PLAYERS, 2, 10));
        System.out.println("Players:" + game.numOfPlayers);




        for (int i = 0; i < game.numOfPlayers; i++) {
            game.players[i] = new Player("Player"+(i+1));
        }
        game.RunGame(game.players);




      //  p1.doBet();
        /*

        while (((p1.account.GetAmount() > 0) && (  p2.account.GetAmount() >0 ))
        && (p1.account.GetAmount() < 200) && (  p2.account.GetAmount() < 200 )){

       // for (int i = 0; i < 10; i++) {
           System.out.println("Dice: " + GameHelper.RollDice());
            p1.account.SubstractAmount(dice.RollDice());
            p2.account.SubstractAmount(dice.RollDice());
            p1.PrintAmount();
            p2.PrintAmount();

        }
        */
    }



}
