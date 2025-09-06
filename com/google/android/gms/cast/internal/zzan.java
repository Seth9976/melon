package com.google.android.gms.cast.internal;

final class zzan implements zzat {
    final zzat zza;
    final zzar zzb;

    public zzan(zzar zzar0, zzat zzat0) {
        this.zza = zzat0;
        this.zzb = zzar0;
        super();
    }

    @Override  // com.google.android.gms.cast.internal.zzat
    public final void zza(String s, long v, int v1, Object object0, long v2, long v3) {
        int v4;
        zzat zzat0 = this.zza;
        if(zzat0 != null) {
            if(v1 == 2001) {
                this.zzb.zza.w("Possibility of local queue out of sync with receiver queue. Refetching sequence number. Current Local Sequence Number = %d", new Object[]{zzar.zzi(this.zzb)});
                zzar.zzM(this.zzb).zzl();
                v4 = 2001;
            }
            else {
                v4 = v1;
            }
            zzat0.zza(s, v, v4, object0, v2, v3);
        }
    }

    @Override  // com.google.android.gms.cast.internal.zzat
    public final void zzb(String s, long v, long v1, long v2) {
        zzat zzat0 = this.zza;
        if(zzat0 != null) {
            zzat0.zzb(s, v, v1, v2);
        }
    }
}

