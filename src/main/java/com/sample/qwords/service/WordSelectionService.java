package com.sample.qwords.service;

import com.sample.qwords.repository.WordList;

/**
 * A service class that handles the selection of a random word from a word list.
 */
public class WordSelectionService {

    private WordList wordlist;
    private String selectedWord;

    /**
     * Constructs a new instance of the WordSelectionService.
     * Initializes the word list and selects a random word from it.
     */
    public WordSelectionService() {

        this.wordlist = WordList.getInstance();
        this.selectedWord = wordlist.getRandomWord();
    }

    /**
     * Returns the currently selected word.
     *
     * @return The selected word as a String.
     */
    public String getWord() {
        return this.selectedWord;
    }
}
