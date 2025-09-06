package com.google.android.gms.internal.measurement;

public final class zzpd implements zzpc {
    public static final zzkl zza;

    static {
        zzkf zzkf0 = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zzkf0.zzd("measurement.client.3p_consent_state_v1", true);
        zzpd.zza = zzkf0.zzc("measurement.service.storage_consent_support_version", 203600L);
    }

    @Override  // com.google.android.gms.internal.measurement.zzpc
    public final long zza() {
        return (long)(((Long)zzpd.zza.zzd()));
    }
}

