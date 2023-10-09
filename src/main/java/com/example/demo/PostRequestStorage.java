package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostRequestStorage {

    private List<String> postRequests = new ArrayList<>();

    public void addPostRequest(String requestBody) {
        postRequests.add(requestBody);
    }

    public List<String> getAllPostRequests() {
        return postRequests;
    }

    public void clearPostRequests() {
        postRequests.clear();
    }
}
