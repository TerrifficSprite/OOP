package lab_2;
import library.MyLibrary;
import java.io.*;
import java.util.Locale;

public class Lab2Ex3 {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer;
        boolean flag = false;

        while (true) {
            int choice = MyLibrary.soutMenu("""
                    ************************
                    \t\tМеню
                    Перейти до обчислень - 1
                    Вийти - 2""");
            switch (choice) {
                case 1:
                    String[] array = FileWork.readFromFile("lab_2_ex_3_input.txt");
                    array = array == null ? new String[0] : array;
                    writer = new BufferedWriter(new FileWriter("lab_2_ex_3_output.txt"));
                    System.out.print("Відредаговане речення: ");
                    writer.write("Відредаговане речення: ");

                    for (String s: array) {
                        boolean badWord = false;
                        String[] word = s.toLowerCase(Locale.ROOT).split("");
                        for (int i = 0, j = word.length - 1; i < s.length(); i++, j--) {
                            if (!word[i].equals(word[j])) {
                                badWord = true;
                                break;
                            }
                        }
                        if (badWord) {
                            System.out.print(s + " ");
                            writer.write(s + " ");
                        }
                    }
                    writer.close();
                    System.out.println();
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
