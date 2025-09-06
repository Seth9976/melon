package org.androidannotations.annotations.sharedpreferences;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE})
public @interface SharedPref {
    public static enum Scope {
        APPLICATION_DEFAULT,
        ACTIVITY,
        ACTIVITY_DEFAULT,
        UNIQUE;

    }

    int mode() default 0;

    String name() default "";

    Scope value() default Scope.ACTIVITY;
}

