package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.NoOpEncoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u001C\n\u0002\u0018\u0002\n\u0002\b\u0005\b\'\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0013\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0004J\u0017\u0010\u0016\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u0018H\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0017\u0010\u001C\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u001BH\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0017\u0010\u001E\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0017\u0010!\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020 H\u0016\u00A2\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020#H\u0016\u00A2\u0006\u0004\b$\u0010%J\u0017\u0010\'\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020&H\u0016\u00A2\u0006\u0004\b\'\u0010(J\u0017\u0010*\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020)H\u0016\u00A2\u0006\u0004\b*\u0010+J\u0017\u0010-\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020,H\u0016\u00A2\u0006\u0004\b-\u0010.J\u001F\u00100\u001A\u00020\t2\u0006\u0010/\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b0\u00101J\u0017\u00102\u001A\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b2\u00103J%\u00104\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\u000E\u00A2\u0006\u0004\b4\u00105J%\u00106\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\u0018\u00A2\u0006\u0004\b6\u00107J%\u00108\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\u001B\u00A2\u0006\u0004\b8\u00109J%\u0010:\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\f\u00A2\u0006\u0004\b:\u0010;J%\u0010<\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020 \u00A2\u0006\u0004\b<\u0010=J%\u0010>\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020#\u00A2\u0006\u0004\b>\u0010?J%\u0010@\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020&\u00A2\u0006\u0004\b@\u0010AJ%\u0010B\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020)\u00A2\u0006\u0004\bB\u0010CJ%\u0010D\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020,\u00A2\u0006\u0004\bD\u0010EJ\u001D\u0010F\u001A\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\f\u00A2\u0006\u0004\bF\u0010GJA\u0010K\u001A\u00020\t\"\n\b\u0000\u0010H*\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\f2\f\u0010J\u001A\b\u0012\u0004\u0012\u00028\u00000I2\u0006\u0010\u0012\u001A\u00028\u0000H\u0016\u00A2\u0006\u0004\bK\u0010LJA\u0010M\u001A\u00020\t\"\b\b\u0000\u0010H*\u00020\u00112\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\f2\f\u0010J\u001A\b\u0012\u0004\u0012\u00028\u00000I2\b\u0010\u0012\u001A\u0004\u0018\u00018\u0000H\u0016\u00A2\u0006\u0004\bM\u0010L\u00A8\u0006N"}, d2 = {"Lkotlinx/serialization/encoding/AbstractEncoder;", "Lkotlinx/serialization/encoding/Encoder;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "<init>", "()V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "beginStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeEncoder;", "Lie/H;", "endStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "index", "", "encodeElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "", "value", "encodeValue", "(Ljava/lang/Object;)V", "encodeNull", "encodeBoolean", "(Z)V", "", "encodeByte", "(B)V", "", "encodeShort", "(S)V", "encodeInt", "(I)V", "", "encodeLong", "(J)V", "", "encodeFloat", "(F)V", "", "encodeDouble", "(D)V", "", "encodeChar", "(C)V", "", "encodeString", "(Ljava/lang/String;)V", "enumDescriptor", "encodeEnum", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)V", "encodeInline", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Encoder;", "encodeBooleanElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IZ)V", "encodeByteElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IB)V", "encodeShortElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IS)V", "encodeIntElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;II)V", "encodeLongElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IJ)V", "encodeFloatElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IF)V", "encodeDoubleElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ID)V", "encodeCharElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IC)V", "encodeStringElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILjava/lang/String;)V", "encodeInlineElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Lkotlinx/serialization/encoding/Encoder;", "T", "Lkotlinx/serialization/SerializationStrategy;", "serializer", "encodeSerializableElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeNullableSerializableElement", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public abstract class AbstractEncoder implements CompositeEncoder, Encoder {
    @Override  // kotlinx.serialization.encoding.Encoder
    @NotNull
    public CompositeEncoder beginCollection(@NotNull SerialDescriptor serialDescriptor0, int v) {
        return DefaultImpls.beginCollection(this, serialDescriptor0, v);
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    @NotNull
    public CompositeEncoder beginStructure(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
        return this;
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    public void encodeBoolean(boolean z) {
        this.encodeValue(Boolean.valueOf(z));
    }

    @Override  // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeBooleanElement(@NotNull SerialDescriptor serialDescriptor0, int v, boolean z) {
        q.g(serialDescriptor0, "descriptor");
        if(this.encodeElement(serialDescriptor0, v)) {
            this.encodeBoolean(z);
        }
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    public void encodeByte(byte b) {
        this.encodeValue(b);
    }

    @Override  // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeByteElement(@NotNull SerialDescriptor serialDescriptor0, int v, byte b) {
        q.g(serialDescriptor0, "descriptor");
        if(this.encodeElement(serialDescriptor0, v)) {
            this.encodeByte(b);
        }
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    public void encodeChar(char c) {
        this.encodeValue(Character.valueOf(c));
    }

    @Override  // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeCharElement(@NotNull SerialDescriptor serialDescriptor0, int v, char c) {
        q.g(serialDescriptor0, "descriptor");
        if(this.encodeElement(serialDescriptor0, v)) {
            this.encodeChar(c);
        }
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    public void encodeDouble(double f) {
        this.encodeValue(f);
    }

    @Override  // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeDoubleElement(@NotNull SerialDescriptor serialDescriptor0, int v, double f) {
        q.g(serialDescriptor0, "descriptor");
        if(this.encodeElement(serialDescriptor0, v)) {
            this.encodeDouble(f);
        }
    }

    public boolean encodeElement(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return true;
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    public void encodeEnum(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "enumDescriptor");
        this.encodeValue(v);
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    public void encodeFloat(float f) {
        this.encodeValue(f);
    }

    @Override  // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeFloatElement(@NotNull SerialDescriptor serialDescriptor0, int v, float f) {
        q.g(serialDescriptor0, "descriptor");
        if(this.encodeElement(serialDescriptor0, v)) {
            this.encodeFloat(f);
        }
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    @NotNull
    public Encoder encodeInline(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
        return this;
    }

    @Override  // kotlinx.serialization.encoding.CompositeEncoder
    @NotNull
    public final Encoder encodeInlineElement(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return this.encodeElement(serialDescriptor0, v) ? this.encodeInline(serialDescriptor0.getElementDescriptor(v)) : NoOpEncoder.INSTANCE;
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    public void encodeInt(int v) {
        this.encodeValue(v);
    }

    @Override  // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeIntElement(@NotNull SerialDescriptor serialDescriptor0, int v, int v1) {
        q.g(serialDescriptor0, "descriptor");
        if(this.encodeElement(serialDescriptor0, v)) {
            this.encodeInt(v1);
        }
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    public void encodeLong(long v) {
        this.encodeValue(v);
    }

    @Override  // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeLongElement(@NotNull SerialDescriptor serialDescriptor0, int v, long v1) {
        q.g(serialDescriptor0, "descriptor");
        if(this.encodeElement(serialDescriptor0, v)) {
            this.encodeLong(v1);
        }
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    public void encodeNotNullMark() {
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    public void encodeNull() {
        throw new SerializationException("\'null\' is not supported by default");
    }

    @Override  // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeNullableSerializableElement(@NotNull SerialDescriptor serialDescriptor0, int v, @NotNull SerializationStrategy serializationStrategy0, @Nullable Object object0) {
        q.g(serialDescriptor0, "descriptor");
        q.g(serializationStrategy0, "serializer");
        if(this.encodeElement(serialDescriptor0, v)) {
            this.encodeNullableSerializableValue(serializationStrategy0, object0);
        }
    }

    public void encodeNullableSerializableValue(@NotNull SerializationStrategy serializationStrategy0, @Nullable Object object0) {
        DefaultImpls.encodeNullableSerializableValue(this, serializationStrategy0, object0);
    }

    @Override  // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeSerializableElement(@NotNull SerialDescriptor serialDescriptor0, int v, @NotNull SerializationStrategy serializationStrategy0, Object object0) {
        q.g(serialDescriptor0, "descriptor");
        q.g(serializationStrategy0, "serializer");
        if(this.encodeElement(serialDescriptor0, v)) {
            this.encodeSerializableValue(serializationStrategy0, object0);
        }
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    public void encodeSerializableValue(@NotNull SerializationStrategy serializationStrategy0, Object object0) {
        DefaultImpls.encodeSerializableValue(this, serializationStrategy0, object0);
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    public void encodeShort(short v) {
        this.encodeValue(v);
    }

    @Override  // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeShortElement(@NotNull SerialDescriptor serialDescriptor0, int v, short v1) {
        q.g(serialDescriptor0, "descriptor");
        if(this.encodeElement(serialDescriptor0, v)) {
            this.encodeShort(v1);
        }
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    public void encodeString(@NotNull String s) {
        q.g(s, "value");
        this.encodeValue(s);
    }

    @Override  // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeStringElement(@NotNull SerialDescriptor serialDescriptor0, int v, @NotNull String s) {
        q.g(serialDescriptor0, "descriptor");
        q.g(s, "value");
        if(this.encodeElement(serialDescriptor0, v)) {
            this.encodeString(s);
        }
    }

    public void encodeValue(@NotNull Object object0) {
        q.g(object0, "value");
        Class class0 = object0.getClass();
        Class class1 = this.getClass();
        throw new SerializationException("Non-serializable " + I.a.b(class0) + " is not supported by " + I.a.b(class1) + " encoder");
    }

    @Override  // kotlinx.serialization.encoding.CompositeEncoder
    public void endStructure(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
    }

    @Override  // kotlinx.serialization.encoding.CompositeEncoder
    public boolean shouldEncodeElementDefault(@NotNull SerialDescriptor serialDescriptor0, int v) {
        return kotlinx.serialization.encoding.CompositeEncoder.DefaultImpls.shouldEncodeElementDefault(this, serialDescriptor0, v);
    }
}

