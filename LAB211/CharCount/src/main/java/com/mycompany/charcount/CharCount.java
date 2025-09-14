/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package com.mycompany.charcount;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CharCount {
    private String text;

    public CharCount(String text) {
        this.text = text;
    }
    public Map<String, Integer> countWords() {
        Map<String, Integer> wordCount = new LinkedHashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(text);
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken().toLowerCase();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }
    public Map<Character, Integer> countLetters() {
        Map<Character, Integer> letterCount = new LinkedHashMap<>();
        for (char c : text.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
            }
        }
        return letterCount;
    }
    public void showResult() {
        System.out.println(countWords());
        System.out.println(countLetters());
    }
}
