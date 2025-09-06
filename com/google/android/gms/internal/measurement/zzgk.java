package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

public final class zzgk extends zzma implements zznm {
    private zzgk() {
        throw null;
    }

    public zzgk(byte[] arr_b) {
        super(zzgl.zzw());
    }

    public final int zza() {
        return ((zzgl)this.zza).zzf();
    }

    public final zzgj zzb(int v) {
        return ((zzgl)this.zza).zzg(v);
    }

    public final zzgk zzc(int v, zzgi zzgi0) {
        this.zzaX();
        ((zzgl)this.zza).zzt(v, ((zzgj)zzgi0.zzbc()));
        return this;
    }

    public final List zzd() {
        return Collections.unmodifiableList(((zzgl)this.zza).zzh());
    }

    public final zzgk zze() {
        this.zzaX();
        ((zzgl)this.zza).zzu();
        return this;
    }

    public final zzgk zzf() {
        this.zzaX();
        ((zzgl)this.zza).zzv();
        return this;
    }

    public final List zzg() {
        return Collections.unmodifiableList(((zzgl)this.zza).zzk());
    }

    // 去混淆评级： 低(20)
    public final String zzh() {
        return "";
    }
}

