package com.google.android.gms.internal.cast;

public final class zzsg extends zzxi implements zzym {
    private static final zzsg zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;

    static {
        zzsg zzsg0 = new zzsg();
        zzsg.zzb = zzsg0;
        zzxi.zzJ(zzsg.class, zzsg0);
    }

    public static zzsg zza() {
        return zzsg.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzsg.zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005᠌\u0004\u0006ဆ\u0005", new Object[]{"zzd", "zze", "zzf", zzmz.zza(), "zzg", "zzh", "zzi", zzlr.zza(), "zzj"});
            }
            case 3: {
                return new zzsg();
            }
            case 4: {
                return new zzsf(null);
            }
            case 5: {
                return zzsg.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

