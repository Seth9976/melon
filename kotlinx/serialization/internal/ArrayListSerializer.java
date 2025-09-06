package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012*\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00050\u0002B\u0015\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\n\u001A\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014¢\u0006\u0004\b\n\u0010\u000BJ#\u0010\r\u001A\u00020\f*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014¢\u0006\u0004\b\r\u0010\u000EJ)\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014¢\u0006\u0004\b\u000F\u0010\u0010J)\u0010\u0011\u001A\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0015\u001A\u00020\u0014*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00052\u0006\u0010\u0013\u001A\u00020\fH\u0014¢\u0006\u0004\b\u0015\u0010\u0016J3\u0010\u0018\u001A\u00020\u0014*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00052\u0006\u0010\u0017\u001A\u00020\f2\u0006\u0010\u0007\u001A\u00028\u0000H\u0014¢\u0006\u0004\b\u0018\u0010\u0019R\u001A\u0010\u001B\u001A\u00020\u001A8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u001D\u0010\u001E¨\u0006\u001F"}, d2 = {"Lkotlinx/serialization/internal/ArrayListSerializer;", "E", "Lkotlinx/serialization/internal/CollectionSerializer;", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlinx/serialization/KSerializer;", "element", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "builder", "()Ljava/util/ArrayList;", "", "builderSize", "(Ljava/util/ArrayList;)I", "toResult", "(Ljava/util/ArrayList;)Ljava/util/List;", "toBuilder", "(Ljava/util/List;)Ljava/util/ArrayList;", "size", "Lie/H;", "checkCapacity", "(Ljava/util/ArrayList;I)V", "index", "insert", "(Ljava/util/ArrayList;ILjava/lang/Object;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class ArrayListSerializer extends CollectionSerializer {
    @NotNull
    private final SerialDescriptor descriptor;

    public ArrayListSerializer(@NotNull KSerializer kSerializer0) {
        q.g(kSerializer0, "element");
        super(kSerializer0);
        this.descriptor = new ArrayListClassDesc(kSerializer0.getDescriptor());
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
        return this.toBuilder(((List)object0));
    }

    @NotNull
    public ArrayList toBuilder(@NotNull List list0) {
        q.g(list0, "<this>");
        ArrayList arrayList0 = list0 instanceof ArrayList ? ((ArrayList)list0) : null;
        return arrayList0 == null ? new ArrayList(list0) : arrayList0;
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public Object toResult(Object object0) {
        return this.toResult(((ArrayList)object0));
    }

    @NotNull
    public List toResult(@NotNull ArrayList arrayList0) {
        q.g(arrayList0, "<this>");
        return arrayList0;
    }
}

