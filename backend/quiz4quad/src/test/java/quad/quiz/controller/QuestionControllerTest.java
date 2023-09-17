package quad.quiz.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import quad.quiz.openapi.model.Question;
import quad.quiz.service.IQuestionService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuestionControllerTest {

    @Mock
    private IQuestionService questionService;

    private QuestionController questionController;

    @BeforeEach
    public void setUp() {
        questionController=new QuestionController(questionService);
    }

    @Test
    void testGetQuestions() {
        // Arrange
        List<Question> expectedQuestions=new ArrayList<>();
        expectedQuestions.add(new Question());
        expectedQuestions.add(new Question());

        when(questionService.getQuestions()).thenReturn(expectedQuestions);

        // Act
        ResponseEntity<List<Question>> response=questionController.getQuestions();

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedQuestions, response.getBody());
    }
}
