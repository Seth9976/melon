package com.google.android.gms.internal.play_billing;

public final class zzhh extends zzcs implements zzed {
    private static final zzhh zzb;
    private int zzd;
    private zzcz zze;
    private int zzf;
    private String zzg;

    static {
        zzhh zzhh0 = new zzhh();
        zzhh.zzb = zzhh0;
        zzcs.zzt(zzhh.class, zzhh0);
    }

    private zzhh() {
        this.zze = zzcs.zzo();
        this.zzg = "";
    }

    @Override  // com.google.android.gms.internal.play_billing.zzcs
    public final Object zzx(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzcs.zzq(zzhh.zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001A\u0002င\u0000\u0003ဈ\u0001", new Object[]{"zzd", "zze", "zzf", "zzg"});
            }
            case 3: {
                return new zzhh();
            }
            case 4: {
                return new zzhg(null);
            }
            case 5: {
                return zzhh.zzb;
            }
            default: {
                return null;
            }
        }
    }

    public static zzhh zzy() {
        return zzhh.zzb;
    }
}

