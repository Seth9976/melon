package com.google.android.gms.internal.cast;

public final class zzrm extends zzxi implements zzym {
    private static final zzrm zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private zzxl zzg;
    private zzxl zzh;
    private zzxn zzi;
    private zzxn zzj;
    private int zzk;

    static {
        zzrm zzrm0 = new zzrm();
        zzrm.zzb = zzrm0;
        zzxi.zzJ(zzrm.class, zzrm0);
    }

    private zzrm() {
        this.zzg = zzxi.zzB();
        this.zzh = zzxi.zzB();
        this.zzi = zzxi.zzD();
        this.zzj = zzxi.zzD();
    }

    public static zzrm zza() {
        return zzrm.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzrm.zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0004\u0000\u0001င\u0000\u0002᠌\u0001\u0003\u0016\u0004\u0016\u0005\u001A\u0006\u001A\u0007᠌\u0002", new Object[]{"zzd", "zze", "zzf", zzmf.zza(), "zzg", "zzh", "zzi", "zzj", "zzk", zzlx.zza()});
            }
            case 3: {
                return new zzrm();
            }
            case 4: {
                return new zzrl(null);
            }
            case 5: {
                return zzrm.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

