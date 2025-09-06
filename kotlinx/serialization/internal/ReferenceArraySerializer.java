package kotlinx.serialization.internal;

import De.d;
import java.util.ArrayList;
import java.util.Iterator;
import je.n;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\n\b\u0001\u0010\u0003*\u0004\u0018\u00018\u00002*\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u00070\u0004B#\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\b\u0012\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00010\n\u00A2\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000F\u001A\u00020\u000E*\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0014\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00010\u0011*\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0014\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u001F\u0010\u0014\u001A\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007H\u0014\u00A2\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001A\u00020\u000E*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007H\u0014\u00A2\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u0018\u001A\b\u0012\u0004\u0012\u00028\u00010\u0005*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007H\u0014\u00A2\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001A\u001A\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007*\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0014\u00A2\u0006\u0004\b\u001A\u0010\u001BJ+\u0010\u001E\u001A\u00020\u001D*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u00072\u0006\u0010\u001C\u001A\u00020\u000EH\u0014\u00A2\u0006\u0004\b\u001E\u0010\u001FJ3\u0010\"\u001A\u00020\u001D*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u00072\u0006\u0010 \u001A\u00020\u000E2\u0006\u0010!\u001A\u00028\u0001H\u0014\u00A2\u0006\u0004\b\"\u0010#R\u001A\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\b8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\t\u0010$R\u001A\u0010&\u001A\u00020%8\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b&\u0010\'\u001A\u0004\b(\u0010)\u00A8\u0006*"}, d2 = {"Lkotlinx/serialization/internal/ReferenceArraySerializer;", "", "ElementKlass", "Element", "Lkotlinx/serialization/internal/CollectionLikeSerializer;", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "LDe/d;", "kClass", "Lkotlinx/serialization/KSerializer;", "eSerializer", "<init>", "(LDe/d;Lkotlinx/serialization/KSerializer;)V", "", "collectionSize", "([Ljava/lang/Object;)I", "", "collectionIterator", "([Ljava/lang/Object;)Ljava/util/Iterator;", "builder", "()Ljava/util/ArrayList;", "builderSize", "(Ljava/util/ArrayList;)I", "toResult", "(Ljava/util/ArrayList;)[Ljava/lang/Object;", "toBuilder", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "size", "Lie/H;", "checkCapacity", "(Ljava/util/ArrayList;I)V", "index", "element", "insert", "(Ljava/util/ArrayList;ILjava/lang/Object;)V", "LDe/d;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class ReferenceArraySerializer extends CollectionLikeSerializer {
    @NotNull
    private final SerialDescriptor descriptor;
    @NotNull
    private final d kClass;

    public ReferenceArraySerializer(@NotNull d d0, @NotNull KSerializer kSerializer0) {
        q.g(d0, "kClass");
        q.g(kSerializer0, "eSerializer");
        super(kSerializer0, null);
        this.kClass = d0;
        this.descriptor = new ArrayClassDesc(kSerializer0.getDescriptor());
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public Object builder() {
        return this.builder();
    }

    @NotNull
    public ArrayList builder() {
        return new ArrayList();
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public int builderSize(Object object0) {
        return this.builderSize(((ArrayList)object0));
    }

    public int builderSize(@NotNull ArrayList arrayList0) {
        q.g(arrayList0, "<this>");
        return arrayList0.size();
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public void checkCapacity(Object object0, int v) {
        this.checkCapacity(((ArrayList)object0), v);
    }

    public void checkCapacity(@NotNull ArrayList arrayList0, int v) {
        q.g(arrayList0, "<this>");
        arrayList0.ensureCapacity(v);
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public Iterator collectionIterator(Object object0) {
        return this.collectionIterator(((Object[])object0));
    }

    @NotNull
    public Iterator collectionIterator(@NotNull Object[] arr_object) {
        q.g(arr_object, "<this>");
        return q.j(arr_object);
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public int collectionSize(Object object0) {
        return this.collectionSize(((Object[])object0));
    }

    public int collectionSize(@NotNull Object[] arr_object) {
        q.g(arr_object, "<this>");
        return arr_object.length;
    }

    @Override  // kotlinx.serialization.internal.CollectionLikeSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override  // kotlinx.serialization.internal.CollectionLikeSerializer
    public void insert(Object object0, int v, Object object1) {
        this.insert(((ArrayList)object0), v, object1);
    }

    public void insert(@NotNull ArrayList arrayList0, int v, Object object0) {
        q.g(arrayList0, "<this>");
        arrayList0.add(v, object0);
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public Object toBuilder(Object object0) {
        return this.toBuilder(((Object[])object0));
    }

    @NotNull
    public ArrayList toBuilder(@NotNull Object[] arr_object) {
        q.g(arr_object, "<this>");
        return new ArrayList(n.N(arr_object));
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public Object toResult(Object object0) {
        return this.toResult(((ArrayList)object0));
    }

    @NotNull
    public Object[] toResult(@NotNull ArrayList arrayList0) {
        q.g(arrayList0, "<this>");
        return PlatformKt.toNativeArrayImpl(arrayList0, this.kClass);
    }
}

