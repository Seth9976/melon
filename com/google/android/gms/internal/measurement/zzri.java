package com.google.android.gms.internal.measurement;

public final class zzri implements zzrh {
    public static final zzkl zza;

    static {
        zzri.zza = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb().zzd("measurement.integration.disable_firebase_instance_id", false);
    }

    @Override  // com.google.android.gms.internal.measurement.zzrh
    public final boolean zza() {
        return true;
    }

    @Override  // com.google.android.gms.internal.measurement.zzrh
    public final boolean zzb() {
        return ((Boolean)zzri.zza.zzd()).booleanValue();
    }
}

