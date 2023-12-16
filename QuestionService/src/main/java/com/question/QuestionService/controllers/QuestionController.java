package com.question.QuestionService.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.QuestionService.entities.Question;
import com.question.QuestionService.services.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public Question createQuestion(@RequestBody Question question){
        return questionService.createQuestion(question);
    }

    @GetMapping
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable Long id){
        return questionService.getQuestionById(id);
    }

    @GetMapping("/quiz/{id}")
    public List<Question> getQuestionsByQuizId(@PathVariable Long id){
        return questionService.getQuestionsByQuizId(id);
    }

}
