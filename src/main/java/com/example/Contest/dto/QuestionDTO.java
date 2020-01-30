package com.example.Contest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class QuestionDTO {

    private String questionId;
    private List<String> userId;
    private String questionFormat;
    private String questionText;
    private Map<String,String> options;
    private String answers;
    private String difficultyLevel;
    private String categoryId;
    private String urlAttachment;
    private Integer QuestionType;

}
