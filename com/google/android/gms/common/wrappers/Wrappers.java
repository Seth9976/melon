package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class Wrappers {
    private PackageManagerWrapper zza;
    private static final Wrappers zzb;

    static {
        Wrappers.zzb = new Wrappers();
    }

    public Wrappers() {
        this.zza = null;
    }

    @KeepForSdk
    public static PackageManagerWrapper packageManager(Context context0) {
        return Wrappers.zzb.zza(context0);
    }

    public final PackageManagerWrapper zza(Context context0) {
        synchronized(this) {
            if(this.zza == null) {
                if(context0.getApplicationContext() != null) {
                    context0 = context0.getApplicationContext();
                }
                this.zza = new PackageManagerWrapper(context0);
            }
            return this.zza;
        }
    }
}

