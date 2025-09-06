package kotlinx.serialization.internal;

import i.n.i.b.a.s.e.M3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.descriptors.SerialDescriptor.DefaultImpls;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind.OBJECT;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001B\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001A\u00020\t2\u0006\u0010\u0011\u001A\u00020\rH\u0016J\u0010\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\tH\u0016J\u0010\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0011\u001A\u00020\rH\u0016J\u0010\u0010\u0016\u001A\u00020\u00012\u0006\u0010\u0011\u001A\u00020\rH\u0016J\u0016\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0011\u001A\u00020\rH\u0016J\b\u0010\u001A\u001A\u00020\tH\u0016J\u0013\u0010\u001B\u001A\u00020\u00152\b\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0096\u0002J\b\u0010\u001E\u001A\u00020\rH\u0016J\b\u0010\u001F\u001A\u00020 H\u0002R\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\tX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000F¨\u0006!"}, d2 = {"Lkotlinx/serialization/internal/NothingSerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "<init>", "()V", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "serialName", "", "getSerialName", "()Ljava/lang/String;", "elementsCount", "", "getElementsCount", "()I", "getElementName", "index", "getElementIndex", "name", "isElementOptional", "", "getElementDescriptor", "getElementAnnotations", "", "", "toString", "equals", "other", "", "hashCode", "error", "", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class NothingSerialDescriptor implements SerialDescriptor {
    @NotNull
    public static final NothingSerialDescriptor INSTANCE;
    @NotNull
    private static final SerialKind kind;
    @NotNull
    private static final String serialName;

    static {
        NothingSerialDescriptor.INSTANCE = new NothingSerialDescriptor();
        NothingSerialDescriptor.kind = OBJECT.INSTANCE;
        NothingSerialDescriptor.serialName = "kotlin.Nothing";
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0;
    }

    private final Void error() {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
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

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public SerialKind getKind() {
        return NothingSerialDescriptor.kind;
    }

    // 去混淆评级： 低(20)
    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public String getSerialName() [...] // 潜在的解密器

    // 去混淆评级： 低(30)
    @Override
    public int hashCode() {
        return this.getKind().hashCode() * 0x1F - 0x6C61E840;
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
        return "NothingSerialDescriptor";
    }
}

