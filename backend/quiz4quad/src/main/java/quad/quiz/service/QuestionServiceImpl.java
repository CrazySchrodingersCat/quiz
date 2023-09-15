package quad.quiz.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import quad.quiz.exception.QuestionNotFoundException;
import quad.quiz.integration.OpenTriviaClient;
import quad.quiz.integration.dto.QuestionDTO;
import quad.quiz.mapper.QuestionMapper;
import quad.quiz.integration.dto.QuestionCategory;
import quad.quiz.integration.dto.QuestionDifficulty;
import quad.quiz.integration.dto.QuestionType;
import quad.quiz.openapi.model.AnswerResult;
import quad.quiz.openapi.model.Question;
import quad.quiz.openapi.model.QuestionAnswer;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class QuestionServiceImpl implements IQuestionService {

    private static final Integer NUMBER_OF_QUESTIONS = 5;
    private final OpenTriviaClient openTriviaClient;

    @Override
    public List<Question> getQuestions() {
        log.info("Get questions");
        var questionDTOs = get5MultipleChoiceBookMediumQuestions();
        return QuestionMapper.INSTANCE.map(questionDTOs);
    }



    @Override
    public AnswerResult validateQuestionAnswer(QuestionAnswer answer) {
       log.info("Validate answers for questions {}", answer.getText());
        var questionDTOs = get5MultipleChoiceBookMediumQuestions();
        var result = getAnswerResult(questionDTOs, answer);
           var answerResult = new AnswerResult();
           answerResult.setText(answer.getText());
           answerResult.setResult(result);
            return answerResult;

    }

    private List<QuestionDTO> get5MultipleChoiceBookMediumQuestions() {
        return openTriviaClient.getQuestions(NUMBER_OF_QUESTIONS, QuestionType.MULTIPLE_CHOICE, QuestionCategory.BOOK, QuestionDifficulty.MEDIUM);
    }

    private boolean getAnswerResult(List<QuestionDTO> questionDTOs, QuestionAnswer questionAnswer) {
        return questionDTOs.stream()
                .filter(dto -> dto.getQuestion().equals(questionAnswer.getText()))
                .findFirst()
                .orElseThrow(() -> new QuestionNotFoundException(String.format("Question '%s' wasn't found", questionAnswer.getText())))
                .getCorrectAnswer().equals(questionAnswer.getAnswer());
    }
}
