package com.google.android.gms.internal.measurement;

final class zzlh extends zzli {
    private int zzb;
    private int zzc;
    private int zzd;

    public zzlh(byte[] arr_b, int v, int v1, boolean z, byte[] arr_b1) {
        super(null);
        this.zzd = 0x7FFFFFFF;
        this.zzb = 0;
    }

    public final int zza(int v) {
        int v1 = this.zzd;
        this.zzd = 0;
        int v2 = this.zzb + this.zzc;
        this.zzb = v2;
        if(v2 > 0) {
            this.zzc = v2;
            this.zzb = 0;
            return v1;
        }
        this.zzc = 0;
        return v1;
    }
}

