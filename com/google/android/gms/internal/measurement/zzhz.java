package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

public final class zzhz extends zzma implements zznm {
    private zzhz() {
        throw null;
    }

    public zzhz(byte[] arr_b) {
        super(zzib.zzq());
    }

    public final List zza() {
        return Collections.unmodifiableList(((zzib)this.zza).zza());
    }

    public final int zzb() {
        return ((zzib)this.zza).zzb();
    }

    public final zzid zzc(int v) {
        return ((zzib)this.zza).zzc(v);
    }

    public final zzhz zzd(int v, zzic zzic0) {
        this.zzaX();
        ((zzib)this.zza).zzj(v, ((zzid)zzic0.zzbc()));
        return this;
    }

    public final zzhz zze(zzic zzic0) {
        this.zzaX();
        ((zzib)this.zza).zzk(((zzid)zzic0.zzbc()));
        return this;
    }

    public final zzhz zzf(Iterable iterable0) {
        this.zzaX();
        ((zzib)this.zza).zzm(iterable0);
        return this;
    }

    public final zzhz zzg() {
        this.zzaX();
        ((zzib)this.zza).zzn();
        return this;
    }

    // 去混淆评级： 低(20)
    public final String zzh() {
        return "";
    }

    public final zzhz zzi(String s) {
        this.zzaX();
        ((zzib)this.zza).zzo(s);
        return this;
    }

    public final zzhz zzj(String s) {
        this.zzaX();
        ((zzib)this.zza).zzp(s);
        return this;
    }
}

