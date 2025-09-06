package com.google.android.gms.internal.cast;

public final class zzrq extends zzxi implements zzym {
    private static final zzrq zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzrq zzrq0 = new zzrq();
        zzrq.zzb = zzrq0;
        zzxi.zzJ(zzrq.class, zzrq0);
    }

    public static zzrq zza() {
        return zzrq.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzrq.zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzd", "zze", zzmf.zza(), "zzf", "zzg"});
            }
            case 3: {
                return new zzrq();
            }
            case 4: {
                return new zzrp(null);
            }
            case 5: {
                return zzrq.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

