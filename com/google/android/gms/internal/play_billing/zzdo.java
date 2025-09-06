package com.google.android.gms.internal.play_billing;

final class zzdo extends zzdq {
    private zzdo() {
        throw null;
    }

    public zzdo(zzdn zzdn0) {
        super(null);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzdq
    public final void zza(Object object0, long v) {
        ((zzcz)zzfp.zzf(object0, v)).zzb();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzdq
    public final void zzb(Object object0, Object object1, long v) {
        zzcz zzcz0 = (zzcz)zzfp.zzf(object0, v);
        zzcz zzcz1 = (zzcz)zzfp.zzf(object1, v);
        int v1 = zzcz0.size();
        int v2 = zzcz1.size();
        if(v1 > 0 && v2 > 0) {
            if(!zzcz0.zzc()) {
                zzcz0 = zzcz0.zzd(v2 + v1);
            }
            zzcz0.addAll(zzcz1);
        }
        if(v1 > 0) {
            zzcz1 = zzcz0;
        }
        zzfp.zzs(object0, v, zzcz1);
    }
}

