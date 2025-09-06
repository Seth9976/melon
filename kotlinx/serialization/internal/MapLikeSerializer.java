package kotlinx.serialization.internal;

import Ce.e;
import P4.a;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Map;
import je.C;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder.DefaultImpls;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0014\b\u0003\u0010\u0005*\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042 \u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006B%\b\u0004\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\b\u0012\f\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0004\b\u000B\u0010\fJ/\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00028\u00032\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u0010H\u0004¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u0019\u001A\u00020\u00132\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0016\u001A\u00020\u00102\u0006\u0010\u000F\u001A\u00028\u00032\u0006\u0010\u0018\u001A\u00020\u0017H\u0004¢\u0006\u0004\b\u0019\u0010\u001AJ\u001F\u0010\u001E\u001A\u00020\u00132\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001D\u001A\u00028\u0002H\u0016¢\u0006\u0004\b\u001E\u0010\u001FR\u001D\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\b8\u0006¢\u0006\f\n\u0004\b\t\u0010 \u001A\u0004\b!\u0010\"R\u001D\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00010\b8\u0006¢\u0006\f\n\u0004\b\n\u0010 \u001A\u0004\b#\u0010\"R\u0014\u0010\'\u001A\u00020$8&X¦\u0004¢\u0006\u0006\u001A\u0004\b%\u0010&\u0082\u0001\u0001(¨\u0006)"}, d2 = {"Lkotlinx/serialization/internal/MapLikeSerializer;", "Key", "Value", "Collection", "", "Builder", "Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "", "Lkotlinx/serialization/KSerializer;", "keySerializer", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decoder", "builder", "", "startIndex", "size", "Lie/H;", "readAll", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/util/Map;II)V", "index", "", "checkIndex", "readElement", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILjava/util/Map;Z)V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lkotlinx/serialization/KSerializer;", "getKeySerializer", "()Lkotlinx/serialization/KSerializer;", "getValueSerializer", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/internal/LinkedHashMapSerializer;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public abstract class MapLikeSerializer extends AbstractCollectionSerializer {
    @NotNull
    private final KSerializer keySerializer;
    @NotNull
    private final KSerializer valueSerializer;

    private MapLikeSerializer(KSerializer kSerializer0, KSerializer kSerializer1) {
        super(null);
        this.keySerializer = kSerializer0;
        this.valueSerializer = kSerializer1;
    }

    public MapLikeSerializer(KSerializer kSerializer0, KSerializer kSerializer1, DefaultConstructorMarker defaultConstructorMarker0) {
        this(kSerializer0, kSerializer1);
    }

    @Override  // kotlinx.serialization.KSerializer
    @NotNull
    public abstract SerialDescriptor getDescriptor();

    @NotNull
    public final KSerializer getKeySerializer() {
        return this.keySerializer;
    }

    @NotNull
    public final KSerializer getValueSerializer() {
        return this.valueSerializer;
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public void readAll(CompositeDecoder compositeDecoder0, Object object0, int v, int v1) {
        this.readAll(compositeDecoder0, ((Map)object0), v, v1);
    }

    public final void readAll(@NotNull CompositeDecoder compositeDecoder0, @NotNull Map map0, int v, int v1) {
        q.g(compositeDecoder0, "decoder");
        q.g(map0, "builder");
        if(v1 < 0) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL");
        }
        e e0 = a.C(a.K(0, v1 * 2), 2);
        int v2 = e0.a;
        int v3 = e0.b;
        int v4 = e0.c;
        if(v4 > 0 && v2 <= v3 || v4 < 0 && v3 <= v2) {
            while(true) {
                this.readElement(compositeDecoder0, v + v2, map0, false);
                if(v2 == v3) {
                    break;
                }
                v2 += v4;
            }
        }
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public void readElement(CompositeDecoder compositeDecoder0, int v, Object object0, boolean z) {
        this.readElement(compositeDecoder0, v, ((Map)object0), z);
    }

    public final void readElement(@NotNull CompositeDecoder compositeDecoder0, int v, @NotNull Map map0, boolean z) {
        Object object2;
        int v1;
        q.g(compositeDecoder0, "decoder");
        q.g(map0, "builder");
        Object object0 = DefaultImpls.decodeSerializableElement$default(compositeDecoder0, this.getDescriptor(), v, this.keySerializer, null, 8, null);
        if(z) {
            v1 = compositeDecoder0.decodeElementIndex(this.getDescriptor());
            if(v1 != v + 1) {
                throw new IllegalArgumentException(("Value must follow key in a map, index for key: " + v + ", returned index for value: " + v1).toString());
            }
        }
        else {
            v1 = v + 1;
        }
        if(!map0.containsKey(object0) || this.valueSerializer.getDescriptor().getKind() instanceof PrimitiveKind) {
            object2 = DefaultImpls.decodeSerializableElement$default(compositeDecoder0, this.getDescriptor(), v1, this.valueSerializer, null, 8, null);
        }
        else {
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            Object object1 = C.Q(object0, map0);
            object2 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, v1, this.valueSerializer, object1);
        }
        map0.put(object0, object2);
    }

    @Override  // kotlinx.serialization.SerializationStrategy
    public void serialize(@NotNull Encoder encoder0, Object object0) {
        q.g(encoder0, "encoder");
        int v = this.collectionSize(object0);
        SerialDescriptor serialDescriptor0 = this.getDescriptor();
        CompositeEncoder compositeEncoder0 = encoder0.beginCollection(serialDescriptor0, v);
        int v1 = 0;
        Iterator iterator0 = this.collectionIterator(object0);
        while(iterator0.hasNext()) {
            Object object1 = iterator0.next();
            Object object2 = ((Map.Entry)object1).getKey();
            Object object3 = ((Map.Entry)object1).getValue();
            int v2 = v1 + 1;
            compositeEncoder0.encodeSerializableElement(this.getDescriptor(), v1, this.getKeySerializer(), object2);
            v1 += 2;
            compositeEncoder0.encodeSerializableElement(this.getDescriptor(), v2, this.getValueSerializer(), object3);
        }
        compositeEncoder0.endStructure(serialDescriptor0);
    }
}

