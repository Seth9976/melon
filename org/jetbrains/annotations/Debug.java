package org.jetbrains.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.intellij.lang.annotations.Language;

public final class Debug {
    @Retention(RetentionPolicy.CLASS)
    @Target({ElementType.TYPE})
    public @interface Renderer {
        @Language(prefix = "class Renderer{Object[] $childrenArray(){return ", suffix = ";}}", value = "JAVA")
        @NonNls
        String childrenArray() default "";

        @Language(prefix = "class Renderer{boolean $hasChildren(){return ", suffix = ";}}", value = "JAVA")
        @NonNls
        String hasChildren() default "";

        @Language(prefix = "class Renderer{String $text(){return ", suffix = ";}}", value = "JAVA")
        @NonNls
        String text() default "";
    }

    private Debug() {
        throw new AssertionError("Debug should not be instantiated");
    }
}

