package quad.quiz.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import quad.quiz.openapi.api.CheckanswersApi;
import quad.quiz.openapi.model.AnswerResult;
import quad.quiz.openapi.model.QuestionAnswer;
import quad.quiz.service.IQuestionService;

@AllArgsConstructor
@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:4200/")
public class CheckAnswersController implements CheckanswersApi {

    private final IQuestionService questionService;

    @Override
    public ResponseEntity<AnswerResult> checkAnswers(QuestionAnswer questionAnswer) {
        log.info("Call CheckAnswersController for checking answers");
        return ResponseEntity.ok(questionService.validateQuestionAnswer(questionAnswer));
    }
}
