package com.google.android.gms.internal.cast;

public final class zzrw extends zzxi implements zzym {
    private static final zzrw zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzrw zzrw0 = new zzrw();
        zzrw.zzb = zzrw0;
        zzxi.zzJ(zzrw.class, zzrw0);
    }

    public static zzrw zza() {
        return zzrw.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzrw.zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001", new Object[]{"zzd", "zze", zzlv.zza(), "zzf"});
            }
            case 3: {
                return new zzrw();
            }
            case 4: {
                return new zzrv(null);
            }
            case 5: {
                return zzrw.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

