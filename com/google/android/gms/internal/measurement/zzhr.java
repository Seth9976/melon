package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

public final class zzhr extends zzma implements zznm {
    private zzhr() {
        throw null;
    }

    public zzhr(byte[] arr_b) {
        super(zzhs.zzu());
    }

    public final List zza() {
        return Collections.unmodifiableList(((zzhs)this.zza).zza());
    }

    public final int zzb() {
        return ((zzhs)this.zza).zzb();
    }

    public final zzhw zzc(int v) {
        return ((zzhs)this.zza).zzc(v);
    }

    public final zzhr zzd(int v, zzhw zzhw0) {
        this.zzaX();
        ((zzhs)this.zza).zzm(v, zzhw0);
        return this;
    }

    public final zzhr zze(int v, zzhv zzhv0) {
        this.zzaX();
        ((zzhs)this.zza).zzm(v, ((zzhw)zzhv0.zzbc()));
        return this;
    }

    public final zzhr zzf(zzhw zzhw0) {
        this.zzaX();
        ((zzhs)this.zza).zzn(zzhw0);
        return this;
    }

    public final zzhr zzg(zzhv zzhv0) {
        this.zzaX();
        ((zzhs)this.zza).zzn(((zzhw)zzhv0.zzbc()));
        return this;
    }

    public final zzhr zzh(Iterable iterable0) {
        this.zzaX();
        ((zzhs)this.zza).zzo(iterable0);
        return this;
    }

    public final zzhr zzi() {
        this.zzaX();
        ((zzhs)this.zza).zzp();
        return this;
    }

    public final zzhr zzj(int v) {
        this.zzaX();
        ((zzhs)this.zza).zzq(v);
        return this;
    }

    // 去混淆评级： 低(20)
    public final String zzk() {
        return "";
    }

    public final zzhr zzl(String s) {
        this.zzaX();
        ((zzhs)this.zza).zzr(s);
        return this;
    }

    public final boolean zzm() {
        return ((zzhs)this.zza).zze();
    }

    public final long zzn() {
        return ((zzhs)this.zza).zzf();
    }

    public final zzhr zzo(long v) {
        this.zzaX();
        ((zzhs)this.zza).zzs(v);
        return this;
    }

    public final long zzp() {
        return ((zzhs)this.zza).zzh();
    }

    public final zzhr zzq(long v) {
        this.zzaX();
        ((zzhs)this.zza).zzt(v);
        return this;
    }
}

