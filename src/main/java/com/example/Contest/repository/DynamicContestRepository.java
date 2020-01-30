package com.example.Contest.repository;

import com.example.Contest.entity.DynamicContest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DynamicContestRepository extends MongoRepository<DynamicContest,String> {
}
