package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzhs extends zzme implements zznm {
    private int zzb;
    private zzmn zzd;
    private String zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private static final zzhs zzi;

    static {
        zzhs zzhs0 = new zzhs();
        zzhs.zzi = zzhs0;
        zzme.zzcp(zzhs.class, zzhs0);
    }

    private zzhs() {
        this.zzd = zzme.zzcv();
        this.zze = "";
    }

    public final List zza() {
        return this.zzd;
    }

    public final int zzb() {
        return this.zzd.size();
    }

    public final zzhw zzc(int v) {
        return (zzhw)this.zzd.get(v);
    }

    public final String zzd() [...] // 潜在的解密器

    public final boolean zze() {
        return (this.zzb & 2) != 0;
    }

    public final long zzf() {
        return this.zzf;
    }

    public final boolean zzg() {
        return (this.zzb & 4) != 0;
    }

    public final long zzh() {
        return this.zzg;
    }

    public final boolean zzi() {
        return (this.zzb & 8) != 0;
    }

    public final int zzj() {
        return this.zzh;
    }

    public static zzhr zzk() {
        return (zzhr)zzhs.zzi.zzck();
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzhs.zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001B\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zzb", "zzd", zzhw.class, "zze", "zzf", "zzg", "zzh"});
            }
            case 3: {
                return new zzhs();
            }
            case 4: {
                return new zzhr(null);
            }
            case 5: {
                return zzhs.zzi;
            }
            default: {
                throw null;
            }
        }
    }

    public final void zzm(int v, zzhw zzhw0) {
        zzhw0.getClass();
        this.zzv();
        this.zzd.set(v, zzhw0);
    }

    public final void zzn(zzhw zzhw0) {
        zzhw0.getClass();
        this.zzv();
        this.zzd.add(zzhw0);
    }

    public final void zzo(Iterable iterable0) {
        this.zzv();
        zzkr.zzce(iterable0, this.zzd);
    }

    public final void zzp() {
        this.zzd = zzme.zzcv();
    }

    public final void zzq(int v) {
        this.zzv();
        this.zzd.remove(v);
    }

    public final void zzr(String s) {
        s.getClass();
        this.zzb |= 1;
        this.zze = s;
    }

    public final void zzs(long v) {
        this.zzb |= 2;
        this.zzf = v;
    }

    public final void zzt(long v) {
        this.zzb |= 4;
        this.zzg = v;
    }

    public static zzhs zzu() {
        return zzhs.zzi;
    }

    private final void zzv() {
        zzmn zzmn0 = this.zzd;
        if(!zzmn0.zza()) {
            this.zzd = zzme.zzcw(zzmn0);
        }
    }
}

