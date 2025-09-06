package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

final class zzh {
    private Long zzA;
    private long zzB;
    private String zzC;
    private int zzD;
    private int zzE;
    private long zzF;
    private String zzG;
    private byte[] zzH;
    private int zzI;
    private long zzJ;
    private long zzK;
    private long zzL;
    private long zzM;
    private long zzN;
    private long zzO;
    private String zzP;
    private boolean zzQ;
    private long zzR;
    private long zzS;
    private final zzib zza;
    private final String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private String zzj;
    private long zzk;
    private String zzl;
    private long zzm;
    private long zzn;
    private boolean zzo;
    private boolean zzp;
    private Boolean zzq;
    private long zzr;
    private List zzs;
    private String zzt;
    private boolean zzu;
    private long zzv;
    private long zzw;
    private int zzx;
    private boolean zzy;
    private Long zzz;

    public zzh(zzib zzib0, String s) {
        Preconditions.checkNotNull(zzib0);
        Preconditions.checkNotEmpty(s);
        this.zza = zzib0;
        this.zzb = s;
        zzib0.zzaW().zzg();
    }

    public final void zzA(long v) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzn != v;
        this.zzn = v;
    }

    public final long zzB() {
        this.zza.zzaW().zzg();
        return this.zzr;
    }

    public final void zzC(long v) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzr != v;
        this.zzr = v;
    }

    public final boolean zzD() {
        this.zza.zzaW().zzg();
        return this.zzo;
    }

    public final void zzE(boolean z) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzo != z;
        this.zzo = z;
    }

    public final void zzF(long v) {
        boolean z = false;
        Preconditions.checkArgument(Long.compare(v, 0L) >= 0);
        this.zza.zzaW().zzg();
        boolean z1 = this.zzQ;
        if(this.zzg != v) {
            z = true;
        }
        this.zzQ = z1 | z;
        this.zzg = v;
    }

    public final long zzG() {
        this.zza.zzaW().zzg();
        return this.zzg;
    }

    public final long zzH() {
        this.zza.zzaW().zzg();
        return this.zzR;
    }

    public final void zzI(long v) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzR != v;
        this.zzR = v;
    }

    public final long zzJ() {
        this.zza.zzaW().zzg();
        return this.zzS;
    }

    public final void zzK(long v) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzS != v;
        this.zzS = v;
    }

    public final void zzL() {
        zzib zzib0 = this.zza;
        zzib0.zzaW().zzg();
        long v = this.zzg + 1L;
        if(v > 0x7FFFFFFFL) {
            zzib0.zzaV().zze().zzb("Bundle index overflow. appId", zzgt.zzl(this.zzb));
            v = 0L;
        }
        this.zzQ = true;
        this.zzg = v;
    }

    public final void zzM(long v) {
        zzib zzib0 = this.zza;
        zzib0.zzaW().zzg();
        long v1 = this.zzg + v;
        if(v1 > 0x7FFFFFFFL) {
            zzib0.zzaV().zze().zzb("Bundle index overflow. appId", zzgt.zzl(this.zzb));
            v1 = v - 1L;
        }
        long v2 = this.zzF + 1L;
        if(v2 > 0x7FFFFFFFL) {
            zzib0.zzaV().zze().zzb("Delivery index overflow. appId", zzgt.zzl(this.zzb));
            v2 = 0L;
        }
        this.zzQ = true;
        this.zzg = v1;
        this.zzF = v2;
    }

    public final long zzN() {
        this.zza.zzaW().zzg();
        return this.zzJ;
    }

    public final void zzO(long v) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzJ != v;
        this.zzJ = v;
    }

    public final long zzP() {
        this.zza.zzaW().zzg();
        return this.zzK;
    }

    public final void zzQ(long v) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzK != v;
        this.zzK = v;
    }

    public final long zzR() {
        this.zza.zzaW().zzg();
        return this.zzL;
    }

    public final void zzS(long v) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzL != v;
        this.zzL = v;
    }

    public final long zzT() {
        this.zza.zzaW().zzg();
        return this.zzM;
    }

    public final void zzU(long v) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzM != v;
        this.zzM = v;
    }

    public final long zzV() {
        this.zza.zzaW().zzg();
        return this.zzO;
    }

    public final void zzW(long v) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzO != v;
        this.zzO = v;
    }

    public final long zzX() {
        this.zza.zzaW().zzg();
        return this.zzN;
    }

    public final void zzY(long v) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzN != v;
        this.zzN = v;
    }

    public final String zzZ() {
        this.zza.zzaW().zzg();
        return this.zzP;
    }

    public final boolean zza() {
        this.zza.zzaW().zzg();
        return this.zzQ;
    }

    public final int zzaA() {
        this.zza.zzaW().zzg();
        return this.zzD;
    }

    public final void zzaB(int v) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzD != v;
        this.zzD = v;
    }

    public final int zzaC() {
        this.zza.zzaW().zzg();
        return this.zzE;
    }

    public final void zzaD(int v) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzE != v;
        this.zzE = v;
    }

    public final void zzaE(long v) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzF != v;
        this.zzF = v;
    }

    public final long zzaF() {
        this.zza.zzaW().zzg();
        return this.zzF;
    }

    public final void zzaG(String s) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzG != s;
        this.zzG = s;
    }

    public final String zzaH() {
        this.zza.zzaW().zzg();
        return this.zzG;
    }

    public final void zzaI(byte[] arr_b) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzH != arr_b;
        this.zzH = arr_b;
    }

    public final byte[] zzaJ() {
        this.zza.zzaW().zzg();
        return this.zzH;
    }

    public final void zzaK(int v) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzI != v;
        this.zzI = v;
    }

    public final int zzaL() {
        this.zza.zzaW().zzg();
        return this.zzI;
    }

    public final String zzaa() {
        this.zza.zzaW().zzg();
        String s = this.zzP;
        this.zzab(null);
        return s;
    }

    public final void zzab(String s) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zzP, s);
        this.zzP = s;
    }

    public final boolean zzac() {
        this.zza.zzaW().zzg();
        return this.zzp;
    }

    public final void zzad(boolean z) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzp != z;
        this.zzp = z;
    }

    public final Boolean zzae() {
        this.zza.zzaW().zzg();
        return this.zzq;
    }

    public final void zzaf(Boolean boolean0) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zzq, boolean0);
        this.zzq = boolean0;
    }

    public final List zzag() {
        this.zza.zzaW().zzg();
        return this.zzs;
    }

    public final void zzah(List list0) {
        this.zza.zzaW().zzg();
        if(!Objects.equals(this.zzs, list0)) {
            this.zzQ = true;
            this.zzs = list0 == null ? null : new ArrayList(list0);
        }
    }

    public final boolean zzai() {
        this.zza.zzaW().zzg();
        return this.zzu;
    }

    public final void zzaj(boolean z) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzu != z;
        this.zzu = z;
    }

    public final long zzak() {
        this.zza.zzaW().zzg();
        return this.zzv;
    }

    public final void zzal(long v) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzv != v;
        this.zzv = v;
    }

    public final long zzam() {
        this.zza.zzaW().zzg();
        return this.zzw;
    }

    public final void zzan(long v) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzw != v;
        this.zzw = v;
    }

    public final int zzao() {
        this.zza.zzaW().zzg();
        return this.zzx;
    }

    public final void zzap(int v) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzx != v;
        this.zzx = v;
    }

    public final boolean zzaq() {
        this.zza.zzaW().zzg();
        return this.zzy;
    }

    public final void zzar(boolean z) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzy != z;
        this.zzy = z;
    }

    public final Long zzas() {
        this.zza.zzaW().zzg();
        return this.zzz;
    }

    public final void zzat(Long long0) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zzz, long0);
        this.zzz = long0;
    }

    public final Long zzau() {
        this.zza.zzaW().zzg();
        return this.zzA;
    }

    public final void zzav(Long long0) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zzA, long0);
        this.zzA = long0;
    }

    public final long zzaw() {
        this.zza.zzaW().zzg();
        return this.zzB;
    }

    public final void zzax(long v) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzB != v;
        this.zzB = v;
    }

    public final String zzay() {
        this.zza.zzaW().zzg();
        return this.zzC;
    }

    public final void zzaz(String s) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzC != s;
        this.zzC = s;
    }

    public final void zzb() {
        this.zza.zzaW().zzg();
        this.zzQ = false;
    }

    public final String zzc() {
        this.zza.zzaW().zzg();
        return this.zzb;
    }

    public final String zzd() {
        this.zza.zzaW().zzg();
        return this.zzc;
    }

    public final void zze(String s) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zzc, s);
        this.zzc = s;
    }

    public final String zzf() {
        this.zza.zzaW().zzg();
        return this.zzd;
    }

    public final void zzg(String s) {
        this.zza.zzaW().zzg();
        if(TextUtils.isEmpty(s)) {
            s = null;
        }
        this.zzQ |= true ^ Objects.equals(this.zzd, s);
        this.zzd = s;
    }

    public final String zzh() {
        this.zza.zzaW().zzg();
        return this.zzt;
    }

    public final void zzi(String s) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zzt, s);
        this.zzt = s;
    }

    public final String zzj() {
        this.zza.zzaW().zzg();
        return this.zze;
    }

    public final void zzk(String s) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zze, s);
        this.zze = s;
    }

    public final String zzl() {
        this.zza.zzaW().zzg();
        return this.zzf;
    }

    public final void zzm(String s) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zzf, s);
        this.zzf = s;
    }

    public final long zzn() {
        this.zza.zzaW().zzg();
        return this.zzh;
    }

    public final void zzo(long v) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzh != v;
        this.zzh = v;
    }

    public final long zzp() {
        this.zza.zzaW().zzg();
        return this.zzi;
    }

    public final void zzq(long v) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzi != v;
        this.zzi = v;
    }

    public final String zzr() {
        this.zza.zzaW().zzg();
        return this.zzj;
    }

    public final void zzs(String s) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zzj, s);
        this.zzj = s;
    }

    public final long zzt() {
        this.zza.zzaW().zzg();
        return this.zzk;
    }

    public final void zzu(long v) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzk != v;
        this.zzk = v;
    }

    public final String zzv() {
        this.zza.zzaW().zzg();
        return this.zzl;
    }

    public final void zzw(String s) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zzl, s);
        this.zzl = s;
    }

    public final long zzx() {
        this.zza.zzaW().zzg();
        return this.zzm;
    }

    public final void zzy(long v) {
        this.zza.zzaW().zzg();
        this.zzQ |= this.zzm != v;
        this.zzm = v;
    }

    public final long zzz() {
        this.zza.zzaW().zzg();
        return this.zzn;
    }
}

