package org.androidannotations.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD})
public @interface Trace {
    public static final String DEFAULT_TAG = "NO_TAG";

    int level() default 4;

    String tag() default "NO_TAG";
}

