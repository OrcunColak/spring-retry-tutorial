package com.colak.springannotationsretryabletutorial.service2;

import com.colak.springannotationsretryabletutorial.exceptions.ExceptionType;
import com.colak.springannotationsretryabletutorial.exceptions.MyNetworkException;
import com.colak.springannotationsretryabletutorial.exceptions.MyTimeoutException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service

@RequiredArgsConstructor
public class MyRetryableService2 {

    private final RetryTemplate retryTemplate;

    /**
     * This method is an example for retryTemplate
     */
    public String fetchDataFromRemote2(ExceptionType exceptionType, String input) throws Exception {
        // As Retry Template we are configuring with all details at the single place in bean registration, so it will
        // be common for all the services where we are going to implement it.
        // Another note is Retry Template is a thread safe class, so you can use it concurrently in multiple threads.
        return retryTemplate.execute(rt -> {
            log.info("fetchDataFromRemote2 is called with {}", input);
            if (exceptionType == ExceptionType.MY_NETWORK_EXCEPTION) {
                throw new MyNetworkException("MyNetworkException");
            } else if (exceptionType == ExceptionType.MY_TIMEOUT_EXCEPTION) {
                throw new MyTimeoutException("MyTimeoutException");
            }
            return input;
        });
    }
}
