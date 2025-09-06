package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzib extends zzme implements zznm {
    private int zzb;
    private zzmn zzd;
    private String zze;
    private String zzf;
    private int zzg;
    private static final zzib zzh;

    static {
        zzib zzib0 = new zzib();
        zzib.zzh = zzib0;
        zzme.zzcp(zzib.class, zzib0);
    }

    private zzib() {
        this.zzd = zzme.zzcv();
        this.zze = "";
        this.zzf = "";
    }

    public final List zza() {
        return this.zzd;
    }

    public final int zzb() {
        return this.zzd.size();
    }

    public final zzid zzc(int v) {
        return (zzid)this.zzd.get(v);
    }

    public final boolean zzd() {
        return (this.zzb & 1) != 0;
    }

    public final String zze() [...] // 潜在的解密器

    public final boolean zzf() {
        return (this.zzb & 2) != 0;
    }

    public final String zzg() [...] // 潜在的解密器

    public static zzhz zzh() {
        return (zzhz)zzib.zzh.zzck();
    }

    public static zzhz zzi(zzib zzib0) {
        zzma zzma0 = zzib.zzh.zzck();
        zzma0.zzbd(zzib0);
        return (zzhz)zzma0;
    }

    public final void zzj(int v, zzid zzid0) {
        zzid0.getClass();
        this.zzr();
        this.zzd.set(v, zzid0);
    }

    public final void zzk(zzid zzid0) {
        zzid0.getClass();
        this.zzr();
        this.zzd.add(zzid0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzib.zzh, "\u0004\u0004\u0000\u0001\u0001\t\u0004\u0000\u0001\u0000\u0001\u001B\u0007ဈ\u0000\bဈ\u0001\t᠌\u0002", new Object[]{"zzb", "zzd", zzid.class, "zze", "zzf", "zzg", zzia.zza});
            }
            case 3: {
                return new zzib();
            }
            case 4: {
                return new zzhz(null);
            }
            case 5: {
                return zzib.zzh;
            }
            default: {
                throw null;
            }
        }
    }

    public final void zzm(Iterable iterable0) {
        this.zzr();
        zzkr.zzce(iterable0, this.zzd);
    }

    public final void zzn() {
        this.zzd = zzme.zzcv();
    }

    public final void zzo(String s) {
        s.getClass();
        this.zzb |= 1;
        this.zze = s;
    }

    public final void zzp(String s) {
        s.getClass();
        this.zzb |= 2;
        this.zzf = s;
    }

    public static zzib zzq() {
        return zzib.zzh;
    }

    private final void zzr() {
        zzmn zzmn0 = this.zzd;
        if(!zzmn0.zza()) {
            this.zzd = zzme.zzcw(zzmn0);
        }
    }
}

