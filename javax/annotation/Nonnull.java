package javax.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@TypeQualifier
public @interface Nonnull {
    public static class Checker implements TypeQualifierValidator {
        @Override  // javax.annotation.meta.TypeQualifierValidator
        public When forConstantValue(Annotation annotation0, Object object0) {
            return this.forConstantValue(((Nonnull)annotation0), object0);
        }

        public When forConstantValue(Nonnull nonnull0, Object object0) {
            return object0 == null ? When.NEVER : When.ALWAYS;
        }
    }

    When when() default When.ALWAYS;
}

