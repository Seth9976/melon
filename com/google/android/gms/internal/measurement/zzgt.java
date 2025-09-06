package com.google.android.gms.internal.measurement;

public final class zzgt extends zzme implements zznm {
    private int zzb;
    private String zzd;
    private String zze;
    private static final zzgt zzf;

    static {
        zzgt zzgt0 = new zzgt();
        zzgt.zzf = zzgt0;
        zzme.zzcp(zzgt.class, zzgt0);
    }

    private zzgt() {
        this.zzd = "";
        this.zze = "";
    }

    public final String zza() [...] // 潜在的解密器

    public final String zzb() [...] // 潜在的解密器

    public static zzgt zzc() {
        return zzgt.zzf;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzgt.zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzb", "zzd", "zze"});
            }
            case 3: {
                return new zzgt();
            }
            case 4: {
                return new zzgs(null);
            }
            case 5: {
                return zzgt.zzf;
            }
            default: {
                throw null;
            }
        }
    }
}

