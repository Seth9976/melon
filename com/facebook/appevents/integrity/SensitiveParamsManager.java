package com.facebook.appevents.integrity;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0003J\u000F\u0010\u0007\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J!\u0010\f\u001A\u00020\u00042\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0006\u0010\u000B\u001A\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\rJ3\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u000E\u001A\u00020\n2\u001A\u0010\u0011\u001A\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u000Fj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001A\u00020\u00128\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R&\u0010\u0017\u001A\u0012\u0012\u0004\u0012\u00020\n0\u000Fj\b\u0012\u0004\u0012\u00020\n`\u00108\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R2\u0010\u001A\u001A\u001E\u0012\u0004\u0012\u00020\n\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n0\u000Fj\b\u0012\u0004\u0012\u00020\n`\u00100\u00198\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001A\u0010\u001BR\u0014\u0010\u001C\u001A\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001C\u0010\u001DR\u0014\u0010\u001E\u001A\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001E\u0010\u001D¨\u0006\u001F"}, d2 = {"Lcom/facebook/appevents/integrity/SensitiveParamsManager;", "", "<init>", "()V", "Lie/H;", "enable", "disable", "loadSensitiveParameters", "Landroid/os/Bundle;", "parameters", "", "eventName", "processFilterSensitiveParams", "(Landroid/os/Bundle;Ljava/lang/String;)V", "parameterKey", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "sensitiveParamsForEvent", "", "shouldFilterOut", "(Ljava/lang/String;Ljava/util/HashSet;)Z", "enabled", "Z", "defaultSensitiveParameters", "Ljava/util/HashSet;", "", "sensitiveParameters", "Ljava/util/Map;", "DEFAULT_SENSITIVE_PARAMS_KEY", "Ljava/lang/String;", "SENSITIVE_PARAMS_KEY", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class SensitiveParamsManager {
    @NotNull
    private static final String DEFAULT_SENSITIVE_PARAMS_KEY = "_MTSDK_Default_";
    @NotNull
    public static final SensitiveParamsManager INSTANCE = null;
    @NotNull
    private static final String SENSITIVE_PARAMS_KEY = "_filteredKey";
    @NotNull
    private static HashSet defaultSensitiveParameters;
    private static boolean enabled;
    @NotNull
    private static Map sensitiveParameters;

    static {
        SensitiveParamsManager.INSTANCE = new SensitiveParamsManager();
        SensitiveParamsManager.defaultSensitiveParameters = new HashSet();
        SensitiveParamsManager.sensitiveParameters = new HashMap();
    }

    public static final void disable() {
        Class class0 = SensitiveParamsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            SensitiveParamsManager.enabled = false;
            SensitiveParamsManager.sensitiveParameters = new HashMap();
            SensitiveParamsManager.defaultSensitiveParameters = new HashSet();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void enable() {
        Class class0 = SensitiveParamsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            SensitiveParamsManager.INSTANCE.loadSensitiveParameters();
            if(SensitiveParamsManager.defaultSensitiveParameters.isEmpty() && SensitiveParamsManager.sensitiveParameters.isEmpty()) {
                SensitiveParamsManager.enabled = false;
                return;
            }
            SensitiveParamsManager.enabled = true;
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    private final void loadSensitiveParameters() {
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                if(fetchedAppSettings0 != null) {
                    try {
                        SensitiveParamsManager.defaultSensitiveParameters = new HashSet();
                        SensitiveParamsManager.sensitiveParameters = new HashMap();
                        JSONArray jSONArray0 = fetchedAppSettings0.getSensitiveParams();
                        if(jSONArray0 != null && jSONArray0.length() != 0) {
                            int v1 = jSONArray0.length();
                            for(int v = 0; v < v1; ++v) {
                                JSONObject jSONObject0 = jSONArray0.getJSONObject(v);
                                if(jSONObject0.has("key") && jSONObject0.has("value")) {
                                    String s = jSONObject0.getString("key");
                                    JSONArray jSONArray1 = jSONObject0.getJSONArray("value");
                                    if(jSONArray1 != null) {
                                        HashSet hashSet0 = Utility.convertJSONArrayToHashSet(jSONArray1);
                                        if(hashSet0 != null) {
                                            if(s.equals("_MTSDK_Default_")) {
                                                SensitiveParamsManager.defaultSensitiveParameters = hashSet0;
                                            }
                                            else {
                                                SensitiveParamsManager.sensitiveParameters.put(s, hashSet0);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    catch(Exception unused_ex) {
                    }
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
            }
        }
    }

    public static final void processFilterSensitiveParams(@Nullable Bundle bundle0, @NotNull String s) {
        Class class0 = SensitiveParamsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                q.g(s, "eventName");
                if(!SensitiveParamsManager.enabled || bundle0 == null || SensitiveParamsManager.defaultSensitiveParameters.isEmpty() && !SensitiveParamsManager.sensitiveParameters.containsKey(s)) {
                    return;
                }
                JSONArray jSONArray0 = new JSONArray();
                try {
                    HashSet hashSet0 = (HashSet)SensitiveParamsManager.sensitiveParameters.get(s);
                    Iterator iterator0 = new ArrayList(bundle0.keySet()).iterator();
                    while(true) {
                        if(!iterator0.hasNext()) {
                            goto label_16;
                        }
                        Object object0 = iterator0.next();
                        String s1 = (String)object0;
                        q.f(s1, "key");
                        if(SensitiveParamsManager.INSTANCE.shouldFilterOut(s1, hashSet0)) {
                            bundle0.remove(s1);
                            jSONArray0.put(s1);
                        }
                    }
                }
                catch(Exception unused_ex) {
                label_16:
                    if(jSONArray0.length() > 0) {
                        bundle0.putString("_filteredKey", jSONArray0.toString());
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    private final boolean shouldFilterOut(String s, HashSet hashSet0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if(SensitiveParamsManager.defaultSensitiveParameters.contains(s) || hashSet0 != null && !hashSet0.isEmpty() && hashSet0.contains(s)) {
                return true;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
        return false;
    }
}

