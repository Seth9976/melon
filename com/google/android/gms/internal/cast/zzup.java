package com.google.android.gms.internal.cast;

public final class zzup extends zzxi implements zzym {
    private static final zzup zzb;
    private int zzd;
    private int zze;
    private long zzf;
    private long zzg;

    static {
        zzup zzup0 = new zzup();
        zzup.zzb = zzup0;
        zzxi.zzJ(zzup.class, zzup0);
    }

    public static zzup zza() {
        return zzup.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzup.zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001\u0003ဂ\u0002", new Object[]{"zzd", "zze", zzoz.zza(), "zzf", "zzg"});
            }
            case 3: {
                return new zzup();
            }
            case 4: {
                return new zzuo(null);
            }
            case 5: {
                return zzup.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

