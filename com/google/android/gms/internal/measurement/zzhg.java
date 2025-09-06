package com.google.android.gms.internal.measurement;

public final class zzhg extends zzme implements zznm {
    private int zzb;
    private int zzd;
    private zzii zze;
    private zzii zzf;
    private boolean zzg;
    private static final zzhg zzh;

    static {
        zzhg zzhg0 = new zzhg();
        zzhg.zzh = zzhg0;
        zzme.zzcp(zzhg.class, zzhg0);
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final int zzb() {
        return this.zzd;
    }

    public final zzii zzc() {
        return this.zze == null ? zzii.zzj() : this.zze;
    }

    public final boolean zzd() {
        return (this.zzb & 4) != 0;
    }

    public final zzii zze() {
        return this.zzf == null ? zzii.zzj() : this.zzf;
    }

    public final boolean zzf() {
        return (this.zzb & 8) != 0;
    }

    public final boolean zzg() {
        return this.zzg;
    }

    public static zzhf zzh() {
        return (zzhf)zzhg.zzh.zzck();
    }

    public final void zzi(int v) {
        this.zzb |= 1;
        this.zzd = v;
    }

    public final void zzj(zzii zzii0) {
        zzii0.getClass();
        this.zze = zzii0;
        this.zzb |= 2;
    }

    public final void zzk(zzii zzii0) {
        this.zzf = zzii0;
        this.zzb |= 4;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzhg.zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg"});
            }
            case 3: {
                return new zzhg();
            }
            case 4: {
                return new zzhf(null);
            }
            case 5: {
                return zzhg.zzh;
            }
            default: {
                throw null;
            }
        }
    }

    public final void zzm(boolean z) {
        this.zzb |= 8;
        this.zzg = z;
    }

    public static zzhg zzn() {
        return zzhg.zzh;
    }
}

