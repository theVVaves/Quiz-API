package com.cooksys.quiz_api.mappers;

import com.cooksys.quiz_api.dtos.QuizRequestDto;
import com.cooksys.quiz_api.dtos.QuizResponseDto;
import com.cooksys.quiz_api.entities.Question;
import com.cooksys.quiz_api.entities.Quiz;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-02T21:33:56-0400",
    comments = "version: 1.4.1.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 22 (Oracle Corporation)"
)
@Component
public class QuizMapperImpl implements QuizMapper {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public QuizResponseDto entityToDto(Quiz entity) {
        if ( entity == null ) {
            return null;
        }

        QuizResponseDto quizResponseDto = new QuizResponseDto();

        quizResponseDto.setId( entity.getId() );
        quizResponseDto.setName( entity.getName() );
        quizResponseDto.setQuestions( questionMapper.entitiesToDtos( entity.getQuestions() ) );

        return quizResponseDto;
    }

    @Override
    public List<QuizResponseDto> entitiesToDtos(List<Quiz> entities) {
        if ( entities == null ) {
            return null;
        }

        List<QuizResponseDto> list = new ArrayList<QuizResponseDto>( entities.size() );
        for ( Quiz quiz : entities ) {
            list.add( entityToDto( quiz ) );
        }

        return list;
    }

    @Override
    public Quiz requestDtoToEntity(QuizRequestDto quizRequestDto) {
        if ( quizRequestDto == null ) {
            return null;
        }

        Quiz quiz = new Quiz();

        quiz.setId( quizRequestDto.getId() );
        quiz.setName( quizRequestDto.getName() );
        List<Question> list = quizRequestDto.getQuestions();
        if ( list != null ) {
            quiz.setQuestions( new ArrayList<Question>( list ) );
        }

        return quiz;
    }
}
