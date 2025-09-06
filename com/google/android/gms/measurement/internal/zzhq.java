package com.google.android.gms.measurement.internal;

import java.util.HashMap;
import java.util.concurrent.Callable;

final class zzhq implements Callable {
    private final zzhs zza;
    private final String zzb;

    public zzhq(zzhs zzhs0, String s) {
        this.zza = zzhs0;
        this.zzb = s;
    }

    @Override
    public final Object call() {
        zzh zzh0 = this.zza.zzg.zzj().zzu(this.zzb);
        HashMap hashMap0 = new HashMap();
        hashMap0.put("platform", "android");
        hashMap0.put("package_name", this.zzb);
        this.zza.zzu.zzc().zzi();
        hashMap0.put("gmp_version", 130000L);
        if(zzh0 != null) {
            String s = zzh0.zzr();
            if(s != null) {
                hashMap0.put("app_version", s);
            }
            hashMap0.put("app_version_int", zzh0.zzt());
            hashMap0.put("dynamite_version", zzh0.zzB());
        }
        return hashMap0;
    }
}

