package com.google.android.gms.internal.cast;

public final class zzsm extends zzxi implements zzym {
    private static final zzsm zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzsm zzsm0 = new zzsm();
        zzsm.zzb = zzsm0;
        zzxi.zzJ(zzsm.class, zzsm0);
    }

    public static zzsm zza() {
        return zzsm.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzsm.zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
            }
            case 3: {
                return new zzsm();
            }
            case 4: {
                return new zzsl(null);
            }
            case 5: {
                return zzsm.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

