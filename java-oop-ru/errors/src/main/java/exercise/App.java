package exercise;

// BEGIN
public class App {
    public static void printSquare(Circle circle){
        try {
            System.out.printf("%d\nВычисление окончено",(int)Math.ceil(circle.getSquare()));
        }catch (NegativeRadiusException e) {
            System.out.println("Не удалось посчитать площадь\nВычисление окончено");
        }

    }
}
// END
