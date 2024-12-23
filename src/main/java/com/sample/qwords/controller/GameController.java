package com.sample.qwords.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.qwords.model.GameStatus;
import com.sample.qwords.model.Word;
import com.sample.qwords.service.WordSelectionService;

import io.micrometer.core.lang.Nullable;
import lombok.extern.log4j.Log4j2;

/**
 * A Spring MVC controller class that handles the game logic and user
 * interactions.
 */
@Controller
@Log4j2
public class GameController {

    private WordSelectionService wordBank;
    private String selected;
    private Word word;

    @GetMapping("/game")
    public String index(@RequestParam String user, Model model) {

        wordBank = new WordSelectionService();
        selected = wordBank.getWord();
        word = new Word(selected);

        log.info(user);

        int attempts = getAttempts(model);

        String result = "";

        // Set View Attributes
        model.addAttribute("word", selected);
        // log the selected word
        log.info(selected);
        model.addAttribute("message", "Make your first guess!");
        model.addAttribute("attempts", attempts);
        model.addAttribute("result", result);
        model.addAttribute("status", GameStatus.INPROGRESS);
        model.addAttribute("user", user);

        return "game";
    }

    /**
     * Handles the user's guess submission during the game.
     *
     * @param guess    The user's guess for the word.
     * @param attempts The number of attempts made so far.
     * @param model    The Model object used to pass data to the view.
     * @return The name of the view to be rendered.
     */
    @PostMapping("/game")
    public String makeGuess(String guess, int attempts, Model model, String user) {

        // log the guessed word
        log.info(guess);
        String result = word.getInfo(guess);
        // log the descriptive results of the info
        log.info("Results is " + result);
        attempts = addAttempt(attempts);

        model.addAttribute("result", result);
        model.addAttribute("attempts", attempts);
        model.addAttribute("guess", guess);
        model.addAttribute("user", user);

        if (word.isCorrect(guess.toCharArray())) {
            model.addAttribute("message", "Congratulations! You guessed correctly");
            model.addAttribute("status", GameStatus.SUCCESS);
        } else {

            if (attempts >= 5) {
                model.addAttribute("message", "Sorry, you've reached the maximum number of attempts.");
                model.addAttribute("status", GameStatus.FAILED);
            } else {
                model.addAttribute("message", "Try again. Your next guess:");
                model.addAttribute("status", GameStatus.INPROGRESS);
            }
        }

        return "game";
    }

    /**
     * Retrieves the number of attempts made so far from the Model object.
     *
     * @param model The Model object containing the attempts data.
     * @return The number of attempts made so far, or 0 if not found in the Model.
     */
    private int getAttempts(Model model) {
        Integer attempts = (Integer) model.getAttribute("attempts");
        return (attempts != null) ? attempts : 0;
    }

    private int addAttempt(@Nullable Integer attempt) {
        return attempt + 1;
    }

}
