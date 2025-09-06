package com.google.android.gms.internal.measurement;

public final class zzhq extends zzme implements zznm {
    private int zzb;
    private int zzd;
    private long zze;
    private static final zzhq zzf;

    static {
        zzhq zzhq0 = new zzhq();
        zzhq.zzf = zzhq0;
        zzme.zzcp(zzhq.class, zzhq0);
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final int zzb() {
        return this.zzd;
    }

    public final boolean zzc() {
        return (this.zzb & 2) != 0;
    }

    public final long zzd() {
        return this.zze;
    }

    public static zzhp zze() {
        return (zzhp)zzhq.zzf.zzck();
    }

    public final void zzf(int v) {
        this.zzb |= 1;
        this.zzd = v;
    }

    public final void zzg(long v) {
        this.zzb |= 2;
        this.zze = v;
    }

    public static zzhq zzh() {
        return zzhq.zzf;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzhq.zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzb", "zzd", "zze"});
            }
            case 3: {
                return new zzhq();
            }
            case 4: {
                return new zzhp(null);
            }
            case 5: {
                return zzhq.zzf;
            }
            default: {
                throw null;
            }
        }
    }
}

