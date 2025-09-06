package kotlinx.serialization.internal;

import dg.c;
import e.k;
import java.util.ArrayList;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder.DefaultImpls;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u0000\u008E\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\'\u0018\u0000*\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00012\u00020\u00032\u00020\u0004B\u0007\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u001B\u0010\n\u001A\u00028\u0000*\u00020\u00072\u0006\u0010\t\u001A\u00020\bH$\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00028\u0000H\u0014\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0011\u001A\u00020\u00102\u0006\u0010\f\u001A\u00028\u0000H\u0014\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001A\u00020\u00132\u0006\u0010\f\u001A\u00028\u0000H\u0014\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001A\u00020\b2\u0006\u0010\f\u001A\u00028\u0000H\u0014\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001A\u00020\u00182\u0006\u0010\f\u001A\u00028\u0000H\u0014\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0017\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\f\u001A\u00028\u0000H\u0014\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0017\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\f\u001A\u00028\u0000H\u0014\u00A2\u0006\u0004\b\u001F\u0010 J\u0017\u0010\"\u001A\u00020!2\u0006\u0010\f\u001A\u00028\u0000H\u0014\u00A2\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001A\u00020$2\u0006\u0010\f\u001A\u00028\u0000H\u0014\u00A2\u0006\u0004\b%\u0010&J\u001F\u0010(\u001A\u00020\b2\u0006\u0010\f\u001A\u00028\u00002\u0006\u0010\'\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b(\u0010)J\u001F\u0010+\u001A\u00020\u00032\u0006\u0010\f\u001A\u00028\u00002\u0006\u0010*\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b+\u0010,J3\u00101\u001A\u00028\u0001\"\n\b\u0001\u0010-*\u0004\u0018\u00010\u00012\f\u0010/\u001A\b\u0012\u0004\u0012\u00028\u00010.2\b\u00100\u001A\u0004\u0018\u00018\u0001H\u0014\u00A2\u0006\u0004\b1\u00102J\u0017\u00104\u001A\u00020\u00032\u0006\u00103\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b4\u00105J\u000F\u00107\u001A\u0004\u0018\u000106\u00A2\u0006\u0004\b7\u00108J\r\u00109\u001A\u00020\r\u00A2\u0006\u0004\b9\u0010:J\r\u0010;\u001A\u00020\u0010\u00A2\u0006\u0004\b;\u0010<J\r\u0010=\u001A\u00020\u0013\u00A2\u0006\u0004\b=\u0010>J\r\u0010?\u001A\u00020\b\u00A2\u0006\u0004\b?\u0010@J\r\u0010A\u001A\u00020\u0018\u00A2\u0006\u0004\bA\u0010BJ\r\u0010C\u001A\u00020\u001B\u00A2\u0006\u0004\bC\u0010DJ\r\u0010E\u001A\u00020\u001E\u00A2\u0006\u0004\bE\u0010FJ\r\u0010G\u001A\u00020!\u00A2\u0006\u0004\bG\u0010HJ\r\u0010I\u001A\u00020$\u00A2\u0006\u0004\bI\u0010JJ\u0015\u0010K\u001A\u00020\b2\u0006\u0010\'\u001A\u00020\u0007\u00A2\u0006\u0004\bK\u0010LJ\u001D\u0010M\u001A\u00020\r2\u0006\u00103\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\bM\u0010NJ\u001D\u0010O\u001A\u00020\u00102\u0006\u00103\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\bO\u0010PJ\u001D\u0010Q\u001A\u00020\u00132\u0006\u00103\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\bQ\u0010RJ\u001D\u0010S\u001A\u00020\b2\u0006\u00103\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\bS\u0010TJ\u001D\u0010U\u001A\u00020\u00182\u0006\u00103\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\bU\u0010VJ\u001D\u0010W\u001A\u00020\u001B2\u0006\u00103\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\bW\u0010XJ\u001D\u0010Y\u001A\u00020\u001E2\u0006\u00103\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\bY\u0010ZJ\u001D\u0010[\u001A\u00020!2\u0006\u00103\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b[\u0010\\J\u001D\u0010]\u001A\u00020$2\u0006\u00103\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b]\u0010^J\u001D\u0010_\u001A\u00020\u00032\u0006\u00103\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b_\u0010`JA\u0010a\u001A\u00028\u0001\"\n\b\u0001\u0010-*\u0004\u0018\u00010\u00012\u0006\u00103\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\b2\f\u0010/\u001A\b\u0012\u0004\u0012\u00028\u00010.2\b\u00100\u001A\u0004\u0018\u00018\u0001\u00A2\u0006\u0004\ba\u0010bJC\u0010c\u001A\u0004\u0018\u00018\u0001\"\b\b\u0001\u0010-*\u00020\u00012\u0006\u00103\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\b2\u000E\u0010/\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010.2\b\u00100\u001A\u0004\u0018\u00018\u0001\u00A2\u0006\u0004\bc\u0010bJ\u0017\u0010f\u001A\u00020e2\u0006\u0010d\u001A\u00028\u0000H\u0004\u00A2\u0006\u0004\bf\u0010gJ\u000F\u0010h\u001A\u00028\u0000H\u0004\u00A2\u0006\u0004\bh\u0010iJ+\u0010m\u001A\u00028\u0001\"\u0004\b\u0001\u0010j2\u0006\u0010\f\u001A\u00028\u00002\f\u0010l\u001A\b\u0012\u0004\u0012\u00028\u00010kH\u0002\u00A2\u0006\u0004\bm\u0010nR*\u0010q\u001A\u0012\u0012\u0004\u0012\u00028\u00000oj\b\u0012\u0004\u0012\u00028\u0000`p8\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\bq\u0010r\u001A\u0004\bs\u0010tR\u0016\u0010u\u001A\u00020\r8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010x\u001A\u0004\u0018\u00018\u00008DX\u0084\u0004\u00A2\u0006\u0006\u001A\u0004\bw\u0010i\u00A8\u0006y"}, d2 = {"Lkotlinx/serialization/internal/TaggedDecoder;", "", "Tag", "Lkotlinx/serialization/encoding/Decoder;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "<init>", "()V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "index", "getTag", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/Object;", "tag", "", "decodeTaggedBoolean", "(Ljava/lang/Object;)Z", "", "decodeTaggedByte", "(Ljava/lang/Object;)B", "", "decodeTaggedShort", "(Ljava/lang/Object;)S", "decodeTaggedInt", "(Ljava/lang/Object;)I", "", "decodeTaggedLong", "(Ljava/lang/Object;)J", "", "decodeTaggedFloat", "(Ljava/lang/Object;)F", "", "decodeTaggedDouble", "(Ljava/lang/Object;)D", "", "decodeTaggedChar", "(Ljava/lang/Object;)C", "", "decodeTaggedString", "(Ljava/lang/Object;)Ljava/lang/String;", "enumDescriptor", "decodeTaggedEnum", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "inlineDescriptor", "decodeTaggedInline", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", "T", "Lkotlinx/serialization/DeserializationStrategy;", "deserializer", "previousValue", "decodeSerializableValue", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "descriptor", "decodeInline", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", "", "decodeNull", "()Ljava/lang/Void;", "decodeBoolean", "()Z", "decodeByte", "()B", "decodeShort", "()S", "decodeInt", "()I", "decodeLong", "()J", "decodeFloat", "()F", "decodeDouble", "()D", "decodeChar", "()C", "decodeString", "()Ljava/lang/String;", "decodeEnum", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "decodeBooleanElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "decodeByteElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)B", "decodeShortElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)S", "decodeIntElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)I", "decodeLongElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)J", "decodeFloatElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)F", "decodeDoubleElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)D", "decodeCharElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)C", "decodeStringElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/String;", "decodeInlineElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Lkotlinx/serialization/encoding/Decoder;", "decodeSerializableElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeNullableSerializableElement", "name", "Lie/H;", "pushTag", "(Ljava/lang/Object;)V", "popTag", "()Ljava/lang/Object;", "E", "Lkotlin/Function0;", "block", "tagBlock", "(Ljava/lang/Object;Lwe/a;)Ljava/lang/Object;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "tagStack", "Ljava/util/ArrayList;", "getTagStack$kotlinx_serialization_core", "()Ljava/util/ArrayList;", "flag", "Z", "getCurrentTagOrNull", "currentTagOrNull", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public abstract class TaggedDecoder implements CompositeDecoder, Decoder {
    private boolean flag;
    @NotNull
    private final ArrayList tagStack;

    public TaggedDecoder() {
        this.tagStack = new ArrayList();
    }

    public static Object a(TaggedDecoder taggedDecoder0, DeserializationStrategy deserializationStrategy0, Object object0) {
        return TaggedDecoder.decodeNullableSerializableElement$lambda$3(taggedDecoder0, deserializationStrategy0, object0);
    }

    public static Object b(TaggedDecoder taggedDecoder0, DeserializationStrategy deserializationStrategy0, Object object0) {
        return TaggedDecoder.decodeSerializableElement$lambda$1(taggedDecoder0, deserializationStrategy0, object0);
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    public final boolean decodeBoolean() {
        return this.decodeTaggedBoolean(this.popTag());
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public final boolean decodeBooleanElement(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return this.decodeTaggedBoolean(this.getTag(serialDescriptor0, v));
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    public final byte decodeByte() {
        return this.decodeTaggedByte(this.popTag());
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public final byte decodeByteElement(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return this.decodeTaggedByte(this.getTag(serialDescriptor0, v));
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    public final char decodeChar() {
        return this.decodeTaggedChar(this.popTag());
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public final char decodeCharElement(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return this.decodeTaggedChar(this.getTag(serialDescriptor0, v));
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public int decodeCollectionSize(@NotNull SerialDescriptor serialDescriptor0) {
        return DefaultImpls.decodeCollectionSize(this, serialDescriptor0);
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    public final double decodeDouble() {
        return this.decodeTaggedDouble(this.popTag());
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public final double decodeDoubleElement(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return this.decodeTaggedDouble(this.getTag(serialDescriptor0, v));
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    public final int decodeEnum(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "enumDescriptor");
        return this.decodeTaggedEnum(this.popTag(), serialDescriptor0);
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    public final float decodeFloat() {
        return this.decodeTaggedFloat(this.popTag());
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public final float decodeFloatElement(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return this.decodeTaggedFloat(this.getTag(serialDescriptor0, v));
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    @NotNull
    public Decoder decodeInline(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
        return this.decodeTaggedInline(this.popTag(), serialDescriptor0);
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    @NotNull
    public final Decoder decodeInlineElement(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return this.decodeTaggedInline(this.getTag(serialDescriptor0, v), serialDescriptor0.getElementDescriptor(v));
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    public final int decodeInt() {
        return this.decodeTaggedInt(this.popTag());
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public final int decodeIntElement(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return this.decodeTaggedInt(this.getTag(serialDescriptor0, v));
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    public final long decodeLong() {
        return this.decodeTaggedLong(this.popTag());
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public final long decodeLongElement(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return this.decodeTaggedLong(this.getTag(serialDescriptor0, v));
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    @Nullable
    public final Void decodeNull() {
        return null;
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    @Nullable
    public final Object decodeNullableSerializableElement(@NotNull SerialDescriptor serialDescriptor0, int v, @NotNull DeserializationStrategy deserializationStrategy0, @Nullable Object object0) {
        q.g(serialDescriptor0, "descriptor");
        q.g(deserializationStrategy0, "deserializer");
        return this.tagBlock(this.getTag(serialDescriptor0, v), new c(this, deserializationStrategy0, object0, 1));
    }

    private static final Object decodeNullableSerializableElement$lambda$3(TaggedDecoder taggedDecoder0, DeserializationStrategy deserializationStrategy0, Object object0) {
        return !deserializationStrategy0.getDescriptor().isNullable() && !taggedDecoder0.decodeNotNullMark() ? taggedDecoder0.decodeNull() : taggedDecoder0.decodeSerializableValue(deserializationStrategy0, object0);
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public boolean decodeSequentially() {
        return false;
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public final Object decodeSerializableElement(@NotNull SerialDescriptor serialDescriptor0, int v, @NotNull DeserializationStrategy deserializationStrategy0, @Nullable Object object0) {
        q.g(serialDescriptor0, "descriptor");
        q.g(deserializationStrategy0, "deserializer");
        return this.tagBlock(this.getTag(serialDescriptor0, v), new c(this, deserializationStrategy0, object0, 0));
    }

    private static final Object decodeSerializableElement$lambda$1(TaggedDecoder taggedDecoder0, DeserializationStrategy deserializationStrategy0, Object object0) {
        return taggedDecoder0.decodeSerializableValue(deserializationStrategy0, object0);
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    public abstract Object decodeSerializableValue(@NotNull DeserializationStrategy arg1);

    public Object decodeSerializableValue(@NotNull DeserializationStrategy deserializationStrategy0, @Nullable Object object0) {
        q.g(deserializationStrategy0, "deserializer");
        return this.decodeSerializableValue(deserializationStrategy0);
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    public final short decodeShort() {
        return this.decodeTaggedShort(this.popTag());
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public final short decodeShortElement(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return this.decodeTaggedShort(this.getTag(serialDescriptor0, v));
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    @NotNull
    public final String decodeString() {
        return this.decodeTaggedString(this.popTag());
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    @NotNull
    public final String decodeStringElement(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return this.decodeTaggedString(this.getTag(serialDescriptor0, v));
    }

    public abstract boolean decodeTaggedBoolean(Object arg1);

    public abstract byte decodeTaggedByte(Object arg1);

    public abstract char decodeTaggedChar(Object arg1);

    public abstract double decodeTaggedDouble(Object arg1);

    public abstract int decodeTaggedEnum(Object arg1, @NotNull SerialDescriptor arg2);

    public abstract float decodeTaggedFloat(Object arg1);

    @NotNull
    public Decoder decodeTaggedInline(Object object0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "inlineDescriptor");
        this.pushTag(object0);
        return this;
    }

    public abstract int decodeTaggedInt(Object arg1);

    public abstract long decodeTaggedLong(Object arg1);

    public abstract short decodeTaggedShort(Object arg1);

    @NotNull
    public abstract String decodeTaggedString(Object arg1);

    @Nullable
    public final Object getCurrentTagOrNull() {
        return p.t0(this.tagStack);
    }

    public abstract Object getTag(@NotNull SerialDescriptor arg1, int arg2);

    @NotNull
    public final ArrayList getTagStack$kotlinx_serialization_core() {
        return this.tagStack;
    }

    public final Object popTag() {
        int v = k.s(this.tagStack);
        Object object0 = this.tagStack.remove(v);
        this.flag = true;
        return object0;
    }

    public final void pushTag(Object object0) {
        this.tagStack.add(object0);
    }

    private final Object tagBlock(Object object0, a a0) {
        this.pushTag(object0);
        Object object1 = a0.invoke();
        if(!this.flag) {
            this.popTag();
        }
        this.flag = false;
        return object1;
    }
}

