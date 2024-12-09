import java.util.ArrayList;
import java.util.List;

/**
 * Клас Sentence представляє речення, яке складається зі слів і розділових знаків.
 */
public class Sentence {
    private final List<String> components = new ArrayList<>();

    public Sentence(String sentence) {
        String[] parts = sentence.split("((?<=\\p{Punct})|(?=\\p{Punct})|\\s+)");
        for (String part : parts) {
            if (!part.isBlank()) {
                components.add(part);
            }
        }
    }

    public String getProcessedSentence() {
        StringBuilder result = new StringBuilder();
        for (String component : components) {
            if (component.matches("\\p{Punct}|\\s+")) {
                result.append(component);
            } else {
                Word word = new Word(component);
                result.append(word.getProcessedWord());
            }
        }
        return result.toString();
    }
}