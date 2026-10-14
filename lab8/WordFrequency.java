package lab8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Lab 8 - Exercise 4: count how often each word appears, then show the most frequent first
public class WordFrequency {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type or paste a paragraph (one line), then press Enter:");
        String paragraph = keyboard.nextLine();

        // 1. Clean up: lower case, remove punctuation, split on spaces
        String cleaned = paragraph.toLowerCase().replaceAll("[^a-z0-9 ]", " ");
        String[] words = cleaned.trim().split("\\s+");

        // 2. Count with a Map: word -> how many times
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            int old = counts.getOrDefault(word, 0);   // 0 if we have not seen the word yet
            counts.put(word, old + 1);
        }

        // 3. A Map has no useful order, so copy the entries into a List and sort THAT
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(counts.entrySet());
        entries.sort((a, b) -> {
            int byCount = Integer.compare(b.getValue(), a.getValue());   // bigger count first
            if (byCount != 0) {
                return byCount;
            }
            return a.getKey().compareTo(b.getKey());                     // tie: alphabetical
        });

        System.out.println();
        System.out.println("Word frequencies (most frequent first):");
        for (Map.Entry<String, Integer> e : entries) {
            System.out.printf("%-10s %d%n", e.getKey(), e.getValue());
        }
    }
}
