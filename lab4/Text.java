import java.util.ArrayList;
import java.util.List;

/**
 * Клас Text представляє текст, що складається з речень.
 */
public class Text {
    private final List<Sentence> sentences = new ArrayList<>();

    public Text(String text) {
        String[] sentenceParts = text.split("(?<=[.!?])\\s+");
        for (String sentence : sentenceParts) {
            sentences.add(new Sentence(sentence.trim()));
        }
    }

    public String getProcessedText() {
        StringBuilder result = new StringBuilder();
        for (Sentence sentence : sentences) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(sentence.getProcessedSentence());
        }
        return result.toString();
    }
}