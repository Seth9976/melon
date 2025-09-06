package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzff extends zzme implements zznm {
    private int zzb;
    private int zzd;
    private String zze;
    private zzmn zzf;
    private boolean zzg;
    private zzfl zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private static final zzff zzl;

    static {
        zzff zzff0 = new zzff();
        zzff.zzl = zzff0;
        zzme.zzcp(zzff.class, zzff0);
    }

    private zzff() {
        this.zze = "";
        this.zzf = zzme.zzcv();
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final int zzb() {
        return this.zzd;
    }

    public final String zzc() [...] // 潜在的解密器

    public final List zzd() {
        return this.zzf;
    }

    public final int zze() {
        return this.zzf.size();
    }

    public final zzfh zzf(int v) {
        return (zzfh)this.zzf.get(v);
    }

    public final boolean zzg() {
        return (this.zzb & 8) != 0;
    }

    public final zzfl zzh() {
        return this.zzh == null ? zzfl.zzj() : this.zzh;
    }

    public final boolean zzi() {
        return this.zzi;
    }

    public final boolean zzj() {
        return this.zzj;
    }

    public final boolean zzk() {
        return (this.zzb & 0x40) != 0;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzff.zzl, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001B\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzb", "zzd", "zze", "zzf", zzfh.class, "zzg", "zzh", "zzi", "zzj", "zzk"});
            }
            case 3: {
                return new zzff();
            }
            case 4: {
                return new zzfe(null);
            }
            case 5: {
                return zzff.zzl;
            }
            default: {
                throw null;
            }
        }
    }

    public final boolean zzm() {
        return this.zzk;
    }

    public static zzfe zzn() {
        return (zzfe)zzff.zzl.zzck();
    }

    public final void zzo(String s) {
        this.zzb |= 2;
        this.zze = s;
    }

    public final void zzp(int v, zzfh zzfh0) {
        zzfh0.getClass();
        zzmn zzmn0 = this.zzf;
        if(!zzmn0.zza()) {
            this.zzf = zzme.zzcw(zzmn0);
        }
        this.zzf.set(v, zzfh0);
    }

    public static zzff zzq() {
        return zzff.zzl;
    }
}

