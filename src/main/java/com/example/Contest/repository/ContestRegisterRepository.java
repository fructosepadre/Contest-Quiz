package com.example.Contest.repository;

import com.example.Contest.entity.ContestRegistration;
import com.example.Contest.entity.DynamicContest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ContestRegisterRepository extends MongoRepository<ContestRegistration,String> {

    List<ContestRegistration> findByContestId(String contestId);


}
