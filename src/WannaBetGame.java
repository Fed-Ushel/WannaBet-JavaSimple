import java.util.ArrayList;

/**
 * Created by F_Aredakov on 16.11.2016.
 */
public class WannaBetGame {
    Player[] players;
    Integer numOfPlayers;
    private Boolean isFinished = false; //Закончилась ли игра
    private Integer turnCount;   //Количество ходов
    private Integer totalTurnBet; //Суммарная ставка на ход
    private static final Integer MAX_DOTS_TURN = 3;

    private static final String INPUT_PLAYER_BET = "Делайте вашу ставку";
    private static final String INPUT_PLAYER_CHOISE = "Выиграет или нет (1 или 0)";
    private static final String INPUT_PLAYER_BET_REPEAT = "Ставка должна быть больше 0 и меньше половины вашего счета \n";


    public WannaBetGame (Integer num) {
        numOfPlayers = num;
        players = new Player[num];
        turnCount = 1;
        totalTurnBet = 0;

    }

    public void RunGame (Player[] pls) {
        /*
        получили массив игроков и очередность их ходов
        запускаем первого игрока в DoTurn, возвращаем результаты хода.
        Проверяем делаем ли следующий ход (никто не проигрался в ноль)
         */
        int i = 0;

        while (!isFinished) {
            if (i < pls.length) {
                System.out.println("Ход №" + turnCount);
                DoTurn(pls[i]);
                i++;
            }
            else { i = 0;  turnCount++; }
            if (turnCount == 4) {
                isFinished = true;
            }
        }
    }

private void DoTurn(Player pl) {

    totalTurnBet = 0;

    System.out.println("Ходит игрок: " + pl.name);
    System.out.println("Задание: " +  GameHelper.questions.get(GameHelper.RollDice(MAX_DOTS_TURN))[2]);

    //Все игроки кроме исполнителя делают ставки
    for (Player plr: players) {
        if (plr != pl) {
            DoBet(plr);
        }
    }

// Иммитируем выиграл или нет
        pl.winlost = GameHelper.RollDice(1);
        if (pl.winlost == 1) {
            System.out.println("Игрок " + pl.name + " смог!!! И выиграл " + totalTurnBet);
            pl.account.amount += totalTurnBet;
        }
        for (Player plr: players) {
            if (plr != pl) {
                // Проверяем по всвем игрокам выиграли или нет
                if (plr.choice == pl.winlost) {
                      plr.account.amount += plr.bet;
                    System.out.println("Игрок " + plr.name + " выиграл. Счет игрока: " +  plr.account.amount );
                    } else {
                        plr.account.amount -= plr.bet;
                    System.out.println("Игрок " + plr.name + " проиграл. Счет игрока: " +  plr.account.amount );
                }


            }







    }
   // return null;

}
private void DoBet(Player pl) {
    System.out.println("Игрок:" + pl.name);
    System.out.println("Счет игрока:" + pl.account.amount);
    Integer min = pl.account.amount/10;
    Integer max = pl.account.amount/2;
    pl.choice = GameHelper.ReadInt(INPUT_PLAYER_CHOISE, 0, 1);
    System.out.println("Выбор игрока:" + pl.choice);
    pl.bet = GameHelper.ReadInt(INPUT_PLAYER_BET, min, max);
    System.out.println("Ставка игрока:" + pl.bet);
    totalTurnBet += pl.bet;
}

}


