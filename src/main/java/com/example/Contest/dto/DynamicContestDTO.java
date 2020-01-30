package com.example.Contest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class DynamicContestDTO {
    String contestId;
    String categoryId;
    String contestName;
    Date contestTimeLimit;
    int noOfQuestions;
    Date contestStartTime;
    int questionIds;
    int noOfSkipsAllowed;
    private List<QuestionDTO> questionsIds;
}
