package kotlinx.serialization.internal;

import ie.u;
import ie.v;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u000B\u001A\u00020\b*\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000E\u001A\u00020\u0005*\u00020\u0002H\u0014¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u0011\u001A\u00020\u0002H\u0014¢\u0006\u0004\b\u000F\u0010\u0010J/\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u0017\u001A\u00020\u0016H\u0014¢\u0006\u0004\b\u0019\u0010\u001AJ\'\u0010!\u001A\u00020\u00182\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001D\u001A\u00020\u00022\u0006\u0010\u001E\u001A\u00020\bH\u0014¢\u0006\u0004\b\u001F\u0010 ¨\u0006\""}, d2 = {"Lkotlinx/serialization/internal/UByteArraySerializer;", "Lkotlinx/serialization/KSerializer;", "Lie/v;", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Lie/u;", "Lkotlinx/serialization/internal/UByteArrayBuilder;", "<init>", "()V", "", "collectionSize-GBYM_sE", "([B)I", "collectionSize", "toBuilder-GBYM_sE", "([B)Lkotlinx/serialization/internal/UByteArrayBuilder;", "toBuilder", "empty-TcUX1vc", "()[B", "empty", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decoder", "index", "builder", "", "checkIndex", "Lie/H;", "readElement", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILkotlinx/serialization/internal/UByteArrayBuilder;Z)V", "Lkotlinx/serialization/encoding/CompositeEncoder;", "encoder", "content", "size", "writeContent-Coi6ktg", "(Lkotlinx/serialization/encoding/CompositeEncoder;[BI)V", "writeContent", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class UByteArraySerializer extends PrimitiveArraySerializer implements KSerializer {
    @NotNull
    public static final UByteArraySerializer INSTANCE;

    static {
        UByteArraySerializer.INSTANCE = new UByteArraySerializer();
    }

    private UByteArraySerializer() {
        super(BuiltinSerializersKt.serializer(u.b));
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public int collectionSize(Object object0) {
        return this.collectionSize-GBYM_sE(((v)object0).a);
    }

    public int collectionSize-GBYM_sE(@NotNull byte[] arr_b) {
        q.g(arr_b, "$this$collectionSize");
        return arr_b.length;
    }

    // 去混淆评级： 低(20)
    @Override  // kotlinx.serialization.internal.PrimitiveArraySerializer
    public Object empty() {
        return new v(new byte[0]);
    }

    @NotNull
    public byte[] empty-TcUX1vc() [...] // 潜在的解密器

    @Override  // kotlinx.serialization.internal.CollectionLikeSerializer
    public void readElement(CompositeDecoder compositeDecoder0, int v, Object object0, boolean z) {
        this.readElement(compositeDecoder0, v, ((UByteArrayBuilder)object0), z);
    }

    public void readElement(@NotNull CompositeDecoder compositeDecoder0, int v, @NotNull UByteArrayBuilder uByteArrayBuilder0, boolean z) {
        q.g(compositeDecoder0, "decoder");
        q.g(uByteArrayBuilder0, "builder");
        uByteArrayBuilder0.append-7apg3OU$kotlinx_serialization_core(compositeDecoder0.decodeInlineElement(this.getDescriptor(), v).decodeByte());
    }

    @Override  // kotlinx.serialization.internal.AbstractCollectionSerializer
    public Object toBuilder(Object object0) {
        return this.toBuilder-GBYM_sE(((v)object0).a);
    }

    @NotNull
    public UByteArrayBuilder toBuilder-GBYM_sE(@NotNull byte[] arr_b) {
        q.g(arr_b, "$this$toBuilder");
        return new UByteArrayBuilder(arr_b, null);
    }

    @Override  // kotlinx.serialization.internal.PrimitiveArraySerializer
    public void writeContent(CompositeEncoder compositeEncoder0, Object object0, int v) {
        this.writeContent-Coi6ktg(compositeEncoder0, ((v)object0).a, v);
    }

    public void writeContent-Coi6ktg(@NotNull CompositeEncoder compositeEncoder0, @NotNull byte[] arr_b, int v) {
        q.g(compositeEncoder0, "encoder");
        q.g(arr_b, "content");
        for(int v1 = 0; v1 < v; ++v1) {
            compositeEncoder0.encodeInlineElement(this.getDescriptor(), v1).encodeByte(arr_b[v1]);
        }
    }
}

