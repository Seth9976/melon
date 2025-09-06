package kotlinx.serialization.json;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001A\u00020\u00022\u0006\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\r\u0010\u000ER\u001A\u0010\u0010\u001A\u00020\u000F8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lkotlinx/serialization/json/JsonObjectSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonObject;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lkotlinx/serialization/json/JsonObject;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lkotlinx/serialization/json/JsonObject;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "JsonObjectDescriptor", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class JsonObjectSerializer implements KSerializer {
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u001B\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0097\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\u0006H\u0097\u0001¢\u0006\u0004\b\n\u0010\u000BJ\u001E\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0005\u001A\u00020\u0004H\u0097\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u0018\u0010\u0010\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0004H\u0097\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0005\u001A\u00020\u0004H\u0097\u0001¢\u0006\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001A\u00020\u00068\u0016X\u0097D¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u0012\u0004\b\u0019\u0010\u0003\u001A\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001D\u001A\u00020\u001A8\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001CR\u0014\u0010\u001E\u001A\u00020\u00128VX\u0097\u0005¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001FR\u0014\u0010 \u001A\u00020\u00128VX\u0096\u0005¢\u0006\u0006\u001A\u0004\b \u0010\u001FR\u0014\u0010#\u001A\u00020\u00048\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\b!\u0010\"R\u001A\u0010&\u001A\b\u0012\u0004\u0012\u00020\r0\f8VX\u0097\u0005¢\u0006\u0006\u001A\u0004\b$\u0010%¨\u0006\'"}, d2 = {"Lkotlinx/serialization/json/JsonObjectSerializer$JsonObjectDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "<init>", "()V", "", "index", "", "getElementName", "(I)Ljava/lang/String;", "name", "getElementIndex", "(Ljava/lang/String;)I", "", "", "getElementAnnotations", "(I)Ljava/util/List;", "getElementDescriptor", "(I)Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "isElementOptional", "(I)Z", "serialName", "Ljava/lang/String;", "getSerialName", "()Ljava/lang/String;", "getSerialName$annotations", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "kind", "isNullable", "()Z", "isInline", "getElementsCount", "()I", "elementsCount", "getAnnotations", "()Ljava/util/List;", "annotations", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
    static final class JsonObjectDescriptor implements SerialDescriptor {
        private final SerialDescriptor $$delegate_0;
        @NotNull
        public static final JsonObjectDescriptor INSTANCE;
        @NotNull
        private static final String serialName;

        static {
            JsonObjectDescriptor.INSTANCE = new JsonObjectDescriptor();
            JsonObjectDescriptor.serialName = "kotlinx.serialization.json.JsonObject";
        }

        private JsonObjectDescriptor() {
            this.$$delegate_0 = BuiltinSerializersKt.MapSerializer(BuiltinSerializersKt.serializer(M.a), JsonElementSerializer.INSTANCE).getDescriptor();
        }

        @Override  // kotlinx.serialization.descriptors.SerialDescriptor
        @NotNull
        public List getAnnotations() {
            return this.$$delegate_0.getAnnotations();
        }

        @Override  // kotlinx.serialization.descriptors.SerialDescriptor
        @NotNull
        public List getElementAnnotations(int v) {
            return this.$$delegate_0.getElementAnnotations(v);
        }

        @Override  // kotlinx.serialization.descriptors.SerialDescriptor
        @NotNull
        public SerialDescriptor getElementDescriptor(int v) {
            return this.$$delegate_0.getElementDescriptor(v);
        }

        @Override  // kotlinx.serialization.descriptors.SerialDescriptor
        public int getElementIndex(@NotNull String s) {
            q.g(s, "name");
            return this.$$delegate_0.getElementIndex(s);
        }

        @Override  // kotlinx.serialization.descriptors.SerialDescriptor
        @NotNull
        public String getElementName(int v) {
            return this.$$delegate_0.getElementName(v);
        }

        @Override  // kotlinx.serialization.descriptors.SerialDescriptor
        public int getElementsCount() {
            return this.$$delegate_0.getElementsCount();
        }

        @Override  // kotlinx.serialization.descriptors.SerialDescriptor
        @NotNull
        public SerialKind getKind() {
            return this.$$delegate_0.getKind();
        }

        @Override  // kotlinx.serialization.descriptors.SerialDescriptor
        @NotNull
        public String getSerialName() {
            return JsonObjectDescriptor.serialName;
        }

        @Override  // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean isElementOptional(int v) {
            return this.$$delegate_0.isElementOptional(v);
        }

        @Override  // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean isInline() {
            return this.$$delegate_0.isInline();
        }

        @Override  // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean isNullable() {
            return this.$$delegate_0.isNullable();
        }
    }

    @NotNull
    public static final JsonObjectSerializer INSTANCE;
    @NotNull
    private static final SerialDescriptor descriptor;

    static {
        JsonObjectSerializer.INSTANCE = new JsonObjectSerializer();
        JsonObjectSerializer.descriptor = JsonObjectDescriptor.INSTANCE;
    }

    @Override  // kotlinx.serialization.DeserializationStrategy
    public Object deserialize(Decoder decoder0) {
        return this.deserialize(decoder0);
    }

    @NotNull
    public JsonObject deserialize(@NotNull Decoder decoder0) {
        q.g(decoder0, "decoder");
        JsonElementSerializersKt.verify(decoder0);
        return new JsonObject(((Map)BuiltinSerializersKt.MapSerializer(BuiltinSerializersKt.serializer(M.a), JsonElementSerializer.INSTANCE).deserialize(decoder0)));
    }

    @Override  // kotlinx.serialization.KSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return JsonObjectSerializer.descriptor;
    }

    @Override  // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder0, Object object0) {
        this.serialize(encoder0, ((JsonObject)object0));
    }

    public void serialize(@NotNull Encoder encoder0, @NotNull JsonObject jsonObject0) {
        q.g(encoder0, "encoder");
        q.g(jsonObject0, "value");
        JsonElementSerializersKt.verify(encoder0);
        BuiltinSerializersKt.MapSerializer(BuiltinSerializersKt.serializer(M.a), JsonElementSerializer.INSTANCE).serialize(encoder0, jsonObject0);
    }
}

