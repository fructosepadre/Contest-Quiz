package com.example.Contest.entity;


import com.example.Contest.dto.QuestionDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Document(collection = "DynamicContest")
public class DynamicContest {

    @Id
    String contestId;
    //todo : this should be moved to different colleciton
   // List<String> userId;
    String categoryId;
    String contestName;
    //todo :: not needed, it is driven by the administrator
    LocalDateTime contestEndTime;
    int noOfQuestions;
    Date contestStartTime;
    String adminId;
    // not needed, left to user to answer or not !!
    int noOfSkipsAllowed;
    //todo : need to have list of questions associated with the contest here, , wihtout user details !!!

    // todo : user responses should be stroed in different collection, because it is different actor
    private List<QuestionDetails> questions;



}
