package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.internal.DescriptorSchemaCache;
import kotlinx.serialization.json.internal.JsonStreamsKt;
import kotlinx.serialization.json.internal.JsonToStringWriter;
import kotlinx.serialization.json.internal.StreamingJsonDecoder;
import kotlinx.serialization.json.internal.StringJsonLexer;
import kotlinx.serialization.json.internal.StringJsonLexerKt;
import kotlinx.serialization.json.internal.TreeJsonEncoderKt;
import kotlinx.serialization.json.internal.WriteMode;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;
import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 $2\u00020\u0001:\u0001$B\u0019\b\u0004\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\r\u001A\u00020\f\"\u0004\b\u0000\u0010\b2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u000B\u001A\u00028\u0000¢\u0006\u0004\b\r\u0010\u000EJ+\u0010\u0012\u001A\u00028\u0000\"\u0004\b\u0000\u0010\b2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00000\u000F2\b\b\u0001\u0010\u0011\u001A\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0015\u001A\u00020\u0014\"\u0004\b\u0000\u0010\b2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u000B\u001A\u00028\u0000¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019R\u001A\u0010\u0005\u001A\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001A\u001A\u0004\b\u001B\u0010\u001CR \u0010\u001E\u001A\u00020\u001D8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u001E\u0010\u001F\u0012\u0004\b\"\u0010#\u001A\u0004\b \u0010!\u0082\u0001\u0002%&¨\u0006\'"}, d2 = {"Lkotlinx/serialization/json/Json;", "Lkotlinx/serialization/StringFormat;", "Lkotlinx/serialization/json/JsonConfiguration;", "configuration", "Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "<init>", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/modules/SerializersModule;)V", "T", "Lkotlinx/serialization/SerializationStrategy;", "serializer", "value", "", "encodeToString", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Ljava/lang/String;", "Lkotlinx/serialization/DeserializationStrategy;", "deserializer", "string", "decodeFromString", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/String;)Ljava/lang/Object;", "Lkotlinx/serialization/json/JsonElement;", "encodeToJsonElement", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Lkotlinx/serialization/json/JsonElement;", "Lkotlinx/serialization/json/JsonConfiguration;", "getConfiguration", "()Lkotlinx/serialization/json/JsonConfiguration;", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "Lkotlinx/serialization/json/internal/DescriptorSchemaCache;", "_schemaCache", "Lkotlinx/serialization/json/internal/DescriptorSchemaCache;", "get_schemaCache$kotlinx_serialization_json", "()Lkotlinx/serialization/json/internal/DescriptorSchemaCache;", "get_schemaCache$kotlinx_serialization_json$annotations", "()V", "Default", "Lkotlinx/serialization/json/Json$Default;", "Lkotlinx/serialization/json/JsonImpl;", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public abstract class Json implements StringFormat {
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/serialization/json/Json$Default;", "Lkotlinx/serialization/json/Json;", "<init>", "()V", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
    public static final class Default extends Json {
        private Default() {
            super(new JsonConfiguration(false, false, false, false, false, false, null, false, false, null, false, false, null, false, false, false, null, 0x1FFFF, null), SerializersModuleBuildersKt.EmptySerializersModule(), null);
        }

        public Default(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Default Default;
    @NotNull
    private final DescriptorSchemaCache _schemaCache;
    @NotNull
    private final JsonConfiguration configuration;
    @NotNull
    private final SerializersModule serializersModule;

    static {
        Json.Default = new Default(null);
    }

    private Json(JsonConfiguration jsonConfiguration0, SerializersModule serializersModule0) {
        this.configuration = jsonConfiguration0;
        this.serializersModule = serializersModule0;
        this._schemaCache = new DescriptorSchemaCache();
    }

    public Json(JsonConfiguration jsonConfiguration0, SerializersModule serializersModule0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(jsonConfiguration0, serializersModule0);
    }

    @Override  // kotlinx.serialization.StringFormat
    public final Object decodeFromString(@NotNull DeserializationStrategy deserializationStrategy0, @Language(prefix = "", suffix = "", value = "json") @NotNull String s) {
        q.g(deserializationStrategy0, "deserializer");
        q.g(s, "string");
        StringJsonLexer stringJsonLexer0 = StringJsonLexerKt.StringJsonLexer(this, s);
        SerialDescriptor serialDescriptor0 = deserializationStrategy0.getDescriptor();
        Object object0 = new StreamingJsonDecoder(this, WriteMode.OBJ, stringJsonLexer0, serialDescriptor0, null).decodeSerializableValue(deserializationStrategy0);
        stringJsonLexer0.expectEof();
        return object0;
    }

    @NotNull
    public final JsonElement encodeToJsonElement(@NotNull SerializationStrategy serializationStrategy0, Object object0) {
        q.g(serializationStrategy0, "serializer");
        return TreeJsonEncoderKt.writeJson(this, object0, serializationStrategy0);
    }

    @Override  // kotlinx.serialization.StringFormat
    @NotNull
    public final String encodeToString(@NotNull SerializationStrategy serializationStrategy0, Object object0) {
        q.g(serializationStrategy0, "serializer");
        JsonToStringWriter jsonToStringWriter0 = new JsonToStringWriter();
        try {
            JsonStreamsKt.encodeByWriter(this, jsonToStringWriter0, serializationStrategy0, object0);
            return "";
        }
        finally {
            jsonToStringWriter0.release();
        }
    }

    @NotNull
    public final JsonConfiguration getConfiguration() {
        return this.configuration;
    }

    @Override  // kotlinx.serialization.SerialFormat
    @NotNull
    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    @NotNull
    public final DescriptorSchemaCache get_schemaCache$kotlinx_serialization_json() {
        return this._schemaCache;
    }
}

