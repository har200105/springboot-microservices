package com.quiz.QuizService.services;

import java.util.List;

import com.quiz.QuizService.entities.Quiz;

public interface QuizService {
    
    Quiz addQuiz(Quiz quiz);

    List<Quiz> getQuizes();

    Quiz getQuizById(Long id);

}
