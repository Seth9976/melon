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
@TypeQualifier(applicableTo = Number.class)
public @interface Nonnegative {
    public static class Checker implements TypeQualifierValidator {
        @Override  // javax.annotation.meta.TypeQualifierValidator
        public When forConstantValue(Annotation annotation0, Object object0) {
            return this.forConstantValue(((Nonnegative)annotation0), object0);
        }

        public When forConstantValue(Nonnegative nonnegative0, Object object0) {
            if(!(object0 instanceof Number)) {
                return When.NEVER;
            }
            if(((Number)object0) instanceof Long) {
                return ((Number)object0).longValue() >= 0L ? When.ALWAYS : When.NEVER;
            }
            if(((Number)object0) instanceof Double) {
                return ((Number)object0).doubleValue() < 0.0 ? When.NEVER : When.ALWAYS;
            }
            if(((Number)object0) instanceof Float) {
                return ((Number)object0).floatValue() < 0.0f ? When.NEVER : When.ALWAYS;
            }
            return ((Number)object0).intValue() >= 0 ? When.ALWAYS : When.NEVER;
        }
    }

    When when() default When.ALWAYS;
}

