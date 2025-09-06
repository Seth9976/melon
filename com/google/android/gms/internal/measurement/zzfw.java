package com.google.android.gms.internal.measurement;

public final class zzfw extends zzme implements zznm {
    private int zzb;
    private int zzd;
    private int zze;
    private static final zzfw zzf;

    static {
        zzfw zzfw0 = new zzfw();
        zzfw.zzf = zzfw0;
        zzme.zzcp(zzfw.class, zzfw0);
    }

    public static zzfw zza() {
        return zzfw.zzf;
    }

    public final int zzb() {
        int v = zzga.zza(this.zzd);
        return v == 0 ? 1 : v;
    }

    public final int zzc() {
        int v = zzga.zza(this.zze);
        return v == 0 ? 1 : v;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzfw.zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzb", "zzd", zzfz.zza, "zze", zzfz.zza});
            }
            case 3: {
                return new zzfw();
            }
            case 4: {
                return new zzfv(null);
            }
            case 5: {
                return zzfw.zzf;
            }
            default: {
                throw null;
            }
        }
    }
}

