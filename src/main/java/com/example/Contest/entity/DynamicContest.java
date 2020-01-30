package com.example.Contest.entity;


import com.example.Contest.dto.QuestionDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Document(collection = "DynamicContest")
public class DynamicContest {

    @Id
    String contestId;
    List<String> userId;
    String categoryId;
    String contestName;
    Date contestTimeLimit;
    int noOfQuestions;
    Date contestStartTime;
    int questionIds;
    int noOfSkipsAllowed;
    private List<QuestionDTO> questionsIds;



}
