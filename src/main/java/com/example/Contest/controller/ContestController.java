package com.example.Contest.controller;

import com.example.Contest.dto.DynamicContestDTO;
import com.example.Contest.dto.QuestionDTO;
import com.example.Contest.dto.StaticContestDTO;
import com.example.Contest.entity.DynamicContest;
import com.example.Contest.entity.StaticContest;
import com.example.Contest.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/contest")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContestController {

    @Autowired
    private StaticContestInterface staticContestInterface;

    @Autowired
    private DynamicContestInterface dynamicContestInterface;

    @Autowired
    private ContestRegistrationInterface contestRegistrationInterface;

    @Autowired
    NotificationService notificationService;

    @PostMapping(value="/addStaticContest")
    public String addStaticContest(@RequestBody StaticContestDTO staticContestDTO){
        staticContestInterface.addStaticContest(staticContestDTO);
        return "yes";
    }

    @PostMapping(value="/addDynamicContest")
    public String addDynamicContest(@RequestBody DynamicContestDTO dynamicContestDTO){
        dynamicContestInterface.addDynamicContest(dynamicContestDTO);
        return "yes";
    }

    @PostMapping(value = "/dynamicContestStart/{userId}")
    public ResponseEntity<String> dynamicContestStart(@PathVariable("userId") String UserId){
        notificationService.sendNotification(UserId);
        return null;
    }

    @GetMapping(value = "/getStaticContestsByCategory/{categoryId}")
    public List<StaticContestDTO> getStaticContestsByCategory(@PathVariable("categoryId") String categoryId){
        return staticContestInterface.getStaticContestByCategory(categoryId);

    }

    @GetMapping(value = "/getDynmicContestByCategory/{categoryId}")
    public List<DynamicContestDTO> getDynamicContestByCategory(@PathVariable("categoryId") String categoryId){
        return dynamicContestInterface.getDynamicContestByCategory(categoryId);
    }

   public List<DynamicContestDTO> getDynamicContestByAdmin(@PathVariable("adminId") String adminId){
        return dynamicContestInterface.getDynamicContestByUserId(adminId);
    }




  /*  @PostMapping(value="/subscribeUser/{userID}/{ContestType}/{contestId}")
    public ResponseEntity<String> subscribeUser(@PathVariable("userId") String userId,@PathVariable("contestType") boolean contestType,@PathVariable("contestId") String contestId){
        if(contestType) staticContestInterface.subscribeUser(userId);
    }*/

 // @GetMapping(value = "/getQuestionsByContest")
  //POints calculation will hit this to fetch the details of a particular contest to validate the answers
  @GetMapping(value="/getContest/{contestId}")
  public StaticContestDTO getContest(@PathVariable("contestId") String contestId){
      return staticContestInterface.getContest(contestId);
  }


    @GetMapping(value="/getDynamicContest/{contestId}")
    public DynamicContestDTO getDynamicContest(@PathVariable("contestId") String contestId){
        return dynamicContestInterface.getContest(contestId);
    }

    @PostMapping(value ="setDynamicNotification/{contestId}")
    public void setDynamicNotification(@PathVariable("contestId") String contestId,@RequestBody QuestionDTO questionDto){
      dynamicContestInterface.setDynamicNotification(contestId,questionDto);
    }

    @PostMapping(value = "registerUser/{contestId}/{userId}/{contestType}")
    public void registerUserToStaticContest(@PathVariable("contestId") String contestId,@PathVariable("userId") String userId,@PathVariable("contestType") String contestType){
      contestRegistrationInterface.registerUser(contestId,userId,contestType);
    }

    @GetMapping(value = "khushboo/{contestId}")
    public QuestionDTO khushboo(@PathVariable("contestId") String contestId)
    {
       // return new ResponseEntity<>(contestId,HttpStatus.OK);
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setAnswers("abc");
        return questionDTO;
    }

    ///Implement notification
    @PostMapping(value = "/getDynamicQuestionFromAdmin/{contestId}/{questionId}")
    public void getDynamicQuestionFromAdmin(@PathVariable("contestId") String contestId,@PathVariable("questionId") String questionId){
      dynamicContestInterface.setDynamicNotification(contestId,questionId);


    }



}
