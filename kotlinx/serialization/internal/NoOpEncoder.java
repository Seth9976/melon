package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\u000B\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000E\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\rH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0011\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001A\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0019H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ\u0017\u0010\u001D\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u001CH\u0016¢\u0006\u0004\b\u001D\u0010\u001EJ\u0017\u0010 \u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u001FH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u001F\u0010(\u001A\u00020\u00062\u0006\u0010&\u001A\u00020%2\u0006\u0010\'\u001A\u00020\u0013H\u0016¢\u0006\u0004\b(\u0010)R\u001A\u0010+\u001A\u00020*8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b+\u0010,\u001A\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lkotlinx/serialization/internal/NoOpEncoder;", "Lkotlinx/serialization/encoding/AbstractEncoder;", "<init>", "()V", "", "value", "Lie/H;", "encodeValue", "(Ljava/lang/Object;)V", "encodeNull", "", "encodeBoolean", "(Z)V", "", "encodeByte", "(B)V", "", "encodeShort", "(S)V", "", "encodeInt", "(I)V", "", "encodeLong", "(J)V", "", "encodeFloat", "(F)V", "", "encodeDouble", "(D)V", "", "encodeChar", "(C)V", "", "encodeString", "(Ljava/lang/String;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "enumDescriptor", "index", "encodeEnum", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)V", "Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class NoOpEncoder extends AbstractEncoder {
    @NotNull
    public static final NoOpEncoder INSTANCE;
    @NotNull
    private static final SerializersModule serializersModule;

    static {
        NoOpEncoder.INSTANCE = new NoOpEncoder();
        NoOpEncoder.serializersModule = SerializersModuleBuildersKt.EmptySerializersModule();
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeBoolean(boolean z) {
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeByte(byte b) {
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeChar(char c) {
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeDouble(double f) {
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeEnum(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "enumDescriptor");
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeFloat(float f) {
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeInt(int v) {
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeLong(long v) {
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeNull() {
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeShort(short v) {
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeString(@NotNull String s) {
        q.g(s, "value");
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeValue(@NotNull Object object0) {
        q.g(object0, "value");
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    @NotNull
    public SerializersModule getSerializersModule() {
        return NoOpEncoder.serializersModule;
    }
}

