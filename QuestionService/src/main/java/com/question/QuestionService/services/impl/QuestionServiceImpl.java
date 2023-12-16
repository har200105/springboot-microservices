package com.question.QuestionService.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.question.QuestionService.entities.Question;
import com.question.QuestionService.repositories.QuestionRepository;
import com.question.QuestionService.services.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

    private QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElseThrow(()-> new RuntimeException("Question Not Found"));
    }

    @Override
    public List<Question> getQuestionsByQuizId(Long id) {
        return questionRepository.findByQuizId(id);
    }

}
