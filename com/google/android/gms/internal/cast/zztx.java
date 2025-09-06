package com.google.android.gms.internal.cast;

public final class zztx extends zzxi implements zzym {
    private static final zztx zzb;
    private int zzd;
    private long zze;
    private boolean zzf;
    private long zzg;
    private boolean zzh;

    static {
        zztx zztx0 = new zztx();
        zztx.zzb = zztx0;
        zzxi.zzJ(zztx.class, zztx0);
    }

    public static zztx zza() {
        return zztx.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zztx.zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဇ\u0001\u0003ဂ\u0002\u0004ဇ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
            }
            case 3: {
                return new zztx();
            }
            case 4: {
                return new zztw(null);
            }
            case 5: {
                return zztx.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

