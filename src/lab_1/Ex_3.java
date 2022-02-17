package lab_1;
import library.MyLibrary;
import java.util.Arrays;
import java.util.Random;

public class Ex_3 {
    private static MyLibrary lib = new MyLibrary();
    private static Random random = new Random();
    private static int MIN = -100, MAX = 100;
    public static int[] getNumbersFromKeyboard(int length) {
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = lib.getNumFromKeyboard("Введiть " + (i + 1) + " елемент масиву: ");
        }
        return numbers;
    }
    public static int[] getRandomNumbers(int length) {
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = random.nextInt(MIN, MAX);
        }
        return numbers;
    }

    public static int sumBeetweenPositiveNums(int[] array) {
        int indexFirst = -1, indexSecond = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                if (indexFirst == -1)
                    indexFirst = i;
                else {
                    indexSecond = i;
                    break;
                }
            }
        }
        if (indexFirst == -1) {
            System.out.println("В масивi немає додатніх елементiв!");
            return 2;
        }else if (indexSecond == -1) {
            System.out.println("Додатній елемент елемент тiльки один");
            return 1;
        }
        int sum = 0;
        for (int i = indexFirst+1; i < indexSecond; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        while (true){
            int menuChoice = lib.soutMenu("""
                ************************
                \t\tМеню
                Ввести дані з клавіатури - 1
                Заповнити дані випадковими числами - 2
                Вийти - 3""");
            int n;
            n = lib.getNumFromKeyboard("Введіть довжину масиву: ");
            if(n < 1){
                System.out.println("Довжина масиву не може бути менше за 1");
                continue;
            }
            int[] array = new int[n];
            if(menuChoice == 3)
                break;
            if(menuChoice == 1)
                array = getNumbersFromKeyboard(n);
            if(menuChoice == 2)
                array = getRandomNumbers(n);
            else if(menuChoice != 1)
                continue;
            /* Початок обчислень */
            System.out.println("Готовий масив: " + Arrays.toString(array));
            System.out.println("Максимальний елемент масиву: " + Arrays.stream(array).max().getAsInt());
            if(sumBeetweenPositiveNums(array) <= 0)
                System.out.println("Cумa елементів масиву, розташованих між першим й другим додатними елементами: "
                        + sumBeetweenPositiveNums(array));
            /* Кінець обчислень */
        }
    }
}
