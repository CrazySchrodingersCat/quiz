package quad.quiz.service;

//import quad.quiz.domain.Question;
import quad.quiz.domain.dto.QuestionResponse;

import java.util.List;

public interface IQuestionService {
    List<QuestionResponse> getQuestions();
    List<Boolean> checkAnswers(Long questionId, List<String> answers);
//    List<Question> fetchQuestionsFromAPI();
}
