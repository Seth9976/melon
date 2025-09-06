package com.google.android.gms.internal.cast;

public final class zzrf extends zzxi implements zzym {
    private static final zzrf zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zzrf zzrf0 = new zzrf();
        zzrf.zzb = zzrf0;
        zzxi.zzJ(zzrf.class, zzrf0);
    }

    public static zzrf zza() {
        return zzrf.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzrf.zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
            }
            case 3: {
                return new zzrf();
            }
            case 4: {
                return new zzre(null);
            }
            case 5: {
                return zzrf.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

