package co.ab180.airbridge.internal.e0;

import co.ab180.airbridge.internal.b;
import co.ab180.airbridge.internal.parser.c;
import ie.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import je.n;
import je.p;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u001A\u001D\u0010\u0003\u001A\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0000\u00A2\u0006\u0004\b\u0003\u0010\u0004\u001A\u001D\u0010\u0006\u001A\u0004\u0018\u00010\u0005*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0000\u00A2\u0006\u0004\b\u0006\u0010\u0007\u001A\u001D\u0010\t\u001A\u0004\u0018\u00010\b*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0000\u00A2\u0006\u0004\b\t\u0010\n\u001A\u001D\u0010\f\u001A\u0004\u0018\u00010\u000B*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0000\u00A2\u0006\u0004\b\f\u0010\r\u001A\u001D\u0010\u000F\u001A\u0004\u0018\u00010\u000E*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0000\u00A2\u0006\u0004\b\u000F\u0010\u0010\u001A\u001B\u0010\u0012\u001A\u00020\u0011*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0000\u00A2\u0006\u0004\b\u0012\u0010\u0013\u001A&\u0010\u0015\u001A\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u0014\u0018\u0001*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0080\b\u00A2\u0006\u0004\b\u0015\u0010\u0016\u001A$\u0010\u0017\u001A\u00028\u0000\"\u0006\b\u0000\u0010\u0014\u0018\u0001*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0080\b\u00A2\u0006\u0004\b\u0017\u0010\u0016\u001A\u001B\u0010\u0017\u001A\u00020\u0000*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0018H\u0000\u00A2\u0006\u0004\b\u0017\u0010\u0019\u001A)\u0010\u001B\u001A\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001A\u0018\u00010\u0018*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0000\u00A2\u0006\u0004\b\u001B\u0010\u001C\u001A\u0017\u0010\u0017\u001A\u00020\u001E*\u0006\u0012\u0002\b\u00030\u001DH\u0000\u00A2\u0006\u0004\b\u0017\u0010\u001F\u001A\u001B\u0010!\u001A\u00020\u0000*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030 H\u0000\u00A2\u0006\u0004\b!\u0010\"\u001A\u0017\u0010\u0017\u001A\u00020\u001A2\u0006\u0010#\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\b\u0017\u0010$\u001A0\u0010%\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001D\"\n\b\u0000\u0010\u0014\u0018\u0001*\u00020\u001A*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0080\b\u00A2\u0006\u0004\b%\u0010&\u001A.\u0010!\u001A\b\u0012\u0004\u0012\u00028\u00000\u001D\"\n\b\u0000\u0010\u0014\u0018\u0001*\u00020\u001A*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0080\b\u00A2\u0006\u0004\b!\u0010&\u001A%\u0010!\u001A\u0004\u0018\u00010\u001A*\u00020\u00002\u0006\u0010\'\u001A\u00020\u00012\u0006\u0010(\u001A\u00020\u0005H\u0000\u00A2\u0006\u0004\b!\u0010)\u001A%\u0010!\u001A\u0004\u0018\u00010\u001A*\u00020\u001E2\u0006\u0010*\u001A\u00020\u000B2\u0006\u0010(\u001A\u00020\u0005H\u0000\u00A2\u0006\u0004\b!\u0010+\u001A%\u0010\u0017\u001A\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u001A0\u00182\u0006\u0010,\u001A\u00020\u0000H\u0000\u00A2\u0006\u0004\b\u0017\u0010-\u001A#\u0010!\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001A0\u00182\u0006\u0010,\u001A\u00020\u0000H\u0000\u00A2\u0006\u0004\b!\u0010-\u001A\u001F\u0010\u0017\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u001A0\u001D2\u0006\u0010.\u001A\u00020\u001EH\u0000\u00A2\u0006\u0004\b\u0017\u0010/\u001A\u001D\u0010!\u001A\b\u0012\u0004\u0012\u00020\u001A0\u001D2\u0006\u0010.\u001A\u00020\u001EH\u0000\u00A2\u0006\u0004\b!\u0010/\u001A\u001F\u0010!\u001A\u00020\u00002\u000E\u0010#\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0018H\u0000\u00A2\u0006\u0004\b!\u0010\u0019\u001A\u001B\u0010!\u001A\u00020\u001E2\n\u0010#\u001A\u0006\u0012\u0002\b\u00030\u001DH\u0000\u00A2\u0006\u0004\b!\u0010\u001F\u001A\u0017\u0010%\u001A\u00020\u00002\u0006\u0010#\u001A\u00020\u001AH\u0000\u00A2\u0006\u0004\b%\u00100\u001A\u0017\u0010!\u001A\u00020\u001A2\u0006\u0010#\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\b!\u0010$\u001A\u0019\u0010\u0012\u001A\u00020\u00052\b\u0010#\u001A\u0004\u0018\u00010\u001AH\u0002\u00A2\u0006\u0004\b\u0012\u00101\u001A\u0019\u0010\u001B\u001A\u00020\u00052\b\u0010#\u001A\u0004\u0018\u00010\u001AH\u0002\u00A2\u0006\u0004\b\u001B\u00101\u00A8\u00062"}, d2 = {"Lorg/json/JSONObject;", "", "name", "j", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;", "", "f", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Boolean;", "", "i", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Number;", "", "g", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Integer;", "", "h", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Long;", "", "d", "(Lorg/json/JSONObject;Ljava/lang/String;)F", "T", "k", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Object;", "b", "", "(Ljava/util/Map;)Lorg/json/JSONObject;", "", "e", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/util/Map;", "", "Lorg/json/JSONArray;", "(Ljava/util/List;)Lorg/json/JSONArray;", "Lie/m;", "a", "(Lie/m;)Lorg/json/JSONObject;", "src", "(Ljava/lang/Object;)Ljava/lang/Object;", "c", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/util/List;", "key", "nullCheck", "(Lorg/json/JSONObject;Ljava/lang/String;Z)Ljava/lang/Object;", "index", "(Lorg/json/JSONArray;IZ)Ljava/lang/Object;", "jsonObject", "(Lorg/json/JSONObject;)Ljava/util/Map;", "jsonArray", "(Lorg/json/JSONArray;)Ljava/util/List;", "(Ljava/lang/Object;)Lorg/json/JSONObject;", "(Ljava/lang/Object;)Z", "airbridge_release"}, k = 2, mv = {1, 4, 3})
public final class b0 {
    private static final Object a(Object object0) {
        if(b0.d(object0)) {
            return object0;
        }
        if(b0.e(object0)) {
            return object0.toString();
        }
        if(object0 instanceof Object[]) {
            return b0.a(n.z0(((Object[])object0)));
        }
        if(object0 instanceof Set) {
            return b0.a(p.P0(((Iterable)object0)));
        }
        if(object0 instanceof List) {
            return b0.a(((List)object0));
        }
        if(object0 instanceof Map) {
            return b0.a(((Map)object0));
        }
        return object0 instanceof m ? b0.c(object0) : c.b.b(object0);
    }

    // 去混淆评级： 低(20)
    @Nullable
    public static final Object a(@NotNull JSONArray jSONArray0, int v, boolean z) {
        return !z || !jSONArray0.isNull(v) ? jSONArray0.opt(v) : null;
    }

    // 去混淆评级： 低(20)
    @Nullable
    public static final Object a(@NotNull JSONObject jSONObject0, @NotNull String s, boolean z) {
        return !z || !jSONObject0.isNull(s) ? jSONObject0.opt(s) : null;
    }

    @NotNull
    public static final List a(@NotNull JSONArray jSONArray0) {
        List list0 = new ArrayList();
        int v = jSONArray0.length();
        for(int v1 = 0; v1 < v; ++v1) {
            Object object0 = b0.a(jSONArray0, v1, true);
            if(object0 instanceof JSONArray) {
                object0 = b0.a(((JSONArray)object0));
            }
            else if(object0 instanceof JSONObject) {
                object0 = b0.a(((JSONObject)object0));
            }
            if(object0 != null) {
                ((ArrayList)list0).add(object0);
            }
        }
        return list0;
    }

    public static final List a(JSONObject jSONObject0, String s) {
        q.g(jSONObject0, "$this$getArray");
        q.g(s, "name");
        JSONArray jSONArray0 = jSONObject0.optJSONArray(s);
        List list0 = null;
        if(jSONArray0 != null && jSONArray0.length() != 0) {
            ArrayList arrayList0 = new ArrayList();
            int v = jSONArray0.length();
            for(int v1 = 0; v1 < v; ++v1) {
                try {
                    if(jSONArray0.getJSONObject(v1) != null) {
                        q.k();
                        throw null;
                    }
                }
                catch(Throwable unused_ex) {
                    b.e.b("Failed to parse JSONObject at index " + v1 + " in array \'" + s + '\'', new Object[0]);
                }
            }
            list0 = arrayList0;
        }
        return list0 == null ? w.a : list0;
    }

    @NotNull
    public static final Map a(@NotNull JSONObject jSONObject0) {
        Map map0 = new LinkedHashMap();
        Iterator iterator0 = jSONObject0.keys();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            String s = (String)object0;
            Object object1 = b0.a(jSONObject0, s, true);
            if(object1 instanceof JSONArray) {
                object1 = b0.a(((JSONArray)object1));
            }
            else if(object1 instanceof JSONObject) {
                object1 = b0.a(((JSONObject)object1));
            }
            if(object1 != null) {
                map0.put(s, object1);
            }
        }
        return map0;
    }

    @NotNull
    public static final JSONArray a(@NotNull List list0) {
        JSONArray jSONArray0 = new co.ab180.airbridge.internal.e0.n();
        for(Object object0: list0) {
            if(object0 != null) {
                ((co.ab180.airbridge.internal.e0.n)jSONArray0).put(b0.a(object0));
            }
        }
        return jSONArray0;
    }

    @NotNull
    public static final JSONObject a(@NotNull m m0) {
        JSONObject jSONObject0 = new o();
        Object object0 = m0.a;
        Object object1 = m0.b;
        if(!(object0 instanceof String) || object1 == null) {
            return jSONObject0;
        }
        if(object0 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        ((o)jSONObject0).put("first", ((String)object0));
        if(object1 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
        }
        ((o)jSONObject0).put("second", b0.b(object1));
        return jSONObject0;
    }

    @NotNull
    public static final JSONObject a(@NotNull Map map0) {
        JSONObject jSONObject0 = new o();
        for(Object object0: map0.entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            if(!(map$Entry0.getKey() instanceof String) && !(map$Entry0.getKey() instanceof String) || map$Entry0.getValue() == null) {
                map$Entry0 = null;
            }
            if(map$Entry0 != null) {
                Object object1 = map$Entry0.getKey();
                if(object1 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                Object object2 = map$Entry0.getValue();
                if(object2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                }
                ((o)jSONObject0).put(((String)object1), b0.a(object2));
            }
        }
        return jSONObject0;
    }

    private static final Object b(Object object0) {
        if(b0.d(object0)) {
            return object0;
        }
        if(b0.e(object0)) {
            return object0.toString();
        }
        if(object0 instanceof Object[]) {
            return b0.b(n.z0(((Object[])object0)));
        }
        if(object0 instanceof Set) {
            return b0.b(p.P0(((Iterable)object0)));
        }
        if(object0 instanceof List) {
            return b0.b(((List)object0));
        }
        if(object0 instanceof Map) {
            return b0.b(((Map)object0));
        }
        return object0 instanceof m ? b0.a(((m)object0)) : c.b.b(object0);
    }

    public static final Object b(JSONObject jSONObject0, String s) {
        q.g(jSONObject0, "$this$getObject");
        q.g(s, "name");
        if(jSONObject0.optJSONObject(s) == null) {
            q.k();
            throw null;
        }
        q.k();
        throw null;
    }

    @NotNull
    public static final List b(@NotNull JSONArray jSONArray0) {
        List list0 = new ArrayList();
        int v = jSONArray0.length();
        for(int v1 = 0; v1 < v; ++v1) {
            Object object0 = b0.a(jSONArray0, v1, true);
            if(object0 instanceof JSONArray) {
                object0 = b0.b(((JSONArray)object0));
            }
            else if(object0 instanceof JSONObject) {
                object0 = b0.b(((JSONObject)object0));
            }
            ((ArrayList)list0).add(object0);
        }
        return list0;
    }

    @NotNull
    public static final Map b(@NotNull JSONObject jSONObject0) {
        Map map0 = new LinkedHashMap();
        Iterator iterator0 = jSONObject0.keys();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            Object object1 = b0.a(jSONObject0, ((String)object0), true);
            if(object1 instanceof JSONArray) {
                object1 = b0.b(((JSONArray)object1));
            }
            else if(object1 instanceof JSONObject) {
                object1 = b0.b(((JSONObject)object1));
            }
            map0.put(((String)object0), object1);
        }
        return map0;
    }

    @NotNull
    public static final JSONArray b(@NotNull List list0) {
        JSONArray jSONArray0 = new co.ab180.airbridge.internal.e0.n();
        for(Object object0: list0) {
            if(object0 != null) {
                ((co.ab180.airbridge.internal.e0.n)jSONArray0).put(b0.b(object0));
            }
        }
        return jSONArray0;
    }

    @NotNull
    public static final JSONObject b(@NotNull Map map0) {
        JSONObject jSONObject0 = new o();
        for(Object object0: map0.entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            if((map$Entry0.getKey() instanceof String || map$Entry0.getKey() instanceof String) && map$Entry0.getValue() != null) {
                Object object1 = map$Entry0.getKey();
                if(object1 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                Object object2 = map$Entry0.getValue();
                if(object2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                }
                ((o)jSONObject0).put(((String)object1), b0.b(object2));
            }
        }
        return jSONObject0;
    }

    public static final List c(JSONObject jSONObject0, String s) {
        q.g(jSONObject0, "$this$optArray");
        q.g(s, "name");
        JSONArray jSONArray0 = jSONObject0.optJSONArray(s);
        if(jSONArray0 != null && jSONArray0.length() != 0) {
            List list0 = new ArrayList();
            int v = jSONArray0.length();
            for(int v1 = 0; v1 < v; ++v1) {
                try {
                    if(jSONArray0.getJSONObject(v1) != null) {
                        q.k();
                        throw null;
                    }
                }
                catch(Throwable unused_ex) {
                    b.e.b("Failed to parse JSONObject at index " + v1 + " in array \'" + s + '\'', new Object[0]);
                }
            }
            return list0;
        }
        return null;
    }

    @NotNull
    public static final JSONObject c(@NotNull Object object0) {
        JSONObject jSONObject0 = new o();
        if(!(object0 instanceof m)) {
            object0 = null;
        }
        if(((m)object0) != null) {
            Object object1 = ((m)object0).a;
            if(object1 instanceof String) {
                ((o)jSONObject0).put("first", object1);
                Object object2 = ((m)object0).b;
                if(object2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                }
                ((o)jSONObject0).put("second", b0.a(object2));
                return jSONObject0;
            }
        }
        return jSONObject0;
    }

    public static final float d(@NotNull JSONObject jSONObject0, @NotNull String s) {
        Number number0 = b0.i(jSONObject0, s);
        return number0 == null ? 0.0f : number0.floatValue();
    }

    // 去混淆评级： 中等(190)
    private static final boolean d(Object object0) {
        return object0 instanceof Byte || object0 instanceof Short || object0 instanceof Integer || object0 instanceof Long || object0 instanceof Float || object0 instanceof Double || object0 instanceof Boolean || object0 instanceof String || object0 instanceof Number || object0 instanceof Byte || object0 instanceof Short || object0 instanceof Integer || object0 instanceof Long || object0 instanceof Float || object0 instanceof Double || object0 instanceof Boolean || object0 instanceof String || object0 instanceof JSONObject || object0 instanceof JSONArray;
    }

    @Nullable
    public static final Map e(@NotNull JSONObject jSONObject0, @NotNull String s) {
        JSONObject jSONObject1 = jSONObject0.optJSONObject(s);
        return jSONObject1 == null ? null : b0.a(jSONObject1);
    }

    // 去混淆评级： 低(20)
    private static final boolean e(Object object0) {
        return object0 instanceof Character || object0 instanceof CharSequence;
    }

    @Nullable
    public static final Boolean f(@NotNull JSONObject jSONObject0, @NotNull String s) {
        Object object0 = jSONObject0.opt(s);
        if(!(object0 instanceof Boolean)) {
            object0 = null;
        }
        return (Boolean)object0;
    }

    @Nullable
    public static final Integer g(@NotNull JSONObject jSONObject0, @NotNull String s) {
        Number number0 = b0.i(jSONObject0, s);
        return number0 == null ? null : number0.intValue();
    }

    @Nullable
    public static final Long h(@NotNull JSONObject jSONObject0, @NotNull String s) {
        Number number0 = b0.i(jSONObject0, s);
        return number0 == null ? null : number0.longValue();
    }

    @Nullable
    public static final Number i(@NotNull JSONObject jSONObject0, @NotNull String s) {
        Object object0 = jSONObject0.opt(s);
        if(!(object0 instanceof Number)) {
            object0 = null;
        }
        return (Number)object0;
    }

    @Nullable
    public static final String j(@NotNull JSONObject jSONObject0, @NotNull String s) {
        Object object0 = jSONObject0.opt(s);
        if(!(object0 instanceof String)) {
            object0 = null;
        }
        return (String)object0;
    }

    public static final Object k(JSONObject jSONObject0, String s) {
        q.g(jSONObject0, "$this$optObject");
        q.g(s, "name");
        if(jSONObject0.optJSONObject(s) == null) {
            return null;
        }
        q.k();
        throw null;
    }
}

