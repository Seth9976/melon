package com.google.android.gms.internal.cast;

public final class zzuj extends zzxi implements zzym {
    private static final zzuj zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private zzpl zzg;

    static {
        zzuj zzuj0 = new zzuj();
        zzuj.zzb = zzuj0;
        zzxi.zzJ(zzuj.class, zzuj0);
    }

    public static zzuj zza() {
        return zzuj.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzuj.zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzob.zza(), "zzf", "zzg"});
            }
            case 3: {
                return new zzuj();
            }
            case 4: {
                return new zzui(null);
            }
            case 5: {
                return zzuj.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

