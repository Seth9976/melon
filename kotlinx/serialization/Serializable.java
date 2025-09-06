package kotlinx.serialization;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u001D\u0012\u0014\b\u0002\u0010\u0004\u001A\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001D\u0010\u0004\u001A\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u00028\u0006¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/serialization/Serializable;", "", "LDe/d;", "Lkotlinx/serialization/KSerializer;", "with", "<init>", "(LDe/d;)V", "()Ljava/lang/Class;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public @interface Serializable {
    Class with() default KSerializer.class;
}

