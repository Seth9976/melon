package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\b\u001A\u00020\u0004*\u00020\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001A\u00020\u0005*\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\f\u001A\u00020\u0002H\u0014¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00020\u0012H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\'\u0010\u001B\u001A\u00020\u00142\u0006\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0019\u001A\u00020\u00022\u0006\u0010\u001A\u001A\u00020\u0004H\u0014¢\u0006\u0004\b\u001B\u0010\u001C¨\u0006\u001D"}, d2 = {"Lkotlinx/serialization/internal/IntArraySerializer;", "Lkotlinx/serialization/KSerializer;", "", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "", "Lkotlinx/serialization/internal/IntArrayBuilder;", "<init>", "()V", "collectionSize", "([I)I", "toBuilder", "([I)Lkotlinx/serialization/internal/IntArrayBuilder;", "empty", "()[I", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decoder", "index", "builder", "", "checkIndex", "Lie/H;", "readElement", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILkotlinx/serialization/internal/IntArrayBuilder;Z)V", "Lkotlinx/serialization/encoding/CompositeEncoder;", "encoder", "content", "size", "writeContent", "(Lkotlinx/serialization/encoding/CompositeEncoder;[II)V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class IntArraySerializer extends PrimitiveArraySerializer implements KSerializer {
    @NotNull
    public static final IntArraySerializer INSTANCE;

    static {
        IntArraySerializer.INSTANCE = new IntArraySerializer();
    }

    private IntArraySerializer() {
        super(BuiltinSerializersKt.serializer(o.a));
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public int collectionSize(Object object0) {
        return this.collectionSize(((int[])object0));
    }

    public int collectionSize(@NotNull int[] arr_v) {
        q.g(arr_v, "<this>");
        return arr_v.length;
    }

    @Override  // kotlinx.serialization.internal.PrimitiveArraySerializer
    public Object empty() {
        return this.empty();
    }

    @NotNull
    public int[] empty() {
        return new int[0];
    }

    @Override  // kotlinx.serialization.internal.CollectionLikeSerializer
    public void readElement(CompositeDecoder compositeDecoder0, int v, Object object0, boolean z) {
        this.readElement(compositeDecoder0, v, ((IntArrayBuilder)object0), z);
    }

    public void readElement(@NotNull CompositeDecoder compositeDecoder0, int v, @NotNull IntArrayBuilder intArrayBuilder0, boolean z) {
        q.g(compositeDecoder0, "decoder");
        q.g(intArrayBuilder0, "builder");
        intArrayBuilder0.append$kotlinx_serialization_core(compositeDecoder0.decodeIntElement(this.getDescriptor(), v));
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public Object toBuilder(Object object0) {
        return this.toBuilder(((int[])object0));
    }

    @NotNull
    public IntArrayBuilder toBuilder(@NotNull int[] arr_v) {
        q.g(arr_v, "<this>");
        return new IntArrayBuilder(arr_v);
    }

    @Override  // kotlinx.serialization.internal.PrimitiveArraySerializer
    public void writeContent(CompositeEncoder compositeEncoder0, Object object0, int v) {
        this.writeContent(compositeEncoder0, ((int[])object0), v);
    }

    public void writeContent(@NotNull CompositeEncoder compositeEncoder0, @NotNull int[] arr_v, int v) {
        q.g(compositeEncoder0, "encoder");
        q.g(arr_v, "content");
        for(int v1 = 0; v1 < v; ++v1) {
            compositeEncoder0.encodeIntElement(this.getDescriptor(), v1, arr_v[v1]);
        }
    }
}

