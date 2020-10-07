package com.techelevator;

import com.techelevator.readfiles.WordCounter;
import org.junit.Assert;
import org.junit.Test;

public class WordsCounterTests {

    @Test
    public void counts_words_in_easy_line() {
        WordCounter sut = new WordCounter();
        int result = sut.countWordsInLine("This is a test.");
        Assert.assertEquals(4, result);
    }

    @Test
    public void counts_words_in_easy_line_with_extra_space() {
        WordCounter sut = new WordCounter();
        int result = sut.countWordsInLine("This   is    a    test.");
        Assert.assertEquals(4, result);
    }

    @Test
    public void counts_words_in_easy_line_with_spaces_before_and_after() {
        WordCounter sut = new WordCounter();
        int result = sut.countWordsInLine("  This   is   a   test.  ");
        Assert.assertEquals(4, result);
    }

    @Test
    public void counts_words_in_empty_string    () {
        WordCounter sut = new WordCounter();
        int result = sut.countWordsInLine("");
        Assert.assertEquals(0, result);
    }
}
