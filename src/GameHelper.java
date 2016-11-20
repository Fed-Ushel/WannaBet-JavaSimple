import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by F_Aredakov on 16.11.2016.
 */
 public final class GameHelper {


    private static Random rand = new Random();
    /* Задания для игры. потом вынести в базу данных
        У  Заданий 4 категории:
        - Сила
        - Ловкость
        - Удача
         - Интеллект

         Атрибуты задания
         1 - категория
         2- категория возраста
         3 - задание
         4 - ответ
         5 - изображение
         6 - время на исполнение

     */
    public static final  Map<Integer, String[]> questions = new HashMap<>();
    static  {
        questions.put(1, new String[]{"1","1","Подними соседа 10 раз за 30 секунд", "", "image.jpg", "30" });
        questions.put(2, new String[]{"2","1","Стоя на одной ноге подними платок с пола", "", "image.jpg", "30" });
        questions.put(3, new String[]{"3","1","Сколько пальцев на трех руках", "Пятнадцать", "image.jpg", "30" });
        questions.put(4, new String[]{"4","1","Сколько пальцев на четырех руках", "Двадцать", "image.jpg", "30" });
    }

    //input data
    public static String GetUserInput(String prompt) {
        String inputLine = null;
        System.out.println(prompt + ":");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            inputLine =  br.readLine();
            if (inputLine.length() == 0) return null;
        }
             catch (IOException e) {
            e.printStackTrace();
        }
        return inputLine;
    }
    //Проверка на Int
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public  static Integer RollDice(Integer max) {
      /*
       private static Random rand = new Random(); вынесен из метода потому что -
[17:36, 17.11.2016] Александр Шевченко: У тебя живет один маленький Random. Ты им пользуешься. А не тратишь время и память, на создание нового экземпляра каждый раз при вызове этого метода
[17:37, 17.11.2016] Александр Шевченко: Сборщик мусора не сразу убивает отжившие объекты. Поэтому память потихоньку засирается.
[17:37, 17.11.2016] Александр Шевченко: И потом тратится время на сборку мусора
       */

         return (rand.nextInt(max)+1);
    }

    public static int ReadInt(String st,int min, int max) {
        //Получаем с консоли ввод количества игроков и проверяем что введено число Int, ограниченное Min и Max
        boolean isSet = false;
        String input = "";
        Integer  in = 0;
        while (!isSet) {
            System.out.println ("Минимум: " + min + " Максимум : " + max);
            input = GameHelper.GetUserInput(st);
            try {
                in = Integer.parseInt(input);

                if (in >= min && in <= max) isSet = true;

            } catch(NumberFormatException e) {
            } catch(NullPointerException e) {}
        }
        return  in;
    }
}
