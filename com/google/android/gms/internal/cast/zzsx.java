package com.google.android.gms.internal.cast;

public final class zzsx extends zzxi implements zzym {
    private static final zzsx zzb;
    private int zzd;
    private int zze;

    static {
        zzsx zzsx0 = new zzsx();
        zzsx.zzb = zzsx0;
        zzxi.zzJ(zzsx.class, zzsx0);
    }

    public static zzsx zza() {
        return zzsx.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzsx.zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzsw.zza});
            }
            case 3: {
                return new zzsx();
            }
            case 4: {
                return new zzsv(null);
            }
            case 5: {
                return zzsx.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

