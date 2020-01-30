package com.example.Contest.controller;

import com.example.Contest.dto.DynamicContestDTO;
import com.example.Contest.dto.StaticContestDTO;
import com.example.Contest.entity.DynamicContest;
import com.example.Contest.entity.StaticContest;
import com.example.Contest.services.DynamicContestInterface;
import com.example.Contest.services.NotificationService;
import com.example.Contest.services.StaticContestInterface;
import com.example.Contest.services.StaticContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/contest")
public class ContestController {

    @Autowired
    private StaticContestInterface staticContestInterface;

    @Autowired
    private DynamicContestInterface dynamicContestInterface;

    @Autowired
    NotificationService notificationService;

    @PostMapping(value="/addStaticContest")
    public ResponseEntity<String> addStaticContest(@RequestBody StaticContestDTO staticContestDTO){
        staticContestInterface.addStaticContest(staticContestDTO);
        return null;

    }

    @PostMapping(value="/addDynamicContest")
    public ResponseEntity<String> addDynamicContest(@RequestBody DynamicContestDTO dynamicContestDTO){
        dynamicContestInterface.addDynamicContest(dynamicContestDTO);
        return null;
    }

    @PostMapping(value = "/dynamicContestStart/{userId}")
    public ResponseEntity<String> dynamicContestStart(@PathVariable String UserId){
        notificationService.sendNotification(UserId);
        return null;
    }





}
