package Y8;

import com.android.billingclient.api.AccountIdentifiers;
import com.android.billingclient.api.Purchase;
import com.iloen.melon.MelonAppBase;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.List;
import k8.t;
import kotlin.jvm.internal.q;
import org.json.JSONObject;

public abstract class f {
    public static String a(Purchase purchase0) {
        q.g(purchase0, "purchase");
        JSONObject jSONObject0 = new JSONObject();
        MelonAppBase.Companion.getClass();
        jSONObject0.put("cpId", t.a().getMelonCpId());
        AccountIdentifiers accountIdentifiers0 = purchase0.getAccountIdentifiers();
        jSONObject0.put("returnData", (accountIdentifiers0 == null ? null : accountIdentifiers0.getObfuscatedProfileId()));
        JSONObject jSONObject1 = new JSONObject();
        jSONObject1.put("INAPP_PURCHASE_DATA", purchase0.getOriginalJson());
        jSONObject1.put("INAPP_DATA_SIGNATURE", URLEncoder.encode(purchase0.getSignature(), "utf-8"));
        jSONObject1.put("melon", jSONObject0);
        String s = jSONObject1.toString();
        q.f(s, "toString(...)");
        return s;
    }

    public static boolean b(List list0) {
        if(list0 != null && (!(list0 instanceof Collection) || !list0.isEmpty())) {
            for(Object object0: list0) {
                if(!((Purchase)object0).isAcknowledged()) {
                    return true;
                }
                if(false) {
                    break;
                }
            }
        }
        return false;
    }
}

