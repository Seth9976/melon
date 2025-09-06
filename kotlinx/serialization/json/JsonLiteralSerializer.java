package kotlinx.serialization.json;

import H0.b;
import Tf.u;
import Tf.v;
import ie.A;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.PrimitiveKind.STRING;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.internal.JsonExceptionsKt;
import org.jetbrains.annotations.NotNull;
import ye.a;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001A\u00020\u00022\u0006\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\r\u0010\u000ER\u001A\u0010\u0010\u001A\u00020\u000F8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lkotlinx/serialization/json/JsonLiteralSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonLiteral;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lkotlinx/serialization/json/JsonLiteral;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lkotlinx/serialization/json/JsonLiteral;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
final class JsonLiteralSerializer implements KSerializer {
    @NotNull
    public static final JsonLiteralSerializer INSTANCE;
    @NotNull
    private static final SerialDescriptor descriptor;

    static {
        JsonLiteralSerializer.INSTANCE = new JsonLiteralSerializer();
        JsonLiteralSerializer.descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor("kotlinx.serialization.json.JsonLiteral", STRING.INSTANCE);
    }

    @Override  // kotlinx.serialization.DeserializationStrategy
    public Object deserialize(Decoder decoder0) {
        return this.deserialize(decoder0);
    }

    @NotNull
    public JsonLiteral deserialize(@NotNull Decoder decoder0) {
        q.g(decoder0, "decoder");
        JsonElement jsonElement0 = JsonElementSerializersKt.asJsonDecoder(decoder0).decodeJsonElement();
        if(jsonElement0 instanceof JsonLiteral) {
            return (JsonLiteral)jsonElement0;
        }
        StringBuilder stringBuilder0 = new StringBuilder("Unexpected JSON element, expected JsonLiteral, had ");
        Class class0 = jsonElement0.getClass();
        throw JsonExceptionsKt.JsonDecodingException(-1, b.l(I.a, class0, stringBuilder0), jsonElement0.toString());
    }

    @Override  // kotlinx.serialization.KSerializer
    @NotNull
    public SerialDescriptor getDescriptor() {
        return JsonLiteralSerializer.descriptor;
    }

    @Override  // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder0, Object object0) {
        this.serialize(encoder0, ((JsonLiteral)object0));
    }

    public void serialize(@NotNull Encoder encoder0, @NotNull JsonLiteral jsonLiteral0) {
        Boolean boolean0;
        q.g(encoder0, "encoder");
        q.g(jsonLiteral0, "value");
        JsonElementSerializersKt.verify(encoder0);
        if(jsonLiteral0.isString()) {
            encoder0.encodeString(jsonLiteral0.getContent());
            return;
        }
        if(jsonLiteral0.getCoerceToInlineType$kotlinx_serialization_json() != null) {
            encoder0.encodeInline(jsonLiteral0.getCoerceToInlineType$kotlinx_serialization_json()).encodeString(jsonLiteral0.getContent());
            return;
        }
        Long long0 = v.u0(jsonLiteral0.getContent());
        if(long0 != null) {
            encoder0.encodeLong(long0.longValue());
            return;
        }
        A a0 = a.b0(jsonLiteral0.getContent());
        if(a0 != null) {
            encoder0.encodeInline(BuiltinSerializersKt.serializer(A.b).getDescriptor()).encodeLong(a0.a);
            return;
        }
        Double double0 = u.f0(jsonLiteral0.getContent());
        if(double0 != null) {
            encoder0.encodeDouble(double0.doubleValue());
            return;
        }
        String s = jsonLiteral0.getContent();
        q.g(s, "<this>");
        boolean z = false;
        if(s.equals("true")) {
            z = true;
            boolean0 = Boolean.TRUE;
        }
        else if(s.equals("false")) {
            z = true;
            boolean0 = Boolean.FALSE;
        }
        if(z) {
            encoder0.encodeBoolean(boolean0.booleanValue());
            return;
        }
        encoder0.encodeString(jsonLiteral0.getContent());
    }
}

