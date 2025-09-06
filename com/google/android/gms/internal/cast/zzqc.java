package com.google.android.gms.internal.cast;

public final class zzqc extends zzxi implements zzym {
    private static final zzqc zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    static {
        zzqc zzqc0 = new zzqc();
        zzqc.zzb = zzqc0;
        zzxi.zzJ(zzqc.class, zzqc0);
    }

    public static zzqc zza() {
        return zzqc.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzqc.zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004ဇ\u0003\u0005င\u0004\u0006င\u0005\u0007ဇ\u0006", new Object[]{"zzd", "zze", zznl.zza(), "zzf", zznh.zza(), "zzg", zznj.zza(), "zzh", "zzi", "zzj", "zzk"});
            }
            case 3: {
                return new zzqc();
            }
            case 4: {
                return new zzqb(null);
            }
            case 5: {
                return zzqc.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

