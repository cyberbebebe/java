/**
 * Клас, що описує косметику.
 */
public class Cosmetic {
    private String name;        // Назва
    private String brand;       // Бренд
    private double price;       // Ціна
    private int volume;         // Об'єм
    private boolean isOrganic;  // Чи є органічною

    /**
     * Конструктор класу Cosmetic.
     *
     * @param name       назва
     * @param brand      бренд
     * @param price      ціна
     * @param volume     об'єм
     * @param isOrganic  чи є органічною
     */
    public Cosmetic(String name, String brand, double price, int volume, boolean isOrganic) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.volume = volume;
        this.isOrganic = isOrganic;
    }

    // Геттери для доступу до полів
    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isOrganic() {
        return isOrganic;
    }

    // Метод для порівняння об'єктів Cosmetic
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cosmetic cosmetic = (Cosmetic) obj;
        return Double.compare(cosmetic.price, price) == 0 &&
                volume == cosmetic.volume &&
                isOrganic == cosmetic.isOrganic &&
                name.equals(cosmetic.name) &&
                brand.equals(cosmetic.brand);
    }

    // Метод для нормального відображення інформації про об'єкт замість Cosmetic+@hash
    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", volume=" + volume +
                ", isOrganic=" + isOrganic +
                '}';
    }
}
