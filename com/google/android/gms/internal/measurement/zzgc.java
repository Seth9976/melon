package com.google.android.gms.internal.measurement;

public final class zzgc extends zzme implements zznm {
    private int zzb;
    private String zzd;
    private String zze;
    private static final zzgc zzf;

    static {
        zzgc zzgc0 = new zzgc();
        zzgc.zzf = zzgc0;
        zzme.zzcp(zzgc.class, zzgc0);
    }

    private zzgc() {
        this.zzd = "";
        this.zze = "";
    }

    public final String zza() [...] // 潜在的解密器

    public static zzgc zzb() {
        return zzgc.zzf;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzgc.zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzb", "zzd", "zze"});
            }
            case 3: {
                return new zzgc();
            }
            case 4: {
                return new zzgb(null);
            }
            case 5: {
                return zzgc.zzf;
            }
            default: {
                throw null;
            }
        }
    }
}

