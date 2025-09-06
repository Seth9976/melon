package com.google.android.gms.internal.measurement;

final class zzbc implements zzbe {
    private final zzg zza;
    private final String zzb;

    public zzbc(zzg zzg0, String s) {
        this.zza = zzg0;
        this.zzb = s;
    }

    @Override  // com.google.android.gms.internal.measurement.zzbe
    public final zzg zza(zzao zzao0) {
        zzg zzg0 = this.zza.zzc();
        zzg0.zzg(this.zzb, zzao0);
        return zzg0;
    }
}

