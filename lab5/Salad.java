import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * Клас, що представляє салат, який складається з овочів.
 *
 * <p>Клас дозволяє додавати овочі до салату, обчислювати загальну калорійність,
 * сортувати інгредієнти за калорійністю та знаходити овочі у заданому діапазоні калорійності.</p>
 *
 * <p>Основні методи класу:</p>
 * <ul>
 *     <li>{@link #addIngredient(Vegetable)} - додає овоч до салату.</li>
 *     <li>{@link #calculateTotalCalories()} - обчислює загальну калорійність салату.</li>
 *     <li>{@link #sortIngredients()} - сортує інгредієнти за калорійністю.</li>
 *     <li>{@link #findByCalories(double, double)} - знаходить інгредієнти у заданому діапазоні калорій.</li>
 *     <li>{@link #print()} - виводить інгредієнти салату на консоль.</li>
 * </ul>
 */
class Salad {
    private List<Vegetable> ingredients = new ArrayList<>();

    /**
     * Додає овоч до списку інгредієнтів салату.
     *
     * @param vegetable Овоч, який потрібно додати до салату
     */
    public void addIngredient(Vegetable vegetable) {
        ingredients.add(vegetable);
    }

    /**
     * Обчислює загальну калорійність усіх інгредієнтів у салаті.
     *
     * @return Загальна кількість калорій у салаті.
     */
    public double calculateTotalCalories() {
        double totalCalories = 0;
        for (Vegetable veg : ingredients) {
            totalCalories += veg.getTotalCalories();
        }
        return totalCalories;
    }

    /**
     * Сортує інгредієнти салату за зростанням загальної калорійності.
     */
    public void sortIngredients() {
        ingredients.sort(Comparator.comparingDouble(Vegetable::getTotalCalories));

    }

    /**
     * Знаходить інгредієнти, калорійність яких входить у заданий діапазон.
     *
     * @param min Мінімальна кількість калорій.
     * @param max Максимальна кількість калорій.
     * @return Список овочів, калорійність яких відповідає заданому діапазону.
     */
    public List<Vegetable> findByCalories(double min, double max) {
        List<Vegetable> result = new ArrayList<>();
        for (Vegetable veg : ingredients) {
            double calories = veg.getTotalCalories();
            if (calories >= min && calories <= max) {
                result.add(veg);
            }
        }
        return result;
    }

    /**
     * Виводить список інгредієнтів салату в консоль.
     */
    public void print() {
        for (Vegetable veg : ingredients) {
            System.out.println(veg);
        }
    }
}