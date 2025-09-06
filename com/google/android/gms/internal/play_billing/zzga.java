package com.google.android.gms.internal.play_billing;

public final class zzga extends zzcs implements zzed {
    private static final zzga zzb;
    private int zzd;
    private int zze;
    private Object zzf;
    private int zzg;
    private zzgk zzh;

    static {
        zzga zzga0 = new zzga();
        zzga.zzb = zzga0;
        zzcs.zzt(zzga.class, zzga0);
    }

    private zzga() {
        this.zze = 0;
    }

    public static zzga zzA(byte[] arr_b, zzcd zzcd0) {
        return (zzga)zzcs.zzm(zzga.zzb, arr_b, zzcd0);
    }

    public static void zzB(zzga zzga0, zzgk zzgk0) {
        zzgk0.getClass();
        zzga0.zzh = zzgk0;
        zzga0.zzd |= 2;
    }

    public static void zzC(zzga zzga0, zzhb zzhb0) {
        zzhb0.getClass();
        zzga0.zzf = zzhb0;
        zzga0.zze = 4;
    }

    public static void zzD(zzga zzga0, int v) {
        zzga0.zzg = v - 1;
        zzga0.zzd |= 1;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzcs
    public final Object zzx(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzcs.zzq(zzga.zzb, "\u0001\u0003\u0001\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0004<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", zzgb.zza, "zzh", zzhb.class});
            }
            case 3: {
                return new zzga();
            }
            case 4: {
                return new zzfz(null);
            }
            case 5: {
                return zzga.zzb;
            }
            default: {
                return null;
            }
        }
    }

    public static zzfz zzy() {
        return (zzfz)zzga.zzb.zzg();
    }

    public static zzga zzz() {
        return zzga.zzb;
    }
}

