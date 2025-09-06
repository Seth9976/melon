package co.ab180.airbridge.internal.e0;

import De.d;
import co.ab180.airbridge.AirbridgeInAppPurchase;
import co.ab180.airbridge.AirbridgeInAppPurchaseEnvironment;
import co.ab180.airbridge.common.Event;
import co.ab180.airbridge.internal.parser.a;
import co.ab180.airbridge.internal.parser.c;
import co.ab180.airbridge.internal.parser.e.y;
import ie.m;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import je.C;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.J;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u001F\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lco/ab180/airbridge/AirbridgeInAppPurchase;", "inAppPurchase", "Lco/ab180/airbridge/AirbridgeInAppPurchaseEnvironment;", "inAppPurchaseEnvironment", "Lco/ab180/airbridge/common/Event;", "a", "(Lco/ab180/airbridge/AirbridgeInAppPurchase;Lco/ab180/airbridge/AirbridgeInAppPurchaseEnvironment;)Lco/ab180/airbridge/common/Event;", "airbridge_release"}, k = 2, mv = {1, 4, 3})
public final class e {
    @NotNull
    public static final Event a(@NotNull AirbridgeInAppPurchase airbridgeInAppPurchase0, @NotNull AirbridgeInAppPurchaseEnvironment airbridgeInAppPurchaseEnvironment0) {
        Object object0;
        Map map1;
        Map map0 = airbridgeInAppPurchase0.getSemanticAttributes();
        LinkedHashMap linkedHashMap0 = map0 == null ? new LinkedHashMap() : C.a0(map0);
        List list0 = null;
        LinkedHashMap linkedHashMap1 = new LinkedHashMap();
        c c0 = c.b;
        String s = airbridgeInAppPurchase0.getPurchase().getOriginalJson();
        J j0 = I.a;
        Class class0 = Map.class;
        d d0 = j0.b(class0);
        if(d0.equals(j0.b(class0))) {
            map1 = b0.b(new JSONObject(s));
            if(map1 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            }
        }
        else {
            if(d0.equals(j0.b(List.class))) {
                List list1 = b0.b(new JSONArray(s));
                if(list1 instanceof Map) {
                    list0 = list1;
                }
                map1 = (Map)list0;
                if(map1 == null) {
                    throw new IllegalAccessException();
                }
                linkedHashMap1.put("iap", C.S(new m[]{new m("purchaseResult", map1), new m("environment", airbridgeInAppPurchaseEnvironment0.getValue$airbridge_release())}));
                return new Event("airbridge.iap", C.U(linkedHashMap0, linkedHashMap1), airbridgeInAppPurchase0.getCustomAttributes());
            }
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
            map1 = (Map)list0;
            if(map1 == null) {
                throw new IllegalAccessException();
            }
        }
        linkedHashMap1.put("iap", C.S(new m[]{new m("purchaseResult", map1), new m("environment", airbridgeInAppPurchaseEnvironment0.getValue$airbridge_release())}));
        return new Event("airbridge.iap", C.U(linkedHashMap0, linkedHashMap1), airbridgeInAppPurchase0.getCustomAttributes());
    }
}

