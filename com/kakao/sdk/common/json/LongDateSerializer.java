package com.kakao.sdk.common.json;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\r\u001A\u00020\f2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000ER\u0014\u0010\u0012\u001A\u00020\u000F8VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/kakao/sdk/common/json/LongDateSerializer;", "Lkotlinx/serialization/KSerializer;", "Ljava/util/Date;", "<init>", "()V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/util/Date;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/util/Date;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class LongDateSerializer implements KSerializer {
    private final PluginGeneratedSerialDescriptor descriptor;

    public LongDateSerializer() {
        this.descriptor = new PluginGeneratedSerialDescriptor("java.util.Date", null, 0);
    }

    @Override  // kotlinx.serialization.DeserializationStrategy
    public Object deserialize(Decoder decoder0) {
        return this.deserialize(decoder0);
    }

    @NotNull
    public Date deserialize(@NotNull Decoder decoder0) {
        q.g(decoder0, "decoder");
        return new Date(decoder0.decodeLong() * 1000L);
    }

    @Override  // kotlinx.serialization.KSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override  // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder0, Object object0) {
        this.serialize(encoder0, ((Date)object0));
    }

    public void serialize(@NotNull Encoder encoder0, @NotNull Date date0) {
        q.g(encoder0, "encoder");
        q.g(date0, "value");
        encoder0.encodeLong(date0.getTime() / 1000L);
    }
}

