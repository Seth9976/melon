package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.ElementMarker;
import org.jetbrains.annotations.NotNull;
import we.n;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\u0007\u001A\u00020\u0006H\u0000¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u0011\u001A\u00020\u0006H\u0000¢\u0006\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0013\u001A\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\b8\u0000@BX\u0080\u000E¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2 = {"Lkotlinx/serialization/json/internal/JsonElementMarker;", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "index", "", "readIfAbsent", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "Lie/H;", "mark$kotlinx_serialization_json", "(I)V", "mark", "nextUnmarkedIndex$kotlinx_serialization_json", "()I", "nextUnmarkedIndex", "Lkotlinx/serialization/internal/ElementMarker;", "origin", "Lkotlinx/serialization/internal/ElementMarker;", "value", "isUnmarkedNull", "Z", "isUnmarkedNull$kotlinx_serialization_json", "()Z", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class JsonElementMarker {
    private boolean isUnmarkedNull;
    @NotNull
    private final ElementMarker origin;

    public JsonElementMarker(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
        super();
        this.origin = new ElementMarker(serialDescriptor0, new n() {
            {
                super(2, 0, JsonElementMarker.class, object0, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z");
            }

            public final Boolean invoke(SerialDescriptor serialDescriptor0, int v) {
                q.g(serialDescriptor0, "p0");
                return Boolean.valueOf(((JsonElementMarker)this.receiver).readIfAbsent(serialDescriptor0, v));
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((SerialDescriptor)object0), ((Number)object1).intValue());
            }
        });
    }

    public final boolean isUnmarkedNull$kotlinx_serialization_json() {
        return this.isUnmarkedNull;
    }

    public final void mark$kotlinx_serialization_json(int v) {
        this.origin.mark(v);
    }

    public final int nextUnmarkedIndex$kotlinx_serialization_json() {
        return this.origin.nextUnmarkedIndex();
    }

    private final boolean readIfAbsent(SerialDescriptor serialDescriptor0, int v) {
        boolean z = !serialDescriptor0.isElementOptional(v) && serialDescriptor0.getElementDescriptor(v).isNullable();
        this.isUnmarkedNull = z;
        return z;
    }
}

