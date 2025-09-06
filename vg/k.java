package vg;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface k {
    boolean allowUnsafeNonAsciiValues() default false;

    String[] value();
}

