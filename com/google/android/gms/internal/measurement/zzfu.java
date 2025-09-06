package com.google.android.gms.internal.measurement;

public final class zzfu extends zzme implements zznm {
    private int zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private static final zzfu zzg;

    static {
        zzfu zzfu0 = new zzfu();
        zzfu.zzg = zzfu0;
        zzme.zzcp(zzfu.class, zzfu0);
    }

    public static zzfu zza() {
        return zzfu.zzg;
    }

    public final int zzb() {
        int v = zzga.zza(this.zzd);
        return v == 0 ? 1 : v;
    }

    public final int zzc() {
        int v = zzfy.zza(this.zze);
        return v == 0 ? 1 : v;
    }

    public final int zzd() {
        int v = zzge.zza(this.zzf);
        return v == 0 ? 1 : v;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzfu.zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzb", "zzd", zzfz.zza, "zze", zzfx.zza, "zzf", zzgd.zza});
            }
            case 3: {
                return new zzfu();
            }
            case 4: {
                return new zzft(null);
            }
            case 5: {
                return zzfu.zzg;
            }
            default: {
                throw null;
            }
        }
    }
}

