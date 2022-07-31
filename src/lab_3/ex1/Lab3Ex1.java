package lab_3.ex1;

import library.FileWork;
import library.MyUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Lab3Ex1 {

    private static final String PATH = "database.txt";

    private static List<Book> convertArray(String[] str) {
        List<Book> books = new ArrayList<>();
        for (String word: str) {
            books.add(stringToClass(word));
        }
        return books;
    }

    private static Book stringToClass(String str) {
        String[] arr = str.split(", ");
        return new Book(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]));
    }

    public static void main(String[] args) {
        boolean flag = false;
        do {
            int choice = MyUtils.soutMenu("""
                    ************************
                    \t\tМеню
                    Перейти до обчислень - 1
                    Вийти - 2""");
            switch (choice) {
                case 1:
                    String[] array = FileWork.readFromFile(PATH);
                    List<Book> list = convertArray(array);
                    Collections.sort(list);
                    list.stream().filter(x -> x.getName().toLowerCase(Locale.ROOT)
                            .contains("програмування")).forEach(System.out::println);
                    break;
                case 2:
                    flag = true;
                    break;
                default: System.out.println("Такого пункту меню не існує!");
            }
        } while (!flag);
    }

}
