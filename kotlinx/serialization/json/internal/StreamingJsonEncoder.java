package kotlinx.serialization.json.internal;

import i.n.i.b.a.s.e.M3;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind.CLASS;
import kotlinx.serialization.descriptors.StructureKind.OBJECT;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.json.ClassDiscriminatorMode;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00B2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\u0010\u0010\n\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t\u00A2\u0006\u0004\b\u000B\u0010\fB1\b\u0010\u0012\u0006\u0010\u000E\u001A\u00020\r\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\u000E\u0010\n\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u00A2\u0006\u0004\b\u000B\u0010\u000FJ\u001F\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u0010H\u0002\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u001F\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u0018H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ+\u0010!\u001A\u00020\u0013\"\u0004\b\u0000\u0010\u001D2\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u00028\u00000\u001E2\u0006\u0010 \u001A\u00028\u0000H\u0016\u00A2\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001A\u00020#2\u0006\u0010\u0017\u001A\u00020\u0016H\u0016\u00A2\u0006\u0004\b$\u0010%J\u0017\u0010&\u001A\u00020\u00132\u0006\u0010\u0017\u001A\u00020\u0016H\u0016\u00A2\u0006\u0004\b&\u0010\'J\u001F\u0010(\u001A\u00020\u001A2\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u0018H\u0016\u00A2\u0006\u0004\b(\u0010\u001CJA\u0010*\u001A\u00020\u0013\"\b\b\u0000\u0010\u001D*\u00020)2\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u00182\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u00028\u00000\u001E2\b\u0010 \u001A\u0004\u0018\u00018\u0000H\u0016\u00A2\u0006\u0004\b*\u0010+J\u0017\u0010-\u001A\u00020,2\u0006\u0010\u0017\u001A\u00020\u0016H\u0016\u00A2\u0006\u0004\b-\u0010.J\u000F\u0010/\u001A\u00020\u0013H\u0016\u00A2\u0006\u0004\b/\u00100J\u0017\u00101\u001A\u00020\u00132\u0006\u0010 \u001A\u00020\u001AH\u0016\u00A2\u0006\u0004\b1\u00102J\u0017\u00104\u001A\u00020\u00132\u0006\u0010 \u001A\u000203H\u0016\u00A2\u0006\u0004\b4\u00105J\u0017\u00107\u001A\u00020\u00132\u0006\u0010 \u001A\u000206H\u0016\u00A2\u0006\u0004\b7\u00108J\u0017\u00109\u001A\u00020\u00132\u0006\u0010 \u001A\u00020\u0018H\u0016\u00A2\u0006\u0004\b9\u0010:J\u0017\u0010<\u001A\u00020\u00132\u0006\u0010 \u001A\u00020;H\u0016\u00A2\u0006\u0004\b<\u0010=J\u0017\u0010?\u001A\u00020\u00132\u0006\u0010 \u001A\u00020>H\u0016\u00A2\u0006\u0004\b?\u0010@J\u0017\u0010B\u001A\u00020\u00132\u0006\u0010 \u001A\u00020AH\u0016\u00A2\u0006\u0004\bB\u0010CJ\u0017\u0010E\u001A\u00020\u00132\u0006\u0010 \u001A\u00020DH\u0016\u00A2\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001A\u00020\u00132\u0006\u0010 \u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\bG\u0010HJ\u001F\u0010J\u001A\u00020\u00132\u0006\u0010I\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u0018H\u0016\u00A2\u0006\u0004\bJ\u0010KR\u0014\u0010\u0004\u001A\u00020\u00038\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0004\u0010LR\u001A\u0010\u0006\u001A\u00020\u00058\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0006\u0010M\u001A\u0004\bN\u0010OR\u0014\u0010\b\u001A\u00020\u00078\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\b\u0010PR\u001E\u0010\n\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\n\u0010QR\u001A\u0010S\u001A\u00020R8\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\bS\u0010T\u001A\u0004\bU\u0010VR\u0014\u0010X\u001A\u00020W8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010Z\u001A\u00020\u001A8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010\\\u001A\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010^\u001A\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b^\u0010]\u00A8\u0006_"}, d2 = {"Lkotlinx/serialization/json/internal/StreamingJsonEncoder;", "Lkotlinx/serialization/json/JsonEncoder;", "Lkotlinx/serialization/encoding/AbstractEncoder;", "Lkotlinx/serialization/json/internal/Composer;", "composer", "Lkotlinx/serialization/json/Json;", "json", "Lkotlinx/serialization/json/internal/WriteMode;", "mode", "", "modeReuseCache", "<init>", "(Lkotlinx/serialization/json/internal/Composer;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;[Lkotlinx/serialization/json/JsonEncoder;)V", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "output", "(Lkotlinx/serialization/json/internal/InternalJsonWriter;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;[Lkotlinx/serialization/json/JsonEncoder;)V", "", "discriminator", "serialName", "Lie/H;", "encodeTypeInfo", "(Ljava/lang/String;Ljava/lang/String;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "index", "", "shouldEncodeElementDefault", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "T", "Lkotlinx/serialization/SerializationStrategy;", "serializer", "value", "encodeSerializableValue", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "Lkotlinx/serialization/encoding/CompositeEncoder;", "beginStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeEncoder;", "endStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "encodeElement", "", "encodeNullableSerializableElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "Lkotlinx/serialization/encoding/Encoder;", "encodeInline", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Encoder;", "encodeNull", "()V", "encodeBoolean", "(Z)V", "", "encodeByte", "(B)V", "", "encodeShort", "(S)V", "encodeInt", "(I)V", "", "encodeLong", "(J)V", "", "encodeFloat", "(F)V", "", "encodeDouble", "(D)V", "", "encodeChar", "(C)V", "encodeString", "(Ljava/lang/String;)V", "enumDescriptor", "encodeEnum", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)V", "Lkotlinx/serialization/json/internal/Composer;", "Lkotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "Lkotlinx/serialization/json/internal/WriteMode;", "[Lkotlinx/serialization/json/JsonEncoder;", "Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "Lkotlinx/serialization/json/JsonConfiguration;", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "forceQuoting", "Z", "polymorphicDiscriminator", "Ljava/lang/String;", "polymorphicSerialName", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class StreamingJsonEncoder extends AbstractEncoder implements JsonEncoder {
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 0x30)
    public abstract class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[WriteMode.values().length];
            try {
                arr_v[WriteMode.LIST.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[WriteMode.MAP.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[WriteMode.POLY_OBJ.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    @NotNull
    private final Composer composer;
    @NotNull
    private final JsonConfiguration configuration;
    private boolean forceQuoting;
    @NotNull
    private final Json json;
    @NotNull
    private final WriteMode mode;
    @Nullable
    private final JsonEncoder[] modeReuseCache;
    @Nullable
    private String polymorphicDiscriminator;
    @Nullable
    private String polymorphicSerialName;
    @NotNull
    private final SerializersModule serializersModule;

    public StreamingJsonEncoder(@NotNull Composer composer0, @NotNull Json json0, @NotNull WriteMode writeMode0, @Nullable JsonEncoder[] arr_jsonEncoder) {
        q.g(composer0, "composer");
        q.g(json0, "json");
        q.g(writeMode0, "mode");
        super();
        this.composer = composer0;
        this.json = json0;
        this.mode = writeMode0;
        this.modeReuseCache = arr_jsonEncoder;
        this.serializersModule = this.getJson().getSerializersModule();
        this.configuration = this.getJson().getConfiguration();
        int v = writeMode0.ordinal();
        if(arr_jsonEncoder != null && (arr_jsonEncoder[v] != null || null != this)) {
            arr_jsonEncoder[v] = this;
        }
    }

    public StreamingJsonEncoder(@NotNull InternalJsonWriter internalJsonWriter0, @NotNull Json json0, @NotNull WriteMode writeMode0, @NotNull JsonEncoder[] arr_jsonEncoder) {
        q.g(internalJsonWriter0, "output");
        q.g(json0, "json");
        q.g(writeMode0, "mode");
        q.g(arr_jsonEncoder, "modeReuseCache");
        this(ComposersKt.Composer(internalJsonWriter0, json0), json0, writeMode0, arr_jsonEncoder);
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    @NotNull
    public CompositeEncoder beginStructure(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
        WriteMode writeMode0 = WriteModeKt.switchMode(this.getJson(), serialDescriptor0);
        int v = writeMode0.begin;
        if(v != 0) {
            this.composer.print(((char)v));
            this.composer.indent();
        }
        String s = this.polymorphicDiscriminator;
        if(s != null) {
            this.encodeTypeInfo(s, (this.polymorphicSerialName == null ? serialDescriptor0.getSerialName() : this.polymorphicSerialName));
            this.polymorphicDiscriminator = null;
            this.polymorphicSerialName = null;
        }
        if(this.mode == writeMode0) {
            return this;
        }
        JsonEncoder[] arr_jsonEncoder = this.modeReuseCache;
        if(arr_jsonEncoder != null) {
            CompositeEncoder compositeEncoder0 = arr_jsonEncoder[writeMode0.ordinal()];
            if(compositeEncoder0 != null) {
                return compositeEncoder0;
            }
        }
        return new StreamingJsonEncoder(this.composer, this.getJson(), writeMode0, this.modeReuseCache);
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeBoolean(boolean z) {
        if(this.forceQuoting) {
            this.encodeString(String.valueOf(z));
            return;
        }
        this.composer.print(z);
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeByte(byte b) {
        if(this.forceQuoting) {
            this.encodeString(String.valueOf(b));
            return;
        }
        this.composer.print(b);
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeChar(char c) {
        this.encodeString(String.valueOf(c));
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeDouble(double f) {
        if(this.forceQuoting) {
            this.encodeString(String.valueOf(f));
        }
        else {
            this.composer.print(f);
        }
        if(!this.configuration.getAllowSpecialFloatingPointValues() && (Double.isInfinite(f) || Double.isNaN(f))) {
            throw JsonExceptionsKt.InvalidFloatingPointEncoded(f, this.composer.writer.toString());
        }
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder
    public boolean encodeElement(@NotNull SerialDescriptor serialDescriptor0, int v) {
        boolean z = false;
        q.g(serialDescriptor0, "descriptor");
        int v1 = WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()];
        if(v1 == 1) {
            if(!this.composer.getWritingFirst()) {
                this.composer.print(',');
            }
            this.composer.nextItem();
        }
        else {
            switch(v1) {
                case 2: {
                    if(!this.composer.getWritingFirst()) {
                        if(v % 2 == 0) {
                            this.composer.print(',');
                            this.composer.nextItem();
                            z = true;
                        }
                        else {
                            this.composer.print(':');
                            this.composer.space();
                        }
                        this.forceQuoting = z;
                        return true;
                    }
                    this.forceQuoting = true;
                    this.composer.nextItem();
                    return true;
                }
                case 3: {
                    if(v == 0) {
                        this.forceQuoting = true;
                    }
                    break;
                }
                default: {
                    if(!this.composer.getWritingFirst()) {
                        this.composer.print(',');
                    }
                    this.composer.nextItem();
                    this.encodeString(JsonNamesMapKt.getJsonElementName(serialDescriptor0, this.getJson(), v));
                    this.composer.print(':');
                    this.composer.space();
                    return true;
                }
            }
            if(v == 1) {
                this.composer.print(',');
                this.composer.space();
                this.forceQuoting = false;
                return true;
            }
        }
        return true;
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeEnum(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "enumDescriptor");
        this.encodeString(serialDescriptor0.getElementName(v));
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeFloat(float f) {
        if(this.forceQuoting) {
            this.encodeString(String.valueOf(f));
        }
        else {
            this.composer.print(f);
        }
        if(!this.configuration.getAllowSpecialFloatingPointValues() && (Float.isInfinite(f) || Float.isNaN(f))) {
            throw JsonExceptionsKt.InvalidFloatingPointEncoded(f, this.composer.writer.toString());
        }
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    @NotNull
    public Encoder encodeInline(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
        if(StreamingJsonEncoderKt.isUnsignedNumber(serialDescriptor0)) {
            Composer composer0 = this.composer;
            if(!(composer0 instanceof ComposerForUnsignedNumbers)) {
                composer0 = new ComposerForUnsignedNumbers(composer0.writer, this.forceQuoting);
            }
            return new StreamingJsonEncoder(composer0, this.getJson(), this.mode, null);
        }
        if(StreamingJsonEncoderKt.isUnquotedLiteral(serialDescriptor0)) {
            Composer composer1 = this.composer;
            if(!(composer1 instanceof ComposerForUnquotedLiterals)) {
                composer1 = new ComposerForUnquotedLiterals(composer1.writer, this.forceQuoting);
            }
            return new StreamingJsonEncoder(composer1, this.getJson(), this.mode, null);
        }
        if(this.polymorphicDiscriminator != null) {
            this.polymorphicSerialName = serialDescriptor0.getSerialName();
            return this;
        }
        return super.encodeInline(serialDescriptor0);
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeInt(int v) {
        if(this.forceQuoting) {
            this.encodeString(String.valueOf(v));
            return;
        }
        this.composer.print(v);
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeLong(long v) {
        if(this.forceQuoting) {
            this.encodeString(String.valueOf(v));
            return;
        }
        this.composer.print(v);
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeNull() {
        this.composer.print("null");
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public void encodeNullableSerializableElement(@NotNull SerialDescriptor serialDescriptor0, int v, @NotNull SerializationStrategy serializationStrategy0, @Nullable Object object0) {
        q.g(serialDescriptor0, "descriptor");
        q.g(serializationStrategy0, "serializer");
        if(object0 == null && !this.configuration.getExplicitNulls()) {
            return;
        }
        super.encodeNullableSerializableElement(serialDescriptor0, v, serializationStrategy0, object0);
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeSerializableValue(@NotNull SerializationStrategy serializationStrategy0, Object object0) {
        String s;
        q.g(serializationStrategy0, "serializer");
        if(this.getJson().getConfiguration().getUseArrayPolymorphism()) {
            serializationStrategy0.serialize(this, object0);
            return;
        }
        if(!(serializationStrategy0 instanceof AbstractPolymorphicSerializer)) {
            switch(this.getJson().getConfiguration().getClassDiscriminatorMode()) {
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
                PolymorphicKt.validateIfSealed(serializationStrategy0, serializationStrategy1, s);
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

    @Override  // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeShort(short v) {
        if(this.forceQuoting) {
            this.encodeString(String.valueOf(v));
            return;
        }
        this.composer.print(v);
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeString(@NotNull String s) {
        q.g(s, "value");
        this.composer.printQuoted(s);
    }

    private final void encodeTypeInfo(String s, String s1) {
        this.composer.nextItem();
        this.encodeString(s);
        this.composer.print(':');
        this.composer.space();
        this.encodeString(s1);
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public void endStructure(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
        if(this.mode.end != 0) {
            this.composer.unIndent();
            this.composer.nextItemIfNotFirst();
            this.composer.print(this.mode.end);
        }
    }

    @Override  // kotlinx.serialization.json.JsonEncoder
    @NotNull
    public Json getJson() {
        return this.json;
    }

    @Override  // kotlinx.serialization.encoding.Encoder
    @NotNull
    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    @Override  // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public boolean shouldEncodeElementDefault(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        return this.configuration.getEncodeDefaults();
    }
}

