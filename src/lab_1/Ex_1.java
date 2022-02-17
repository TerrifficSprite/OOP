package lab_1;
import library.MyLibrary;
import java.util.Scanner;
public class Ex_1 {

    static MyLibrary lib = new MyLibrary();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            int menuChoice = lib.soutMenu("""
                ************************
                \t\tМеню
                Перейти до обчислень - 1
                Вийти - 2 """);
            if(menuChoice == 2)
                break;
            else if(menuChoice != 1)
                continue;
            /* Початок обчислень */
            switch (lib.getNumFromKeyboard("Введіть номер студента: ")){
                case 1:
                    System.out.println("Беліч Олександр"); break;
                case 2:
                    System.out.println("Глинський Петро"); break;
                case 3:
                    System.out.println("Григоращук Олександр"); break;
                case 4:
                    System.out.println("Ісопеску Михайло"); break;
                case 5:
                    System.out.println("Кожокар Діана"); break;
                case 6:
                    System.out.println("Няйко Андрій"); break;
                case 7:
                    System.out.println("Пепін Євген"); break;
                case 8:
                    System.out.println("Софроній Михайло"); break;
                case 9:
                    System.out.println("Топало Василь"); break;
                case 10:
                    System.out.println("Чорний Максим"); break;
                default:
                    System.out.println("Студента з таким номером не існує!"); break;
            }
            /* Кінець обчислень */
        }
    }
}
