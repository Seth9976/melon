package co.ab180.airbridge.internal.hybrid.c;

import De.d;
import co.ab180.airbridge.internal.e0.b0;
import co.ab180.airbridge.internal.parser.e.y;
import ie.m;
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

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\tB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000B\u001A\u00020\u0006¢\u0006\u0004\b\u000B\u0010\bJ\u0015\u0010\r\u001A\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f¢\u0006\u0004\b\r\u0010\u000EJ\r\u0010\u000F\u001A\u00020\u0006¢\u0006\u0004\b\u000F\u0010\bJ!\u0010\u0011\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010\"\u0004\b\u0000\u0010\f¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0015\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014¨\u0006\u0016"}, d2 = {"Lco/ab180/airbridge/internal/hybrid/c/c;", "", "", "jsonString", "<init>", "(Ljava/lang/String;)V", "", "d", "()Z", "a", "()Ljava/lang/String;", "f", "T", "c", "()Ljava/lang/Object;", "e", "Lie/m;", "b", "()Lie/m;", "", "Ljava/util/Map;", "data", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class c {
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001A\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001A\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"co/ab180/airbridge/internal/hybrid/c/c$a", "", "", "KEY_KEY", "Ljava/lang/String;", "KEY_VALUE", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {
        private a() {
        }

        public a(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    private static final String a = "key";
    private static final String b = "value";
    @NotNull
    public static final a c;
    private final Map d;

    static {
        c.c = new a(null);
    }

    public c(@NotNull String s) {
        Iterator iterator0;
        x x0;
        Object object0;
        Class class0 = Map.class;
        super();
        try {
            List list0 = null;
            co.ab180.airbridge.internal.parser.c c0 = co.ab180.airbridge.internal.parser.c.b;
            J j0 = I.a;
            d d0 = j0.b(class0);
            if(d0.equals(j0.b(class0))) {
                Map map0 = b0.b(new JSONObject(s));
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
                        if(map$Entry0.getKey() instanceof String) {
                            map$Entry0.getValue();
                            Object object2 = map$Entry0.getKey();
                            if(object2 == null) {
                                break;
                            }
                            x0.put(((String)object2), map$Entry0.getValue());
                        }
                    }
                }
            }
            else if(!d0.equals(j0.b(List.class))) {
                JSONObject jSONObject0 = new JSONObject(s);
                co.ab180.airbridge.internal.parser.a a0 = co.ab180.airbridge.internal.parser.c.a(c0, class0);
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
                List list1 = b0.b(new JSONArray(s));
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
        return (String)this.d.get("key");
    }

    @Nullable
    public final m b() {
        return this.a() == null || this.c() == null ? null : new m(this.a(), this.c());
    }

    @Nullable
    public final Object c() {
        return this.d.get("value");
    }

    public final boolean d() {
        return this.d.containsKey("key");
    }

    // 去混淆评级： 低(20)
    public final boolean e() {
        return this.d() && this.f();
    }

    public final boolean f() {
        return this.d.containsKey("value");
    }
}

