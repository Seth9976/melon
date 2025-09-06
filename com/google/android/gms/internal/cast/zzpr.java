package com.google.android.gms.internal.cast;

public final class zzpr extends zzxi implements zzym {
    private static final zzpr zzb;
    private int zzd;
    private String zze;
    private long zzf;

    static {
        zzpr zzpr0 = new zzpr();
        zzpr.zzb = zzpr0;
        zzxi.zzJ(zzpr.class, zzpr0);
    }

    private zzpr() {
        this.zze = "";
    }

    public static zzpr zza() {
        return zzpr.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzpr.zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", "zzf"});
            }
            case 3: {
                return new zzpr();
            }
            case 4: {
                return new zzpq(null);
            }
            case 5: {
                return zzpr.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

