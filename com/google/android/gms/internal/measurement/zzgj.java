package com.google.android.gms.internal.measurement;

public final class zzgj extends zzme implements zznm {
    private int zzb;
    private String zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;
    private static final zzgj zzh;

    static {
        zzgj zzgj0 = new zzgj();
        zzgj.zzh = zzgj0;
        zzme.zzcp(zzgj.class, zzgj0);
    }

    private zzgj() {
        this.zzd = "";
    }

    public final String zza() [...] // 潜在的解密器

    public final boolean zzb() {
        return (this.zzb & 2) != 0;
    }

    public final boolean zzc() {
        return this.zze;
    }

    public final boolean zzd() {
        return (this.zzb & 4) != 0;
    }

    public final boolean zze() {
        return this.zzf;
    }

    public final boolean zzf() {
        return (this.zzb & 8) != 0;
    }

    public final int zzg() {
        return this.zzg;
    }

    public final void zzh(String s) {
        s.getClass();
        this.zzb |= 1;
        this.zzd = s;
    }

    public static zzgj zzi() {
        return zzgj.zzh;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzgj.zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg"});
            }
            case 3: {
                return new zzgj();
            }
            case 4: {
                return new zzgi(null);
            }
            case 5: {
                return zzgj.zzh;
            }
            default: {
                throw null;
            }
        }
    }
}

