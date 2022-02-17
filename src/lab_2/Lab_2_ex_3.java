package lab_2;

import library.MyLibrary;

import java.io.*;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Lab_2_ex_3 {
    static MyLibrary lib = new MyLibrary();
    static boolean flag = false;
    static BufferedReader reader;
    static BufferedWriter writer;

    public static void main(String[] args) throws IOException {
        while (true){
            int choice = lib.soutMenu("""
                    ************************
                    \t\tМеню
                    Перейти до обчислень - 1
                    Вийти - 2 """);
            switch (choice){
                case 1:
                    try {
                        reader = new BufferedReader(new FileReader("lab_2_ex_3_input.txt"));
                        String str;
                        String[] array = null;
                        while ((str = reader.readLine()) != null)
                            array = str.split("\\s|:|,|-");
                        reader.close();
                        writer = new BufferedWriter(new FileWriter("lab_2_ex_3_output.txt"));
                        for (String s: array){
                            boolean badWord = false;
                            String[] word = s.toLowerCase(Locale.ROOT).split("");
                            for (int i = 0, j = word.length-1; i < s.length(); i++, j--) {
                                if(!word[i].equals(word[j])){
                                    badWord = true;
                                    break;
                                }
                            }
                            if(badWord){
                                System.out.print(s + " ");
                                writer.write(s + " ");
                            }
                        }
                        writer.close();
                        System.out.println();
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
