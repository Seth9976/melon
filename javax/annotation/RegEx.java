package javax.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.annotation.meta.TypeQualifierNickname;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Syntax("RegEx")
@TypeQualifierNickname
public @interface RegEx {
    public static class Checker implements TypeQualifierValidator {
        @Override  // javax.annotation.meta.TypeQualifierValidator
        public When forConstantValue(Annotation annotation0, Object object0) {
            return this.forConstantValue(((RegEx)annotation0), object0);
        }

        public When forConstantValue(RegEx regEx0, Object object0) {
            if(!(object0 instanceof String)) {
                return When.NEVER;
            }
            try {
                Pattern.compile(((String)object0));
                return When.ALWAYS;
            }
            catch(PatternSyntaxException unused_ex) {
                return When.NEVER;
            }
        }
    }

    When when() default When.ALWAYS;
}

