import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        int studentNumber = 16;

        int C3 = studentNumber % 3;
        int C17 = studentNumber % 17;

        // Прінт варіанту
        System.out.println("C3: " + C3 + ", тип текстових змінних: String ");
        System.out.println("C17: " + C17 + ", дія з текстом: в кожному слові заданого тексту, видалити всі попередні входження останньої літери цього слова. ");

        // Інпут тексту
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть текст: ");
        String text = sc.nextLine();
        sc.close();

        // Обробка тексту
        String processedText = processText(text);

        System.out.println(processedText);
    }

    // Метод для обробки тексту
    private static String processText(String text) {
        // Поділ тексту на слова ТА розділові знаки
        String[] words = text.split("((?<=\\p{Punct})|(?=\\p{Punct})|\\s+)");
        String result = "";

        for (String word : words) {
            if (word.matches("\\p{Punct}|\\s+")) {
                // Дописування розділових знаків в кінцеву строку
                result += word;
            } else {
                // Обробка слова
                char lastLetter = word.charAt(word.length() - 1); // Остання літера
                String newWord = ""; // Пуста змінна для слова з видаленими буквами

                for (int i = 0; i < word.length() - 1; i++) {
                    if (word.charAt(i) != lastLetter) {
                        newWord += word.charAt(i); // Дописування всіх символів слова які не є такими як остання літера
                    }
                }

                // Дописування останньої літери
                newWord += lastLetter;
                // Дописування слова в кінцеву строку
                result += newWord;
            }
        }

        return result;
    }



}
