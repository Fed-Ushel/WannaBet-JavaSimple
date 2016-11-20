/**
 * Created by F_Aredakov on 16.11.2016.
 */
public class Player {
    public String name;
    public Account account;
    public int age; //задания зависят от возраста
    public int bet; //сумма ставки
    public int choice; // сможет игрок или нет (пока 0 или 1)
    public int winlost; //смог или не смог (пока 0 или 1)

    //статистика игрока - 4 типа заданий
    public int strength;
    public int dexterity;
    public int luck;
    public int intelligence;

    public Player(String Name) {
        this.bet = 0;
        this.name = Name;
        this.account = new Account();
    }

    public String GetName(Player pl) {
        return pl.name;
    }
    public int GetAmount() {
        return this.account.GetAmount();
    }

    public void PrintAmount() {
        System.out.println("Account: " + name + " Amount: " + this.account.GetAmount());

    }

    public void doBet() {
        System.out.println(GameHelper.GetUserInput("TEST"));
    }


}
