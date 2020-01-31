package com.example.Contest.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection="ContestRegistration")
public class ContestRegistration {

    @Id
    private String keyId;
    private String userId;
    private String contestId;
    private String contestType;
}
