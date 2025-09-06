package com.google.android.gms.internal.measurement;

public final class zzfl extends zzme implements zznm {
    private int zzb;
    private int zzd;
    private boolean zze;
    private String zzf;
    private String zzg;
    private String zzh;
    private static final zzfl zzi;

    static {
        zzfl zzfl0 = new zzfl();
        zzfl.zzi = zzfl0;
        zzme.zzcp(zzfl.class, zzfl0);
    }

    private zzfl() {
        this.zzf = "";
        this.zzg = "";
        this.zzh = "";
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final boolean zzb() {
        return (this.zzb & 2) != 0;
    }

    public final boolean zzc() {
        return this.zze;
    }

    public final boolean zzd() {
        return (this.zzb & 4) != 0;
    }

    public final String zze() [...] // 潜在的解密器

    public final boolean zzf() {
        return (this.zzb & 8) != 0;
    }

    public final String zzg() [...] // 潜在的解密器

    public final boolean zzh() {
        return (this.zzb & 16) != 0;
    }

    public final String zzi() [...] // 潜在的解密器

    public static zzfl zzj() {
        return zzfl.zzi;
    }

    public static zzfl zzk() {
        return zzfl.zzi;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzfl.zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zzb", "zzd", zzfj.zza, "zze", "zzf", "zzg", "zzh"});
            }
            case 3: {
                return new zzfl();
            }
            case 4: {
                return new zzfi(null);
            }
            case 5: {
                return zzfl.zzi;
            }
            default: {
                throw null;
            }
        }
    }

    public final int zzm() {
        int v = zzfk.zza(this.zzd);
        return v == 0 ? 1 : v;
    }
}

