package com.google.android.gms.internal.cast;

import com.google.android.gms.common.util.DefaultClock;

public final class zzr {
    private final int zza;
    private final long zzb;
    private long zzc;

    public zzr(zzq zzq0) {
        this.zza = zzq0.zza;
        this.zzb = DefaultClock.getInstance().currentTimeMillis();
    }

    public final zzqi zza() {
        int v = this.zza;
        zzqh zzqh0 = zzqi.zza();
        int v1 = 2;
        if(v != 1) {
            switch(v) {
                case 2: {
                    v1 = 3;
                    break;
                }
                case 3: {
                    break;
                }
                case 4: {
                    v1 = 5;
                    break;
                }
                default: {
                    v1 = 1;
                }
            }
        }
        zzqh0.zzb(v1);
        zzqh0.zza(((int)(this.zzb - this.zzc)));
        return (zzqi)zzqh0.zzr();
    }

    public final void zzb(long v) {
        this.zzc = v;
    }

    public final boolean zzc() {
        return this.zza == 2;
    }
}

