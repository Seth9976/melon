package kotlinx.serialization.builtins;

import De.d;
import Uf.a;
import ie.D;
import ie.H;
import ie.t;
import ie.w;
import ie.z;
import kotlin.Metadata;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.b;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.s;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanArraySerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.ByteArraySerializer;
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.CharArraySerializer;
import kotlinx.serialization.internal.CharSerializer;
import kotlinx.serialization.internal.DoubleArraySerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.DurationSerializer;
import kotlinx.serialization.internal.FloatArraySerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.IntArraySerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.LongArraySerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.MapEntrySerializer;
import kotlinx.serialization.internal.NothingSerializer;
import kotlinx.serialization.internal.NullableSerializer;
import kotlinx.serialization.internal.PairSerializer;
import kotlinx.serialization.internal.ReferenceArraySerializer;
import kotlinx.serialization.internal.ShortArraySerializer;
import kotlinx.serialization.internal.ShortSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.internal.TripleSerializer;
import kotlinx.serialization.internal.UByteArraySerializer;
import kotlinx.serialization.internal.UByteSerializer;
import kotlinx.serialization.internal.UIntArraySerializer;
import kotlinx.serialization.internal.UIntSerializer;
import kotlinx.serialization.internal.ULongArraySerializer;
import kotlinx.serialization.internal.ULongSerializer;
import kotlinx.serialization.internal.UShortArraySerializer;
import kotlinx.serialization.internal.UShortSerializer;
import kotlinx.serialization.internal.UnitSerializer;
import kotlinx.serialization.internal.UuidSerializer;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u00C0\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0006\u001AG\u0010\u0006\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00010\u0002\u00A2\u0006\u0004\b\u0006\u0010\u0007\u001AG\u0010\t\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b0\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00010\u0002\u00A2\u0006\u0004\b\t\u0010\u0007\u001Aa\u0010\u0011\u001A\u001A\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00100\u0002\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000B\"\u0004\b\u0002\u0010\f2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00020\u0002\u00A2\u0006\u0004\b\u0011\u0010\u0012\u001A\u0017\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00140\u0002*\u00020\u0013\u00A2\u0006\u0004\b\u0015\u0010\u0016\u001A\u0013\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00170\u0002\u00A2\u0006\u0004\b\u0018\u0010\u0019\u001A\u0017\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u001B0\u0002*\u00020\u001A\u00A2\u0006\u0004\b\u0015\u0010\u001C\u001A\u0013\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u001D0\u0002\u00A2\u0006\u0004\b\u001E\u0010\u0019\u001A\u0015\u0010 \u001A\b\u0012\u0004\u0012\u00020\u001F0\u0002H\u0007\u00A2\u0006\u0004\b \u0010\u0019\u001A\u0017\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\"0\u0002*\u00020!\u00A2\u0006\u0004\b\u0015\u0010#\u001A\u0013\u0010%\u001A\b\u0012\u0004\u0012\u00020$0\u0002\u00A2\u0006\u0004\b%\u0010\u0019\u001A\u0015\u0010\'\u001A\b\u0012\u0004\u0012\u00020&0\u0002H\u0007\u00A2\u0006\u0004\b\'\u0010\u0019\u001A\u0017\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020)0\u0002*\u00020(\u00A2\u0006\u0004\b\u0015\u0010*\u001A\u0013\u0010,\u001A\b\u0012\u0004\u0012\u00020+0\u0002\u00A2\u0006\u0004\b,\u0010\u0019\u001A\u0015\u0010.\u001A\b\u0012\u0004\u0012\u00020-0\u0002H\u0007\u00A2\u0006\u0004\b.\u0010\u0019\u001A\u0017\u0010\u0015\u001A\b\u0012\u0004\u0012\u0002000\u0002*\u00020/\u00A2\u0006\u0004\b\u0015\u00101\u001A\u0013\u00103\u001A\b\u0012\u0004\u0012\u0002020\u0002\u00A2\u0006\u0004\b3\u0010\u0019\u001A\u0015\u00105\u001A\b\u0012\u0004\u0012\u0002040\u0002H\u0007\u00A2\u0006\u0004\b5\u0010\u0019\u001A\u0017\u0010\u0015\u001A\b\u0012\u0004\u0012\u0002070\u0002*\u000206\u00A2\u0006\u0004\b\u0015\u00108\u001A\u0013\u0010:\u001A\b\u0012\u0004\u0012\u0002090\u0002\u00A2\u0006\u0004\b:\u0010\u0019\u001A\u0017\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020<0\u0002*\u00020;\u00A2\u0006\u0004\b\u0015\u0010=\u001A\u0013\u0010?\u001A\b\u0012\u0004\u0012\u00020>0\u0002\u00A2\u0006\u0004\b?\u0010\u0019\u001A\u0017\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020A0\u0002*\u00020@\u00A2\u0006\u0004\b\u0015\u0010B\u001A\u0013\u0010D\u001A\b\u0012\u0004\u0012\u00020C0\u0002\u00A2\u0006\u0004\bD\u0010\u0019\u001A\u0017\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020E0\u0002*\u00020E\u00A2\u0006\u0004\b\u0015\u0010F\u001A\u0017\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020H0\u0002*\u00020G\u00A2\u0006\u0004\b\u0015\u0010I\u001AM\u0010Q\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010P0\u0002\"\b\b\u0000\u0010K*\u00020J\"\n\b\u0001\u0010L*\u0004\u0018\u00018\u00002\f\u0010N\u001A\b\u0012\u0004\u0012\u00028\u00000M2\f\u0010O\u001A\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0007\u00A2\u0006\u0004\bQ\u0010R\u001A-\u0010T\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000S0\u0002\"\u0004\b\u0000\u0010K2\f\u0010O\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\u00A2\u0006\u0004\bT\u0010U\u001A-\u0010W\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000V0\u0002\"\u0004\b\u0000\u0010K2\f\u0010O\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\u00A2\u0006\u0004\bW\u0010U\u001AG\u0010Y\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010X0\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00010\u0002\u00A2\u0006\u0004\bY\u0010\u0007\u001A\u0017\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020[0\u0002*\u00020Z\u00A2\u0006\u0004\b\u0015\u0010\\\u001A\u0017\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020^0\u0002*\u00020]\u00A2\u0006\u0004\b\u0015\u0010_\u001A\u0017\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020a0\u0002*\u00020`\u00A2\u0006\u0004\b\u0015\u0010b\u001A\u0017\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020d0\u0002*\u00020c\u00A2\u0006\u0004\b\u0015\u0010e\u001A\u0017\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020g0\u0002*\u00020f\u00A2\u0006\u0004\b\u0015\u0010h\u001A\u0019\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020j0\u0002*\u00020iH\u0007\u00A2\u0006\u0004\b\u0015\u0010k\u001A\u0015\u0010m\u001A\b\u0012\u0004\u0012\u00020l0\u0002H\u0007\u00A2\u0006\u0004\bm\u0010\u0019\"3\u0010q\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002\"\b\b\u0000\u0010K*\u00020J*\b\u0012\u0004\u0012\u00028\u00000\u00028F\u00A2\u0006\f\u0012\u0004\bo\u0010p\u001A\u0004\bn\u0010U\u00A8\u0006r"}, d2 = {"K", "V", "Lkotlinx/serialization/KSerializer;", "keySerializer", "valueSerializer", "Lie/m;", "PairSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "", "MapEntrySerializer", "A", "B", "C", "aSerializer", "bSerializer", "cSerializer", "Lie/s;", "TripleSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "Lkotlin/Char$Companion;", "", "serializer", "(Lkotlin/jvm/internal/f;)Lkotlinx/serialization/KSerializer;", "", "CharArraySerializer", "()Lkotlinx/serialization/KSerializer;", "Lkotlin/Byte$Companion;", "", "(Lkotlin/jvm/internal/c;)Lkotlinx/serialization/KSerializer;", "", "ByteArraySerializer", "Lie/v;", "UByteArraySerializer", "Lkotlin/Short$Companion;", "", "(Lkotlin/jvm/internal/L;)Lkotlinx/serialization/KSerializer;", "", "ShortArraySerializer", "Lie/F;", "UShortArraySerializer", "Lkotlin/Int$Companion;", "", "(Lkotlin/jvm/internal/o;)Lkotlinx/serialization/KSerializer;", "", "IntArraySerializer", "Lie/y;", "UIntArraySerializer", "Lkotlin/Long$Companion;", "", "(Lkotlin/jvm/internal/s;)Lkotlinx/serialization/KSerializer;", "", "LongArraySerializer", "Lie/B;", "ULongArraySerializer", "Lkotlin/Float$Companion;", "", "(Lkotlin/jvm/internal/j;)Lkotlinx/serialization/KSerializer;", "", "FloatArraySerializer", "Lkotlin/Double$Companion;", "", "(Lkotlin/jvm/internal/i;)Lkotlinx/serialization/KSerializer;", "", "DoubleArraySerializer", "Lkotlin/Boolean$Companion;", "", "(Lkotlin/jvm/internal/b;)Lkotlinx/serialization/KSerializer;", "", "BooleanArraySerializer", "Lie/H;", "(Lie/H;)Lkotlinx/serialization/KSerializer;", "Lkotlin/String$Companion;", "", "(Lkotlin/jvm/internal/M;)Lkotlinx/serialization/KSerializer;", "", "T", "E", "LDe/d;", "kClass", "elementSerializer", "", "ArraySerializer", "(LDe/d;Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "", "ListSerializer", "(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "", "SetSerializer", "", "MapSerializer", "Lie/w;", "Lie/x;", "(Lie/w;)Lkotlinx/serialization/KSerializer;", "Lie/z;", "Lie/A;", "(Lie/z;)Lkotlinx/serialization/KSerializer;", "Lie/t;", "Lie/u;", "(Lie/t;)Lkotlinx/serialization/KSerializer;", "Lie/D;", "Lie/E;", "(Lie/D;)Lkotlinx/serialization/KSerializer;", "LUf/a;", "LUf/b;", "(LUf/a;)Lkotlinx/serialization/KSerializer;", "LVf/a;", "LVf/b;", "(LVf/a;)Lkotlinx/serialization/KSerializer;", "", "NothingSerializer", "getNullable", "getNullable$annotations", "(Lkotlinx/serialization/KSerializer;)V", "nullable", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class BuiltinSerializersKt {
    @NotNull
    public static final KSerializer ArraySerializer(@NotNull d d0, @NotNull KSerializer kSerializer0) {
        q.g(d0, "kClass");
        q.g(kSerializer0, "elementSerializer");
        return new ReferenceArraySerializer(d0, kSerializer0);
    }

    @NotNull
    public static final KSerializer BooleanArraySerializer() {
        return BooleanArraySerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer ByteArraySerializer() {
        return ByteArraySerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer CharArraySerializer() {
        return CharArraySerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer DoubleArraySerializer() {
        return DoubleArraySerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer FloatArraySerializer() {
        return FloatArraySerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer IntArraySerializer() {
        return IntArraySerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer ListSerializer(@NotNull KSerializer kSerializer0) {
        q.g(kSerializer0, "elementSerializer");
        return new ArrayListSerializer(kSerializer0);
    }

    @NotNull
    public static final KSerializer LongArraySerializer() {
        return LongArraySerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer MapEntrySerializer(@NotNull KSerializer kSerializer0, @NotNull KSerializer kSerializer1) {
        q.g(kSerializer0, "keySerializer");
        q.g(kSerializer1, "valueSerializer");
        return new MapEntrySerializer(kSerializer0, kSerializer1);
    }

    @NotNull
    public static final KSerializer MapSerializer(@NotNull KSerializer kSerializer0, @NotNull KSerializer kSerializer1) {
        q.g(kSerializer0, "keySerializer");
        q.g(kSerializer1, "valueSerializer");
        return new LinkedHashMapSerializer(kSerializer0, kSerializer1);
    }

    @NotNull
    public static final KSerializer NothingSerializer() {
        return NothingSerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer PairSerializer(@NotNull KSerializer kSerializer0, @NotNull KSerializer kSerializer1) {
        q.g(kSerializer0, "keySerializer");
        q.g(kSerializer1, "valueSerializer");
        return new PairSerializer(kSerializer0, kSerializer1);
    }

    @NotNull
    public static final KSerializer SetSerializer(@NotNull KSerializer kSerializer0) {
        q.g(kSerializer0, "elementSerializer");
        return new LinkedHashSetSerializer(kSerializer0);
    }

    @NotNull
    public static final KSerializer ShortArraySerializer() {
        return ShortArraySerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer TripleSerializer(@NotNull KSerializer kSerializer0, @NotNull KSerializer kSerializer1, @NotNull KSerializer kSerializer2) {
        q.g(kSerializer0, "aSerializer");
        q.g(kSerializer1, "bSerializer");
        q.g(kSerializer2, "cSerializer");
        return new TripleSerializer(kSerializer0, kSerializer1, kSerializer2);
    }

    @NotNull
    public static final KSerializer UByteArraySerializer() {
        return UByteArraySerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer UIntArraySerializer() {
        return UIntArraySerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer ULongArraySerializer() {
        return ULongArraySerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer UShortArraySerializer() {
        return UShortArraySerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer getNullable(@NotNull KSerializer kSerializer0) {
        q.g(kSerializer0, "<this>");
        return kSerializer0.getDescriptor().isNullable() ? kSerializer0 : new NullableSerializer(kSerializer0);
    }

    @NotNull
    public static final KSerializer serializer(@NotNull a a0) {
        q.g(a0, "<this>");
        return DurationSerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer serializer(@NotNull Vf.a a0) {
        q.g(a0, "<this>");
        return UuidSerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer serializer(@NotNull D d0) {
        q.g(d0, "<this>");
        return UShortSerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer serializer(@NotNull H h0) {
        q.g(h0, "<this>");
        return UnitSerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer serializer(@NotNull t t0) {
        q.g(t0, "<this>");
        return UByteSerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer serializer(@NotNull w w0) {
        q.g(w0, "<this>");
        return UIntSerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer serializer(@NotNull z z0) {
        q.g(z0, "<this>");
        return ULongSerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer serializer(@NotNull L l0) {
        q.g(l0, "<this>");
        return ShortSerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer serializer(@NotNull M m0) {
        q.g(m0, "<this>");
        return StringSerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer serializer(@NotNull b b0) {
        q.g(b0, "<this>");
        return BooleanSerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer serializer(@NotNull c c0) {
        q.g(c0, "<this>");
        return ByteSerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer serializer(@NotNull f f0) {
        q.g(f0, "<this>");
        return CharSerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer serializer(@NotNull i i0) {
        q.g(i0, "<this>");
        return DoubleSerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer serializer(@NotNull j j0) {
        q.g(j0, "<this>");
        return FloatSerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer serializer(@NotNull o o0) {
        q.g(o0, "<this>");
        return IntSerializer.INSTANCE;
    }

    @NotNull
    public static final KSerializer serializer(@NotNull s s0) {
        q.g(s0, "<this>");
        return LongSerializer.INSTANCE;
    }
}

