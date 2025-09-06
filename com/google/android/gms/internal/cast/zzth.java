package com.google.android.gms.internal.cast;

public final class zzth extends zzxi implements zzym {
    private static final zzth zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzth zzth0 = new zzth();
        zzth.zzb = zzth0;
        zzxi.zzJ(zzth.class, zzth0);
    }

    public static zzth zza() {
        return zzth.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzth.zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzd", "zze", "zzf"});
            }
            case 3: {
                return new zzth();
            }
            case 4: {
                return new zztg(null);
            }
            case 5: {
                return zzth.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

