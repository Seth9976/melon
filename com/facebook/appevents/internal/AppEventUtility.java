package com.facebook.appevents.internal;

import Tf.o;
import Tf.v;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0003J\u0019\u0010\n\u001A\u00020\t2\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u000E\u001A\u00020\u00072\u0006\u0010\r\u001A\u00020\fH\u0007¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0011\u001A\u00020\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001B\u0010\u0018\u001A\u0004\u0018\u00010\u00172\b\u0010\u0016\u001A\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001A\u001A\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001A\u0010\u001BR\u0014\u0010\u001C\u001A\u00020\u00108CX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u0012¨\u0006\u001D"}, d2 = {"Lcom/facebook/appevents/internal/AppEventUtility;", "", "<init>", "()V", "Lie/H;", "assertIsNotMainThread", "assertIsMainThread", "", "value", "", "normalizePrice", "(Ljava/lang/String;)D", "", "bytes", "bytesToHex", "([B)Ljava/lang/String;", "", "isEmulator", "()Z", "getAppVersion", "()Ljava/lang/String;", "Landroid/app/Activity;", "activity", "Landroid/view/View;", "getRootView", "(Landroid/app/Activity;)Landroid/view/View;", "PRICE_REGEX", "Ljava/lang/String;", "isMainThread", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AppEventUtility {
    @NotNull
    public static final AppEventUtility INSTANCE = null;
    @NotNull
    private static final String PRICE_REGEX = "[-+]*\\d+([.,]\\d+)*([.,]\\d+)?";

    static {
        AppEventUtility.INSTANCE = new AppEventUtility();
    }

    public static final void assertIsMainThread() {
    }

    public static final void assertIsNotMainThread() {
    }

    @NotNull
    public static final String bytesToHex(@NotNull byte[] arr_b) {
        q.g(arr_b, "bytes");
        StringBuffer stringBuffer0 = new StringBuffer();
        for(int v = 0; v < arr_b.length; ++v) {
            stringBuffer0.append(String.format("%02x", Arrays.copyOf(new Object[]{((byte)arr_b[v])}, 1)));
        }
        String s = stringBuffer0.toString();
        q.f(s, "sb.toString()");
        return s;
    }

    @NotNull
    public static final String getAppVersion() {
        Context context0 = FacebookSdk.getApplicationContext();
        try {
            String s = context0.getPackageManager().getPackageInfo("com.iloen.melon", 0).versionName;
            q.f(s, "{\n      val packageInfo …ageInfo.versionName\n    }");
            return s;
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            return "";
        }
    }

    @Nullable
    public static final View getRootView(@Nullable Activity activity0) {
        Class class0 = AppEventUtility.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        if(activity0 == null) {
            return null;
        }
        try {
            Window window0 = activity0.getWindow();
            return window0 == null ? null : window0.getDecorView().getRootView();
        }
        catch(Exception throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
        catch(Throwable unused_ex) {
        }
        return null;
    }

    public static final boolean isEmulator() {
        String s = Build.FINGERPRINT;
        q.f(s, "FINGERPRINT");
        if(!v.r0(s, "generic", false) && !v.r0(s, "unknown", false)) {
            String s1 = Build.MODEL;
            q.f(s1, "MODEL");
            if(!o.v0(s1, "google_sdk", false) && !o.v0(s1, "Emulator", false) && !o.v0(s1, "Android SDK built for x86", false)) {
                String s2 = Build.MANUFACTURER;
                q.f(s2, "MANUFACTURER");
                if(!o.v0(s2, "Genymotion", false)) {
                    String s3 = Build.BRAND;
                    q.f(s3, "BRAND");
                    if(v.r0(s3, "generic", false)) {
                        String s4 = Build.DEVICE;
                        q.f(s4, "DEVICE");
                        return v.r0(s4, "generic", false) ? true : "google_sdk".equals(Build.PRODUCT);
                    }
                    return "google_sdk".equals(Build.PRODUCT);
                }
            }
        }
        return true;
    }

    private static final boolean isMainThread() {
        return q.b(Looper.myLooper(), Looper.getMainLooper());
    }

    public static final double normalizePrice(@Nullable String s) {
        try {
            Matcher matcher0 = Pattern.compile("[-+]*\\d+([.,]\\d+)*([.,]\\d+)?", 8).matcher(s);
            if(matcher0.find()) {
                String s1 = matcher0.group(0);
                return NumberFormat.getNumberInstance(Utility.getCurrentLocale()).parse(s1).doubleValue();
            }
        }
        catch(ParseException unused_ex) {
        }
        return 0.0;
    }
}

