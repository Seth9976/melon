package com.google.android.gms.internal.cast;

public final class zzpx extends zzxi implements zzym {
    private static final zzpx zzb;
    private zzxn zzd;

    static {
        zzpx zzpx0 = new zzpx();
        zzpx.zzb = zzpx0;
        zzxi.zzJ(zzpx.class, zzpx0);
    }

    private zzpx() {
        this.zzd = zzxi.zzD();
    }

    public static zzpx zza() {
        return zzpx.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzpx.zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001A", new Object[]{"zzd"});
            }
            case 3: {
                return new zzpx();
            }
            case 4: {
                return new zzpw(null);
            }
            case 5: {
                return zzpx.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

