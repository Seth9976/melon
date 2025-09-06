package kotlinx.serialization.json.internal;

import Tf.o;
import i.n.i.b.a.s.e.M3;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind.ENUM;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00C0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001jB1\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\b\u0012\u0006\u0010\u000B\u001A\u00020\n\u0012\b\u0010\r\u001A\u0004\u0018\u00010\f\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0011\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0016\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u00132\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u000B\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0017\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u000B\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u000F\u0010\u001F\u001A\u00020\u001EH\u0016\u00A2\u0006\u0004\b\u001F\u0010 J\u0011\u0010\"\u001A\u0004\u0018\u00010!H\u0016\u00A2\u0006\u0004\b\"\u0010#J=\u0010\'\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u00132\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010%\u001A\u00020$2\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00028\u00000\u00142\b\u0010&\u001A\u0004\u0018\u00018\u0000H\u0016\u00A2\u0006\u0004\b\'\u0010(J\u0017\u0010)\u001A\u00020$2\u0006\u0010\u000B\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b)\u0010*J\u000F\u0010+\u001A\u00020\u001EH\u0016\u00A2\u0006\u0004\b+\u0010 J\u000F\u0010-\u001A\u00020,H\u0016\u00A2\u0006\u0004\b-\u0010.J\u000F\u00100\u001A\u00020/H\u0016\u00A2\u0006\u0004\b0\u00101J\u000F\u00102\u001A\u00020$H\u0016\u00A2\u0006\u0004\b2\u00103J\u000F\u00105\u001A\u000204H\u0016\u00A2\u0006\u0004\b5\u00106J\u000F\u00108\u001A\u000207H\u0016\u00A2\u0006\u0004\b8\u00109J\u000F\u0010;\u001A\u00020:H\u0016\u00A2\u0006\u0004\b;\u0010<J\u000F\u0010>\u001A\u00020=H\u0016\u00A2\u0006\u0004\b>\u0010?J\u000F\u0010A\u001A\u00020@H\u0016\u00A2\u0006\u0004\bA\u0010BJ\u0017\u0010D\u001A\u00020C2\u0006\u0010\u000B\u001A\u00020\nH\u0016\u00A2\u0006\u0004\bD\u0010EJ\u0017\u0010G\u001A\u00020$2\u0006\u0010F\u001A\u00020\nH\u0016\u00A2\u0006\u0004\bG\u0010*J\u001D\u0010I\u001A\u00020\u001E*\u0004\u0018\u00010\f2\u0006\u0010H\u001A\u00020@H\u0002\u00A2\u0006\u0004\bI\u0010JJ\u0017\u0010K\u001A\u00020\u001B2\u0006\u0010\u000B\u001A\u00020\nH\u0002\u00A2\u0006\u0004\bK\u0010\u001DJ\u000F\u0010L\u001A\u00020\u001BH\u0002\u00A2\u0006\u0004\bL\u0010MJ\u000F\u0010N\u001A\u00020$H\u0002\u00A2\u0006\u0004\bN\u00103J\u001F\u0010O\u001A\u00020\u001E2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010%\u001A\u00020$H\u0002\u00A2\u0006\u0004\bO\u0010PJ\u0017\u0010Q\u001A\u00020$2\u0006\u0010\u000B\u001A\u00020\nH\u0002\u00A2\u0006\u0004\bQ\u0010*J\u0017\u0010S\u001A\u00020\u001E2\u0006\u0010R\u001A\u00020@H\u0002\u00A2\u0006\u0004\bS\u0010TJ\u000F\u0010U\u001A\u00020$H\u0002\u00A2\u0006\u0004\bU\u00103J\u000F\u0010V\u001A\u00020@H\u0002\u00A2\u0006\u0004\bV\u0010BR\u0017\u0010\u0005\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010W\u001A\u0004\bX\u0010YR\u0014\u0010\u0007\u001A\u00020\u00068\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0007\u0010ZR\u0014\u0010\t\u001A\u00020\b8\u0000X\u0081\u0004\u00A2\u0006\u0006\n\u0004\b\t\u0010[R\u001A\u0010]\u001A\u00020\\8\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b]\u0010^\u001A\u0004\b_\u0010`R\u0016\u0010a\u001A\u00020$8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010\r\u001A\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\r\u0010cR\u0014\u0010e\u001A\u00020d8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010h\u001A\u0004\u0018\u00010g8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bh\u0010i\u00A8\u0006k"}, d2 = {"Lkotlinx/serialization/json/internal/StreamingJsonDecoder;", "Lkotlinx/serialization/json/JsonDecoder;", "", "Lkotlinx/serialization/encoding/AbstractDecoder;", "Lkotlinx/serialization/json/Json;", "json", "Lkotlinx/serialization/json/internal/WriteMode;", "mode", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "lexer", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/json/internal/StreamingJsonDecoder$DiscriminatorHolder;", "discriminatorHolder", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;Lkotlinx/serialization/json/internal/AbstractJsonLexer;Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/json/internal/StreamingJsonDecoder$DiscriminatorHolder;)V", "Lkotlinx/serialization/json/JsonElement;", "decodeJsonElement", "()Lkotlinx/serialization/json/JsonElement;", "T", "Lkotlinx/serialization/DeserializationStrategy;", "deserializer", "decodeSerializableValue", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "beginStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeDecoder;", "Lie/H;", "endStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "decodeNotNullMark", "()Z", "", "decodeNull", "()Ljava/lang/Void;", "", "index", "previousValue", "decodeSerializableElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeElementIndex", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "decodeBoolean", "", "decodeByte", "()B", "", "decodeShort", "()S", "decodeInt", "()I", "", "decodeLong", "()J", "", "decodeFloat", "()F", "", "decodeDouble", "()D", "", "decodeChar", "()C", "", "decodeString", "()Ljava/lang/String;", "Lkotlinx/serialization/encoding/Decoder;", "decodeInline", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", "enumDescriptor", "decodeEnum", "unknownKey", "trySkip", "(Lkotlinx/serialization/json/internal/StreamingJsonDecoder$DiscriminatorHolder;Ljava/lang/String;)Z", "skipLeftoverElements", "checkLeadingComma", "()V", "decodeMapIndex", "coerceInputValue", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "decodeObjectIndex", "key", "handleUnknown", "(Ljava/lang/String;)Z", "decodeListIndex", "decodeStringKey", "Lkotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "Lkotlinx/serialization/json/internal/WriteMode;", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "currentIndex", "I", "Lkotlinx/serialization/json/internal/StreamingJsonDecoder$DiscriminatorHolder;", "Lkotlinx/serialization/json/JsonConfiguration;", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "Lkotlinx/serialization/json/internal/JsonElementMarker;", "elementMarker", "Lkotlinx/serialization/json/internal/JsonElementMarker;", "DiscriminatorHolder", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public class StreamingJsonDecoder extends AbstractDecoder implements JsonDecoder {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001A\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlinx/serialization/json/internal/StreamingJsonDecoder$DiscriminatorHolder;", "", "discriminatorToSkip", "", "<init>", "(Ljava/lang/String;)V", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
    public static final class DiscriminatorHolder {
        @Nullable
        public String discriminatorToSkip;

        public DiscriminatorHolder(@Nullable String s) {
            this.discriminatorToSkip = s;
        }
    }

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
            try {
                arr_v[WriteMode.OBJ.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    @NotNull
    private final JsonConfiguration configuration;
    private int currentIndex;
    @Nullable
    private DiscriminatorHolder discriminatorHolder;
    @Nullable
    private final JsonElementMarker elementMarker;
    @NotNull
    private final Json json;
    @NotNull
    public final AbstractJsonLexer lexer;
    @NotNull
    private final WriteMode mode;
    @NotNull
    private final SerializersModule serializersModule;

    public StreamingJsonDecoder(@NotNull Json json0, @NotNull WriteMode writeMode0, @NotNull AbstractJsonLexer abstractJsonLexer0, @NotNull SerialDescriptor serialDescriptor0, @Nullable DiscriminatorHolder streamingJsonDecoder$DiscriminatorHolder0) {
        q.g(json0, "json");
        q.g(writeMode0, "mode");
        q.g(abstractJsonLexer0, "lexer");
        q.g(serialDescriptor0, "descriptor");
        super();
        this.json = json0;
        this.mode = writeMode0;
        this.lexer = abstractJsonLexer0;
        this.serializersModule = json0.getSerializersModule();
        this.currentIndex = -1;
        this.discriminatorHolder = streamingJsonDecoder$DiscriminatorHolder0;
        JsonConfiguration jsonConfiguration0 = json0.getConfiguration();
        this.configuration = jsonConfiguration0;
        this.elementMarker = jsonConfiguration0.getExplicitNulls() ? null : new JsonElementMarker(serialDescriptor0);
    }

    @Override  // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    @NotNull
    public CompositeDecoder beginStructure(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
        WriteMode writeMode0 = WriteModeKt.switchMode(this.json, serialDescriptor0);
        this.lexer.path.pushDescriptor(serialDescriptor0);
        this.lexer.consumeNextToken(writeMode0.begin);
        this.checkLeadingComma();
        switch(WhenMappings.$EnumSwitchMapping$0[writeMode0.ordinal()]) {
            case 1: 
            case 2: 
            case 3: {
                return new StreamingJsonDecoder(this.json, writeMode0, this.lexer, serialDescriptor0, this.discriminatorHolder);
            }
            default: {
                return this.mode != writeMode0 || !this.json.getConfiguration().getExplicitNulls() ? new StreamingJsonDecoder(this.json, writeMode0, this.lexer, serialDescriptor0, this.discriminatorHolder) : this;
            }
        }
    }

    private final void checkLeadingComma() {
        if(this.lexer.peekNextToken() != 4) {
            return;
        }
        AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    private final boolean coerceInputValue(SerialDescriptor serialDescriptor0, int v) {
        Json json0 = this.json;
        boolean z = serialDescriptor0.isElementOptional(v);
        SerialDescriptor serialDescriptor1 = serialDescriptor0.getElementDescriptor(v);
        if(z && !serialDescriptor1.isNullable() && this.lexer.tryConsumeNull(true)) {
            return true;
        }
        if(!q.b(serialDescriptor1.getKind(), ENUM.INSTANCE) || serialDescriptor1.isNullable() && this.lexer.tryConsumeNull(false)) {
            return false;
        }
        String s = this.lexer.peekString(this.configuration.isLenient());
        if(s == null) {
            return false;
        }
        if(JsonNamesMapKt.getJsonNameIndex(serialDescriptor1, json0, s) == -3 && (z || !json0.getConfiguration().getExplicitNulls() && serialDescriptor1.isNullable())) {
            this.lexer.consumeString();
            return true;
        }
        return false;
    }

    @Override  // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public boolean decodeBoolean() {
        return this.lexer.consumeBooleanLenient();
    }

    @Override  // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public byte decodeByte() {
        long v = this.lexer.consumeNumericLiteral();
        if(v == ((long)(((byte)(((int)v)))))) {
            return (byte)(((int)v));
        }
        AbstractJsonLexer.fail$default(this.lexer, "Failed to parse byte for input \'" + v + '\'', 0, null, 6, null);
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    @Override  // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public char decodeChar() {
        String s = this.lexer.consumeStringLenient();
        if(s.length() == 1) {
            return s.charAt(0);
        }
        AbstractJsonLexer.fail$default(this.lexer, "Expected single char, but got \'" + s + '\'', 0, null, 6, null);
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    @Override  // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public double decodeDouble() {
        double f;
        AbstractJsonLexer abstractJsonLexer0 = this.lexer;
        String s = abstractJsonLexer0.consumeStringLenient();
        try {
            f = Double.parseDouble(s);
        }
        catch(IllegalArgumentException unused_ex) {
            AbstractJsonLexer.fail$default(abstractJsonLexer0, "Failed to parse type \'double\' for input \'" + s + '\'', 0, null, 6, null);
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        if(this.json.getConfiguration().getAllowSpecialFloatingPointValues() || !Double.isInfinite(f) && !Double.isNaN(f)) {
            return f;
        }
        JsonExceptionsKt.throwInvalidFloatingPointDecoded(this.lexer, f);
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public int decodeElementIndex(@NotNull SerialDescriptor serialDescriptor0) {
        int v;
        q.g(serialDescriptor0, "descriptor");
        switch(WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()]) {
            case 2: {
                v = this.decodeMapIndex();
                break;
            }
            case 4: {
                v = this.decodeObjectIndex(serialDescriptor0);
                break;
            }
            default: {
                v = this.decodeListIndex();
            }
        }
        if(this.mode != WriteMode.MAP) {
            this.lexer.path.updateDescriptorIndex(v);
        }
        return v;
    }

    @Override  // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public int decodeEnum(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "enumDescriptor");
        String s = this.decodeString();
        return JsonNamesMapKt.getJsonNameIndexOrThrow(serialDescriptor0, this.json, s, " at path $");
    }

    @Override  // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public float decodeFloat() {
        float f;
        AbstractJsonLexer abstractJsonLexer0 = this.lexer;
        String s = abstractJsonLexer0.consumeStringLenient();
        try {
            f = Float.parseFloat(s);
        }
        catch(IllegalArgumentException unused_ex) {
            AbstractJsonLexer.fail$default(abstractJsonLexer0, "Failed to parse type \'float\' for input \'" + s + '\'', 0, null, 6, null);
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        if(this.json.getConfiguration().getAllowSpecialFloatingPointValues() || !Float.isInfinite(f) && !Float.isNaN(f)) {
            return f;
        }
        JsonExceptionsKt.throwInvalidFloatingPointDecoded(this.lexer, f);
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    @Override  // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    @NotNull
    public Decoder decodeInline(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
        return StreamingJsonEncoderKt.isUnsignedNumber(serialDescriptor0) ? new JsonDecoderForUnsignedTypes(this.lexer, this.json) : super.decodeInline(serialDescriptor0);
    }

    @Override  // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public int decodeInt() {
        long v = this.lexer.consumeNumericLiteral();
        if(v == ((long)(((int)v)))) {
            return (int)v;
        }
        AbstractJsonLexer.fail$default(this.lexer, "Failed to parse int for input \'" + v + '\'', 0, null, 6, null);
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    @Override  // kotlinx.serialization.json.JsonDecoder
    @NotNull
    public JsonElement decodeJsonElement() {
        return new JsonTreeReader(this.json.getConfiguration(), this.lexer).read();
    }

    private final int decodeListIndex() {
        boolean z = this.lexer.tryConsumeComma();
        if(this.lexer.canConsumeValue()) {
            int v = this.currentIndex;
            if(v != -1 && !z) {
                AbstractJsonLexer.fail$default(this.lexer, "Expected end of the array or comma", 0, null, 6, null);
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            this.currentIndex = v + 1;
            return v + 1;
        }
        if(z && !this.json.getConfiguration().getAllowTrailingComma()) {
            JsonExceptionsKt.invalidTrailingComma(this.lexer, "array");
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return -1;
    }

    @Override  // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public long decodeLong() {
        return this.lexer.consumeNumericLiteral();
    }

    private final int decodeMapIndex() {
        int v = this.currentIndex;
        boolean z = false;
        boolean z1 = v % 2 != 0;
        if(!z1) {
            this.lexer.consumeNextToken(':');
        }
        else if(v != -1) {
            z = this.lexer.tryConsumeComma();
        }
        if(this.lexer.canConsumeValue()) {
            if(z1) {
                if(this.currentIndex == -1) {
                    AbstractJsonLexer abstractJsonLexer0 = this.lexer;
                    int v1 = abstractJsonLexer0.currentPosition;
                    if(z) {
                        AbstractJsonLexer.fail$default(abstractJsonLexer0, "Unexpected leading comma", v1, null, 4, null);
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
                else {
                    AbstractJsonLexer abstractJsonLexer1 = this.lexer;
                    int v2 = abstractJsonLexer1.currentPosition;
                    if(!z) {
                        AbstractJsonLexer.fail$default(abstractJsonLexer1, "Expected comma after the key-value pair", v2, null, 4, null);
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
            }
            int v3 = this.currentIndex + 1;
            this.currentIndex = v3;
            return v3;
        }
        if(z && !this.json.getConfiguration().getAllowTrailingComma()) {
            JsonExceptionsKt.invalidTrailingComma$default(this.lexer, null, 1, null);
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return -1;
    }

    // 去混淆评级： 低(20)
    @Override  // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public boolean decodeNotNullMark() {
        return !(this.elementMarker == null ? false : this.elementMarker.isUnmarkedNull$kotlinx_serialization_json()) && !AbstractJsonLexer.tryConsumeNull$default(this.lexer, false, 1, null);
    }

    @Override  // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    @Nullable
    public Void decodeNull() {
        return null;
    }

    private final int decodeObjectIndex(SerialDescriptor serialDescriptor0) {
        boolean z2;
        boolean z;
        for(z = this.lexer.tryConsumeComma(); true; z = z1 ? this.handleUnknown(s) : z2) {
            boolean z1 = true;
            if(!this.lexer.canConsumeValue()) {
                break;
            }
            String s = this.decodeStringKey();
            this.lexer.consumeNextToken(':');
            int v = JsonNamesMapKt.getJsonNameIndex(serialDescriptor0, this.json, s);
            if(v == -3) {
                z2 = false;
            }
            else {
                if(this.configuration.getCoerceInputValues() && this.coerceInputValue(serialDescriptor0, v)) {
                    z2 = this.lexer.tryConsumeComma();
                    z1 = false;
                    continue;
                }
                JsonElementMarker jsonElementMarker0 = this.elementMarker;
                if(jsonElementMarker0 != null) {
                    jsonElementMarker0.mark$kotlinx_serialization_json(v);
                }
                return v;
            }
        }
        if(z && !this.json.getConfiguration().getAllowTrailingComma()) {
            JsonExceptionsKt.invalidTrailingComma$default(this.lexer, null, 1, null);
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return this.elementMarker == null ? -1 : this.elementMarker.nextUnmarkedIndex$kotlinx_serialization_json();
    }

    @Override  // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public Object decodeSerializableElement(@NotNull SerialDescriptor serialDescriptor0, int v, @NotNull DeserializationStrategy deserializationStrategy0, @Nullable Object object0) {
        q.g(serialDescriptor0, "descriptor");
        q.g(deserializationStrategy0, "deserializer");
        boolean z = this.mode == WriteMode.MAP && (v & 1) == 0;
        if(z) {
            this.lexer.path.resetCurrentMapKey();
        }
        Object object1 = super.decodeSerializableElement(serialDescriptor0, v, deserializationStrategy0, object0);
        if(z) {
            this.lexer.path.updateCurrentMapKey(object1);
        }
        return object1;
    }

    @Override  // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public Object decodeSerializableValue(@NotNull DeserializationStrategy deserializationStrategy0) {
        DeserializationStrategy deserializationStrategy2;
        DeserializationStrategy deserializationStrategy1;
        String s4;
        q.g(deserializationStrategy0, "deserializer");
        try {
            if(!(deserializationStrategy0 instanceof AbstractPolymorphicSerializer) || this.json.getConfiguration().getUseArrayPolymorphism()) {
                return deserializationStrategy0.deserialize(this);
            }
            String s = PolymorphicKt.classDiscriminator(((AbstractPolymorphicSerializer)deserializationStrategy0).getDescriptor(), this.json);
            String s1 = this.lexer.peekLeadingMatchingValue(s, this.configuration.isLenient());
            if(s1 == null) {
                if(!(deserializationStrategy0 instanceof AbstractPolymorphicSerializer) || this.getJson().getConfiguration().getUseArrayPolymorphism()) {
                    return deserializationStrategy0.deserialize(this);
                }
                String s2 = PolymorphicKt.classDiscriminator(((AbstractPolymorphicSerializer)deserializationStrategy0).getDescriptor(), this.getJson());
                JsonElement jsonElement0 = this.decodeJsonElement();
                String s3 = ((AbstractPolymorphicSerializer)deserializationStrategy0).getDescriptor().getSerialName();
                if(!(jsonElement0 instanceof JsonObject)) {
                    Class class0 = jsonElement0.getClass();
                    throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + I.a.b(JsonObject.class).m() + ", but had " + I.a.b(class0).m() + " as the serialized body of " + s3 + " at element: " + "$", jsonElement0.toString());
                }
                JsonElement jsonElement1 = (JsonElement)((JsonObject)jsonElement0).get(s2);
                if(jsonElement1 == null) {
                    s4 = null;
                }
                else {
                    JsonPrimitive jsonPrimitive0 = JsonElementKt.getJsonPrimitive(jsonElement1);
                    s4 = jsonPrimitive0 == null ? null : JsonElementKt.getContentOrNull(jsonPrimitive0);
                }
                try {
                    deserializationStrategy1 = PolymorphicSerializerKt.findPolymorphicSerializer(((AbstractPolymorphicSerializer)deserializationStrategy0), this, s4);
                }
                catch(SerializationException serializationException0) {
                    String s5 = serializationException0.getMessage();
                    q.d(s5);
                    throw JsonExceptionsKt.JsonDecodingException(-1, s5, ((JsonObject)jsonElement0).toString());
                }
                q.e(deserializationStrategy1, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.decodeSerializableValuePolymorphic>");
                return TreeJsonDecoderKt.readPolymorphicJson(this.getJson(), s2, ((JsonObject)jsonElement0), deserializationStrategy1);
            }
            try {
                deserializationStrategy2 = PolymorphicSerializerKt.findPolymorphicSerializer(((AbstractPolymorphicSerializer)deserializationStrategy0), this, s1);
            }
            catch(SerializationException serializationException1) {
                String s6 = serializationException1.getMessage();
                q.d(s6);
                String s7 = o.O0(o.a1(s6, '\n'), ".");
                String s8 = serializationException1.getMessage();
                q.d(s8);
                String s9 = o.W0('\n', s8, "");
                AbstractJsonLexer.fail$default(this.lexer, s7, 0, s9, 2, null);
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            q.e(deserializationStrategy2, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.StreamingJsonDecoder.decodeSerializableValue>");
            this.discriminatorHolder = new DiscriminatorHolder(s);
            return deserializationStrategy2.deserialize(this);
        }
        catch(MissingFieldException missingFieldException0) {
            String s10 = missingFieldException0.getMessage();
            q.d(s10);
            throw o.v0(s10, "at path", false) ? missingFieldException0 : new MissingFieldException(missingFieldException0.getMissingFields(), missingFieldException0.getMessage() + " at path: " + "$", missingFieldException0);
        }
    }

    @Override  // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public short decodeShort() {
        long v = this.lexer.consumeNumericLiteral();
        if(v == ((long)(((short)(((int)v)))))) {
            return (short)(((int)v));
        }
        AbstractJsonLexer.fail$default(this.lexer, "Failed to parse short for input \'" + v + '\'', 0, null, 6, null);
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override  // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    @NotNull
    public String decodeString() {
        return this.configuration.isLenient() ? this.lexer.consumeStringLenientNotNull() : this.lexer.consumeString();
    }

    // 去混淆评级： 低(20)
    private final String decodeStringKey() {
        return this.configuration.isLenient() ? this.lexer.consumeStringLenientNotNull() : this.lexer.consumeKeyString();
    }

    @Override  // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public void endStructure(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
        if(this.json.getConfiguration().getIgnoreUnknownKeys() && serialDescriptor0.getElementsCount() == 0) {
            this.skipLeftoverElements(serialDescriptor0);
        }
        if(this.lexer.tryConsumeComma() && !this.json.getConfiguration().getAllowTrailingComma()) {
            JsonExceptionsKt.invalidTrailingComma(this.lexer, "");
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        this.lexer.consumeNextToken(this.mode.end);
        this.lexer.path.popDescriptor();
    }

    @Override  // kotlinx.serialization.json.JsonDecoder
    @NotNull
    public final Json getJson() {
        return this.json;
    }

    @Override  // kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.CompositeDecoder
    @NotNull
    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    private final boolean handleUnknown(String s) {
        if(!this.configuration.getIgnoreUnknownKeys() && !this.trySkip(this.discriminatorHolder, s)) {
            this.lexer.failOnUnknownKey(s);
            return this.lexer.tryConsumeComma();
        }
        this.lexer.skipElement(this.configuration.isLenient());
        return this.lexer.tryConsumeComma();
    }

    private final void skipLeftoverElements(SerialDescriptor serialDescriptor0) {
        while(this.decodeElementIndex(serialDescriptor0) != -1) {
        }
    }

    private final boolean trySkip(DiscriminatorHolder streamingJsonDecoder$DiscriminatorHolder0, String s) {
        if(streamingJsonDecoder$DiscriminatorHolder0 == null) {
            return false;
        }
        if(q.b(streamingJsonDecoder$DiscriminatorHolder0.discriminatorToSkip, s)) {
            streamingJsonDecoder$DiscriminatorHolder0.discriminatorToSkip = null;
            return true;
        }
        return false;
    }
}

