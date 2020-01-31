package com.example.Contest.services;

import com.example.Contest.dto.RegisterUserDTO;
import com.example.Contest.entity.ContestRegistration;
import com.example.Contest.repository.ContestRegisterRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//todo : move to impl package under services
@Service
public class ContestRegistrationService implements ContestRegistrationInterface {

    @Autowired
    ContestRegisterRepository contestRegisterRepository;

    @Override
    public void registerUser(String contestId, String userId,String contestType) {
        RegisterUserDTO registerUserDTO = new RegisterUserDTO();
        registerUserDTO.setContestId(contestId);
        registerUserDTO.setUserId(userId);
        ContestRegistration contestRegistration = new ContestRegistration();
        BeanUtils.copyProperties(registerUserDTO,contestRegistration);
        contestRegisterRepository.save(contestRegistration);
    }
}
