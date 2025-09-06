package org.androidannotations.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD})
public @interface Receiver {
    @Retention(RetentionPolicy.CLASS)
    @Target({ElementType.PARAMETER})
    public @interface Extra {
        String value() default "";
    }

    public static enum RegisterAt {
        OnCreateOnDestroy,
        OnStartOnStop,
        OnResumeOnPause,
        OnAttachOnDetach;

    }

    String[] actions();

    String[] dataSchemes() default {};

    boolean local() default false;

    RegisterAt registerAt() default RegisterAt.OnCreateOnDestroy;
}

