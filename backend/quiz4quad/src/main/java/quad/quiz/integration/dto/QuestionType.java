package quad.quiz.integration.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QuestionType {

    MULTIPLE_CHOICE("multiple"),
    BOOLEAN("boolean");

    private String description;
}
