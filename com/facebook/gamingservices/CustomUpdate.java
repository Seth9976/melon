package com.facebook.gamingservices;

import com.facebook.AccessToken;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequest;
import com.facebook.gamingservices.model.CustomUpdateContent;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001A\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\bH\u0007¨\u0006\t"}, d2 = {"Lcom/facebook/gamingservices/CustomUpdate;", "", "()V", "newCustomUpdateRequest", "Lcom/facebook/GraphRequest;", "content", "Lcom/facebook/gamingservices/model/CustomUpdateContent;", "callback", "Lcom/facebook/GraphRequest$Callback;", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CustomUpdate {
    @NotNull
    public static final CustomUpdate INSTANCE;

    static {
        CustomUpdate.INSTANCE = new CustomUpdate();
    }

    @NotNull
    public static final GraphRequest newCustomUpdateRequest(@NotNull CustomUpdateContent customUpdateContent0, @Nullable Callback graphRequest$Callback0) {
        q.g(customUpdateContent0, "content");
        AccessToken accessToken0 = AccessToken.Companion.getCurrentAccessToken();
        JSONObject jSONObject0 = customUpdateContent0.toGraphRequestContent();
        return GraphRequest.Companion.newPostRequest(accessToken0, "me/custom_update", jSONObject0, graphRequest$Callback0);
    }
}

