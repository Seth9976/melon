package com.google.android.gms.internal.cast;

public final class zztd extends zzxi implements zzym {
    private static final zztd zzb;
    private int zzd;
    private int zze;

    static {
        zztd zztd0 = new zztd();
        zztd.zzb = zztd0;
        zzxi.zzJ(zztd.class, zztd0);
    }

    public static zztd zza() {
        return zztd.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zztd.zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zztc.zza});
            }
            case 3: {
                return new zztd();
            }
            case 4: {
                return new zztb(null);
            }
            case 5: {
                return zztd.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

