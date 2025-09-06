package com.google.android.gms.internal.measurement;

public final class zzqh implements zzqg {
    public static final zzkl zza;

    static {
        zzkf zzkf0 = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zzkf0.zzd("measurement.sdk.collection.enable_extend_user_property_size", true);
        zzqh.zza = zzkf0.zzd("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        zzkf0.zzc("measurement.id.sdk.collection.last_deep_link_referrer2", 0L);
    }

    @Override  // com.google.android.gms.internal.measurement.zzqg
    public final boolean zza() {
        return ((Boolean)zzqh.zza.zzd()).booleanValue();
    }
}

