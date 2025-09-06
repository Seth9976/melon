package kotlinx.serialization.descriptors;

import De.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u001B\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u001B\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\n\u0010\u0004\u001A\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001A\u0010\n\u001A\u00020\t2\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0013\u001A\u00020\u000F2\u0006\u0010\u0012\u001A\u00020\fH\u0097\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0016\u001A\u00020\f2\u0006\u0010\u0015\u001A\u00020\u000FH\u0097\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001E\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0012\u001A\u00020\fH\u0097\u0001¢\u0006\u0004\b\u001A\u0010\u001BJ\u0018\u0010\u001C\u001A\u00020\u00012\u0006\u0010\u0012\u001A\u00020\fH\u0097\u0001¢\u0006\u0004\b\u001C\u0010\u001DJ\u0018\u0010\u001E\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\fH\u0097\u0001¢\u0006\u0004\b\u001E\u0010\u001FR\u0014\u0010\u0002\u001A\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010 R\u0018\u0010\u0004\u001A\u0006\u0012\u0002\b\u00030\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010!R\u001A\u0010\"\u001A\u00020\u000F8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001A\u0004\b$\u0010\u0011R\u0014\u0010(\u001A\u00020%8\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\b&\u0010\'R\u0014\u0010)\u001A\u00020\t8VX\u0097\u0005¢\u0006\u0006\u001A\u0004\b)\u0010*R\u0014\u0010+\u001A\u00020\t8VX\u0096\u0005¢\u0006\u0006\u001A\u0004\b+\u0010*R\u0014\u0010-\u001A\u00020\f8\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\b,\u0010\u000ER\u001A\u00100\u001A\b\u0012\u0004\u0012\u00020\u00190\u00188VX\u0097\u0005¢\u0006\u0006\u001A\u0004\b.\u0010/¨\u00061"}, d2 = {"Lkotlinx/serialization/descriptors/ContextDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "original", "LDe/d;", "kClass", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;LDe/d;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "index", "getElementName", "(I)Ljava/lang/String;", "name", "getElementIndex", "(Ljava/lang/String;)I", "", "", "getElementAnnotations", "(I)Ljava/util/List;", "getElementDescriptor", "(I)Lkotlinx/serialization/descriptors/SerialDescriptor;", "isElementOptional", "(I)Z", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "LDe/d;", "serialName", "Ljava/lang/String;", "getSerialName", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "kind", "isNullable", "()Z", "isInline", "getElementsCount", "elementsCount", "getAnnotations", "()Ljava/util/List;", "annotations", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
final class ContextDescriptor implements SerialDescriptor {
    @NotNull
    public final d kClass;
    @NotNull
    private final SerialDescriptor original;
    @NotNull
    private final String serialName;

    public ContextDescriptor(@NotNull SerialDescriptor serialDescriptor0, @NotNull d d0) {
        q.g(serialDescriptor0, "original");
        q.g(d0, "kClass");
        super();
        this.original = serialDescriptor0;
        this.kClass = d0;
        this.serialName = serialDescriptor0.getSerialName() + '<' + d0.m() + '>';
    }

    // 去混淆评级： 低(25)
    @Override
    public boolean equals(@Nullable Object object0) {
        ContextDescriptor contextDescriptor0 = object0 instanceof ContextDescriptor ? ((ContextDescriptor)object0) : null;
        return contextDescriptor0 == null ? false : q.b(this.original, contextDescriptor0.original) && q.b(contextDescriptor0.kClass, this.kClass);
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public List getAnnotations() {
        return this.original.getAnnotations();
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public List getElementAnnotations(int v) {
        return this.original.getElementAnnotations(v);
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public SerialDescriptor getElementDescriptor(int v) {
        return this.original.getElementDescriptor(v);
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementIndex(@NotNull String s) {
        q.g(s, "name");
        return this.original.getElementIndex(s);
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public String getElementName(int v) {
        return this.original.getElementName(v);
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementsCount() {
        return this.original.getElementsCount();
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public SerialKind getKind() {
        return this.original.getKind();
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public String getSerialName() {
        return this.serialName;
    }

    @Override
    public int hashCode() {
        return this.getSerialName().hashCode() + this.kClass.hashCode() * 0x1F;
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isElementOptional(int v) {
        return this.original.isElementOptional(v);
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return this.original.isInline();
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isNullable() {
        return this.original.isNullable();
    }

    @Override
    @NotNull
    public String toString() {
        return "ContextDescriptor(kClass: " + this.kClass + ", original: " + this.original + ')';
    }
}

