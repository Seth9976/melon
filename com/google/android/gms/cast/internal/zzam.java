package com.google.android.gms.cast.internal;

final class zzam implements zzat {
    final zzat zza;
    final zzar zzb;

    public zzam(zzar zzar0, zzat zzat0) {
        this.zza = zzat0;
        this.zzb = zzar0;
        super();
    }

    @Override  // com.google.android.gms.cast.internal.zzat
    public final void zza(String s, long v, int v1, Object object0, long v2, long v3) {
        zzar.zzN(this.zzb, null);
        zzat zzat0 = this.zza;
        if(zzat0 != null) {
            zzat0.zza(s, v, v1, object0, v2, v3);
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

