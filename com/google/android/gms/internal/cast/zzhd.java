package com.google.android.gms.internal.cast;

import java.util.Arrays;

public final class zzhd extends zzha {
    public zzhd() {
        super(4);
    }

    public final zzhd zzb(Object object0) {
        object0.getClass();
        int v = this.zza.length;
        int v1 = zzhb.zza(v, this.zzb + 1);
        if(v1 > v || this.zzc) {
            this.zza = Arrays.copyOf(this.zza, v1);
            this.zzc = false;
        }
        int v2 = this.zzb;
        this.zzb = v2 + 1;
        this.zza[v2] = object0;
        return this;
    }

    public final zzhg zzc() {
        this.zzc = true;
        return zzhg.zzi(this.zza, this.zzb);
    }
}

