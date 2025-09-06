package com.google.android.gms.internal.cast;

public final class zzqy extends zzxi implements zzym {
    private static final zzqy zzb;
    private int zzd;
    private int zze;
    private Object zzf;
    private long zzg;

    static {
        zzqy zzqy0 = new zzqy();
        zzqy.zzb = zzqy0;
        zzxi.zzJ(zzqy.class, zzqy0);
    }

    private zzqy() {
        this.zze = 0;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzqy.zzb, "\u0001\u0004\u0001\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001စ\u0000\u0002:\u0000\u00035\u0000\u00048\u0000", new Object[]{"zzf", "zze", "zzd", "zzg"});
            }
            case 3: {
                return new zzqy();
            }
            case 4: {
                return new zzqx(null);
            }
            case 5: {
                return zzqy.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

