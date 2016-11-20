/**
 * Created by F_Aredakov on 16.11.2016.
 */
public class Account {
    public int amount = 0;
   public Account () {
       amount = 100;
   }

    public int SubstractAmount(Integer sum) {
        amount = amount - sum;
        return amount;
    }

   public int GetAmount() {
       return amount;
   }
}
