package com.google.android.gms.internal.cast;

public final class zzrs extends zzxi implements zzym {
    private static final zzrs zzb;
    private int zzd;
    private zzxn zze;
    private boolean zzf;
    private boolean zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private boolean zzk;

    static {
        zzrs zzrs0 = new zzrs();
        zzrs.zzb = zzrs0;
        zzxi.zzJ(zzrs.class, zzrs0);
    }

    private zzrs() {
        this.zze = zzxi.zzD();
    }

    public static zzrs zza() {
        return zzrs.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzrs.zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u001B\u0002ဇ\u0000\u0003ဇ\u0001\u0004ဂ\u0002\u0005ဂ\u0003\u0006ဂ\u0004\u0007ဇ\u0005", new Object[]{"zzd", "zze", zzrk.class, "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
            }
            case 3: {
                return new zzrs();
            }
            case 4: {
                return new zzrr(null);
            }
            case 5: {
                return zzrs.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

