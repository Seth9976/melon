package com.google.android.gms.internal.measurement;

public final class zzgh extends zzme implements zznm {
    private int zzb;
    private String zzd;
    private zzmn zze;
    private boolean zzf;
    private static final zzgh zzg;

    static {
        zzgh zzgh0 = new zzgh();
        zzgh.zzg = zzgh0;
        zzme.zzcp(zzgh.class, zzgh0);
    }

    private zzgh() {
        this.zzd = "";
        this.zze = zzme.zzcv();
    }

    public final String zza() [...] // 潜在的解密器

    public static zzgh zzb() {
        return zzgh.zzg;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzgh.zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001B\u0003ဇ\u0001", new Object[]{"zzb", "zzd", "zze", zzgr.class, "zzf"});
            }
            case 3: {
                return new zzgh();
            }
            case 4: {
                return new zzgg(null);
            }
            case 5: {
                return zzgh.zzg;
            }
            default: {
                throw null;
            }
        }
    }
}

