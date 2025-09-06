package com.google.android.gms.internal.cast;

import k8.Y;

class zzwl extends zzwk {
    protected final byte[] zza;

    public zzwl(byte[] arr_b) {
        super(null);
        arr_b.getClass();
        this.zza = arr_b;
    }

    @Override  // com.google.android.gms.internal.cast.zzwn
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof zzwn)) {
            return false;
        }
        if(this.zzd() != ((zzwn)object0).zzd()) {
            return false;
        }
        if(this.zzd() == 0) {
            return true;
        }
        if(object0 instanceof zzwl) {
            int v = this.zzi();
            int v1 = ((zzwl)object0).zzi();
            if(v != 0 && v1 != 0 && v != v1) {
                return false;
            }
            int v2 = this.zzd();
            if(v2 > ((zzwl)object0).zzd()) {
                throw new IllegalArgumentException("Length too large: " + v2 + this.zzd());
            }
            if(v2 > ((zzwl)object0).zzd()) {
                throw new IllegalArgumentException(Y.h(v2, ((zzwl)object0).zzd(), "Ran off end of other: 0, ", ", "));
            }
            byte[] arr_b = this.zza;
            byte[] arr_b1 = ((zzwl)object0).zza;
            ((zzwl)object0).zzc();
            int v3 = 0;
            for(int v4 = 0; v3 < v2; ++v4) {
                if(arr_b[v3] != arr_b1[v4]) {
                    return false;
                }
                ++v3;
            }
            return true;
        }
        return object0.equals(this);
    }

    @Override  // com.google.android.gms.internal.cast.zzwn
    public byte zza(int v) {
        return this.zza[v];
    }

    @Override  // com.google.android.gms.internal.cast.zzwn
    public byte zzb(int v) {
        return this.zza[v];
    }

    public int zzc() {
        return 0;
    }

    @Override  // com.google.android.gms.internal.cast.zzwn
    public int zzd() {
        return this.zza.length;
    }

    @Override  // com.google.android.gms.internal.cast.zzwn
    public final int zze(int v, int v1, int v2) {
        return zzxo.zzb(v, this.zza, 0, v2);
    }

    @Override  // com.google.android.gms.internal.cast.zzwn
    public final zzwn zzf(int v, int v1) {
        zzwn.zzh(0, v1, this.zzd());
        return v1 == 0 ? zzwn.zzb : new zzwi(this.zza, 0, v1);
    }

    @Override  // com.google.android.gms.internal.cast.zzwn
    public final void zzg(zzwf zzwf0) {
        int v = this.zzd();
        ((zzwr)zzwf0).zzc(this.zza, 0, v);
    }
}

