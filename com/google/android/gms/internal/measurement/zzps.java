package com.google.android.gms.internal.measurement;

public final class zzps implements zzpr {
    public static final zzkl zza;
    public static final zzkl zzb;
    public static final zzkl zzc;

    static {
        zzkf zzkf0 = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zzkf0.zzd("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        zzps.zza = zzkf0.zzd("measurement.audience.refresh_event_count_filters_timestamp", false);
        zzps.zzb = zzkf0.zzd("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        zzps.zzc = zzkf0.zzd("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    @Override  // com.google.android.gms.internal.measurement.zzpr
    public final boolean zza() {
        return true;
    }

    @Override  // com.google.android.gms.internal.measurement.zzpr
    public final boolean zzb() {
        return ((Boolean)zzps.zza.zzd()).booleanValue();
    }

    @Override  // com.google.android.gms.internal.measurement.zzpr
    public final boolean zzc() {
        return ((Boolean)zzps.zzb.zzd()).booleanValue();
    }

    @Override  // com.google.android.gms.internal.measurement.zzpr
    public final boolean zzd() {
        return ((Boolean)zzps.zzc.zzd()).booleanValue();
    }
}

