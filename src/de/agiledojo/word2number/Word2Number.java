package de.agiledojo.word2number;

import java.util.Map;
import java.util.Scanner;

public class Word2Number {

    private Map<String, Integer> numberMap;

    public Word2Number(Map<String, Integer> numberMap) {
        this.numberMap = numberMap;
    }

    public int convert(String statement) {
        Scanner scanner = new Scanner(statement);
        if (!scanner.hasNext()) {
            throw new IllegalArgumentException("Empty String cannot be converted.");
        }
        return convert(scanner, 0);
    }

    private int convert(Scanner scanner, int number) {
        String word = scanner.next();
        number += scanner.hasNext() ? numberFor(word, scanner.next()) : numberFor(word);
        return scanner.hasNext()? convert(scanner,number): number;
    }

    private int numberFor(String firstWord, String secondWord) {
        if (numberFor(secondWord) < 10) {
            return numberFor(firstWord) + numberFor(secondWord);
        } else {
            return numberFor(firstWord) * numberFor(secondWord);
        }
    }

    private Integer numberFor(String word) {
        if (!numberMap.containsKey(word)) {
            throw new IllegalArgumentException("Cannot find a number for '" + word +"'.");
        }
        return numberMap.get(word);
    }

}
