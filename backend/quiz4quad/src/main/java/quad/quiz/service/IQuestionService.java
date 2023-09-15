package quad.quiz.service;

import quad.quiz.openapi.model.AnswerResult;
import quad.quiz.openapi.model.Question;
import quad.quiz.openapi.model.QuestionAnswer;

import java.util.List;

public interface IQuestionService {
    List<Question> getQuestions();

    AnswerResult validateQuestionAnswer(QuestionAnswer questionAnswers);
}
