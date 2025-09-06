package kotlinx.serialization.internal;

import ie.H;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.StructureKind.MAP;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xe.a;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022 \u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003:\u0001\u0015B#\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ)\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u000E\u001A\u00028\u00002\u0006\u0010\u0011\u001A\u00028\u0001H\u0014¢\u0006\u0002\u0010\u0014R\u0014\u0010\n\u001A\u00020\u000BX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR$\u0010\u000E\u001A\u00028\u0000*\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R$\u0010\u0011\u001A\u00028\u0001*\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0010¨\u0006\u0016"}, d2 = {"Lkotlinx/serialization/internal/MapEntrySerializer;", "K", "V", "Lkotlinx/serialization/internal/KeyValueSerializer;", "", "keySerializer", "Lkotlinx/serialization/KSerializer;", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "key", "getKey", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "value", "getValue", "toResult", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map$Entry;", "MapEntry", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class MapEntrySerializer extends KeyValueSerializer {
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0082\b\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000E\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003B\u0017\u0012\u0006\u0010\u0004\u001A\u00028\u0002\u0012\u0006\u0010\u0005\u001A\u00028\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001A\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001A\u00020\u000BHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001A\u0010\u0011\u001A\u00020\u00102\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001A\u0010\u0004\u001A\u00028\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015R\u001A\u0010\u0005\u001A\u00028\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001A\u0004\b\u0016\u0010\u0015¨\u0006\u0017"}, d2 = {"Lkotlinx/serialization/internal/MapEntrySerializer$MapEntry;", "K", "V", "", "key", "value", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "getValue", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
    static final class MapEntry implements Map.Entry, a {
        private final Object key;
        private final Object value;

        public MapEntry(Object object0, Object object1) {
            this.key = object0;
            this.value = object1;
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof MapEntry)) {
                return false;
            }
            return q.b(this.key, ((MapEntry)object0).key) ? q.b(this.value, ((MapEntry)object0).value) : false;
        }

        @Override
        public Object getKey() {
            return this.key;
        }

        @Override
        public Object getValue() {
            return this.value;
        }

        @Override
        public int hashCode() {
            int v = 0;
            int v1 = this.key == null ? 0 : this.key.hashCode();
            Object object0 = this.value;
            if(object0 != null) {
                v = object0.hashCode();
            }
            return v1 * 0x1F + v;
        }

        @Override
        public Object setValue(Object object0) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override
        @NotNull
        public String toString() {
            return "MapEntry(key=" + this.key + ", value=" + this.value + ')';
        }
    }

    @NotNull
    private final SerialDescriptor descriptor;

    public MapEntrySerializer(@NotNull KSerializer kSerializer0, @NotNull KSerializer kSerializer1) {
        q.g(kSerializer0, "keySerializer");
        q.g(kSerializer1, "valueSerializer");
        super(kSerializer0, kSerializer1, null);
        dg.a a0 = new dg.a(kSerializer0, kSerializer1, 0);
        this.descriptor = SerialDescriptorsKt.buildSerialDescriptor("kotlin.collections.Map.Entry", MAP.INSTANCE, new SerialDescriptor[0], a0);
    }

    public static H a(KSerializer kSerializer0, KSerializer kSerializer1, ClassSerialDescriptorBuilder classSerialDescriptorBuilder0) {
        return MapEntrySerializer.descriptor$lambda$0(kSerializer0, kSerializer1, classSerialDescriptorBuilder0);
    }

    private static final H descriptor$lambda$0(KSerializer kSerializer0, KSerializer kSerializer1, ClassSerialDescriptorBuilder classSerialDescriptorBuilder0) {
        q.g(classSerialDescriptorBuilder0, "$this$buildSerialDescriptor");
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder0, "key", kSerializer0.getDescriptor(), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder0, "value", kSerializer1.getDescriptor(), null, false, 12, null);
        return H.a;
    }

    @Override  // kotlinx.serialization.KSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override  // kotlinx.serialization.internal.KeyValueSerializer
    public Object getKey(Object object0) {
        return this.getKey(((Map.Entry)object0));
    }

    public Object getKey(@NotNull Map.Entry map$Entry0) {
        q.g(map$Entry0, "<this>");
        return map$Entry0.getKey();
    }

    @Override  // kotlinx.serialization.internal.KeyValueSerializer
    public Object getValue(Object object0) {
        return this.getValue(((Map.Entry)object0));
    }

    public Object getValue(@NotNull Map.Entry map$Entry0) {
        q.g(map$Entry0, "<this>");
        return map$Entry0.getValue();
    }

    @Override  // kotlinx.serialization.internal.KeyValueSerializer
    public Object toResult(Object object0, Object object1) {
        return this.toResult(object0, object1);
    }

    @NotNull
    public Map.Entry toResult(Object object0, Object object1) {
        return new MapEntry(object0, object1);
    }
}

