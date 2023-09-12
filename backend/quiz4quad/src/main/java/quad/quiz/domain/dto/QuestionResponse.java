package quad.quiz.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
@AllArgsConstructor
public class QuestionResponse {
    private String questionText;
    private String type;
    private List<String> options;
}
