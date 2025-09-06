package com.google.android.gms.internal.cast;

public final class zzpv extends zzxi implements zzym {
    private static final zzpv zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zzpv zzpv0 = new zzpv();
        zzpv.zzb = zzpv0;
        zzxi.zzJ(zzpv.class, zzpv0);
    }

    public static zzpv zza() {
        return zzpv.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzpv.zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဋ\u0000\u0002ဋ\u0001\u0003᠌\u0002\u0004င\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", zzml.zza(), "zzh"});
            }
            case 3: {
                return new zzpv();
            }
            case 4: {
                return new zzpu(null);
            }
            case 5: {
                return zzpv.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

