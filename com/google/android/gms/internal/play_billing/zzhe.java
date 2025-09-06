package com.google.android.gms.internal.play_billing;

public final class zzhe extends zzcs implements zzed {
    private static final zzhe zzb;
    private int zzd;
    private int zze;
    private Object zzf;
    private zzgu zzg;
    private zzgx zzh;

    static {
        zzhe zzhe0 = new zzhe();
        zzhe.zzb = zzhe0;
        zzcs.zzt(zzhe.class, zzhe0);
    }

    private zzhe() {
        this.zze = 0;
    }

    public static void zzA(zzhe zzhe0, zzhl zzhl0) {
        zzhe0.zzf = zzhl0;
        zzhe0.zze = 4;
    }

    public static void zzB(zzhe zzhe0, zzgu zzgu0) {
        zzgu0.getClass();
        zzhe0.zzg = zzgu0;
        zzhe0.zzd |= 1;
    }

    public static void zzC(zzhe zzhe0, zzga zzga0) {
        zzhe0.zzf = zzga0;
        zzhe0.zze = 2;
    }

    public static void zzD(zzhe zzhe0, zzge zzge0) {
        zzhe0.zzf = zzge0;
        zzhe0.zze = 3;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzcs
    public final Object zzx(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzcs.zzq(zzhe.zzb, "\u0001\u0006\u0001\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006ဉ\u0001", new Object[]{"zzf", "zze", "zzd", "zzg", zzga.class, zzge.class, zzhl.class, zzgr.class, "zzh"});
            }
            case 3: {
                return new zzhe();
            }
            case 4: {
                return new zzhd(null);
            }
            case 5: {
                return zzhe.zzb;
            }
            default: {
                return null;
            }
        }
    }

    public static zzhd zzy() {
        return (zzhd)zzhe.zzb.zzg();
    }

    public static zzhe zzz() {
        return zzhe.zzb;
    }
}

