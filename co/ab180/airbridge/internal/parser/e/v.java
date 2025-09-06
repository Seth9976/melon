package co.ab180.airbridge.internal.parser.e;

import co.ab180.airbridge.internal.network.model.OneStoreReferrerDetails;
import ie.d;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@d
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u0005\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lco/ab180/airbridge/internal/parser/e/v;", "Lco/ab180/airbridge/internal/parser/e/y;", "Lco/ab180/airbridge/internal/network/model/OneStoreReferrerDetails;", "Lorg/json/JSONObject;", "jsonObject", "b", "(Lorg/json/JSONObject;)Lco/ab180/airbridge/internal/network/model/OneStoreReferrerDetails;", "src", "a", "(Lco/ab180/airbridge/internal/network/model/OneStoreReferrerDetails;)Lorg/json/JSONObject;", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class v extends y {
    @Override  // co.ab180.airbridge.internal.parser.e.y
    public Object a(JSONObject jSONObject0) {
        return this.b(jSONObject0);
    }

    @NotNull
    public JSONObject a(@NotNull OneStoreReferrerDetails oneStoreReferrerDetails0) {
        JSONObject jSONObject0 = this.a();
        jSONObject0.put("", oneStoreReferrerDetails0.getPid());
        jSONObject0.put("", oneStoreReferrerDetails0.getReferrer());
        jSONObject0.put("", oneStoreReferrerDetails0.getReferrerClickTimestampSeconds());
        jSONObject0.put("", oneStoreReferrerDetails0.getInstallBeginTimestampSeconds());
        return jSONObject0;
    }

    @Override  // co.ab180.airbridge.internal.parser.e.y
    public JSONObject a(Object object0) {
        return this.a(((OneStoreReferrerDetails)object0));
    }

    // 去混淆评级： 中等(80)
    @NotNull
    public OneStoreReferrerDetails b(@NotNull JSONObject jSONObject0) {
        return new OneStoreReferrerDetails(jSONObject0.optString(""), jSONObject0.optString(""), jSONObject0.optLong(""), jSONObject0.optLong(""));
    }
}

