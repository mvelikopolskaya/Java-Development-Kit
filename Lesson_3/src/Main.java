public class Main {
    public static void main(String[] args) {
//Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
//sum(), multiply(), divide(), subtract().
//Параметры этих методов – два числа разного типа, над которыми должна быть произведена операция.
        System.out.println(Calc.sum(2, 5.5));
        System.out.println(Calc.multiply(11, 3));
        System.out.println(Calc.divide(20, 40));
        System.out.println(Calc.subtract(12, 18));

//Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true,
//если они одинаковые, и false в противном случае.
//Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа по парно по индексам.
//То есть тип элемента в первом массиве под нулевым индексом такой же как тип элемента во втором массиве под нулевым индексом
//(и под всеми остальными индексами аналогично)
        Integer[] arrInt1 = {1, 2, 3};
        Integer[] arrInt2 = {4, 5, 6};
        String[] arrString1 = {"one", "two", "tree"};
        String[] arrString2 = {"four", "five", "six", "seven"};

        System.out.println(CompareArrays.compareArrays(arrInt1, arrInt2));
        System.out.println(CompareArrays.compareArrays(arrString1, arrInt1));
        System.out.println(CompareArrays.compareArrays(arrString1, arrString2));

//Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
//Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары,
//а также переопределение метода toString(), возвращающее строковое представление пары.
        Pair<Integer, String> pair1 = new Pair<>(1, "one");
        Pair pair2 = new Pair<>("Hello", "world");
        System.out.println(pair1);
        System.out.println(pair2);
    }
}