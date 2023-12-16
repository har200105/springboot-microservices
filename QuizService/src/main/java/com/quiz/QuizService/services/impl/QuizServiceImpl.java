package com.quiz.QuizService.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.quiz.QuizService.entities.Quiz;
import com.quiz.QuizService.repositories.QuizRepository;
import com.quiz.QuizService.services.QuestionClient;
import com.quiz.QuizService.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;

    private QuestionClient questionClient;


    public QuizServiceImpl(QuizRepository quizRepository,QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }


    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getQuizes() {
        
        List<Quiz> quizes =  quizRepository.findAll();
        
        List<Quiz> newQuizes = quizes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());

        return newQuizes;
    }

    @Override
    public Quiz getQuizById(Long id) {
        Quiz quiz =  quizRepository.findById(id).orElseThrow(()-> new RuntimeException("Quiz not found"));
        quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
        return quiz;
    }

}
