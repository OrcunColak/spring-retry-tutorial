package com.colak.springannotationsretryabletutorial.service2;

import com.colak.springannotationsretryabletutorial.exceptions.ExceptionType;
import com.colak.springannotationsretryabletutorial.exceptions.MyNetworkException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyRetryableService2Test {

    @Autowired
    private MyRetryableService2 myRetryableService2;


    @Test
    void testFetchDataFromRemote2() {
        String input = "foo";
        Assertions.assertThrows(MyNetworkException.class,
                () -> myRetryableService2.fetchDataFromRemote2(ExceptionType.MY_NETWORK_EXCEPTION, input)
        );
    }
}
