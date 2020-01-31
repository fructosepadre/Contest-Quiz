package com.example.Contest.services;

import com.example.Contest.dto.DynamicContestDTO;
import com.example.Contest.dto.DynamicContestNotificationDTO;
import com.example.Contest.dto.QuestionDTO;
import com.example.Contest.entity.ContestRegistration;
import com.example.Contest.entity.DynamicContest;
import com.example.Contest.entity.StaticContest;
import com.example.Contest.repository.ContestRegisterRepository;
import com.example.Contest.repository.DynamicContestRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DynamicContestService implements DynamicContestInterface {

    @Autowired
    DynamicContestRepository dynamicContestRepository;
    //todo :: QuestionDetails to QuestionDTO copy code !!

    @Autowired
    ContestRegisterRepository contestRegisterRepository;

    @Override
    public void addDynamicContest(DynamicContestDTO dynamicContestDTO) {
        DynamicContest dynamicContest = new DynamicContest();
        BeanUtils.copyProperties(dynamicContestDTO,dynamicContest);
        dynamicContestRepository.save(dynamicContest);

    }

    @Override
    public List<DynamicContestDTO> getDynamicContestByCategory(String categoryId) {
        List<DynamicContest> dynamicContests = dynamicContestRepository.findByCategoryId(categoryId);
        List<DynamicContestDTO> dynamicContestDTOS = new ArrayList<>();
        for (DynamicContest contest : dynamicContests) {
            DynamicContestDTO contestDTO = new DynamicContestDTO();
            BeanUtils.copyProperties(contest,contestDTO);
            dynamicContestDTOS.add(contestDTO);
            //todo :: QuestionDetails to QuestionDTO copy code !!
        }
        return dynamicContestDTOS;
    }

    @Override
    public DynamicContestDTO getContest(String contestId) {
        DynamicContestDTO dynamicContestDTO = new DynamicContestDTO();
        Optional<DynamicContest> dynamicContest = dynamicContestRepository.findById(contestId);
        if(dynamicContest.isPresent()){
            BeanUtils.copyProperties(dynamicContest,dynamicContestDTO);
            return dynamicContestDTO;
        }
        return null;
    }

    @Override
    public List<DynamicContestDTO> getDynamicContestByUserId(String adminId) {
        return dynamicContestRepository.findByAdminId(adminId);
    }

    @Override
    public void setDynamicNotification(String contestId, String questionId) {
       DynamicContestNotificationDTO dynamicContestNotificationDTO = new DynamicContestNotificationDTO();
       dynamicContestNotificationDTO.setAppId("Quiz");
       String contestName = "";
       //// Change JPA to find by a particular id
       Optional<DynamicContest> dynamicContest = dynamicContestRepository.findById(contestId);
       if(dynamicContest.isPresent()) contestName = dynamicContest.get().getContestName();
       dynamicContestNotificationDTO.setMessage("Question has been uploaded for the contest " + contestName);
       List<String> userIds = new ArrayList<>();
       List<ContestRegistration> contestRegistrations = contestRegisterRepository.findByContestId(contestId);
        for (ContestRegistration contestRegistration:contestRegistrations) {
            userIds.add(contestRegistration.getUserId());
        }
        dynamicContestNotificationDTO.setUserId(userIds);
    }
}
