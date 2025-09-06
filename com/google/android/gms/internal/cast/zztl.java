package com.google.android.gms.internal.cast;

public final class zztl extends zzxi implements zzym {
    private static final zztl zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zztl zztl0 = new zztl();
        zztl.zzb = zztl0;
        zzxi.zzJ(zztl.class, zztl0);
    }

    public static zztl zza() {
        return zztl.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zztl.zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzd", "zze", zznl.zza(), "zzf", zznl.zza()});
            }
            case 3: {
                return new zztl();
            }
            case 4: {
                return new zztk(null);
            }
            case 5: {
                return zztl.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

