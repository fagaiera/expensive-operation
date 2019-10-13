package io.berkel.async.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @PostMapping("/booktransaction")
    public ResponseEntity<Void> bookTransaction() {

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}