package com.google.android.gms.internal.cast;

public final class zzsq extends zzxi implements zzym {
    private static final zzsq zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;
    private String zzh;
    private int zzi;
    private int zzj;
    private String zzk;

    static {
        zzsq zzsq0 = new zzsq();
        zzsq.zzb = zzsq0;
        zzxi.zzJ(zzsq.class, zzsq0);
    }

    private zzsq() {
        this.zzh = "";
        this.zzk = "";
    }

    public static zzsq zza() {
        return zzsq.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzsq.zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003င\u0002\u0004ဈ\u0003\u0005င\u0004\u0006င\u0005\u0007ဈ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
            }
            case 3: {
                return new zzsq();
            }
            case 4: {
                return new zzsp(null);
            }
            case 5: {
                return zzsq.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

