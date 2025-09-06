package co.ab180.airbridge.internal.parser.e;

import co.ab180.airbridge.internal.e0.b0;
import co.ab180.airbridge.internal.network.model.UserInfo;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u0005\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lco/ab180/airbridge/internal/parser/e/c0;", "Lco/ab180/airbridge/internal/parser/e/y;", "Lco/ab180/airbridge/internal/network/model/UserInfo;", "Lorg/json/JSONObject;", "jsonObject", "b", "(Lorg/json/JSONObject;)Lco/ab180/airbridge/internal/network/model/UserInfo;", "src", "a", "(Lco/ab180/airbridge/internal/network/model/UserInfo;)Lorg/json/JSONObject;", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class c0 extends y {
    @Override  // co.ab180.airbridge.internal.parser.e.y
    public Object a(JSONObject jSONObject0) {
        return this.b(jSONObject0);
    }

    @NotNull
    public JSONObject a(@NotNull UserInfo userInfo0) {
        JSONObject jSONObject0 = this.a();
        jSONObject0.put("", userInfo0.getId());
        jSONObject0.put("", userInfo0.getEmail());
        jSONObject0.put("", userInfo0.getPhone());
        Map map0 = userInfo0.getAlias();
        JSONObject jSONObject1 = null;
        jSONObject0.put("", (map0 == null ? null : b0.b(map0)));
        Map map1 = userInfo0.getAttributes();
        if(map1 != null) {
            jSONObject1 = b0.b(map1);
        }
        jSONObject0.put("", jSONObject1);
        jSONObject0.put("", userInfo0.getHashEnabled());
        return jSONObject0;
    }

    @Override  // co.ab180.airbridge.internal.parser.e.y
    public JSONObject a(Object object0) {
        return this.a(((UserInfo)object0));
    }

    @NotNull
    public UserInfo b(@NotNull JSONObject jSONObject0) {
        String s = b0.j(jSONObject0, "");
        String s1 = b0.j(jSONObject0, "");
        String s2 = b0.j(jSONObject0, "");
        Map map0 = b0.e(jSONObject0, "");
        if(!(map0 instanceof Map)) {
            map0 = null;
        }
        return new UserInfo(s, s1, s2, map0, b0.e(jSONObject0, ""), b0.f(jSONObject0, ""));
    }
}

