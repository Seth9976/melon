package co.ab180.airbridge.internal.parser.e;

import De.d;
import co.ab180.airbridge.internal.e0.b0;
import co.ab180.airbridge.internal.network.body.LogData;
import co.ab180.airbridge.internal.network.body.LogInfo;
import co.ab180.airbridge.internal.network.model.AppInfo;
import co.ab180.airbridge.internal.network.model.DeviceInfo;
import co.ab180.airbridge.internal.parser.a;
import co.ab180.airbridge.internal.parser.c;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.J;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u0005\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lco/ab180/airbridge/internal/parser/e/r;", "Lco/ab180/airbridge/internal/parser/e/y;", "Lco/ab180/airbridge/internal/network/body/LogData;", "Lorg/json/JSONObject;", "jsonObject", "b", "(Lorg/json/JSONObject;)Lco/ab180/airbridge/internal/network/body/LogData;", "src", "a", "(Lco/ab180/airbridge/internal/network/body/LogData;)Lorg/json/JSONObject;", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class r extends y {
    @Override  // co.ab180.airbridge.internal.parser.e.y
    public Object a(JSONObject jSONObject0) {
        return this.b(jSONObject0);
    }

    @NotNull
    public JSONObject a(@NotNull LogData logData0) {
        JSONObject jSONObject0 = this.a();
        jSONObject0.put("", logData0.getUuid());
        jSONObject0.put("", logData0.getSdkVersion());
        jSONObject0.put("", logData0.getPlatform());
        jSONObject0.put("", c.b.b(logData0.getLogInfo()));
        jSONObject0.put("", c.b.b(logData0.getAppInfo()));
        jSONObject0.put("", c.b.b(logData0.getDeviceInfo()));
        jSONObject0.put("", logData0.getEventTimestamp());
        return jSONObject0;
    }

    @Override  // co.ab180.airbridge.internal.parser.e.y
    public JSONObject a(Object object0) {
        return this.a(((LogData)object0));
    }

    @NotNull
    public LogData b(@NotNull JSONObject jSONObject0) {
        Object object5;
        DeviceInfo deviceInfo0;
        Object object4;
        Object object3;
        AppInfo appInfo0;
        Object object2;
        Object object1;
        LogInfo logInfo0;
        Object object0;
        String s = jSONObject0.optString("");
        String s1 = jSONObject0.optString("");
        String s2 = jSONObject0.optString("");
        JSONObject jSONObject1 = jSONObject0.optJSONObject("");
        Class class0 = LogInfo.class;
        List list0 = null;
        if(jSONObject1 == null) {
            logInfo0 = null;
        }
        else {
            a a0 = c.b.a(class0);
            if(a0 == null) {
                object0 = null;
            }
            else {
                y y0 = a0.b();
                object0 = y0 == null ? null : y0.a(jSONObject1);
            }
            if(!(object0 instanceof LogInfo)) {
                object0 = null;
            }
            logInfo0 = (LogInfo)object0;
            if(logInfo0 == null) {
                throw new IllegalAccessException();
            }
        }
        Class class1 = List.class;
        Class class2 = Map.class;
        if(logInfo0 == null) {
            c c0 = c.b;
            J j0 = I.a;
            d d0 = j0.b(class0);
            if(d0.equals(j0.b(class2))) {
                Map map0 = b0.a(new JSONObject("{}"));
                if(map0 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type co.ab180.airbridge.internal.network.body.LogInfo");
                }
                logInfo0 = (LogInfo)map0;
            }
            else if(d0.equals(j0.b(class1))) {
                List list1 = b0.a(new JSONArray("{}"));
                if(!(list1 instanceof LogInfo)) {
                    list1 = null;
                }
                logInfo0 = (LogInfo)list1;
                if(logInfo0 == null) {
                    throw new IllegalAccessException();
                }
            }
            else {
                JSONObject jSONObject2 = new JSONObject("{}");
                a a1 = c0.a(class0);
                if(a1 == null) {
                    object1 = null;
                }
                else {
                    y y1 = a1.b();
                    object1 = y1 == null ? null : y1.a(jSONObject2);
                }
                if(!(object1 instanceof LogInfo)) {
                    object1 = null;
                }
                logInfo0 = (LogInfo)object1;
                if(logInfo0 == null) {
                    throw new IllegalAccessException();
                }
            }
        }
        JSONObject jSONObject3 = jSONObject0.optJSONObject("");
        Class class3 = AppInfo.class;
        if(jSONObject3 == null) {
            appInfo0 = null;
        }
        else {
            a a2 = c.b.a(class3);
            if(a2 == null) {
                object2 = null;
            }
            else {
                y y2 = a2.b();
                object2 = y2 == null ? null : y2.a(jSONObject3);
            }
            if(!(object2 instanceof AppInfo)) {
                object2 = null;
            }
            appInfo0 = (AppInfo)object2;
            if(appInfo0 == null) {
                throw new IllegalAccessException();
            }
        }
        if(appInfo0 == null) {
            c c1 = c.b;
            J j1 = I.a;
            d d1 = j1.b(class3);
            if(d1.equals(j1.b(class2))) {
                Map map1 = b0.a(new JSONObject("{}"));
                if(map1 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type co.ab180.airbridge.internal.network.model.AppInfo");
                }
                appInfo0 = (AppInfo)map1;
            }
            else if(d1.equals(j1.b(class1))) {
                List list2 = b0.a(new JSONArray("{}"));
                if(!(list2 instanceof AppInfo)) {
                    list2 = null;
                }
                appInfo0 = (AppInfo)list2;
                if(appInfo0 == null) {
                    throw new IllegalAccessException();
                }
            }
            else {
                JSONObject jSONObject4 = new JSONObject("{}");
                a a3 = c1.a(class3);
                if(a3 == null) {
                    object3 = null;
                }
                else {
                    y y3 = a3.b();
                    object3 = y3 == null ? null : y3.a(jSONObject4);
                }
                if(!(object3 instanceof AppInfo)) {
                    object3 = null;
                }
                appInfo0 = (AppInfo)object3;
                if(appInfo0 == null) {
                    throw new IllegalAccessException();
                }
            }
        }
        JSONObject jSONObject5 = jSONObject0.optJSONObject("");
        Class class4 = DeviceInfo.class;
        if(jSONObject5 == null) {
            deviceInfo0 = null;
        }
        else {
            a a4 = c.b.a(class4);
            if(a4 == null) {
                object4 = null;
            }
            else {
                y y4 = a4.b();
                object4 = y4 == null ? null : y4.a(jSONObject5);
            }
            if(!(object4 instanceof DeviceInfo)) {
                object4 = null;
            }
            deviceInfo0 = (DeviceInfo)object4;
            if(deviceInfo0 == null) {
                throw new IllegalAccessException();
            }
        }
        if(deviceInfo0 == null) {
            c c2 = c.b;
            J j2 = I.a;
            d d2 = j2.b(class4);
            if(d2.equals(j2.b(class2))) {
                Map map2 = b0.a(new JSONObject("{}"));
                if(map2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type co.ab180.airbridge.internal.network.model.DeviceInfo");
                }
                return new LogData(s, s1, s2, logInfo0, appInfo0, ((DeviceInfo)map2), jSONObject0.optLong(""));
            }
            if(d2.equals(j2.b(class1))) {
                List list3 = b0.a(new JSONArray("{}"));
                if(list3 instanceof DeviceInfo) {
                    list0 = list3;
                }
                deviceInfo0 = (DeviceInfo)list0;
                if(deviceInfo0 == null) {
                    throw new IllegalAccessException();
                }
            }
            else {
                JSONObject jSONObject6 = new JSONObject("{}");
                a a5 = c2.a(class4);
                if(a5 == null) {
                    object5 = null;
                }
                else {
                    y y5 = a5.b();
                    object5 = y5 == null ? null : y5.a(jSONObject6);
                }
                if(object5 instanceof DeviceInfo) {
                    list0 = object5;
                }
                deviceInfo0 = (DeviceInfo)list0;
                if(deviceInfo0 == null) {
                    throw new IllegalAccessException();
                }
            }
        }
        return new LogData(s, s1, s2, logInfo0, appInfo0, deviceInfo0, jSONObject0.optLong(""));
    }
}

