package com.google.android.gms.internal.cast;

public final class zzqu extends zzxi implements zzym {
    private static final zzqu zzb;
    private int zzd;
    private String zze;
    private long zzf;
    private long zzg;
    private zzxn zzh;
    private int zzi;
    private boolean zzj;
    private String zzk;
    private long zzl;
    private long zzm;

    static {
        zzqu zzqu0 = new zzqu();
        zzqu.zzb = zzqu0;
        zzxi.zzJ(zzqu.class, zzqu0);
    }

    private zzqu() {
        this.zze = "";
        this.zzh = zzxi.zzD();
        this.zzk = "";
    }

    public static zzqu zza() {
        return zzqu.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzqu.zzb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004\u001B\u0005င\u0003\u0006ဇ\u0004\u0007ဈ\u0005\bဂ\u0006\tဂ\u0007", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", zzqs.class, "zzi", "zzj", "zzk", "zzl", "zzm"});
            }
            case 3: {
                return new zzqu();
            }
            case 4: {
                return new zzqt(null);
            }
            case 5: {
                return zzqu.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

