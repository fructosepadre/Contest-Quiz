package com.example.Contest.repository;

import com.example.Contest.dto.StaticContestDTO;
import com.example.Contest.entity.StaticContest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StaticContestRepository extends MongoRepository<StaticContest,String> {


    List<StaticContest> findByCategoryId(String categoryId);

}
