package com.kevin.easyaudiorecord.action;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

/**
 * @author : 王康
 * @date : 2021/9/13
 * @desc :
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface TestAction {
}
