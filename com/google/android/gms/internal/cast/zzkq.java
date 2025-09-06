package com.google.android.gms.internal.cast;

public final class zzkq extends zzxi implements zzym {
    private static final zzkq zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private zzkm zzi;
    private int zzj;

    static {
        zzkq zzkq0 = new zzkq();
        zzkq.zzb = zzkq0;
        zzxi.zzJ(zzkq.class, zzkq0);
    }

    public static zzkq zza() {
        return zzkq.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzkq.zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002᠌\u0001\u0003င\u0002\u0004င\u0003\u0005ဉ\u0004\u0006᠌\u0005", new Object[]{"zzd", "zze", "zzf", zzkp.zza, "zzg", "zzh", "zzi", "zzj", zzko.zza});
            }
            case 3: {
                return new zzkq();
            }
            case 4: {
                return new zzkn(null);
            }
            case 5: {
                return zzkq.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

