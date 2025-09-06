package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzhw extends zzme implements zznm {
    private int zzb;
    private String zzd;
    private String zze;
    private long zzf;
    private float zzg;
    private double zzh;
    private zzmn zzi;
    private static final zzhw zzj;

    static {
        zzhw zzhw0 = new zzhw();
        zzhw.zzj = zzhw0;
        zzme.zzcp(zzhw.class, zzhw0);
    }

    private zzhw() {
        this.zzd = "";
        this.zze = "";
        this.zzi = zzme.zzcv();
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final String zzb() [...] // 潜在的解密器

    public final boolean zzc() {
        return (this.zzb & 2) != 0;
    }

    public final String zzd() [...] // 潜在的解密器

    public final boolean zze() {
        return (this.zzb & 4) != 0;
    }

    public final long zzf() {
        return this.zzf;
    }

    public final boolean zzg() {
        return (this.zzb & 8) != 0;
    }

    public final float zzh() {
        return this.zzg;
    }

    public final boolean zzi() {
        return (this.zzb & 16) != 0;
    }

    public final double zzj() {
        return this.zzh;
    }

    public final List zzk() {
        return this.zzi;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzhw.zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001B", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", zzhw.class});
            }
            case 3: {
                return new zzhw();
            }
            case 4: {
                return new zzhv(null);
            }
            case 5: {
                return zzhw.zzj;
            }
            default: {
                throw null;
            }
        }
    }

    public final int zzm() {
        return this.zzi.size();
    }

    public static zzhv zzn() {
        return (zzhv)zzhw.zzj.zzck();
    }

    public final void zzo(String s) {
        s.getClass();
        this.zzb |= 1;
        this.zzd = s;
    }

    public final void zzp(String s) {
        s.getClass();
        this.zzb |= 2;
        this.zze = s;
    }

    public final void zzq() {
        this.zzb &= -3;
        this.zze = "";
    }

    public final void zzr(long v) {
        this.zzb |= 4;
        this.zzf = v;
    }

    public final void zzs() {
        this.zzb &= -5;
        this.zzf = 0L;
    }

    public final void zzt(double f) {
        this.zzb |= 16;
        this.zzh = f;
    }

    public final void zzu() {
        this.zzb &= -17;
        this.zzh = 0.0;
    }

    public final void zzv(zzhw zzhw0) {
        zzhw0.getClass();
        this.zzz();
        this.zzi.add(zzhw0);
    }

    public final void zzw(Iterable iterable0) {
        this.zzz();
        zzkr.zzce(iterable0, this.zzi);
    }

    public final void zzx() {
        this.zzi = zzme.zzcv();
    }

    public static zzhw zzy() {
        return zzhw.zzj;
    }

    private final void zzz() {
        zzmn zzmn0 = this.zzi;
        if(!zzmn0.zza()) {
            this.zzi = zzme.zzcw(zzmn0);
        }
    }
}

