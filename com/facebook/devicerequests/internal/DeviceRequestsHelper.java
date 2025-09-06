package com.facebook.devicerequests.internal;

import R6.d;
import X7.a;
import X7.e;
import a8.b;
import android.annotation.TargetApi;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.net.nsd.NsdManager.RegistrationListener;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00C7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0007\u001A\u00020\u00052\u0014\u0010\u0006\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\u0007\u001A\u00020\u0005H\u0007\u00A2\u0006\u0004\b\u0007\u0010\tJ\u0019\u0010\f\u001A\u00020\u000B2\b\u0010\n\u001A\u0004\u0018\u00010\u0005H\u0007\u00A2\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u000BH\u0007\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u001B\u0010\u0012\u001A\u0004\u0018\u00010\u00112\b\u0010\u0010\u001A\u0004\u0018\u00010\u0005H\u0007\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001A\u00020\u00142\b\u0010\n\u001A\u0004\u0018\u00010\u0005H\u0007\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001A\u00020\u000B2\b\u0010\n\u001A\u0004\u0018\u00010\u0005H\u0003\u00A2\u0006\u0004\b\u0017\u0010\rJ\u0019\u0010\u0018\u001A\u00020\u00142\b\u0010\n\u001A\u0004\u0018\u00010\u0005H\u0003\u00A2\u0006\u0004\b\u0018\u0010\u0016R\u001C\u0010\u001A\u001A\n \u0019*\u0004\u0018\u00010\u00050\u00058\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u001A\u0010\u001BR\u0014\u0010\u001C\u001A\u00020\u00058\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u001C\u0010\u001BR\u0014\u0010\u001D\u001A\u00020\u00058\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u001D\u0010\u001BR\u0014\u0010\u001E\u001A\u00020\u00058\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u001E\u0010\u001BR\u0014\u0010\u001F\u001A\u00020\u00058\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u001F\u0010\u001BR\u0014\u0010 \u001A\u00020\u00058\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b \u0010\u001BR\u0014\u0010!\u001A\u00020\u00058\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b!\u0010\u001BR\u0014\u0010\"\u001A\u00020\u00058\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\"\u0010\u001BR4\u0010&\u001A\"\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020$0#j\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020$`%8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b&\u0010\'\u00A8\u0006("}, d2 = {"Lcom/facebook/devicerequests/internal/DeviceRequestsHelper;", "", "<init>", "()V", "", "", "deviceInfo", "getDeviceInfo", "(Ljava/util/Map;)Ljava/lang/String;", "()Ljava/lang/String;", "userCode", "", "startAdvertisementService", "(Ljava/lang/String;)Z", "isAvailable", "()Z", "url", "Landroid/graphics/Bitmap;", "generateQRCode", "(Ljava/lang/String;)Landroid/graphics/Bitmap;", "Lie/H;", "cleanUpAdvertisementService", "(Ljava/lang/String;)V", "startAdvertisementServiceImpl", "cleanUpAdvertisementServiceImpl", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "DEVICE_INFO_PARAM", "DEVICE_TARGET_USER_ID", "DEVICE_INFO_DEVICE", "DEVICE_INFO_MODEL", "SDK_HEADER", "SDK_FLAVOR", "SERVICE_TYPE", "Ljava/util/HashMap;", "Landroid/net/nsd/NsdManager$RegistrationListener;", "Lkotlin/collections/HashMap;", "deviceRequestsListeners", "Ljava/util/HashMap;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class DeviceRequestsHelper {
    @NotNull
    public static final String DEVICE_INFO_DEVICE = "device";
    @NotNull
    public static final String DEVICE_INFO_MODEL = "model";
    @NotNull
    public static final String DEVICE_INFO_PARAM = "device_info";
    @NotNull
    public static final String DEVICE_TARGET_USER_ID = "target_user_id";
    @NotNull
    public static final DeviceRequestsHelper INSTANCE = null;
    @NotNull
    public static final String SDK_FLAVOR = "android";
    @NotNull
    public static final String SDK_HEADER = "fbsdk";
    @NotNull
    public static final String SERVICE_TYPE = "_fb._tcp.";
    private static final String TAG;
    @NotNull
    private static final HashMap deviceRequestsListeners;

    static {
        DeviceRequestsHelper.INSTANCE = new DeviceRequestsHelper();
        DeviceRequestsHelper.TAG = DeviceRequestsHelper.class.getCanonicalName();
        DeviceRequestsHelper.deviceRequestsListeners = new HashMap();
    }

    public static final void cleanUpAdvertisementService(@Nullable String s) {
        Class class0 = DeviceRequestsHelper.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            DeviceRequestsHelper.INSTANCE.cleanUpAdvertisementServiceImpl(s);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    @TargetApi(16)
    private final void cleanUpAdvertisementServiceImpl(String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                NsdManager.RegistrationListener nsdManager$RegistrationListener0 = (NsdManager.RegistrationListener)DeviceRequestsHelper.deviceRequestsListeners.get(s);
                if(nsdManager$RegistrationListener0 != null) {
                    Object object0 = FacebookSdk.getApplicationContext().getSystemService("servicediscovery");
                    q.e(object0, "null cannot be cast to non-null type android.net.nsd.NsdManager");
                    NsdManager nsdManager0 = (NsdManager)object0;
                    try {
                        nsdManager0.unregisterService(nsdManager$RegistrationListener0);
                    }
                    catch(IllegalArgumentException illegalArgumentException0) {
                        Utility.logd(DeviceRequestsHelper.TAG, illegalArgumentException0);
                    }
                    DeviceRequestsHelper.deviceRequestsListeners.remove(s);
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    @Nullable
    public static final Bitmap generateQRCode(@Nullable String s) {
        Throwable throwable1;
        Bitmap bitmap0;
        int[] arr_v;
        int v1;
        int v;
        Class class0 = DeviceRequestsHelper.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            EnumMap enumMap0 = new EnumMap(a.class);
            enumMap0.put(a.f, 2);
            try {
                b b0 = new d(7).p(s, 12, enumMap0);
                v = b0.b;
                v1 = b0.a;
                arr_v = new int[v * v1];
                for(int v2 = 0; v2 < v; ++v2) {
                    int v3 = v2 * v1;
                    for(int v4 = 0; v4 < v1; ++v4) {
                        arr_v[v3 + v4] = b0.a(v4, v2) ? 0xFF000000 : -1;
                    }
                }
                bitmap0 = Bitmap.createBitmap(v1, v, Bitmap.Config.ARGB_8888);
            }
            catch(e unused_ex) {
                return null;
            }
            try {
                bitmap0.setPixels(arr_v, 0, v1, 0, 0, v1, v);
            }
            catch(e unused_ex) {
            }
            return bitmap0;
        }
        catch(Throwable throwable0) {
            try {
                throwable1 = throwable0;
                goto label_27;
            }
            catch(e unused_ex) {
            }
            catch(Throwable throwable0) {
                throwable1 = throwable0;
                goto label_27;
            }
        }
        return null;
    label_27:
        CrashShieldHandler.handleThrowable(throwable1, class0);
        return null;
    }

    @NotNull
    public static final String getDeviceInfo() {
        Class class0 = DeviceRequestsHelper.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            return DeviceRequestsHelper.getDeviceInfo(null);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    @NotNull
    public static final String getDeviceInfo(@Nullable Map map0) {
        Class class0 = DeviceRequestsHelper.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            if(map0 == null) {
                map0 = new HashMap();
            }
            String s = Build.DEVICE;
            q.f(s, "DEVICE");
            map0.put("device", s);
            String s1 = Build.MODEL;
            q.f(s1, "MODEL");
            map0.put("model", s1);
            String s2 = new JSONObject(map0).toString();
            q.f(s2, "JSONObject(deviceInfo as Map<*, *>).toString()");
            return s2;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    public static final boolean isAvailable() {
        Class class0 = DeviceRequestsHelper.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return false;
        }
        try {
            FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if(fetchedAppSettings0 != null && fetchedAppSettings0.getSmartLoginOptions().contains(SmartLoginOption.Enabled)) {
                return true;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
        return false;
    }

    public static final boolean startAdvertisementService(@Nullable String s) {
        Class class0 = DeviceRequestsHelper.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return false;
        }
        try {
            return DeviceRequestsHelper.isAvailable() ? DeviceRequestsHelper.INSTANCE.startAdvertisementServiceImpl(s) : false;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return false;
        }
    }

    @TargetApi(16)
    private final boolean startAdvertisementServiceImpl(String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            HashMap hashMap0 = DeviceRequestsHelper.deviceRequestsListeners;
            if(hashMap0.containsKey(s)) {
                return true;
            }
            String s1 = "fbsdk_android-18|1|3" + '_' + s;
            NsdServiceInfo nsdServiceInfo0 = new NsdServiceInfo();
            nsdServiceInfo0.setServiceType("_fb._tcp.");
            nsdServiceInfo0.setServiceName(s1);
            nsdServiceInfo0.setPort(80);
            Object object0 = FacebookSdk.getApplicationContext().getSystemService("servicediscovery");
            q.e(object0, "null cannot be cast to non-null type android.net.nsd.NsdManager");
            com.facebook.devicerequests.internal.DeviceRequestsHelper.startAdvertisementServiceImpl.nsdRegistrationListener.1 deviceRequestsHelper$startAdvertisementServiceImpl$nsdRegistrationListener$10 = new NsdManager.RegistrationListener() {
                @Override  // android.net.nsd.NsdManager$RegistrationListener
                public void onRegistrationFailed(@NotNull NsdServiceInfo nsdServiceInfo0, int v) {
                    q.g(nsdServiceInfo0, "serviceInfo");
                    DeviceRequestsHelper.cleanUpAdvertisementService(this.$userCode);
                }

                @Override  // android.net.nsd.NsdManager$RegistrationListener
                public void onServiceRegistered(@NotNull NsdServiceInfo nsdServiceInfo0) {
                    q.g(nsdServiceInfo0, "NsdServiceInfo");
                    String s = nsdServiceInfo0.getServiceName();
                    if(!q.b(s, s)) {
                        DeviceRequestsHelper.cleanUpAdvertisementService(this.$userCode);
                    }
                }

                @Override  // android.net.nsd.NsdManager$RegistrationListener
                public void onServiceUnregistered(@NotNull NsdServiceInfo nsdServiceInfo0) {
                    q.g(nsdServiceInfo0, "serviceInfo");
                }

                @Override  // android.net.nsd.NsdManager$RegistrationListener
                public void onUnregistrationFailed(@NotNull NsdServiceInfo nsdServiceInfo0, int v) {
                    q.g(nsdServiceInfo0, "serviceInfo");
                }
            };
            hashMap0.put(s, deviceRequestsHelper$startAdvertisementServiceImpl$nsdRegistrationListener$10);
            ((NsdManager)object0).registerService(nsdServiceInfo0, 1, deviceRequestsHelper$startAdvertisementServiceImpl$nsdRegistrationListener$10);
            return true;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return false;
        }
    }
}

