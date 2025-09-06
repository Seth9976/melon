package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zza;
import com.google.android.gms.cast.internal.zzac;
import com.google.android.gms.cast.internal.zzai;
import com.google.android.gms.cast.internal.zzr;
import com.google.android.gms.common.api.Status;

final class zzbq extends zzai {
    final zzbr zza;

    public zzbq(zzbr zzbr0) {
        this.zza = zzbr0;
        super();
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzb(ApplicationMetadata applicationMetadata0, String s, String s1, boolean z) {
        zzbr.zzC(this.zza, applicationMetadata0);
        zzbr.zzD(this.zza, s);
        zzr zzr0 = new zzr(new Status(0), applicationMetadata0, s, s1, z);
        zzbr.zzL(this.zza, zzr0);
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzc(int v) {
        zzbr.zzK(this.zza, v);
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzd(int v) {
        zzbr zzbr0 = this.zza;
        zzbr.zzN(zzbr0, v);
        if(zzbr.zzp(zzbr0) != null) {
            zzbr.zzo(zzbr0).post(new zzbo(this, v));
        }
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zze(int v) {
        zzbr.zzN(this.zza, v);
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzf(zza zza0) {
        zzbr.zzo(this.zza).post(new zzbk(this, zza0));
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzg(int v) {
        zzbr.zzN(this.zza, v);
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzh(String s, byte[] arr_b) {
        zzbr.zzr().d("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", new Object[]{s, ((int)arr_b.length)});
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzi(int v) {
        zzbr.zzo(this.zza).post(new zzbm(this, v));
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzj(zzac zzac0) {
        zzbr.zzo(this.zza).post(new zzbj(this, zzac0));
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzk(int v) {
        zzbr.zzo(this.zza).post(new zzbl(this, v));
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzl(String s, long v) {
        zzbr.zzM(this.zza, v, 0);
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzm(String s, long v, int v1) {
        zzbr.zzM(this.zza, v, v1);
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzn(String s, double f, boolean z) {
        zzbr.zzr().d("Deprecated callback: \"onStatusReceived\"", new Object[0]);
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzo(int v) {
        zzbr.zzo(this.zza).post(new zzbp(this, v));
    }

    @Override  // com.google.android.gms.cast.internal.zzaj
    public final void zzp(String s, String s1) {
        zzbr.zzr().d("Receive (type=text, ns=%s) %s", new Object[]{s, s1});
        zzbr.zzo(this.zza).post(new zzbn(this, s, s1));
    }
}

