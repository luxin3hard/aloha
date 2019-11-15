package com.mclx.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
//@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface RestPost {
    String path();
}
