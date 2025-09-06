package vg;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface j {
    boolean allowUnsafeNonAsciiValues() default false;
}

