package co.ab180.airbridge.internal.parser;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u001D\u0012\u0014\u0010\u0005\u001A\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001F\u0010\u0005\u001A\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00028\u0006¢\u0006\u0006\u001A\u0004\b\u0005\u0010\b¨\u0006\t"}, d2 = {"Lco/ab180/airbridge/internal/parser/RuleWith;", "", "LDe/d;", "Lco/ab180/airbridge/internal/parser/e/y;", "", "value", "<init>", "(LDe/d;)V", "()Ljava/lang/Class;", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public @interface RuleWith {
    Class value();
}

