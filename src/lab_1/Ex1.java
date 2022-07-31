package lab_1;
import library.MyUtils;
public class Ex1 {

    public static void main(String[] args) {

        while (true) {
            int menuChoice = MyUtils.soutMenu("""
                ************************
                \t\tМеню
                Перейти до обчислень - 1
                Вийти - 2""");
            if (menuChoice == 2) {
                break;
            } else if (menuChoice != 1) {
                continue;
            }
            /* Початок обчислень */
            switch (MyUtils.getNumFromKeyboard("Введіть номер студента: ")) {
                case 1 -> System.out.println("Беліч Олександр");
                case 2 -> System.out.println("Глинський Петро");
                case 3 -> System.out.println("Григоращук Олександр");
                case 4 -> System.out.println("Ісопеску Михайло");
                case 5 -> System.out.println("Кожокар Діана");
                case 6 -> System.out.println("Няйко Андрій");
                case 7 -> System.out.println("Пепін Євген");
                case 8 -> System.out.println("Софроній Михайло");
                case 9 -> System.out.println("Топало Василь");
                case 10 -> System.out.println("Чорний Максим");
                default -> System.out.println("Студента з таким номером не існує!");
            }
            /* Кінець обчислень */
        }
    }
}
