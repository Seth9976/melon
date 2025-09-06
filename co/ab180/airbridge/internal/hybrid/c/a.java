package co.ab180.airbridge.internal.hybrid.c;

import De.d;
import co.ab180.airbridge.common.Event;
import co.ab180.airbridge.internal.e0.b0;
import co.ab180.airbridge.internal.parser.c;
import co.ab180.airbridge.internal.parser.e.y;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import je.C;
import je.x;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.J;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\b\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u000BB\u000F\u0012\u0006\u0010\u000E\u001A\u00020\u0006¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004R$\u0010\t\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00058\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0007\u0010\bR#\u0010\r\u001A\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\n8F@\u0006¢\u0006\u0006\u001A\u0004\b\u000B\u0010\f¨\u0006\u0012"}, d2 = {"Lco/ab180/airbridge/internal/hybrid/c/a;", "", "Lco/ab180/airbridge/common/Event;", "b", "()Lco/ab180/airbridge/common/Event;", "", "", "f", "Ljava/util/Map;", "data", "", "a", "()Ljava/util/Map;", "sdkAttributes", "jsonString", "<init>", "(Ljava/lang/String;)V", "e", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class a {
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001A\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001A\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001A\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001A\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"co/ab180/airbridge/internal/hybrid/c/a$a", "", "", "KEY_CATEGORY", "Ljava/lang/String;", "KEY_CUSTOM_ATTRIBUTES", "KEY_SDK_ATTRIBUTES", "KEY_SEMANTIC_ATTRIBUTES", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
    public static final class co.ab180.airbridge.internal.hybrid.c.a.a {
        private co.ab180.airbridge.internal.hybrid.c.a.a() {
        }

        public co.ab180.airbridge.internal.hybrid.c.a.a(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    private static final String a = "category";
    private static final String b = "semanticAttributes";
    private static final String c = "customAttributes";
    private static final String d = "sdkAttributes";
    @NotNull
    public static final co.ab180.airbridge.internal.hybrid.c.a.a e;
    private Map f;

    static {
        a.e = new co.ab180.airbridge.internal.hybrid.c.a.a(null);
    }

    public a(@NotNull String s) {
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
                Map map0 = b0.b(new JSONObject(s));
                if(map0 != null) {
                    x0 = new LinkedHashMap();
                    iterator0 = map0.entrySet().iterator();
                    while(true) {
                    label_35:
                        if(!iterator0.hasNext()) {
                            this.f = x0;
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
            this.f = x0;
            return;
        }
        this.f = x0;
    }

    @Nullable
    public final Map a() {
        if(this.f.containsKey("sdkAttributes")) {
            Map map0 = (Map)this.f.get("sdkAttributes");
            if(map0 != null) {
                LinkedHashMap linkedHashMap0 = new LinkedHashMap();
                for(Object object0: map0.entrySet()) {
                    Map.Entry map$Entry0 = (Map.Entry)object0;
                    if(map$Entry0.getKey() instanceof String) {
                        map$Entry0.getValue();
                        Object object1 = map$Entry0.getKey();
                        if(object1 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        linkedHashMap0.put(((String)object1), map$Entry0.getValue());
                    }
                }
                return C.a0(linkedHashMap0);
            }
        }
        return null;
    }

    @Nullable
    public final Event b() {
        Map map2;
        Object object0 = this.f.get("category");
        Map map0 = null;
        if(((String)object0) != null) {
            Event event0 = new Event(((String)object0), null, null, 6, null);
            if(this.f.containsKey("semanticAttributes")) {
                Map map1 = (Map)this.f.get("semanticAttributes");
                if(map1 == null) {
                    map2 = null;
                }
                else {
                    LinkedHashMap linkedHashMap0 = new LinkedHashMap();
                    for(Object object1: map1.entrySet()) {
                        Map.Entry map$Entry0 = (Map.Entry)object1;
                        if(map$Entry0.getKey() instanceof String && map$Entry0.getValue() != null) {
                            Object object2 = map$Entry0.getKey();
                            if(object2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            Object object3 = map$Entry0.getValue();
                            if(object3 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                            }
                            linkedHashMap0.put(((String)object2), object3);
                        }
                    }
                    map2 = C.a0(linkedHashMap0);
                }
                event0.setSemanticAttributes(map2);
            }
            if(this.f.containsKey("customAttributes")) {
                Map map3 = (Map)this.f.get("customAttributes");
                if(map3 != null) {
                    LinkedHashMap linkedHashMap1 = new LinkedHashMap();
                    for(Object object4: map3.entrySet()) {
                        Map.Entry map$Entry1 = (Map.Entry)object4;
                        if(map$Entry1.getKey() instanceof String && map$Entry1.getValue() != null) {
                            Object object5 = map$Entry1.getKey();
                            if(object5 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            Object object6 = map$Entry1.getValue();
                            if(object6 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                            }
                            linkedHashMap1.put(((String)object5), object6);
                        }
                    }
                    map0 = C.a0(linkedHashMap1);
                }
                event0.setCustomAttributes(map0);
            }
            return event0;
        }
        return null;
    }
}

