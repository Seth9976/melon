package com.google.android.gms.internal.measurement;

public final class zzqe implements zzqd {
    public static final zzkl zza;

    static {
        zzkf zzkf0 = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zzkf0.zzd("measurement.gmscore_feature_tracking", true);
        zzqe.zza = zzkf0.zzd("measurement.gmscore_client_telemetry", false);
    }

    @Override  // com.google.android.gms.internal.measurement.zzqd
    public final boolean zza() {
        return ((Boolean)zzqe.zza.zzd()).booleanValue();
    }
}

