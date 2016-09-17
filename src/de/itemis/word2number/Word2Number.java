package de.itemis.word2number;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Word2Number {

    private Map<String, Integer> numberMap;

    public Word2Number() {
        initializeNumberMap();
    }

    public int convert(String statement) {
        Scanner scanner = new Scanner(statement);
        String word = scanner.next();

        return scanner.hasNext() ? numberFor(word, scanner.next()) : numberFor(word);
    }

    private int numberFor(String firstWord, String secondWord) {
        if (numberFor(firstWord) > numberFor(secondWord)) {
            return numberFor(firstWord) + numberFor(secondWord);
        } else {
            return numberFor(firstWord) * numberFor(secondWord);
        }
    }

    private Integer numberFor(String word) {
        return numberMap.get(word);
    }

    private void initializeNumberMap() {
        numberMap = new HashMap<>();
        numberMap.put("three",3);
        numberMap.put("thirty",30);
        numberMap.put("hundred",100);
    }
}
