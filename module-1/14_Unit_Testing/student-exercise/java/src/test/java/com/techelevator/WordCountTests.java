package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTests {
    @Test
    public void getCount_ba_ba_black_sheep(){
        WordCount sut = new WordCount();

        Map<String, Integer> result = sut.getCount(new String[]{"ba","ba","black","sheep"});

        Map<String, Integer> expected = new HashMap<String, Integer>(){{
            put("ba", 2);
            put("black", 1);
            put("sheep", 1);
        }};

        Assert.assertEquals(expected, result);
    }
    @Test
    public void getCount_new_old(){
        WordCount sut = new WordCount();

        Map<String, Integer> result = sut.getCount(new String[]{"new","old","new","old"});

        Map<String, Integer> expected = new HashMap<String, Integer>(){{
            put("new", 2);
            put("old", 2);
        }};

        Assert.assertEquals(expected, result);
    }
    @Test
    public void getCount_null(){
        WordCount sut = new WordCount();

        Map<String, Integer> result = sut.getCount(new String[]{});

        Map<String, Integer> expected = new HashMap<String, Integer>(){{;
        }};

        Assert.assertEquals(expected, result);
    }
}
