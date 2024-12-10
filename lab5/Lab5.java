import java.util.Scanner;

/**
 * Головний клас програми, що створює салат із заданих інгредієнтів.
 *
 * <p>Користувач вводить вагу овочів, після чого програма обчислює загальну
 * калорійність салату, сортує інгредієнти за калорійністю та знаходить овочі
 * у заданому діапазоні калорійності.</p>
 */
public class Lab5 {
    public static void main(String[] args) {

        int studentNumber = 16;
        int C13 = 16%13;

        System.out.println("C13:" + C13 + "; Визначити ієрархію овочів. Зробити салат. Порахувати калорійність салату. Провести сортування овочів для салату на основі одного з параметрів. Знайти овоч у салаті, що відповідає заданому діапазону калорійності");

        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть вагу інгредієнтів (у грамах)");

        System.out.print("Скільки грамів помідорів додати? ");
        double tomatoWeight = sc.nextDouble();

        System.out.print("Скільки грамів огірків додати? ");
        double cucumberWeight = sc.nextDouble();

        System.out.print("Скільки грамів моркви додати? ");
        double carrotWeight = sc.nextDouble();

        Salad salad = new Salad();

        salad.addIngredient(new Tomato(tomatoWeight));
        salad.addIngredient(new Cucumber(cucumberWeight));
        salad.addIngredient(new Carrot(carrotWeight));

        System.out.println("Склад салату:");
        salad.print();

        System.out.printf("Загальна калорійність: %.2f ккал%n", salad.calculateTotalCalories());

        System.out.println("\nСортування за калорійністю:");
        salad.sortIngredients();
        salad.print();

        System.out.println("\nЗадайте діапазон калорій");

        System.out.print("Мінімум калорій: ");
        double minCalories = sc.nextDouble();

        System.out.print("Максимум калорій: ");
        double maxCalories = sc.nextDouble();

        System.out.println("\nІнгредієнти в заданому діапазоні калорій:");
        salad.findByCalories(minCalories, maxCalories).forEach(System.out::println);

    }
}