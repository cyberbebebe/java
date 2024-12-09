import java.util.ArrayList;
import java.util.List;

/**
 * Клас Word представляє слово, що складається з літер (char'ів).
 */
public class Word {
    private final List<Letter> letters = new ArrayList<>();

    public Word(String word) {
        for (char c : word.toCharArray()) {
            letters.add(new Letter(c));
        }
    }

    public String getProcessedWord() {
        if (letters.isEmpty()) {
            return "";
        }
        char lastLetter = letters.get(letters.size() - 1).getValue();
        StringBuilder processedWord = new StringBuilder();

        for (int i = 0; i < letters.size() - 1; i++) {
            if (letters.get(i).getValue() != lastLetter) {
                processedWord.append(letters.get(i).getValue());
            }
        }

        processedWord.append(lastLetter);
        return processedWord.toString();
    }
}