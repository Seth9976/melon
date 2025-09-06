package com.google.android.gms.internal.measurement;

final class zzbd implements zzbe {
    private final zzg zza;
    private final String zzb;

    public zzbd(zzg zzg0, String s) {
        this.zza = zzg0;
        this.zzb = s;
    }

    @Override  // com.google.android.gms.internal.measurement.zzbe
    public final zzg zza(zzao zzao0) {
        zzg zzg0 = this.zza.zzc();
        zzg0.zzf(this.zzb, zzao0);
        return zzg0;
    }
}

