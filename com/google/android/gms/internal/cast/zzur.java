package com.google.android.gms.internal.cast;

public final class zzur extends zzxi implements zzym {
    private static final zzur zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private zzxl zzg;
    private int zzh;
    private zzxn zzi;
    private long zzj;

    static {
        zzur zzur0 = new zzur();
        zzur.zzb = zzur0;
        zzxi.zzJ(zzur.class, zzur0);
    }

    private zzur() {
        this.zzg = zzxi.zzB();
        this.zzi = zzxi.zzD();
    }

    public static zzur zza() {
        return zzur.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzur.zzb, "\u0001\u0006\u0000\u0001\u0001\u0007\u0006\u0000\u0002\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003ࠞ\u0005᠌\u0002\u0006\u001B\u0007ဂ\u0003", new Object[]{"zzd", "zze", zzoz.zza(), "zzf", zzlx.zza(), "zzg", zzox.zza(), "zzh", zzll.zza(), "zzi", zzup.class, "zzj"});
            }
            case 3: {
                return new zzur();
            }
            case 4: {
                return new zzuq(null);
            }
            case 5: {
                return zzur.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

