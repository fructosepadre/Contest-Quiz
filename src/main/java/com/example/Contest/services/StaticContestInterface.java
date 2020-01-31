package com.example.Contest.services;

import com.example.Contest.dto.QuestionDTO;
import com.example.Contest.dto.StaticContestDTO;

import java.util.List;

public interface StaticContestInterface {
    void addStaticContest(StaticContestDTO staticContestDTO);

    void subscribeUser(String userId);

    List<StaticContestDTO> getStaticContestByCategory(String categoryId);

    StaticContestDTO getContest(String contestId);

}
