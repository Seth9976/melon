package kotlinx.serialization.internal;

import ie.E;
import ie.F;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u000B\u001A\u00020\b*\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000E\u001A\u00020\u0005*\u00020\u0002H\u0014¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u0011\u001A\u00020\u0002H\u0014¢\u0006\u0004\b\u000F\u0010\u0010J/\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u0017\u001A\u00020\u0016H\u0014¢\u0006\u0004\b\u0019\u0010\u001AJ\'\u0010!\u001A\u00020\u00182\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001D\u001A\u00020\u00022\u0006\u0010\u001E\u001A\u00020\bH\u0014¢\u0006\u0004\b\u001F\u0010 ¨\u0006\""}, d2 = {"Lkotlinx/serialization/internal/UShortArraySerializer;", "Lkotlinx/serialization/KSerializer;", "Lie/F;", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Lie/E;", "Lkotlinx/serialization/internal/UShortArrayBuilder;", "<init>", "()V", "", "collectionSize-rL5Bavg", "([S)I", "collectionSize", "toBuilder-rL5Bavg", "([S)Lkotlinx/serialization/internal/UShortArrayBuilder;", "toBuilder", "empty-amswpOA", "()[S", "empty", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decoder", "index", "builder", "", "checkIndex", "Lie/H;", "readElement", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILkotlinx/serialization/internal/UShortArrayBuilder;Z)V", "Lkotlinx/serialization/encoding/CompositeEncoder;", "encoder", "content", "size", "writeContent-eny0XGE", "(Lkotlinx/serialization/encoding/CompositeEncoder;[SI)V", "writeContent", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class UShortArraySerializer extends PrimitiveArraySerializer implements KSerializer {
    @NotNull
    public static final UShortArraySerializer INSTANCE;

    static {
        UShortArraySerializer.INSTANCE = new UShortArraySerializer();
    }

    private UShortArraySerializer() {
        super(BuiltinSerializersKt.serializer(E.b));
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public int collectionSize(Object object0) {
        return this.collectionSize-rL5Bavg(((F)object0).a);
    }

    public int collectionSize-rL5Bavg(@NotNull short[] arr_v) {
        q.g(arr_v, "$this$collectionSize");
        return arr_v.length;
    }

    @Override  // kotlinx.serialization.internal.PrimitiveArraySerializer
    public Object empty() {
        return new F(this.empty-amswpOA());
    }

    @NotNull
    public short[] empty-amswpOA() {
        return new short[0];
    }

    @Override  // kotlinx.serialization.internal.CollectionLikeSerializer
    public void readElement(CompositeDecoder compositeDecoder0, int v, Object object0, boolean z) {
        this.readElement(compositeDecoder0, v, ((UShortArrayBuilder)object0), z);
    }

    public void readElement(@NotNull CompositeDecoder compositeDecoder0, int v, @NotNull UShortArrayBuilder uShortArrayBuilder0, boolean z) {
        q.g(compositeDecoder0, "decoder");
        q.g(uShortArrayBuilder0, "builder");
        uShortArrayBuilder0.append-xj2QHRw$kotlinx_serialization_core(compositeDecoder0.decodeInlineElement(this.getDescriptor(), v).decodeShort());
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public Object toBuilder(Object object0) {
        return this.toBuilder-rL5Bavg(((F)object0).a);
    }

    @NotNull
    public UShortArrayBuilder toBuilder-rL5Bavg(@NotNull short[] arr_v) {
        q.g(arr_v, "$this$toBuilder");
        return new UShortArrayBuilder(arr_v, null);
    }

    @Override  // kotlinx.serialization.internal.PrimitiveArraySerializer
    public void writeContent(CompositeEncoder compositeEncoder0, Object object0, int v) {
        this.writeContent-eny0XGE(compositeEncoder0, ((F)object0).a, v);
    }

    public void writeContent-eny0XGE(@NotNull CompositeEncoder compositeEncoder0, @NotNull short[] arr_v, int v) {
        q.g(compositeEncoder0, "encoder");
        q.g(arr_v, "content");
        for(int v1 = 0; v1 < v; ++v1) {
            compositeEncoder0.encodeInlineElement(this.getDescriptor(), v1).encodeShort(arr_v[v1]);
        }
    }
}

