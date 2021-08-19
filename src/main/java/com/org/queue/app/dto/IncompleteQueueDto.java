package com.org.queue.app.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;
@Getter
@Builder
public class IncompleteQueueDto {
     int  docId;
     String userName;
     String sentTo;
     Date received;
     Date processed;
     String faxId;
     String lot;
     int loanId;

}
