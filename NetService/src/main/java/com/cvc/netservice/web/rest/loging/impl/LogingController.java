package com.cvc.netservice.web.rest.loging.impl;

import com.cvc.netservice.service.LogingService;
import com.cvc.netservice.service.dto.UserDTO;
import com.cvc.netservice.web.rest.loging.LogingApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class LogingController implements LogingApi {

    @Autowired
    private LogingService logingService;

    @Override
    public ResponseEntity<Boolean> loging(String username, String password) {
        UserDTO userDTO = logingService.findOne(1L);

        return null;
    }
}
