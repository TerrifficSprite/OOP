package lab_2;
import library.MyUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Lab2Ex1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;

        while (true) {
            List<String> strings = new ArrayList<>();
            int choice = MyUtils.soutMenu("""
                    ************************
                    \t\tМеню
                    Перейти до обчислень - 1
                    Вийти - 2""");
            switch (choice) {
                case 1:
                    System.out.print("Введіть текст: ");
                    String str = scanner.nextLine();
                    String[] splittedText = str.split("");
                    int counter = 0;
                    for (String ch: splittedText) {
                        if (Pattern.matches("[0-9]", ch)) {
                            counter++;
                        }
                    }
                    System.out.println("Кількість чисел в тексті: " + counter);
                    splittedText = str.split(" ");
                    System.out.print("Слова які починаються з приголосної букви: ");

                    for (String word: splittedText) {
                        if (Pattern.matches("[^(aoeiu[0-9])]",
                                String.valueOf(word.toLowerCase(Locale.ROOT).charAt(0)))) {
                            strings.add(word.trim());
                        }
                    }

                    System.out.println(strings);
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
