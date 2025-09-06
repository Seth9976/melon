package com.google.android.gms.internal.measurement;

import java.util.Map;

public final class zzha extends zzme implements zznm {
    private int zzb;
    private String zzd;
    private String zze;
    private String zzf;
    private long zzg;
    private String zzh;
    private String zzi;
    private String zzj;
    private long zzk;
    private zznf zzl;
    private zznf zzm;
    private static final zzha zzn;

    static {
        zzha zzha0 = new zzha();
        zzha.zzn = zzha0;
        zzme.zzcp(zzha.class, zzha0);
    }

    private zzha() {
        this.zzl = zznf.zza();
        this.zzm = zznf.zza();
        this.zzd = "";
        this.zze = "";
        this.zzf = "";
        this.zzh = "";
        this.zzi = "";
        this.zzj = "";
    }

    public final void zzA(String s) {
        this.zzb |= 16;
        this.zzh = s;
    }

    public final void zzB() {
        this.zzb &= -17;
        this.zzh = "";
    }

    public final void zzC(String s) {
        this.zzb |= 0x20;
        this.zzi = s;
    }

    public final void zzD() {
        this.zzb &= -33;
        this.zzi = "";
    }

    public final void zzE(String s) {
        this.zzb |= 0x40;
        this.zzj = s;
    }

    public final void zzF() {
        this.zzb &= -65;
        this.zzj = "";
    }

    public final void zzG(long v) {
        this.zzb |= 0x80;
        this.zzk = v;
    }

    public final Map zzH() {
        if(!this.zzl.zze()) {
            this.zzl = this.zzl.zzc();
        }
        return this.zzl;
    }

    public final Map zzI() {
        if(!this.zzm.zze()) {
            this.zzm = this.zzm.zzc();
        }
        return this.zzm;
    }

    public static zzha zzJ() {
        return zzha.zzn;
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

    public final String zzf() [...] // 潜在的解密器

    public final boolean zzg() {
        return (this.zzb & 8) != 0;
    }

    public final long zzh() {
        return this.zzg;
    }

    public final boolean zzi() {
        return (this.zzb & 16) != 0;
    }

    public final String zzj() [...] // 潜在的解密器

    public final boolean zzk() {
        return (this.zzb & 0x20) != 0;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzha.zzn, "\u0004\n\u0000\u0001\u0001\n\n\u0002\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\bဂ\u0007\t2\n2", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzgy.zza, "zzm", zzgz.zza});
            }
            case 3: {
                return new zzha();
            }
            case 4: {
                return new zzgx(null);
            }
            case 5: {
                return zzha.zzn;
            }
            default: {
                throw null;
            }
        }
    }

    public final String zzm() [...] // 潜在的解密器

    public final boolean zzn() {
        return (this.zzb & 0x40) != 0;
    }

    public final String zzo() [...] // 潜在的解密器

    public final boolean zzp() {
        return (this.zzb & 0x80) != 0;
    }

    public final long zzq() {
        return this.zzk;
    }

    public static zzgx zzr() {
        return (zzgx)zzha.zzn.zzck();
    }

    public static zzha zzs() {
        return zzha.zzn;
    }

    public final void zzt(String s) {
        this.zzb |= 1;
        this.zzd = s;
    }

    public final void zzu() {
        this.zzb &= -2;
        this.zzd = "";
    }

    public final void zzv(String s) {
        this.zzb |= 2;
        this.zze = s;
    }

    public final void zzw() {
        this.zzb &= -3;
        this.zze = "";
    }

    public final void zzx(String s) {
        this.zzb |= 4;
        this.zzf = s;
    }

    public final void zzy() {
        this.zzb &= -5;
        this.zzf = "";
    }

    public final void zzz(long v) {
        this.zzb |= 8;
        this.zzg = v;
    }
}

