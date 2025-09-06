package com.google.android.gms.internal.measurement;

public final class zzpp implements zzpo {
    public static final zzkl zza;
    public static final zzkl zzb;

    static {
        zzkf zzkf0 = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zzkf0.zzd("measurement.collection.event_safelist", true);
        zzpp.zza = zzkf0.zzd("measurement.service.store_null_safelist", true);
        zzpp.zzb = zzkf0.zzd("measurement.service.store_safelist", true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzpo
    public final boolean zza() {
        return true;
    }

    @Override  // com.google.android.gms.internal.measurement.zzpo
    public final boolean zzb() {
        return ((Boolean)zzpp.zza.zzd()).booleanValue();
    }

    @Override  // com.google.android.gms.internal.measurement.zzpo
    public final boolean zzc() {
        return ((Boolean)zzpp.zzb.zzd()).booleanValue();
    }
}

