package com.google.android.gms.internal.measurement;

public final class zzhl extends zzme implements zznm {
    private int zzb;
    private int zzd;
    private int zze;
    private static final zzhl zzf;

    static {
        zzhl zzhl0 = new zzhl();
        zzhl.zzf = zzhl0;
        zzme.zzcp(zzhl.class, zzhl0);
    }

    public static zzhk zza() {
        return (zzhk)zzhl.zzf.zzck();
    }

    public static zzhl zzb() {
        return zzhl.zzf;
    }

    public final int zzc() {
        int v = zzhj.zza(this.zzd);
        return v == 0 ? 1 : v;
    }

    public final int zzd() {
        int v = zzhn.zza(this.zze);
        return v == 0 ? 1 : v;
    }

    public final void zze(int v) {
        this.zzd = v - 1;
        this.zzb |= 1;
    }

    public final void zzf(int v) {
        this.zze = v - 1;
        this.zzb |= 2;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzhl.zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzb", "zzd", zzhi.zza, "zze", zzhm.zza});
            }
            case 3: {
                return new zzhl();
            }
            case 4: {
                return new zzhk(null);
            }
            case 5: {
                return zzhl.zzf;
            }
            default: {
                throw null;
            }
        }
    }
}

