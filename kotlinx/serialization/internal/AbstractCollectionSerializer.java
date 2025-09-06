package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u00028\u00010\u0004B\t\b\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001F\u0010\u000B\u001A\u00020\n2\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00028\u0002H\u0002¢\u0006\u0004\b\u000B\u0010\fJ\u0013\u0010\r\u001A\u00020\n*\u00028\u0001H$¢\u0006\u0004\b\r\u0010\u000EJ\u0019\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00000\u000F*\u00028\u0001H$¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\t\u001A\u00028\u0002H$¢\u0006\u0004\b\t\u0010\u0012J\u0013\u0010\u0013\u001A\u00020\n*\u00028\u0002H$¢\u0006\u0004\b\u0013\u0010\u000EJ\u0013\u0010\u0014\u001A\u00028\u0001*\u00028\u0002H$¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001A\u00028\u0002*\u00028\u0001H$¢\u0006\u0004\b\u0016\u0010\u0015J\u001B\u0010\u0019\u001A\u00020\u0018*\u00028\u00022\u0006\u0010\u0017\u001A\u00020\nH$¢\u0006\u0004\b\u0019\u0010\u001AJ!\u0010\u001D\u001A\u00028\u00012\u0006\u0010\b\u001A\u00020\u001B2\b\u0010\u001C\u001A\u0004\u0018\u00018\u0001H\u0007¢\u0006\u0004\b\u001D\u0010\u001EJ\u0017\u0010\u001F\u001A\u00028\u00012\u0006\u0010\b\u001A\u00020\u001BH\u0016¢\u0006\u0004\b\u001F\u0010 J1\u0010$\u001A\u00020\u00182\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010!\u001A\u00020\n2\u0006\u0010\t\u001A\u00028\u00022\b\b\u0002\u0010#\u001A\u00020\"H$¢\u0006\u0004\b$\u0010%J/\u0010\'\u001A\u00020\u00182\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00028\u00022\u0006\u0010&\u001A\u00020\n2\u0006\u0010\u0017\u001A\u00020\nH$¢\u0006\u0004\b\'\u0010(\u0082\u0001\u0002)*¨\u0006+"}, d2 = {"Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "Element", "Collection", "Builder", "Lkotlinx/serialization/KSerializer;", "<init>", "()V", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decoder", "builder", "", "readSize", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/lang/Object;)I", "collectionSize", "(Ljava/lang/Object;)I", "", "collectionIterator", "(Ljava/lang/Object;)Ljava/util/Iterator;", "()Ljava/lang/Object;", "builderSize", "toResult", "(Ljava/lang/Object;)Ljava/lang/Object;", "toBuilder", "size", "Lie/H;", "checkCapacity", "(Ljava/lang/Object;I)V", "Lkotlinx/serialization/encoding/Decoder;", "previous", "merge", "(Lkotlinx/serialization/encoding/Decoder;Ljava/lang/Object;)Ljava/lang/Object;", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "index", "", "checkIndex", "readElement", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILjava/lang/Object;Z)V", "startIndex", "readAll", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/lang/Object;II)V", "Lkotlinx/serialization/internal/CollectionLikeSerializer;", "Lkotlinx/serialization/internal/MapLikeSerializer;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public abstract class AbstractCollectionSerializer implements KSerializer {
    private AbstractCollectionSerializer() {
    }

    public AbstractCollectionSerializer(DefaultConstructorMarker defaultConstructorMarker0) {
    }

    public abstract Object builder();

    public abstract int builderSize(Object arg1);

    public abstract void checkCapacity(Object arg1, int arg2);

    @NotNull
    public abstract Iterator collectionIterator(Object arg1);

    public abstract int collectionSize(Object arg1);

    @Override  // kotlinx.serialization.DeserializationStrategy
    public Object deserialize(@NotNull Decoder decoder0) {
        q.g(decoder0, "decoder");
        return this.merge(decoder0, null);
    }

    public final Object merge(@NotNull Decoder decoder0, @Nullable Object object0) {
        Object object1;
        q.g(decoder0, "decoder");
        if(object0 == null) {
            object1 = this.builder();
        }
        else {
            object1 = this.toBuilder(object0);
            if(object1 == null) {
                object1 = this.builder();
            }
        }
        int v = this.builderSize(object1);
        CompositeDecoder compositeDecoder0 = decoder0.beginStructure(this.getDescriptor());
        if(compositeDecoder0.decodeSequentially()) {
            this.readAll(compositeDecoder0, object1, v, this.readSize(compositeDecoder0, object1));
        }
        else {
            int v1;
            while((v1 = compositeDecoder0.decodeElementIndex(this.getDescriptor())) != -1) {
                AbstractCollectionSerializer.readElement$default(this, compositeDecoder0, v + v1, object1, false, 8, null);
            }
        }
        compositeDecoder0.endStructure(this.getDescriptor());
        return this.toResult(object1);
    }

    public abstract void readAll(@NotNull CompositeDecoder arg1, Object arg2, int arg3, int arg4);

    public abstract void readElement(@NotNull CompositeDecoder arg1, int arg2, Object arg3, boolean arg4);

    public static void readElement$default(AbstractCollectionSerializer abstractCollectionSerializer0, CompositeDecoder compositeDecoder0, int v, Object object0, boolean z, int v1, Object object1) {
        if(object1 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readElement");
        }
        if((v1 & 8) != 0) {
            z = true;
        }
        abstractCollectionSerializer0.readElement(compositeDecoder0, v, object0, z);
    }

    private final int readSize(CompositeDecoder compositeDecoder0, Object object0) {
        int v = compositeDecoder0.decodeCollectionSize(this.getDescriptor());
        this.checkCapacity(object0, v);
        return v;
    }

    public abstract Object toBuilder(Object arg1);

    public abstract Object toResult(Object arg1);
}

