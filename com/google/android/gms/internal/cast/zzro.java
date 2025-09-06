package com.google.android.gms.internal.cast;

public final class zzro extends zzxi implements zzym {
    private static final zzro zzb;
    private int zzd;
    private int zze;

    static {
        zzro zzro0 = new zzro();
        zzro.zzb = zzro0;
        zzxi.zzJ(zzro.class, zzro0);
    }

    public static zzro zza() {
        return zzro.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzro.zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzmf.zza()});
            }
            case 3: {
                return new zzro();
            }
            case 4: {
                return new zzrn(null);
            }
            case 5: {
                return zzro.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

