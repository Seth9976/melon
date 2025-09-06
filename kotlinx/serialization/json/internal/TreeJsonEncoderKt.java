package kotlinx.serialization.json.internal;

import dd.z;
import ie.H;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind.ENUM;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\u001A3\u0010\u0007\u001A\u00020\u0006\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00028\u00002\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\"\u0018\u0010\r\u001A\u00020\n*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\f¨\u0006\u000E"}, d2 = {"T", "Lkotlinx/serialization/json/Json;", "json", "value", "Lkotlinx/serialization/SerializationStrategy;", "serializer", "Lkotlinx/serialization/json/JsonElement;", "writeJson", "(Lkotlinx/serialization/json/Json;Ljava/lang/Object;Lkotlinx/serialization/SerializationStrategy;)Lkotlinx/serialization/json/JsonElement;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "getRequiresTopLevelTag", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Z", "requiresTopLevelTag", "kotlinx-serialization-json"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class TreeJsonEncoderKt {
    public static H a(kotlin.jvm.internal.H h0, JsonElement jsonElement0) {
        return TreeJsonEncoderKt.writeJson$lambda$0(h0, jsonElement0);
    }

    public static final boolean access$getRequiresTopLevelTag(SerialDescriptor serialDescriptor0) {
        return TreeJsonEncoderKt.getRequiresTopLevelTag(serialDescriptor0);
    }

    private static final boolean getRequiresTopLevelTag(SerialDescriptor serialDescriptor0) {
        return serialDescriptor0.getKind() instanceof PrimitiveKind || serialDescriptor0.getKind() == ENUM.INSTANCE;
    }

    @NotNull
    public static final JsonElement writeJson(@NotNull Json json0, Object object0, @NotNull SerializationStrategy serializationStrategy0) {
        q.g(json0, "json");
        q.g(serializationStrategy0, "serializer");
        kotlin.jvm.internal.H h0 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
        new JsonTreeEncoder(json0, new z(h0, 11)).encodeSerializableValue(serializationStrategy0, object0);
        Object object1 = h0.a;
        if(object1 != null) {
            return (JsonElement)object1;
        }
        q.m("result");
        throw null;
    }

    private static final H writeJson$lambda$0(kotlin.jvm.internal.H h0, JsonElement jsonElement0) {
        q.g(jsonElement0, "it");
        h0.a = jsonElement0;
        return H.a;
    }
}

