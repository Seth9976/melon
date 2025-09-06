package com.facebook.applinks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import va.e;

public class AppLinkData {
    public interface CompletionHandler {
        void onDeferredAppLinkDataFetched(AppLinkData arg1);
    }

    private static final String APPLINK_BRIDGE_ARGS_KEY = "bridge_args";
    private static final String APPLINK_METHOD_ARGS_KEY = "method_args";
    private static final String APPLINK_VERSION_KEY = "version";
    public static final String ARGUMENTS_EXTRAS_KEY = "extras";
    public static final String ARGUMENTS_NATIVE_CLASS_KEY = "com.facebook.platform.APPLINK_NATIVE_CLASS";
    public static final String ARGUMENTS_NATIVE_URL = "com.facebook.platform.APPLINK_NATIVE_URL";
    public static final String ARGUMENTS_REFERER_DATA_KEY = "referer_data";
    public static final String ARGUMENTS_TAPTIME_KEY = "com.facebook.platform.APPLINK_TAP_TIME_UTC";
    private static final String AUTO_APPLINK_FLAG_KEY = "is_auto_applink";
    private static final String BRIDGE_ARGS_METHOD_KEY = "method";
    private static final String BUNDLE_AL_APPLINK_DATA_KEY = "al_applink_data";
    private static final String BUNDLE_APPLINK_ARGS_KEY = "com.facebook.platform.APPLINK_ARGS";
    private static final String DEFERRED_APP_LINK_ARGS_FIELD = "applink_args";
    private static final String DEFERRED_APP_LINK_CLASS_FIELD = "applink_class";
    private static final String DEFERRED_APP_LINK_CLICK_TIME_FIELD = "click_time";
    private static final String DEFERRED_APP_LINK_EVENT = "DEFERRED_APP_LINK";
    private static final String DEFERRED_APP_LINK_PATH = "%s/activities";
    private static final String DEFERRED_APP_LINK_URL_FIELD = "applink_url";
    private static final String EXTRAS_DEEPLINK_CONTEXT_KEY = "deeplink_context";
    private static final String METHOD_ARGS_REF_KEY = "ref";
    private static final String METHOD_ARGS_TARGET_URL_KEY = "target_url";
    private static final String PROMOTION_CODE_KEY = "promo_code";
    private static final String REFERER_DATA_REF_KEY = "fb_ref";
    private static final String TAG = "com.facebook.applinks.AppLinkData";
    private JSONObject appLinkData;
    private Bundle argumentBundle;
    private JSONObject arguments;
    private String promotionCode;
    private String ref;
    private Uri targetUri;

    public static AppLinkData createFromActivity(Activity activity0) {
        Class class0 = AppLinkData.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            Validate.notNull(activity0, "activity");
            Intent intent0 = activity0.getIntent();
            if(intent0 == null) {
                return null;
            }
            AppLinkData appLinkData0 = AppLinkData.createFromAlApplinkData(intent0);
            if(appLinkData0 == null) {
                appLinkData0 = AppLinkData.createFromJson(intent0.getStringExtra("com.facebook.platform.APPLINK_ARGS"));
            }
            return appLinkData0 == null ? AppLinkData.createFromUri(intent0.getData()) : appLinkData0;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    public static AppLinkData createFromAlApplinkData(Intent intent0) {
        Class class0 = AppLinkData.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        if(intent0 == null) {
            return null;
        }
        try {
            Bundle bundle0 = intent0.getBundleExtra("al_applink_data");
            if(bundle0 == null) {
                return null;
            }
            AppLinkData appLinkData0 = new AppLinkData();
            Uri uri0 = intent0.getData();
            appLinkData0.targetUri = uri0;
            appLinkData0.appLinkData = AppLinkData.getAppLinkData(uri0);
            if(appLinkData0.targetUri == null) {
                String s = bundle0.getString("target_url");
                if(s != null) {
                    appLinkData0.targetUri = Uri.parse(s);
                }
            }
            appLinkData0.argumentBundle = bundle0;
            appLinkData0.arguments = null;
            Bundle bundle1 = bundle0.getBundle("referer_data");
            if(bundle1 != null) {
                appLinkData0.ref = bundle1.getString("fb_ref");
            }
            Bundle bundle2 = bundle0.getBundle("extras");
            if(bundle2 != null) {
                String s1 = bundle2.getString("deeplink_context");
                if(s1 != null) {
                    try {
                        JSONObject jSONObject0 = new JSONObject(s1);
                        if(jSONObject0.has("promo_code")) {
                            appLinkData0.promotionCode = jSONObject0.getString("promo_code");
                            return appLinkData0;
                        }
                    }
                    catch(JSONException jSONException0) {
                        Utility.logd("com.facebook.applinks.AppLinkData", "Unable to parse deeplink_context JSON", jSONException0);
                    }
                }
            }
            return appLinkData0;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    private static AppLinkData createFromJson(String s) {
        if(s == null) {
            return null;
        }
        try {
            JSONObject jSONObject0 = new JSONObject(s);
            String s1 = jSONObject0.getString("version");
            if(jSONObject0.getJSONObject("bridge_args").getString("method").equals("applink") && s1.equals("2")) {
                AppLinkData appLinkData0 = new AppLinkData();
                JSONObject jSONObject1 = jSONObject0.getJSONObject("method_args");
                appLinkData0.arguments = jSONObject1;
                if(jSONObject1.has("ref")) {
                    appLinkData0.ref = appLinkData0.arguments.getString("ref");
                }
                else if(appLinkData0.arguments.has("referer_data")) {
                    JSONObject jSONObject2 = appLinkData0.arguments.getJSONObject("referer_data");
                    if(jSONObject2.has("fb_ref")) {
                        appLinkData0.ref = jSONObject2.getString("fb_ref");
                    }
                }
                if(appLinkData0.arguments.has("target_url")) {
                    Uri uri0 = Uri.parse(appLinkData0.arguments.getString("target_url"));
                    appLinkData0.targetUri = uri0;
                    appLinkData0.appLinkData = AppLinkData.getAppLinkData(uri0);
                }
                if(appLinkData0.arguments.has("extras")) {
                    JSONObject jSONObject3 = appLinkData0.arguments.getJSONObject("extras");
                    if(jSONObject3.has("deeplink_context")) {
                        JSONObject jSONObject4 = jSONObject3.getJSONObject("deeplink_context");
                        if(jSONObject4.has("promo_code")) {
                            appLinkData0.promotionCode = jSONObject4.getString("promo_code");
                        }
                    }
                }
                appLinkData0.argumentBundle = AppLinkData.toBundle(appLinkData0.arguments);
                return appLinkData0;
            }
            return null;
        }
        catch(JSONException jSONException0) {
        }
        catch(FacebookException facebookException0) {
            Utility.logd("com.facebook.applinks.AppLinkData", "Unable to parse AppLink JSON", facebookException0);
            return null;
        }
        Utility.logd("com.facebook.applinks.AppLinkData", "Unable to parse AppLink JSON", jSONException0);
        return null;
    }

    private static AppLinkData createFromUri(Uri uri0) {
        if(uri0 == null) {
            return null;
        }
        AppLinkData appLinkData0 = new AppLinkData();
        appLinkData0.targetUri = uri0;
        appLinkData0.appLinkData = AppLinkData.getAppLinkData(uri0);
        return appLinkData0;
    }

    public static void fetchDeferredAppLinkData(Context context0, CompletionHandler appLinkData$CompletionHandler0) {
        AppLinkData.fetchDeferredAppLinkData(context0, null, appLinkData$CompletionHandler0);
    }

    public static void fetchDeferredAppLinkData(Context context0, String s, CompletionHandler appLinkData$CompletionHandler0) {
        Validate.notNull(context0, "context");
        Validate.notNull(appLinkData$CompletionHandler0, "completionHandler");
        if(s == null) {
            s = Utility.getMetadataApplicationId(context0);
        }
        Validate.notNull(s, "applicationId");
        Context context1 = context0.getApplicationContext();
        FacebookSdk.getExecutor().execute(new Runnable() {
            @Override
            public void run() {
                if(CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    AppLinkData.fetchDeferredAppLinkFromServer(context1, s, appLinkData$CompletionHandler0);
                }
                catch(Throwable throwable0) {
                    CrashShieldHandler.handleThrowable(throwable0, this);
                }
            }
        });
    }

    private static void fetchDeferredAppLinkFromServer(Context context0, String s, CompletionHandler appLinkData$CompletionHandler0) {
        AppLinkData appLinkData0;
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("event", "DEFERRED_APP_LINK");
            Utility.setAppEventAttributionParameters(jSONObject0, AttributionIdentifiers.getAttributionIdentifiers(context0), AppEventsLogger.getAnonymousAppDeviceGUID(context0), FacebookSdk.getLimitEventAndDataUsage(context0), context0);
            Utility.setAppEventExtendedDeviceInfoParameters(jSONObject0, FacebookSdk.getApplicationContext());
            jSONObject0.put("application_package_name", "com.iloen.melon");
            appLinkData0 = null;
        }
        catch(JSONException jSONException0) {
            throw new FacebookException("An error occurred while preparing deferred app link", jSONException0);
        }
        try {
            JSONObject jSONObject1 = GraphRequest.newPostRequest(null, s + "/activities", jSONObject0, null).executeAndWait().getJSONObject();
            if(jSONObject1 != null) {
                String s1 = jSONObject1.optString("applink_args");
                long v = jSONObject1.optLong("click_time", -1L);
                String s2 = jSONObject1.optString("applink_class");
                String s3 = jSONObject1.optString("applink_url");
                if(!TextUtils.isEmpty(s1)) {
                    appLinkData0 = AppLinkData.createFromJson(s1);
                    if(appLinkData0 != null) {
                        if(v != -1L) {
                            try {
                                JSONObject jSONObject2 = appLinkData0.arguments;
                                if(jSONObject2 != null) {
                                    jSONObject2.put("com.facebook.platform.APPLINK_TAP_TIME_UTC", v);
                                }
                                Bundle bundle0 = appLinkData0.argumentBundle;
                                if(bundle0 != null) {
                                    bundle0.putString("com.facebook.platform.APPLINK_TAP_TIME_UTC", Long.toString(v));
                                }
                            }
                            catch(JSONException unused_ex) {
                                Utility.logd("com.facebook.applinks.AppLinkData", "Unable to put tap time in AppLinkData.arguments");
                            }
                        }
                        if(s2 != null) {
                            try {
                                JSONObject jSONObject3 = appLinkData0.arguments;
                                if(jSONObject3 != null) {
                                    jSONObject3.put("com.facebook.platform.APPLINK_NATIVE_CLASS", s2);
                                }
                                Bundle bundle1 = appLinkData0.argumentBundle;
                                if(bundle1 != null) {
                                    bundle1.putString("com.facebook.platform.APPLINK_NATIVE_CLASS", s2);
                                }
                            }
                            catch(JSONException unused_ex) {
                                Utility.logd("com.facebook.applinks.AppLinkData", "Unable to put app link class name in AppLinkData.arguments");
                            }
                        }
                        if(s3 != null) {
                            try {
                                JSONObject jSONObject4 = appLinkData0.arguments;
                                if(jSONObject4 != null) {
                                    jSONObject4.put("com.facebook.platform.APPLINK_NATIVE_URL", s3);
                                }
                                Bundle bundle2 = appLinkData0.argumentBundle;
                                if(bundle2 != null) {
                                    bundle2.putString("com.facebook.platform.APPLINK_NATIVE_URL", s3);
                                }
                            }
                            catch(JSONException unused_ex) {
                                Utility.logd("com.facebook.applinks.AppLinkData", "Unable to put app link URL in AppLinkData.arguments");
                            }
                        }
                    }
                }
            }
        }
        catch(Exception unused_ex) {
            Utility.logd("com.facebook.applinks.AppLinkData", "Unable to fetch deferred applink from server");
        }
        appLinkData$CompletionHandler0.onDeferredAppLinkDataFetched(appLinkData0);
    }

    private static JSONObject getAppLinkData(Uri uri0) {
        Class class0 = AppLinkData.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        if(uri0 == null) {
            return null;
        }
        try {
            String s = uri0.getQueryParameter("al_applink_data");
            if(s == null) {
                return null;
            }
            try {
                return new JSONObject(s);
            }
            catch(JSONException unused_ex) {
                return null;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    public JSONObject getAppLinkData() {
        JSONObject jSONObject0 = this.appLinkData;
        return jSONObject0 == null ? new JSONObject() : jSONObject0;
    }

    public Bundle getArgumentBundle() {
        return this.argumentBundle;
    }

    public String getPromotionCode() {
        return this.promotionCode;
    }

    public String getRef() {
        return this.ref;
    }

    public Bundle getRefererData() {
        return this.argumentBundle == null ? null : this.argumentBundle.getBundle("referer_data");
    }

    public Uri getTargetUri() {
        return this.targetUri;
    }

    public boolean isAutoAppLink() {
        Uri uri0 = this.targetUri;
        if(uri0 == null) {
            return false;
        }
        String s = uri0.getHost();
        String s1 = this.targetUri.getScheme();
        String s2 = e.b("fb", FacebookSdk.getApplicationId());
        return this.appLinkData != null && this.appLinkData.optBoolean("is_auto_applink") && "applinks".equals(s) && s2.equals(s1);
    }

    private static Bundle toBundle(JSONObject jSONObject0) {
        Bundle bundle0 = new Bundle();
        Iterator iterator0 = jSONObject0.keys();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            String s = (String)object0;
            Object object1 = jSONObject0.get(s);
            if(object1 instanceof JSONObject) {
                bundle0.putBundle(s, AppLinkData.toBundle(((JSONObject)object1)));
            }
            else {
                if(object1 instanceof JSONArray) {
                    JSONArray jSONArray0 = (JSONArray)object1;
                    int v = 0;
                    if(jSONArray0.length() == 0) {
                        bundle0.putStringArray(s, new String[0]);
                    }
                    else {
                        Object object2 = jSONArray0.get(0);
                        if(object2 instanceof JSONObject) {
                            Bundle[] arr_bundle = new Bundle[jSONArray0.length()];
                            while(v < jSONArray0.length()) {
                                arr_bundle[v] = AppLinkData.toBundle(jSONArray0.getJSONObject(v));
                                ++v;
                            }
                            bundle0.putParcelableArray(s, arr_bundle);
                        }
                        else {
                            if(object2 instanceof JSONArray) {
                                throw new FacebookException("Nested arrays are not supported.");
                            }
                            String[] arr_s = new String[jSONArray0.length()];
                            while(v < jSONArray0.length()) {
                                arr_s[v] = jSONArray0.get(v).toString();
                                ++v;
                            }
                            bundle0.putStringArray(s, arr_s);
                        }
                    }
                    continue;
                }
                bundle0.putString(s, object1.toString());
            }
        }
        return bundle0;
    }
}

