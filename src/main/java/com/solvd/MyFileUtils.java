package com.solvd;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class MyFileUtils {
    private static final Logger LOGGER = LogManager.getLogger(MyFileUtils.class);

    public static void main(String[] args) throws IOException {
        File txt = new File("src/main/resources/textFile.txt");

        Map<String, Integer> words = new HashMap<>();
        List<String> list = new ArrayList<>();

        String text = FileUtils.readFileToString(txt, "UTF-8").toUpperCase();
        Arrays.stream(StringUtils.split(text, ".-,;? ")).forEach(word -> {
            if (words.containsKey(word)) words.replace(word, words.get(word) + 1);
            else words.put(word, 1);
        });

        words.keySet().forEach(key -> list.add(key + " - " + words.get(key)));

        FileUtils.writeLines(new File("src/main/resources/uniqueWordsCount.txt"), list);
    }
}

