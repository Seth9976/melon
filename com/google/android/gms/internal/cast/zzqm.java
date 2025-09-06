package com.google.android.gms.internal.cast;

public final class zzqm extends zzxi implements zzym {
    private static final zzqm zzb;
    private int zzd;
    private zzrc zze;
    private long zzf;
    private int zzg;
    private zzxn zzh;
    private zzxn zzi;
    private zzxn zzj;
    private zzxn zzk;
    private zzxn zzl;
    private int zzm;

    static {
        zzqm zzqm0 = new zzqm();
        zzqm.zzb = zzqm0;
        zzxi.zzJ(zzqm.class, zzqm0);
    }

    private zzqm() {
        this.zzh = zzxi.zzD();
        this.zzi = zzxi.zzD();
        this.zzj = zzxi.zzD();
        this.zzk = zzxi.zzD();
        this.zzl = zzxi.zzD();
    }

    public static zzql zza() {
        return (zzql)zzqm.zzb.zzy();
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzqm.zzb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0005\u0000\u0001ဉ\u0000\u0002စ\u0001\u0003᠌\u0002\u0004\u001B\u0005\u001B\u0006\u001B\u0007\u001B\b\u001B\tင\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", zzon.zza(), "zzh", zzqk.class, "zzi", zzqg.class, "zzj", zzqq.class, "zzk", zzqo.class, "zzl", zzqi.class, "zzm"});
            }
            case 3: {
                return new zzqm();
            }
            case 4: {
                return new zzql(null);
            }
            case 5: {
                return zzqm.zzb;
            }
            default: {
                throw null;
            }
        }
    }

    public static zzqm zzc() {
        return zzqm.zzb;
    }

    public static void zzd(zzqm zzqm0, Iterable iterable0) {
        zzxn zzxn0 = zzqm0.zzh;
        if(!zzxn0.zzc()) {
            zzqm0.zzh = zzxi.zzE(zzxn0);
        }
        zzwa.zzt(iterable0, zzqm0.zzh);
    }

    public static void zze(zzqm zzqm0, Iterable iterable0) {
        zzxn zzxn0 = zzqm0.zzi;
        if(!zzxn0.zzc()) {
            zzqm0.zzi = zzxi.zzE(zzxn0);
        }
        zzwa.zzt(iterable0, zzqm0.zzi);
    }

    public static void zzf(zzqm zzqm0, Iterable iterable0) {
        zzxn zzxn0 = zzqm0.zzl;
        if(!zzxn0.zzc()) {
            zzqm0.zzl = zzxi.zzE(zzxn0);
        }
        zzwa.zzt(iterable0, zzqm0.zzl);
    }

    public static void zzg(zzqm zzqm0, Iterable iterable0) {
        zzxn zzxn0 = zzqm0.zzj;
        if(!zzxn0.zzc()) {
            zzqm0.zzj = zzxi.zzE(zzxn0);
        }
        zzwa.zzt(iterable0, zzqm0.zzj);
    }

    public static void zzh(zzqm zzqm0, Iterable iterable0) {
        zzxn zzxn0 = zzqm0.zzk;
        if(!zzxn0.zzc()) {
            zzqm0.zzk = zzxi.zzE(zzxn0);
        }
        zzwa.zzt(iterable0, zzqm0.zzk);
    }

    public static void zzi(zzqm zzqm0, zzrc zzrc0) {
        zzrc0.getClass();
        zzqm0.zze = zzrc0;
        zzqm0.zzd |= 1;
    }

    public static void zzj(zzqm zzqm0, int v) {
        zzqm0.zzd |= 8;
        zzqm0.zzm = v;
    }

    public static void zzk(zzqm zzqm0, long v) {
        zzqm0.zzd |= 2;
        zzqm0.zzf = v;
    }
}

