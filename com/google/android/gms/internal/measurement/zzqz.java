package com.google.android.gms.internal.measurement;

public final class zzqz implements zzqy {
    public static final zzkl zza;

    static {
        zzkf zzkf0 = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zzqz.zza = zzkf0.zzd("measurement.client.sessions.enable_fix_background_engagement", false);
        zzkf0.zzd("measurement.client.sessions.enable_pause_engagement_in_background", true);
        zzkf0.zzc("measurement.id.client.sessions.enable_fix_background_engagement", 0L);
    }

    @Override  // com.google.android.gms.internal.measurement.zzqy
    public final boolean zza() {
        return ((Boolean)zzqz.zza.zzd()).booleanValue();
    }
}

