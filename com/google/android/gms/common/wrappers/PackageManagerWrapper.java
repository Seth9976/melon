package com.google.android.gms.common.wrappers;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.Process;
import b2.b;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class PackageManagerWrapper {
    protected final Context zza;

    public PackageManagerWrapper(Context context0) {
        this.zza = context0;
    }

    @KeepForSdk
    public int checkCallingOrSelfPermission(String s) {
        return this.zza.checkCallingOrSelfPermission(s);
    }

    @KeepForSdk
    public int checkPermission(String s, String s1) {
        return this.zza.getPackageManager().checkPermission(s, s1);
    }

    @KeepForSdk
    public ApplicationInfo getApplicationInfo(String s, int v) {
        return this.zza.getPackageManager().getApplicationInfo(s, v);
    }

    @KeepForSdk
    public CharSequence getApplicationLabel(String s) {
        return this.zza.getPackageManager().getApplicationLabel(this.zza.getPackageManager().getApplicationInfo(s, 0));
    }

    @KeepForSdk
    public b getApplicationLabelAndIcon(String s) {
        ApplicationInfo applicationInfo0 = this.zza.getPackageManager().getApplicationInfo(s, 0);
        return new b(this.zza.getPackageManager().getApplicationLabel(applicationInfo0), this.zza.getPackageManager().getApplicationIcon(applicationInfo0));
    }

    @KeepForSdk
    public PackageInfo getPackageInfo(String s, int v) {
        return this.zza.getPackageManager().getPackageInfo(s, v);
    }

    @KeepForSdk
    public String[] getPackagesForUid(int v) {
        return this.zza.getPackageManager().getPackagesForUid(v);
    }

    @KeepForSdk
    public boolean isCallerInstantApp() {
        if(Binder.getCallingUid() == Process.myUid()) {
            return InstantApps.isInstantApp(this.zza);
        }
        String s = this.zza.getPackageManager().getNameForUid(Binder.getCallingUid());
        return s == null ? false : this.zza.getPackageManager().isInstantApp(s);
    }

    @TargetApi(19)
    public final boolean zza(int v, String s) {
        try {
            AppOpsManager appOpsManager0 = (AppOpsManager)this.zza.getSystemService("appops");
            if(appOpsManager0 == null) {
                throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
            }
            appOpsManager0.checkPackage(v, s);
            return true;
        }
        catch(SecurityException unused_ex) {
            return false;
        }
    }
}

