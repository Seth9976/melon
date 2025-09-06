package com.google.android.gms.internal.cast;

public final class zzun extends zzxi implements zzym {
    private static final zzun zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private zzxn zzg;
    private zzxn zzh;
    private int zzi;
    private zzxl zzj;
    private boolean zzk;
    private boolean zzl;

    static {
        zzun zzun0 = new zzun();
        zzun.zzb = zzun0;
        zzxi.zzJ(zzun.class, zzun0);
    }

    private zzun() {
        this.zzg = zzxi.zzD();
        this.zzh = zzxi.zzD();
        this.zzj = zzxi.zzB();
    }

    public static zzun zza() {
        return zzun.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzun.zzb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0003\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003\u001B\u0004\u001B\u0005᠌\u0002\u0006ࠬ\u0007ဇ\u0003\bဇ\u0004", new Object[]{"zzd", "zze", zzot.zza(), "zzf", zzov.zza(), "zzg", zzrc.class, "zzh", zzrc.class, "zzi", zzlx.zza(), "zzj", zzot.zza(), "zzk", "zzl"});
            }
            case 3: {
                return new zzun();
            }
            case 4: {
                return new zzum(null);
            }
            case 5: {
                return zzun.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

