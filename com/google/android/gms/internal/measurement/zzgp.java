package com.google.android.gms.internal.measurement;

public final class zzgp extends zzme implements zznm {
    private int zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private static final zzgp zzg;

    static {
        zzgp zzgp0 = new zzgp();
        zzgp.zzg = zzgp0;
        zzme.zzcp(zzgp.class, zzgp0);
    }

    private zzgp() {
        this.zzd = 14;
        this.zze = 11;
        this.zzf = 60;
    }

    public static zzgp zza() {
        return zzgp.zzg;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzgp.zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzb", "zzd", "zze", "zzf"});
            }
            case 3: {
                return new zzgp();
            }
            case 4: {
                return new zzgo(null);
            }
            case 5: {
                return zzgp.zzg;
            }
            default: {
                throw null;
            }
        }
    }
}

