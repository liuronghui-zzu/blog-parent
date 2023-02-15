package com.lrh.blog.common.aop;

import java.lang.annotation.*;

//type代表可以放在类上面 method放在类方法上
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    String module() default "";
    String operator() default "";

}
