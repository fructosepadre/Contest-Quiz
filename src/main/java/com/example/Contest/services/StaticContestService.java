package com.example.Contest.services;


import com.example.Contest.dto.DynamicContestDTO;
import com.example.Contest.dto.QuestionDTO;
import com.example.Contest.dto.RegisterUserDTO;
import com.example.Contest.dto.StaticContestDTO;
import com.example.Contest.entity.ContestRegistration;
import com.example.Contest.entity.DynamicContest;
import com.example.Contest.entity.StaticContest;
import com.example.Contest.repository.StaticContestRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StaticContestService implements StaticContestInterface{

    @Autowired
    StaticContestRepository staticContestRepository;

    @Override
    public void addStaticContest(StaticContestDTO staticContestDTO) {
        StaticContest staticContest = new StaticContest();
        BeanUtils.copyProperties(staticContestDTO,staticContest);
        staticContestRepository.save(staticContest);

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


}


