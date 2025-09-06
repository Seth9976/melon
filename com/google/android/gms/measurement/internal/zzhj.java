package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

public final class zzhj {
    final zzib zza;

    public zzhj(zzpf zzpf0) {
        this.zza = zzpf0.zzaf();
    }

    public final boolean zza() {
        try {
            zzib zzib0 = this.zza;
            PackageManagerWrapper packageManagerWrapper0 = Wrappers.packageManager(zzib0.zzaY());
            if(packageManagerWrapper0 == null) {
                zzib0.zzaV().zzk().zza("Failed to get PackageManager for Install Referrer Play Store compatibility check");
                return false;
            }
            return packageManagerWrapper0.getPackageInfo("com.android.vending", 0x80).versionCode >= 80837300;
        }
        catch(Exception exception0) {
        }
        this.zza.zzaV().zzk().zzb("Failed to retrieve Play Store version for Install Referrer", exception0);
        return false;
    }
}

