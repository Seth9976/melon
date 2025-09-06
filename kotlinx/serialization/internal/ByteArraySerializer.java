package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001A\u00020\b*\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000B\u001A\u00020\u0005*\u00020\u0002H\u0014¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\r\u001A\u00020\u0002H\u0014¢\u0006\u0004\b\r\u0010\u000EJ/\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\b2\u0006\u0010\u0012\u001A\u00020\u00052\u0006\u0010\u0014\u001A\u00020\u0013H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\'\u0010\u001C\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001A\u001A\u00020\u00022\u0006\u0010\u001B\u001A\u00020\bH\u0014¢\u0006\u0004\b\u001C\u0010\u001D¨\u0006\u001E"}, d2 = {"Lkotlinx/serialization/internal/ByteArraySerializer;", "Lkotlinx/serialization/KSerializer;", "", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "", "Lkotlinx/serialization/internal/ByteArrayBuilder;", "<init>", "()V", "", "collectionSize", "([B)I", "toBuilder", "([B)Lkotlinx/serialization/internal/ByteArrayBuilder;", "empty", "()[B", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decoder", "index", "builder", "", "checkIndex", "Lie/H;", "readElement", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILkotlinx/serialization/internal/ByteArrayBuilder;Z)V", "Lkotlinx/serialization/encoding/CompositeEncoder;", "encoder", "content", "size", "writeContent", "(Lkotlinx/serialization/encoding/CompositeEncoder;[BI)V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class ByteArraySerializer extends PrimitiveArraySerializer implements KSerializer {
    @NotNull
    public static final ByteArraySerializer INSTANCE;

    static {
        ByteArraySerializer.INSTANCE = new ByteArraySerializer();
    }

    private ByteArraySerializer() {
        super(BuiltinSerializersKt.serializer(c.a));
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public int collectionSize(Object object0) {
        return this.collectionSize(((byte[])object0));
    }

    public int collectionSize(@NotNull byte[] arr_b) {
        q.g(arr_b, "<this>");
        return arr_b.length;
    }

    // 去混淆评级： 低(20)
    @Override  // kotlinx.serialization.internal.PrimitiveArraySerializer
    public Object empty() {
        return new byte[0];
    }

    @NotNull
    public byte[] empty() [...] // 潜在的解密器

    @Override  // kotlinx.serialization.internal.CollectionLikeSerializer
    public void readElement(CompositeDecoder compositeDecoder0, int v, Object object0, boolean z) {
        this.readElement(compositeDecoder0, v, ((ByteArrayBuilder)object0), z);
    }

    public void readElement(@NotNull CompositeDecoder compositeDecoder0, int v, @NotNull ByteArrayBuilder byteArrayBuilder0, boolean z) {
        q.g(compositeDecoder0, "decoder");
        q.g(byteArrayBuilder0, "builder");
        byteArrayBuilder0.append$kotlinx_serialization_core(compositeDecoder0.decodeByteElement(this.getDescriptor(), v));
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public Object toBuilder(Object object0) {
        return this.toBuilder(((byte[])object0));
    }

    @NotNull
    public ByteArrayBuilder toBuilder(@NotNull byte[] arr_b) {
        q.g(arr_b, "<this>");
        return new ByteArrayBuilder(arr_b);
    }

    @Override  // kotlinx.serialization.internal.PrimitiveArraySerializer
    public void writeContent(CompositeEncoder compositeEncoder0, Object object0, int v) {
        this.writeContent(compositeEncoder0, ((byte[])object0), v);
    }

    public void writeContent(@NotNull CompositeEncoder compositeEncoder0, @NotNull byte[] arr_b, int v) {
        q.g(compositeEncoder0, "encoder");
        q.g(arr_b, "content");
        for(int v1 = 0; v1 < v; ++v1) {
            compositeEncoder0.encodeByteElement(this.getDescriptor(), v1, arr_b[v1]);
        }
    }
}

