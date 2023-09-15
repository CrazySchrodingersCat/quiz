package quad.quiz.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import quad.quiz.integration.dto.QuestionDTO;
import quad.quiz.openapi.model.Question;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    List<Question> map(List<QuestionDTO> dtos);

    @Mapping(target = "text", source = "question")
    @Mapping(target = "options", expression = "java(dtoToOptions(dto))")
    Question map(QuestionDTO dto);

    default List<String> dtoToOptions(QuestionDTO dto) {
        List<String> options = new ArrayList<>();
        options.addAll(dto.getIncorrectAnswers());
        options.add(dto.getCorrectAnswer());
        return options;
    }
}
