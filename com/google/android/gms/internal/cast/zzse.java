package com.google.android.gms.internal.cast;

public final class zzse extends zzxi implements zzym {
    private static final zzse zzb;
    private int zzd;
    private int zze;
    private long zzf;
    private int zzg;

    static {
        zzse zzse0 = new zzse();
        zzse.zzb = zzse0;
        zzxi.zzJ(zzse.class, zzse0);
    }

    public static zzse zza() {
        return zzse.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzse.zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001\u0003᠌\u0002", new Object[]{"zzd", "zze", zzmx.zza(), "zzf", "zzg", zzlb.zza()});
            }
            case 3: {
                return new zzse();
            }
            case 4: {
                return new zzsd(null);
            }
            case 5: {
                return zzse.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

