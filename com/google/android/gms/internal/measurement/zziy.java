package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zziy extends zzme implements zznm {
    private int zzb;
    private String zzd;
    private zzmn zze;
    private static final zziy zzf;

    static {
        zziy zziy0 = new zziy();
        zziy.zzf = zziy0;
        zzme.zzcp(zziy.class, zziy0);
    }

    private zziy() {
        this.zzd = "";
        this.zze = zzme.zzcv();
    }

    public final String zza() [...] // 潜在的解密器

    public final List zzb() {
        return this.zze;
    }

    public static zziy zzc() {
        return zziy.zzf;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zziy.zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001B", new Object[]{"zzb", "zzd", "zze", zzje.class});
            }
            case 3: {
                return new zziy();
            }
            case 4: {
                return new zzix(null);
            }
            case 5: {
                return zziy.zzf;
            }
            default: {
                throw null;
            }
        }
    }
}

