package com.facebook.share.internal;

import com.facebook.share.model.CameraEffectArguments.Builder;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\t\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ)\u0010\r\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"com/facebook/share/internal/CameraEffectJSONUtility$SETTERS$2", "Lcom/facebook/share/internal/CameraEffectJSONUtility$Setter;", "Lcom/facebook/share/model/CameraEffectArguments$Builder;", "builder", "", "key", "", "value", "Lie/H;", "setOnArgumentsBuilder", "(Lcom/facebook/share/model/CameraEffectArguments$Builder;Ljava/lang/String;Ljava/lang/Object;)V", "Lorg/json/JSONObject;", "json", "setOnJSON", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CameraEffectJSONUtility.SETTERS.2 implements Setter {
    @Override  // com.facebook.share.internal.CameraEffectJSONUtility$Setter
    public void setOnArgumentsBuilder(@NotNull Builder cameraEffectArguments$Builder0, @NotNull String s, @Nullable Object object0) {
        q.g(cameraEffectArguments$Builder0, "builder");
        q.g(s, "key");
        throw new IllegalArgumentException("Unexpected type from JSON");
    }

    @Override  // com.facebook.share.internal.CameraEffectJSONUtility$Setter
    public void setOnJSON(@NotNull JSONObject jSONObject0, @NotNull String s, @Nullable Object object0) {
        q.g(jSONObject0, "json");
        q.g(s, "key");
        JSONArray jSONArray0 = new JSONArray();
        q.e(object0, "null cannot be cast to non-null type kotlin.Array<kotlin.String?>");
        for(int v = 0; v < ((String[])object0).length; ++v) {
            jSONArray0.put(((String[])object0)[v]);
        }
        jSONObject0.put(s, jSONArray0);
    }
}

