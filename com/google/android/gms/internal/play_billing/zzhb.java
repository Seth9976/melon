package com.google.android.gms.internal.play_billing;

public final class zzhb extends zzcs implements zzed {
    private static final zzhb zzb;
    private int zzd;
    private int zze;

    static {
        zzhb zzhb0 = new zzhb();
        zzhb.zzb = zzhb0;
        zzcs.zzt(zzhb.class, zzhb0);
    }

    public static void zzA(zzhb zzhb0, int v) {
        zzhb0.zze = v - 1;
        zzhb0.zzd |= 1;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzcs
    public final Object zzx(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzcs.zzq(zzhb.zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzha.zza});
            }
            case 3: {
                return new zzhb();
            }
            case 4: {
                return new zzgz(null);
            }
            case 5: {
                return zzhb.zzb;
            }
            default: {
                return null;
            }
        }
    }

    public static zzgz zzy() {
        return (zzgz)zzhb.zzb.zzg();
    }

    public static zzhb zzz() {
        return zzhb.zzb;
    }
}

