package com.google.android.gms.internal.measurement;

public final class zzig extends zzme implements zznm {
    private int zzb;
    private int zzd;
    private zzmn zze;
    private static final zzig zzf;

    static {
        zzig zzig0 = new zzig();
        zzig.zzf = zzig0;
        zzme.zzcp(zzig.class, zzig0);
    }

    private zzig() {
        this.zzd = 1;
        this.zze = zzme.zzcv();
    }

    public static zzie zza() {
        return (zzie)zzig.zzf.zzck();
    }

    public final void zzb(zzhu zzhu0) {
        zzhu0.getClass();
        zzmn zzmn0 = this.zze;
        if(!zzmn0.zza()) {
            this.zze = zzme.zzcw(zzmn0);
        }
        this.zze.add(zzhu0);
    }

    public static zzig zzc() {
        return zzig.zzf;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzig.zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001B", new Object[]{"zzb", "zzd", zzif.zza, "zze", zzhu.class});
            }
            case 3: {
                return new zzig();
            }
            case 4: {
                return new zzie(null);
            }
            case 5: {
                return zzig.zzf;
            }
            default: {
                throw null;
            }
        }
    }
}

