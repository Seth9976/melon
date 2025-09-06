package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001A\u00020\u0002*\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0004J\u0010\u0010\t\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\u0002H\u0004J\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\f\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0014J\u0018\u0010\r\u001A\u00020\u00022\u0006\u0010\u000E\u001A\u00020\u00022\u0006\u0010\u000F\u001A\u00020\u0002H\u0014J\b\u0010\u0010\u001A\u00020\u0002H\u0004¨\u0006\u0011"}, d2 = {"Lkotlinx/serialization/internal/NamedValueDecoder;", "Lkotlinx/serialization/internal/TaggedDecoder;", "", "<init>", "()V", "getTag", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "index", "", "nested", "nestedName", "elementName", "descriptor", "composeName", "parentName", "childName", "renderTagStack", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public abstract class NamedValueDecoder extends TaggedDecoder {
    @NotNull
    public abstract String composeName(@NotNull String arg1, @NotNull String arg2);

    @NotNull
    public String elementName(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return serialDescriptor0.getElementName(v);
    }

    @Override  // kotlinx.serialization.internal.TaggedDecoder
    public Object getTag(SerialDescriptor serialDescriptor0, int v) {
        return this.getTag(serialDescriptor0, v);
    }

    @NotNull
    public final String getTag(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "<this>");
        return this.nested(this.elementName(serialDescriptor0, v));
    }

    @NotNull
    public final String nested(@NotNull String s) {
        q.g(s, "nestedName");
        String s1 = (String)this.getCurrentTagOrNull();
        if(s1 == null) {
            s1 = "";
        }
        return this.composeName(s1, s);
    }

    // 去混淆评级： 低(20)
    @NotNull
    public final String renderTagStack() [...] // 潜在的解密器
}

