package lab_2;

import library.MyLibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Lab_2_ex_1 {
    static MyLibrary lib = new MyLibrary();
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            List<String> strings = new ArrayList<>();
            int choice = lib.soutMenu("""
                    ************************
                    \t\tМеню
                    Перейти до обчислень - 1
                    Вийти - 2 """);
            switch (choice){
                case 1:
                    System.out.print("Введіть текст: ");
                    String str = scanner.nextLine();
                    String[] splitted_text = str.split("");
                    int counter = 0;
                    for (String ch: splitted_text) {
                        if (Pattern.matches("[0-9]", ch))
                            counter++;
                    }
                    System.out.println("Кількість чисел в тексті: " + counter);
                    splitted_text = str.split(" ");
                    System.out.print("Слова які починаються з приголосної букви: ");
                    for (String word: splitted_text) {
                        if(Pattern.matches("[^(aoeiu[0-9])]", String.valueOf(word.toLowerCase(Locale.ROOT).charAt(0))))
                            strings.add(word.trim());
                    }
                    System.out.println(strings);
                    break;
                case 2:
                    flag = true;
                    break;
                default:
                    continue;
            }
            if(flag)
                break;
        }
    }
}
