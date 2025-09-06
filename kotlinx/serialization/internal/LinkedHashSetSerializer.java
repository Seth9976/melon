package kotlinx.serialization.internal;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012*\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00050\u0002B\u0015\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\n\u001A\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014¢\u0006\u0004\b\n\u0010\u000BJ#\u0010\r\u001A\u00020\f*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014¢\u0006\u0004\b\r\u0010\u000EJ)\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014¢\u0006\u0004\b\u000F\u0010\u0010J)\u0010\u0011\u001A\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0015\u001A\u00020\u0014*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00052\u0006\u0010\u0013\u001A\u00020\fH\u0014¢\u0006\u0004\b\u0015\u0010\u0016J3\u0010\u0019\u001A\u00020\u0014*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00052\u0006\u0010\u0017\u001A\u00020\f2\u0006\u0010\u0018\u001A\u00028\u0000H\u0014¢\u0006\u0004\b\u0019\u0010\u001AR\u001A\u0010\u001C\u001A\u00020\u001B8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\u001F¨\u0006 "}, d2 = {"Lkotlinx/serialization/internal/LinkedHashSetSerializer;", "E", "Lkotlinx/serialization/internal/CollectionSerializer;", "", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "Lkotlinx/serialization/KSerializer;", "eSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "builder", "()Ljava/util/LinkedHashSet;", "", "builderSize", "(Ljava/util/LinkedHashSet;)I", "toResult", "(Ljava/util/LinkedHashSet;)Ljava/util/Set;", "toBuilder", "(Ljava/util/Set;)Ljava/util/LinkedHashSet;", "size", "Lie/H;", "checkCapacity", "(Ljava/util/LinkedHashSet;I)V", "index", "element", "insert", "(Ljava/util/LinkedHashSet;ILjava/lang/Object;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class LinkedHashSetSerializer extends CollectionSerializer {
    @NotNull
    private final SerialDescriptor descriptor;

    public LinkedHashSetSerializer(@NotNull KSerializer kSerializer0) {
        q.g(kSerializer0, "eSerializer");
        super(kSerializer0);
        this.descriptor = new LinkedHashSetClassDesc(kSerializer0.getDescriptor());
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public Object builder() {
        return this.builder();
    }

    @NotNull
    public LinkedHashSet builder() {
        return new LinkedHashSet();
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public int builderSize(Object object0) {
        return this.builderSize(((LinkedHashSet)object0));
    }

    public int builderSize(@NotNull LinkedHashSet linkedHashSet0) {
        q.g(linkedHashSet0, "<this>");
        return linkedHashSet0.size();
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public void checkCapacity(Object object0, int v) {
        this.checkCapacity(((LinkedHashSet)object0), v);
    }

    public void checkCapacity(@NotNull LinkedHashSet linkedHashSet0, int v) {
        q.g(linkedHashSet0, "<this>");
    }

    @Override  // kotlinx.serialization.internal.CollectionLikeSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override  // kotlinx.serialization.internal.CollectionLikeSerializer
    public void insert(Object object0, int v, Object object1) {
        this.insert(((LinkedHashSet)object0), v, object1);
    }

    public void insert(@NotNull LinkedHashSet linkedHashSet0, int v, Object object0) {
        q.g(linkedHashSet0, "<this>");
        linkedHashSet0.add(object0);
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public Object toBuilder(Object object0) {
        return this.toBuilder(((Set)object0));
    }

    @NotNull
    public LinkedHashSet toBuilder(@NotNull Set set0) {
        q.g(set0, "<this>");
        LinkedHashSet linkedHashSet0 = set0 instanceof LinkedHashSet ? ((LinkedHashSet)set0) : null;
        return linkedHashSet0 == null ? new LinkedHashSet(set0) : linkedHashSet0;
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public Object toResult(Object object0) {
        return this.toResult(((LinkedHashSet)object0));
    }

    @NotNull
    public Set toResult(@NotNull LinkedHashSet linkedHashSet0) {
        q.g(linkedHashSet0, "<this>");
        return linkedHashSet0;
    }
}

