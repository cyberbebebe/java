import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        int studentNumber = 16;

        int C3 = studentNumber % 3;
        int C17 = studentNumber % 17;

        System.out.println("C3: " + C3 + ", тип текстових змінних: String ");
        System.out.println("C17: " + C17 + ", дія з текстом: в кожному слові заданого тексту, видалити всі попередні входження останньої літери цього слова. ");

        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть текст: ");
        String text = sc.nextLine();
        sc.close();

        String processedText = processText(text);

        System.out.println(processedText);
    }

    // Метод для обробки тексту
    private static String processText(String text) {
        String result = ""; 
        String word = ""; 

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (Character.isLetter(currentChar)) {
               
                word += currentChar;
            } else {
                
                if (!word.isEmpty()) {
                    result += processWord(word);
                    word = ""; 
                }
                // Append the non-letter character (space or punctuation) to the result
                result += currentChar;
            }
        }

        // Process the last word if there is one
        if (!word.isEmpty()) {
            result += processWord(word);
        }

        return result;
    }

    // Метод для обробки слова
    private static String processWord(String word) {
        if (word.isEmpty()) {
            return word;
        }

        char lastLetter = word.charAt(word.length() - 1); // Остання буква в слові
        String newWord = "";

        // Видалення всіх попередніх входжень букв як остання
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) != lastLetter) {
                newWord += word.charAt(i);
            }
        }

        // Append the last letter
        newWord += lastLetter;

        return newWord;
    }
}