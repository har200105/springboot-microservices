package com.quiz.QuizService.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quiz.QuizService.entities.Question;

@FeignClient(name ="QUESTION-SERVICE")
public interface QuestionClient {

    @GetMapping("/question/quiz/{id}")
    List<Question> getQuestionsOfQuiz(@PathVariable Long id); 

}
