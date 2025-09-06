package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001B\b\'\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016\u00A2\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u000E\u0010\nJ\u000F\u0010\u0010\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0013\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0016\u001A\u00020\u0015H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0019\u001A\u00020\u0018H\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u000F\u0010\u001C\u001A\u00020\u001BH\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u000F\u0010\u001F\u001A\u00020\u001EH\u0016\u00A2\u0006\u0004\b\u001F\u0010 J\u000F\u0010\"\u001A\u00020!H\u0016\u00A2\u0006\u0004\b\"\u0010#J\u000F\u0010%\u001A\u00020$H\u0016\u00A2\u0006\u0004\b%\u0010&J\u0017\u0010)\u001A\u00020\u00152\u0006\u0010(\u001A\u00020\'H\u0016\u00A2\u0006\u0004\b)\u0010*J\u0017\u0010,\u001A\u00020\u00012\u0006\u0010+\u001A\u00020\'H\u0016\u00A2\u0006\u0004\b,\u0010-J5\u00102\u001A\u00028\u0000\"\n\b\u0000\u0010.*\u0004\u0018\u00010\u00052\f\u00100\u001A\b\u0012\u0004\u0012\u00028\u00000/2\n\b\u0002\u00101\u001A\u0004\u0018\u00018\u0000H\u0016\u00A2\u0006\u0004\b2\u00103J\u0017\u00104\u001A\u00020\u00022\u0006\u0010+\u001A\u00020\'H\u0016\u00A2\u0006\u0004\b4\u00105J\u0017\u00107\u001A\u0002062\u0006\u0010+\u001A\u00020\'H\u0016\u00A2\u0006\u0004\b7\u00108J\u001D\u0010:\u001A\u00020\b2\u0006\u0010+\u001A\u00020\'2\u0006\u00109\u001A\u00020\u0015\u00A2\u0006\u0004\b:\u0010;J\u001D\u0010<\u001A\u00020\u000F2\u0006\u0010+\u001A\u00020\'2\u0006\u00109\u001A\u00020\u0015\u00A2\u0006\u0004\b<\u0010=J\u001D\u0010>\u001A\u00020\u00122\u0006\u0010+\u001A\u00020\'2\u0006\u00109\u001A\u00020\u0015\u00A2\u0006\u0004\b>\u0010?J\u001D\u0010@\u001A\u00020\u00152\u0006\u0010+\u001A\u00020\'2\u0006\u00109\u001A\u00020\u0015\u00A2\u0006\u0004\b@\u0010AJ\u001D\u0010B\u001A\u00020\u00182\u0006\u0010+\u001A\u00020\'2\u0006\u00109\u001A\u00020\u0015\u00A2\u0006\u0004\bB\u0010CJ\u001D\u0010D\u001A\u00020\u001B2\u0006\u0010+\u001A\u00020\'2\u0006\u00109\u001A\u00020\u0015\u00A2\u0006\u0004\bD\u0010EJ\u001D\u0010F\u001A\u00020\u001E2\u0006\u0010+\u001A\u00020\'2\u0006\u00109\u001A\u00020\u0015\u00A2\u0006\u0004\bF\u0010GJ\u001D\u0010H\u001A\u00020!2\u0006\u0010+\u001A\u00020\'2\u0006\u00109\u001A\u00020\u0015\u00A2\u0006\u0004\bH\u0010IJ\u001D\u0010J\u001A\u00020$2\u0006\u0010+\u001A\u00020\'2\u0006\u00109\u001A\u00020\u0015\u00A2\u0006\u0004\bJ\u0010KJ\u001F\u0010L\u001A\u00020\u00012\u0006\u0010+\u001A\u00020\'2\u0006\u00109\u001A\u00020\u0015H\u0016\u00A2\u0006\u0004\bL\u0010MJ=\u0010N\u001A\u00028\u0000\"\u0004\b\u0000\u0010.2\u0006\u0010+\u001A\u00020\'2\u0006\u00109\u001A\u00020\u00152\f\u00100\u001A\b\u0012\u0004\u0012\u00028\u00000/2\b\u00101\u001A\u0004\u0018\u00018\u0000H\u0016\u00A2\u0006\u0004\bN\u0010OJC\u0010P\u001A\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010.*\u00020\u00052\u0006\u0010+\u001A\u00020\'2\u0006\u00109\u001A\u00020\u00152\u000E\u00100\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000/2\b\u00101\u001A\u0004\u0018\u00018\u0000\u00A2\u0006\u0004\bP\u0010O\u00A8\u0006Q"}, d2 = {"Lkotlinx/serialization/encoding/AbstractDecoder;", "Lkotlinx/serialization/encoding/Decoder;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "<init>", "()V", "", "decodeValue", "()Ljava/lang/Object;", "", "decodeNotNullMark", "()Z", "", "decodeNull", "()Ljava/lang/Void;", "decodeBoolean", "", "decodeByte", "()B", "", "decodeShort", "()S", "", "decodeInt", "()I", "", "decodeLong", "()J", "", "decodeFloat", "()F", "", "decodeDouble", "()D", "", "decodeChar", "()C", "", "decodeString", "()Ljava/lang/String;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "enumDescriptor", "decodeEnum", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "descriptor", "decodeInline", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", "T", "Lkotlinx/serialization/DeserializationStrategy;", "deserializer", "previousValue", "decodeSerializableValue", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "beginStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeDecoder;", "Lie/H;", "endStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "index", "decodeBooleanElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "decodeByteElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)B", "decodeShortElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)S", "decodeIntElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)I", "decodeLongElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)J", "decodeFloatElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)F", "decodeDoubleElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)D", "decodeCharElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)C", "decodeStringElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/String;", "decodeInlineElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Lkotlinx/serialization/encoding/Decoder;", "decodeSerializableElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeNullableSerializableElement", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public abstract class AbstractDecoder implements CompositeDecoder, Decoder {
    @Override  // kotlinx.serialization.encoding.Decoder
    @NotNull
    public CompositeDecoder beginStructure(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
        return this;
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    public boolean decodeBoolean() {
        Object object0 = this.decodeValue();
        q.e(object0, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean)object0).booleanValue();
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public final boolean decodeBooleanElement(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return this.decodeBoolean();
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    public abstract byte decodeByte();

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public final byte decodeByteElement(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return this.decodeByte();
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    public char decodeChar() {
        Object object0 = this.decodeValue();
        q.e(object0, "null cannot be cast to non-null type kotlin.Char");
        return ((Character)object0).charValue();
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public final char decodeCharElement(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return this.decodeChar();
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public int decodeCollectionSize(@NotNull SerialDescriptor serialDescriptor0) {
        return DefaultImpls.decodeCollectionSize(this, serialDescriptor0);
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    public double decodeDouble() {
        Object object0 = this.decodeValue();
        q.e(object0, "null cannot be cast to non-null type kotlin.Double");
        return (double)(((Double)object0));
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public final double decodeDoubleElement(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return this.decodeDouble();
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    public int decodeEnum(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "enumDescriptor");
        Object object0 = this.decodeValue();
        q.e(object0, "null cannot be cast to non-null type kotlin.Int");
        return (int)(((Integer)object0));
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    public float decodeFloat() {
        Object object0 = this.decodeValue();
        q.e(object0, "null cannot be cast to non-null type kotlin.Float");
        return (float)(((Float)object0));
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public final float decodeFloatElement(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return this.decodeFloat();
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    @NotNull
    public Decoder decodeInline(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
        return this;
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    @NotNull
    public Decoder decodeInlineElement(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return this.decodeInline(serialDescriptor0.getElementDescriptor(v));
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    public abstract int decodeInt();

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public final int decodeIntElement(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return this.decodeInt();
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    public abstract long decodeLong();

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public final long decodeLongElement(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return this.decodeLong();
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    public boolean decodeNotNullMark() {
        return true;
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    @Nullable
    public Void decodeNull() {
        return null;
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    @Nullable
    public final Object decodeNullableSerializableElement(@NotNull SerialDescriptor serialDescriptor0, int v, @NotNull DeserializationStrategy deserializationStrategy0, @Nullable Object object0) {
        q.g(serialDescriptor0, "descriptor");
        q.g(deserializationStrategy0, "deserializer");
        return !deserializationStrategy0.getDescriptor().isNullable() && !this.decodeNotNullMark() ? this.decodeNull() : this.decodeSerializableValue(deserializationStrategy0, object0);
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public boolean decodeSequentially() {
        return false;
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public Object decodeSerializableElement(@NotNull SerialDescriptor serialDescriptor0, int v, @NotNull DeserializationStrategy deserializationStrategy0, @Nullable Object object0) {
        q.g(serialDescriptor0, "descriptor");
        q.g(deserializationStrategy0, "deserializer");
        return this.decodeSerializableValue(deserializationStrategy0, object0);
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    public Object decodeSerializableValue(@NotNull DeserializationStrategy deserializationStrategy0) {
        return kotlinx.serialization.encoding.Decoder.DefaultImpls.decodeSerializableValue(this, deserializationStrategy0);
    }

    public Object decodeSerializableValue(@NotNull DeserializationStrategy deserializationStrategy0, @Nullable Object object0) {
        q.g(deserializationStrategy0, "deserializer");
        return this.decodeSerializableValue(deserializationStrategy0);
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    public abstract short decodeShort();

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public final short decodeShortElement(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return this.decodeShort();
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    @NotNull
    public String decodeString() {
        Object object0 = this.decodeValue();
        q.e(object0, "null cannot be cast to non-null type kotlin.String");
        return (String)object0;
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    @NotNull
    public final String decodeStringElement(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return this.decodeString();
    }

    @NotNull
    public Object decodeValue() {
        Class class0 = this.getClass();
        throw new SerializationException(I.a.b(class0) + " can\'t retrieve untyped values");
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public void endStructure(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
    }
}

