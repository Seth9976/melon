package Z8;

import com.gaa.sdk.iap.k;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.log.LogU;
import k8.t;
import kotlin.jvm.internal.q;
import org.json.JSONObject;

public final class j {
    static {
    }

    public static String a(k k0, String s) {
        q.g(k0, "purchaseData");
        JSONObject jSONObject0 = new JSONObject();
        jSONObject0.put("orderId", k0.b.optString("orderId"));
        jSONObject0.put("original", k0.b.optString("packageName"));
        jSONObject0.put("productId", k0.b.optString("productId"));
        jSONObject0.put("purchaseTime", k0.b.optLong("purchaseTime"));
        jSONObject0.put("acknowledgeState", ((int)k0.a()));
        jSONObject0.put("purchaseState", k0.b.optInt("purchaseState", 0));
        jSONObject0.put("recurringState", k0.b.optInt("recurringState", -1));
        jSONObject0.put("purchaseId", k0.b.optString("purchaseId"));
        jSONObject0.put("purchaseToken", k0.b.optString("purchaseToken"));
        jSONObject0.put("developerPayload", k0.b.optString("developerPayload"));
        jSONObject0.put("quantity", k0.b.optInt("quantity", 1));
        jSONObject0.put("billingKey", k0.d);
        jSONObject0.put("signature", k0.c);
        jSONObject0.put("original", k0.a);
        if(s != null) {
            JSONObject jSONObject1 = new JSONObject();
            MelonAppBase.Companion.getClass();
            jSONObject1.put("cpId", t.a().getMelonCpId());
            jSONObject1.put("returnData", s);
            jSONObject0.put("melon", jSONObject1);
        }
        LogU.Companion.d("OneStoreIapUtilities", "getJsonStrFromPurchaseData() rootJson:" + jSONObject0);
        String s1 = jSONObject0.toString();
        q.f(s1, "toString(...)");
        return s1;
    }
}

