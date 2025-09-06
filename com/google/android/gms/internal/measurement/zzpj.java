package com.google.android.gms.internal.measurement;

public final class zzpj implements zzpi {
    public static final zzkl zza;
    public static final zzkl zzb;

    static {
        zzkf zzkf0 = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zzpj.zza = zzkf0.zzd("measurement.set_default_event_parameters_propagate_clear.client.dev", true);
        zzpj.zzb = zzkf0.zzd("measurement.set_default_event_parameters_propagate_clear.service", true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzpi
    public final boolean zza() {
        return ((Boolean)zzpj.zza.zzd()).booleanValue();
    }

    @Override  // com.google.android.gms.internal.measurement.zzpi
    public final boolean zzb() {
        return ((Boolean)zzpj.zzb.zzd()).booleanValue();
    }
}

