package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder.DefaultImpls;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004B\u0017\b\u0004\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001A\u00020\f*\u00028\u00022\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00028\u0000H$¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0012\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00028\u0001H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u0019\u001A\u00020\f2\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0016\u001A\u00028\u00022\u0006\u0010\u0017\u001A\u00020\t2\u0006\u0010\u0018\u001A\u00020\tH\u0004¢\u0006\u0004\b\u0019\u0010\u001AJ/\u0010\u001D\u001A\u00020\f2\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u0016\u001A\u00028\u00022\u0006\u0010\u001C\u001A\u00020\u001BH\u0014¢\u0006\u0004\b\u001D\u0010\u001ER\u001A\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001FR\u0014\u0010#\u001A\u00020 8&X¦\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\"\u0082\u0001\u0003$%&¨\u0006\'"}, d2 = {"Lkotlinx/serialization/internal/CollectionLikeSerializer;", "Element", "Collection", "Builder", "Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "Lkotlinx/serialization/KSerializer;", "elementSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "", "index", "element", "Lie/H;", "insert", "(Ljava/lang/Object;ILjava/lang/Object;)V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decoder", "builder", "startIndex", "size", "readAll", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/lang/Object;II)V", "", "checkIndex", "readElement", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILjava/lang/Object;Z)V", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/internal/CollectionSerializer;", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Lkotlinx/serialization/internal/ReferenceArraySerializer;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public abstract class CollectionLikeSerializer extends AbstractCollectionSerializer {
    @NotNull
    private final KSerializer elementSerializer;

    private CollectionLikeSerializer(KSerializer kSerializer0) {
        super(null);
        this.elementSerializer = kSerializer0;
    }

    public CollectionLikeSerializer(KSerializer kSerializer0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(kSerializer0);
    }

    @Override  // kotlinx.serialization.KSerializer
    @NotNull
    public abstract SerialDescriptor getDescriptor();

    public abstract void insert(Object arg1, int arg2, Object arg3);

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readAll(@NotNull CompositeDecoder compositeDecoder0, Object object0, int v, int v1) {
        q.g(compositeDecoder0, "decoder");
        if(v1 < 0) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL");
        }
        for(int v2 = 0; v2 < v1; ++v2) {
            this.readElement(compositeDecoder0, v + v2, object0, false);
        }
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public void readElement(@NotNull CompositeDecoder compositeDecoder0, int v, Object object0, boolean z) {
        q.g(compositeDecoder0, "decoder");
        this.insert(object0, v, DefaultImpls.decodeSerializableElement$default(compositeDecoder0, this.getDescriptor(), v, this.elementSerializer, null, 8, null));
    }

    @Override  // kotlinx.serialization.SerializationStrategy
    public void serialize(@NotNull Encoder encoder0, Object object0) {
        q.g(encoder0, "encoder");
        int v = this.collectionSize(object0);
        SerialDescriptor serialDescriptor0 = this.getDescriptor();
        CompositeEncoder compositeEncoder0 = encoder0.beginCollection(serialDescriptor0, v);
        Iterator iterator0 = this.collectionIterator(object0);
        for(int v1 = 0; v1 < v; ++v1) {
            SerialDescriptor serialDescriptor1 = this.getDescriptor();
            Object object1 = iterator0.next();
            compositeEncoder0.encodeSerializableElement(serialDescriptor1, v1, this.elementSerializer, object1);
        }
        compositeEncoder0.endStructure(serialDescriptor0);
    }
}

