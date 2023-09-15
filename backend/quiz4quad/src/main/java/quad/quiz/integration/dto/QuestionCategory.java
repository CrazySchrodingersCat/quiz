package quad.quiz.integration.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QuestionCategory {

    GENERAL(9),
    BOOK(10),
    MOVIE(11),
    MUSIC(12);

    private Integer categoryId;
}
