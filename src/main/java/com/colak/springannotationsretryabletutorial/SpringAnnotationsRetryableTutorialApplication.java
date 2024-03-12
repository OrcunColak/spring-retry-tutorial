package com.colak.springannotationsretryabletutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
// This annotation will enable spring boot retry pattern and then only @Retryable annotation will work
@EnableRetry
public class SpringAnnotationsRetryableTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAnnotationsRetryableTutorialApplication.class, args);
    }

}
