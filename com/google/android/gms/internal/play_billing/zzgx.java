package com.google.android.gms.internal.play_billing;

public final class zzgx extends zzcs implements zzed {
    private static final zzgx zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    static {
        zzgx zzgx0 = new zzgx();
        zzgx.zzb = zzgx0;
        zzcs.zzt(zzgx.class, zzgx0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzcs
    public final Object zzx(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzcs.zzq(zzgx.zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
            }
            case 3: {
                return new zzgx();
            }
            case 4: {
                return new zzgw(null);
            }
            case 5: {
                return zzgx.zzb;
            }
            default: {
                return null;
            }
        }
    }

    public static zzgx zzy() {
        return zzgx.zzb;
    }
}

