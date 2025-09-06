package com.google.android.gms.cast.framework;

public final class zzo {
    private int zza;
    private int zzb;

    public zzo() {
        this.zza = 0;
        this.zzb = -1;
    }

    public final zzo zza(int v) {
        this.zza = v;
        return this;
    }

    public final zzo zzb(int v) {
        this.zzb = v;
        return this;
    }

    public final zzq zzc() {
        int v = this.zza;
        if(v == 0) {
            v = CastContext.zza(this.zzb);
            this.zza = v;
        }
        return new zzq(v, this.zzb, null);
    }
}

