package com.org.queue.app.service;

import com.org.queue.app.dto.IncompleteQueueDto;
import com.org.queue.app.model.AEData;
import com.org.queue.app.repository.AEDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AEDataService {
    @Autowired
    private AEDataRepository repository;

    public List<IncompleteQueueDto> incompleteQueue(){
        List<AEData> aeDataList = repository.findAll();

        return  aeDataList.stream().map(aeData->IncompleteQueueDto.builder()
                .docId(aeData.getId())
                .userName(aeData.getField4())
                .sentTo(aeData.getField8())
                .received(aeData.getReceiptDt())
                .processed(aeData.getReceiptDt())
                .faxId(aeData.getField6())
                .lot(aeData.getField7())
                .loanId(aeData.getField1())
                .build()).collect(Collectors.toList());

    }

}
