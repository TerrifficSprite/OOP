package lab_2;

import java.io.*;

public final class FileWork {

    private FileWork() {
        throw new IllegalStateException("Це допоміжний класс");
    }

    public static String[] readFromFile(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String str;
            String[] array = null;
            while ((str = reader.readLine()) != null) {
                array = str.split("");
            }
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
        return new String[0];
    }
}
