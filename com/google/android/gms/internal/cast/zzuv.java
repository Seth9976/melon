package com.google.android.gms.internal.cast;

public final class zzuv extends zzxi implements zzym {
    private static final zzuv zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private long zzg;

    static {
        zzuv zzuv0 = new zzuv();
        zzuv.zzb = zzuv0;
        zzxi.zzJ(zzuv.class, zzuv0);
    }

    public static zzuv zza() {
        return zzuv.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzuv.zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003ဂ\u0002", new Object[]{"zzd", "zze", zzpd.zza(), "zzf", "zzg"});
            }
            case 3: {
                return new zzuv();
            }
            case 4: {
                return new zzuu(null);
            }
            case 5: {
                return zzuv.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

