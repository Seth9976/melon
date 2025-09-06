package com.google.android.gms.internal.measurement;

public final class zzqk implements zzqj {
    public static final zzkl zza;
    public static final zzkl zzb;
    public static final zzkl zzc;
    public static final zzkl zzd;
    public static final zzkl zze;
    public static final zzkl zzf;

    static {
        zzkf zzkf0 = new zzkf(zzka.zza("com.google.android.gms.measurement")).zza().zzb();
        zzqk.zza = zzkf0.zzd("measurement.test.boolean_flag", false);
        zzqk.zzb = zzkf0.zzc("measurement.test.cached_long_flag", -1L);
        zzqk.zzc = zzkf0.zze("measurement.test.double_flag", -3.0);
        zzqk.zzd = zzkf0.zzc("measurement.test.int_flag", -2L);
        zzqk.zze = zzkf0.zzc("measurement.test.long_flag", -1L);
        zzqk.zzf = zzkf0.zzf("measurement.test.string_flag", "---");
    }

    @Override  // com.google.android.gms.internal.measurement.zzqj
    public final boolean zza() {
        return ((Boolean)zzqk.zza.zzd()).booleanValue();
    }

    @Override  // com.google.android.gms.internal.measurement.zzqj
    public final long zzb() {
        return (long)(((Long)zzqk.zzb.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzqj
    public final double zzc() {
        return (double)(((Double)zzqk.zzc.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzqj
    public final long zzd() {
        return (long)(((Long)zzqk.zzd.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzqj
    public final long zze() {
        return (long)(((Long)zzqk.zze.zzd()));
    }

    @Override  // com.google.android.gms.internal.measurement.zzqj
    public final String zzf() {
        return (String)zzqk.zzf.zzd();
    }
}

