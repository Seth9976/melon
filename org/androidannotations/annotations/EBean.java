package org.androidannotations.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.androidannotations.api.KotlinOpen;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE})
@KotlinOpen
public @interface EBean {
    public static enum Scope {
        Default,
        Activity,
        Fragment,
        Singleton;

    }

    Scope scope() default Scope.Default;
}

