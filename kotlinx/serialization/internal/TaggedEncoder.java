package kotlinx.serialization.internal;

import e.k;
import java.util.ArrayList;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder.DefaultImpls;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\'\u0018\u0000*\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00012\u00020\u00032\u00020\u0004B\u0007\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u001B\u0010\n\u001A\u00028\u0000*\u00020\u00072\u0006\u0010\t\u001A\u00020\bH$\u00A2\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00028\u00002\u0006\u0010\r\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0012\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00028\u00002\u0006\u0010\r\u001A\u00020\u0011H\u0014\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u001F\u0010\u0015\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00028\u00002\u0006\u0010\r\u001A\u00020\u0014H\u0014\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u001F\u0010\u0018\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00028\u00002\u0006\u0010\r\u001A\u00020\u0017H\u0014\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u001F\u0010\u001B\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00028\u00002\u0006\u0010\r\u001A\u00020\u001AH\u0014\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u001F\u0010\u001E\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00028\u00002\u0006\u0010\r\u001A\u00020\u001DH\u0014\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u001F\u0010!\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00028\u00002\u0006\u0010\r\u001A\u00020 H\u0014\u00A2\u0006\u0004\b!\u0010\"J\u001F\u0010$\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00028\u00002\u0006\u0010\r\u001A\u00020#H\u0014\u00A2\u0006\u0004\b$\u0010%J\u001F\u0010\'\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00028\u00002\u0006\u0010\r\u001A\u00020&H\u0014\u00A2\u0006\u0004\b\'\u0010(J\'\u0010+\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00028\u00002\u0006\u0010)\u001A\u00020\u00072\u0006\u0010*\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b+\u0010,J\u001F\u0010.\u001A\u00020\u00032\u0006\u0010\f\u001A\u00028\u00002\u0006\u0010-\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b.\u0010/J\u0017\u00101\u001A\u00020\u00032\u0006\u00100\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b1\u00102J\u0015\u00103\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020 \u00A2\u0006\u0004\b3\u00104J\u0015\u00105\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\u0011\u00A2\u0006\u0004\b5\u00106J\u0015\u00107\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\u0014\u00A2\u0006\u0004\b7\u00108J\u0015\u00109\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\b\u00A2\u0006\u0004\b9\u0010:J\u0015\u0010;\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\u0017\u00A2\u0006\u0004\b;\u0010<J\u0015\u0010=\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\u001A\u00A2\u0006\u0004\b=\u0010>J\u0015\u0010?\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\u001D\u00A2\u0006\u0004\b?\u0010@J\u0015\u0010A\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020#\u00A2\u0006\u0004\bA\u0010BJ\u0015\u0010C\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020&\u00A2\u0006\u0004\bC\u0010DJ\u001D\u0010E\u001A\u00020\u000E2\u0006\u0010)\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\bE\u0010FJ\u0015\u0010G\u001A\u00020\u000E2\u0006\u00100\u001A\u00020\u0007\u00A2\u0006\u0004\bG\u0010HJ\u0017\u0010I\u001A\u00020\u000E2\u0006\u00100\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\bI\u0010HJ%\u0010J\u001A\u00020\u000E2\u0006\u00100\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\r\u001A\u00020 \u00A2\u0006\u0004\bJ\u0010KJ%\u0010L\u001A\u00020\u000E2\u0006\u00100\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\u0011\u00A2\u0006\u0004\bL\u0010MJ%\u0010N\u001A\u00020\u000E2\u0006\u00100\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\u0014\u00A2\u0006\u0004\bN\u0010OJ%\u0010P\u001A\u00020\u000E2\u0006\u00100\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\b\u00A2\u0006\u0004\bP\u0010QJ%\u0010R\u001A\u00020\u000E2\u0006\u00100\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\u0017\u00A2\u0006\u0004\bR\u0010SJ%\u0010T\u001A\u00020\u000E2\u0006\u00100\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\u001A\u00A2\u0006\u0004\bT\u0010UJ%\u0010V\u001A\u00020\u000E2\u0006\u00100\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\u001D\u00A2\u0006\u0004\bV\u0010WJ%\u0010X\u001A\u00020\u000E2\u0006\u00100\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\r\u001A\u00020#\u00A2\u0006\u0004\bX\u0010YJ%\u0010Z\u001A\u00020\u000E2\u0006\u00100\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\r\u001A\u00020&\u00A2\u0006\u0004\bZ\u0010[J\u001D\u0010\\\u001A\u00020\u00032\u0006\u00100\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b\\\u0010]JA\u0010a\u001A\u00020\u000E\"\n\b\u0001\u0010^*\u0004\u0018\u00010\u00012\u0006\u00100\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\b2\f\u0010`\u001A\b\u0012\u0004\u0012\u00028\u00010_2\u0006\u0010\r\u001A\u00028\u0001H\u0016\u00A2\u0006\u0004\ba\u0010bJA\u0010c\u001A\u00020\u000E\"\b\b\u0001\u0010^*\u00020\u00012\u0006\u00100\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\b2\f\u0010`\u001A\b\u0012\u0004\u0012\u00028\u00010_2\b\u0010\r\u001A\u0004\u0018\u00018\u0001H\u0016\u00A2\u0006\u0004\bc\u0010bJ\u0017\u0010e\u001A\u00020\u000E2\u0006\u0010d\u001A\u00028\u0000H\u0004\u00A2\u0006\u0004\be\u0010fJ\u000F\u0010g\u001A\u00028\u0000H\u0004\u00A2\u0006\u0004\bg\u0010hJ\u001F\u0010j\u001A\u00020 2\u0006\u0010i\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\bH\u0002\u00A2\u0006\u0004\bj\u0010kR$\u0010n\u001A\u0012\u0012\u0004\u0012\u00028\u00000lj\b\u0012\u0004\u0012\u00028\u0000`m8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bn\u0010oR\u0014\u0010q\u001A\u00028\u00008DX\u0084\u0004\u00A2\u0006\u0006\u001A\u0004\bp\u0010hR\u0016\u0010s\u001A\u0004\u0018\u00018\u00008DX\u0084\u0004\u00A2\u0006\u0006\u001A\u0004\br\u0010h\u00A8\u0006t"}, d2 = {"Lkotlinx/serialization/internal/TaggedEncoder;", "", "Tag", "Lkotlinx/serialization/encoding/Encoder;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "<init>", "()V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "index", "getTag", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/Object;", "tag", "value", "Lie/H;", "encodeTaggedInt", "(Ljava/lang/Object;I)V", "", "encodeTaggedByte", "(Ljava/lang/Object;B)V", "", "encodeTaggedShort", "(Ljava/lang/Object;S)V", "", "encodeTaggedLong", "(Ljava/lang/Object;J)V", "", "encodeTaggedFloat", "(Ljava/lang/Object;F)V", "", "encodeTaggedDouble", "(Ljava/lang/Object;D)V", "", "encodeTaggedBoolean", "(Ljava/lang/Object;Z)V", "", "encodeTaggedChar", "(Ljava/lang/Object;C)V", "", "encodeTaggedString", "(Ljava/lang/Object;Ljava/lang/String;)V", "enumDescriptor", "ordinal", "encodeTaggedEnum", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;I)V", "inlineDescriptor", "encodeTaggedInline", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Encoder;", "descriptor", "encodeInline", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Encoder;", "encodeBoolean", "(Z)V", "encodeByte", "(B)V", "encodeShort", "(S)V", "encodeInt", "(I)V", "encodeLong", "(J)V", "encodeFloat", "(F)V", "encodeDouble", "(D)V", "encodeChar", "(C)V", "encodeString", "(Ljava/lang/String;)V", "encodeEnum", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)V", "endStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "endEncode", "encodeBooleanElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IZ)V", "encodeByteElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IB)V", "encodeShortElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IS)V", "encodeIntElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;II)V", "encodeLongElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IJ)V", "encodeFloatElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IF)V", "encodeDoubleElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ID)V", "encodeCharElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IC)V", "encodeStringElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILjava/lang/String;)V", "encodeInlineElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Lkotlinx/serialization/encoding/Encoder;", "T", "Lkotlinx/serialization/SerializationStrategy;", "serializer", "encodeSerializableElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeNullableSerializableElement", "name", "pushTag", "(Ljava/lang/Object;)V", "popTag", "()Ljava/lang/Object;", "desc", "encodeElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "tagStack", "Ljava/util/ArrayList;", "getCurrentTag", "currentTag", "getCurrentTagOrNull", "currentTagOrNull", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public abstract class TaggedEncoder implements CompositeEncoder, Encoder {
    @NotNull
    private final ArrayList tagStack;

    public TaggedEncoder() {
        this.tagStack = new ArrayList();
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    @NotNull
    public CompositeEncoder beginCollection(@NotNull SerialDescriptor serialDescriptor0, int v) {
        return DefaultImpls.beginCollection(this, serialDescriptor0, v);
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    public final void encodeBoolean(boolean z) {
        this.encodeTaggedBoolean(this.popTag(), z);
    }

    @Override  // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeBooleanElement(@NotNull SerialDescriptor serialDescriptor0, int v, boolean z) {
        q.g(serialDescriptor0, "descriptor");
        this.encodeTaggedBoolean(this.getTag(serialDescriptor0, v), z);
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    public final void encodeByte(byte b) {
        this.encodeTaggedByte(this.popTag(), b);
    }

    @Override  // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeByteElement(@NotNull SerialDescriptor serialDescriptor0, int v, byte b) {
        q.g(serialDescriptor0, "descriptor");
        this.encodeTaggedByte(this.getTag(serialDescriptor0, v), b);
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    public final void encodeChar(char c) {
        this.encodeTaggedChar(this.popTag(), c);
    }

    @Override  // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeCharElement(@NotNull SerialDescriptor serialDescriptor0, int v, char c) {
        q.g(serialDescriptor0, "descriptor");
        this.encodeTaggedChar(this.getTag(serialDescriptor0, v), c);
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    public final void encodeDouble(double f) {
        this.encodeTaggedDouble(this.popTag(), f);
    }

    @Override  // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeDoubleElement(@NotNull SerialDescriptor serialDescriptor0, int v, double f) {
        q.g(serialDescriptor0, "descriptor");
        this.encodeTaggedDouble(this.getTag(serialDescriptor0, v), f);
    }

    private final boolean encodeElement(SerialDescriptor serialDescriptor0, int v) {
        this.pushTag(this.getTag(serialDescriptor0, v));
        return true;
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    public final void encodeEnum(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "enumDescriptor");
        this.encodeTaggedEnum(this.popTag(), serialDescriptor0, v);
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    public final void encodeFloat(float f) {
        this.encodeTaggedFloat(this.popTag(), f);
    }

    @Override  // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeFloatElement(@NotNull SerialDescriptor serialDescriptor0, int v, float f) {
        q.g(serialDescriptor0, "descriptor");
        this.encodeTaggedFloat(this.getTag(serialDescriptor0, v), f);
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    @NotNull
    public Encoder encodeInline(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
        return this.encodeTaggedInline(this.popTag(), serialDescriptor0);
    }

    @Override  // kotlinx.serialization.encoding.CompositeEncoder
    @NotNull
    public final Encoder encodeInlineElement(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return this.encodeTaggedInline(this.getTag(serialDescriptor0, v), serialDescriptor0.getElementDescriptor(v));
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    public final void encodeInt(int v) {
        this.encodeTaggedInt(this.popTag(), v);
    }

    @Override  // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeIntElement(@NotNull SerialDescriptor serialDescriptor0, int v, int v1) {
        q.g(serialDescriptor0, "descriptor");
        this.encodeTaggedInt(this.getTag(serialDescriptor0, v), v1);
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    public final void encodeLong(long v) {
        this.encodeTaggedLong(this.popTag(), v);
    }

    @Override  // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeLongElement(@NotNull SerialDescriptor serialDescriptor0, int v, long v1) {
        q.g(serialDescriptor0, "descriptor");
        this.encodeTaggedLong(this.getTag(serialDescriptor0, v), v1);
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
    public abstract void encodeSerializableValue(@NotNull SerializationStrategy arg1, Object arg2);

    @Override  // kotlinx.serialization.encoding.Encoder
    public final void encodeShort(short v) {
        this.encodeTaggedShort(this.popTag(), v);
    }

    @Override  // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeShortElement(@NotNull SerialDescriptor serialDescriptor0, int v, short v1) {
        q.g(serialDescriptor0, "descriptor");
        this.encodeTaggedShort(this.getTag(serialDescriptor0, v), v1);
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    public final void encodeString(@NotNull String s) {
        q.g(s, "value");
        this.encodeTaggedString(this.popTag(), s);
    }

    @Override  // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeStringElement(@NotNull SerialDescriptor serialDescriptor0, int v, @NotNull String s) {
        q.g(serialDescriptor0, "descriptor");
        q.g(s, "value");
        this.encodeTaggedString(this.getTag(serialDescriptor0, v), s);
    }

    public abstract void encodeTaggedBoolean(Object arg1, boolean arg2);

    public abstract void encodeTaggedByte(Object arg1, byte arg2);

    public abstract void encodeTaggedChar(Object arg1, char arg2);

    public abstract void encodeTaggedDouble(Object arg1, double arg2);

    public abstract void encodeTaggedEnum(Object arg1, @NotNull SerialDescriptor arg2, int arg3);

    public abstract void encodeTaggedFloat(Object arg1, float arg2);

    @NotNull
    public Encoder encodeTaggedInline(Object object0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "inlineDescriptor");
        this.pushTag(object0);
        return this;
    }

    public abstract void encodeTaggedInt(Object arg1, int arg2);

    public abstract void encodeTaggedLong(Object arg1, long arg2);

    public abstract void encodeTaggedShort(Object arg1, short arg2);

    public abstract void encodeTaggedString(Object arg1, @NotNull String arg2);

    public abstract void endEncode(@NotNull SerialDescriptor arg1);

    @Override  // kotlinx.serialization.encoding.CompositeEncoder
    public final void endStructure(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
        if(!this.tagStack.isEmpty()) {
            this.popTag();
        }
        this.endEncode(serialDescriptor0);
    }

    public final Object getCurrentTag() {
        return p.s0(this.tagStack);
    }

    @Nullable
    public final Object getCurrentTagOrNull() {
        return p.t0(this.tagStack);
    }

    public abstract Object getTag(@NotNull SerialDescriptor arg1, int arg2);

    public final Object popTag() {
        if(this.tagStack.isEmpty()) {
            throw new SerializationException("No tag in stack for requested element");
        }
        int v = k.s(this.tagStack);
        return this.tagStack.remove(v);
    }

    public final void pushTag(Object object0) {
        this.tagStack.add(object0);
    }
}

