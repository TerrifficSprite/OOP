package lab_2;

import library.MyLibrary;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Lab_2_ex_2 {
    static MyLibrary lib = new MyLibrary();
    static boolean flag = false;
    static BufferedReader reader;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true){
            int e = 0, y = 0, u = 0, i = 0, o = 0, a = 0;
            int choice = lib.soutMenu("""
                    ************************
                    \t\tМеню
                    Перейти до обчислень - 1
                    Вийти - 2 """);
            switch (choice){
                case 1:
                        try {
                            reader = new BufferedReader(new FileReader("lab_2_ex_2.txt"));
                            String str;
                            String[] array = null;
                            while ((str = reader.readLine()) != null)
                                array = str.split("");
                            reader.close();
                            for (String ch: array) {
                                switch (ch){
                                    case "a":
                                        a++; break;
                                    case "e":
                                        e++; break;
                                    case "y":
                                        y++; break;
                                    case "u":
                                        u++; break;
                                    case "i":
                                        i++; break;
                                    case "o":
                                        o++; break;
                                }
                            }
                            System.out.println("Кількість голосних букв в тексті: " +
                                    Arrays.stream(array).filter(x -> Pattern.matches("[eyuioa]", x)).count());
                            System.out.printf("a - %d, e - %d, i - %d, u - %d, o - %d, y - %d\n",
                                    a, e, i, u, o, y);
                        } catch (FileNotFoundException ef) {
                            System.out.println("Файлу не існує, файл створено!");
                            FileWriter writer = new FileWriter("lab_2_ex_2.txt");
                            writer.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        } catch (NullPointerException exn){
                            System.out.println("Файл пустий!");
                        }
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
