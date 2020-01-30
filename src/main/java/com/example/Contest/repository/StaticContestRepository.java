package com.example.Contest.repository;

import com.example.Contest.entity.StaticContest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StaticContestRepository extends MongoRepository<StaticContest,String> {


}
