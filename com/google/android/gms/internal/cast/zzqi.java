package com.google.android.gms.internal.cast;

public final class zzqi extends zzxi implements zzym {
    private static final zzqi zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzqi zzqi0 = new zzqi();
        zzqi.zzb = zzqi0;
        zzxi.zzJ(zzqi.class, zzqi0);
    }

    public static zzqh zza() {
        return (zzqh)zzqi.zzb.zzy();
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzqi.zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001", new Object[]{"zzd", "zze", zzof.zza(), "zzf"});
            }
            case 3: {
                return new zzqi();
            }
            case 4: {
                return new zzqh(null);
            }
            case 5: {
                return zzqi.zzb;
            }
            default: {
                throw null;
            }
        }
    }

    public static zzqi zzc() {
        return zzqi.zzb;
    }

    public static void zzd(zzqi zzqi0, int v) {
        zzqi0.zzd |= 2;
        zzqi0.zzf = v;
    }

    public static void zze(zzqi zzqi0, int v) {
        zzqi0.zze = v - 1;
        zzqi0.zzd |= 1;
    }
}

