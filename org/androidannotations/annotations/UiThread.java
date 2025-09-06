package org.androidannotations.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD})
public @interface UiThread {
    public static enum Propagation {
        ENQUEUE,
        REUSE;

    }

    long delay() default 0L;

    String id() default "";

    Propagation propagation() default Propagation.ENQUEUE;
}

