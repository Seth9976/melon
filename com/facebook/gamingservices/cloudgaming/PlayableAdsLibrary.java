package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import org.json.JSONObject;

public class PlayableAdsLibrary {
    public static void markGameLoaded(Context context0, JSONObject jSONObject0, Callback daemonRequest$Callback0) {
        DaemonRequest.executeAsync(context0, jSONObject0, daemonRequest$Callback0, SDKMessageEnum.MARK_GAME_LOADED);
    }

    public static void openAppStore(Context context0, JSONObject jSONObject0, Callback daemonRequest$Callback0) {
        DaemonRequest.executeAsync(context0, jSONObject0, daemonRequest$Callback0, SDKMessageEnum.OPEN_APP_STORE);
    }
}

