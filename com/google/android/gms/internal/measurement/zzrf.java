package com.google.android.gms.internal.measurement;

public final class zzrf implements zzre {
    public static final zzkl zza;
    public static final zzkl zzb;

    static {
        zzkf zzkf0 = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zzrf.zza = zzkf0.zzd("measurement.tcf.consent_fix", false);
        zzkf0.zzd("measurement.tcf.client", true);
        zzrf.zzb = zzkf0.zzd("measurement.tcf.empty_pref_fix", true);
        zzkf0.zzc("measurement.id.tcf", 0L);
    }

    @Override  // com.google.android.gms.internal.measurement.zzre
    public final boolean zza() {
        return ((Boolean)zzrf.zza.zzd()).booleanValue();
    }

    @Override  // com.google.android.gms.internal.measurement.zzre
    public final boolean zzb() {
        return ((Boolean)zzrf.zzb.zzd()).booleanValue();
    }
}

