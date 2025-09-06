package com.google.android.gms.internal.measurement;

public final class zzpg implements zzpf {
    public static final zzkl zza;
    public static final zzkl zzb;

    static {
        zzkf zzkf0 = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zzkf0.zzd("measurement.set_default_event_parameters_with_backfill.client.dev", false);
        zzkf0.zzd("measurement.set_default_event_parameters_with_backfill.service", true);
        zzkf0.zzc("measurement.id.set_default_event_parameters.fix_service_request_ordering", 0L);
        zzpg.zza = zzkf0.zzd("measurement.set_default_event_parameters.fix_app_update_logging", true);
        zzpg.zzb = zzkf0.zzd("measurement.set_default_event_parameters.fix_service_request_ordering", false);
        zzkf0.zzd("measurement.set_default_event_parameters.fix_subsequent_launches", true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzpf
    public final boolean zza() {
        return ((Boolean)zzpg.zza.zzd()).booleanValue();
    }

    @Override  // com.google.android.gms.internal.measurement.zzpf
    public final boolean zzb() {
        return ((Boolean)zzpg.zzb.zzd()).booleanValue();
    }
}

