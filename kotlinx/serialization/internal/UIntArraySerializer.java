package kotlinx.serialization.internal;

import ie.x;
import ie.y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u000B\u001A\u00020\b*\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000E\u001A\u00020\u0005*\u00020\u0002H\u0014¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u0011\u001A\u00020\u0002H\u0014¢\u0006\u0004\b\u000F\u0010\u0010J/\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u0017\u001A\u00020\u0016H\u0014¢\u0006\u0004\b\u0019\u0010\u001AJ\'\u0010!\u001A\u00020\u00182\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001D\u001A\u00020\u00022\u0006\u0010\u001E\u001A\u00020\bH\u0014¢\u0006\u0004\b\u001F\u0010 ¨\u0006\""}, d2 = {"Lkotlinx/serialization/internal/UIntArraySerializer;", "Lkotlinx/serialization/KSerializer;", "Lie/y;", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Lie/x;", "Lkotlinx/serialization/internal/UIntArrayBuilder;", "<init>", "()V", "", "collectionSize--ajY-9A", "([I)I", "collectionSize", "toBuilder--ajY-9A", "([I)Lkotlinx/serialization/internal/UIntArrayBuilder;", "toBuilder", "empty--hP7Qyg", "()[I", "empty", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decoder", "index", "builder", "", "checkIndex", "Lie/H;", "readElement", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILkotlinx/serialization/internal/UIntArrayBuilder;Z)V", "Lkotlinx/serialization/encoding/CompositeEncoder;", "encoder", "content", "size", "writeContent-CPlH8fI", "(Lkotlinx/serialization/encoding/CompositeEncoder;[II)V", "writeContent", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class UIntArraySerializer extends PrimitiveArraySerializer implements KSerializer {
    @NotNull
    public static final UIntArraySerializer INSTANCE;

    static {
        UIntArraySerializer.INSTANCE = new UIntArraySerializer();
    }

    private UIntArraySerializer() {
        super(BuiltinSerializersKt.serializer(x.b));
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public int collectionSize(Object object0) {
        return this.collectionSize--ajY-9A(((y)object0).a);
    }

    public int collectionSize--ajY-9A(@NotNull int[] arr_v) {
        q.g(arr_v, "$this$collectionSize");
        return arr_v.length;
    }

    @Override  // kotlinx.serialization.internal.PrimitiveArraySerializer
    public Object empty() {
        return new y(this.empty--hP7Qyg());
    }

    @NotNull
    public int[] empty--hP7Qyg() {
        return new int[0];
    }

    @Override  // kotlinx.serialization.internal.CollectionLikeSerializer
    public void readElement(CompositeDecoder compositeDecoder0, int v, Object object0, boolean z) {
        this.readElement(compositeDecoder0, v, ((UIntArrayBuilder)object0), z);
    }

    public void readElement(@NotNull CompositeDecoder compositeDecoder0, int v, @NotNull UIntArrayBuilder uIntArrayBuilder0, boolean z) {
        q.g(compositeDecoder0, "decoder");
        q.g(uIntArrayBuilder0, "builder");
        uIntArrayBuilder0.append-WZ4Q5Ns$kotlinx_serialization_core(compositeDecoder0.decodeInlineElement(this.getDescriptor(), v).decodeInt());
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public Object toBuilder(Object object0) {
        return this.toBuilder--ajY-9A(((y)object0).a);
    }

    @NotNull
    public UIntArrayBuilder toBuilder--ajY-9A(@NotNull int[] arr_v) {
        q.g(arr_v, "$this$toBuilder");
        return new UIntArrayBuilder(arr_v, null);
    }

    @Override  // kotlinx.serialization.internal.PrimitiveArraySerializer
    public void writeContent(CompositeEncoder compositeEncoder0, Object object0, int v) {
        this.writeContent-CPlH8fI(compositeEncoder0, ((y)object0).a, v);
    }

    public void writeContent-CPlH8fI(@NotNull CompositeEncoder compositeEncoder0, @NotNull int[] arr_v, int v) {
        q.g(compositeEncoder0, "encoder");
        q.g(arr_v, "content");
        for(int v1 = 0; v1 < v; ++v1) {
            compositeEncoder0.encodeInlineElement(this.getDescriptor(), v1).encodeInt(arr_v[v1]);
        }
    }
}

