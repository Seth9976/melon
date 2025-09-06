package com.google.android.gms.internal.play_billing;

public final class zzgr extends zzcs implements zzed {
    private static final zzcy zzb;
    private static final zzgr zzd;
    private int zze;
    private String zzf;
    private int zzg;
    private zzcx zzh;
    private zzcz zzi;
    private zzgk zzj;
    private boolean zzk;
    private boolean zzl;

    static {
        zzgr.zzb = new zzgl();
        zzgr zzgr0 = new zzgr();
        zzgr.zzd = zzgr0;
        zzcs.zzt(zzgr.class, zzgr0);
    }

    private zzgr() {
        this.zzf = "";
        this.zzh = zzcs.zzn();
        this.zzi = zzcs.zzo();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzcs
    public final Object zzx(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzcs.zzq(zzgr.zzd, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ࠬ\u0004\u001B\u0005ဉ\u0002\u0006ဇ\u0003\u0007ဇ\u0004", new Object[]{"zze", "zzf", "zzg", zzgq.zza, "zzh", zzgn.zza, "zzi", zzhh.class, "zzj", "zzk", "zzl"});
            }
            case 3: {
                return new zzgr();
            }
            case 4: {
                return new zzgp(null);
            }
            case 5: {
                return zzgr.zzd;
            }
            default: {
                return null;
            }
        }
    }

    public static zzgr zzy() {
        return zzgr.zzd;
    }
}

