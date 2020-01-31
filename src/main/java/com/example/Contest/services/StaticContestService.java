package com.example.Contest.services;


import com.example.Contest.dto.*;
import com.example.Contest.entity.ContestRegistration;
import com.example.Contest.entity.DynamicContest;
import com.example.Contest.entity.StaticContest;
import com.example.Contest.repository.ContestRegisterRepository;
import com.example.Contest.repository.StaticContestRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StaticContestService implements StaticContestInterface{

    @Autowired
    StaticContestRepository staticContestRepository;

    @Autowired
    ContestRegisterRepository contestRegisterRepository;

    @Override
    public void addStaticContest(StaticContestDTO staticContestDTO) {
        StaticContest staticContest = new StaticContest();
        BeanUtils.copyProperties(staticContestDTO,staticContest);
        staticContestRepository.save(staticContest);
        StaticContestNotificationDTO staticContestNotificationDTO = new StaticContestNotificationDTO();
        staticContestNotificationDTO.setAppId("Quiz");
        staticContestNotificationDTO.setMessage("Question has been uploaded for the contest " + staticContestDTO.getContestName());
        List<String> userIds = new ArrayList<>();
        List<ContestRegistration> contestRegistrations = contestRegisterRepository.findByContestId(staticContest.getContestId());
        for (ContestRegistration contestRegistration:contestRegistrations) {
            userIds.add(contestRegistration.getUserId());
        }
        staticContestNotificationDTO.setUserId(userIds);
        staticContestNotificationDTO.setNotificationSendTime(staticContest.getContestStartTime());
        ///send to notification service

    }

    @Override
    public void subscribeUser(String userId) {
        //staticContestRepository;
    }

    @Override
    public List<StaticContestDTO> getStaticContestByCategory(String categoryId) {
            List<StaticContest> staticContests = staticContestRepository.findByCategoryId(categoryId);
            List<StaticContestDTO> staticContestDTOS = new ArrayList<>();
            for (StaticContest contest : staticContests) {
                StaticContestDTO contestDTO = new StaticContestDTO();
                BeanUtils.copyProperties(contest,contestDTO);
                staticContestDTOS.add(contestDTO);
            }
            return staticContestDTOS;
        }


    @Override
    public StaticContestDTO getContest(String contestId) {
        StaticContestDTO staticContestDTO = new StaticContestDTO();
        Optional<StaticContest> staticContest = staticContestRepository.findById(contestId);
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        if(staticContest.isPresent()){
             BeanUtils.copyProperties(staticContest,staticContestDTO);
             return staticContestDTO;
        }
           return null;
    }

    @Override
    public List<StaticContestDTO> getStaticContestByUserId(String adminId) {
        List<StaticContest> staticContests = staticContestRepository.findByAdminId(adminId);
        List<StaticContestDTO> staticContestDTOS = new ArrayList<>();
        for (StaticContest staticContest : staticContests) {
            StaticContestDTO staticContestDTO = new StaticContestDTO();
            BeanUtils.copyProperties(staticContest,staticContestDTO);
            LocalDateTime now = LocalDateTime.now();
            if(now.isAfter(staticContest.getContestEndTime())){
                staticContestDTO.setCompleted(true);
            }
            staticContestDTOS.add(staticContestDTO);
        }
        return staticContestDTOS;
    }
}


