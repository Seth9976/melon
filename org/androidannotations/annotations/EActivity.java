package org.androidannotations.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.androidannotations.api.KotlinOpen;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE})
@KotlinOpen
public @interface EActivity {
    String resName() default "";

    int value() default -1;
}

