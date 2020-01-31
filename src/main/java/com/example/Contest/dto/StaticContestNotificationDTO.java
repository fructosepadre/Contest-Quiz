package com.example.Contest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class StaticContestNotificationDTO {

    String appId;
    String notificationType; ///question start,question end,question remove,quiz end
    String message;
    List<String> userId;
    Date notificationSendTime;
}
