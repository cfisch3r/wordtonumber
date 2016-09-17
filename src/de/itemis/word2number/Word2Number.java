package de.itemis.word2number;

import java.util.Map;
import java.util.Scanner;

public class Word2Number {

    private Map<String, Integer> numberMap;

    public Word2Number(Map<String, Integer> numberMap) {
        this.numberMap = numberMap;
    }

    public int convert(String statement) {
        Scanner scanner = new Scanner(statement);
        if (scanner.hasNext()) {
            return convert(scanner, scanner.next(), 0);
        }
        throw new IllegalArgumentException();
    }

    private int convert(Scanner scanner, String word, int result) {
        result += scanner.hasNext() ? numberFor(word, scanner.next()) : numberFor(word);
        return scanner.hasNext()? convert(scanner,scanner.next(),result): result;
    }

    private int numberFor(String firstWord, String secondWord) {
        if (numberFor(secondWord) < 10) {
            return numberFor(firstWord) + numberFor(secondWord);
        } else {
            return numberFor(firstWord) * numberFor(secondWord);
        }
    }

    private Integer numberFor(String word) {
        return numberMap.get(word);
    }

}
