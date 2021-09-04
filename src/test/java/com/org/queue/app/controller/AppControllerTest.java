package com.org.queue.app.controller;

import com.org.queue.app.dto.IncompleteQueueDto;
import com.org.queue.app.model.AEData;
import com.org.queue.app.service.AEDataService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AppController.class)
class AppControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AEDataService service;

    @Test
    void hello() throws Exception {

        List<IncompleteQueueDto> list=new ArrayList<>();

        AEData aeData=new AEData();
        aeData.setField1("field1");
        aeData.setField4("FAXIN");

        IncompleteQueueDto.IncompleteQueueDtoBuilder builder = IncompleteQueueDto.builder();
        builder
                .docId(aeData.getId())
                .userName(aeData.getField4())
                .sentTo(aeData.getField8())
                .received(aeData.getReceiptDt())
                .processed(aeData.getProcessDt())
                .faxId(aeData.getField6())
                .lot(aeData.getField7())
                .loanId(aeData.getField1())
                .build();
        list.add(builder.build());
        when(service.incompleteQueue()).thenReturn(list);


        mockMvc.perform(get("/api/queue/incomplete")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].userName", Matchers.is("FAXIN")))
                .andExpect(jsonPath("$.[0].docId", Matchers.is(0)))
                .andExpect(jsonPath("$.*", Matchers.hasSize(1)));
/*
        RequestBuilder request = get("/api/queue/incomplete");
        MvcResult result = mvc.perform(request).andReturn();
        String respone = result.getResponse().getContentAsString();
        assertEquals("Hello, World", respone);

 */
    }

    @Test
    @Disabled
    public void testHelloWithName() throws Exception {
        mockMvc.perform(get("/hello?name=Dan"))
                .andExpect(content().string("Hello, Dan"));
    }
}