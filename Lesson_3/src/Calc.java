public class Calc {

    public static <E extends Number> double sum(E numA, E numB) {
        return numA.doubleValue() + numB.doubleValue();
    }

    public static <E extends Number> double multiply(E numA, E numB) {
        return numA.doubleValue() * numB.doubleValue();
    }

    public static <E extends Number> double divide(E numA, E numB) {
        if(numB.doubleValue() == 0){
            System.out.println("Деление на ноль");
        }
        return numA.doubleValue() / numB.doubleValue();
    }

    public static <E extends Number> double subtract(E numA, E numB) {
        return numA.doubleValue() - numB.doubleValue();
    }
}
