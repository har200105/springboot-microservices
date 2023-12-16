package com.quiz.QuizService.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.QuizService.entities.Quiz;
import com.quiz.QuizService.services.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private QuizService quizService;

    public QuizController(QuizService quizService){
        this.quizService = quizService;
    }

    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz){
        return quizService.addQuiz(quiz);
    }

    @GetMapping
    public List<Quiz> getAllQuizes(){
        return quizService.getQuizes();
    }

    @GetMapping("/{id}")
    public Quiz quiz(@PathVariable Long id){
        return quizService.getQuizById(id);
    }
}
