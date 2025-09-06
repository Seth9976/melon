package kotlinx.serialization.internal;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\u0010&\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022B\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012 \u0012\u001E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00060\u0003B#\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00010\u0007\u00A2\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\r\u001A\u00020\f*\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0014\u00A2\u0006\u0004\b\r\u0010\u000EJ1\u0010\u0011\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00100\u000F*\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0014\u00A2\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0013\u001A\u001E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0006H\u0014\u00A2\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0015\u001A\u00020\f*\u001E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0006H\u0014\u00A2\u0006\u0004\b\u0015\u0010\u0016J;\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004*\u001E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0006H\u0014\u00A2\u0006\u0004\b\u0017\u0010\u0018J;\u0010\u0019\u001A\u001E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0006*\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0014\u00A2\u0006\u0004\b\u0019\u0010\u001AJ7\u0010\u001D\u001A\u00020\u001C*\u001E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00062\u0006\u0010\u001B\u001A\u00020\fH\u0014\u00A2\u0006\u0004\b\u001D\u0010\u001ER\u001A\u0010 \u001A\u00020\u001F8\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b \u0010!\u001A\u0004\b\"\u0010#\u00A8\u0006$"}, d2 = {"Lkotlinx/serialization/internal/LinkedHashMapSerializer;", "K", "V", "Lkotlinx/serialization/internal/MapLikeSerializer;", "", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "Lkotlinx/serialization/KSerializer;", "kSerializer", "vSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "", "collectionSize", "(Ljava/util/Map;)I", "", "", "collectionIterator", "(Ljava/util/Map;)Ljava/util/Iterator;", "builder", "()Ljava/util/LinkedHashMap;", "builderSize", "(Ljava/util/LinkedHashMap;)I", "toResult", "(Ljava/util/LinkedHashMap;)Ljava/util/Map;", "toBuilder", "(Ljava/util/Map;)Ljava/util/LinkedHashMap;", "size", "Lie/H;", "checkCapacity", "(Ljava/util/LinkedHashMap;I)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class LinkedHashMapSerializer extends MapLikeSerializer {
    @NotNull
    private final SerialDescriptor descriptor;

    public LinkedHashMapSerializer(@NotNull KSerializer kSerializer0, @NotNull KSerializer kSerializer1) {
        q.g(kSerializer0, "kSerializer");
        q.g(kSerializer1, "vSerializer");
        super(kSerializer0, kSerializer1, null);
        this.descriptor = new LinkedHashMapClassDesc(kSerializer0.getDescriptor(), kSerializer1.getDescriptor());
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public Object builder() {
        return this.builder();
    }

    @NotNull
    public LinkedHashMap builder() {
        return new LinkedHashMap();
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public int builderSize(Object object0) {
        return this.builderSize(((LinkedHashMap)object0));
    }

    public int builderSize(@NotNull LinkedHashMap linkedHashMap0) {
        q.g(linkedHashMap0, "<this>");
        return linkedHashMap0.size() * 2;
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public void checkCapacity(Object object0, int v) {
        this.checkCapacity(((LinkedHashMap)object0), v);
    }

    public void checkCapacity(@NotNull LinkedHashMap linkedHashMap0, int v) {
        q.g(linkedHashMap0, "<this>");
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public Iterator collectionIterator(Object object0) {
        return this.collectionIterator(((Map)object0));
    }

    @NotNull
    public Iterator collectionIterator(@NotNull Map map0) {
        q.g(map0, "<this>");
        return map0.entrySet().iterator();
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public int collectionSize(Object object0) {
        return this.collectionSize(((Map)object0));
    }

    public int collectionSize(@NotNull Map map0) {
        q.g(map0, "<this>");
        return map0.size();
    }

    @Override  // kotlinx.serialization.internal.MapLikeSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public Object toBuilder(Object object0) {
        return this.toBuilder(((Map)object0));
    }

    @NotNull
    public LinkedHashMap toBuilder(@NotNull Map map0) {
        q.g(map0, "<this>");
        LinkedHashMap linkedHashMap0 = map0 instanceof LinkedHashMap ? ((LinkedHashMap)map0) : null;
        return linkedHashMap0 == null ? new LinkedHashMap(map0) : linkedHashMap0;
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public Object toResult(Object object0) {
        return this.toResult(((LinkedHashMap)object0));
    }

    @NotNull
    public Map toResult(@NotNull LinkedHashMap linkedHashMap0) {
        q.g(linkedHashMap0, "<this>");
        return linkedHashMap0;
    }
}

