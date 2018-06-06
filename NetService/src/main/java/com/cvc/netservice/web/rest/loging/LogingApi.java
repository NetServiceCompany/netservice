package com.cvc.netservice.web.rest.loging;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/login")
public interface LogingApi {

    @ApiOperation(value = "AUTHO LOGING", notes = "", response = Boolean.class, tags = {"LOGING",})
    @GetMapping("")
    ResponseEntity<Boolean> loging(@RequestParam(value = "username", required = true) String username,
                                   @RequestParam(value = "password", required = false) String password);
}
