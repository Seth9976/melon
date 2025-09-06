package co.ab180.airbridge.internal.parser.e;

import De.d;
import co.ab180.airbridge.internal.e0.b0;
import co.ab180.airbridge.internal.network.response.GeneratedTrackingLinkInfo;
import co.ab180.airbridge.internal.network.response.GeneratedTrackingLinkResult;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u0005\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lco/ab180/airbridge/internal/parser/e/k;", "Lco/ab180/airbridge/internal/parser/e/y;", "Lco/ab180/airbridge/internal/network/response/GeneratedTrackingLinkResult;", "Lorg/json/JSONObject;", "jsonObject", "b", "(Lorg/json/JSONObject;)Lco/ab180/airbridge/internal/network/response/GeneratedTrackingLinkResult;", "src", "a", "(Lco/ab180/airbridge/internal/network/response/GeneratedTrackingLinkResult;)Lorg/json/JSONObject;", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class k extends y {
    @Override  // co.ab180.airbridge.internal.parser.e.y
    public Object a(JSONObject jSONObject0) {
        return this.b(jSONObject0);
    }

    @NotNull
    public JSONObject a(@NotNull GeneratedTrackingLinkResult generatedTrackingLinkResult0) {
        JSONObject jSONObject0 = this.a();
        jSONObject0.put("", c.b.b(generatedTrackingLinkResult0));
        return jSONObject0;
    }

    @Override  // co.ab180.airbridge.internal.parser.e.y
    public JSONObject a(Object object0) {
        return this.a(((GeneratedTrackingLinkResult)object0));
    }

    @NotNull
    public GeneratedTrackingLinkResult b(@NotNull JSONObject jSONObject0) {
        Object object1;
        GeneratedTrackingLinkInfo generatedTrackingLinkInfo0;
        Object object0;
        JSONObject jSONObject1 = jSONObject0.optJSONObject("");
        Class class0 = GeneratedTrackingLinkInfo.class;
        List list0 = null;
        if(jSONObject1 == null) {
            generatedTrackingLinkInfo0 = null;
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
            if(!(object0 instanceof GeneratedTrackingLinkInfo)) {
                object0 = null;
            }
            generatedTrackingLinkInfo0 = (GeneratedTrackingLinkInfo)object0;
            if(generatedTrackingLinkInfo0 == null) {
                throw new IllegalAccessException();
            }
        }
        if(generatedTrackingLinkInfo0 == null) {
            c c0 = c.b;
            J j0 = I.a;
            d d0 = j0.b(class0);
            if(d0.equals(j0.b(Map.class))) {
                Map map0 = b0.a(new JSONObject("{}"));
                if(map0 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type co.ab180.airbridge.internal.network.response.GeneratedTrackingLinkInfo");
                }
                return new GeneratedTrackingLinkResult(((GeneratedTrackingLinkInfo)map0));
            }
            if(d0.equals(j0.b(List.class))) {
                List list1 = b0.a(new JSONArray("{}"));
                if(list1 instanceof GeneratedTrackingLinkInfo) {
                    list0 = list1;
                }
                generatedTrackingLinkInfo0 = (GeneratedTrackingLinkInfo)list0;
                if(generatedTrackingLinkInfo0 == null) {
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
                if(object1 instanceof GeneratedTrackingLinkInfo) {
                    list0 = object1;
                }
                generatedTrackingLinkInfo0 = (GeneratedTrackingLinkInfo)list0;
                if(generatedTrackingLinkInfo0 == null) {
                    throw new IllegalAccessException();
                }
            }
        }
        return new GeneratedTrackingLinkResult(generatedTrackingLinkInfo0);
    }
}

