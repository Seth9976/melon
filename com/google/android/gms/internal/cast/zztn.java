package com.google.android.gms.internal.cast;

public final class zztn extends zzxi implements zzym {
    private static final zztn zzb;
    private int zzd;
    private zzrc zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private long zzj;
    private zzxn zzk;

    static {
        zztn zztn0 = new zztn();
        zztn.zzb = zztn0;
        zzxi.zzJ(zztn.class, zztn0);
    }

    private zztn() {
        this.zzk = zzxi.zzD();
    }

    public static zztn zza() {
        return zztn.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zztn.zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001ဉ\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006ဂ\u0005\u0007\u001B", new Object[]{"zzd", "zze", "zzf", zznp.zza(), "zzg", zznn.zza(), "zzh", zzlx.zza(), "zzi", zzlb.zza(), "zzj", "zzk", zzrc.class});
            }
            case 3: {
                return new zztn();
            }
            case 4: {
                return new zztm(null);
            }
            case 5: {
                return zztn.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

