package com.google.android.gms.internal.cast;

import java.util.HashMap;
import java.util.Map;

public final class zzin {
    private static final zziq zza;
    private static final zzip zzb;
    private final Map zzc;
    private final Map zzd;

    static {
        zzin.zza = new zzil();
        zzin.zzb = new zzim();
    }

    public zzin(zziq zziq0, zzir zzir0) {
        this.zzc = new HashMap();
        this.zzd = new HashMap();
    }

    public final zzis zza() {
        return new zzio(this, null);
    }

    public final void zzd(zzie zzie0) {
        zzka.zza(zzie0, "key");
        if(zzie0.zzb()) {
            zzip zzip0 = zzin.zzb;
            zzka.zza(zzie0, "key");
            if(!zzie0.zzb()) {
                throw new IllegalArgumentException("key must be repeating");
            }
            this.zzc.remove(zzie0);
            this.zzd.put(zzie0, zzip0);
            return;
        }
        zzka.zza(zzie0, "key");
        this.zzd.remove(zzie0);
        this.zzc.put(zzie0, zzin.zza);
    }
}

