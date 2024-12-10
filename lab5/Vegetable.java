import java.util.Comparator;

/**
 * Абстрактний клас, що представляє овоч.
 * Включає вагу, калорійність і методи для розрахунку калорійності овочу.
 */
abstract class Vegetable implements Comparable<Vegetable> {
    private String name;
    private double weight; // Вага (г)
    private double caloriesPer100g; // Калорійність (на 100 г)

    /**
     * Конструктор для створення овочу.
     *
     * @param name Назва овочу
     * @param weight Вага овочу у грамах
     * @param caloriesPer100g Калорійність на 100 г
     */
    public Vegetable(String name, double weight, double caloriesPer100g) {
        this.name = name;
        this.weight = weight;
        this.caloriesPer100g = caloriesPer100g;
    }

    /**
     * Обчислює загальну калорійність овочу.
     *
     * @return Кількість калорій на задану вагу продукту
     */
    public double getTotalCalories() {
        return (weight / 100) * caloriesPer100g;
    }

    @Override
    public int compareTo(Vegetable other) {
        return Double.compare(this.getTotalCalories(), other.getTotalCalories());
    }

    @Override
    public String toString() {
        return name + ": вага = " + weight + " г, калорійність = " + getTotalCalories() + " ккал";
    }
}