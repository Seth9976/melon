package com.google.android.gms.internal.cast;

public final class zzsk extends zzxi implements zzym {
    private static final zzsk zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    static {
        zzsk zzsk0 = new zzsk();
        zzsk.zzb = zzsk0;
        zzxi.zzJ(zzsk.class, zzsk0);
    }

    public static zzsk zza() {
        return zzsk.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzsk.zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005᠌\u0004\u0006᠌\u0005\u0007ဇ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", zznb.zza(), "zzj", zznb.zza(), "zzk"});
            }
            case 3: {
                return new zzsk();
            }
            case 4: {
                return new zzsj(null);
            }
            case 5: {
                return zzsk.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

