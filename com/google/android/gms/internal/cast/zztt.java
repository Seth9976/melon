package com.google.android.gms.internal.cast;

public final class zztt extends zzxi implements zzym {
    private static final zztt zzb;
    private int zzd;
    private zzpl zze;

    static {
        zztt zztt0 = new zztt();
        zztt.zzb = zztt0;
        zzxi.zzJ(zztt.class, zztt0);
    }

    public static zztt zza() {
        return zztt.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zztt.zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zzd", "zze"});
            }
            case 3: {
                return new zztt();
            }
            case 4: {
                return new zzts(null);
            }
            case 5: {
                return zztt.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

