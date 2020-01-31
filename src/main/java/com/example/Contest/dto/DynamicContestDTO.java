package com.example.Contest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class DynamicContestDTO {

    String categoryId;
    List<String> userId;
    String contestName;
    Date contestTimeLimit;
    int noOfQuestions;
    Date contestStartTime;
    String adminId;
    int noOfSkipsAllowed;
    private List<QuestionDTO> questions;
    private boolean isCompleted;
}
