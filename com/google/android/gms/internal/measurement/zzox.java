package com.google.android.gms.internal.measurement;

public final class zzox implements zzow {
    public static final zzkl zza;

    static {
        zzkf zzkf0 = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zzox.zza = zzkf0.zzd("measurement.service.ad_impression.convert_value_to_double", true);
        zzkf0.zzd("measurement.service.separate_public_internal_event_blacklisting", true);
        zzkf0.zzd("measurement.service.ad_impression", true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzow
    public final boolean zza() {
        return ((Boolean)zzox.zza.zzd()).booleanValue();
    }
}

