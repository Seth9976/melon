package com.google.android.gms.internal.measurement;

public final class zzhy extends zzme implements zznm {
    private int zzb;
    private String zzd;
    private String zze;
    private zzhc zzf;
    private static final zzhy zzg;

    static {
        zzhy zzhy0 = new zzhy();
        zzhy.zzg = zzhy0;
        zzme.zzcp(zzhy.class, zzhy0);
    }

    private zzhy() {
        this.zzd = "";
        this.zze = "";
    }

    public static zzhy zza() {
        return zzhy.zzg;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzhy.zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", new Object[]{"zzb", "zzd", "zze", "zzf"});
            }
            case 3: {
                return new zzhy();
            }
            case 4: {
                return new zzhx(null);
            }
            case 5: {
                return zzhy.zzg;
            }
            default: {
                throw null;
            }
        }
    }
}

