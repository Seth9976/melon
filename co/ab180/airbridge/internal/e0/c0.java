package co.ab180.airbridge.internal.e0;

import co.ab180.airbridge.common.Purchase;
import co.ab180.airbridge.internal.d0.a.d;
import co.ab180.airbridge.internal.parser.a;
import co.ab180.airbridge.internal.parser.c;
import co.ab180.airbridge.internal.parser.e.y;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import je.x;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.J;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\u001A\u0015\u0010\u0002\u001A\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001A\u001F\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0004H\u0000¢\u0006\u0004\b\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lco/ab180/airbridge/internal/d0/a/d;", "Lco/ab180/airbridge/common/Purchase;", "a", "(Lco/ab180/airbridge/internal/d0/a/d;)Lco/ab180/airbridge/common/Purchase;", "", "originalJson", "signature", "(Ljava/lang/String;Ljava/lang/String;)Lco/ab180/airbridge/common/Purchase;", "airbridge_release"}, k = 2, mv = {1, 4, 3})
public final class c0 {
    @Nullable
    public static final Purchase a(@NotNull d d0) {
        try {
            return c0.a(d0.c(), d0.d());
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    @NotNull
    public static final Purchase a(@NotNull String s, @NotNull String s1) {
        Iterator iterator0;
        x x0;
        Object object0;
        try {
            Class class0 = Map.class;
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
                    label_34:
                        if(!iterator0.hasNext()) {
                            return new Purchase(s, s1, x0);
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
                a a0 = c.a(c0, class0);
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
                    goto label_34;
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
                    goto label_34;
                }
            }
            x0 = x.a;
        }
        catch(Exception unused_ex) {
            x0 = x.a;
            return new Purchase(s, s1, x0);
        }
        return new Purchase(s, s1, x0);
    }
}

