package com.lc.dr.aspect;

import com.lc.dr.annotations.MethodApi;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Desc:
 * Author:   licheng
 * Datetime: 2017-03-30 11:21
 */
@Aspect
@Configuration
public class MethodApiAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodApiAspect.class);

    @Around("@annotation(methodApi)")
    public Object around(ProceedingJoinPoint joinPoint, MethodApi methodApi) throws Throwable {
        String methodName = joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName();
        String inputInfo = methodName + "(" + Arrays.toString(joinPoint.getArgs()) + ")";
        if (methodApi.params()) {
            LOGGER.info(inputInfo);
        }
        Object object = joinPoint.proceed();
        if (methodApi.result()) {
            LOGGER.info(String.valueOf(object));
        }
        return object;
    }
}
