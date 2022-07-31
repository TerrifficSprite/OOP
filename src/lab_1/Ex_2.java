package lab_1;import library.MyUtils;

public class Ex_2 {
    private static final int MIN = 1, MAX = 6;
    private static final float DX = 0.2f;
    static MyUtils lib = new MyUtils();

    public static void calculateWhileMethod(int min, int max, float step) {
        float cur = min;
        System.out.println("Результати обчислення функцiї y=lg(x) \n" +
                "на промiжку [1, 6] з кроком 0.2");
        System.out.println("x\t\ty=lg(x)\n" +
                "---\t\t-----");
        while (cur <= max) {
            System.out.printf("%.1f\t\t%.3f\n", cur, calculateY(cur));
            cur += step;
            cur = (float) Math.round(cur * 100) / 100;
        }
        System.out.println("Виконано циклом While");
    }
    public static void calculateDoWhileMethod(int min, int max, float step) {
        float cur = min;
        System.out.println("Результати обчислення функцiї y=lg(x) \n" +
                "на промiжку [1, 6] з кроком 0.2");
        System.out.println("x\t\ty=lg(x)\n" +
                "---\t\t-----");
        do {
            System.out.printf("%.1f\t\t%.3f\n", cur, calculateY(cur));
            cur += step;
            cur = (float) Math.round(cur * 100) / 100;
        } while (cur <= max);
        System.out.println("Виконано циклом Do-While");
    }
    public static float calculateY(float x) {
        return (float) Math.log(x);
    }
    public static void main(String[] args) {
        while (true){
            int menuChoice = lib.soutMenu("""
                ************************
                \t\tМеню
                Обчислити циклом While - 1
                Обчислити циклом Do-While - 2
                Вийти - 3""");
            if(menuChoice == 3)
                break;
            if(menuChoice == 1)
                calculateWhileMethod(MIN, MAX, DX);
            if(menuChoice == 2)
                calculateDoWhileMethod(MIN, MAX, DX);
            else if(menuChoice != 1)
                continue;
        }
    }
}
