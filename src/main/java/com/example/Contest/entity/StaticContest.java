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
@Document(collection="StaticContest")
public class StaticContest {

    @Id
    String contestId;
    String categoryId;
    //todo : this should be moved to different colleciton

    String contestName;
    LocalDateTime contestEndTime;
    int noOfQuestions;
    Date contestStartTime;
    String adminId;
    Integer noOfSkipsAllowed;
    //todo : need to have list of questions associated with the contest here, wihtout user details !!!

    // todo : user responses should be stroed in different collection, because it is different actor
    private List<QuestionDetails> questions;
}
