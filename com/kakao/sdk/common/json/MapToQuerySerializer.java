package com.kakao.sdk.common.json;

import com.kakao.sdk.common.util.Utility;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind.CONTEXTUAL;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ+\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000B\u001A\u00020\n2\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u000E\u0010\u000FR \u0010\u0011\u001A\u00020\u00108\u0016X\u0096\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0015\u0010\u0005\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/kakao/sdk/common/json/MapToQuerySerializer;", "Lkotlinx/serialization/KSerializer;", "", "", "<init>", "()V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/util/Map;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/util/Map;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor$annotations", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class MapToQuerySerializer implements KSerializer {
    @NotNull
    public static final MapToQuerySerializer INSTANCE;
    @NotNull
    private static final SerialDescriptor descriptor;

    static {
        MapToQuerySerializer.INSTANCE = new MapToQuerySerializer();
        MapToQuerySerializer.descriptor = SerialDescriptorsKt.buildSerialDescriptor("MapToQuery", CONTEXTUAL.INSTANCE, new SerialDescriptor[0], MapToQuerySerializer.descriptor.1.INSTANCE);
    }

    @Override  // kotlinx.serialization.DeserializationStrategy
    public Object deserialize(Decoder decoder0) {
        return this.deserialize(decoder0);
    }

    @NotNull
    public Map deserialize(@NotNull Decoder decoder0) {
        q.g(decoder0, "decoder");
        String s = decoder0.decodeString();
        return Utility.INSTANCE.parseQuery(s);
    }

    @Override  // kotlinx.serialization.KSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return MapToQuerySerializer.descriptor;
    }

    public static void getDescriptor$annotations() {
    }

    @Override  // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder0, Object object0) {
        this.serialize(encoder0, ((Map)object0));
    }

    public void serialize(@NotNull Encoder encoder0, @NotNull Map map0) {
        q.g(encoder0, "encoder");
        q.g(map0, "value");
        encoder0.encodeString(Utility.INSTANCE.buildQuery(map0));
    }
}

