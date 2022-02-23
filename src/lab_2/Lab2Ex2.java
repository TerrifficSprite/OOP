package lab_2;
import library.MyLibrary;
import java.io.*;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Lab2Ex2 {

    public static void main(String[] args) throws IOException {
        boolean flag = false;

        while (true) {
            int e = 0;
            int y = 0;
            int u = 0;
            int i = 0;
            int o = 0;
            int a = 0;
            int choice = MyLibrary.soutMenu("""
                    ************************
                    \t\tМеню
                    Перейти до обчислень - 1
                    Вийти - 2""");
            switch (choice) {
                case 1:
                    String[] array = FileWork.readFromFile("lab_2_ex_2.txt");
                    array = array == null ? new String[0] : array;
                    for (String ch: array) {
                        switch (ch) {
                            case "a" -> a++;
                            case "e" -> e++;
                            case "y" -> y++;
                            case "u" -> u++;
                            case "i" -> i++;
                            case "o" -> o++;
                        }
                    }
                    System.out.println("Кількість голосних букв в тексті: "
                            + Arrays.stream(array).filter(x -> Pattern.matches("[eyuioa]", x))
                            .count());
                    System.out.printf("a - %d, e - %d, i - %d, u - %d, o - %d, y - %d\n",
                            a, e, i, u, o, y);
                    break;
                case 2:
                    flag = true;
                    break;
                default:
                    continue;
            }
            if (flag) {
                break;
            }
        }
    }
}
