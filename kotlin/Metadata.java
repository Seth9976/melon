package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0002\b\u0016\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0096\u0001\u0012\u000E\b\u0002\u0010\u0002\u001A\u00020\u0003B\u0004\b\u0003\u0010\u0002\u0012\f\b\u0002\u0010\u0004\u001A\u00020\u0005B\u0002\b\f\u0012\u001E\b\u0002\u0010\u0006\u001A\u00020\u0005B\u0014\b\fJ\u0004\b\u0003\u0010\u0002J\u0004\b\u0003\u0010\u0000J\u0004\b\u0003\u0010\u0006\u0012\u0012\b\u0002\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\bB\u0002\b\f\u0012\u0012\b\u0002\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\bB\u0002\b\f\u0012\u000E\b\u0002\u0010\u000B\u001A\u00020\tB\u0004\b\b(\f\u0012\u000E\b\u0002\u0010\r\u001A\u00020\tB\u0004\b\b(\f\u0012\u000E\b\u0002\u0010\u000E\u001A\u00020\u0003B\u0004\b\u0003\u0010\u0000R\u0011\u0010\u0002\u001A\u00020\u00038G¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0004\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u001A\u0010\u0006\u001A\u00020\u00058GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0012R\u0017\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b8G¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u0017\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\b8G¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0017R\u0011\u0010\u000B\u001A\u00020\t8G¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001AR\u001A\u0010\r\u001A\u00020\t8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001B\u0010\u0014\u001A\u0004\b\u001C\u0010\u001AR\u001A\u0010\u000E\u001A\u00020\u00038GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001D\u0010\u0014\u001A\u0004\b\u001E\u0010\u0010¨\u0006\u001F"}, d2 = {"Lkotlin/Metadata;", "", "kind", "", "metadataVersion", "", "bytecodeVersion", "data1", "", "", "data2", "extraString", "", "packageName", "extraInt", "k", "()I", "mv", "()[I", "bv$annotations", "()V", "bv", "d1", "()[Ljava/lang/String;", "d2", "xs", "()Ljava/lang/String;", "pn$annotations", "pn", "xi$annotations", "xi", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public @interface Metadata {
    int[] bv() default {1, 0, 3};

    String[] d1() default {};

    String[] d2() default {};

    int k() default 1;

    int[] mv() default {};

    String pn() default "";

    int xi() default 0;

    String xs() default "";
}

