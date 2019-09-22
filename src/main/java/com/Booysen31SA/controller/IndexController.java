package com.Booysen31SA.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @RequestMapping(value = {"/"})
    public ResponseEntity<String> home() {
        return new ResponseEntity<>("Welcome to Education App!", HttpStatus.OK);
    }

    @RequestMapping(value = {"/unsuccessful", "/Assignment-5"})
    public ResponseEntity<String> unsuccessful() {
        return new ResponseEntity<>("Welcome to Education App!", HttpStatus.OK);
    }

}
