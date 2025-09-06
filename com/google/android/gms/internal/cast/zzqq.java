package com.google.android.gms.internal.cast;

public final class zzqq extends zzxi implements zzym {
    private static final zzqq zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzqq zzqq0 = new zzqq();
        zzqq.zzb = zzqq0;
        zzxi.zzJ(zzqq.class, zzqq0);
    }

    public static zzqp zza() {
        return (zzqp)zzqq.zzb.zzy();
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzqq.zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001", new Object[]{"zzd", "zze", zzop.zza(), "zzf"});
            }
            case 3: {
                return new zzqq();
            }
            case 4: {
                return new zzqp(null);
            }
            case 5: {
                return zzqq.zzb;
            }
            default: {
                throw null;
            }
        }
    }

    public static zzqq zzc() {
        return zzqq.zzb;
    }

    public static void zzd(zzqq zzqq0, int v) {
        zzqq0.zzd |= 2;
        zzqq0.zzf = v;
    }

    public static void zze(zzqq zzqq0, int v) {
        zzqq0.zze = v - 1;
        zzqq0.zzd |= 1;
    }
}

