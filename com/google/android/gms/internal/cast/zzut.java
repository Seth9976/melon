package com.google.android.gms.internal.cast;

public final class zzut extends zzxi implements zzym {
    private static final zzut zzb;
    private int zzd;
    private String zze;
    private long zzf;
    private long zzg;
    private zzuv zzh;

    static {
        zzut zzut0 = new zzut();
        zzut.zzb = zzut0;
        zzxi.zzJ(zzut.class, zzut0);
    }

    private zzut() {
        this.zze = "";
    }

    public static zzut zza() {
        return zzut.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzut.zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဉ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
            }
            case 3: {
                return new zzut();
            }
            case 4: {
                return new zzus(null);
            }
            case 5: {
                return zzut.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

