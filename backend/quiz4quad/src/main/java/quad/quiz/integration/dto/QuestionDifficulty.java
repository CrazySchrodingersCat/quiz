package quad.quiz.integration.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QuestionDifficulty {

    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard");

    private String description;
}
