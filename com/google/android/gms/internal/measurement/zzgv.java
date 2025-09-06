package com.google.android.gms.internal.measurement;

public final class zzgv extends zzme implements zznm {
    private int zzb;
    private String zzd;
    private String zze;
    private String zzf;
    private int zzg;
    private String zzh;
    private static final zzgv zzi;

    static {
        zzgv zzgv0 = new zzgv();
        zzgv.zzi = zzgv0;
        zzme.zzcp(zzgv.class, zzgv0);
    }

    private zzgv() {
        this.zzd = "";
        this.zze = "";
        this.zzf = "";
        this.zzh = "";
    }

    public final String zza() [...] // 潜在的解密器

    public final String zzb() [...] // 潜在的解密器

    public final int zzc() {
        return this.zzg;
    }

    public final String zzd() [...] // 潜在的解密器

    public static zzgv zze() {
        return zzgv.zzi;
    }

    public static zzgv zzf() {
        return zzgv.zzi;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzgv.zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003\u0005ဈ\u0004", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh"});
            }
            case 3: {
                return new zzgv();
            }
            case 4: {
                return new zzgu(null);
            }
            case 5: {
                return zzgv.zzi;
            }
            default: {
                throw null;
            }
        }
    }
}

