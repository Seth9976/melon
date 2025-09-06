package com.google.android.gms.internal.cast;

public final class zzra extends zzxi implements zzym {
    private static final zzra zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private zzpl zzg;

    static {
        zzra zzra0 = new zzra();
        zzra.zzb = zzra0;
        zzxi.zzJ(zzra.class, zzra0);
    }

    public static zzra zza() {
        return zzra.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzra.zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzlt.zza(), "zzf", "zzg"});
            }
            case 3: {
                return new zzra();
            }
            case 4: {
                return new zzqz(null);
            }
            case 5: {
                return zzra.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

