package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.HashSet;
import java.util.List;
import je.D;
import je.n;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0007\u001A\u0004\u0018\u00010\u0005H\u0007J\b\u0010\b\u001A\u00020\u0005H\u0007J\u0010\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u0005H\u0007R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u000B"}, d2 = {"Lcom/facebook/internal/CustomTabUtils;", "", "()V", "CHROME_PACKAGES", "", "", "[Ljava/lang/String;", "getChromePackage", "getDefaultRedirectURI", "getValidRedirectURI", "developerDefinedRedirectURI", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CustomTabUtils {
    @NotNull
    private static final String[] CHROME_PACKAGES;
    @NotNull
    public static final CustomTabUtils INSTANCE;

    static {
        CustomTabUtils.INSTANCE = new CustomTabUtils();
        CustomTabUtils.CHROME_PACKAGES = new String[]{"com.android.chrome", "com.chrome.beta", "com.chrome.dev"};
    }

    @Nullable
    public static final String getChromePackage() {
        Class class0 = CustomTabUtils.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        else {
            try {
                Context context0 = FacebookSdk.getApplicationContext();
                Intent intent0 = new Intent("android.support.customtabs.action.CustomTabsService");
                List list0 = context0.getPackageManager().queryIntentServices(intent0, 0);
                q.f(list0, "context.packageManager.q…ervices(serviceIntent, 0)");
                q.g(CustomTabUtils.CHROME_PACKAGES, "<this>");
                HashSet hashSet0 = new HashSet(D.N(CustomTabUtils.CHROME_PACKAGES.length));
                n.w0(CustomTabUtils.CHROME_PACKAGES, hashSet0);
                for(Object object0: list0) {
                    ServiceInfo serviceInfo0 = ((ResolveInfo)object0).serviceInfo;
                    if(serviceInfo0 != null && hashSet0.contains(serviceInfo0.packageName)) {
                        return serviceInfo0.packageName;
                    }
                    if(false) {
                        break;
                    }
                }
                return null;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    // 去混淆评级： 中等(60)
    @NotNull
    public static final String getDefaultRedirectURI() {
        return "fbconnect://cct.com.iloen.melon";
    }

    @NotNull
    public static final String getValidRedirectURI(@NotNull String s) {
        Class class0 = CustomTabUtils.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(s, "developerDefinedRedirectURI");
            if(Validate.hasCustomTabRedirectActivity(FacebookSdk.getApplicationContext(), s)) {
                return s;
            }
            return Validate.hasCustomTabRedirectActivity(FacebookSdk.getApplicationContext(), CustomTabUtils.getDefaultRedirectURI()) ? CustomTabUtils.getDefaultRedirectURI() : "";
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }
}

