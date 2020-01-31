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

    @GetMapping(value = "/getDynamicContestByAdmin/{adminId}")
    public List<DynamicContestDTO> getDynamicContestByAdmin(@PathVariable("adminId") String adminId){
        return dynamicContestInterface.getDynamicContestByUserId(adminId);
    }

    @GetMapping(value = "/getStaticContestByAdmin/{adminId}")
    public List<StaticContestDTO> getStaticContestByAdmin(@PathVariable("adminId") String adminId){
        return staticContestInterface.getStaticContestByUserId(adminId);
    }


  @GetMapping(value="/getContest/{contestId}")
  public StaticContestDTO getContest(@PathVariable("contestId") String contestId){
      return staticContestInterface.getContest(contestId);
  }


    @GetMapping(value="/getDynamicContest/{contestId}")
    public DynamicContestDTO getDynamicContest(@PathVariable("contestId") String contestId){
        return dynamicContestInterface.getContest(contestId);
    }

    @GetMapping(value="/getStaticContest/{contestId}")
    public StaticContestDTO getStaticContest(@PathVariable("contestId") String contestId){
        return staticContestInterface.getContest(contestId);
    }



    @PostMapping(value = "registerUser/{contestId}/{userId}/{contestType}")
    public void registerUserToStaticContest(@PathVariable("contestId") String contestId,@PathVariable("userId") String userId,@PathVariable("contestType") String contestType){
      contestRegistrationInterface.registerUser(contestId,userId,contestType);
    }

    ///Implement notification
    @PostMapping(value = "/getDynamicQuestionFromAdmin/{contestId}/{questionId}")
    public void getDynamicQuestionFromAdmin(@PathVariable("contestId") String contestId,@PathVariable("questionId") String questionId){
      dynamicContestInterface.setDynamicNotification(contestId,questionId);

    }

    @PostMapping(value = "/dynamicContestEnd/{contestId}")
    public void endDynamicContest(@PathVariable("contestId") String contestId){
        dynamicContestInterface.endDynamicContest(contestId);
    }



}
