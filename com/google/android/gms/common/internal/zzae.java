package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

public final class zzae {
    private static final Object zza;
    private static boolean zzb;
    private static String zzc;
    private static int zzd;

    static {
        zzae.zza = new Object();
    }

    public static String zza(Context context0) {
        zzae.zzc(context0);
        return zzae.zzc;
    }

    public static int zzb(Context context0) {
        zzae.zzc(context0);
        return zzae.zzd;
    }

    private static void zzc(Context context0) {
        synchronized(zzae.zza) {
            if(zzae.zzb) {
                return;
            }
            zzae.zzb = true;
            PackageManagerWrapper packageManagerWrapper0 = Wrappers.packageManager(context0);
            try {
                Bundle bundle0 = packageManagerWrapper0.getApplicationInfo("com.iloen.melon", 0x80).metaData;
                if(bundle0 == null) {
                    return;
                }
                zzae.zzc = bundle0.getString("com.google.app.id");
                zzae.zzd = bundle0.getInt("com.google.android.gms.version");
            }
            catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                Log.wtf("MetadataValueReader", "This should never happen.", packageManager$NameNotFoundException0);
            }
        }
    }
}

