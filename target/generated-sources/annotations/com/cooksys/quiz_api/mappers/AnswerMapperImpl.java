package com.cooksys.quiz_api.mappers;

import com.cooksys.quiz_api.dtos.AnswerRequestDto;
import com.cooksys.quiz_api.dtos.AnswerResponseDto;
import com.cooksys.quiz_api.entities.Answer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-02T21:33:56-0400",
    comments = "version: 1.4.1.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 22 (Oracle Corporation)"
)
@Component
public class AnswerMapperImpl implements AnswerMapper {

    @Override
    public AnswerResponseDto entityToDto(Answer entity) {
        if ( entity == null ) {
            return null;
        }

        AnswerResponseDto answerResponseDto = new AnswerResponseDto();

        answerResponseDto.setId( entity.getId() );
        answerResponseDto.setText( entity.getText() );

        return answerResponseDto;
    }

    @Override
    public Answer dtoToEntity(AnswerRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Answer answer = new Answer();

        answer.setCorrect( dto.isCorrect() );
        answer.setText( dto.getText() );

        return answer;
    }

    @Override
    public List<AnswerResponseDto> entitiesToDtos(List<Answer> entities) {
        if ( entities == null ) {
            return null;
        }

        List<AnswerResponseDto> list = new ArrayList<AnswerResponseDto>( entities.size() );
        for ( Answer answer : entities ) {
            list.add( entityToDto( answer ) );
        }

        return list;
    }
}
