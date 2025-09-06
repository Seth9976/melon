package com.google.android.gms.internal.cast;

public final class zzry extends zzxi implements zzym {
    private static final zzry zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private byte zzh;

    static {
        zzry zzry0 = new zzry();
        zzry.zzb = zzry0;
        zzxi.zzJ(zzry.class, zzry0);
    }

    private zzry() {
        this.zzh = 2;
    }

    public static zzry zza() {
        return zzry.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return this.zzh;
            }
            case 2: {
                return zzxi.zzG(zzry.zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ᴌ\u0000\u0002င\u0001\u0003᠌\u0002", new Object[]{"zzd", "zze", zzmn.zza(), "zzf", "zzg", zzpf.zza()});
            }
            case 3: {
                return new zzry();
            }
            case 4: {
                return new zzrx(null);
            }
            case 5: {
                return zzry.zzb;
            }
            default: {
                this.zzh = object0 == null ? 0 : 1;
                return null;
            }
        }
    }
}

