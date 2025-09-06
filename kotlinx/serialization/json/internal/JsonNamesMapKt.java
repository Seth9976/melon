package kotlinx.serialization.json.internal;

import ed.w0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import je.C;
import je.p;
import je.x;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind.ENUM;
import kotlinx.serialization.descriptors.StructureKind.CLASS;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonNames;
import kotlinx.serialization.json.JsonNamingStrategy;
import kotlinx.serialization.json.JsonSchemaCacheKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\u001A\'\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001A\'\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003*\u00020\u00012\u0006\u0010\b\u001A\u00020\u0000H\u0000¢\u0006\u0004\b\t\u0010\n\u001A#\u0010\f\u001A\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u000B\u001A\u00020\u0005H\u0000¢\u0006\u0004\b\f\u0010\r\u001A\u001D\u0010\u000F\u001A\u0004\u0018\u00010\u000E*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0000¢\u0006\u0004\b\u000F\u0010\u0010\u001A#\u0010\u0012\u001A\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0011\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001A\u001B\u0010\u0015\u001A\u00020\u0014*\u00020\u00012\u0006\u0010\b\u001A\u00020\u0000H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001A#\u0010\u0017\u001A\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0011\u001A\u00020\u0004H\u0000¢\u0006\u0004\b\u0017\u0010\u0013\u001A-\u0010\u0019\u001A\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0011\u001A\u00020\u00042\b\b\u0002\u0010\u0018\u001A\u00020\u0004H\u0000¢\u0006\u0004\b\u0019\u0010\u001A\",\u0010\u001C\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u001B8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\u001F\"&\u0010!\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040 0\u001B8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b!\u0010\u001D\u001A\u0004\b\"\u0010\u001F¨\u0006#"}, d2 = {"Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/json/Json;", "json", "", "", "", "buildDeserializationNamesMap", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/json/Json;)Ljava/util/Map;", "descriptor", "deserializationNamesMap", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/descriptors/SerialDescriptor;)Ljava/util/Map;", "index", "getJsonElementName", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/json/Json;I)Ljava/lang/String;", "Lkotlinx/serialization/json/JsonNamingStrategy;", "namingStrategy", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/json/Json;)Lkotlinx/serialization/json/JsonNamingStrategy;", "name", "getJsonNameIndexSlowPath", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/json/Json;Ljava/lang/String;)I", "", "decodeCaseInsensitive", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/descriptors/SerialDescriptor;)Z", "getJsonNameIndex", "suffix", "getJsonNameIndexOrThrow", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/json/Json;Ljava/lang/String;Ljava/lang/String;)I", "Lkotlinx/serialization/json/internal/DescriptorSchemaCache$Key;", "JsonDeserializationNamesKey", "Lkotlinx/serialization/json/internal/DescriptorSchemaCache$Key;", "getJsonDeserializationNamesKey", "()Lkotlinx/serialization/json/internal/DescriptorSchemaCache$Key;", "", "JsonSerializationNamesKey", "getJsonSerializationNamesKey", "kotlinx-serialization-json"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class JsonNamesMapKt {
    @NotNull
    private static final Key JsonDeserializationNamesKey;
    @NotNull
    private static final Key JsonSerializationNamesKey;

    static {
        JsonNamesMapKt.JsonDeserializationNamesKey = new Key();
        JsonNamesMapKt.JsonSerializationNamesKey = new Key();
    }

    public static Map a(SerialDescriptor serialDescriptor0, Json json0) {
        return JsonNamesMapKt.deserializationNamesMap$lambda$3(serialDescriptor0, json0);
    }

    private static final Map buildDeserializationNamesMap(SerialDescriptor serialDescriptor0, Json json0) {
        String s1;
        Map map0 = new LinkedHashMap();
        boolean z = JsonNamesMapKt.decodeCaseInsensitive(json0, serialDescriptor0);
        JsonNamesMapKt.namingStrategy(serialDescriptor0, json0);
        int v = serialDescriptor0.getElementsCount();
        for(int v1 = 0; v1 < v; ++v1) {
            Iterable iterable0 = serialDescriptor0.getElementAnnotations(v1);
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: iterable0) {
                if(object0 instanceof JsonNames) {
                    arrayList0.add(object0);
                }
            }
            JsonNames jsonNames0 = (JsonNames)p.G0(arrayList0);
            if(jsonNames0 != null) {
                String[] arr_s = jsonNames0.names();
                if(arr_s != null) {
                    int v2 = arr_s.length;
                    for(int v3 = 0; v3 < v2; ++v3) {
                        String s = arr_s[v3];
                        if(z) {
                            s = s.toLowerCase(Locale.ROOT);
                            q.f(s, "toLowerCase(...)");
                        }
                        JsonNamesMapKt.buildDeserializationNamesMap$putOrThrow(map0, serialDescriptor0, s, v1);
                    }
                }
            }
            if(z) {
                s1 = serialDescriptor0.getElementName(v1).toLowerCase(Locale.ROOT);
                q.f(s1, "toLowerCase(...)");
            }
            else {
                s1 = null;
            }
            if(s1 != null) {
                JsonNamesMapKt.buildDeserializationNamesMap$putOrThrow(map0, serialDescriptor0, s1, v1);
            }
        }
        return map0.isEmpty() ? x.a : map0;
    }

    private static final void buildDeserializationNamesMap$putOrThrow(Map map0, SerialDescriptor serialDescriptor0, String s, int v) {
        String s1 = q.b(serialDescriptor0.getKind(), ENUM.INSTANCE) ? "enum value" : "property";
        if(map0.containsKey(s)) {
            throw new JsonException("The suggested name \'" + s + "\' for " + s1 + ' ' + serialDescriptor0.getElementName(v) + " is already one of the names for " + s1 + ' ' + serialDescriptor0.getElementName(((Number)C.Q(s, map0)).intValue()) + " in " + serialDescriptor0);
        }
        map0.put(s, v);
    }

    // 去混淆评级： 低(20)
    private static final boolean decodeCaseInsensitive(Json json0, SerialDescriptor serialDescriptor0) {
        return json0.getConfiguration().getDecodeEnumsCaseInsensitive() && q.b(serialDescriptor0.getKind(), ENUM.INSTANCE);
    }

    @NotNull
    public static final Map deserializationNamesMap(@NotNull Json json0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(json0, "<this>");
        q.g(serialDescriptor0, "descriptor");
        DescriptorSchemaCache descriptorSchemaCache0 = JsonSchemaCacheKt.getSchemaCache(json0);
        w0 w00 = new w0(3, serialDescriptor0, json0);
        return (Map)descriptorSchemaCache0.getOrPut(serialDescriptor0, JsonNamesMapKt.JsonDeserializationNamesKey, w00);
    }

    private static final Map deserializationNamesMap$lambda$3(SerialDescriptor serialDescriptor0, Json json0) {
        return JsonNamesMapKt.buildDeserializationNamesMap(serialDescriptor0, json0);
    }

    @NotNull
    public static final Key getJsonDeserializationNamesKey() {
        return JsonNamesMapKt.JsonDeserializationNamesKey;
    }

    @NotNull
    public static final String getJsonElementName(@NotNull SerialDescriptor serialDescriptor0, @NotNull Json json0, int v) {
        q.g(serialDescriptor0, "<this>");
        q.g(json0, "json");
        JsonNamesMapKt.namingStrategy(serialDescriptor0, json0);
        return serialDescriptor0.getElementName(v);
    }

    public static final int getJsonNameIndex(@NotNull SerialDescriptor serialDescriptor0, @NotNull Json json0, @NotNull String s) {
        q.g(serialDescriptor0, "<this>");
        q.g(json0, "json");
        q.g(s, "name");
        if(JsonNamesMapKt.decodeCaseInsensitive(json0, serialDescriptor0)) {
            String s1 = s.toLowerCase(Locale.ROOT);
            q.f(s1, "toLowerCase(...)");
            return JsonNamesMapKt.getJsonNameIndexSlowPath(serialDescriptor0, json0, s1);
        }
        JsonNamesMapKt.namingStrategy(serialDescriptor0, json0);
        int v = serialDescriptor0.getElementIndex(s);
        return v == -3 && json0.getConfiguration().getUseAlternativeNames() ? JsonNamesMapKt.getJsonNameIndexSlowPath(serialDescriptor0, json0, s) : v;
    }

    public static final int getJsonNameIndexOrThrow(@NotNull SerialDescriptor serialDescriptor0, @NotNull Json json0, @NotNull String s, @NotNull String s1) {
        q.g(serialDescriptor0, "<this>");
        q.g(json0, "json");
        q.g(s, "name");
        q.g(s1, "suffix");
        int v = JsonNamesMapKt.getJsonNameIndex(serialDescriptor0, json0, s);
        if(v == -3) {
            throw new SerializationException(serialDescriptor0.getSerialName() + " does not contain element with name \'" + s + '\'' + s1);
        }
        return v;
    }

    public static int getJsonNameIndexOrThrow$default(SerialDescriptor serialDescriptor0, Json json0, String s, String s1, int v, Object object0) {
        if((v & 4) != 0) {
            s1 = "";
        }
        return JsonNamesMapKt.getJsonNameIndexOrThrow(serialDescriptor0, json0, s, s1);
    }

    private static final int getJsonNameIndexSlowPath(SerialDescriptor serialDescriptor0, Json json0, String s) {
        Integer integer0 = (Integer)JsonNamesMapKt.deserializationNamesMap(json0, serialDescriptor0).get(s);
        return integer0 == null ? -3 : ((int)integer0);
    }

    @Nullable
    public static final JsonNamingStrategy namingStrategy(@NotNull SerialDescriptor serialDescriptor0, @NotNull Json json0) {
        q.g(serialDescriptor0, "<this>");
        q.g(json0, "json");
        if(q.b(serialDescriptor0.getKind(), CLASS.INSTANCE)) {
            json0.getConfiguration().getNamingStrategy();
        }
        return null;
    }
}

