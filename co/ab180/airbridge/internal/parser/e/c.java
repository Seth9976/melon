package co.ab180.airbridge.internal.parser.e;

import De.d;
import co.ab180.airbridge.internal.e0.b0;
import co.ab180.airbridge.internal.network.model.DeviceInfo;
import co.ab180.airbridge.internal.network.model.LocationInfo;
import co.ab180.airbridge.internal.network.model.NetworkInfo;
import co.ab180.airbridge.internal.network.model.ScreenInfo;
import co.ab180.airbridge.internal.parser.a;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.J;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u0005\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lco/ab180/airbridge/internal/parser/e/c;", "Lco/ab180/airbridge/internal/parser/e/y;", "Lco/ab180/airbridge/internal/network/model/DeviceInfo;", "Lorg/json/JSONObject;", "jsonObject", "b", "(Lorg/json/JSONObject;)Lco/ab180/airbridge/internal/network/model/DeviceInfo;", "src", "a", "(Lco/ab180/airbridge/internal/network/model/DeviceInfo;)Lorg/json/JSONObject;", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class c extends y {
    @Override  // co.ab180.airbridge.internal.parser.e.y
    public Object a(JSONObject jSONObject0) {
        return this.b(jSONObject0);
    }

    @NotNull
    public JSONObject a(@NotNull DeviceInfo deviceInfo0) {
        JSONObject jSONObject0 = this.a();
        jSONObject0.put("", deviceInfo0.getUuid());
        jSONObject0.put("", deviceInfo0.getHasDataBeforeAppSetIDCollected());
        jSONObject0.put("", deviceInfo0.getBackupUUID());
        jSONObject0.put("", deviceInfo0.getGaid());
        jSONObject0.put("", deviceInfo0.getLimitAdTracking());
        jSONObject0.put("", deviceInfo0.getOaid());
        jSONObject0.put("", deviceInfo0.getOaidLimitAdTracking());
        jSONObject0.put("", deviceInfo0.getAppSetID());
        jSONObject0.put("", deviceInfo0.getAppSetIDScope());
        jSONObject0.put("", deviceInfo0.getModel());
        jSONObject0.put("", deviceInfo0.getType());
        jSONObject0.put("", deviceInfo0.getIp());
        jSONObject0.put("", deviceInfo0.getManufacturer());
        jSONObject0.put("", deviceInfo0.getOsName());
        jSONObject0.put("", deviceInfo0.getOsVersion());
        jSONObject0.put("", deviceInfo0.getLocale());
        jSONObject0.put("", deviceInfo0.getTimezone());
        jSONObject0.put("", deviceInfo0.getOrientation());
        jSONObject0.put("", co.ab180.airbridge.internal.parser.c.b.b(deviceInfo0.getScreenInfo()));
        jSONObject0.put("", co.ab180.airbridge.internal.parser.c.b.b(deviceInfo0.getNetworkInfo()));
        LocationInfo locationInfo0 = deviceInfo0.getLocationInfo();
        JSONObject jSONObject1 = null;
        jSONObject0.put("", (locationInfo0 == null ? null : co.ab180.airbridge.internal.parser.c.b.b(locationInfo0)));
        Map map0 = deviceInfo0.getAlias();
        jSONObject0.put("", (map0 == null ? null : b0.b(map0)));
        Map map1 = deviceInfo0.getIabtcf();
        if(map1 != null) {
            jSONObject1 = b0.b(map1);
        }
        jSONObject0.put("", jSONObject1);
        return jSONObject0;
    }

    @Override  // co.ab180.airbridge.internal.parser.e.y
    public JSONObject a(Object object0) {
        return this.a(((DeviceInfo)object0));
    }

    @NotNull
    public DeviceInfo b(@NotNull JSONObject jSONObject0) {
        LocationInfo locationInfo0;
        Object object4;
        Object object3;
        NetworkInfo networkInfo0;
        Object object2;
        Object object1;
        ScreenInfo screenInfo1;
        ScreenInfo screenInfo0;
        Object object0;
        String s = jSONObject0.optString("");
        boolean z = jSONObject0.optBoolean("");
        String s1 = jSONObject0.optString("");
        String s2 = b0.j(jSONObject0, "");
        Boolean boolean0 = b0.f(jSONObject0, "");
        String s3 = b0.j(jSONObject0, "");
        Boolean boolean1 = b0.f(jSONObject0, "");
        String s4 = b0.j(jSONObject0, "");
        Integer integer0 = b0.g(jSONObject0, "");
        String s5 = jSONObject0.optString("");
        String s6 = jSONObject0.optString("");
        String s7 = jSONObject0.optString("");
        String s8 = jSONObject0.optString("");
        String s9 = jSONObject0.optString("");
        String s10 = jSONObject0.optString("");
        String s11 = jSONObject0.optString("");
        String s12 = jSONObject0.optString("");
        String s13 = jSONObject0.optString("");
        JSONObject jSONObject1 = jSONObject0.optJSONObject("");
        Class class0 = ScreenInfo.class;
        Map map0 = null;
        if(jSONObject1 == null) {
            screenInfo0 = null;
        }
        else {
            a a0 = co.ab180.airbridge.internal.parser.c.b.a(class0);
            if(a0 == null) {
                object0 = null;
            }
            else {
                y y0 = a0.b();
                object0 = y0 == null ? null : y0.a(jSONObject1);
            }
            if(!(object0 instanceof ScreenInfo)) {
                object0 = null;
            }
            screenInfo0 = (ScreenInfo)object0;
            if(screenInfo0 == null) {
                throw new IllegalAccessException();
            }
        }
        Class class1 = List.class;
        Class class2 = Map.class;
        if(screenInfo0 == null) {
            co.ab180.airbridge.internal.parser.c c0 = co.ab180.airbridge.internal.parser.c.b;
            J j0 = I.a;
            d d0 = j0.b(class0);
            if(d0.equals(j0.b(class2))) {
                Map map1 = b0.a(new JSONObject("{}"));
                if(map1 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type co.ab180.airbridge.internal.network.model.ScreenInfo");
                }
                screenInfo1 = (ScreenInfo)map1;
                goto label_72;
            }
            if(d0.equals(j0.b(class1))) {
                List list0 = b0.a(new JSONArray("{}"));
                if(!(list0 instanceof ScreenInfo)) {
                    list0 = null;
                }
                screenInfo1 = (ScreenInfo)list0;
                if(screenInfo1 == null) {
                    throw new IllegalAccessException();
                }
                goto label_72;
            }
            JSONObject jSONObject2 = new JSONObject("{}");
            a a1 = c0.a(class0);
            if(a1 == null) {
                object1 = null;
            }
            else {
                y y1 = a1.b();
                object1 = y1 == null ? null : y1.a(jSONObject2);
            }
            if(!(object1 instanceof ScreenInfo)) {
                object1 = null;
            }
            screenInfo1 = (ScreenInfo)object1;
            if(screenInfo1 == null) {
                throw new IllegalAccessException();
            }
        }
        else {
            screenInfo1 = screenInfo0;
        }
    label_72:
        JSONObject jSONObject3 = jSONObject0.optJSONObject("");
        Class class3 = NetworkInfo.class;
        if(jSONObject3 == null) {
            networkInfo0 = null;
        }
        else {
            a a2 = co.ab180.airbridge.internal.parser.c.b.a(class3);
            if(a2 == null) {
                object2 = null;
            }
            else {
                y y2 = a2.b();
                object2 = y2 == null ? null : y2.a(jSONObject3);
            }
            if(!(object2 instanceof NetworkInfo)) {
                object2 = null;
            }
            networkInfo0 = (NetworkInfo)object2;
            if(networkInfo0 == null) {
                throw new IllegalAccessException();
            }
        }
        if(networkInfo0 == null) {
            co.ab180.airbridge.internal.parser.c c1 = co.ab180.airbridge.internal.parser.c.b;
            J j1 = I.a;
            d d1 = j1.b(class3);
            if(d1.equals(j1.b(class2))) {
                Map map2 = b0.a(new JSONObject("{}"));
                if(map2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type co.ab180.airbridge.internal.network.model.NetworkInfo");
                }
                networkInfo0 = (NetworkInfo)map2;
            }
            else if(d1.equals(j1.b(class1))) {
                List list1 = b0.a(new JSONArray("{}"));
                if(!(list1 instanceof NetworkInfo)) {
                    list1 = null;
                }
                networkInfo0 = (NetworkInfo)list1;
                if(networkInfo0 == null) {
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
                if(!(object3 instanceof NetworkInfo)) {
                    object3 = null;
                }
                networkInfo0 = (NetworkInfo)object3;
                if(networkInfo0 == null) {
                    throw new IllegalAccessException();
                }
            }
        }
        JSONObject jSONObject5 = jSONObject0.optJSONObject("");
        if(jSONObject5 == null) {
            locationInfo0 = null;
        }
        else {
            a a4 = co.ab180.airbridge.internal.parser.c.b.a(LocationInfo.class);
            if(a4 == null) {
                object4 = null;
            }
            else {
                y y4 = a4.b();
                object4 = y4 == null ? null : y4.a(jSONObject5);
            }
            if(!(object4 instanceof LocationInfo)) {
                object4 = null;
            }
            locationInfo0 = (LocationInfo)object4;
            if(locationInfo0 == null) {
                throw new IllegalAccessException();
            }
        }
        Map map3 = b0.e(jSONObject0, "");
        if(map3 instanceof Map) {
            map0 = map3;
        }
        return new DeviceInfo(s, z, s1, s2, boolean0, s3, boolean1, s4, integer0, s5, s6, s7, s8, s9, s10, s11, s12, s13, screenInfo1, networkInfo0, locationInfo0, map0, b0.e(jSONObject0, ""));
    }
}

