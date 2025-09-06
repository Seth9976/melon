package com.facebook.applinks;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.bolts.AppLink.Target;
import com.facebook.bolts.AppLink;
import com.facebook.bolts.AppLinkResolver;
import com.facebook.bolts.Continuation;
import com.facebook.bolts.Task;
import com.facebook.bolts.TaskCompletionSource;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookAppLinkResolver implements AppLinkResolver {
    private static final String APP_LINK_ANDROID_TARGET_KEY = "android";
    private static final String APP_LINK_KEY = "app_links";
    private static final String APP_LINK_TARGET_APP_NAME_KEY = "app_name";
    private static final String APP_LINK_TARGET_CLASS_KEY = "class";
    private static final String APP_LINK_TARGET_PACKAGE_KEY = "package";
    private static final String APP_LINK_TARGET_SHOULD_FALLBACK_KEY = "should_fallback";
    private static final String APP_LINK_TARGET_URL_KEY = "url";
    private static final String APP_LINK_WEB_TARGET_KEY = "web";
    private final HashMap cachedAppLinks;

    public FacebookAppLinkResolver() {
        this.cachedAppLinks = new HashMap();
    }

    public static Target access$000(JSONObject jSONObject0) {
        Class class0 = FacebookAppLinkResolver.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            return FacebookAppLinkResolver.getAndroidTargetFromJson(jSONObject0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    public static Uri access$100(Uri uri0, JSONObject jSONObject0) {
        Class class0 = FacebookAppLinkResolver.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            return FacebookAppLinkResolver.getWebFallbackUriFromJson(uri0, jSONObject0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    // 去混淆评级： 低(20)
    public static HashMap access$200(FacebookAppLinkResolver facebookAppLinkResolver0) {
        return CrashShieldHandler.isObjectCrashing(FacebookAppLinkResolver.class) ? null : facebookAppLinkResolver0.cachedAppLinks;
    }

    private static Target getAndroidTargetFromJson(JSONObject jSONObject0) {
        Class class0 = FacebookAppLinkResolver.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            String s = FacebookAppLinkResolver.tryGetStringFromJson(jSONObject0, "package", null);
            if(s == null) {
                return null;
            }
            String s1 = FacebookAppLinkResolver.tryGetStringFromJson(jSONObject0, "class", null);
            String s2 = FacebookAppLinkResolver.tryGetStringFromJson(jSONObject0, "app_name", null);
            String s3 = FacebookAppLinkResolver.tryGetStringFromJson(jSONObject0, "url", null);
            return new Target(s, s1, (s3 == null ? null : Uri.parse(s3)), s2);
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    @Override  // com.facebook.bolts.AppLinkResolver
    public Task getAppLinkFromUrlInBackground(Uri uri0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList arrayList0 = new ArrayList();
            arrayList0.add(uri0);
            return this.getAppLinkFromUrlsInBackground(arrayList0).onSuccess(new Continuation() {
                public AppLink then(Task task0) {
                    return (AppLink)((Map)task0.getResult()).get(uri0);
                }

                @Override  // com.facebook.bolts.Continuation
                public Object then(Task task0) {
                    return this.then(task0);
                }
            });
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    public Task getAppLinkFromUrlsInBackground(List list0) {
        AppLink appLink0;
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            HashMap hashMap0 = new HashMap();
            HashSet hashSet0 = new HashSet();
            StringBuilder stringBuilder0 = new StringBuilder();
            for(Object object0: list0) {
                Uri uri0 = (Uri)object0;
                synchronized(this.cachedAppLinks) {
                    appLink0 = (AppLink)this.cachedAppLinks.get(uri0);
                }
                if(appLink0 == null) {
                    if(!hashSet0.isEmpty()) {
                        stringBuilder0.append(',');
                    }
                    stringBuilder0.append(uri0.toString());
                    hashSet0.add(uri0);
                }
                else {
                    hashMap0.put(uri0, appLink0);
                }
            }
            if(hashSet0.isEmpty()) {
                return Task.forResult(hashMap0);
            }
            TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
            Bundle bundle0 = new Bundle();
            bundle0.putString("ids", stringBuilder0.toString());
            bundle0.putString("fields", "app_links.fields(android,web)");
            new GraphRequest(AccessToken.getCurrentAccessToken(), "", bundle0, null, new Callback() {
                @Override  // com.facebook.GraphRequest$Callback
                public void onCompleted(GraphResponse graphResponse0) {
                    if(!CrashShieldHandler.isObjectCrashing(this)) {
                        try {
                            FacebookRequestError facebookRequestError0 = graphResponse0.getError();
                            if(facebookRequestError0 != null) {
                                taskCompletionSource0.setError(facebookRequestError0.getException());
                                return;
                            }
                            JSONObject jSONObject0 = graphResponse0.getJSONObject();
                            if(jSONObject0 == null) {
                                taskCompletionSource0.setResult(hashMap0);
                                return;
                            }
                            Iterator iterator0 = hashSet0.iterator();
                            while(true) {
                                if(!iterator0.hasNext()) {
                                    taskCompletionSource0.setResult(hashMap0);
                                    return;
                                }
                                Object object0 = iterator0.next();
                                Uri uri0 = (Uri)object0;
                                if(jSONObject0.has(uri0.toString())) {
                                    try {
                                        JSONObject jSONObject1 = jSONObject0.getJSONObject(uri0.toString()).getJSONObject("app_links");
                                        JSONArray jSONArray0 = jSONObject1.getJSONArray("android");
                                        int v = jSONArray0.length();
                                        ArrayList arrayList0 = new ArrayList(v);
                                        for(int v1 = 0; v1 < v; ++v1) {
                                            Target appLink$Target0 = FacebookAppLinkResolver.access$000(jSONArray0.getJSONObject(v1));
                                            if(appLink$Target0 != null) {
                                                arrayList0.add(appLink$Target0);
                                            }
                                        }
                                        AppLink appLink0 = new AppLink(uri0, arrayList0, FacebookAppLinkResolver.access$100(uri0, jSONObject1));
                                        hashMap0.put(uri0, appLink0);
                                        HashMap hashMap0 = FacebookAppLinkResolver.access$200(FacebookAppLinkResolver.this);
                                        synchronized(hashMap0) {
                                            FacebookAppLinkResolver.access$200(FacebookAppLinkResolver.this).put(uri0, appLink0);
                                        }
                                    }
                                    catch(JSONException unused_ex) {
                                    }
                                }
                            }
                        }
                        catch(Throwable throwable0) {
                        }
                        CrashShieldHandler.handleThrowable(throwable0, this);
                    }
                }
            }).executeAsync();
            return taskCompletionSource0.getTask();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    private static Uri getWebFallbackUriFromJson(Uri uri0, JSONObject jSONObject0) {
        Class class0 = FacebookAppLinkResolver.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            JSONObject jSONObject1 = jSONObject0.getJSONObject("web");
            if(!FacebookAppLinkResolver.tryGetBooleanFromJson(jSONObject1, "should_fallback", true)) {
                return null;
            }
            String s = FacebookAppLinkResolver.tryGetStringFromJson(jSONObject1, "url", null);
            if(s != null) {
                Uri uri1 = Uri.parse(s);
                return uri1 == null ? uri0 : uri1;
            }
            return uri0;
        }
        catch(JSONException unused_ex) {
            return uri0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    private static boolean tryGetBooleanFromJson(JSONObject jSONObject0, String s, boolean z) {
        Class class0 = FacebookAppLinkResolver.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return false;
        }
        try {
            return jSONObject0.getBoolean(s);
        }
        catch(JSONException unused_ex) {
            return z;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return false;
        }
    }

    private static String tryGetStringFromJson(JSONObject jSONObject0, String s, String s1) {
        Class class0 = FacebookAppLinkResolver.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            return jSONObject0.getString(s);
        }
        catch(JSONException unused_ex) {
            return s1;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }
}

