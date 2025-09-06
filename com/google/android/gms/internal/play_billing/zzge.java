package com.google.android.gms.internal.play_billing;

public final class zzge extends zzcs implements zzed {
    private static final zzge zzb;
    private int zzd;
    private int zze;
    private Object zzf;
    private int zzg;

    static {
        zzge zzge0 = new zzge();
        zzge.zzb = zzge0;
        zzcs.zzt(zzge.class, zzge0);
    }

    private zzge() {
        this.zze = 0;
    }

    public static void zzA(zzge zzge0, zzhb zzhb0) {
        zzhb0.getClass();
        zzge0.zzf = zzhb0;
        zzge0.zze = 2;
    }

    public static void zzB(zzge zzge0, int v) {
        zzge0.zzg = v - 1;
        zzge0.zzd |= 1;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzcs
    public final Object zzx(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzcs.zzq(zzge.zzb, "\u0001\u0003\u0001\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", zzgb.zza, zzhb.class, zzho.class});
            }
            case 3: {
                return new zzge();
            }
            case 4: {
                return new zzgd(null);
            }
            case 5: {
                return zzge.zzb;
            }
            default: {
                return null;
            }
        }
    }

    public static zzgd zzy() {
        return (zzgd)zzge.zzb.zzg();
    }

    public static zzge zzz() {
        return zzge.zzb;
    }
}

