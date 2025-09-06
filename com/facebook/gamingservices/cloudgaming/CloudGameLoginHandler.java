package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.gamingservices.GamingPayload;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CloudGameLoginHandler {
    private static final int DEFAULT_TIMEOUT_IN_SEC = 5;
    private static boolean IS_RUNNING_IN_CLOUD = false;
    private static SDKLogger mLogger;

    private static List convertPermissionsStringIntoPermissionsList(String s) {
        List list0 = new ArrayList();
        if(!s.isEmpty()) {
            JSONArray jSONArray0 = new JSONArray(s);
            for(int v = 0; v < jSONArray0.length(); ++v) {
                ((ArrayList)list0).add(jSONArray0.get(v).toString());
            }
        }
        return list0;
    }

    public static void gameLoadComplete(Context context0, Callback daemonRequest$Callback0) {
        DaemonRequest.executeAsync(context0, null, daemonRequest$Callback0, SDKMessageEnum.MARK_GAME_LOADED);
    }

    public static AccessToken init(Context context0) {
        synchronized(CloudGameLoginHandler.class) {
            return CloudGameLoginHandler.init(context0, 5);
        }
    }

    public static AccessToken init(Context context0, int v) {
        AccessToken accessToken0;
        synchronized(CloudGameLoginHandler.class) {
            if(v <= 0) {
                v = 5;
            }
            if(CloudGameLoginHandler.isCloudEnvReady(context0, v)) {
                CloudGameLoginHandler.mLogger = SDKLogger.getInstance(context0);
                GraphResponse graphResponse0 = DaemonRequest.executeAndWait(context0, null, SDKMessageEnum.GET_ACCESS_TOKEN, v);
                if(graphResponse0 == null || graphResponse0.getJSONObject() == null) {
                    throw new FacebookException("Cannot receive response.");
                }
                if(graphResponse0.getError() == null) {
                    CloudGameLoginHandler.setPackageName(graphResponse0.getJSONObject(), context0);
                    try {
                        accessToken0 = CloudGameLoginHandler.setCurrentAccessToken(graphResponse0.getJSONObject());
                        GamingPayload.loadPayloadFromCloudGame(graphResponse0.getJSONObject().optString("payload"));
                        Profile.fetchProfileForCurrentAccessToken();
                        CloudGameLoginHandler.IS_RUNNING_IN_CLOUD = true;
                        CloudGameLoginHandler.mLogger.logLoginSuccess();
                        return accessToken0;
                    }
                    catch(JSONException jSONException0) {
                        throw new FacebookException("Cannot properly handle response.", jSONException0);
                    }
                }
                throw new FacebookException(graphResponse0.getError().getErrorMessage());
            }
        }
        throw new FacebookException("Not running in Cloud environment.");
    }

    private static boolean isCloudEnvReady(Context context0, int v) {
        GraphResponse graphResponse0 = DaemonRequest.executeAndWait(context0, null, SDKMessageEnum.IS_ENV_READY, v);
        return graphResponse0 != null && graphResponse0.getJSONObject() != null && graphResponse0.getError() == null;
    }

    public static boolean isRunningInCloud() [...] // 潜在的解密器

    private static AccessToken setCurrentAccessToken(JSONObject jSONObject0) {
        List list4;
        Date date5;
        AccessTokenSource accessTokenSource1;
        Date date4;
        List list3;
        Date date3;
        String s12;
        String s = jSONObject0.optString("accessToken");
        String s1 = jSONObject0.optString("accessTokenSource");
        String s2 = jSONObject0.optString("appID");
        String s3 = jSONObject0.optString("declinedPermissions");
        String s4 = jSONObject0.optString("expiredPermissions");
        String s5 = jSONObject0.optString("expirationTime");
        String s6 = jSONObject0.optString("dataAccessExpirationTime");
        String s7 = jSONObject0.optString("graphDomain");
        String s8 = jSONObject0.optString("lastRefreshTime");
        String s9 = jSONObject0.optString("permissions");
        String s10 = jSONObject0.optString("userID");
        String s11 = jSONObject0.optString("sessionID");
        if(s.isEmpty() || s2.isEmpty() || s10.isEmpty()) {
            return null;
        }
        SDKLogger sDKLogger0 = CloudGameLoginHandler.mLogger;
        if(sDKLogger0 != null) {
            sDKLogger0.setAppID(s2);
            CloudGameLoginHandler.mLogger.setUserID(s10);
            CloudGameLoginHandler.mLogger.setSessionID(s11);
        }
        List list0 = CloudGameLoginHandler.convertPermissionsStringIntoPermissionsList(s9);
        List list1 = CloudGameLoginHandler.convertPermissionsStringIntoPermissionsList(s3);
        List list2 = CloudGameLoginHandler.convertPermissionsStringIntoPermissionsList(s4);
        AccessTokenSource accessTokenSource0 = s1.isEmpty() ? null : AccessTokenSource.valueOf(s1);
        Date date0 = s5.isEmpty() ? null : new Date(((long)Integer.parseInt(s5)) * 1000L);
        Date date1 = s8.isEmpty() ? null : new Date(((long)Integer.parseInt(s8)) * 1000L);
        Date date2 = s6.isEmpty() ? null : new Date(((long)Integer.parseInt(s6)) * 1000L);
        if(s7.isEmpty()) {
            s12 = null;
            list3 = list2;
            date3 = date0;
            date5 = date1;
            date4 = date2;
            list4 = list0;
            accessTokenSource1 = accessTokenSource0;
        }
        else {
            s12 = s7;
            date3 = date0;
            list3 = list2;
            date4 = date2;
            accessTokenSource1 = accessTokenSource0;
            date5 = date1;
            list4 = list0;
        }
        AccessToken accessToken0 = new AccessToken(s, s2, s10, list4, list1, list3, accessTokenSource1, date3, date5, date4, s12);
        AccessToken.setCurrentAccessToken(accessToken0);
        return accessToken0;
    }

    private static void setPackageName(JSONObject jSONObject0, Context context0) {
        String s = jSONObject0.optString("daemonPackageName");
        if(s.isEmpty()) {
            throw new FacebookException("Could not establish a secure connection.");
        }
        SharedPreferences.Editor sharedPreferences$Editor0 = context0.getSharedPreferences("com.facebook.gamingservices.cloudgaming:preferences", 0).edit();
        sharedPreferences$Editor0.putString("daemonPackageName", s);
        sharedPreferences$Editor0.commit();
    }
}

