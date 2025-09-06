package com.google.android.gms.internal.cast;

public final class zzqa extends zzxi implements zzym {
    private static final zzqa zzb;
    private int zzd;
    private int zze;

    static {
        zzqa zzqa0 = new zzqa();
        zzqa.zzb = zzqa0;
        zzxi.zzJ(zzqa.class, zzqa0);
    }

    public static zzqa zza() {
        return zzqa.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzqa.zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzlf.zza()});
            }
            case 3: {
                return new zzqa();
            }
            case 4: {
                return new zzpz(null);
            }
            case 5: {
                return zzqa.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

