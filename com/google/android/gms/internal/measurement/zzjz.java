package com.google.android.gms.internal.measurement;

import H6.a;
import H6.f;
import H6.i;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Log;

public final class zzjz {
    static volatile f zza;
    private static final Object zzb;

    static {
        zzjz.zza = a.a;
        zzjz.zzb = new Object();
    }

    public static boolean zza(Context context0, Uri uri0) {
        String s = uri0.getAuthority();
        boolean z = false;
        if(!"com.google.android.gms.phenotype".equals(s)) {
            Log.e("PhenotypeClientHelper", s + " is an unsupported authority. Only com.google.android.gms.phenotype authority is supported.");
            return false;
        }
        if(zzjz.zza.b()) {
            return ((Boolean)zzjz.zza.a()).booleanValue();
        }
        synchronized(zzjz.zzb) {
            if(zzjz.zza.b()) {
                return ((Boolean)zzjz.zza.a()).booleanValue();
            }
            ProviderInfo providerInfo0 = context0.getPackageManager().resolveContentProvider("com.google.android.gms.phenotype", (Build.VERSION.SDK_INT >= 29 ? 0x10000000 : 0));
            if(providerInfo0 != null && "com.google.android.gms".equals(providerInfo0.packageName)) {
                PackageManager packageManager0 = context0.getPackageManager();
                try {
                    if((packageManager0.getApplicationInfo("com.google.android.gms", 0).flags & 0x81) != 0) {
                        z = true;
                    }
                }
                catch(PackageManager.NameNotFoundException unused_ex) {
                }
            }
            zzjz.zza = new i(Boolean.valueOf(z));
        }
        return ((Boolean)zzjz.zza.a()).booleanValue();
    }
}

