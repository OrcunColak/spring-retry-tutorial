package com.colak.springannotationsretryabletutorial.service1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryListener;

@Slf4j
public class MyRetryListenerBean implements RetryListener {

    @Override
    public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
        log.error("Retry attempt {} for retryable method {}",
                context.getRetryCount(),
                context.getAttribute("context.name"),
                throwable);
    }
}
