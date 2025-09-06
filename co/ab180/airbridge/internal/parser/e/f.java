package co.ab180.airbridge.internal.parser.e;

import co.ab180.airbridge.internal.e0.b0;
import co.ab180.airbridge.internal.network.model.EventData;
import co.ab180.airbridge.internal.network.model.GoalData;
import co.ab180.airbridge.internal.network.model.InstallReferrerData;
import co.ab180.airbridge.internal.network.model.MetaInstallReferrerData;
import co.ab180.airbridge.internal.parser.a;
import co.ab180.airbridge.internal.parser.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u0005\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lco/ab180/airbridge/internal/parser/e/f;", "Lco/ab180/airbridge/internal/parser/e/y;", "Lco/ab180/airbridge/internal/network/model/EventData;", "Lorg/json/JSONObject;", "jsonObject", "b", "(Lorg/json/JSONObject;)Lco/ab180/airbridge/internal/network/model/EventData;", "src", "a", "(Lco/ab180/airbridge/internal/network/model/EventData;)Lorg/json/JSONObject;", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class f extends y {
    @Override  // co.ab180.airbridge.internal.parser.e.y
    public Object a(JSONObject jSONObject0) {
        return this.b(jSONObject0);
    }

    @NotNull
    public JSONObject a(@NotNull EventData eventData0) {
        JSONObject jSONObject0 = this.a();
        jSONObject0.put("", eventData0.getSessionId());
        jSONObject0.put("", eventData0.getSessionStartTimestamp());
        jSONObject0.put("", eventData0.getSessionTimeoutMillis());
        jSONObject0.put("", eventData0.getTriggeredBy());
        jSONObject0.put("", eventData0.getDeeplink());
        jSONObject0.put("", eventData0.isUniversalTrackingLink());
        jSONObject0.put("", eventData0.getInstallTimestamp());
        jSONObject0.put("", eventData0.getInstallBeginTimestamp());
        jSONObject0.put("", eventData0.getReferrer());
        jSONObject0.put("", eventData0.getReferrerClickTimestamp());
        jSONObject0.put("", eventData0.getPushToken());
        c c0 = c.b;
        MetaInstallReferrerData metaInstallReferrerData0 = eventData0.getMetaInstallReferrerData();
        JSONObject jSONObject1 = null;
        jSONObject0.put("", (metaInstallReferrerData0 == null ? null : c0.b(metaInstallReferrerData0)));
        InstallReferrerData installReferrerData0 = eventData0.getInstallReferrerData();
        jSONObject0.put("", (installReferrerData0 == null ? null : c0.b(installReferrerData0)));
        jSONObject0.put("", eventData0.getAppMarketIdentifier());
        jSONObject0.put("", eventData0.getAppStorePackageName());
        GoalData goalData0 = eventData0.getGoalData();
        if(goalData0 != null) {
            jSONObject1 = c0.b(goalData0);
        }
        jSONObject0.put("", jSONObject1);
        return jSONObject0;
    }

    @Override  // co.ab180.airbridge.internal.parser.e.y
    public JSONObject a(Object object0) {
        return this.a(((EventData)object0));
    }

    @NotNull
    public EventData b(@NotNull JSONObject jSONObject0) {
        Object object2;
        InstallReferrerData installReferrerData0;
        Object object1;
        MetaInstallReferrerData metaInstallReferrerData0;
        Object object0;
        String s = jSONObject0.optString("");
        long v = jSONObject0.optLong("");
        long v1 = jSONObject0.optLong("");
        String s1 = b0.j(jSONObject0, "");
        String s2 = b0.j(jSONObject0, "");
        Boolean boolean0 = b0.f(jSONObject0, "");
        Long long0 = b0.h(jSONObject0, "");
        Long long1 = b0.h(jSONObject0, "");
        String s3 = b0.j(jSONObject0, "");
        Long long2 = b0.h(jSONObject0, "");
        String s4 = b0.j(jSONObject0, "");
        JSONObject jSONObject1 = jSONObject0.optJSONObject("");
        GoalData goalData0 = null;
        if(jSONObject1 == null) {
            metaInstallReferrerData0 = null;
        }
        else {
            a a0 = c.b.a(MetaInstallReferrerData.class);
            if(a0 == null) {
                object0 = null;
            }
            else {
                y y0 = a0.b();
                object0 = y0 == null ? null : y0.a(jSONObject1);
            }
            if(!(object0 instanceof MetaInstallReferrerData)) {
                object0 = null;
            }
            metaInstallReferrerData0 = (MetaInstallReferrerData)object0;
            if(metaInstallReferrerData0 == null) {
                throw new IllegalAccessException();
            }
        }
        JSONObject jSONObject2 = jSONObject0.optJSONObject("");
        if(jSONObject2 == null) {
            installReferrerData0 = null;
        }
        else {
            a a1 = c.b.a(InstallReferrerData.class);
            if(a1 == null) {
                object1 = null;
            }
            else {
                y y1 = a1.b();
                object1 = y1 == null ? null : y1.a(jSONObject2);
            }
            if(!(object1 instanceof InstallReferrerData)) {
                object1 = null;
            }
            installReferrerData0 = (InstallReferrerData)object1;
            if(installReferrerData0 == null) {
                throw new IllegalAccessException();
            }
        }
        String s5 = b0.j(jSONObject0, "");
        String s6 = b0.j(jSONObject0, "");
        JSONObject jSONObject3 = jSONObject0.optJSONObject("");
        if(jSONObject3 != null) {
            a a2 = c.b.a(GoalData.class);
            if(a2 == null) {
                object2 = null;
            }
            else {
                y y2 = a2.b();
                object2 = y2 == null ? null : y2.a(jSONObject3);
            }
            if(object2 instanceof GoalData) {
                goalData0 = object2;
            }
            if(goalData0 == null) {
                throw new IllegalAccessException();
            }
        }
        return new EventData(s, v, v1, s1, s2, boolean0, long0, long1, s3, long2, s4, metaInstallReferrerData0, installReferrerData0, s5, s6, goalData0);
    }
}

