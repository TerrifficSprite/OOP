package library;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyLibrary {

    public int soutMenu(String text){
        System.out.println(text);
        int choice = getNumFromKeyboard("");
        System.out.println("************************");
        return choice;
    }

    public int getNumFromKeyboard(String text){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print(text);
            return scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Вводити можна тільки числа!");
        }
        return 0;
    }

    public float round(int to){
return 0;
    }
}
