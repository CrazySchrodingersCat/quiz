//package quad.quiz.controllers;
//
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import quad.quiz.domain.Question;
//import quad.quiz.domain.dto.QuestionResponse;
//import quad.quiz.service.IQuestionService;
//
//import java.util.List;
//
//@Slf4j
//@RestController
//@RequestMapping("/questions")
//@RequiredArgsConstructor
//public class QuestionController {
//    @Autowired
//    private final IQuestionService questionService;
//
//    @GetMapping
//    public ResponseEntity<List<QuestionResponse>> getQuestions(){
//        log.info("GET questions");
//        List<Question> questions  = questionService.fetchQuestionsFromAPI();
//        log.info("Response from api : " + questions);
//        log.info("Questions : " + questionService.getQuestions());
//        return new ResponseEntity<>(questionService.getQuestions(), HttpStatus.OK);
//    }
//
//    @PostMapping("{qiestionId}")
//    public ResponseEntity<List<Boolean>> checkAnswers(@PathVariable @Validated Long questionId,@RequestBody List<String> answers){
//        return new ResponseEntity<>(questionService.checkAnswers(questionId, answers), HttpStatus.OK);
//    }
////}
