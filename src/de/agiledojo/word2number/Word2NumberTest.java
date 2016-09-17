package de.agiledojo.word2number;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Word2NumberTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Word2Number word2Number;

    private static Map<String,Integer> initializeNumberMap() {
        Map<String,Integer> numberMap = new HashMap<>();
        numberMap.put("three",3);
        numberMap.put("thirty",30);
        numberMap.put("hundred",100);
        return numberMap;
    }

    @Before
    public void setUp() throws Exception {
        word2Number = new Word2Number(initializeNumberMap());
    }

    @Test
    public void convertsSingleWordToNumber() {
        assertEquals(3, word2Number.convert("three"));
    }

    @Test
    public void convertsWordPairForTwoDigitNumber() {
        assertEquals(33, word2Number.convert("thirty three"));
    }

    @Test
    public void convertsWordPairForHigherDigitNumber() {
        assertEquals(300, word2Number.convert("three hundred"));
    }

    @Test
    public void convertsWordCombinationToNumber() {
        assertEquals(303, word2Number.convert("three hundred three"));
    }

    @Test
    public void throwsExceptionForEmptyStatement() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Empty String cannot be converted.");
        word2Number.convert("");
    }

    @Test
    public void throwsExceptionWhenWordCannotBeFound() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Cannot find a number for 'noNumber'.");
        word2Number.convert("noNumber");
    }
}
