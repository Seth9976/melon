package com.google.android.gms.internal.play_billing;

final class zzdt implements zzea {
    private final zzea[] zza;

    public zzdt(zzea[] arr_zzea) {
        this.zza = arr_zzea;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzea
    public final zzdz zzb(Class class0) {
        for(int v = 0; v < 2; ++v) {
            zzea zzea0 = this.zza[v];
            if(zzea0.zzc(class0)) {
                return zzea0.zzb(class0);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: " + class0.getName());
    }

    @Override  // com.google.android.gms.internal.play_billing.zzea
    public final boolean zzc(Class class0) {
        for(int v = 0; v < 2; ++v) {
            if(this.zza[v].zzc(class0)) {
                return true;
            }
        }
        return false;
    }
}

