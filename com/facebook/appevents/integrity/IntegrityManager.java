package com.facebook.appevents.integrity;

import com.facebook.FacebookSdk;
import com.facebook.appevents.ml.ModelManager.Task;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u000E\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J#\u0010\t\u001A\u00020\u00042\u0012\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0010\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001A\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001A\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001A\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0016\u0010\u0017\u001A\u00020\f8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001A\u00020\f8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018¨\u0006\u001A"}, d2 = {"Lcom/facebook/appevents/integrity/IntegrityManager;", "", "<init>", "()V", "Lie/H;", "enable", "", "", "parameters", "processParameters", "(Ljava/util/Map;)V", "input", "", "shouldFilter", "(Ljava/lang/String;)Z", "textFeature", "getIntegrityPredictionResult", "(Ljava/lang/String;)Ljava/lang/String;", "INTEGRITY_TYPE_NONE", "Ljava/lang/String;", "INTEGRITY_TYPE_ADDRESS", "INTEGRITY_TYPE_HEALTH", "RESTRICTIVE_ON_DEVICE_PARAMS_KEY", "enabled", "Z", "isSampleEnabled", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class IntegrityManager {
    @NotNull
    public static final IntegrityManager INSTANCE = null;
    @NotNull
    public static final String INTEGRITY_TYPE_ADDRESS = "address";
    @NotNull
    public static final String INTEGRITY_TYPE_HEALTH = "health";
    @NotNull
    public static final String INTEGRITY_TYPE_NONE = "none";
    @NotNull
    private static final String RESTRICTIVE_ON_DEVICE_PARAMS_KEY = "_onDeviceParams";
    private static boolean enabled;
    private static boolean isSampleEnabled;

    static {
        IntegrityManager.INSTANCE = new IntegrityManager();
    }

    public static final void enable() {
        Class class0 = IntegrityManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            IntegrityManager.enabled = true;
            IntegrityManager.isSampleEnabled = FetchedAppGateKeepersManager.getGateKeeperForKey("FBSDKFeatureIntegritySample", FacebookSdk.getApplicationId(), false);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    private final String getIntegrityPredictionResult(String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            float[] arr_f = new float[30];
            for(int v = 0; v < 30; ++v) {
                arr_f[v] = 0.0f;
            }
            String[] arr_s = ModelManager.predict(Task.MTML_INTEGRITY_DETECT, new float[][]{arr_f}, new String[]{s});
            if(arr_s != null) {
                String s1 = arr_s[0];
                return s1 == null ? "none" : s1;
            }
            return "none";
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return null;
    }

    public static final void processParameters(@NotNull Map map0) {
        Class class0 = IntegrityManager.class;
        if(!CrashShieldHandler.isObjectCrashing(class0)) {
            try {
                q.g(map0, "parameters");
                if(IntegrityManager.enabled && !map0.isEmpty()) {
                    try {
                        List list0 = p.P0(map0.keySet());
                        JSONObject jSONObject0 = new JSONObject();
                        Iterator iterator0 = list0.iterator();
                        while(true) {
                            if(!iterator0.hasNext()) {
                                if(jSONObject0.length() == 0) {
                                    break;
                                }
                                String s2 = jSONObject0.toString();
                                q.f(s2, "restrictiveParamJson.toString()");
                                map0.put("_onDeviceParams", s2);
                                break;
                            }
                            Object object0 = iterator0.next();
                            String s = (String)object0;
                            Object object1 = map0.get(s);
                            if(object1 == null) {
                                break;
                            }
                            String s1 = (String)object1;
                            if(IntegrityManager.INSTANCE.shouldFilter(s) || IntegrityManager.INSTANCE.shouldFilter(s1)) {
                                map0.remove(s);
                                if(!IntegrityManager.isSampleEnabled) {
                                    s1 = "";
                                }
                                jSONObject0.put(s, s1);
                            }
                        }
                    }
                    catch(Exception unused_ex) {
                    }
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, class0);
            }
        }
    }

    private final boolean shouldFilter(String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return !"none".equals(this.getIntegrityPredictionResult(s));
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return false;
        }
    }
}

