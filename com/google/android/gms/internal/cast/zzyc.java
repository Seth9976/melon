package com.google.android.gms.internal.cast;

final class zzyc implements zzyj {
    private final zzyj[] zza;

    public zzyc(zzyj[] arr_zzyj) {
        this.zza = arr_zzyj;
    }

    @Override  // com.google.android.gms.internal.cast.zzyj
    public final zzyi zzb(Class class0) {
        for(int v = 0; v < 2; ++v) {
            zzyj zzyj0 = this.zza[v];
            if(zzyj0.zzc(class0)) {
                return zzyj0.zzb(class0);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: " + class0.getName());
    }

    @Override  // com.google.android.gms.internal.cast.zzyj
    public final boolean zzc(Class class0) {
        for(int v = 0; v < 2; ++v) {
            if(this.zza[v].zzc(class0)) {
                return true;
            }
        }
        return false;
    }
}

