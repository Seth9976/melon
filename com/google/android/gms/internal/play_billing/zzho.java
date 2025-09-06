package com.google.android.gms.internal.play_billing;

public final class zzho extends zzcs implements zzed {
    private static final zzho zzb;
    private int zzd;
    private int zze;

    static {
        zzho zzho0 = new zzho();
        zzho.zzb = zzho0;
        zzcs.zzt(zzho.class, zzho0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzcs
    public final Object zzx(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzcs.zzq(zzho.zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zzd", "zze"});
            }
            case 3: {
                return new zzho();
            }
            case 4: {
                return new zzhn(null);
            }
            case 5: {
                return zzho.zzb;
            }
            default: {
                return null;
            }
        }
    }

    public static zzho zzy() {
        return zzho.zzb;
    }
}

