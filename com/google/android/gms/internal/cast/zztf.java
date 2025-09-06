package com.google.android.gms.internal.cast;

public final class zztf extends zzxi implements zzym {
    private static final zztf zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zztf zztf0 = new zztf();
        zztf.zzb = zztf0;
        zzxi.zzJ(zztf.class, zztf0);
    }

    public static zztf zza() {
        return zztf.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zztf.zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzd", "zze", "zzf"});
            }
            case 3: {
                return new zztf();
            }
            case 4: {
                return new zzte(null);
            }
            case 5: {
                return zztf.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

