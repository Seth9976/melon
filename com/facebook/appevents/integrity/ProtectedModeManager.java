package com.facebook.appevents.integrity;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import d3.g;
import ie.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0003J\u000F\u0010\b\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\n\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J-\u0010\u0010\u001A\u0016\u0012\u0004\u0012\u00020\u000E\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000E\u0018\u0001`\u000F2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001A\u00020\u00042\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001A\u00020\u00072\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001A\u00020\u00078\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001A\u001A\u00020\u000E8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001A\u0010\u001BR\u0014\u0010\u001C\u001A\u00020\u000E8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001C\u0010\u001BR+\u0010!\u001A\u0012\u0012\u0004\u0012\u00020\u000E0\rj\b\u0012\u0004\u0012\u00020\u000E`\u000F8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001D\u0010\u001E\u001A\u0004\b\u001F\u0010 R*\u0010\"\u001A\u0016\u0012\u0004\u0012\u00020\u000E\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000E\u0018\u0001`\u000F8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/facebook/appevents/integrity/ProtectedModeManager;", "", "<init>", "()V", "Lie/H;", "enable", "disable", "", "isEnabled", "()Z", "loadStandardParams", "Lorg/json/JSONArray;", "jsonArray", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "convertJSONArrayToHashSet", "(Lorg/json/JSONArray;)Ljava/util/HashSet;", "Landroid/os/Bundle;", "parameters", "processParametersForProtectedMode", "(Landroid/os/Bundle;)V", "protectedModeIsApplied", "(Landroid/os/Bundle;)Z", "enabled", "Z", "PROTECTED_MODE_IS_APPLIED_KEY", "Ljava/lang/String;", "PROTECTED_MODE_IS_APPLIED_VALUE", "defaultStandardParameterNames$delegate", "Lie/j;", "getDefaultStandardParameterNames", "()Ljava/util/HashSet;", "defaultStandardParameterNames", "standardParams", "Ljava/util/HashSet;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ProtectedModeManager {
    @NotNull
    public static final ProtectedModeManager INSTANCE = null;
    @NotNull
    private static final String PROTECTED_MODE_IS_APPLIED_KEY = "pm";
    @NotNull
    private static final String PROTECTED_MODE_IS_APPLIED_VALUE = "1";
    @NotNull
    private static final j defaultStandardParameterNames$delegate;
    private static boolean enabled;
    @Nullable
    private static HashSet standardParams;

    static {
        ProtectedModeManager.INSTANCE = new ProtectedModeManager();
        ProtectedModeManager.defaultStandardParameterNames$delegate = g.Q(ProtectedModeManager.defaultStandardParameterNames.2.INSTANCE);
    }

    private final HashSet convertJSONArrayToHashSet(JSONArray jSONArray0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        if(jSONArray0 != null) {
            try {
                if(jSONArray0.length() != 0) {
                    HashSet hashSet0 = new HashSet();
                    int v = jSONArray0.length();
                    for(int v1 = 0; v1 < v; ++v1) {
                        String s = jSONArray0.getString(v1);
                        q.f(s, "jsonArray.getString(i)");
                        hashSet0.add(s);
                    }
                    return hashSet0;
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
            }
        }
        return null;
    }

    public static final void disable() {
        if(CrashShieldHandler.isObjectCrashing(ProtectedModeManager.class)) {
            return;
        }
        ProtectedModeManager.enabled = false;
    }

    public static final void enable() {
        Class class0 = ProtectedModeManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            ProtectedModeManager.enabled = true;
            ProtectedModeManager.INSTANCE.loadStandardParams();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    @NotNull
    public final HashSet getDefaultStandardParameterNames() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return (HashSet)ProtectedModeManager.defaultStandardParameterNames$delegate.getValue();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    // 去混淆评级： 低(20)
    public static final boolean isEnabled() {
        return CrashShieldHandler.isObjectCrashing(ProtectedModeManager.class) ? false : ProtectedModeManager.enabled;
    }

    private final void loadStandardParams() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                if(fetchedAppSettings0 != null) {
                    HashSet hashSet0 = this.convertJSONArrayToHashSet(fetchedAppSettings0.getProtectedModeStandardParamsSetting());
                    if(hashSet0 == null) {
                        hashSet0 = this.getDefaultStandardParameterNames();
                    }
                    ProtectedModeManager.standardParams = hashSet0;
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    public static final void processParametersForProtectedMode(@Nullable Bundle bundle0) {
        Class class0 = ProtectedModeManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                if(ProtectedModeManager.enabled && bundle0 != null && !bundle0.isEmpty() && ProtectedModeManager.standardParams != null) {
                    ArrayList arrayList0 = new ArrayList();
                    Set set0 = bundle0.keySet();
                    q.f(set0, "parameters.keySet()");
                    for(Object object0: set0) {
                        String s = (String)object0;
                        HashSet hashSet0 = ProtectedModeManager.standardParams;
                        q.d(hashSet0);
                        if(!hashSet0.contains(s)) {
                            q.f(s, "param");
                            arrayList0.add(s);
                        }
                    }
                    for(Object object1: arrayList0) {
                        bundle0.remove(((String)object1));
                    }
                    bundle0.putString("pm", "1");
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    public final boolean protectedModeIsApplied(@Nullable Bundle bundle0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        if(bundle0 == null) {
            return false;
        }
        try {
            if(bundle0.containsKey("pm") && q.b(bundle0.get("pm"), "1")) {
                return true;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
        return false;
    }
}

