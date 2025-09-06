package com.google.android.gms.internal.measurement;

public final class zzqb implements zzqa {
    public static final zzkl zza;

    static {
        zzkf zzkf0 = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zzkf0.zzd("measurement.gbraid_campaign.gbraid.client", true);
        zzqb.zza = zzkf0.zzd("measurement.gbraid_campaign.stop_lgclid", false);
    }

    @Override  // com.google.android.gms.internal.measurement.zzqa
    public final boolean zza() {
        return ((Boolean)zzqb.zza.zzd()).booleanValue();
    }
}

