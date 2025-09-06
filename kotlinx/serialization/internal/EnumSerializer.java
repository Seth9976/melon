package kotlinx.serialization.internal;

import Zc.N;
import d3.g;
import ie.j;
import java.util.Arrays;
import je.n;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u0000*\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001D\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tB\'\b\u0010\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\b\u0010\fJ\u0017\u0010\r\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00028\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001A\u00028\u00002\u0006\u0010\u0016\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000F\u0010\u0019\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u001AR\u001A\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001BR\u0018\u0010\u001C\u001A\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001C\u0010\u001DR\u001B\u0010\u000B\u001A\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001E\u0010\u001F\u001A\u0004\b \u0010!¨\u0006\""}, d2 = {"Lkotlinx/serialization/internal/EnumSerializer;", "", "T", "Lkotlinx/serialization/KSerializer;", "", "serialName", "", "values", "<init>", "(Ljava/lang/String;[Ljava/lang/Enum;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "(Ljava/lang/String;[Ljava/lang/Enum;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "createUnmarkedDescriptor", "(Ljava/lang/String;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Enum;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Enum;", "toString", "()Ljava/lang/String;", "[Ljava/lang/Enum;", "overriddenDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lie/j;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class EnumSerializer implements KSerializer {
    @NotNull
    private final j descriptor$delegate;
    @Nullable
    private SerialDescriptor overriddenDescriptor;
    @NotNull
    private final Enum[] values;

    public EnumSerializer(@NotNull String s, @NotNull Enum[] arr_enum) {
        q.g(s, "serialName");
        q.g(arr_enum, "values");
        super();
        this.values = arr_enum;
        this.descriptor$delegate = g.Q(new N(26, this, s));
    }

    public EnumSerializer(@NotNull String s, @NotNull Enum[] arr_enum, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(s, "serialName");
        q.g(arr_enum, "values");
        q.g(serialDescriptor0, "descriptor");
        this(s, arr_enum);
        this.overriddenDescriptor = serialDescriptor0;
    }

    public static SerialDescriptor a(EnumSerializer enumSerializer0, String s) {
        return EnumSerializer.descriptor_delegate$lambda$0(enumSerializer0, s);
    }

    private final SerialDescriptor createUnmarkedDescriptor(String s) {
        SerialDescriptor serialDescriptor0 = new EnumDescriptor(s, this.values.length);
        Enum[] arr_enum = this.values;
        for(int v = 0; v < arr_enum.length; ++v) {
            PluginGeneratedSerialDescriptor.addElement$default(((PluginGeneratedSerialDescriptor)serialDescriptor0), arr_enum[v].name(), false, 2, null);
        }
        return serialDescriptor0;
    }

    private static final SerialDescriptor descriptor_delegate$lambda$0(EnumSerializer enumSerializer0, String s) {
        return enumSerializer0.overriddenDescriptor == null ? enumSerializer0.createUnmarkedDescriptor(s) : enumSerializer0.overriddenDescriptor;
    }

    @NotNull
    public Enum deserialize(@NotNull Decoder decoder0) {
        q.g(decoder0, "decoder");
        int v = decoder0.decodeEnum(this.getDescriptor());
        if(v >= 0) {
            Enum[] arr_enum = this.values;
            if(v < arr_enum.length) {
                return arr_enum[v];
            }
        }
        throw new SerializationException(v + " is not among valid " + this.getDescriptor().getSerialName() + " enum values, values size is " + this.values.length);
    }

    @Override  // kotlinx.serialization.DeserializationStrategy
    public Object deserialize(Decoder decoder0) {
        return this.deserialize(decoder0);
    }

    @Override  // kotlinx.serialization.KSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor)this.descriptor$delegate.getValue();
    }

    public void serialize(@NotNull Encoder encoder0, @NotNull Enum enum0) {
        q.g(encoder0, "encoder");
        q.g(enum0, "value");
        int v = n.o0(this.values, enum0);
        if(v != -1) {
            encoder0.encodeEnum(this.getDescriptor(), v);
            return;
        }
        String s = Arrays.toString(this.values);
        q.f(s, "toString(...)");
        throw new SerializationException(enum0 + " is not a valid enum " + this.getDescriptor().getSerialName() + ", must be one of " + s);
    }

    @Override  // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder0, Object object0) {
        this.serialize(encoder0, ((Enum)object0));
    }

    @Override
    @NotNull
    public String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + this.getDescriptor().getSerialName() + '>';
    }
}

