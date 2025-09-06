package co.ab180.airbridge.internal.parser.e;

import co.ab180.airbridge.internal.e0.b0;
import co.ab180.airbridge.internal.thirdparty.huawei.installreferrer.ReferrerDetails;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0007¢\u0006\u0004\b\u000B\u0010\fJ\u001B\u0010\u0006\u001A\u00060\u0002j\u0002`\u00032\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001B\u0010\t\u001A\u00020\u00042\n\u0010\b\u001A\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lco/ab180/airbridge/internal/parser/e/n;", "Lco/ab180/airbridge/internal/parser/e/y;", "Lco/ab180/airbridge/internal/thirdparty/huawei/installreferrer/ReferrerDetails;", "Lco/ab180/airbridge/internal/parser/define/HuaweiReferrerDetails;", "Lorg/json/JSONObject;", "jsonObject", "b", "(Lorg/json/JSONObject;)Lco/ab180/airbridge/internal/thirdparty/huawei/installreferrer/ReferrerDetails;", "src", "a", "(Lco/ab180/airbridge/internal/thirdparty/huawei/installreferrer/ReferrerDetails;)Lorg/json/JSONObject;", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class n extends y {
    @Override  // co.ab180.airbridge.internal.parser.e.y
    public Object a(JSONObject jSONObject0) {
        return this.b(jSONObject0);
    }

    @NotNull
    public JSONObject a(@NotNull ReferrerDetails referrerDetails0) {
        JSONObject jSONObject0 = this.a();
        jSONObject0.put("", referrerDetails0.getInstallReferrer());
        jSONObject0.put("", referrerDetails0.getReferrerClickTimestampMillis());
        jSONObject0.put("", referrerDetails0.getInstallBeginTimestampMillis());
        return jSONObject0;
    }

    @Override  // co.ab180.airbridge.internal.parser.e.y
    public JSONObject a(Object object0) {
        return this.a(((ReferrerDetails)object0));
    }

    // 去混淆评级： 中等(60)
    @NotNull
    public ReferrerDetails b(@NotNull JSONObject jSONObject0) {
        return new ReferrerDetails(b0.j(jSONObject0, ""), b0.h(jSONObject0, ""), b0.h(jSONObject0, ""));
    }
}

