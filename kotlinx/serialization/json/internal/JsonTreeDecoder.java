package kotlinx.serialization.json.internal;

import java.util.Map;
import java.util.Set;
import je.C;
import je.y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind.ENUM;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.internal.JsonInternalDependenciesKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.json.JsonSchemaCacheKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0012\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000BJ\'\u0010\u0011\u001A\u00020\u00102\u0006\u0010\f\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0013\u001A\u00020\u00102\u0006\u0010\f\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0017\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001F\u0010\u0019\u001A\u00020\u00062\u0006\u0010\f\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\rH\u0014¢\u0006\u0004\b\u0019\u0010\u001AJ\u0017\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u000F\u001A\u00020\u0006H\u0014¢\u0006\u0004\b\u001C\u0010\u001DJ\u0017\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\f\u001A\u00020\bH\u0016¢\u0006\u0004\b\u001F\u0010 J\u0017\u0010\"\u001A\u00020!2\u0006\u0010\f\u001A\u00020\bH\u0016¢\u0006\u0004\b\"\u0010#R\u001A\u0010\u0005\u001A\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010$\u001A\u0004\b%\u0010&R\u0016\u0010\t\u001A\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\'R\u0016\u0010(\u001A\u00020\r8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001A\u00020\u00108\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeDecoder;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "Lkotlinx/serialization/json/Json;", "json", "Lkotlinx/serialization/json/JsonObject;", "value", "", "polymorphicDiscriminator", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "polyDescriptor", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "descriptor", "", "index", "tag", "", "coerceInputValue", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILjava/lang/String;)Z", "absenceIsNull", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "decodeElementIndex", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "decodeNotNullMark", "()Z", "elementName", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/String;", "Lkotlinx/serialization/json/JsonElement;", "currentElement", "(Ljava/lang/String;)Lkotlinx/serialization/json/JsonElement;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "beginStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeDecoder;", "Lie/H;", "endStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "Lkotlinx/serialization/json/JsonObject;", "getValue", "()Lkotlinx/serialization/json/JsonObject;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "position", "I", "forceNull", "Z", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
class JsonTreeDecoder extends AbstractJsonTreeDecoder {
    private boolean forceNull;
    @Nullable
    private final SerialDescriptor polyDescriptor;
    private int position;
    @NotNull
    private final JsonObject value;

    public JsonTreeDecoder(@NotNull Json json0, @NotNull JsonObject jsonObject0, @Nullable String s, @Nullable SerialDescriptor serialDescriptor0) {
        q.g(json0, "json");
        q.g(jsonObject0, "value");
        super(json0, jsonObject0, s, null);
        this.value = jsonObject0;
        this.polyDescriptor = serialDescriptor0;
    }

    public JsonTreeDecoder(Json json0, JsonObject jsonObject0, String s, SerialDescriptor serialDescriptor0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 4) != 0) {
            s = null;
        }
        if((v & 8) != 0) {
            serialDescriptor0 = null;
        }
        this(json0, jsonObject0, s, serialDescriptor0);
    }

    private final boolean absenceIsNull(SerialDescriptor serialDescriptor0, int v) {
        boolean z = !this.getJson().getConfiguration().getExplicitNulls() && !serialDescriptor0.isElementOptional(v) && serialDescriptor0.getElementDescriptor(v).isNullable();
        this.forceNull = z;
        return z;
    }

    @Override  // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    @NotNull
    public CompositeDecoder beginStructure(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
        if(serialDescriptor0 == this.polyDescriptor) {
            Json json0 = this.getJson();
            JsonElement jsonElement0 = this.currentObject();
            String s = this.polyDescriptor.getSerialName();
            if(jsonElement0 instanceof JsonObject) {
                return new JsonTreeDecoder(json0, ((JsonObject)jsonElement0), this.getPolymorphicDiscriminator(), this.polyDescriptor);
            }
            StringBuilder stringBuilder0 = new StringBuilder("Expected ");
            stringBuilder0.append(I.a.b(JsonObject.class).m());
            stringBuilder0.append(", but had ");
            Class class0 = jsonElement0.getClass();
            stringBuilder0.append(I.a.b(class0).m());
            e.g(stringBuilder0, " as the serialized body of ", s, " at element: ");
            stringBuilder0.append(AbstractJsonTreeDecoder.access$renderTagStack(this));
            throw JsonExceptionsKt.JsonDecodingException(-1, stringBuilder0.toString(), jsonElement0.toString());
        }
        return super.beginStructure(serialDescriptor0);
    }

    private final boolean coerceInputValue(SerialDescriptor serialDescriptor0, int v, String s) {
        Json json0 = this.getJson();
        boolean z = serialDescriptor0.isElementOptional(v);
        SerialDescriptor serialDescriptor1 = serialDescriptor0.getElementDescriptor(v);
        if(z && !serialDescriptor1.isNullable() && this.currentElement(s) instanceof JsonNull) {
            return true;
        }
        if(!q.b(serialDescriptor1.getKind(), ENUM.INSTANCE) || serialDescriptor1.isNullable() && this.currentElement(s) instanceof JsonNull) {
            return false;
        }
        JsonElement jsonElement0 = this.currentElement(s);
        String s1 = null;
        JsonPrimitive jsonPrimitive0 = jsonElement0 instanceof JsonPrimitive ? ((JsonPrimitive)jsonElement0) : null;
        if(jsonPrimitive0 != null) {
            s1 = JsonElementKt.getContentOrNull(jsonPrimitive0);
        }
        return s1 == null ? false : JsonNamesMapKt.getJsonNameIndex(serialDescriptor1, json0, s1) == -3 && (z || !json0.getConfiguration().getExplicitNulls() && serialDescriptor1.isNullable());
    }

    @Override  // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    @NotNull
    public JsonElement currentElement(@NotNull String s) {
        q.g(s, "tag");
        return (JsonElement)C.Q(s, this.getValue());
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public int decodeElementIndex(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
        while(this.position < serialDescriptor0.getElementsCount()) {
            int v = this.position;
            this.position = v + 1;
            String s = this.getTag(serialDescriptor0, v);
            int v1 = this.position - 1;
            this.forceNull = false;
            if((this.getValue().containsKey(s) || this.absenceIsNull(serialDescriptor0, v1)) && (!this.configuration.getCoerceInputValues() || !this.coerceInputValue(serialDescriptor0, v1, s))) {
                return v1;
            }
            if(false) {
                break;
            }
        }
        return -1;
    }

    // 去混淆评级： 低(20)
    @Override  // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    public boolean decodeNotNullMark() {
        return !this.forceNull && super.decodeNotNullMark();
    }

    @Override  // kotlinx.serialization.internal.NamedValueDecoder
    @NotNull
    public String elementName(@NotNull SerialDescriptor serialDescriptor0, int v) {
        q.g(serialDescriptor0, "descriptor");
        JsonNamesMapKt.namingStrategy(serialDescriptor0, this.getJson());
        String s = serialDescriptor0.getElementName(v);
        if(!this.configuration.getUseAlternativeNames() || this.getValue().keySet().contains(s)) {
            return s;
        }
        Map map0 = JsonNamesMapKt.deserializationNamesMap(this.getJson(), serialDescriptor0);
        for(Object object0: this.getValue().keySet()) {
            Integer integer0 = (Integer)map0.get(((String)object0));
            if(integer0 != null && ((int)integer0) == v) {
                return ((String)object0) == null ? s : ((String)object0);
            }
            if(false) {
                break;
            }
        }
        return s;
    }

    @Override  // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    public void endStructure(@NotNull SerialDescriptor serialDescriptor0) {
        Set set0;
        q.g(serialDescriptor0, "descriptor");
        if(!this.configuration.getIgnoreUnknownKeys() && !(serialDescriptor0.getKind() instanceof PolymorphicKind)) {
            JsonNamesMapKt.namingStrategy(serialDescriptor0, this.getJson());
            if(this.configuration.getUseAlternativeNames()) {
                Set set1 = JsonInternalDependenciesKt.jsonCachedSerialNames(serialDescriptor0);
                Map map0 = (Map)JsonSchemaCacheKt.getSchemaCache(this.getJson()).get(serialDescriptor0, JsonNamesMapKt.getJsonDeserializationNamesKey());
                Set set2 = map0 == null ? null : map0.keySet();
                if(set2 == null) {
                    set2 = y.a;
                }
                set0 = je.I.K(set1, set2);
            }
            else {
                set0 = JsonInternalDependenciesKt.jsonCachedSerialNames(serialDescriptor0);
            }
            for(Object object0: this.getValue().keySet()) {
                String s = (String)object0;
                if(!set0.contains(s) && !q.b(s, this.getPolymorphicDiscriminator())) {
                    throw JsonExceptionsKt.UnknownKeyException(s, this.getValue().toString());
                }
                if(false) {
                    break;
                }
            }
        }
    }

    @Override  // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    public JsonElement getValue() {
        return this.getValue();
    }

    @NotNull
    public JsonObject getValue() {
        return this.value;
    }
}

