package com.colak.springannotationsretryabletutorial.service1;

import com.colak.springannotationsretryabletutorial.exceptions.ExceptionType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyRetryableService1Test {

    @Autowired
    private MyRetryableService1 myRetryableService1;

    @ParameterizedTest
    @EnumSource(ExceptionType.class)
    void testFetchDataFromRemote(ExceptionType exceptionType) throws Exception {
        String input = "foo";
        String expectedValue = getExpectedValue(exceptionType, input);

        String result = myRetryableService1.fetchDataFromRemote(exceptionType, input);
        Assertions.assertEquals(expectedValue, result);
    }

    private String getExpectedValue(ExceptionType exceptionType, String input) {
        return switch (exceptionType) {
            case NONE -> input;
            case MY_NETWORK_EXCEPTION -> "Default " + input;
            case MY_TIMEOUT_EXCEPTION -> "Default 2 " + input;
        };
    }

}
