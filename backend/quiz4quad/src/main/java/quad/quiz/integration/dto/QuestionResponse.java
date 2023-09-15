package quad.quiz.integration.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Getter
@Setter
@Builder
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionResponse {

    private Integer responseCode;

    private List<QuestionDTO> results;
}
