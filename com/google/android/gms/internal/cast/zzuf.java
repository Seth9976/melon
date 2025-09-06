package com.google.android.gms.internal.cast;

public final class zzuf extends zzxi implements zzym {
    private static final zzuf zzb;
    private int zzd;
    private int zze;
    private boolean zzf;
    private zzxn zzg;
    private zzxn zzh;

    static {
        zzuf zzuf0 = new zzuf();
        zzuf.zzb = zzuf0;
        zzxi.zzJ(zzuf.class, zzuf0);
    }

    private zzuf() {
        this.zzg = zzxi.zzD();
        this.zzh = zzxi.zzD();
    }

    public static zzuf zza() {
        return zzuf.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzuf.zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003\u001B\u0004\u001B", new Object[]{"zzd", "zze", zznz.zza(), "zzf", "zzg", zzub.class, "zzh", zzud.class});
            }
            case 3: {
                return new zzuf();
            }
            case 4: {
                return new zzue(null);
            }
            case 5: {
                return zzuf.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

