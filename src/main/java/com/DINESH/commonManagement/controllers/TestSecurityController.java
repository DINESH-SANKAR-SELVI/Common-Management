package com.DINESH.commonManagement.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
//@PreAuthorize("hasAuthority('CUSTOMER')")
public class TestSecurityController {

//    @Autowired
//    private JwtUtil jwtUtil;

    @GetMapping("sayhello")
//    @PreAuthorize("hasAuthority('DEVELOPER')")
    public ResponseEntity<?> sayHello(){
        return new ResponseEntity<>("Hello BOSS..!", HttpStatus.OK);
    }

    @GetMapping("sayHello")
//    @PreAuthorize("hasAuthority('COMPANYFOUNDER') or hasAuthority('ADMIN')")
    public ResponseEntity<?> sayHelloToAdmin(){
        return new ResponseEntity<>("Hello Admin/CompanyFounder..!", HttpStatus.OK);
    }

    @GetMapping("SayHello")
//    @PreAuthorize("hasAuthority('SHOPFOUNDER') or hasAuthority('BRANCHMANAGER')")
    public ResponseEntity<?> sayHelloToManager(){
        return new ResponseEntity<>("Hello Admin/CompanyFounder..!", HttpStatus.OK);
    }
}
