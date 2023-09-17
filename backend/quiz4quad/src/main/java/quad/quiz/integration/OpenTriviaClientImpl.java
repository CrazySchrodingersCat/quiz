package quad.quiz.integration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import quad.quiz.exception.OpenTriviaErrorException;
import quad.quiz.integration.dto.QuestionDTO;
import quad.quiz.integration.dto.QuestionResponse;
import quad.quiz.integration.dto.QuestionCategory;
import quad.quiz.integration.dto.QuestionDifficulty;
import quad.quiz.integration.dto.QuestionType;

import java.net.URI;
import java.util.List;

@Component
@Slf4j
public class OpenTriviaClientImpl implements OpenTriviaClient {

    @Value("${integration.open-trivia-db.url}")
    private String serviceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @Cacheable("getQuestions")
    public List<QuestionDTO> getQuestions(Integer questionsNumber, QuestionType questionType, QuestionCategory questionCategory, QuestionDifficulty questionDifficulty) {
        log.info("Query OpenTrivia API for getting {} questions with type {}, category {}, difficulty {}", questionsNumber, questionType, questionCategory, questionDifficulty);
        final var uri=buildUri(questionsNumber, questionType, questionCategory, questionDifficulty);
        try {
            var questionResponse=restTemplate.exchange(uri, HttpMethod.GET, null, QuestionResponse.class).getBody();
            assert questionResponse != null;
            return questionResponse.getResults();
        } catch (RuntimeException ex) {
            log.error("OpenTrivia API on getting {} questions with type {}, category {}, difficulty {} has been failed: {}, ", questionsNumber, questionType, questionCategory, questionDifficulty, ex.getMessage());
            throw new OpenTriviaErrorException("Failed getting questions");
        }
    }

    private URI buildUri(Integer questionsNumber, QuestionType questionType, QuestionCategory questionCategory, QuestionDifficulty questionDifficulty) {
        return UriComponentsBuilder.fromUriString(serviceUrl)
                // Add query parameter
                .queryParam("amount", String.valueOf(questionsNumber))
                .queryParam("type", questionType.getDescription())
                .queryParam("category", String.valueOf(questionCategory.getCategoryId()))
                .queryParam("difficulty", questionDifficulty.getDescription())
                // .queryParam("encode", "base64")
                .build()
                .toUri();
    }
}
