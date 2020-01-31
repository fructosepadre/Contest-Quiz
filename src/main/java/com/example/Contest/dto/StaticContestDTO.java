package com.example.Contest.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class StaticContestDTO {

    String categoryId;
    String contestName;
    LocalDateTime contestEndTime;
    Integer noOfQuestions;
    Date contestStartTime;
    String adminId;
    Integer noOfSkipsAllowed;
    private List<QuestionDTO> questions;
    private boolean isCompleted;
}



