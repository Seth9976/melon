package kotlinx.serialization.json;

import dd.v;
import ed.s;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.PolymorphicKind.SEALED;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001A\u00020\u00022\u0006\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\r\u0010\u000ER\u001A\u0010\u0010\u001A\u00020\u000F8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lkotlinx/serialization/json/JsonElementSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonElement;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lkotlinx/serialization/json/JsonElement;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lkotlinx/serialization/json/JsonElement;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class JsonElementSerializer implements KSerializer {
    @NotNull
    public static final JsonElementSerializer INSTANCE;
    @NotNull
    private static final SerialDescriptor descriptor;

    static {
        JsonElementSerializer.INSTANCE = new JsonElementSerializer();
        s s0 = new s(2);
        JsonElementSerializer.descriptor = SerialDescriptorsKt.buildSerialDescriptor("kotlinx.serialization.json.JsonElement", SEALED.INSTANCE, new SerialDescriptor[0], s0);
    }

    public static H a(ClassSerialDescriptorBuilder classSerialDescriptorBuilder0) {
        return JsonElementSerializer.descriptor$lambda$5(classSerialDescriptorBuilder0);
    }

    public static SerialDescriptor b() {
        return JsonElementSerializer.descriptor$lambda$5$lambda$0();
    }

    public static SerialDescriptor c() {
        return JsonElementSerializer.descriptor$lambda$5$lambda$1();
    }

    public static SerialDescriptor d() {
        return JsonElementSerializer.descriptor$lambda$5$lambda$2();
    }

    private static final H descriptor$lambda$5(ClassSerialDescriptorBuilder classSerialDescriptorBuilder0) {
        q.g(classSerialDescriptorBuilder0, "$this$buildSerialDescriptor");
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder0, "JsonPrimitive", JsonElementSerializersKt.defer(new v(10)), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder0, "JsonNull", JsonElementSerializersKt.defer(new v(11)), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder0, "JsonLiteral", JsonElementSerializersKt.defer(new v(12)), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder0, "JsonObject", JsonElementSerializersKt.defer(new v(13)), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder0, "JsonArray", JsonElementSerializersKt.defer(new v(14)), null, false, 12, null);
        return H.a;
    }

    private static final SerialDescriptor descriptor$lambda$5$lambda$0() {
        return JsonPrimitiveSerializer.INSTANCE.getDescriptor();
    }

    private static final SerialDescriptor descriptor$lambda$5$lambda$1() {
        return JsonNullSerializer.INSTANCE.getDescriptor();
    }

    private static final SerialDescriptor descriptor$lambda$5$lambda$2() {
        return JsonLiteralSerializer.INSTANCE.getDescriptor();
    }

    private static final SerialDescriptor descriptor$lambda$5$lambda$3() {
        return JsonObjectSerializer.INSTANCE.getDescriptor();
    }

    private static final SerialDescriptor descriptor$lambda$5$lambda$4() {
        return JsonArraySerializer.INSTANCE.getDescriptor();
    }

    @Override  // kotlinx.serialization.DeserializationStrategy
    public Object deserialize(Decoder decoder0) {
        return this.deserialize(decoder0);
    }

    @NotNull
    public JsonElement deserialize(@NotNull Decoder decoder0) {
        q.g(decoder0, "decoder");
        return JsonElementSerializersKt.asJsonDecoder(decoder0).decodeJsonElement();
    }

    public static SerialDescriptor e() {
        return JsonElementSerializer.descriptor$lambda$5$lambda$3();
    }

    public static SerialDescriptor f() {
        return JsonElementSerializer.descriptor$lambda$5$lambda$4();
    }

    @Override  // kotlinx.serialization.KSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return JsonElementSerializer.descriptor;
    }

    @Override  // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder0, Object object0) {
        this.serialize(encoder0, ((JsonElement)object0));
    }

    public void serialize(@NotNull Encoder encoder0, @NotNull JsonElement jsonElement0) {
        q.g(encoder0, "encoder");
        q.g(jsonElement0, "value");
        JsonElementSerializersKt.verify(encoder0);
        if(jsonElement0 instanceof JsonPrimitive) {
            encoder0.encodeSerializableValue(JsonPrimitiveSerializer.INSTANCE, jsonElement0);
            return;
        }
        if(jsonElement0 instanceof JsonObject) {
            encoder0.encodeSerializableValue(JsonObjectSerializer.INSTANCE, jsonElement0);
            return;
        }
        if(!(jsonElement0 instanceof JsonArray)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        encoder0.encodeSerializableValue(JsonArraySerializer.INSTANCE, jsonElement0);
    }
}

