package com.google.android.gms.internal.cast;

public final class zzqw extends zzxi implements zzym {
    private static final zzqw zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzqw zzqw0 = new zzqw();
        zzqw.zzb = zzqw0;
        zzxi.zzJ(zzqw.class, zzqw0);
    }

    public static zzqw zza() {
        return zzqw.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzqw.zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzd", "zze", zzlp.zza(), "zzf", zzln.zza()});
            }
            case 3: {
                return new zzqw();
            }
            case 4: {
                return new zzqv(null);
            }
            case 5: {
                return zzqw.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

