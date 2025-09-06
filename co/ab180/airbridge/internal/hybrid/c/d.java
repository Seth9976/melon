package co.ab180.airbridge.internal.hybrid.c;

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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\n\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\u000EB\u000F\u0012\u0006\u0010\u0014\u001A\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001A\u00020\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000F\u0010\t\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\u0007J\r\u0010\n\u001A\u00020\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000F\u0010\u000B\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000B\u0010\u0007J\r\u0010\f\u001A\u00020\u0002¢\u0006\u0004\b\f\u0010\u0004J\u001B\u0010\u000E\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r¢\u0006\u0004\b\u000E\u0010\u000FJ\r\u0010\u0010\u001A\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u001B\u0010\u0011\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r¢\u0006\u0004\b\u0011\u0010\u000FR$\u0010\u0013\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012¨\u0006\u0017"}, d2 = {"Lco/ab180/airbridge/internal/hybrid/c/d;", "", "", "i", "()Z", "", "d", "()Ljava/lang/String;", "h", "c", "j", "e", "f", "", "a", "()Ljava/util/Map;", "g", "b", "Ljava/util/Map;", "data", "jsonString", "<init>", "(Ljava/lang/String;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class d {
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001A\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001A\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001A\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001A\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001A\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000B"}, d2 = {"co/ab180/airbridge/internal/hybrid/c/d$a", "", "", "KEY_ALIAS", "Ljava/lang/String;", "KEY_ATTRIBUTES", "KEY_EMAIL", "KEY_ID", "KEY_PHONE", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {
        private a() {
        }

        public a(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    private static final String a = "id";
    private static final String b = "email";
    private static final String c = "phone";
    private static final String d = "alias";
    private static final String e = "attributes";
    @NotNull
    public static final a f;
    private final Map g;

    static {
        d.f = new a(null);
    }

    public d(@NotNull String s) {
        Iterator iterator0;
        x x0;
        Object object0;
        Class class0 = Map.class;
        super();
        try {
            List list0 = null;
            c c0 = c.b;
            J j0 = I.a;
            De.d d0 = j0.b(class0);
            if(d0.equals(j0.b(class0))) {
                Map map0 = b0.b(new JSONObject(s));
                if(map0 != null) {
                    x0 = new LinkedHashMap();
                    iterator0 = map0.entrySet().iterator();
                    while(true) {
                    label_35:
                        if(!iterator0.hasNext()) {
                            this.g = x0;
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
            this.g = x0;
            return;
        }
        this.g = x0;
    }

    @Nullable
    public final Map a() {
        Map map0 = (Map)this.g.get("alias");
        if(map0 != null) {
            Map map1 = new LinkedHashMap();
            for(Object object0: map0.entrySet()) {
                Map.Entry map$Entry0 = (Map.Entry)object0;
                if(map$Entry0.getKey() instanceof String && map$Entry0.getValue() instanceof String) {
                    Object object1 = map$Entry0.getKey();
                    if(object1 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    Object object2 = map$Entry0.getValue();
                    if(object2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    map1.put(((String)object1), ((String)object2));
                }
            }
            return map1;
        }
        return null;
    }

    @Nullable
    public final Map b() {
        Map map0 = (Map)this.g.get("attributes");
        if(map0 != null) {
            Map map1 = new LinkedHashMap();
            for(Object object0: map0.entrySet()) {
                Map.Entry map$Entry0 = (Map.Entry)object0;
                if(map$Entry0.getKey() instanceof String && map$Entry0.getValue() != null) {
                    Object object1 = map$Entry0.getKey();
                    if(object1 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    Object object2 = map$Entry0.getValue();
                    if(object2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                    }
                    map1.put(((String)object1), object2);
                }
            }
            return map1;
        }
        return null;
    }

    @Nullable
    public final String c() {
        return (String)this.g.get("email");
    }

    @Nullable
    public final String d() {
        return (String)this.g.get("id");
    }

    @Nullable
    public final String e() {
        return (String)this.g.get("phone");
    }

    public final boolean f() {
        return this.g.containsKey("alias");
    }

    public final boolean g() {
        return this.g.containsKey("attributes");
    }

    public final boolean h() {
        return this.g.containsKey("email");
    }

    public final boolean i() {
        return this.g.containsKey("id");
    }

    public final boolean j() {
        return this.g.containsKey("phone");
    }
}

