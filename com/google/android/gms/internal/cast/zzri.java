package com.google.android.gms.internal.cast;

public final class zzri extends zzxi implements zzym {
    private static final zzri zzb;
    private int zzd;
    private boolean zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private zzsg zzi;
    private int zzj;
    private boolean zzk;

    static {
        zzri zzri0 = new zzri();
        zzri.zzb = zzri0;
        zzxi.zzJ(zzri.class, zzri0);
    }

    public static zzri zza() {
        return zzri.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzri.zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004᠌\u0003\u0005ဉ\u0004\u0006᠌\u0005\u0007ဇ\u0006", new Object[]{"zzd", "zze", "zzf", zzlx.zza(), "zzg", zzmb.zza(), "zzh", zzkz.zza(), "zzi", "zzj", zzlz.zza(), "zzk"});
            }
            case 3: {
                return new zzri();
            }
            case 4: {
                return new zzrh(null);
            }
            case 5: {
                return zzri.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

