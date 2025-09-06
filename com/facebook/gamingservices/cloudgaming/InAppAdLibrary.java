package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import org.json.JSONException;
import org.json.JSONObject;

public class InAppAdLibrary {
    public static void loadInterstitialAd(Context context0, String s, Callback daemonRequest$Callback0) {
        try {
            DaemonRequest.executeAsync(context0, new JSONObject().put("placementID", s), daemonRequest$Callback0, SDKMessageEnum.LOAD_INTERSTITIAL_AD);
        }
        catch(JSONException jSONException0) {
            SDKLogger.logInternalError(context0, SDKMessageEnum.LOAD_INTERSTITIAL_AD, jSONException0);
        }
    }

    public static void loadRewardedVideo(Context context0, String s, Callback daemonRequest$Callback0) {
        try {
            DaemonRequest.executeAsync(context0, new JSONObject().put("placementID", s), daemonRequest$Callback0, SDKMessageEnum.LOAD_REWARDED_VIDEO);
        }
        catch(JSONException jSONException0) {
            SDKLogger.logInternalError(context0, SDKMessageEnum.LOAD_REWARDED_VIDEO, jSONException0);
        }
    }

    public static void showInterstitialAd(Context context0, String s, Callback daemonRequest$Callback0) {
        try {
            DaemonRequest.executeAsync(context0, new JSONObject().put("placementID", s), daemonRequest$Callback0, SDKMessageEnum.SHOW_INTERSTITIAL_AD);
        }
        catch(JSONException jSONException0) {
            SDKLogger.logInternalError(context0, SDKMessageEnum.SHOW_INTERSTITIAL_AD, jSONException0);
        }
    }

    public static void showRewardedVideo(Context context0, String s, Callback daemonRequest$Callback0) {
        try {
            DaemonRequest.executeAsync(context0, new JSONObject().put("placementID", s), daemonRequest$Callback0, SDKMessageEnum.SHOW_REWARDED_VIDEO);
        }
        catch(JSONException jSONException0) {
            SDKLogger.logInternalError(context0, SDKMessageEnum.SHOW_REWARDED_VIDEO, jSONException0);
        }
    }
}

