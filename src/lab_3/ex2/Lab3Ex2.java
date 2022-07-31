package lab_3.ex2;

import library.FileWork;
import library.MyUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Lab3Ex2 {

    private static final String PATH = "database.txt";

    private static List<PhoneBook> convertArray(String[] str) {
        List<PhoneBook> books = new ArrayList<>();
        for (String word: str) {
            books.add(stringToClass(word));
        }
        return books;
    }

    private static PhoneBook stringToClass(String str) {
        String[] a = str.split(", ");
        return new PhoneBook(a[0], a[1], a[2], a[3], Integer.parseInt(a[4]), a[5]);
    }

    private static String getString(String text) {
        System.out.print(text);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void editByNum(PhoneBook phoneBook) {
        boolean flag = true;
        do {
            int localNum = MyUtils.getNumFromKeyboard("""
                Яке поле хочете редагувати?
                Прiзвище - 1
                Iм'я - 2
                По батькові - 3
                Адреса - 4
                Номер телефону - 5
                Вийти - 6
                """);
            System.out.println("Введiть нове значення: ");
            switch (localNum) {
                case 1: phoneBook.setLastname(getString("")); break;
                case 2: phoneBook.setFirstname(getString("")); break;
                case 3: phoneBook.setFathersname(getString("")); break;
                case 4: phoneBook.setAddress(getString("")); break;
                case 5: phoneBook.setPhoneNumber(MyUtils.getNumFromKeyboard("")); break;
                case 6: flag = false; break;
                default:
                    System.out.println("Такого пункту меню немає!");
                    break;
            }
        } while (flag);
    }

    private static void edit(List<PhoneBook> phoneBooks) {
        int i = 0;
        for (; i < phoneBooks.size(); i++) {
            System.out.printf("%d - %s%n", i + 1, phoneBooks.get(i).toString());
        }
        System.out.println(i + 1 + " - Вийти");
        int edit = MyUtils.getNumFromKeyboard(
                "Виберіть запис який запис хочете редагувати: ");
        if (edit == phoneBooks.size() + 1) {
            return;
        } else if (edit > phoneBooks.size() + 1 || edit < 1) {
            System.out.println("Такого варіанту відповіді немає!");
            return;
        }
        PhoneBook book = phoneBooks.get(edit - 1);
        editByNum(book);
    }

    private static void delete(List<PhoneBook> phoneBooks) {
        int a = 1;
        for (PhoneBook p : phoneBooks) {
            System.out.println(a + " - " + p.printView());
            a++;
        }
        System.out.println(a + " - Вийти");
        int deleteChoice = MyUtils
                .getNumFromKeyboard("Виберiть запис який хочете видалити: ");
        if (deleteChoice == a) {
            return;
        }
        phoneBooks.remove(deleteChoice - 1);
        System.out.println("Запис успiшно видалено!");
    }

    public static void main(String[] args) {
        String[] arr = FileWork.readFromFile(PATH);
        List<PhoneBook> phoneBooks = convertArray(arr);
        boolean flag = false;
        do {
            int choice = MyUtils.soutMenu("""
                    ************************
                    \t\tМеню
                    Додати записи - 1
                    Редагувати записи - 2
                    Видалити записи - 3
                    Виведення інформації на екран - 4
                    Пошук інформації за прізвищем - 5
                    Вийти - 6""");
            switch (choice) {
                case 1:
                    PhoneBook book = new PhoneBook(
                            getString("Введіть прізвище: "),
                            getString("Введіть ім'я: "),
                            getString("Введіть по батькові: "),
                            getString("Введіть адресу: "),
                            MyUtils.getNumFromKeyboard("Введіть номер телефону: "));
                    FileWork.appendToFile(PATH, book.toString());
                    System.out.println("Запис успішно добавлено!");
                    break;
                case 2:
                    phoneBooks = convertArray(FileWork.readFromFile(PATH));
                    edit(phoneBooks);
                    FileWork.writeToFile(PATH, phoneBooks);
                    break;
                case 3:
                    phoneBooks = convertArray(FileWork.readFromFile(PATH));
                    delete(phoneBooks);
                    FileWork.writeToFile(PATH, phoneBooks);
                    break;
                case 4:
                    phoneBooks = convertArray(FileWork.readFromFile(PATH));
                    Collections.sort(phoneBooks);
                    for (PhoneBook p: phoneBooks) {
                        System.out.println(p.printView());
                    }
                    break;
                case 5:
                    phoneBooks = convertArray(FileWork.readFromFile(PATH));
                    String word = getString("Введіть текст для пошуку: ");
                    for (PhoneBook b: phoneBooks) {
                        if (b.getLastname().contains(word)) {
                            System.out.println(b.printView());
                        }
                    }
                    break;
                case 6:
                    flag = true;
                    break;
                default: System.out.println("Такого пункту меню не існує!");
            }
        } while (!flag);
    }


}
