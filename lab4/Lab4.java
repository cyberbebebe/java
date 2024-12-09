import java.util.Scanner;

/**
 * Основний клас для виконання обробки тексту.
 */
public class Lab4 {
    public static void main(String[] args) {

        // Зчитування тексту від користувача
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть текст: ");
        String inputText = sc.nextLine();
        sc.close();

        // Обробка тексту
        Text text = new Text(inputText);
        String processedText = text.getProcessedText();

        // Виведення результату
        System.out.println("Оброблений текст:");
        System.out.println(processedText);
    }
}
