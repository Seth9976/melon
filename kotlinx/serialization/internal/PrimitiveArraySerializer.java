package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b!\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u000E\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00010\u00032\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005B\u0017\b\u0000\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u000B\u001A\u00020\n*\u00028\u0002H\u0004¢\u0006\u0004\b\u000B\u0010\fJ\u0013\u0010\r\u001A\u00028\u0001*\u00028\u0002H\u0004¢\u0006\u0004\b\r\u0010\u000EJ\u001B\u0010\u0011\u001A\u00020\u0010*\u00028\u00022\u0006\u0010\u000F\u001A\u00020\nH\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001A\b\u0012\u0004\u0012\u00028\u00000\u0013*\u00028\u0001H\u0004¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0018\u001A\u00020\u0010*\u00028\u00022\u0006\u0010\u0016\u001A\u00020\n2\u0006\u0010\u0017\u001A\u00028\u0000H\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00028\u0002H\u0004¢\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001C\u001A\u00028\u0001H$¢\u0006\u0004\b\u001C\u0010\u001DJ\'\u0010!\u001A\u00020\u00102\u0006\u0010\u001F\u001A\u00020\u001E2\u0006\u0010 \u001A\u00028\u00012\u0006\u0010\u000F\u001A\u00020\nH$¢\u0006\u0004\b!\u0010\"J\u001D\u0010%\u001A\u00020\u00102\u0006\u0010\u001F\u001A\u00020#2\u0006\u0010$\u001A\u00028\u0001¢\u0006\u0004\b%\u0010&J\u0015\u0010)\u001A\u00028\u00012\u0006\u0010(\u001A\u00020\'¢\u0006\u0004\b)\u0010*R\u0017\u0010,\u001A\u00020+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001A\u0004\b.\u0010/¨\u00060"}, d2 = {"Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Element", "Array", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "Builder", "Lkotlinx/serialization/internal/CollectionLikeSerializer;", "Lkotlinx/serialization/KSerializer;", "primitiveSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "", "builderSize", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;)I", "toResult", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;)Ljava/lang/Object;", "size", "Lie/H;", "checkCapacity", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;I)V", "", "collectionIterator", "(Ljava/lang/Object;)Ljava/util/Iterator;", "index", "element", "insert", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;ILjava/lang/Object;)V", "builder", "()Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "empty", "()Ljava/lang/Object;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "encoder", "content", "writeContent", "(Lkotlinx/serialization/encoding/CompositeEncoder;Ljava/lang/Object;I)V", "Lkotlinx/serialization/encoding/Encoder;", "value", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public abstract class PrimitiveArraySerializer extends CollectionLikeSerializer {
    @NotNull
    private final SerialDescriptor descriptor;

    public PrimitiveArraySerializer(@NotNull KSerializer kSerializer0) {
        q.g(kSerializer0, "primitiveSerializer");
        super(kSerializer0, null);
        this.descriptor = new PrimitiveArrayDescriptor(kSerializer0.getDescriptor());
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public Object builder() {
        return this.builder();
    }

    @NotNull
    public final PrimitiveArrayBuilder builder() {
        return (PrimitiveArrayBuilder)this.toBuilder(this.empty());
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public int builderSize(Object object0) {
        return this.builderSize(((PrimitiveArrayBuilder)object0));
    }

    public final int builderSize(@NotNull PrimitiveArrayBuilder primitiveArrayBuilder0) {
        q.g(primitiveArrayBuilder0, "<this>");
        return primitiveArrayBuilder0.getPosition$kotlinx_serialization_core();
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public void checkCapacity(Object object0, int v) {
        this.checkCapacity(((PrimitiveArrayBuilder)object0), v);
    }

    public final void checkCapacity(@NotNull PrimitiveArrayBuilder primitiveArrayBuilder0, int v) {
        q.g(primitiveArrayBuilder0, "<this>");
        primitiveArrayBuilder0.ensureCapacity$kotlinx_serialization_core(v);
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    @NotNull
    public final Iterator collectionIterator(Object object0) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead");
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object deserialize(@NotNull Decoder decoder0) {
        q.g(decoder0, "decoder");
        return this.merge(decoder0, null);
    }

    public abstract Object empty();

    @Override  // kotlinx.serialization.internal.CollectionLikeSerializer
    @NotNull
    public final SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override  // kotlinx.serialization.internal.CollectionLikeSerializer
    public void insert(Object object0, int v, Object object1) {
        this.insert(((PrimitiveArrayBuilder)object0), v, object1);
    }

    public final void insert(@NotNull PrimitiveArrayBuilder primitiveArrayBuilder0, int v, Object object0) {
        q.g(primitiveArrayBuilder0, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead");
    }

    @Override  // kotlinx.serialization.internal.CollectionLikeSerializer
    public final void serialize(@NotNull Encoder encoder0, Object object0) {
        q.g(encoder0, "encoder");
        int v = this.collectionSize(object0);
        CompositeEncoder compositeEncoder0 = encoder0.beginCollection(this.descriptor, v);
        this.writeContent(compositeEncoder0, object0, v);
        compositeEncoder0.endStructure(this.descriptor);
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public Object toResult(Object object0) {
        return this.toResult(((PrimitiveArrayBuilder)object0));
    }

    public final Object toResult(@NotNull PrimitiveArrayBuilder primitiveArrayBuilder0) {
        q.g(primitiveArrayBuilder0, "<this>");
        return primitiveArrayBuilder0.build$kotlinx_serialization_core();
    }

    public abstract void writeContent(@NotNull CompositeEncoder arg1, Object arg2, int arg3);
}

