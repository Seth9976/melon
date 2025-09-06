package com.google.android.gms.internal.cast;

public final class zzru extends zzxi implements zzym {
    private static final zzru zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private zzrq zzg;

    static {
        zzru zzru0 = new zzru();
        zzru.zzb = zzru0;
        zzxi.zzJ(zzru.class, zzru0);
    }

    public static zzru zza() {
        return zzru.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzru.zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
            }
            case 3: {
                return new zzru();
            }
            case 4: {
                return new zzrt(null);
            }
            case 5: {
                return zzru.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

