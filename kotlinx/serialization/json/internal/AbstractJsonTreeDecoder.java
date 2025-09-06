package kotlinx.serialization.json.internal;

import Tf.v;
import U4.x;
import com.iloen.melon.utils.a;
import i.n.i.b.a.s.e.M3;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind.ENUM;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind.LIST;
import kotlinx.serialization.descriptors.StructureKind.MAP;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.NamedValueDecoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e;

@Metadata(d1 = {"\u0000\u00B4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0004\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0007\u00A2\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\u0005H\u0004\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0015\u0010\u000E\u001A\u00020\u00072\u0006\u0010\r\u001A\u00020\u0007\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0010\u0010\fJ#\u0010\u0014\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u00112\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u001F\u0010\u0018\u001A\u00020\u00072\u0006\u0010\u0016\u001A\u00020\u00072\u0006\u0010\u0017\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001B\u001A\u00020\u001AH\u0016\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0017\u0010 \u001A\u00020\u001F2\u0006\u0010\u001B\u001A\u00020\u001AH\u0016\u00A2\u0006\u0004\b \u0010!J\u000F\u0010#\u001A\u00020\"H\u0016\u00A2\u0006\u0004\b#\u0010$J\u0017\u0010&\u001A\u00020\u00052\u0006\u0010%\u001A\u00020\u0007H$\u00A2\u0006\u0004\b&\u0010\'J\u001F\u0010*\u001A\u00020)2\u0006\u0010%\u001A\u00020\u00072\u0006\u0010(\u001A\u00020\u001AH\u0014\u00A2\u0006\u0004\b*\u0010+J\u0017\u0010,\u001A\u00020\"2\u0006\u0010%\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b,\u0010-J\u0017\u0010/\u001A\u00020.2\u0006\u0010%\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b/\u00100J\u0017\u00102\u001A\u0002012\u0006\u0010%\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b2\u00103J\u0017\u00104\u001A\u00020)2\u0006\u0010%\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b4\u00105J\u0017\u00107\u001A\u0002062\u0006\u0010%\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b7\u00108J\u0017\u0010:\u001A\u0002092\u0006\u0010%\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b:\u0010;J\u0017\u0010=\u001A\u00020<2\u0006\u0010%\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b=\u0010>J\u0017\u0010@\u001A\u00020?2\u0006\u0010%\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001A\u00020\u00072\u0006\u0010%\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\bB\u0010\u000FJ\u001F\u0010E\u001A\u00020D2\u0006\u0010%\u001A\u00020\u00072\u0006\u0010C\u001A\u00020\u001AH\u0014\u00A2\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001A\u00020D2\u0006\u0010\u001B\u001A\u00020\u001AH\u0016\u00A2\u0006\u0004\bG\u0010HJ\'\u0010M\u001A\u00020L2\u0006\u0010J\u001A\u00020I2\u0006\u0010K\u001A\u00020\u00072\u0006\u0010%\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\bM\u0010NR\u001A\u0010\u0004\u001A\u00020\u00038\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0004\u0010O\u001A\u0004\bP\u0010QR\u001A\u0010\u0006\u001A\u00020\u00058\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0006\u0010R\u001A\u0004\bS\u0010\fR\u001C\u0010\b\u001A\u0004\u0018\u00010\u00078\u0004X\u0084\u0004\u00A2\u0006\f\n\u0004\b\b\u0010T\u001A\u0004\bU\u0010VR\u0014\u0010X\u001A\u00020W8\u0004X\u0085\u0004\u00A2\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010]\u001A\u00020Z8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b[\u0010\\\u0082\u0001\u0003^_`\u00A8\u0006a"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "Lkotlinx/serialization/internal/NamedValueDecoder;", "Lkotlinx/serialization/json/JsonDecoder;", "Lkotlinx/serialization/json/Json;", "json", "Lkotlinx/serialization/json/JsonElement;", "value", "", "polymorphicDiscriminator", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;)V", "currentObject", "()Lkotlinx/serialization/json/JsonElement;", "currentTag", "renderTagStack", "(Ljava/lang/String;)Ljava/lang/String;", "decodeJsonElement", "T", "Lkotlinx/serialization/DeserializationStrategy;", "deserializer", "decodeSerializableValue", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "parentName", "childName", "composeName", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/encoding/CompositeDecoder;", "beginStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeDecoder;", "Lie/H;", "endStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "decodeNotNullMark", "()Z", "tag", "currentElement", "(Ljava/lang/String;)Lkotlinx/serialization/json/JsonElement;", "enumDescriptor", "", "decodeTaggedEnum", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "decodeTaggedBoolean", "(Ljava/lang/String;)Z", "", "decodeTaggedByte", "(Ljava/lang/String;)B", "", "decodeTaggedShort", "(Ljava/lang/String;)S", "decodeTaggedInt", "(Ljava/lang/String;)I", "", "decodeTaggedLong", "(Ljava/lang/String;)J", "", "decodeTaggedFloat", "(Ljava/lang/String;)F", "", "decodeTaggedDouble", "(Ljava/lang/String;)D", "", "decodeTaggedChar", "(Ljava/lang/String;)C", "decodeTaggedString", "inlineDescriptor", "Lkotlinx/serialization/encoding/Decoder;", "decodeTaggedInline", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", "decodeInline", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", "Lkotlinx/serialization/json/JsonPrimitive;", "literal", "primitive", "", "unparsedPrimitive", "(Lkotlinx/serialization/json/JsonPrimitive;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Void;", "Lkotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "Lkotlinx/serialization/json/JsonElement;", "getValue", "Ljava/lang/String;", "getPolymorphicDiscriminator", "()Ljava/lang/String;", "Lkotlinx/serialization/json/JsonConfiguration;", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "Lkotlinx/serialization/json/internal/JsonPrimitiveDecoder;", "Lkotlinx/serialization/json/internal/JsonTreeDecoder;", "Lkotlinx/serialization/json/internal/JsonTreeListDecoder;", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
abstract class AbstractJsonTreeDecoder extends NamedValueDecoder implements JsonDecoder {
    @NotNull
    protected final JsonConfiguration configuration;
    @NotNull
    private final Json json;
    @Nullable
    private final String polymorphicDiscriminator;
    @NotNull
    private final JsonElement value;

    private AbstractJsonTreeDecoder(Json json0, JsonElement jsonElement0, String s) {
        this.json = json0;
        this.value = jsonElement0;
        this.polymorphicDiscriminator = s;
        this.configuration = this.getJson().getConfiguration();
    }

    public AbstractJsonTreeDecoder(Json json0, JsonElement jsonElement0, String s, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 4) != 0) {
            s = null;
        }
        this(json0, jsonElement0, s, null);
    }

    public AbstractJsonTreeDecoder(Json json0, JsonElement jsonElement0, String s, DefaultConstructorMarker defaultConstructorMarker0) {
        this(json0, jsonElement0, s);
    }

    // 去混淆评级： 低(20)
    public static final String access$renderTagStack(AbstractJsonTreeDecoder abstractJsonTreeDecoder0) {
        return "$";
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    @NotNull
    public CompositeDecoder beginStructure(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
        JsonElement jsonElement0 = this.currentObject();
        SerialKind serialKind0 = serialDescriptor0.getKind();
        boolean z = q.b(serialKind0, LIST.INSTANCE);
        Class class0 = JsonArray.class;
        if(!z && !(serialKind0 instanceof PolymorphicKind)) {
            boolean z1 = q.b(serialKind0, MAP.INSTANCE);
            Class class1 = JsonObject.class;
            if(z1) {
                Json json0 = this.getJson();
                SerialDescriptor serialDescriptor1 = WriteModeKt.carrierDescriptor(serialDescriptor0.getElementDescriptor(0), json0.getSerializersModule());
                SerialKind serialKind1 = serialDescriptor1.getKind();
                if(!(serialKind1 instanceof PrimitiveKind) && !q.b(serialKind1, ENUM.INSTANCE)) {
                    if(!json0.getConfiguration().getAllowStructuredMapKeys()) {
                        throw JsonExceptionsKt.InvalidKeyKindException(serialDescriptor1);
                    }
                    Json json1 = this.getJson();
                    String s = serialDescriptor0.getSerialName();
                    if(jsonElement0 instanceof JsonArray) {
                        return new JsonTreeListDecoder(json1, ((JsonArray)jsonElement0));
                    }
                    StringBuilder stringBuilder0 = new StringBuilder("Expected ");
                    stringBuilder0.append(I.a.b(class0).m());
                    stringBuilder0.append(", but had ");
                    Class class2 = jsonElement0.getClass();
                    stringBuilder0.append(I.a.b(class2).m());
                    e.g(stringBuilder0, " as the serialized body of ", s, " at element: ");
                    stringBuilder0.append(AbstractJsonTreeDecoder.access$renderTagStack(this));
                    throw JsonExceptionsKt.JsonDecodingException(-1, stringBuilder0.toString(), jsonElement0.toString());
                }
                Json json2 = this.getJson();
                String s1 = serialDescriptor0.getSerialName();
                if(jsonElement0 instanceof JsonObject) {
                    return new JsonTreeMapDecoder(json2, ((JsonObject)jsonElement0));
                }
                StringBuilder stringBuilder1 = new StringBuilder("Expected ");
                stringBuilder1.append(I.a.b(class1).m());
                stringBuilder1.append(", but had ");
                Class class3 = jsonElement0.getClass();
                stringBuilder1.append(I.a.b(class3).m());
                e.g(stringBuilder1, " as the serialized body of ", s1, " at element: ");
                stringBuilder1.append(AbstractJsonTreeDecoder.access$renderTagStack(this));
                throw JsonExceptionsKt.JsonDecodingException(-1, stringBuilder1.toString(), jsonElement0.toString());
            }
            Json json3 = this.getJson();
            String s2 = serialDescriptor0.getSerialName();
            if(jsonElement0 instanceof JsonObject) {
                return new JsonTreeDecoder(json3, ((JsonObject)jsonElement0), this.polymorphicDiscriminator, null, 8, null);
            }
            StringBuilder stringBuilder2 = new StringBuilder("Expected ");
            stringBuilder2.append(I.a.b(class1).m());
            stringBuilder2.append(", but had ");
            Class class4 = jsonElement0.getClass();
            stringBuilder2.append(I.a.b(class4).m());
            e.g(stringBuilder2, " as the serialized body of ", s2, " at element: ");
            stringBuilder2.append(AbstractJsonTreeDecoder.access$renderTagStack(this));
            throw JsonExceptionsKt.JsonDecodingException(-1, stringBuilder2.toString(), jsonElement0.toString());
        }
        Json json4 = this.getJson();
        String s3 = serialDescriptor0.getSerialName();
        if(jsonElement0 instanceof JsonArray) {
            return new JsonTreeListDecoder(json4, ((JsonArray)jsonElement0));
        }
        StringBuilder stringBuilder3 = new StringBuilder("Expected ");
        stringBuilder3.append(I.a.b(class0).m());
        stringBuilder3.append(", but had ");
        Class class5 = jsonElement0.getClass();
        stringBuilder3.append(I.a.b(class5).m());
        e.g(stringBuilder3, " as the serialized body of ", s3, " at element: ");
        stringBuilder3.append(AbstractJsonTreeDecoder.access$renderTagStack(this));
        throw JsonExceptionsKt.JsonDecodingException(-1, stringBuilder3.toString(), jsonElement0.toString());
    }

    @Override  // kotlinx.serialization.internal.NamedValueDecoder
    @NotNull
    public String composeName(@NotNull String s, @NotNull String s1) {
        q.g(s, "parentName");
        q.g(s1, "childName");
        return s1;
    }

    @NotNull
    public abstract JsonElement currentElement(@NotNull String arg1);

    @NotNull
    public final JsonElement currentObject() {
        String s = (String)this.getCurrentTagOrNull();
        if(s != null) {
            JsonElement jsonElement0 = this.currentElement(s);
            return jsonElement0 == null ? this.getValue() : jsonElement0;
        }
        return this.getValue();
    }

    @Override  // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    @NotNull
    public Decoder decodeInline(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
        return this.getCurrentTagOrNull() == null ? new JsonPrimitiveDecoder(this.getJson(), this.getValue(), this.polymorphicDiscriminator).decodeInline(serialDescriptor0) : super.decodeInline(serialDescriptor0);
    }

    @Override  // kotlinx.serialization.json.JsonDecoder
    @NotNull
    public JsonElement decodeJsonElement() {
        return this.currentObject();
    }

    @Override  // kotlinx.serialization.encoding.Decoder
    public boolean decodeNotNullMark() {
        return !(this.currentObject() instanceof JsonNull);
    }

    @Override  // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public Object decodeSerializableValue(@NotNull DeserializationStrategy deserializationStrategy0) {
        DeserializationStrategy deserializationStrategy1;
        String s2;
        q.g(deserializationStrategy0, "deserializer");
        if(deserializationStrategy0 instanceof AbstractPolymorphicSerializer && !this.getJson().getConfiguration().getUseArrayPolymorphism()) {
            String s = PolymorphicKt.classDiscriminator(((AbstractPolymorphicSerializer)deserializationStrategy0).getDescriptor(), this.getJson());
            JsonElement jsonElement0 = this.decodeJsonElement();
            String s1 = ((AbstractPolymorphicSerializer)deserializationStrategy0).getDescriptor().getSerialName();
            if(jsonElement0 instanceof JsonObject) {
                JsonElement jsonElement1 = (JsonElement)((JsonObject)jsonElement0).get(s);
                if(jsonElement1 == null) {
                    s2 = null;
                }
                else {
                    JsonPrimitive jsonPrimitive0 = JsonElementKt.getJsonPrimitive(jsonElement1);
                    s2 = jsonPrimitive0 == null ? null : JsonElementKt.getContentOrNull(jsonPrimitive0);
                }
                try {
                    deserializationStrategy1 = PolymorphicSerializerKt.findPolymorphicSerializer(((AbstractPolymorphicSerializer)deserializationStrategy0), this, s2);
                }
                catch(SerializationException serializationException0) {
                    String s3 = serializationException0.getMessage();
                    q.d(s3);
                    throw JsonExceptionsKt.JsonDecodingException(-1, s3, ((JsonObject)jsonElement0).toString());
                }
                q.e(deserializationStrategy1, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.decodeSerializableValuePolymorphic>");
                return TreeJsonDecoderKt.readPolymorphicJson(this.getJson(), s, ((JsonObject)jsonElement0), deserializationStrategy1);
            }
            Class class0 = jsonElement0.getClass();
            throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + I.a.b(JsonObject.class).m() + ", but had " + I.a.b(class0).m() + " as the serialized body of " + s1 + " at element: " + "$", jsonElement0.toString());
        }
        return deserializationStrategy0.deserialize(this);
    }

    @Override  // kotlinx.serialization.internal.TaggedDecoder
    public boolean decodeTaggedBoolean(Object object0) {
        return this.decodeTaggedBoolean(((String)object0));
    }

    public boolean decodeTaggedBoolean(@NotNull String s) {
        Boolean boolean0;
        q.g(s, "tag");
        JsonElement jsonElement0 = this.currentElement(s);
        if(jsonElement0 instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive0 = (JsonPrimitive)jsonElement0;
            try {
                boolean0 = JsonElementKt.getBooleanOrNull(jsonPrimitive0);
                if(boolean0 == null) {
                    this.unparsedPrimitive(jsonPrimitive0, "boolean", s);
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
            catch(IllegalArgumentException unused_ex) {
                this.unparsedPrimitive(jsonPrimitive0, "boolean", s);
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            return boolean0.booleanValue();
        }
        Class class0 = jsonElement0.getClass();
        throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + I.a.b(JsonPrimitive.class).m() + ", but had " + I.a.b(class0).m() + " as the serialized body of boolean at element: " + this.renderTagStack(s), jsonElement0.toString());
    }

    @Override  // kotlinx.serialization.internal.TaggedDecoder
    public byte decodeTaggedByte(Object object0) {
        return this.decodeTaggedByte(((String)object0));
    }

    public byte decodeTaggedByte(@NotNull String s) {
        Byte byte0;
        q.g(s, "tag");
        JsonElement jsonElement0 = this.currentElement(s);
        if(jsonElement0 instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive0 = (JsonPrimitive)jsonElement0;
            try {
                int v = JsonElementKt.getInt(jsonPrimitive0);
                byte0 = 0xFFFFFF80 > v || v > 0x7F ? null : ((byte)v);
                if(byte0 == null) {
                    this.unparsedPrimitive(jsonPrimitive0, "byte", s);
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
            catch(IllegalArgumentException unused_ex) {
                this.unparsedPrimitive(jsonPrimitive0, "byte", s);
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            return byte0.byteValue();
        }
        Class class0 = jsonElement0.getClass();
        throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + I.a.b(JsonPrimitive.class).m() + ", but had " + I.a.b(class0).m() + " as the serialized body of byte at element: " + this.renderTagStack(s), jsonElement0.toString());
    }

    @Override  // kotlinx.serialization.internal.TaggedDecoder
    public char decodeTaggedChar(Object object0) {
        return this.decodeTaggedChar(((String)object0));
    }

    public char decodeTaggedChar(@NotNull String s) {
        q.g(s, "tag");
        JsonElement jsonElement0 = this.currentElement(s);
        if(jsonElement0 instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive0 = (JsonPrimitive)jsonElement0;
            try {
                String s1 = jsonPrimitive0.getContent();
                q.g(s1, "<this>");
                switch(s1.length()) {
                    case 0: {
                        throw new NoSuchElementException("Char sequence is empty.");
                    }
                    case 1: {
                        return s1.charAt(0);
                    }
                }
            }
            catch(IllegalArgumentException unused_ex) {
            }
            this.unparsedPrimitive(jsonPrimitive0, "char", s);
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        Class class0 = jsonElement0.getClass();
        throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + I.a.b(JsonPrimitive.class).m() + ", but had " + I.a.b(class0).m() + " as the serialized body of char at element: " + this.renderTagStack(s), jsonElement0.toString());
    }

    @Override  // kotlinx.serialization.internal.TaggedDecoder
    public double decodeTaggedDouble(Object object0) {
        return this.decodeTaggedDouble(((String)object0));
    }

    public double decodeTaggedDouble(@NotNull String s) {
        double f;
        q.g(s, "tag");
        JsonElement jsonElement0 = this.currentElement(s);
        if(jsonElement0 instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive0 = (JsonPrimitive)jsonElement0;
            try {
                f = JsonElementKt.getDouble(jsonPrimitive0);
            }
            catch(IllegalArgumentException unused_ex) {
                this.unparsedPrimitive(jsonPrimitive0, "double", s);
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            if(!this.getJson().getConfiguration().getAllowSpecialFloatingPointValues() && (Double.isInfinite(f) || Double.isNaN(f))) {
                throw JsonExceptionsKt.InvalidFloatingPointDecoded(f, s, this.currentObject().toString());
            }
            return f;
        }
        Class class0 = jsonElement0.getClass();
        throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + I.a.b(JsonPrimitive.class).m() + ", but had " + I.a.b(class0).m() + " as the serialized body of double at element: " + this.renderTagStack(s), jsonElement0.toString());
    }

    @Override  // kotlinx.serialization.internal.TaggedDecoder
    public int decodeTaggedEnum(Object object0, SerialDescriptor serialDescriptor0) {
        return this.decodeTaggedEnum(((String)object0), serialDescriptor0);
    }

    public int decodeTaggedEnum(@NotNull String s, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(s, "tag");
        q.g(serialDescriptor0, "enumDescriptor");
        Json json0 = this.getJson();
        JsonElement jsonElement0 = this.currentElement(s);
        String s1 = serialDescriptor0.getSerialName();
        if(jsonElement0 instanceof JsonPrimitive) {
            return JsonNamesMapKt.getJsonNameIndexOrThrow$default(serialDescriptor0, json0, ((JsonPrimitive)jsonElement0).getContent(), null, 4, null);
        }
        StringBuilder stringBuilder0 = new StringBuilder("Expected ");
        stringBuilder0.append(I.a.b(JsonPrimitive.class).m());
        stringBuilder0.append(", but had ");
        Class class0 = jsonElement0.getClass();
        stringBuilder0.append(I.a.b(class0).m());
        e.g(stringBuilder0, " as the serialized body of ", s1, " at element: ");
        stringBuilder0.append(this.renderTagStack(s));
        throw JsonExceptionsKt.JsonDecodingException(-1, stringBuilder0.toString(), jsonElement0.toString());
    }

    @Override  // kotlinx.serialization.internal.TaggedDecoder
    public float decodeTaggedFloat(Object object0) {
        return this.decodeTaggedFloat(((String)object0));
    }

    public float decodeTaggedFloat(@NotNull String s) {
        float f;
        q.g(s, "tag");
        JsonElement jsonElement0 = this.currentElement(s);
        if(jsonElement0 instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive0 = (JsonPrimitive)jsonElement0;
            try {
                f = JsonElementKt.getFloat(jsonPrimitive0);
            }
            catch(IllegalArgumentException unused_ex) {
                this.unparsedPrimitive(jsonPrimitive0, "float", s);
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            if(!this.getJson().getConfiguration().getAllowSpecialFloatingPointValues() && (Float.isInfinite(f) || Float.isNaN(f))) {
                throw JsonExceptionsKt.InvalidFloatingPointDecoded(f, s, this.currentObject().toString());
            }
            return f;
        }
        Class class0 = jsonElement0.getClass();
        throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + I.a.b(JsonPrimitive.class).m() + ", but had " + I.a.b(class0).m() + " as the serialized body of float at element: " + this.renderTagStack(s), jsonElement0.toString());
    }

    @Override  // kotlinx.serialization.internal.TaggedDecoder
    public Decoder decodeTaggedInline(Object object0, SerialDescriptor serialDescriptor0) {
        return this.decodeTaggedInline(((String)object0), serialDescriptor0);
    }

    @NotNull
    public Decoder decodeTaggedInline(@NotNull String s, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(s, "tag");
        q.g(serialDescriptor0, "inlineDescriptor");
        if(StreamingJsonEncoderKt.isUnsignedNumber(serialDescriptor0)) {
            Json json0 = this.getJson();
            JsonElement jsonElement0 = this.currentElement(s);
            String s1 = serialDescriptor0.getSerialName();
            if(jsonElement0 instanceof JsonPrimitive) {
                return new JsonDecoderForUnsignedTypes(StringJsonLexerKt.StringJsonLexer(json0, ((JsonPrimitive)jsonElement0).getContent()), this.getJson());
            }
            StringBuilder stringBuilder0 = new StringBuilder("Expected ");
            stringBuilder0.append(I.a.b(JsonPrimitive.class).m());
            stringBuilder0.append(", but had ");
            Class class0 = jsonElement0.getClass();
            stringBuilder0.append(I.a.b(class0).m());
            e.g(stringBuilder0, " as the serialized body of ", s1, " at element: ");
            stringBuilder0.append(this.renderTagStack(s));
            throw JsonExceptionsKt.JsonDecodingException(-1, stringBuilder0.toString(), jsonElement0.toString());
        }
        return super.decodeTaggedInline(s, serialDescriptor0);
    }

    @Override  // kotlinx.serialization.internal.TaggedDecoder
    public int decodeTaggedInt(Object object0) {
        return this.decodeTaggedInt(((String)object0));
    }

    public int decodeTaggedInt(@NotNull String s) {
        q.g(s, "tag");
        JsonElement jsonElement0 = this.currentElement(s);
        if(jsonElement0 instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive0 = (JsonPrimitive)jsonElement0;
            try {
                return JsonElementKt.getInt(jsonPrimitive0);
            }
            catch(IllegalArgumentException unused_ex) {
                this.unparsedPrimitive(jsonPrimitive0, "int", s);
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        Class class0 = jsonElement0.getClass();
        throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + I.a.b(JsonPrimitive.class).m() + ", but had " + I.a.b(class0).m() + " as the serialized body of int at element: " + this.renderTagStack(s), jsonElement0.toString());
    }

    @Override  // kotlinx.serialization.internal.TaggedDecoder
    public long decodeTaggedLong(Object object0) {
        return this.decodeTaggedLong(((String)object0));
    }

    public long decodeTaggedLong(@NotNull String s) {
        q.g(s, "tag");
        JsonElement jsonElement0 = this.currentElement(s);
        if(jsonElement0 instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive0 = (JsonPrimitive)jsonElement0;
            try {
                return JsonElementKt.getLong(jsonPrimitive0);
            }
            catch(IllegalArgumentException unused_ex) {
                this.unparsedPrimitive(jsonPrimitive0, "long", s);
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        Class class0 = jsonElement0.getClass();
        throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + I.a.b(JsonPrimitive.class).m() + ", but had " + I.a.b(class0).m() + " as the serialized body of long at element: " + this.renderTagStack(s), jsonElement0.toString());
    }

    @Override  // kotlinx.serialization.internal.TaggedDecoder
    public short decodeTaggedShort(Object object0) {
        return this.decodeTaggedShort(((String)object0));
    }

    public short decodeTaggedShort(@NotNull String s) {
        Short short0;
        q.g(s, "tag");
        JsonElement jsonElement0 = this.currentElement(s);
        if(jsonElement0 instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive0 = (JsonPrimitive)jsonElement0;
            try {
                int v = JsonElementKt.getInt(jsonPrimitive0);
                short0 = 0xFFFF8000 > v || v > 0x7FFF ? null : ((short)v);
                if(short0 == null) {
                    this.unparsedPrimitive(jsonPrimitive0, "short", s);
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
            catch(IllegalArgumentException unused_ex) {
                this.unparsedPrimitive(jsonPrimitive0, "short", s);
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            return short0.shortValue();
        }
        Class class0 = jsonElement0.getClass();
        throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + I.a.b(JsonPrimitive.class).m() + ", but had " + I.a.b(class0).m() + " as the serialized body of short at element: " + this.renderTagStack(s), jsonElement0.toString());
    }

    @Override  // kotlinx.serialization.internal.TaggedDecoder
    public String decodeTaggedString(Object object0) {
        return this.decodeTaggedString(((String)object0));
    }

    @NotNull
    public String decodeTaggedString(@NotNull String s) {
        q.g(s, "tag");
        JsonElement jsonElement0 = this.currentElement(s);
        if(jsonElement0 instanceof JsonPrimitive) {
            if(((JsonPrimitive)jsonElement0) instanceof JsonLiteral) {
                if(!((JsonLiteral)(((JsonPrimitive)jsonElement0))).isString() && !this.getJson().getConfiguration().isLenient()) {
                    throw JsonExceptionsKt.JsonDecodingException(-1, x.m(a.n("String literal for key \'", s, "\' should be quoted at element: "), this.renderTagStack(s), ".\nUse \'isLenient = true\' in \'Json {}\' builder to accept non-compliant JSON."), this.currentObject().toString());
                }
                return ((JsonLiteral)(((JsonPrimitive)jsonElement0))).getContent();
            }
            StringBuilder stringBuilder0 = a.n("Expected string value for a non-null key \'", s, "\', got null literal instead at element: ");
            stringBuilder0.append(this.renderTagStack(s));
            throw JsonExceptionsKt.JsonDecodingException(-1, stringBuilder0.toString(), this.currentObject().toString());
        }
        Class class0 = jsonElement0.getClass();
        throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + I.a.b(JsonPrimitive.class).m() + ", but had " + I.a.b(class0).m() + " as the serialized body of string at element: " + this.renderTagStack(s), jsonElement0.toString());
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public void endStructure(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
    }

    @Override  // kotlinx.serialization.json.JsonDecoder
    @NotNull
    public Json getJson() {
        return this.json;
    }

    @Nullable
    public final String getPolymorphicDiscriminator() {
        return this.polymorphicDiscriminator;
    }

    @Override  // kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.CompositeDecoder
    @NotNull
    public SerializersModule getSerializersModule() {
        return this.getJson().getSerializersModule();
    }

    @NotNull
    public abstract JsonElement getValue();

    @NotNull
    public final String renderTagStack(@NotNull String s) {
        q.g(s, "currentTag");
        return "$" + '.' + s;
    }

    // 去混淆评级： 低(20)
    private final Void unparsedPrimitive(JsonPrimitive jsonPrimitive0, String s, String s1) {
        throw JsonExceptionsKt.JsonDecodingException(-1, "Failed to parse literal \'" + jsonPrimitive0 + "\' as " + ((v.r0(s, "i", false) ? "an " : "a ") + s) + " value at element: " + this.renderTagStack(s1), this.currentObject().toString());
    }
}

