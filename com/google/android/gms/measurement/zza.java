package com.google.android.gms.measurement;

import android.os.Bundle;
import androidx.collection.V;
import androidx.collection.f;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzib;
import com.google.android.gms.measurement.internal.zzjo;
import com.google.android.gms.measurement.internal.zzjp;
import com.google.android.gms.measurement.internal.zzli;
import com.google.android.gms.measurement.internal.zzpk;
import java.util.List;
import java.util.Map;

final class zza extends zzc {
    private final zzib zza;
    private final zzli zzb;

    public zza(zzib zzib0) {
        super(null);
        Preconditions.checkNotNull(zzib0);
        this.zza = zzib0;
        this.zzb = zzib0.zzj();
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final void zza(String s, String s1, Bundle bundle0) {
        this.zzb.zzB(s, s1, bundle0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final void zzb(String s, String s1, Bundle bundle0, long v) {
        this.zzb.zzC(s, s1, bundle0, true, false, v);
    }

    @Override  // com.google.android.gms.measurement.zzc
    public final Map zzc(boolean z) {
        List list0 = this.zzb.zzO(z);
        Map map0 = new f(list0.size());  // 初始化器: Landroidx/collection/V;-><init>(I)V
        for(Object object0: list0) {
            zzpk zzpk0 = (zzpk)object0;
            Object object1 = zzpk0.zza();
            if(object1 != null) {
                ((V)map0).put(zzpk0.zzb, object1);
            }
        }
        return map0;
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final Map zzd(String s, String s1, boolean z) {
        return this.zzb.zzP(s, s1, z);
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final void zze(zzjo zzjo0) {
        this.zzb.zzV(zzjo0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final void zzf(zzjp zzjp0) {
        this.zzb.zzW(zzjp0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final void zzg(zzjp zzjp0) {
        this.zzb.zzX(zzjp0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final String zzh() {
        return this.zzb.zzad();
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final String zzi() {
        return this.zzb.zzae();
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final String zzj() {
        return this.zzb.zzQ();
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final String zzk() {
        return this.zzb.zzQ();
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final long zzl() {
        return this.zza.zzk().zzd();
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final void zzm(String s) {
        this.zza.zzw().zza(s, this.zza.zzaZ().elapsedRealtime());
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final void zzn(String s) {
        this.zza.zzw().zzb(s, this.zza.zzaZ().elapsedRealtime());
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final void zzo(Bundle bundle0) {
        this.zzb.zzZ(bundle0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final void zzp(String s, String s1, Bundle bundle0) {
        this.zza.zzj().zzab(s, s1, bundle0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final List zzq(String s, String s1) {
        return this.zzb.zzac(s, s1);
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final int zzr(String s) {
        this.zzb.zzY(s);
        return 25;
    }

    @Override  // com.google.android.gms.measurement.zzc
    public final Boolean zzs() {
        return this.zzb.zzi();
    }

    @Override  // com.google.android.gms.measurement.zzc
    public final Integer zzt() {
        return this.zzb.zzl();
    }

    @Override  // com.google.android.gms.measurement.zzc
    public final String zzu() {
        return this.zzb.zzj();
    }

    @Override  // com.google.android.gms.measurement.zzc
    public final Long zzv() {
        return this.zzb.zzk();
    }

    @Override  // com.google.android.gms.measurement.zzc
    public final Double zzw() {
        return this.zzb.zzm();
    }

    @Override  // com.google.android.gms.measurement.internal.zzlj
    public final Object zzx(int v) {
        switch(v) {
            case 0: {
                return this.zzb.zzj();
            }
            case 1: {
                return this.zzb.zzk();
            }
            case 2: {
                return this.zzb.zzm();
            }
            case 3: {
                return this.zzb.zzl();
            }
            default: {
                return this.zzb.zzi();
            }
        }
    }
}

