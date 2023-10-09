package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OkController {

    @Autowired
    private PostRequestStorage postRequestStorage;

    @GetMapping("/ok")
    public ResponseEntity<?> okGet() {
        List<String> postRequests = postRequestStorage.getAllPostRequests();
        if (postRequests.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No data available.");
        } else {
            StringBuilder response = new StringBuilder("Response to GET request: ");
            for (String data : postRequests) {
                response.append(data).append(", ");
            }
            response.setLength(response.length() - 2);
            return ResponseEntity.ok(response.toString());
        }
    }

    @PostMapping("/ok")
    public ResponseEntity<?> okPost(@RequestBody String requestBody) {
        if (isNumeric(requestBody)) {
            postRequestStorage.addPostRequest(requestBody);
            return ResponseEntity.status(HttpStatus.CREATED).body("Response to POST request: Data saved.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Response to POST request: Invalid input. Only numbers are allowed.");
        }
    }

    @PostMapping("/clean")
    public ResponseEntity<?> clean() {
        postRequestStorage.clearPostRequests();
        return ResponseEntity.ok("Response to POST request: Data cleaned.");
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
