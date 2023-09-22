package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @PostMapping("/process")
    public MyResponse processRequest(@RequestBody MyRequest request) {
        MyResponse response = new MyResponse();
        response.setResponse("Данные из запроса: " + request.getMessage());
        return response;
    }
}
