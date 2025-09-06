package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzgl extends zzme implements zznm {
    private int zzb;
    private long zzd;
    private String zze;
    private int zzf;
    private zzmn zzg;
    private zzmn zzh;
    private zzmn zzi;
    private String zzj;
    private boolean zzk;
    private zzmn zzl;
    private zzmn zzm;
    private String zzn;
    private String zzo;
    private zzgf zzp;
    private zzgp zzq;
    private zzgv zzr;
    private zzgr zzs;
    private zzgn zzt;
    private static final zzgl zzu;

    static {
        zzgl zzgl0 = new zzgl();
        zzgl.zzu = zzgl0;
        zzme.zzcp(zzgl.class, zzgl0);
    }

    private zzgl() {
        this.zze = "";
        this.zzg = zzme.zzcv();
        this.zzh = zzme.zzcv();
        this.zzi = zzme.zzcv();
        this.zzj = "";
        this.zzl = zzme.zzcv();
        this.zzm = zzme.zzcv();
        this.zzn = "";
        this.zzo = "";
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final long zzb() {
        return this.zzd;
    }

    public final boolean zzc() {
        return (this.zzb & 2) != 0;
    }

    public final String zzd() [...] // 潜在的解密器

    public final List zze() {
        return this.zzg;
    }

    public final int zzf() {
        return this.zzh.size();
    }

    public final zzgj zzg(int v) {
        return (zzgj)this.zzh.get(v);
    }

    public final List zzh() {
        return this.zzi;
    }

    public final List zzi() {
        return this.zzl;
    }

    public final int zzj() {
        return this.zzl.size();
    }

    public final List zzk() {
        return this.zzm;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzgl.zzu, "\u0004\u0011\u0000\u0001\u0001\u0013\u0011\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001B\u0005\u001B\u0006\u001B\u0007ဈ\u0003\bဇ\u0004\t\u001B\n\u001B\u000Bဈ\u0005\u000Eဈ\u0006\u000Fဉ\u0007\u0010ဉ\b\u0011ဉ\t\u0012ဉ\n\u0013ဉ\u000B", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", zzgt.class, "zzh", zzgj.class, "zzi", zzfd.class, "zzj", "zzk", "zzl", zzja.class, "zzm", zzgh.class, "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt"});
            }
            case 3: {
                return new zzgl();
            }
            case 4: {
                return new zzgk(null);
            }
            case 5: {
                return zzgl.zzu;
            }
            default: {
                throw null;
            }
        }
    }

    public final String zzm() [...] // 潜在的解密器

    public final boolean zzn() {
        return (this.zzb & 0x80) != 0;
    }

    public final zzgf zzo() {
        return this.zzp == null ? zzgf.zzg() : this.zzp;
    }

    public final boolean zzp() {
        return (this.zzb & 0x200) != 0;
    }

    public final zzgv zzq() {
        return this.zzr == null ? zzgv.zze() : this.zzr;
    }

    public static zzgk zzr() {
        return (zzgk)zzgl.zzu.zzck();
    }

    public static zzgl zzs() {
        return zzgl.zzu;
    }

    public final void zzt(int v, zzgj zzgj0) {
        zzgj0.getClass();
        zzmn zzmn0 = this.zzh;
        if(!zzmn0.zza()) {
            this.zzh = zzme.zzcw(zzmn0);
        }
        this.zzh.set(v, zzgj0);
    }

    public final void zzu() {
        this.zzi = zzme.zzcv();
    }

    public final void zzv() {
        this.zzl = zzme.zzcv();
    }

    public static zzgl zzw() {
        return zzgl.zzu;
    }
}

