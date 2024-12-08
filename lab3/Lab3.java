import java.util.Arrays;
import java.util.Comparator;

/**
 * Основний клас із виконавчим методом.
 */
public class Lab3 {
    public static void main(String[] args) {
        // Визначення варіанту
        int studentNumber = 16;
        int C11 = studentNumber % 11;

        System.out.println("C11: " + C11 + " - визначити клас косметика, який складається як мінімум з 5-и полів");

        // Створення масиву об'єктів класу Cosmetic
        Cosmetic[] cosmeticsList = {
                new Cosmetic("Шампунь", "Head & Shoulders", 99.99, 200, false),
                new Cosmetic("Тонік", "Nivea", 200.0, 160, true),
                new Cosmetic("Лосьйон", "Neutrogena", 123.99, 140, true),
                new Cosmetic("Крем", "L'Oreal", 155.0, 150, true),
                new Cosmetic("Мило", "Dove", 55.5, 300, false),
        };

        // Сортування за ціною (зростання)
        Arrays.sort(cosmeticsList, Comparator.comparingDouble(Cosmetic::getPrice));

        System.out.println("Сортування за зростанням ціни:");
        for (Cosmetic cosmetic : cosmeticsList) {
            System.out.println(cosmetic);
        }

        // Сортування за об'ємом (спадання)
        Arrays.sort(cosmeticsList, Comparator.comparingInt(Cosmetic::getVolume).reversed());

        System.out.println("\nСортування за спаданням об'єму:");
        for (Cosmetic cosmetic : cosmeticsList) {
            System.out.println(cosmetic);
        }

        // Спробуємо знайти справжню та не справжню косметику
        Cosmetic targetReal = new Cosmetic("Крем", "L'Oreal", 155.0, 150, true);
        Cosmetic targetFake = new Cosmetic("Крем", "Head & Shoulders", 123.99, 300, true);

        System.out.println("\nСпробуємо знайти косметику з справжніми аргументами" + targetReal);
        System.out.println("Спробуємо знайти косметику з фейковими аргументами" + targetFake);

        // Пошук ідентичного об'єкта
        boolean foundReal = false;
        boolean foundFake = false;

        for (Cosmetic cosmetic : cosmeticsList) {
            if (cosmetic.equals(targetReal)) {
                System.out.println("Знайдено косметику: " + cosmetic);
                foundReal = true;
            }
            if (cosmetic.equals(targetFake)) {
                System.out.println("Знайдено косметику: " + cosmetic);
                foundFake = true;
            }
        }

        // Якщо не знайдено, то вивести це
        if (!foundReal) {
            System.out.println("Косметику " + targetReal + " не знайдено.");
        }
        if (!foundFake) {
            System.out.println("Косметику " + targetFake + " не знайдено.");
        }

    }
}
