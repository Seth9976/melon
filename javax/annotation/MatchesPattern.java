package javax.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.regex.Pattern;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@TypeQualifier(applicableTo = String.class)
public @interface MatchesPattern {
    public static class Checker implements TypeQualifierValidator {
        @Override  // javax.annotation.meta.TypeQualifierValidator
        public When forConstantValue(Annotation annotation0, Object object0) {
            return this.forConstantValue(((MatchesPattern)annotation0), object0);
        }

        // 去混淆评级： 低(20)
        public When forConstantValue(MatchesPattern matchesPattern0, Object object0) {
            return Pattern.compile(matchesPattern0.value(), matchesPattern0.flags()).matcher(((String)object0)).matches() ? When.ALWAYS : When.NEVER;
        }
    }

    int flags() default 0;

    @RegEx
    String value();
}

