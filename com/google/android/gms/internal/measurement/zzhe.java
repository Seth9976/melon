package com.google.android.gms.internal.measurement;

public final class zzhe extends zzme implements zznm {
    private int zzb;
    private boolean zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private static final zzhe zzk;

    static {
        zzhe zzhe0 = new zzhe();
        zzhe.zzk = zzhe0;
        zzme.zzcp(zzhe.class, zzhe0);
    }

    public final boolean zza() {
        return this.zzd;
    }

    public final boolean zzb() {
        return this.zze;
    }

    public final boolean zzc() {
        return this.zzf;
    }

    public final boolean zzd() {
        return this.zzg;
    }

    public final boolean zze() {
        return this.zzh;
    }

    public final boolean zzf() {
        return this.zzi;
    }

    public final boolean zzg() {
        return this.zzj;
    }

    public static zzhd zzh() {
        return (zzhd)zzhe.zzk.zzck();
    }

    public static zzhe zzi() {
        return zzhe.zzk;
    }

    public final void zzj(boolean z) {
        this.zzb |= 1;
        this.zzd = z;
    }

    public final void zzk(boolean z) {
        this.zzb |= 2;
        this.zze = z;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzhe.zzk, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဇ\u0006", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
            }
            case 3: {
                return new zzhe();
            }
            case 4: {
                return new zzhd(null);
            }
            case 5: {
                return zzhe.zzk;
            }
            default: {
                throw null;
            }
        }
    }

    public final void zzm(boolean z) {
        this.zzb |= 4;
        this.zzf = z;
    }

    public final void zzn(boolean z) {
        this.zzb |= 8;
        this.zzg = z;
    }

    public final void zzo(boolean z) {
        this.zzb |= 16;
        this.zzh = z;
    }

    public final void zzp(boolean z) {
        this.zzb |= 0x20;
        this.zzi = z;
    }

    public final void zzq(boolean z) {
        this.zzb |= 0x40;
        this.zzj = z;
    }

    public static zzhe zzr() {
        return zzhe.zzk;
    }
}

