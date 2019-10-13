package io.berkel.async.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RestController
public class AsyncController {

    private static final Logger logger = LoggerFactory.getLogger(AsyncController.class);

    @PostMapping("/expensiveoperation")
    public ResponseEntity<Void> expensiveOperation() {

        Runnable runnableTask = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(600000);
                logger.info("Expensive operation completed");
            } catch (InterruptedException e) {
                logger.error("Exception occured.");
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(runnableTask);
        executorService.shutdown();

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();

    }

}