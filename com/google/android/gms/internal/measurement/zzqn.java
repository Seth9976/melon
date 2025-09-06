package com.google.android.gms.internal.measurement;

public final class zzqn implements zzqm {
    public static final zzkl zza;
    public static final zzkl zzb;
    public static final zzkl zzc;
    public static final zzkl zzd;
    public static final zzkl zze;
    public static final zzkl zzf;
    public static final zzkl zzg;
    public static final zzkl zzh;

    static {
        zzkf zzkf0 = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zzkf0.zzd("measurement.rb.attribution.ad_campaign_info", true);
        zzkf0.zzd("measurement.rb.attribution.service.bundle_on_backgrounded", true);
        zzqn.zza = zzkf0.zzd("measurement.rb.attribution.client2", true);
        zzqn.zzb = zzkf0.zzd("measurement.rb.attribution.followup1.service", false);
        zzkf0.zzd("measurement.rb.attribution.client.get_trigger_uris_async", true);
        zzqn.zzc = zzkf0.zzd("measurement.rb.attribution.service.trigger_uris_high_priority", true);
        zzkf0.zzd("measurement.rb.attribution.index_out_of_bounds_fix", true);
        zzqn.zzd = zzkf0.zzd("measurement.rb.attribution.service.enable_max_trigger_uris_queried_at_once", true);
        zzqn.zze = zzkf0.zzd("measurement.rb.attribution.retry_disposition", false);
        zzqn.zzf = zzkf0.zzd("measurement.rb.attribution.service", true);
        zzqn.zzg = zzkf0.zzd("measurement.rb.attribution.enable_trigger_redaction", true);
        zzqn.zzh = zzkf0.zzd("measurement.rb.attribution.uuid_generation", true);
        zzkf0.zzc("measurement.id.rb.attribution.retry_disposition", 0L);
        zzkf0.zzd("measurement.rb.attribution.improved_retry", true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzqm
    public final boolean zza() {
        return true;
    }

    @Override  // com.google.android.gms.internal.measurement.zzqm
    public final boolean zzb() {
        return ((Boolean)zzqn.zza.zzd()).booleanValue();
    }

    @Override  // com.google.android.gms.internal.measurement.zzqm
    public final boolean zzc() {
        return ((Boolean)zzqn.zzb.zzd()).booleanValue();
    }

    @Override  // com.google.android.gms.internal.measurement.zzqm
    public final boolean zzd() {
        return ((Boolean)zzqn.zzc.zzd()).booleanValue();
    }

    @Override  // com.google.android.gms.internal.measurement.zzqm
    public final boolean zze() {
        return ((Boolean)zzqn.zzd.zzd()).booleanValue();
    }

    @Override  // com.google.android.gms.internal.measurement.zzqm
    public final boolean zzf() {
        return ((Boolean)zzqn.zze.zzd()).booleanValue();
    }

    @Override  // com.google.android.gms.internal.measurement.zzqm
    public final boolean zzg() {
        return ((Boolean)zzqn.zzf.zzd()).booleanValue();
    }

    @Override  // com.google.android.gms.internal.measurement.zzqm
    public final boolean zzh() {
        return ((Boolean)zzqn.zzg.zzd()).booleanValue();
    }

    @Override  // com.google.android.gms.internal.measurement.zzqm
    public final boolean zzi() {
        return ((Boolean)zzqn.zzh.zzd()).booleanValue();
    }
}

