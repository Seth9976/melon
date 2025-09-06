package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.Wrappers;

@KeepForSdk
public class ClientLibraryUtils {
    @KeepForSdk
    public static int getClientVersion(Context context0, String s) {
        PackageInfo packageInfo0 = ClientLibraryUtils.getPackageInfo(context0, s);
        if(packageInfo0 != null) {
            ApplicationInfo applicationInfo0 = packageInfo0.applicationInfo;
            if(applicationInfo0 != null) {
                return applicationInfo0.metaData == null ? -1 : applicationInfo0.metaData.getInt("com.google.android.gms.version", -1);
            }
        }
        return -1;
    }

    @KeepForSdk
    public static PackageInfo getPackageInfo(Context context0, String s) {
        try {
            return Wrappers.packageManager(context0).getPackageInfo(s, 0x80);
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            return null;
        }
    }

    @KeepForSdk
    public static boolean isPackageSide() [...] // Inlined contents
}

