package com.example.Contest.repository;

import com.example.Contest.dto.DynamicContestDTO;
import com.example.Contest.entity.DynamicContest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DynamicContestRepository extends MongoRepository<DynamicContest,String> {
    List<DynamicContest> findByCategoryId(String categoryId);

    List<DynamicContestDTO> findByAdminId(String adminId);
}
