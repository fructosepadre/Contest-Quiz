package com.example.Contest.services;

import com.example.Contest.dto.DynamicContestDTO;
import com.example.Contest.entity.DynamicContest;
import com.example.Contest.entity.StaticContest;
import com.example.Contest.repository.DynamicContestRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DynamicContestService implements DynamicContestInterface {

    @Autowired
    DynamicContestRepository dynamicContestRepository;


    @Override
    public void addDynamicContest(DynamicContestDTO dynamicContestDTO) {
        DynamicContest dynamicContest = new DynamicContest();
        BeanUtils.copyProperties(dynamicContestDTO,dynamicContest);
        dynamicContestRepository.save(dynamicContest);

    }
}
