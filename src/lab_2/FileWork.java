package lab_2;

import java.io.*;

public class FileWork {

    static String[] readFromFile(String path) throws IOException {

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path));
            String str;
            String[] array = null;
            while ((str = reader.readLine()) != null) {
                array = str.split("");
            }
            reader.close();
            return array;
        } catch (FileNotFoundException e) {
            System.out.println("Файлу не існує, файл створено!");
            FileWriter writer = new FileWriter("lab_2_ex_2.txt");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException exn) {
            System.out.println("Файл пустий!");
        }
        return null;
    }

}
