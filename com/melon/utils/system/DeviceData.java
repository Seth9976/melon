package com.melon.utils.system;

import A8.K;
import A8.e;
import A8.g;
import Tf.o;
import Tf.v;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import b3.Z;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.DeviceIdentifier;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/melon/utils/system/DeviceData;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DeviceData {
    public final Context a;
    public final LogU b;
    public final e c;
    public final float d;

    @Inject
    public DeviceData(@NotNull Context context0) {
        q.g(context0, "context");
        super();
        this.a = context0;
        LogU logU0 = Z.g("DeviceData", true);
        this.b = logU0;
        Object object0 = context0.getSystemService("phone");
        q.e(object0, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        this.c = ((TelephonyManager)object0).getPhoneType() == 0 ? e.b : e.c;
        LogU.info$default(logU0, "getDeviceType() deviceType: " + this.c(), null, false, 6, null);
        Object object1 = context0.getSystemService("window");
        q.e(object1, "null cannot be cast to non-null type android.view.WindowManager");
        Display display0 = ((WindowManager)object1).getDefaultDisplay();
        if(display0 != null) {
            display0.getWidth();
            display0.getHeight();
            switch(display0.getRotation()) {
                case 1: 
                case 3: {
                    display0.getHeight();
                    display0.getWidth();
                }
            }
            Resources resources0 = context0.getResources();
            if(resources0 != null) {
                DisplayMetrics displayMetrics0 = resources0.getDisplayMetrics();
                q.f(displayMetrics0, "getDisplayMetrics(...)");
                this.d = displayMetrics0.density;
            }
        }
    }

    public static String a(String s) {
        if(s != null && s.length() != 0) {
            if(!v.r0(s, "0", false)) {
                if(v.r0(s, "+82", false)) {
                    String s1 = s.substring(3);
                    q.f(s1, "substring(...)");
                    return "0" + s1;
                }
                if(v.r0(s, "82", false)) {
                    String s2 = s.substring(2);
                    q.f(s2, "substring(...)");
                    return "0" + s2;
                }
            }
            return s;
        }
        return "88888888888";
    }

    public final String b() {
        try {
            q.d("");
        }
        catch(Exception exception0) {
            LogU.info$default(this.b, "getDeviceSerialNumber() exception: " + exception0, null, false, 6, null);
        }
        LogU.info$default(this.b, "getDeviceSerialNumber() serial: ", null, false, 6, null);
        return "";
    }

    public final e c() {
        e e0 = this.c;
        if(e0 != null) {
            return e0;
        }
        q.m("deviceType");
        throw null;
    }

    // 去混淆评级： 低(20)
    public static g d() {
        return R8.q.a.c() ? g.c : g.b;
    }

    public final String e() {
        String s2;
        String s = MelonSettingInfo.getLine1Number();
        String s1 = "88888888888";
        if(!TextUtils.isEmpty(s) && !TextUtils.equals(s, "88888888888")) {
            LogU.debug$default(this.b, "getRealMin() fromFile: " + s, null, false, 6, null);
            q.d(s);
            return s;
        }
        try {
            Object object0 = this.a.getSystemService("phone");
            TelephonyManager telephonyManager0 = object0 instanceof TelephonyManager ? ((TelephonyManager)object0) : null;
            if(telephonyManager0 == null) {
                s2 = "88888888888";
            }
            else if(telephonyManager0.getPhoneType() != 0) {
                s2 = DeviceData.a(telephonyManager0.getLine1Number());
            }
            else {
                s2 = "88888888888";
            }
            if(!"88888888888".equals(s2)) {
                MelonSettingInfo.setLine1Number(s2);
            }
            s1 = s2;
        }
        catch(Exception exception0) {
            LogU.error$default(this.b, "getRealMin() error: " + exception0, null, false, 6, null);
        }
        LogU.debug$default(this.b, "getRealMin() fromSystem: " + s1, null, false, 6, null);
        return s1;
    }

    // 去混淆评级： 低(20)
    public final K f() {
        return this.j() ? K.b : K.c;
    }

    public final String g() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(this.e());
        stringBuilder0.append("|");
        stringBuilder0.append(DeviceIdentifier.id(this.a));
        stringBuilder0.append("|");
        String s = Build.MODEL;
        stringBuilder0.append((TextUtils.isEmpty(s) ? "" : DeviceData.k(s)));
        stringBuilder0.append("||");
        stringBuilder0.append(this.b());
        LogU.debug$default(this.b, "getUniqueDeviceId() HWKEY: " + stringBuilder0, null, false, 6, null);
        String s1 = stringBuilder0.toString();
        q.f(s1, "toString(...)");
        return s1;
    }

    public final String h() {
        String s = MelonSettingInfo.getVirtualMin();
        if(!TextUtils.isEmpty(s)) {
            q.d(s);
        }
        else if(this.j()) {
            s = this.e();
        }
        else {
            s = "88888888888";
        }
        LogU.verbose$default(this.b, "getVirtualMin() mdn:" + s, null, false, 6, null);
        return s;
    }

    public final boolean i() {
        Object object0 = this.a.getSystemService("phone");
        q.e(object0, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        TelephonyManager telephonyManager0 = (TelephonyManager)object0;
        try {
            return TextUtils.isEmpty(telephonyManager0.getLine1Number());
        }
        catch(Exception unused_ex) {
            LogU.error$default(this.b, "isOnlyWifiDevice() CONTACTS PERMISSON Error!", null, false, 6, null);
            return true;
        }
    }

    public final boolean j() {
        Object object0 = this.a.getSystemService("phone");
        TelephonyManager telephonyManager0 = object0 instanceof TelephonyManager ? ((TelephonyManager)object0) : null;
        if(telephonyManager0 == null) {
            LogU.error$default(this.b, "isSKTDevice() invalid telephonyManager", null, false, 6, null);
            return false;
        }
        String s = telephonyManager0.getSimOperatorName();
        q.f(s, "getSimOperatorName(...)");
        Locale locale0 = Locale.getDefault();
        q.f(locale0, "getDefault(...)");
        String s1 = s.toLowerCase(locale0);
        q.f(s1, "toLowerCase(...)");
        String s2 = v.p0(s1, " ", "");
        String s3 = telephonyManager0.getNetworkOperatorName();
        q.f(s3, "getNetworkOperatorName(...)");
        Locale locale1 = Locale.getDefault();
        q.f(locale1, "getDefault(...)");
        String s4 = s3.toLowerCase(locale1);
        q.f(s4, "toLowerCase(...)");
        String s5 = v.p0(s4, " ", "");
        LogU.verbose$default(this.b, "isSKTDevice() simOperatorName: " + s2 + ", networkOperatorName: " + s5, null, false, 6, null);
        return o.v0(s2, "skt", false) || o.v0(s5, "skt", false) && telephonyManager0.getPhoneType() != 0;
    }

    public static String k(String s) [...] // 潜在的解密器
}

