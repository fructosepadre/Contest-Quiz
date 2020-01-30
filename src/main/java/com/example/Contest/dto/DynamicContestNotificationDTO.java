package com.example.Contest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class DynamicContestNotificationDTO {


    String appId;
    String notificationType; ///question start,question end,question remove,quiz end
    String message;
    String FCMToken;
    List<DynamicContestDTO> dynamicContestDTOS;

}
