package com.google.android.gms.internal.common;

import java.util.Arrays;

class zzac extends zzad {
    Object[] zza;
    int zzb;
    boolean zzc;

    public zzac(int v) {
        this.zza = new Object[4];
        this.zzb = 0;
    }

    public final zzac zza(Object object0) {
        int v1;
        object0.getClass();
        int v = this.zzb;
        if(v + 1 < 0) {
            throw new IllegalArgumentException("cannot store more than Integer.MAX_VALUE elements");
        }
        if(v + 1 <= this.zza.length) {
            v1 = this.zza.length;
        }
        else {
            v1 = (this.zza.length >> 1) + this.zza.length + 1;
            if(v1 < v + 1) {
                int v2 = Integer.highestOneBit(v);
                v1 = v2 + v2;
            }
            if(v1 < 0) {
                v1 = 0x7FFFFFFF;
            }
        }
        if(v1 > this.zza.length || this.zzc) {
            this.zza = Arrays.copyOf(this.zza, v1);
            this.zzc = false;
        }
        int v3 = this.zzb;
        this.zzb = v3 + 1;
        this.zza[v3] = object0;
        return this;
    }
}

