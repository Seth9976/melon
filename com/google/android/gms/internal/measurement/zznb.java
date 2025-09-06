package com.google.android.gms.internal.measurement;

final class zznb implements zznj {
    private final zznj[] zza;

    public zznb(zznj[] arr_zznj) {
        this.zza = arr_zznj;
    }

    @Override  // com.google.android.gms.internal.measurement.zznj
    public final boolean zzb(Class class0) {
        for(int v = 0; v < 2; ++v) {
            if(this.zza[v].zzb(class0)) {
                return true;
            }
        }
        return false;
    }

    @Override  // com.google.android.gms.internal.measurement.zznj
    public final zzni zzc(Class class0) {
        for(int v = 0; v < 2; ++v) {
            zznj zznj0 = this.zza[v];
            if(zznj0.zzb(class0)) {
                return zznj0.zzc(class0);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: " + class0.getName());
    }
}

