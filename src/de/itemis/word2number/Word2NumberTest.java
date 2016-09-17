package de.itemis.word2number;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Word2NumberTest {

    private Word2Number word2Number;

    @Before
    public void setUp() throws Exception {
        word2Number = new Word2Number();
    }

    @Test
    public void convertsSingleWordToNumber() {
        assertEquals(3, word2Number.convert("three"));
    }

    @Test
    public void convertsWordPairWithSecondPartLowerThanFirstToNumber() {
        assertEquals(33, word2Number.convert("thirty three"));
    }

    @Test
    public void convertsWordPairWithSecondPartHigherThanFirstToNumber() {
        assertEquals(300, word2Number.convert("three hundred"));
    }
}
