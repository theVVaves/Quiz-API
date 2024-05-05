package com.cooksys.quiz_api.mappers;

import com.cooksys.quiz_api.dtos.AnswerRequestDto;
import com.cooksys.quiz_api.dtos.QuestionRequestDto;
import com.cooksys.quiz_api.dtos.QuestionResponseDto;
import com.cooksys.quiz_api.entities.Answer;
import com.cooksys.quiz_api.entities.Question;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-02T21:33:57-0400",
    comments = "version: 1.4.1.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 22 (Oracle Corporation)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public QuestionResponseDto entityToDto(Question entity) {
        if ( entity == null ) {
            return null;
        }

        QuestionResponseDto questionResponseDto = new QuestionResponseDto();

        questionResponseDto.setAnswers( answerMapper.entitiesToDtos( entity.getAnswers() ) );
        questionResponseDto.setId( entity.getId() );
        questionResponseDto.setText( entity.getText() );

        return questionResponseDto;
    }

    @Override
    public List<QuestionResponseDto> entitiesToDtos(List<Question> entities) {
        if ( entities == null ) {
            return null;
        }

        List<QuestionResponseDto> list = new ArrayList<QuestionResponseDto>( entities.size() );
        for ( Question question : entities ) {
            list.add( entityToDto( question ) );
        }

        return list;
    }

    @Override
    public Question requestDtoToEntity(QuestionRequestDto questionRequestDto) {
        if ( questionRequestDto == null ) {
            return null;
        }

        Question question = new Question();

        question.setAnswers( answerRequestDtoListToAnswerList( questionRequestDto.getAnswers() ) );
        question.setText( questionRequestDto.getText() );

        return question;
    }

    protected List<Answer> answerRequestDtoListToAnswerList(List<AnswerRequestDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Answer> list1 = new ArrayList<Answer>( list.size() );
        for ( AnswerRequestDto answerRequestDto : list ) {
            list1.add( answerMapper.dtoToEntity( answerRequestDto ) );
        }

        return list1;
    }
}
