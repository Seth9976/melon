package kotlinx.serialization.json.internal;

import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind.ENUM;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind.CLASS;
import kotlinx.serialization.descriptors.StructureKind.LIST;
import kotlinx.serialization.descriptors.StructureKind.MAP;
import kotlinx.serialization.descriptors.StructureKind.OBJECT;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.NamedValueEncoder;
import kotlinx.serialization.json.ClassDiscriminatorMode;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000\u00B0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0015\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0002RU\b3\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0004\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0012\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00A2\u0006\u0004\b\t\u0010\nJ\u001F\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\rH\u0014\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u001F\u0010\u0013\u001A\u00020\u00122\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u001F\u0010\u0017\u001A\u00020\u000F2\u0006\u0010\u0015\u001A\u00020\u000F2\u0006\u0010\u0016\u001A\u00020\u000FH\u0014\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u001F\u0010\u001B\u001A\u00020\u00072\u0006\u0010\u0019\u001A\u00020\u000F2\u0006\u0010\u001A\u001A\u00020\u0006H&\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001D\u001A\u00020\u0006H&\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010\u001F\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\u001F\u0010 J\u000F\u0010!\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b!\u0010 J\u0017\u0010#\u001A\u00020\u00072\u0006\u0010\"\u001A\u00020\u000FH\u0014\u00A2\u0006\u0004\b#\u0010$J\u001F\u0010&\u001A\u00020\u00072\u0006\u0010\"\u001A\u00020\u000F2\u0006\u0010%\u001A\u00020\rH\u0014\u00A2\u0006\u0004\b&\u0010\'J\u001F\u0010)\u001A\u00020\u00072\u0006\u0010\"\u001A\u00020\u000F2\u0006\u0010%\u001A\u00020(H\u0014\u00A2\u0006\u0004\b)\u0010*J\u001F\u0010,\u001A\u00020\u00072\u0006\u0010\"\u001A\u00020\u000F2\u0006\u0010%\u001A\u00020+H\u0014\u00A2\u0006\u0004\b,\u0010-J\u001F\u0010/\u001A\u00020\u00072\u0006\u0010\"\u001A\u00020\u000F2\u0006\u0010%\u001A\u00020.H\u0014\u00A2\u0006\u0004\b/\u00100J\u001F\u00102\u001A\u00020\u00072\u0006\u0010\"\u001A\u00020\u000F2\u0006\u0010%\u001A\u000201H\u0014\u00A2\u0006\u0004\b2\u00103J+\u00107\u001A\u00020\u0007\"\u0004\b\u0000\u001042\f\u00106\u001A\b\u0012\u0004\u0012\u00028\u0000052\u0006\u0010%\u001A\u00028\u0000H\u0016\u00A2\u0006\u0004\b7\u00108J\u001F\u0010:\u001A\u00020\u00072\u0006\u0010\"\u001A\u00020\u000F2\u0006\u0010%\u001A\u000209H\u0014\u00A2\u0006\u0004\b:\u0010;J\u001F\u0010<\u001A\u00020\u00072\u0006\u0010\"\u001A\u00020\u000F2\u0006\u0010%\u001A\u00020\u0012H\u0014\u00A2\u0006\u0004\b<\u0010=J\u001F\u0010?\u001A\u00020\u00072\u0006\u0010\"\u001A\u00020\u000F2\u0006\u0010%\u001A\u00020>H\u0014\u00A2\u0006\u0004\b?\u0010@J\u001F\u0010A\u001A\u00020\u00072\u0006\u0010\"\u001A\u00020\u000F2\u0006\u0010%\u001A\u00020\u000FH\u0014\u00A2\u0006\u0004\bA\u0010BJ\'\u0010E\u001A\u00020\u00072\u0006\u0010\"\u001A\u00020\u000F2\u0006\u0010C\u001A\u00020\u000B2\u0006\u0010D\u001A\u00020\rH\u0014\u00A2\u0006\u0004\bE\u0010FJ\u001F\u0010I\u001A\u00020H2\u0006\u0010\"\u001A\u00020\u000F2\u0006\u0010G\u001A\u00020\u000BH\u0014\u00A2\u0006\u0004\bI\u0010JJ\u0017\u0010K\u001A\u00020H2\u0006\u0010\f\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\bK\u0010LJ\u0017\u0010N\u001A\u00020M2\u0006\u0010\f\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\bN\u0010OJ\u0017\u0010P\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u000BH\u0014\u00A2\u0006\u0004\bP\u0010QJ\u0017\u0010S\u001A\u00020R2\u0006\u0010\"\u001A\u00020\u000FH\u0003\u00A2\u0006\u0004\bS\u0010TJ\u001F\u0010V\u001A\u00020U2\u0006\u0010\"\u001A\u00020\u000F2\u0006\u0010G\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\bV\u0010WR\u0017\u0010\u0004\u001A\u00020\u00038\u0006\u00A2\u0006\f\n\u0004\b\u0004\u0010X\u001A\u0004\bY\u0010ZR&\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0004X\u0084\u0004\u00A2\u0006\f\n\u0004\b\b\u0010[\u001A\u0004\b\\\u0010]R\u0014\u0010_\u001A\u00020^8\u0004X\u0085\u0004\u00A2\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010a\u001A\u0004\u0018\u00010\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010c\u001A\u0004\u0018\u00010\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bc\u0010bR\u0011\u0010g\u001A\u00020d8F\u00A2\u0006\u0006\u001A\u0004\be\u0010f\u0082\u0001\u0003hij\u00A8\u0006k"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonTreeEncoder;", "Lkotlinx/serialization/internal/NamedValueEncoder;", "Lkotlinx/serialization/json/JsonEncoder;", "Lkotlinx/serialization/json/Json;", "json", "Lkotlin/Function1;", "Lkotlinx/serialization/json/JsonElement;", "Lie/H;", "nodeConsumer", "<init>", "(Lkotlinx/serialization/json/Json;Lwe/k;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "index", "", "elementName", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/String;", "", "shouldEncodeElementDefault", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "parentName", "childName", "composeName", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "key", "element", "putElement", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;)V", "getCurrent", "()Lkotlinx/serialization/json/JsonElement;", "encodeNotNullMark", "()V", "encodeNull", "tag", "encodeTaggedNull", "(Ljava/lang/String;)V", "value", "encodeTaggedInt", "(Ljava/lang/String;I)V", "", "encodeTaggedByte", "(Ljava/lang/String;B)V", "", "encodeTaggedShort", "(Ljava/lang/String;S)V", "", "encodeTaggedLong", "(Ljava/lang/String;J)V", "", "encodeTaggedFloat", "(Ljava/lang/String;F)V", "T", "Lkotlinx/serialization/SerializationStrategy;", "serializer", "encodeSerializableValue", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "", "encodeTaggedDouble", "(Ljava/lang/String;D)V", "encodeTaggedBoolean", "(Ljava/lang/String;Z)V", "", "encodeTaggedChar", "(Ljava/lang/String;C)V", "encodeTaggedString", "(Ljava/lang/String;Ljava/lang/String;)V", "enumDescriptor", "ordinal", "encodeTaggedEnum", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;I)V", "inlineDescriptor", "Lkotlinx/serialization/encoding/Encoder;", "encodeTaggedInline", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Encoder;", "encodeInline", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Encoder;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "beginStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeEncoder;", "endEncode", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "kotlinx/serialization/json/internal/AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1", "inlineUnsignedNumberEncoder", "(Ljava/lang/String;)Lkotlinx/serialization/json/internal/AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1;", "kotlinx/serialization/json/internal/AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1", "inlineUnquotedLiteralEncoder", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/json/internal/AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1;", "Lkotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "Lwe/k;", "getNodeConsumer", "()Lwe/k;", "Lkotlinx/serialization/json/JsonConfiguration;", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "polymorphicDiscriminator", "Ljava/lang/String;", "polymorphicSerialName", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "Lkotlinx/serialization/json/internal/JsonPrimitiveEncoder;", "Lkotlinx/serialization/json/internal/JsonTreeEncoder;", "Lkotlinx/serialization/json/internal/JsonTreeListEncoder;", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
abstract class AbstractJsonTreeEncoder extends NamedValueEncoder implements JsonEncoder {
    @NotNull
    protected final JsonConfiguration configuration;
    @NotNull
    private final Json json;
    @NotNull
    private final k nodeConsumer;
    @Nullable
    private String polymorphicDiscriminator;
    @Nullable
    private String polymorphicSerialName;

    private AbstractJsonTreeEncoder(Json json0, k k0) {
        this.json = json0;
        this.nodeConsumer = k0;
        this.configuration = json0.getConfiguration();
    }

    public AbstractJsonTreeEncoder(Json json0, k k0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(json0, k0);
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    @NotNull
    public CompositeEncoder beginStructure(@NotNull SerialDescriptor serialDescriptor0) {
        CompositeEncoder compositeEncoder0;
        q.g(serialDescriptor0, "descriptor");
        k k0 = this.getCurrentTagOrNull() == null ? this.nodeConsumer : new a(this);
        SerialKind serialKind0 = serialDescriptor0.getKind();
        if(q.b(serialKind0, LIST.INSTANCE) || serialKind0 instanceof PolymorphicKind) {
            compositeEncoder0 = new JsonTreeListEncoder(this.json, k0);
        }
        else if(q.b(serialKind0, MAP.INSTANCE)) {
            Json json0 = this.json;
            SerialDescriptor serialDescriptor1 = WriteModeKt.carrierDescriptor(serialDescriptor0.getElementDescriptor(0), json0.getSerializersModule());
            SerialKind serialKind1 = serialDescriptor1.getKind();
            if(serialKind1 instanceof PrimitiveKind || q.b(serialKind1, ENUM.INSTANCE)) {
                compositeEncoder0 = new JsonTreeMapEncoder(this.json, k0);
            }
            else {
                if(!json0.getConfiguration().getAllowStructuredMapKeys()) {
                    throw JsonExceptionsKt.InvalidKeyKindException(serialDescriptor1);
                }
                compositeEncoder0 = new JsonTreeListEncoder(this.json, k0);
            }
        }
        else {
            compositeEncoder0 = new JsonTreeEncoder(this.json, k0);
        }
        String s = this.polymorphicDiscriminator;
        if(s != null) {
            if(compositeEncoder0 instanceof JsonTreeMapEncoder) {
                ((JsonTreeMapEncoder)compositeEncoder0).putElement("key", JsonElementKt.JsonPrimitive(s));
                ((JsonTreeMapEncoder)compositeEncoder0).putElement("value", JsonElementKt.JsonPrimitive((this.polymorphicSerialName == null ? serialDescriptor0.getSerialName() : this.polymorphicSerialName)));
            }
            else {
                ((AbstractJsonTreeEncoder)compositeEncoder0).putElement(s, JsonElementKt.JsonPrimitive((this.polymorphicSerialName == null ? serialDescriptor0.getSerialName() : this.polymorphicSerialName)));
            }
            this.polymorphicDiscriminator = null;
            this.polymorphicSerialName = null;
        }
        return compositeEncoder0;
    }

    private static final H beginStructure$lambda$2(AbstractJsonTreeEncoder abstractJsonTreeEncoder0, JsonElement jsonElement0) {
        q.g(jsonElement0, "node");
        abstractJsonTreeEncoder0.putElement(((String)abstractJsonTreeEncoder0.getCurrentTag()), jsonElement0);
        return H.a;
    }

    @Override  // kotlinx.serialization.internal.NamedValueEncoder
    @NotNull
    public String composeName(@NotNull String s, @NotNull String s1) {
        q.g(s, "parentName");
        q.g(s1, "childName");
        return s1;
    }

    @Override  // kotlinx.serialization.internal.NamedValueEncoder
    @NotNull
    public String elementName(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return JsonNamesMapKt.getJsonElementName(serialDescriptor0, this.json, v);
    }

    @Override  // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder
    @NotNull
    public Encoder encodeInline(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
        if(this.getCurrentTagOrNull() != null) {
            if(this.polymorphicDiscriminator != null) {
                this.polymorphicSerialName = serialDescriptor0.getSerialName();
            }
            return super.encodeInline(serialDescriptor0);
        }
        return new JsonPrimitiveEncoder(this.json, this.nodeConsumer).encodeInline(serialDescriptor0);
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    public void encodeNotNullMark() {
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    public void encodeNull() {
        String s = (String)this.getCurrentTagOrNull();
        if(s == null) {
            this.nodeConsumer.invoke(JsonNull.INSTANCE);
            return;
        }
        this.encodeTaggedNull(s);
    }

    @Override  // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeSerializableValue(@NotNull SerializationStrategy serializationStrategy0, Object object0) {
        String s;
        q.g(serializationStrategy0, "serializer");
        if(this.getCurrentTagOrNull() == null && TreeJsonEncoderKt.access$getRequiresTopLevelTag(WriteModeKt.carrierDescriptor(serializationStrategy0.getDescriptor(), this.getSerializersModule()))) {
            new JsonPrimitiveEncoder(this.json, this.nodeConsumer).encodeSerializableValue(serializationStrategy0, object0);
            return;
        }
        if(this.getJson().getConfiguration().getUseArrayPolymorphism()) {
            serializationStrategy0.serialize(this, object0);
            return;
        }
        if(!(serializationStrategy0 instanceof AbstractPolymorphicSerializer)) {
            switch(WhenMappings.$EnumSwitchMapping$0[this.getJson().getConfiguration().getClassDiscriminatorMode().ordinal()]) {
                case 1: 
                case 2: {
                    s = null;
                    break;
                }
                case 3: {
                    SerialKind serialKind0 = serializationStrategy0.getDescriptor().getKind();
                    s = !q.b(serialKind0, CLASS.INSTANCE) && !q.b(serialKind0, OBJECT.INSTANCE) ? null : PolymorphicKt.classDiscriminator(serializationStrategy0.getDescriptor(), this.getJson());
                    break;
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
        }
        else if(this.getJson().getConfiguration().getClassDiscriminatorMode() != ClassDiscriminatorMode.NONE) {
            s = PolymorphicKt.classDiscriminator(serializationStrategy0.getDescriptor(), this.getJson());
        }
        else {
            s = null;
        }
        if(serializationStrategy0 instanceof AbstractPolymorphicSerializer) {
            if(object0 == null) {
                throw new IllegalArgumentException(("Value for serializer " + ((AbstractPolymorphicSerializer)serializationStrategy0).getDescriptor() + " should always be non-null. Please report issue to the kotlinx.serialization tracker.").toString());
            }
            SerializationStrategy serializationStrategy1 = PolymorphicSerializerKt.findPolymorphicSerializer(((AbstractPolymorphicSerializer)serializationStrategy0), this, object0);
            if(s != null) {
                PolymorphicKt.access$validateIfSealed(serializationStrategy0, serializationStrategy1, s);
            }
            PolymorphicKt.checkKind(serializationStrategy1.getDescriptor().getKind());
            serializationStrategy0 = serializationStrategy1;
        }
        if(s != null) {
            String s1 = serializationStrategy0.getDescriptor().getSerialName();
            this.polymorphicDiscriminator = s;
            this.polymorphicSerialName = s1;
        }
        serializationStrategy0.serialize(this, object0);
    }

    @Override  // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedBoolean(Object object0, boolean z) {
        this.encodeTaggedBoolean(((String)object0), z);
    }

    public void encodeTaggedBoolean(@NotNull String s, boolean z) {
        q.g(s, "tag");
        this.putElement(s, JsonElementKt.JsonPrimitive(Boolean.valueOf(z)));
    }

    @Override  // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedByte(Object object0, byte b) {
        this.encodeTaggedByte(((String)object0), b);
    }

    public void encodeTaggedByte(@NotNull String s, byte b) {
        q.g(s, "tag");
        this.putElement(s, JsonElementKt.JsonPrimitive(b));
    }

    @Override  // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedChar(Object object0, char c) {
        this.encodeTaggedChar(((String)object0), c);
    }

    public void encodeTaggedChar(@NotNull String s, char c) {
        q.g(s, "tag");
        this.putElement(s, JsonElementKt.JsonPrimitive(String.valueOf(c)));
    }

    @Override  // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedDouble(Object object0, double f) {
        this.encodeTaggedDouble(((String)object0), f);
    }

    public void encodeTaggedDouble(@NotNull String s, double f) {
        q.g(s, "tag");
        this.putElement(s, JsonElementKt.JsonPrimitive(f));
        if(!this.configuration.getAllowSpecialFloatingPointValues() && (Double.isInfinite(f) || Double.isNaN(f))) {
            throw JsonExceptionsKt.InvalidFloatingPointEncoded(f, s, this.getCurrent().toString());
        }
    }

    @Override  // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedEnum(Object object0, SerialDescriptor serialDescriptor0, int v) {
        this.encodeTaggedEnum(((String)object0), serialDescriptor0, v);
    }

    public void encodeTaggedEnum(@NotNull String s, @NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(s, "tag");
        q.g(serialDescriptor0, "enumDescriptor");
        this.putElement(s, JsonElementKt.JsonPrimitive(serialDescriptor0.getElementName(v)));
    }

    @Override  // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedFloat(Object object0, float f) {
        this.encodeTaggedFloat(((String)object0), f);
    }

    public void encodeTaggedFloat(@NotNull String s, float f) {
        q.g(s, "tag");
        this.putElement(s, JsonElementKt.JsonPrimitive(f));
        if(!this.configuration.getAllowSpecialFloatingPointValues() && (Float.isInfinite(f) || Float.isNaN(f))) {
            throw JsonExceptionsKt.InvalidFloatingPointEncoded(f, s, this.getCurrent().toString());
        }
    }

    @Override  // kotlinx.serialization.internal.TaggedEncoder
    public Encoder encodeTaggedInline(Object object0, SerialDescriptor serialDescriptor0) {
        return this.encodeTaggedInline(((String)object0), serialDescriptor0);
    }

    @NotNull
    public Encoder encodeTaggedInline(@NotNull String s, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(s, "tag");
        q.g(serialDescriptor0, "inlineDescriptor");
        if(StreamingJsonEncoderKt.isUnsignedNumber(serialDescriptor0)) {
            return this.inlineUnsignedNumberEncoder(s);
        }
        return StreamingJsonEncoderKt.isUnquotedLiteral(serialDescriptor0) ? this.inlineUnquotedLiteralEncoder(s, serialDescriptor0) : super.encodeTaggedInline(s, serialDescriptor0);
    }

    @Override  // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedInt(Object object0, int v) {
        this.encodeTaggedInt(((String)object0), v);
    }

    public void encodeTaggedInt(@NotNull String s, int v) {
        q.g(s, "tag");
        this.putElement(s, JsonElementKt.JsonPrimitive(v));
    }

    @Override  // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedLong(Object object0, long v) {
        this.encodeTaggedLong(((String)object0), v);
    }

    public void encodeTaggedLong(@NotNull String s, long v) {
        q.g(s, "tag");
        this.putElement(s, JsonElementKt.JsonPrimitive(v));
    }

    public void encodeTaggedNull(@NotNull String s) {
        q.g(s, "tag");
        this.putElement(s, JsonNull.INSTANCE);
    }

    @Override  // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedShort(Object object0, short v) {
        this.encodeTaggedShort(((String)object0), v);
    }

    public void encodeTaggedShort(@NotNull String s, short v) {
        q.g(s, "tag");
        this.putElement(s, JsonElementKt.JsonPrimitive(v));
    }

    @Override  // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedString(Object object0, String s) {
        this.encodeTaggedString(((String)object0), s);
    }

    public void encodeTaggedString(@NotNull String s, @NotNull String s1) {
        q.g(s, "tag");
        q.g(s1, "value");
        this.putElement(s, JsonElementKt.JsonPrimitive(s1));
    }

    @Override  // kotlinx.serialization.internal.TaggedEncoder
    public void endEncode(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
        JsonElement jsonElement0 = this.getCurrent();
        this.nodeConsumer.invoke(jsonElement0);
    }

    @NotNull
    public abstract JsonElement getCurrent();

    @Override  // kotlinx.serialization.json.JsonEncoder
    @NotNull
    public final Json getJson() {
        return this.json;
    }

    @NotNull
    public final k getNodeConsumer() {
        return this.nodeConsumer;
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    @NotNull
    public final SerializersModule getSerializersModule() {
        return this.json.getSerializersModule();
    }

    private final kotlinx.serialization.json.internal.AbstractJsonTreeEncoder.inlineUnquotedLiteralEncoder.1 inlineUnquotedLiteralEncoder(String s, SerialDescriptor serialDescriptor0) {
        return new AbstractEncoder() {
            @Override  // kotlinx.serialization.encoding.AbstractEncoder
            public void encodeString(String s) {
                q.g(s, "value");
                JsonLiteral jsonLiteral0 = new JsonLiteral(s, false, this.$inlineDescriptor);
                s.putElement(serialDescriptor0, jsonLiteral0);
            }

            @Override  // kotlinx.serialization.encoding.Encoder
            public SerializersModule getSerializersModule() {
                return s.getJson().getSerializersModule();
            }
        };
    }

    private final kotlinx.serialization.json.internal.AbstractJsonTreeEncoder.inlineUnsignedNumberEncoder.1 inlineUnsignedNumberEncoder(String s) {
        return new AbstractEncoder() {
            private final SerializersModule serializersModule;

            {
                AbstractJsonTreeEncoder abstractJsonTreeEncoder0 = s;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                this.serializersModule = abstractJsonTreeEncoder0.getJson().getSerializersModule();
            }

            @Override  // kotlinx.serialization.encoding.AbstractEncoder
            public void encodeByte(byte b) {
                this.putUnquotedString(String.valueOf(b & 0xFF));
            }

            @Override  // kotlinx.serialization.encoding.AbstractEncoder
            public void encodeInt(int v) {
                this.putUnquotedString(Integer.toUnsignedString(v));
            }

            @Override  // kotlinx.serialization.encoding.AbstractEncoder
            public void encodeLong(long v) {
                this.putUnquotedString(Long.toUnsignedString(v));
            }

            @Override  // kotlinx.serialization.encoding.AbstractEncoder
            public void encodeShort(short v) {
                this.putUnquotedString(String.valueOf(v & 0xFFFF));
            }

            @Override  // kotlinx.serialization.encoding.Encoder
            public SerializersModule getSerializersModule() {
                return this.serializersModule;
            }

            public final void putUnquotedString(String s) {
                q.g(s, "s");
                JsonLiteral jsonLiteral0 = new JsonLiteral(s, false, null, 4, null);
                s.putElement(this.$tag, jsonLiteral0);
            }
        };
    }

    public abstract void putElement(@NotNull String arg1, @NotNull JsonElement arg2);

    @Override  // kotlinx.serialization.encoding.CompositeEncoder
    public boolean shouldEncodeElementDefault(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return this.configuration.getEncodeDefaults();
    }
}

