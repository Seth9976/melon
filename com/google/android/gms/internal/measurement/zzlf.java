package com.google.android.gms.internal.measurement;

class zzlf extends zzle {
    protected final byte[] zza;

    public zzlf(byte[] arr_b) {
        super(null);
        arr_b.getClass();
        this.zza = arr_b;
    }

    @Override  // com.google.android.gms.internal.measurement.zzlg
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof zzlg)) {
            return false;
        }
        if(this.zzc() != ((zzlg)object0).zzc()) {
            return false;
        }
        if(this.zzc() == 0) {
            return true;
        }
        if(object0 instanceof zzlf) {
            int v = this.zzi();
            int v1 = ((zzlf)object0).zzi();
            if(v != 0 && v1 != 0 && v != v1) {
                return false;
            }
            int v2 = this.zzc();
            if(v2 > ((zzlf)object0).zzc()) {
                throw new IllegalArgumentException("Length too large: " + v2 + this.zzc());
            }
            if(v2 > ((zzlf)object0).zzc()) {
                throw new IllegalArgumentException("Ran off end of other: 0, " + v2 + ", " + ((zzlf)object0).zzc());
            }
            byte[] arr_b = this.zza;
            byte[] arr_b1 = ((zzlf)object0).zza;
            ((zzlf)object0).zzd();
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

    @Override  // com.google.android.gms.internal.measurement.zzlg
    public byte zza(int v) {
        return this.zza[v];
    }

    @Override  // com.google.android.gms.internal.measurement.zzlg
    public byte zzb(int v) {
        return this.zza[v];
    }

    @Override  // com.google.android.gms.internal.measurement.zzlg
    public int zzc() {
        return this.zza.length;
    }

    public int zzd() {
        return 0;
    }

    @Override  // com.google.android.gms.internal.measurement.zzlg
    public final zzlg zze(int v, int v1) {
        int v2 = zzlg.zzj(0, v1, this.zzc());
        return v2 == 0 ? zzlg.zzb : new zzlb(this.zza, 0, v2);
    }

    @Override  // com.google.android.gms.internal.measurement.zzlg
    public final void zzf(zzky zzky0) {
        int v = this.zzc();
        ((zzlj)zzky0).zzv(this.zza, 0, v);
    }

    @Override  // com.google.android.gms.internal.measurement.zzlg
    public final int zzg(int v, int v1, int v2) {
        return zzmo.zzc(v, this.zza, 0, v2);
    }
}

