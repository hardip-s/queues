package com.org.queue.app.exception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

//@RestController
public class MyErrorController implements ErrorController {

    private static final String PATH = "/error";

   // @RequestMapping(value = PATH )
    public String myerror(HttpServletRequest request              ) {

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

           /* if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error-404";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error-500";
            }*/
        }
        return "Something went wrong error:"+status;
        //return "<center><h1>Something went wrong</h1></center>";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

}