package kotlinx.serialization.json.internal;

import ie.A;
import ie.E;
import ie.u;
import ie.x;
import java.util.Set;
import je.n;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonElementKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\"\u0014\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0003\u001A\u00020\u0004*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0005\"\u0018\u0010\u0006\u001A\u00020\u0004*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0005¨\u0006\u0007"}, d2 = {"unsignedNumberDescriptors", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "isUnsignedNumber", "", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Z", "isUnquotedLiteral", "kotlinx-serialization-json"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class StreamingJsonEncoderKt {
    @NotNull
    private static final Set unsignedNumberDescriptors;

    static {
        StreamingJsonEncoderKt.unsignedNumberDescriptors = n.A0(new SerialDescriptor[]{BuiltinSerializersKt.serializer(x.b).getDescriptor(), BuiltinSerializersKt.serializer(A.b).getDescriptor(), BuiltinSerializersKt.serializer(u.b).getDescriptor(), BuiltinSerializersKt.serializer(E.b).getDescriptor()});
    }

    public static final boolean isUnquotedLiteral(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "<this>");
        return serialDescriptor0.isInline() && serialDescriptor0.equals(JsonElementKt.getJsonUnquotedLiteralDescriptor());
    }

    public static final boolean isUnsignedNumber(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "<this>");
        return serialDescriptor0.isInline() && StreamingJsonEncoderKt.unsignedNumberDescriptors.contains(serialDescriptor0);
    }
}

