package com.google.android.gms.internal.measurement;

public final class zzqw implements zzqv {
    public static final zzkl zza;

    static {
        zzkf zzkf0 = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zzqw.zza = zzkf0.zzd("measurement.session_stitching_token_enabled", false);
        zzkf0.zzd("measurement.link_sst_to_sid", true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzqv
    public final boolean zza() {
        return true;
    }

    @Override  // com.google.android.gms.internal.measurement.zzqv
    public final boolean zzb() {
        return ((Boolean)zzqw.zza.zzd()).booleanValue();
    }
}

