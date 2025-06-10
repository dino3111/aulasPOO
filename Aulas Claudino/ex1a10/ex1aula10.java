package ex1a10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ex1aula10 {

    public static void main(String[] args) throws IOException {
        String filename = "C:\\Users\\claud\\Desktop\\EstudoPOO\\src\\ex1a10\\major.txt";

        String content = Files.readString(Path.of(filename));

        String separatorsRegex = "[\\t\\n\\.,:'‘’;?!\\-*{}=+&/\\(\\)\\[\\]”“\"\\\\']+";

        String[] allWords = content.split(separatorsRegex);

        List<String> filteredWords = new ArrayList<>();
        for (String w : allWords) {
            if (w.length() >= 3) {
                filteredWords.add(w.toLowerCase());
            }
        }

        Map<String, Map<String, Integer>> pairsMap = new TreeMap<>();

        for (int i = 0; i < filteredWords.size() - 1; i++) {
            String w1 = filteredWords.get(i);
            String w2 = filteredWords.get(i + 1);

            pairsMap.putIfAbsent(w1, new TreeMap<>());
            Map<String, Integer> nextWords = pairsMap.get(w1);

            nextWords.put(w2, nextWords.getOrDefault(w2, 0) + 1);
        }

        for (Map.Entry<String, Map<String, Integer>> entry : pairsMap.entrySet()) {
            String word = entry.getKey();
            Map<String, Integer> nextWords = entry.getValue();

            StringBuilder sb = new StringBuilder();
            sb.append(word).append("={");

            List<String> nextWordCounts = new ArrayList<>();
            for (Map.Entry<String, Integer> nwEntry : nextWords.entrySet()) {
                nextWordCounts.add(nwEntry.getKey() + "=" + nwEntry.getValue());
            }
            sb.append(String.join(", ", nextWordCounts));
            sb.append("}");

            System.out.println(sb);
        }
    }
}

