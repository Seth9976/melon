package kotlinx.serialization.internal;

import i.n.i.b.a.s.e.M3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor.DefaultImpls;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001B\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0010\u001A\u00020\u00032\u0006\u0010\u0011\u001A\u00020\rH\u0016J\u0010\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\u0003H\u0016J\u0010\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0011\u001A\u00020\rH\u0016J\u0010\u0010\u0016\u001A\u00020\u00012\u0006\u0010\u0011\u001A\u00020\rH\u0016J\u0016\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0011\u001A\u00020\rH\u0016J\b\u0010\u001A\u001A\u00020\u0003H\u0016J\u0013\u0010\u001B\u001A\u00020\u00152\b\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0096\u0002J\b\u0010\u001E\u001A\u00020\rH\u0016J\b\u0010\u001F\u001A\u00020 H\u0002R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000F¨\u0006!"}, d2 = {"Lkotlinx/serialization/internal/PrimitiveSerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "kind", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/PrimitiveKind;)V", "getSerialName", "()Ljava/lang/String;", "getKind", "()Lkotlinx/serialization/descriptors/PrimitiveKind;", "elementsCount", "", "getElementsCount", "()I", "getElementName", "index", "getElementIndex", "name", "isElementOptional", "", "getElementDescriptor", "getElementAnnotations", "", "", "toString", "equals", "other", "", "hashCode", "error", "", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class PrimitiveSerialDescriptor implements SerialDescriptor {
    @NotNull
    private final PrimitiveKind kind;
    @NotNull
    private final String serialName;

    public PrimitiveSerialDescriptor(@NotNull String s, @NotNull PrimitiveKind primitiveKind0) {
        q.g(s, "serialName");
        q.g(primitiveKind0, "kind");
        super();
        this.serialName = s;
        this.kind = primitiveKind0;
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof PrimitiveSerialDescriptor ? q.b(this.getSerialName(), ((PrimitiveSerialDescriptor)object0).getSerialName()) && q.b(this.getKind(), ((PrimitiveSerialDescriptor)object0).getKind()) : false;
    }

    private final Void error() {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public List getAnnotations() {
        return DefaultImpls.getAnnotations(this);
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public List getElementAnnotations(int v) {
        this.error();
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public SerialDescriptor getElementDescriptor(int v) {
        this.error();
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementIndex(@NotNull String s) {
        q.g(s, "name");
        this.error();
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public String getElementName(int v) {
        this.error();
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementsCount() {
        return 0;
    }

    @NotNull
    public PrimitiveKind getKind() {
        return this.kind;
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind getKind() {
        return this.getKind();
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public String getSerialName() {
        return this.serialName;
    }

    @Override
    public int hashCode() {
        return this.getKind().hashCode() * 0x1F + this.getSerialName().hashCode();
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isElementOptional(int v) {
        this.error();
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return false;
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isNullable() {
        return false;
    }

    @Override
    @NotNull
    public String toString() {
        return "PrimitiveDescriptor(" + this.getSerialName() + ')';
    }
}

