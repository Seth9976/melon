package com.google.android.gms.internal.measurement;

public final class zzqt implements zzqs {
    public static final zzkl zza;

    static {
        zzqt.zza = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb().zzd("measurement.experiment.enable_phenotype_experiment_reporting", true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzqs
    public final boolean zza() {
        return ((Boolean)zzqt.zza.zzd()).booleanValue();
    }
}

