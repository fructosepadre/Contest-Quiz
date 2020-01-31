package com.example.Contest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class DynamicContestNotificationDTO {
    String appId;
    String title; ///question start,question end,question remove,quiz end
    String message;
    String questionId;
    List<String> userId;

}
