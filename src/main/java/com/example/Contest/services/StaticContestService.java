package com.example.Contest.services;


import com.example.Contest.dto.StaticContestDTO;
import com.example.Contest.entity.StaticContest;
import com.example.Contest.repository.StaticContestRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
