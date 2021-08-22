package com.org.queue.app.controller;

import com.org.queue.app.dto.IncompleteQueueDto;
import com.org.queue.app.service.AEDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class AppController  {

    @Autowired
    private AEDataService service;

    @GetMapping(value = "/api/queue/incomplete")
    public List<IncompleteQueueDto> incompleteQueue() {
        return service.incompleteQueue();

    }

//    @RequestMapping("/error")
//    public String handleError(HttpServletRequest request) {
//        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//
//        if (status != null) {
//            Integer statusCode = Integer.valueOf(status.toString());
//
//           /* if(statusCode == HttpStatus.NOT_FOUND.value()) {
//                return "error-404";
//            }
//            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
//                return "error-500";
//            }*/
//        }
//        return "error:"+status;
//    }

}
