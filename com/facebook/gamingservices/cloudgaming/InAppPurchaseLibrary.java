package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import org.json.JSONException;
import org.json.JSONObject;

public class InAppPurchaseLibrary {
    public static void cancelSubscription(Context context0, String s, Callback daemonRequest$Callback0) {
        try {
            DaemonRequest.executeAsync(context0, new JSONObject().put("purchaseToken", s), daemonRequest$Callback0, SDKMessageEnum.CANCEL_SUBSCRIPTION);
        }
        catch(JSONException jSONException0) {
            SDKLogger.logInternalError(context0, SDKMessageEnum.CANCEL_SUBSCRIPTION, jSONException0);
        }
    }

    public static void consumePurchase(Context context0, String s, Callback daemonRequest$Callback0) {
        try {
            DaemonRequest.executeAsync(context0, new JSONObject().put("purchaseToken", s), daemonRequest$Callback0, SDKMessageEnum.CONSUME_PURCHASE);
        }
        catch(JSONException jSONException0) {
            SDKLogger.logInternalError(context0, SDKMessageEnum.CONSUME_PURCHASE, jSONException0);
        }
    }

    public static void getCatalog(Context context0, Callback daemonRequest$Callback0) {
        DaemonRequest.executeAsync(context0, null, daemonRequest$Callback0, SDKMessageEnum.GET_CATALOG);
    }

    public static void getPurchases(Context context0, Callback daemonRequest$Callback0) {
        DaemonRequest.executeAsync(context0, null, daemonRequest$Callback0, SDKMessageEnum.GET_PURCHASES);
    }

    public static void getSubscribableCatalog(Context context0, Callback daemonRequest$Callback0) {
        DaemonRequest.executeAsync(context0, null, daemonRequest$Callback0, SDKMessageEnum.GET_SUBSCRIBABLE_CATALOG);
    }

    public static void getSubscriptions(Context context0, Callback daemonRequest$Callback0) {
        DaemonRequest.executeAsync(context0, null, daemonRequest$Callback0, SDKMessageEnum.GET_SUBSCRIPTIONS);
    }

    public static void onReady(Context context0, Callback daemonRequest$Callback0) {
        DaemonRequest.executeAsync(context0, null, daemonRequest$Callback0, SDKMessageEnum.ON_READY);
    }

    public static void purchase(Context context0, String s, String s1, Callback daemonRequest$Callback0) {
        try {
            DaemonRequest.executeAsync(context0, new JSONObject().put("productID", s).put("developerPayload", s1), daemonRequest$Callback0, SDKMessageEnum.PURCHASE);
        }
        catch(JSONException jSONException0) {
            SDKLogger.logInternalError(context0, SDKMessageEnum.PURCHASE, jSONException0);
        }
    }

    public static void purchaseSubscription(Context context0, String s, Callback daemonRequest$Callback0) {
        try {
            DaemonRequest.executeAsync(context0, new JSONObject().put("productID", s), daemonRequest$Callback0, SDKMessageEnum.PURCHASE_SUBSCRIPTION);
        }
        catch(JSONException jSONException0) {
            SDKLogger.logInternalError(context0, SDKMessageEnum.PURCHASE_SUBSCRIPTION, jSONException0);
        }
    }
}

