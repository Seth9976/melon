package co.ab180.airbridge.internal.parser.e;

import co.ab180.airbridge.internal.e0.b0;
import co.ab180.airbridge.internal.network.model.GoalData;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u0005\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lco/ab180/airbridge/internal/parser/e/l;", "Lco/ab180/airbridge/internal/parser/e/y;", "Lco/ab180/airbridge/internal/network/model/GoalData;", "Lorg/json/JSONObject;", "jsonObject", "b", "(Lorg/json/JSONObject;)Lco/ab180/airbridge/internal/network/model/GoalData;", "src", "a", "(Lco/ab180/airbridge/internal/network/model/GoalData;)Lorg/json/JSONObject;", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class l extends y {
    @Override  // co.ab180.airbridge.internal.parser.e.y
    public Object a(JSONObject jSONObject0) {
        return this.b(jSONObject0);
    }

    @NotNull
    public JSONObject a(@NotNull GoalData goalData0) {
        JSONObject jSONObject0 = this.a();
        jSONObject0.put("", goalData0.getCategory());
        Map map0 = goalData0.getSemanticAttributes();
        JSONObject jSONObject1 = null;
        jSONObject0.put("", (map0 == null ? null : b0.b(map0)));
        Map map1 = goalData0.getCustomAttributes();
        if(map1 != null) {
            jSONObject1 = b0.b(map1);
        }
        jSONObject0.put("", jSONObject1);
        return jSONObject0;
    }

    @Override  // co.ab180.airbridge.internal.parser.e.y
    public JSONObject a(Object object0) {
        return this.a(((GoalData)object0));
    }

    // 去混淆评级： 中等(60)
    @NotNull
    public GoalData b(@NotNull JSONObject jSONObject0) {
        return new GoalData(b0.j(jSONObject0, ""), b0.e(jSONObject0, ""), b0.e(jSONObject0, ""));
    }
}

