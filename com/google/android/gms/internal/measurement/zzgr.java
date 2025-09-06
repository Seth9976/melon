package com.google.android.gms.internal.measurement;

public final class zzgr extends zzme implements zznm {
    private int zzb;
    private String zzd;
    private String zze;
    private static final zzgr zzf;

    static {
        zzgr zzgr0 = new zzgr();
        zzgr.zzf = zzgr0;
        zzme.zzcp(zzgr.class, zzgr0);
    }

    private zzgr() {
        this.zzd = "";
        this.zze = "";
    }

    public static zzgr zza() {
        return zzgr.zzf;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzgr.zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzb", "zzd", "zze"});
            }
            case 3: {
                return new zzgr();
            }
            case 4: {
                return new zzgq(null);
            }
            case 5: {
                return zzgr.zzf;
            }
            default: {
                throw null;
            }
        }
    }
}

