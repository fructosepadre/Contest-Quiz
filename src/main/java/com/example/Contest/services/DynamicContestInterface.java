package com.example.Contest.services;

import com.example.Contest.dto.DynamicContestDTO;
import com.example.Contest.dto.QuestionDTO;

import java.util.List;

public interface DynamicContestInterface {
    void addDynamicContest(DynamicContestDTO dynamicContestDTO);

    List<DynamicContestDTO> getDynamicContestByCategory(String categoryId);

    DynamicContestDTO getContest(String contestId);

    List<DynamicContestDTO> getDynamicContestByUserId(String adminId);

    void setDynamicNotification(String contestId, String questionId);

    void endDynamicContest(String contestId);
}
