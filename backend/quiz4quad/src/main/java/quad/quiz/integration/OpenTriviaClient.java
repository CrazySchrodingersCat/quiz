package quad.quiz.integration;

import quad.quiz.integration.dto.QuestionDTO;
import quad.quiz.integration.dto.QuestionCategory;
import quad.quiz.integration.dto.QuestionDifficulty;
import quad.quiz.integration.dto.QuestionType;

import java.util.List;

public interface OpenTriviaClient {

    List<QuestionDTO> getQuestions(Integer questionsNumber, QuestionType questionType, QuestionCategory questionCategory, QuestionDifficulty questionDifficulty);
}
