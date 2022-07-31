package lab_1;
import library.MyUtils;
import java.util.Random;

public class Ex_4 {
    static MyUtils lib = new MyUtils();
    private static void print_arr(int[][] array, int m, int n, String text) {
        System.out.println(text);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(j == 0)
                    System.out.print("[");
                if (j == n - 1) {
                    int temp = array[i][j];
                    if(Integer.toString(temp).length() == 1)
                        System.out.print("  " + temp);
                    else if(Integer.toString(temp).length() == 2)
                        System.out.print(" " + temp);
                    else
                        System.out.print(temp);
                }
                else
                    System.out.print(array[i][j] + "   \t");
            }
            System.out.println("]");
        }
    }

    public static int[][] getFromKeyboard(int m, int n) {
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = lib.getNumFromKeyboard("Введiть елемент [" + i + ", " + j + "]: ");
            }
            System.out.println();
        }
        return array;
    }

    public static int[][] getByRandom(int m, int n) {
        Random random = new Random();
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = random.nextInt(-100, 100);
            }
        }
        return array;
    }

    public static int[][] deleteHighest(int[][] array, int m, int n){
        int max = array[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(array[i][j] > max)
                    max = array[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(array[i][j] == max)
                    array[i][j] = 0;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        while (true){
            boolean keyboardChoice = false;
            int menuChoice = lib.soutMenu("""
                    ************************
                    \t\tМеню
                    Перейти до обчислень методом вводу з клавiатури - 1
                    Перейти до обчислень методом випадкових чисел - 2
                    Вийти - 3""");
            int n, m;
            n = lib.getNumFromKeyboard("Введiть довжину масиву: ");
            m = lib.getNumFromKeyboard("Введiть висоту масиву: ");
            if(n < 1 || m < 1){
                System.out.println("Довжина та висота масиву не можуть бути менше за 1");
                continue;
            }
            int[][] array;
            if(menuChoice == 3)
                break;
            if(menuChoice == 1)
                keyboardChoice = true;
            else if(menuChoice != 2)
                continue;
            /* Початок обчислень */
            array = keyboardChoice ? getFromKeyboard(m, n) : getByRandom(m, n);
            print_arr(array, m, n, "Готовий масив: ");
            deleteHighest(array, m, n);
            deleteHighest(array, m, n);
            print_arr(array, m, n, "Відредагований масив: ");
            /* Кінець обчислень */
        }
    }
}
