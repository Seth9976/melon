package com.google.android.gms.internal.measurement;

public final class zziu extends zzme implements zznm {
    private int zzb;
    private long zzd;
    private String zze;
    private String zzf;
    private long zzg;
    private float zzh;
    private double zzi;
    private static final zziu zzj;

    static {
        zziu zziu0 = new zziu();
        zziu.zzj = zziu0;
        zzme.zzcp(zziu.class, zziu0);
    }

    private zziu() {
        this.zze = "";
        this.zzf = "";
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final long zzb() {
        return this.zzd;
    }

    public final String zzc() [...] // 潜在的解密器

    public final boolean zzd() {
        return (this.zzb & 4) != 0;
    }

    public final String zze() [...] // 潜在的解密器

    public final boolean zzf() {
        return (this.zzb & 8) != 0;
    }

    public final long zzg() {
        return this.zzg;
    }

    public final boolean zzh() {
        return (this.zzb & 16) != 0;
    }

    public final float zzi() {
        return this.zzh;
    }

    public final boolean zzj() {
        return (this.zzb & 0x20) != 0;
    }

    public final double zzk() {
        return this.zzi;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zziu.zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
            }
            case 3: {
                return new zziu();
            }
            case 4: {
                return new zzit(null);
            }
            case 5: {
                return zziu.zzj;
            }
            default: {
                throw null;
            }
        }
    }

    public static zzit zzm() {
        return (zzit)zziu.zzj.zzck();
    }

    public final void zzn(long v) {
        this.zzb |= 1;
        this.zzd = v;
    }

    public final void zzo(String s) {
        s.getClass();
        this.zzb |= 2;
        this.zze = s;
    }

    public final void zzp(String s) {
        s.getClass();
        this.zzb |= 4;
        this.zzf = s;
    }

    public final void zzq() {
        this.zzb &= -5;
        this.zzf = "";
    }

    public final void zzr(long v) {
        this.zzb |= 8;
        this.zzg = v;
    }

    public final void zzs() {
        this.zzb &= -9;
        this.zzg = 0L;
    }

    public final void zzt(double f) {
        this.zzb |= 0x20;
        this.zzi = f;
    }

    public final void zzu() {
        this.zzb &= -33;
        this.zzi = 0.0;
    }

    public static zziu zzv() {
        return zziu.zzj;
    }
}

