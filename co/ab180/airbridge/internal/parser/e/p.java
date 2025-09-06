package co.ab180.airbridge.internal.parser.e;

import co.ab180.airbridge.internal.network.model.GalaxyStoreReferrerDetails;
import co.ab180.airbridge.internal.network.model.GoogleReferrerDetails;
import co.ab180.airbridge.internal.network.model.HuaweiStoreReferrerDetails;
import co.ab180.airbridge.internal.network.model.InstallReferrerData;
import co.ab180.airbridge.internal.parser.a;
import co.ab180.airbridge.internal.parser.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u0005\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lco/ab180/airbridge/internal/parser/e/p;", "Lco/ab180/airbridge/internal/parser/e/y;", "Lco/ab180/airbridge/internal/network/model/InstallReferrerData;", "Lorg/json/JSONObject;", "jsonObject", "b", "(Lorg/json/JSONObject;)Lco/ab180/airbridge/internal/network/model/InstallReferrerData;", "src", "a", "(Lco/ab180/airbridge/internal/network/model/InstallReferrerData;)Lorg/json/JSONObject;", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class p extends y {
    @Override  // co.ab180.airbridge.internal.parser.e.y
    public Object a(JSONObject jSONObject0) {
        return this.b(jSONObject0);
    }

    @NotNull
    public JSONObject a(@NotNull InstallReferrerData installReferrerData0) {
        JSONObject jSONObject0 = this.a();
        c c0 = c.b;
        GoogleReferrerDetails googleReferrerDetails0 = installReferrerData0.getGoogleReferrerDetails();
        JSONObject jSONObject1 = null;
        jSONObject0.put("", (googleReferrerDetails0 == null ? null : c0.b(googleReferrerDetails0)));
        HuaweiStoreReferrerDetails huaweiStoreReferrerDetails0 = installReferrerData0.getHuaweiStoreReferrerDetails();
        jSONObject0.put("", (huaweiStoreReferrerDetails0 == null ? null : c0.b(huaweiStoreReferrerDetails0)));
        GalaxyStoreReferrerDetails galaxyStoreReferrerDetails0 = installReferrerData0.getGalaxyStoreReferrerDetails();
        if(galaxyStoreReferrerDetails0 != null) {
            jSONObject1 = c0.b(galaxyStoreReferrerDetails0);
        }
        jSONObject0.put("", jSONObject1);
        return jSONObject0;
    }

    @Override  // co.ab180.airbridge.internal.parser.e.y
    public JSONObject a(Object object0) {
        return this.a(((InstallReferrerData)object0));
    }

    @NotNull
    public InstallReferrerData b(@NotNull JSONObject jSONObject0) {
        Object object2;
        HuaweiStoreReferrerDetails huaweiStoreReferrerDetails0;
        Object object1;
        GoogleReferrerDetails googleReferrerDetails0;
        Object object0;
        JSONObject jSONObject1 = jSONObject0.optJSONObject("");
        GalaxyStoreReferrerDetails galaxyStoreReferrerDetails0 = null;
        if(jSONObject1 == null) {
            googleReferrerDetails0 = null;
        }
        else {
            a a0 = c.b.a(GoogleReferrerDetails.class);
            if(a0 == null) {
                object0 = null;
            }
            else {
                y y0 = a0.b();
                object0 = y0 == null ? null : y0.a(jSONObject1);
            }
            if(!(object0 instanceof GoogleReferrerDetails)) {
                object0 = null;
            }
            googleReferrerDetails0 = (GoogleReferrerDetails)object0;
            if(googleReferrerDetails0 == null) {
                throw new IllegalAccessException();
            }
        }
        JSONObject jSONObject2 = jSONObject0.optJSONObject("");
        if(jSONObject2 == null) {
            huaweiStoreReferrerDetails0 = null;
        }
        else {
            a a1 = c.b.a(HuaweiStoreReferrerDetails.class);
            if(a1 == null) {
                object1 = null;
            }
            else {
                y y1 = a1.b();
                object1 = y1 == null ? null : y1.a(jSONObject2);
            }
            if(!(object1 instanceof HuaweiStoreReferrerDetails)) {
                object1 = null;
            }
            huaweiStoreReferrerDetails0 = (HuaweiStoreReferrerDetails)object1;
            if(huaweiStoreReferrerDetails0 == null) {
                throw new IllegalAccessException();
            }
        }
        JSONObject jSONObject3 = jSONObject0.optJSONObject("");
        if(jSONObject3 != null) {
            a a2 = c.b.a(GalaxyStoreReferrerDetails.class);
            if(a2 == null) {
                object2 = null;
            }
            else {
                y y2 = a2.b();
                object2 = y2 == null ? null : y2.a(jSONObject3);
            }
            if(object2 instanceof GalaxyStoreReferrerDetails) {
                galaxyStoreReferrerDetails0 = object2;
            }
            if(galaxyStoreReferrerDetails0 == null) {
                throw new IllegalAccessException();
            }
        }
        return new InstallReferrerData(googleReferrerDetails0, huaweiStoreReferrerDetails0, galaxyStoreReferrerDetails0);
    }
}

