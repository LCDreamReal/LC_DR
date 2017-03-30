package com.lc.dr.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Desc:
 * Author:   licheng
 * Datetime: 2017-03-30 11:18
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MethodApi {

    boolean params() default true;

    boolean result() default false;
}
