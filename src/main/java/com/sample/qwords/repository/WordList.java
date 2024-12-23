package com.sample.qwords.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Random;
//import IOException
import java.io.IOException;

public class WordList {

    private static WordList instance;
    private final List<String> wordlist;
    private final String filePath;
    private boolean isLoaded = false;

    // local variables to track the current and last word returned
    private String lastWord = null;
    private String currentWord = null;

    private WordList() {
        this.wordlist = new ArrayList<>();
        this.isLoaded = false;
        this.filePath = "";
        loadWordsFromFile();
    }

    private WordList(String filePath) throws IOException {
        this.wordlist = new ArrayList<>();
        this.isLoaded = false;
        this.filePath = filePath;
        loadWordsFromFile(filePath);
    }

    public static WordList getInstance() {
        if (instance == null) {
            instance = new WordList();
        }
        return instance;
    }

    public static WordList getInstance(String filePath) throws IOException {
        if (instance == null) {
            instance = new WordList(filePath);
        } else {
            instance.loadWordsFromFile(filePath);
        }

        return instance;
    }

    private void loadWordsFromFile(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            wordlist.add(line.trim());
        }
        isLoaded = true;

        currentWord = wordlist.isEmpty() ? null : getRandomWord();
        lastWord = null;
        System.out.println("Total words: " + wordlist.size());
    }

    private void loadWordsFromFile(String filePath) throws IOException {
        System.out.println("Loading words from file: " + filePath);
        if (!isLoaded | !filePath.equals(this.filePath)) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                loadWordsFromFile(reader);
                System.out.println("Words loaded from file: " + filePath);
            } catch (IOException e) {
                System.err.println("Error loading words from file: " + filePath);
                throw e;
            }
        }
    }

    private void loadWordsFromFile() {
        System.out.println("Loading words from classpath resource: words.txt");
        if (!isLoaded) {
            try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("words.txt");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                loadWordsFromFile(reader);
                System.out.println("Words loaded from classpath resource: words.txt");
            } catch (IOException e) {
                System.err.println("Error loading words from classpath resource: words.txt");
                e.printStackTrace();
            }
        }
    }

    public List<String> getWordList() {
        return new ArrayList<>(wordlist);
    }

    public void clearWordList() {
        wordlist.clear();
    }

    public void addWord(String word) {
        if (word != null && !wordlist.contains(word)) {
            wordlist.add(word);
        }
    }

    public boolean containsWord(String word) {
        if (word == null) {
            return false;
        }
        return wordlist.contains(word);
    }

    public String getWordAtIndex(int index) {
        return wordlist.get(index);
    }

    public boolean removeWord(String word) {
        boolean removed = wordlist.remove(word);
        if (removed) {
        }
        return removed;
    }

    public void saveWordListToFile(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String word : wordlist) {
                writer.write(word);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void loadWordListFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            wordlist.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                wordlist.add(line.trim());
            }
            isLoaded = true;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Shuffles the word list.
     */
    public void shuffleWordList() {
        Collections.shuffle(wordlist);
    }

    public List<String> getWordsByLength(int length) {
        return wordlist.stream()
                .filter(word -> word.length() == length)
                .collect(Collectors.toList());
    }

    public String getRandomWord() {
        // track the current and last word returned using
        // lastWord and currentWord class properties
        if (wordlist.isEmpty()) {
            return null;
        }

        // if the currentWord is not null, store it in the lastWord variable before
        // getting a new word.
        if (currentWord != null) {
            lastWord = currentWord;
        }
        currentWord = this.wordlist.get(0);
        return currentWord;
    }

    public List<String> getWords() {
        return new ArrayList<>(wordlist);
    }

    public static void resetInstance() {
        if (instance != null) {
            instance = null;
        }
        throw new UnsupportedOperationException("Unimplemented method 'resetInstance'");
    }

    // TODO: Add getters for currentWord and lastWord.

    // TODO: Also add a method to get wordlist size.

}
