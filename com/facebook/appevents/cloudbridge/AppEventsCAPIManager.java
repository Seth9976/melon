package com.facebook.appevents.cloudbridge;

import Tf.o;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger.Companion;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\n\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0000¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001A\u00020\u000B8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001C\u0010\u000F\u001A\n \u000E*\u0004\u0018\u00010\u000B0\u000B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000F\u0010\rR\"\u0010\u0011\u001A\u00020\u00108\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R@\u0010\u001D\u001A\u0010\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00172\u0014\u0010\u0018\u001A\u0010\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00178A@@X\u0080\u000E¢\u0006\f\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001C¨\u0006\u001E"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsCAPIManager;", "", "<init>", "()V", "Lie/H;", "enable", "Lcom/facebook/GraphResponse;", "response", "getCAPIGSettingsFromGraphResponse$facebook_core_release", "(Lcom/facebook/GraphResponse;)V", "getCAPIGSettingsFromGraphResponse", "", "SETTINGS_PATH", "Ljava/lang/String;", "kotlin.jvm.PlatformType", "TAG", "", "isEnabled", "Z", "isEnabled$facebook_core_release", "()Z", "setEnabled$facebook_core_release", "(Z)V", "", "valuesToSave", "getSavedCloudBridgeCredentials$facebook_core_release", "()Ljava/util/Map;", "setSavedCloudBridgeCredentials$facebook_core_release", "(Ljava/util/Map;)V", "savedCloudBridgeCredentials", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AppEventsCAPIManager {
    @NotNull
    public static final AppEventsCAPIManager INSTANCE = null;
    @NotNull
    private static final String SETTINGS_PATH = "/cloudbridge_settings";
    private static final String TAG;
    private static boolean isEnabled;

    static {
        AppEventsCAPIManager.INSTANCE = new AppEventsCAPIManager();
        AppEventsCAPIManager.TAG = AppEventsCAPIManager.class.getCanonicalName();
    }

    public static final void enable() {
        try {
            a a0 = new a(0);
            GraphRequest graphRequest0 = new GraphRequest(null, FacebookSdk.getApplicationId() + "/cloudbridge_settings", null, HttpMethod.GET, a0, null, 0x20, null);
            q.e(AppEventsCAPIManager.TAG, "null cannot be cast to non-null type kotlin.String");
            Logger.Companion.log(LoggingBehavior.APP_EVENTS, AppEventsCAPIManager.TAG, " \n\nCreating Graph Request: \n=============\n%s\n\n ", new Object[]{graphRequest0});
            graphRequest0.executeAsync();
        }
        catch(JSONException jSONException0) {
            q.e(AppEventsCAPIManager.TAG, "null cannot be cast to non-null type kotlin.String");
            Object[] arr_object = {e2.a.T(jSONException0)};
            Logger.Companion.log(LoggingBehavior.APP_EVENTS, AppEventsCAPIManager.TAG, " \n\nGraph Request Exception: \n=============\n%s\n\n ", arr_object);
        }
    }

    private static final void enable$lambda$0(GraphResponse graphResponse0) {
        q.g(graphResponse0, "response");
        AppEventsCAPIManager.INSTANCE.getCAPIGSettingsFromGraphResponse$facebook_core_release(graphResponse0);
    }

    public final void getCAPIGSettingsFromGraphResponse$facebook_core_release(@NotNull GraphResponse graphResponse0) {
        boolean z;
        String s3;
        String s2;
        String s1;
        Map map1;
        q.g(graphResponse0, "response");
        if(graphResponse0.getError() != null) {
            q.e(AppEventsCAPIManager.TAG, "null cannot be cast to non-null type kotlin.String");
            Logger.Companion.log(LoggingBehavior.APP_EVENTS, AppEventsCAPIManager.TAG, " \n\nGraph Response Error: \n================\nResponse Error: %s\nResponse Error Exception: %s\n\n ", new Object[]{graphResponse0.getError().toString(), String.valueOf(graphResponse0.getError().getException())});
            Map map0 = AppEventsCAPIManager.getSavedCloudBridgeCredentials$facebook_core_release();
            if(map0 != null) {
                URL uRL0 = new URL(String.valueOf(map0.get("endpoint")));
                AppEventsConversionsAPITransformerWebRequests.configure(String.valueOf(map0.get("dataset_id")), uRL0.getProtocol() + "://" + uRL0.getHost(), String.valueOf(map0.get("access_key")));
                AppEventsCAPIManager.isEnabled = true;
            }
            return;
        }
        Companion logger$Companion0 = Logger.Companion;
        LoggingBehavior loggingBehavior0 = LoggingBehavior.APP_EVENTS;
        String s = AppEventsCAPIManager.TAG;
        q.e(s, "null cannot be cast to non-null type kotlin.String");
        logger$Companion0.log(loggingBehavior0, s, " \n\nGraph Response Received: \n================\n%s\n\n ", new Object[]{graphResponse0});
        JSONObject jSONObject0 = graphResponse0.getJSONObject();
        try {
            Object object0 = jSONObject0 == null ? null : jSONObject0.get("data");
            q.e(object0, "null cannot be cast to non-null type org.json.JSONArray");
            map1 = Utility.convertJSONObjectToHashMap(new JSONObject(((String)p.m0(Utility.convertJSONArrayToList(((JSONArray)object0))))));
            s1 = (String)map1.get("endpoint");
            s2 = (String)map1.get("dataset_id");
            s3 = (String)map1.get("access_key");
            goto label_34;
        }
        catch(JSONException jSONException0) {
        }
        catch(NullPointerException nullPointerException0) {
            goto label_30;
        }
        q.f(AppEventsCAPIManager.TAG, "TAG");
        Object[] arr_object = {e2.a.T(jSONException0)};
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, AppEventsCAPIManager.TAG, "CloudBridge Settings API response is not a valid json: \n%s ", arr_object);
        return;
    label_30:
        q.f(AppEventsCAPIManager.TAG, "TAG");
        Object[] arr_object1 = {e2.a.T(nullPointerException0)};
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, AppEventsCAPIManager.TAG, "CloudBridge Settings API response is not a valid json: \n%s ", arr_object1);
        return;
    label_34:
        if(s1 != null && s2 != null && s3 != null) {
            try {
                AppEventsConversionsAPITransformerWebRequests.configure(s2, s1, s3);
                this.setSavedCloudBridgeCredentials$facebook_core_release(map1);
            }
            catch(MalformedURLException malformedURLException0) {
                q.f(AppEventsCAPIManager.TAG, "TAG");
                Object[] arr_object2 = {e2.a.T(malformedURLException0)};
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, AppEventsCAPIManager.TAG, "CloudBridge Settings API response doesn\'t have valid url\n %s ", arr_object2);
                return;
            }
            SettingsAPIFields settingsAPIFields0 = SettingsAPIFields.ENABLED;
            if(map1.get("is_enabled") == null) {
                z = false;
            }
            else {
                Object object1 = map1.get(settingsAPIFields0.getRawValue());
                q.e(object1, "null cannot be cast to non-null type kotlin.Boolean");
                z = ((Boolean)object1).booleanValue();
            }
            AppEventsCAPIManager.isEnabled = z;
            return;
        }
        q.f(s, "TAG");
        logger$Companion0.log(loggingBehavior0, s, "CloudBridge Settings API response doesn\'t have valid data");
    }

    @Nullable
    public static final Map getSavedCloudBridgeCredentials$facebook_core_release() {
        Class class0 = AppEventsCAPIManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences0 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.CloudBridgeSavedCredentials", 0);
            if(sharedPreferences0 == null) {
                return null;
            }
            SettingsAPIFields settingsAPIFields0 = SettingsAPIFields.DATASETID;
            String s = sharedPreferences0.getString("dataset_id", null);
            SettingsAPIFields settingsAPIFields1 = SettingsAPIFields.URL;
            String s1 = sharedPreferences0.getString("endpoint", null);
            SettingsAPIFields settingsAPIFields2 = SettingsAPIFields.ACCESSKEY;
            String s2 = sharedPreferences0.getString("access_key", null);
            if(s != null && !o.H0(s) && s1 != null && !o.H0(s1) && s2 != null && !o.H0(s2)) {
                Map map0 = new LinkedHashMap();
                map0.put(settingsAPIFields1.getRawValue(), s1);
                map0.put(settingsAPIFields0.getRawValue(), s);
                map0.put(settingsAPIFields2.getRawValue(), s2);
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, AppEventsCAPIManager.TAG.toString(), " \n\nLoading Cloudbridge settings from saved Prefs: \n================\n DATASETID: %s\n URL: %s \n ACCESSKEY: %s \n\n ", new Object[]{s, s1, s2});
                return map0;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
        return null;
    }

    public final boolean isEnabled$facebook_core_release() {
        return AppEventsCAPIManager.isEnabled;
    }

    public final void setEnabled$facebook_core_release(boolean z) {
        AppEventsCAPIManager.isEnabled = z;
    }

    public final void setSavedCloudBridgeCredentials$facebook_core_release(@Nullable Map map0) {
        SharedPreferences sharedPreferences0 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.CloudBridgeSavedCredentials", 0);
        if(sharedPreferences0 != null) {
            if(map0 == null) {
                SharedPreferences.Editor sharedPreferences$Editor0 = sharedPreferences0.edit();
                sharedPreferences$Editor0.clear();
                sharedPreferences$Editor0.apply();
                return;
            }
            SettingsAPIFields settingsAPIFields0 = SettingsAPIFields.DATASETID;
            Object object0 = map0.get("dataset_id");
            SettingsAPIFields settingsAPIFields1 = SettingsAPIFields.URL;
            Object object1 = map0.get("endpoint");
            SettingsAPIFields settingsAPIFields2 = SettingsAPIFields.ACCESSKEY;
            Object object2 = map0.get("access_key");
            if(object0 != null && object1 != null && object2 != null) {
                SharedPreferences.Editor sharedPreferences$Editor1 = sharedPreferences0.edit();
                sharedPreferences$Editor1.putString(settingsAPIFields0.getRawValue(), object0.toString());
                sharedPreferences$Editor1.putString(settingsAPIFields1.getRawValue(), object1.toString());
                sharedPreferences$Editor1.putString(settingsAPIFields2.getRawValue(), object2.toString());
                sharedPreferences$Editor1.apply();
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, AppEventsCAPIManager.TAG.toString(), " \n\nSaving Cloudbridge settings from saved Prefs: \n================\n DATASETID: %s\n URL: %s \n ACCESSKEY: %s \n\n ", new Object[]{object0, object1, object2});
            }
        }
    }
}

