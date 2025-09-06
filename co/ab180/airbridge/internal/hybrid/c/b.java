package co.ab180.airbridge.internal.hybrid.c;

import De.d;
import co.ab180.airbridge.internal.e0.b0;
import co.ab180.airbridge.internal.parser.c;
import co.ab180.airbridge.internal.parser.e.y;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import je.x;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.J;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0001\nB\u000F\u0012\u0006\u0010\u000E\u001A\u00020\u0007¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0003\u001A\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0005\u001A\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001A\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\r\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\n\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\tR\"\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u000B8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\f¨\u0006\u0011"}, d2 = {"Lco/ab180/airbridge/internal/hybrid/c/b;", "", "", "d", "()Z", "c", "e", "", "b", "()Ljava/lang/String;", "a", "", "Ljava/util/Map;", "data", "jsonString", "<init>", "(Ljava/lang/String;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class b {
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001A\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001A\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"co/ab180/airbridge/internal/hybrid/c/b$a", "", "", "KEY_PARAMETER", "Ljava/lang/String;", "KEY_TYPE", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {
        private a() {
        }

        public a(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    private static final String a = "type";
    private static final String b = "parameter";
    @NotNull
    public static final a c;
    private final Map d;

    static {
        b.c = new a(null);
    }

    public b(@NotNull String s) {
        Iterator iterator0;
        x x0;
        Object object0;
        Class class0 = Map.class;
        super();
        try {
            List list0 = null;
            c c0 = c.b;
            J j0 = I.a;
            d d0 = j0.b(class0);
            if(d0.equals(j0.b(class0))) {
                Map map0 = b0.a(new JSONObject(s));
                if(map0 != null) {
                    x0 = new LinkedHashMap();
                    iterator0 = map0.entrySet().iterator();
                    while(true) {
                    label_35:
                        if(!iterator0.hasNext()) {
                            this.d = x0;
                            return;
                        }
                        Object object1 = iterator0.next();
                        Map.Entry map$Entry0 = (Map.Entry)object1;
                        if(map$Entry0.getKey() instanceof String && map$Entry0.getValue() != null) {
                            Object object2 = map$Entry0.getKey();
                            if(object2 == null) {
                                break;
                            }
                            Object object3 = map$Entry0.getValue();
                            if(object3 == null) {
                                break;
                            }
                            x0.put(((String)object2), object3);
                        }
                    }
                }
            }
            else if(!d0.equals(j0.b(List.class))) {
                JSONObject jSONObject0 = new JSONObject(s);
                co.ab180.airbridge.internal.parser.a a0 = c.a(c0, class0);
                if(a0 == null) {
                    object0 = null;
                }
                else {
                    y y0 = a0.b();
                    object0 = y0 == null ? null : y0.a(jSONObject0);
                }
                if(object0 instanceof Map) {
                    list0 = object0;
                }
                if(((Map)list0) != null) {
                    x0 = new LinkedHashMap();
                    iterator0 = ((Map)list0).entrySet().iterator();
                    goto label_35;
                }
            }
            else {
                List list1 = b0.a(new JSONArray(s));
                if(list1 instanceof Map) {
                    list0 = list1;
                }
                if(((Map)list0) != null) {
                    x0 = new LinkedHashMap();
                    iterator0 = ((Map)list0).entrySet().iterator();
                    goto label_35;
                }
            }
            x0 = x.a;
        }
        catch(Exception unused_ex) {
            x0 = x.a;
            this.d = x0;
            return;
        }
        this.d = x0;
    }

    @Nullable
    public final String a() {
        Object object0 = this.d.get("parameter");
        if(object0 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
        }
        if(object0 instanceof Map) {
            c c0 = c.b;
            J j0 = I.a;
            d d0 = j0.b(Map.class);
            if(d0.equals(j0.b(Map.class))) {
                return b0.a(((Map)object0)).toString();
            }
            return d0.equals(j0.b(List.class)) ? b0.a(((List)object0)).toString() : c0.b(object0).toString();
        }
        return null;
    }

    @NotNull
    public final String b() {
        Object object0 = this.d.get("type");
        if(object0 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        return (String)object0;
    }

    private final boolean c() {
        return this.d.containsKey("parameter");
    }

    private final boolean d() {
        return this.d.containsKey("type");
    }

    public final boolean e() {
        return this.d() & this.c();
    }
}

