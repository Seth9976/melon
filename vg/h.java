package vg;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface h {
    boolean hasBody() default false;

    String method();

    String path() default "";
}

