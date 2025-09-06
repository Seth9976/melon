package com.google.android.gms.internal.cast;

public final class zzss extends zzxi implements zzym {
    private static final zzss zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzss zzss0 = new zzss();
        zzss.zzb = zzss0;
        zzxi.zzJ(zzss.class, zzss0);
    }

    public static zzss zza() {
        return zzss.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzss.zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002᠌\u0001\u0003င\u0002", new Object[]{"zzd", "zze", "zzf", zznf.zza(), "zzg"});
            }
            case 3: {
                return new zzss();
            }
            case 4: {
                return new zzsr(null);
            }
            case 5: {
                return zzss.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

