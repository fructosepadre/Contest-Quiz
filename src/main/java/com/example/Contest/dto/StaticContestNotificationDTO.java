package com.example.Contest.dto;

import java.util.List;

public class StaticContestNotificationDTO {

    String appId;
    String notificationType; ///question start,question end,question remove,quiz end
    String message;
    List<StaticContestDTO> staticContestDTOS;
}
