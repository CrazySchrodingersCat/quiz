package quad.quiz.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import quad.quiz.openapi.model.AnswerResult;
import quad.quiz.openapi.model.QuestionAnswer;
import quad.quiz.service.IQuestionService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CheckAnswersControllerTest {

    @Mock
    private IQuestionService questionService;

    @InjectMocks
    private CheckAnswersController checkAnswersController;


    @Test
    void testCheckAnswers() {
        // Arrange
        QuestionAnswer questionAnswer=new QuestionAnswer();

        AnswerResult expectedAnswerResult=new AnswerResult();

        when(questionService.validateQuestionAnswer(questionAnswer)).thenReturn(expectedAnswerResult);

        // Act
        ResponseEntity<AnswerResult> response=checkAnswersController.checkAnswers(questionAnswer);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedAnswerResult, response.getBody());
    }
}
