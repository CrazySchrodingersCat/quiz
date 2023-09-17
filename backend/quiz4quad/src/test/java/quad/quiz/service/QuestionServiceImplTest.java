package quad.quiz.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import quad.quiz.integration.OpenTriviaClient;
import quad.quiz.integration.dto.QuestionDTO;
import quad.quiz.openapi.model.AnswerResult;
import quad.quiz.openapi.model.Question;
import quad.quiz.openapi.model.QuestionAnswer;
//import quad.quiz.integration.dto;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuestionServiceImplTest {

    private QuestionServiceImpl questionService;

    @Mock
    private OpenTriviaClient openTriviaClient;

    @BeforeEach
    public void setUp() {

        questionService=new QuestionServiceImpl(openTriviaClient);
    }

    @Test
    void testGetQuestions() {
        // Arrange
        List<QuestionDTO> questionDTOs=createSampleQuestionDTOs();
        when(openTriviaClient.getQuestions(anyInt(), any(), any(), any())).thenReturn(questionDTOs);

        // Act
        List<Question> questions=questionService.getQuestions();

        // Assert
        assertEquals(questionDTOs.size(), questions.size());
    }

    @Test
    void testValidateQuestionAnswer() {
        // Arrange
        List<QuestionDTO> questionDTOs=createSampleQuestionDTOs();
        when(openTriviaClient.getQuestions(anyInt(), any(), any(), any())).thenReturn(questionDTOs);

        // Act
        QuestionAnswer answer=new QuestionAnswer();
        answer.setAnswer("Correct Answer 1");
        answer.setText("Question 1");
        AnswerResult result=questionService.validateQuestionAnswer(answer);

        // Assert
        assertEquals("Question 1", result.getText());
    }

    private List<QuestionDTO> createSampleQuestionDTOs() {
        List<QuestionDTO> questionDTOs=new ArrayList<>();
        QuestionDTO question1=QuestionDTO.builder()
                .category("Category 1")
                .type("Type 1")
                .difficulty("Easy")
                .question("Question 1")
                .correctAnswer("Correct Answer 1")
                .incorrectAnswers(List.of("Incorrect Answer 1", "Incorrect Answer 2"))
                .build();

        QuestionDTO question2=QuestionDTO.builder()
                .category("Category 2")
                .type("Type 2")
                .difficulty("Medium")
                .question("Question 2")
                .correctAnswer("Correct Answer 2")
                .incorrectAnswers(List.of("Incorrect Answer 3", "Incorrect Answer 4"))
                .build();
        questionDTOs.add(question1);
        questionDTOs.add(question2);

        return questionDTOs;
    }
}