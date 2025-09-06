package kotlinx.serialization.internal;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\b!\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000E\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u0003*\u0004\b\u0002\u0010\u00042\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u0005B\u0015\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\n\u001A\u00020\u000B*\u00028\u0001H\u0014¢\u0006\u0002\u0010\fJ\u0017\u0010\r\u001A\b\u0012\u0004\u0012\u00028\u00000\u000E*\u00028\u0001H\u0014¢\u0006\u0002\u0010\u000F¨\u0006\u0010"}, d2 = {"Lkotlinx/serialization/internal/CollectionSerializer;", "E", "C", "", "B", "Lkotlinx/serialization/internal/CollectionLikeSerializer;", "element", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "collectionSize", "", "(Ljava/util/Collection;)I", "collectionIterator", "", "(Ljava/util/Collection;)Ljava/util/Iterator;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public abstract class CollectionSerializer extends CollectionLikeSerializer {
    public CollectionSerializer(@NotNull KSerializer kSerializer0) {
        q.g(kSerializer0, "element");
        super(kSerializer0, null);
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public Iterator collectionIterator(Object object0) {
        return this.collectionIterator(((Collection)object0));
    }

    @NotNull
    public Iterator collectionIterator(@NotNull Collection collection0) {
        q.g(collection0, "<this>");
        return collection0.iterator();
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public int collectionSize(Object object0) {
        return this.collectionSize(((Collection)object0));
    }

    public int collectionSize(@NotNull Collection collection0) {
        q.g(collection0, "<this>");
        return collection0.size();
    }
}

