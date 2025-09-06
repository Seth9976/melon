package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001B\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\u0010\u0004\u001A\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000B\u001A\u00020\fH\u0016J\u0013\u0010\r\u001A\u00020\t2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0096\u0002R\u0014\u0010\b\u001A\u00020\tX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\n¨\u0006\u0010"}, d2 = {"Lkotlinx/serialization/internal/InlineClassDescriptor;", "Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;", "name", "", "generatedSerializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/internal/GeneratedSerializer;)V", "isInline", "", "()Z", "hashCode", "", "equals", "other", "", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class InlineClassDescriptor extends PluginGeneratedSerialDescriptor {
    private final boolean isInline;

    public InlineClassDescriptor(@NotNull String s, @NotNull GeneratedSerializer generatedSerializer0) {
        q.g(s, "name");
        q.g(generatedSerializer0, "generatedSerializer");
        super(s, generatedSerializer0, 1);
        this.isInline = true;
    }

    @Override  // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof InlineClassDescriptor)) {
            return false;
        }
        if(!q.b(this.getSerialName(), ((SerialDescriptor)object0).getSerialName())) {
            return false;
        }
        if(!((InlineClassDescriptor)object0).isInline() || !Arrays.equals(this.getTypeParameterDescriptors$kotlinx_serialization_core(), ((InlineClassDescriptor)object0).getTypeParameterDescriptors$kotlinx_serialization_core()) || this.getElementsCount() != ((SerialDescriptor)object0).getElementsCount()) {
            return false;
        }
        int v = this.getElementsCount();
        for(int v1 = 0; v1 < v; ++v1) {
            if(!q.b(this.getElementDescriptor(v1).getSerialName(), ((SerialDescriptor)object0).getElementDescriptor(v1).getSerialName())) {
                return false;
            }
            if(!q.b(this.getElementDescriptor(v1).getKind(), ((SerialDescriptor)object0).getElementDescriptor(v1).getKind())) {
                return false;
            }
        }
        return true;
    }

    @Override  // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public int hashCode() {
        return super.hashCode() * 0x1F;
    }

    @Override  // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public boolean isInline() {
        return this.isInline;
    }
}

