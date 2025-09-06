package com.google.android.gms.internal.measurement;

public final class zzis extends zzme implements zznm {
    private int zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private static final zzis zzg;

    static {
        zzis zzis0 = new zzis();
        zzis.zzg = zzis0;
        zzme.zzcp(zzis.class, zzis0);
    }

    public final zzin zza() {
        zzin zzin0 = zzin.zzb(this.zze);
        return zzin0 == null ? zzin.zza : zzin0;
    }

    public static zzil zzb() {
        return (zzil)zzis.zzg.zzck();
    }

    public static zzis zzc() {
        return zzis.zzg;
    }

    public final void zzd(zzin zzin0) {
        this.zze = zzin0.zza();
        this.zzb |= 2;
    }

    public static zzis zze() {
        return zzis.zzg;
    }

    public final int zzf() {
        int v = zzir.zza(this.zzd);
        return v == 0 ? 1 : v;
    }

    public final int zzg() {
        int v = zzip.zza(this.zzf);
        return v == 0 ? 1 : v;
    }

    public final void zzh(int v) {
        this.zzd = v - 1;
        this.zzb |= 1;
    }

    public final void zzi(int v) {
        this.zzf = v - 1;
        this.zzb |= 4;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzis.zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzb", "zzd", zziq.zza, "zze", zzim.zza, "zzf", zzio.zza});
            }
            case 3: {
                return new zzis();
            }
            case 4: {
                return new zzil(null);
            }
            case 5: {
                return zzis.zzg;
            }
            default: {
                throw null;
            }
        }
    }
}

