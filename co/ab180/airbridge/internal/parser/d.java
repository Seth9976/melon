package co.ab180.airbridge.internal.parser;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0081\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0003\u001A\u00020\u00028\u0006@\u0006¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lco/ab180/airbridge/internal/parser/d;", "", "", "value", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public @interface d {
    String value();
}

