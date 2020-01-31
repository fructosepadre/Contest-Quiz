package com.example.Contest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class StaticContestDTO {

    String categoryId;
    String contestName;
    Date contestEndTime;
    Integer noOfQuestions;
    Date contestStartTime;
    String adminId;
    Integer noOfSkipsAllowed;
    private List<QuestionDTO> questions;
}



