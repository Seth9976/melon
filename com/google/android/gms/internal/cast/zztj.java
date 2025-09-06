package com.google.android.gms.internal.cast;

public final class zztj extends zzxi implements zzym {
    private static final zztj zzb;
    private int zzd;
    private zzaag zze;
    private zzxn zzf;
    private zzxn zzg;
    private zzxn zzh;
    private String zzi;
    private long zzj;
    private int zzk;

    static {
        zztj zztj0 = new zztj();
        zztj.zzb = zztj0;
        zzxi.zzJ(zztj.class, zztj0);
    }

    private zztj() {
        this.zzf = zzxi.zzD();
        this.zzg = zzxi.zzD();
        this.zzh = zzxi.zzD();
        this.zzi = "";
    }

    public static zztj zza() {
        return zztj.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zztj.zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0003\u0000\u0001ဉ\u0000\u0002\u001A\u0003\u001B\u0004\u001B\u0005ဈ\u0001\u0006ဂ\u0002\u0007᠌\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", zzpr.class, "zzh", zzta.class, "zzi", "zzj", "zzk", zzpy.zza});
            }
            case 3: {
                return new zztj();
            }
            case 4: {
                return new zzti(null);
            }
            case 5: {
                return zztj.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

