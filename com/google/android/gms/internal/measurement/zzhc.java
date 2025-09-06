package com.google.android.gms.internal.measurement;

public final class zzhc extends zzme implements zznm {
    private int zzb;
    private String zzd;
    private String zze;
    private String zzf;
    private String zzg;
    private String zzh;
    private String zzi;
    private String zzj;
    private static final zzhc zzk;

    static {
        zzhc zzhc0 = new zzhc();
        zzhc.zzk = zzhc0;
        zzme.zzcp(zzhc.class, zzhc0);
    }

    private zzhc() {
        this.zzd = "";
        this.zze = "";
        this.zzf = "";
        this.zzg = "";
        this.zzh = "";
        this.zzi = "";
        this.zzj = "";
    }

    public static zzhc zza() {
        return zzhc.zzk;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzhc.zzk, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
            }
            case 3: {
                return new zzhc();
            }
            case 4: {
                return new zzhb(null);
            }
            case 5: {
                return zzhc.zzk;
            }
            default: {
                throw null;
            }
        }
    }
}

