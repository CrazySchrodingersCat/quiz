package quad.quiz.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quad.quiz.openapi.api.QuestionsApi;
import quad.quiz.openapi.model.Question;
import quad.quiz.service.IQuestionService;

import java.util.List;

@AllArgsConstructor
@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:4200/")
public class QuestionController implements QuestionsApi {

    private final IQuestionService questionService;

    @Override
    public ResponseEntity<List<Question>> getQuestions() {
        log.info("Call QuestionController for getting questions");
        return ResponseEntity.ok(questionService.getQuestions());
    }
}
