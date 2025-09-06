package com.google.android.gms.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzjo;
import com.google.android.gms.measurement.internal.zzjp;
import com.google.android.gms.measurement.internal.zzlj;
import java.util.List;
import java.util.Map;

final class zzb extends zzc {
    private final zzlj zza;

    public zzb(zzlj zzlj0) {
        super(null);
        Preconditions.checkNotNull(zzlj0);
        this.zza = zzlj0;
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final void zza(String s, String s1, Bundle bundle0) {
        this.zza.zza(s, s1, bundle0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final void zzb(String s, String s1, Bundle bundle0, long v) {
        this.zza.zzb(s, s1, bundle0, v);
    }

    @Override  // com.google.android.gms.measurement.zzc
    public final Map zzc(boolean z) {
        return this.zza.zzd(null, null, z);
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final Map zzd(String s, String s1, boolean z) {
        return this.zza.zzd(s, s1, z);
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final void zze(zzjo zzjo0) {
        this.zza.zze(zzjo0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final void zzf(zzjp zzjp0) {
        this.zza.zzf(zzjp0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final void zzg(zzjp zzjp0) {
        this.zza.zzg(zzjp0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final String zzh() {
        return this.zza.zzh();
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final String zzi() {
        return this.zza.zzi();
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final String zzj() {
        return this.zza.zzj();
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final String zzk() {
        return this.zza.zzk();
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final long zzl() {
        return this.zza.zzl();
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final void zzm(String s) {
        this.zza.zzm(s);
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final void zzn(String s) {
        this.zza.zzn(s);
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final void zzo(Bundle bundle0) {
        this.zza.zzo(bundle0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final void zzp(String s, String s1, Bundle bundle0) {
        this.zza.zzp(s, s1, bundle0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final List zzq(String s, String s1) {
        return this.zza.zzq(s, s1);
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final int zzr(String s) {
        return this.zza.zzr(s);
    }

    @Override  // com.google.android.gms.measurement.zzc
    public final Boolean zzs() {
        return (Boolean)this.zza.zzx(4);
    }

    @Override  // com.google.android.gms.measurement.zzc
    public final Integer zzt() {
        return (Integer)this.zza.zzx(3);
    }

    @Override  // com.google.android.gms.measurement.zzc
    public final String zzu() {
        return (String)this.zza.zzx(0);
    }

    @Override  // com.google.android.gms.measurement.zzc
    public final Long zzv() {
        return (Long)this.zza.zzx(1);
    }

    @Override  // com.google.android.gms.measurement.zzc
    public final Double zzw() {
        return (Double)this.zza.zzx(2);
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final Object zzx(int v) {
        return this.zza.zzx(v);
    }
}

