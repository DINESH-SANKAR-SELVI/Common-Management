package com.DINESH.commonManagement.controllers;

import com.DINESH.commonManagement.services.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

    @Autowired
    private CommonService commonService;

    @GetMapping
    public ResponseEntity<?> welcomePage() throws Exception {
        return new ResponseEntity<>(commonService.goToSwagger(), HttpStatus.FOUND);
    }

    @GetMapping("sayhello")
    public ResponseEntity<?> sayHello() throws Exception {
        return new ResponseEntity<>(commonService.sayHello(), HttpStatus.FOUND);
    }
}
