package com.question.QuestionService.services;

import java.util.List;

import com.question.QuestionService.entities.Question;

public interface QuestionService {

    Question createQuestion(Question question);
    List<Question> getAllQuestions();
    Question getQuestionById(Long id);
    List<Question> getQuestionsByQuizId(Long id);
} 
