package com.mclx.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface RestUrl {

    String url();
}
