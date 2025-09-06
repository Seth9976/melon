package com.google.android.gms.internal.cast;

import com.google.android.gms.common.util.DefaultClock;

public final class zzab {
    final int zza;
    final long zzb;
    private long zzc;

    public zzab(zzaa zzaa0) {
        this.zza = zzaa0.zza;
        this.zzb = DefaultClock.getInstance().currentTimeMillis();
    }

    public final zzqq zza() {
        zzqp zzqp0 = zzqq.zza();
        zzqp0.zza(((int)(this.zzb - this.zzc)));
        int v = this.zza;
        int v1 = 2;
        if(v != 1) {
            switch(v) {
                case 2: {
                    v1 = 3;
                    break;
                }
                case 3: {
                    v1 = 4;
                    break;
                }
                default: {
                    v1 = 1;
                }
            }
        }
        zzqp0.zzb(v1);
        return (zzqq)zzqp0.zzr();
    }

    public final void zzb(long v) {
        this.zzc = v;
    }
}

