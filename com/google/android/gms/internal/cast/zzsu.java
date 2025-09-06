package com.google.android.gms.internal.cast;

public final class zzsu extends zzxi implements zzym {
    private static final zzsu zzb;
    private int zzd;
    private zzxn zze;
    private zzxn zzf;
    private zztt zzg;

    static {
        zzsu zzsu0 = new zzsu();
        zzsu.zzb = zzsu0;
        zzxi.zzJ(zzsu.class, zzsu0);
    }

    private zzsu() {
        this.zze = zzxi.zzD();
        this.zzf = zzxi.zzD();
    }

    public static zzsu zza() {
        return zzsu.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzsu.zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u001B\u0002\u001B\u0003ဉ\u0000", new Object[]{"zzd", "zze", zzuj.class, "zzf", zzra.class, "zzg"});
            }
            case 3: {
                return new zzsu();
            }
            case 4: {
                return new zzst(null);
            }
            case 5: {
                return zzsu.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

