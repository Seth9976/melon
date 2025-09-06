package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzid extends zzme implements zznm {
    private int zzA;
    private String zzB;
    private String zzC;
    private boolean zzD;
    private zzmn zzE;
    private String zzF;
    private int zzG;
    private int zzH;
    private int zzI;
    private String zzJ;
    private long zzK;
    private long zzL;
    private String zzM;
    private String zzN;
    private int zzO;
    private String zzP;
    private zzig zzQ;
    private zzml zzR;
    private long zzS;
    private long zzT;
    private String zzU;
    private String zzV;
    private int zzW;
    private boolean zzX;
    private String zzY;
    private boolean zzZ;
    private zzhy zzaa;
    private String zzab;
    private zzmn zzac;
    private String zzad;
    private long zzae;
    private boolean zzaf;
    private String zzag;
    private boolean zzah;
    private String zzai;
    private int zzaj;
    private String zzak;
    private zzhe zzal;
    private int zzam;
    private zzha zzan;
    private String zzao;
    private zzis zzap;
    private long zzaq;
    private String zzar;
    private zzho zzas;
    private static final zzid zzat;
    private int zzb;
    private int zzd;
    private int zze;
    private zzmn zzf;
    private zzmn zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private String zzm;
    private String zzn;
    private String zzo;
    private String zzp;
    private int zzq;
    private String zzr;
    private String zzs;
    private String zzt;
    private long zzu;
    private long zzv;
    private String zzw;
    private boolean zzx;
    private String zzy;
    private long zzz;

    static {
        zzid zzid0 = new zzid();
        zzid.zzat = zzid0;
        zzme.zzcp(zzid.class, zzid0);
    }

    private zzid() {
        this.zzf = zzme.zzcv();
        this.zzg = zzme.zzcv();
        this.zzm = "";
        this.zzn = "";
        this.zzo = "";
        this.zzp = "";
        this.zzr = "";
        this.zzs = "";
        this.zzt = "";
        this.zzw = "";
        this.zzy = "";
        this.zzB = "";
        this.zzC = "";
        this.zzE = zzme.zzcv();
        this.zzF = "";
        this.zzJ = "";
        this.zzM = "";
        this.zzN = "";
        this.zzP = "";
        this.zzR = zzme.zzcs();
        this.zzU = "";
        this.zzV = "";
        this.zzY = "";
        this.zzab = "";
        this.zzac = zzme.zzcv();
        this.zzad = "";
        this.zzag = "";
        this.zzai = "";
        this.zzak = "";
        this.zzao = "";
        this.zzar = "";
    }

    public final String zzA() [...] // 潜在的解密器

    public final String zzB() [...] // 潜在的解密器

    public final boolean zzC() {
        return (this.zzb & 0x4000) != 0;
    }

    public final long zzD() {
        return this.zzu;
    }

    public final boolean zzE() {
        return (this.zzb & 0x8000) != 0;
    }

    public final long zzF() {
        return this.zzv;
    }

    public final String zzG() [...] // 潜在的解密器

    public final boolean zzH() {
        return (this.zzb & 0x20000) != 0;
    }

    public final boolean zzI() {
        return this.zzx;
    }

    public final String zzJ() [...] // 潜在的解密器

    public final boolean zzK() {
        return (this.zzb & 0x80000) != 0;
    }

    public final long zzL() {
        return this.zzz;
    }

    public final boolean zzM() {
        return (this.zzb & 0x100000) != 0;
    }

    public final int zzN() {
        return this.zzA;
    }

    public final String zzO() [...] // 潜在的解密器

    public final String zzP() [...] // 潜在的解密器

    public final boolean zzQ() {
        return (this.zzb & 0x800000) != 0;
    }

    public final boolean zzR() {
        return this.zzD;
    }

    public final List zzS() {
        return this.zzE;
    }

    public final String zzT() [...] // 潜在的解密器

    public final boolean zzU() {
        return (this.zzb & 0x2000000) != 0;
    }

    public final int zzV() {
        return this.zzG;
    }

    public final boolean zzW() {
        return (this.zzb & 0x20000000) != 0;
    }

    public final long zzX() {
        return this.zzK;
    }

    public final boolean zzY() {
        return (this.zzb & 0x80000000) != 0;
    }

    public final String zzZ() [...] // 潜在的解密器

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final boolean zzaA() {
        return (this.zzd & 0x8000000) != 0;
    }

    public final long zzaB() {
        return this.zzaq;
    }

    public final boolean zzaC() {
        return (this.zzd & 0x20000000) != 0;
    }

    public final zzho zzaD() {
        return this.zzas == null ? zzho.zzc() : this.zzas;
    }

    public static zzic zzaE() {
        return (zzic)zzid.zzat.zzck();
    }

    public static zzic zzaF(zzid zzid0) {
        zzma zzma0 = zzid.zzat.zzck();
        zzma0.zzbd(zzid0);
        return (zzic)zzma0;
    }

    public final void zzaG(int v) {
        this.zzb |= 1;
        this.zze = 1;
    }

    public final void zzaH(int v, zzhs zzhs0) {
        zzhs0.getClass();
        this.zzcy();
        this.zzf.set(v, zzhs0);
    }

    public final void zzaI(zzhs zzhs0) {
        zzhs0.getClass();
        this.zzcy();
        this.zzf.add(zzhs0);
    }

    public final void zzaJ(Iterable iterable0) {
        this.zzcy();
        zzkr.zzce(iterable0, this.zzf);
    }

    public final void zzaK() {
        this.zzf = zzme.zzcv();
    }

    public final void zzaL(int v) {
        this.zzcy();
        this.zzf.remove(v);
    }

    public final void zzaM(int v, zziu zziu0) {
        zziu0.getClass();
        this.zzcz();
        this.zzg.set(v, zziu0);
    }

    public final void zzaN(zziu zziu0) {
        zziu0.getClass();
        this.zzcz();
        this.zzg.add(zziu0);
    }

    public final void zzaO(Iterable iterable0) {
        this.zzcz();
        zzkr.zzce(iterable0, this.zzg);
    }

    public final void zzaP(int v) {
        this.zzcz();
        this.zzg.remove(v);
    }

    public final void zzaQ(long v) {
        this.zzb |= 2;
        this.zzh = v;
    }

    public final void zzaR() {
        this.zzb &= -3;
        this.zzh = 0L;
    }

    public final void zzaS(long v) {
        this.zzb |= 4;
        this.zzi = v;
    }

    public final void zzaT(long v) {
        this.zzb |= 8;
        this.zzj = v;
    }

    public final void zzaU(long v) {
        this.zzb |= 16;
        this.zzk = v;
    }

    public final void zzaV() {
        this.zzb &= -17;
        this.zzk = 0L;
    }

    public final void zzaW(long v) {
        this.zzb |= 0x20;
        this.zzl = v;
    }

    public final void zzaX() {
        this.zzb &= -33;
        this.zzl = 0L;
    }

    public final void zzaY(String s) {
        this.zzb |= 0x40;
        this.zzm = "android";
    }

    public final void zzaZ(String s) {
        s.getClass();
        this.zzb |= 0x80;
        this.zzn = s;
    }

    public final boolean zzaa() {
        return (this.zzd & 2) != 0;
    }

    public final int zzab() {
        return this.zzO;
    }

    public final boolean zzac() {
        return (this.zzd & 16) != 0;
    }

    public final long zzad() {
        return this.zzS;
    }

    public final boolean zzae() {
        return (this.zzd & 0x80) != 0;
    }

    public final String zzaf() [...] // 潜在的解密器

    public final boolean zzag() {
        return (this.zzd & 0x2000) != 0;
    }

    public final String zzah() [...] // 潜在的解密器

    public final boolean zzai() {
        return (this.zzd & 0x8000) != 0;
    }

    public final long zzaj() {
        return this.zzae;
    }

    public final boolean zzak() {
        return this.zzaf;
    }

    public final boolean zzal() {
        return (this.zzd & 0x20000) != 0;
    }

    public final String zzam() [...] // 潜在的解密器

    public final boolean zzan() {
        return (this.zzd & 0x40000) != 0;
    }

    public final boolean zzao() {
        return this.zzah;
    }

    public final boolean zzap() {
        return (this.zzd & 0x80000) != 0;
    }

    public final String zzaq() [...] // 潜在的解密器

    public final int zzar() {
        return this.zzaj;
    }

    public final boolean zzas() {
        return (this.zzd & 0x400000) != 0;
    }

    public final zzhe zzat() {
        return this.zzal == null ? zzhe.zzi() : this.zzal;
    }

    public final boolean zzau() {
        return (this.zzd & 0x800000) != 0;
    }

    public final int zzav() {
        return this.zzam;
    }

    public final boolean zzaw() {
        return (this.zzd & 0x1000000) != 0;
    }

    public final zzha zzax() {
        return this.zzan == null ? zzha.zzs() : this.zzan;
    }

    public final boolean zzay() {
        return (this.zzd & 0x4000000) != 0;
    }

    public final zzis zzaz() {
        return this.zzap == null ? zzis.zzc() : this.zzap;
    }

    public final int zzb() {
        return this.zze;
    }

    public final void zzbA(long v) {
        this.zzb |= 0x20000000;
        this.zzK = v;
    }

    public final void zzbB(String s) {
        s.getClass();
        this.zzb |= 0x80000000;
        this.zzM = s;
    }

    public final void zzbC() {
        this.zzb &= 0x7FFFFFFF;
        this.zzM = "";
    }

    public final void zzbD(int v) {
        this.zzd |= 2;
        this.zzO = v;
    }

    public final void zzbE(zzig zzig0) {
        zzig0.getClass();
        this.zzQ = zzig0;
        this.zzd |= 8;
    }

    public final void zzbF(Iterable iterable0) {
        zzml zzml0 = this.zzR;
        if(!zzml0.zza()) {
            int v = zzml0.size();
            this.zzR = zzml0.zze(v + v);
        }
        zzkr.zzce(iterable0, this.zzR);
    }

    public final void zzbG(long v) {
        this.zzd |= 16;
        this.zzS = v;
    }

    public final void zzbH(long v) {
        this.zzd |= 0x20;
        this.zzT = v;
    }

    public final void zzbI(String s) {
        this.zzd |= 0x80;
        this.zzV = s;
    }

    public final void zzbJ(String s) {
        s.getClass();
        this.zzd |= 0x2000;
        this.zzab = s;
    }

    public final void zzbK() {
        this.zzd &= 0xFFFFDFFF;
        this.zzab = "";
    }

    public final void zzbL(Iterable iterable0) {
        zzmn zzmn0 = this.zzac;
        if(!zzmn0.zza()) {
            this.zzac = zzme.zzcw(zzmn0);
        }
        zzkr.zzce(iterable0, this.zzac);
    }

    public final void zzbM(String s) {
        s.getClass();
        this.zzd |= 0x4000;
        this.zzad = s;
    }

    public final void zzbN(long v) {
        this.zzd |= 0x8000;
        this.zzae = v;
    }

    public final void zzbO(boolean z) {
        this.zzd |= 0x10000;
        this.zzaf = z;
    }

    public final void zzbP(String s) {
        this.zzd |= 0x20000;
        this.zzag = s;
    }

    public final void zzbQ(boolean z) {
        this.zzd |= 0x40000;
        this.zzah = z;
    }

    public final void zzbR(String s) {
        s.getClass();
        this.zzd |= 0x80000;
        this.zzai = s;
    }

    public final void zzbS(int v) {
        this.zzd |= 0x100000;
        this.zzaj = v;
    }

    public final void zzbT(zzhe zzhe0) {
        zzhe0.getClass();
        this.zzal = zzhe0;
        this.zzd |= 0x400000;
    }

    public final void zzbU(int v) {
        this.zzd |= 0x800000;
        this.zzam = v;
    }

    public final void zzbV(zzha zzha0) {
        zzha0.getClass();
        this.zzan = zzha0;
        this.zzd |= 0x1000000;
    }

    public final void zzbW(zzis zzis0) {
        this.zzap = zzis0;
        this.zzd |= 0x4000000;
    }

    public final void zzbX(long v) {
        this.zzd |= 0x8000000;
        this.zzaq = v;
    }

    public final void zzbY(String s) {
        this.zzd |= 0x10000000;
        this.zzar = "";
    }

    public final void zzbZ(zzho zzho0) {
        zzho0.getClass();
        this.zzas = zzho0;
        this.zzd |= 0x20000000;
    }

    public final void zzba(String s) {
        s.getClass();
        this.zzb |= 0x100;
        this.zzo = s;
    }

    public final void zzbb() {
        this.zzb &= 0xFFFFFEFF;
        this.zzo = "";
    }

    public final void zzbc(String s) {
        s.getClass();
        this.zzb |= 0x200;
        this.zzp = s;
    }

    public final void zzbd(int v) {
        this.zzb |= 0x400;
        this.zzq = v;
    }

    public final void zzbe(String s) {
        s.getClass();
        this.zzb |= 0x800;
        this.zzr = s;
    }

    public final void zzbf(String s) {
        s.getClass();
        this.zzb |= 0x1000;
        this.zzs = s;
    }

    public final void zzbg(String s) {
        s.getClass();
        this.zzb |= 0x2000;
        this.zzt = s;
    }

    public final void zzbh(long v) {
        this.zzb |= 0x4000;
        this.zzu = v;
    }

    public final void zzbi(long v) {
        this.zzb |= 0x8000;
        this.zzv = 130000L;
    }

    public final void zzbj(String s) {
        s.getClass();
        this.zzb |= 0x10000;
        this.zzw = s;
    }

    public final void zzbk() {
        this.zzb &= 0xFFFEFFFF;
        this.zzw = "";
    }

    public final void zzbl(boolean z) {
        this.zzb |= 0x20000;
        this.zzx = z;
    }

    public final void zzbm() {
        this.zzb &= 0xFFFDFFFF;
        this.zzx = false;
    }

    public final void zzbn(String s) {
        s.getClass();
        this.zzb |= 0x40000;
        this.zzy = s;
    }

    public final void zzbo() {
        this.zzb &= 0xFFFBFFFF;
        this.zzy = "";
    }

    public final void zzbp(long v) {
        this.zzb |= 0x80000;
        this.zzz = v;
    }

    public final void zzbq(int v) {
        this.zzb |= 0x100000;
        this.zzA = v;
    }

    public final void zzbr(String s) {
        this.zzb |= 0x200000;
        this.zzB = s;
    }

    public final void zzbs() {
        this.zzb &= 0xFFDFFFFF;
        this.zzB = "";
    }

    public final void zzbt(String s) {
        s.getClass();
        this.zzb |= 0x400000;
        this.zzC = s;
    }

    public final void zzbu(boolean z) {
        this.zzb |= 0x800000;
        this.zzD = z;
    }

    public final void zzbv(Iterable iterable0) {
        zzmn zzmn0 = this.zzE;
        if(!zzmn0.zza()) {
            this.zzE = zzme.zzcw(zzmn0);
        }
        zzkr.zzce(iterable0, this.zzE);
    }

    public final void zzbw() {
        this.zzE = zzme.zzcv();
    }

    public final void zzbx(String s) {
        s.getClass();
        this.zzb |= 0x1000000;
        this.zzF = s;
    }

    public final void zzby(int v) {
        this.zzb |= 0x2000000;
        this.zzG = v;
    }

    public final void zzbz() {
        this.zzb &= 0xEFFFFFFF;
        this.zzJ = "";
    }

    public final List zzc() {
        return this.zzf;
    }

    public static zzid zzca() {
        return zzid.zzat;
    }

    private final void zzcy() {
        zzmn zzmn0 = this.zzf;
        if(!zzmn0.zza()) {
            this.zzf = zzme.zzcw(zzmn0);
        }
    }

    private final void zzcz() {
        zzmn zzmn0 = this.zzg;
        if(!zzmn0.zza()) {
            this.zzg = zzme.zzcw(zzmn0);
        }
    }

    public final int zzd() {
        return this.zzf.size();
    }

    public final zzhs zze(int v) {
        return (zzhs)this.zzf.get(v);
    }

    public final List zzf() {
        return this.zzg;
    }

    public final int zzg() {
        return this.zzg.size();
    }

    public final zziu zzh(int v) {
        return (zziu)this.zzg.get(v);
    }

    public final boolean zzi() {
        return (this.zzb & 2) != 0;
    }

    public final long zzj() {
        return this.zzh;
    }

    public final boolean zzk() {
        return (this.zzb & 4) != 0;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzid.zzat, "\u0004C\u0000\u0002\u0001VC\u0000\u0005\u0000\u0001င\u0000\u0002\u001B\u0003\u001B\u0004ဂ\u0001\u0005ဂ\u0002\u0006ဂ\u0003\u0007ဂ\u0005\bဈ\u0006\tဈ\u0007\nဈ\b\u000Bဈ\t\fင\n\rဈ\u000B\u000Eဈ\f\u0010ဈ\r\u0011ဂ\u000E\u0012ဂ\u000F\u0013ဈ\u0010\u0014ဇ\u0011\u0015ဈ\u0012\u0016ဂ\u0013\u0017င\u0014\u0018ဈ\u0015\u0019ဈ\u0016\u001Aဂ\u0004\u001Cဇ\u0017\u001D\u001B\u001Eဈ\u0018\u001Fင\u0019 င\u001A!င\u001B\"ဈ\u001C#ဂ\u001D$ဂ\u001E%ဈ\u001F&ဈ \'င!)ဈ\",ဉ#-\u001D.ဂ$/ဂ%2ဈ&4ဈ\'5᠌(7ဇ)9ဈ*:ဇ+;ဉ,?ဈ-@\u001AAဈ.Cဂ/Dဇ0Gဈ1Hဇ2Iဈ3Jင4Kဈ5Lဉ6Mင7Oဉ8Pဈ9Qဉ:Rဂ;Sဈ<Vဉ=", new Object[]{"zzb", "zzd", "zze", "zzf", zzhs.class, "zzg", zziu.class, "zzh", "zzi", "zzj", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzk", "zzD", "zzE", zzhg.class, "zzF", "zzG", "zzH", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzT", "zzU", "zzV", "zzW", zzgw.zza, "zzX", "zzY", "zzZ", "zzaa", "zzab", "zzac", "zzad", "zzae", "zzaf", "zzag", "zzah", "zzai", "zzaj", "zzak", "zzal", "zzam", "zzan", "zzao", "zzap", "zzaq", "zzar", "zzas"});
            }
            case 3: {
                return new zzid();
            }
            case 4: {
                return new zzic(null);
            }
            case 5: {
                return zzid.zzat;
            }
            default: {
                throw null;
            }
        }
    }

    public final long zzm() {
        return this.zzi;
    }

    public final boolean zzn() {
        return (this.zzb & 8) != 0;
    }

    public final long zzo() {
        return this.zzj;
    }

    public final boolean zzp() {
        return (this.zzb & 16) != 0;
    }

    public final long zzq() {
        return this.zzk;
    }

    public final boolean zzr() {
        return (this.zzb & 0x20) != 0;
    }

    public final long zzs() {
        return this.zzl;
    }

    public final String zzt() [...] // 潜在的解密器

    public final String zzu() [...] // 潜在的解密器

    public final String zzv() [...] // 潜在的解密器

    public final String zzw() [...] // 潜在的解密器

    public final boolean zzx() {
        return (this.zzb & 0x400) != 0;
    }

    public final int zzy() {
        return this.zzq;
    }

    public final String zzz() [...] // 潜在的解密器
}

