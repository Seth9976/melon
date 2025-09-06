package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzbl;
import com.google.android.gms.internal.measurement.zzbn;
import java.util.List;

public final class zzfy extends zzbl implements zzga {
    public zzfy(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzA(zzr zzr0) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, zzr0);
        this.zzc(27, parcel0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzB(zzr zzr0, zzon zzon0, zzgg zzgg0) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, zzr0);
        zzbn.zzc(parcel0, zzon0);
        zzbn.zzd(parcel0, zzgg0);
        this.zzc(29, parcel0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzC(zzr zzr0, zzaf zzaf0) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, zzr0);
        zzbn.zzc(parcel0, zzaf0);
        this.zzc(30, parcel0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzD(zzr zzr0, Bundle bundle0, zzgd zzgd0) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, zzr0);
        zzbn.zzc(parcel0, bundle0);
        zzbn.zzd(parcel0, zzgd0);
        this.zzc(0x1F, parcel0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zze(zzbg zzbg0, zzr zzr0) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, zzbg0);
        zzbn.zzc(parcel0, zzr0);
        this.zzc(1, parcel0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzf(zzpk zzpk0, zzr zzr0) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, zzpk0);
        zzbn.zzc(parcel0, zzr0);
        this.zzc(2, parcel0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzg(zzr zzr0) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, zzr0);
        this.zzc(4, parcel0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzh(zzbg zzbg0, String s, String s1) {
        throw null;
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzi(zzr zzr0) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, zzr0);
        this.zzc(6, parcel0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final List zzj(zzr zzr0, boolean z) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, zzr0);
        parcel0.writeInt(((int)z));
        Parcel parcel1 = this.zzP(7, parcel0);
        List list0 = parcel1.createTypedArrayList(zzpk.CREATOR);
        parcel1.recycle();
        return list0;
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final byte[] zzk(zzbg zzbg0, String s) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, zzbg0);
        parcel0.writeString(s);
        Parcel parcel1 = this.zzP(9, parcel0);
        byte[] arr_b = parcel1.createByteArray();
        parcel1.recycle();
        return arr_b;
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzl(long v, String s, String s1, String s2) {
        Parcel parcel0 = this.zza();
        parcel0.writeLong(v);
        parcel0.writeString(s);
        parcel0.writeString(s1);
        parcel0.writeString(s2);
        this.zzc(10, parcel0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final String zzm(zzr zzr0) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, zzr0);
        Parcel parcel1 = this.zzP(11, parcel0);
        String s = parcel1.readString();
        parcel1.recycle();
        return s;
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzn(zzah zzah0, zzr zzr0) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, zzah0);
        zzbn.zzc(parcel0, zzr0);
        this.zzc(12, parcel0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzo(zzah zzah0) {
        throw null;
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final List zzp(String s, String s1, boolean z, zzr zzr0) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        parcel0.writeString(s1);
        parcel0.writeInt(((int)z));
        zzbn.zzc(parcel0, zzr0);
        Parcel parcel1 = this.zzP(14, parcel0);
        List list0 = parcel1.createTypedArrayList(zzpk.CREATOR);
        parcel1.recycle();
        return list0;
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final List zzq(String s, String s1, String s2, boolean z) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(null);
        parcel0.writeString(s1);
        parcel0.writeString(s2);
        parcel0.writeInt(((int)z));
        Parcel parcel1 = this.zzP(15, parcel0);
        List list0 = parcel1.createTypedArrayList(zzpk.CREATOR);
        parcel1.recycle();
        return list0;
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final List zzr(String s, String s1, zzr zzr0) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        parcel0.writeString(s1);
        zzbn.zzc(parcel0, zzr0);
        Parcel parcel1 = this.zzP(16, parcel0);
        List list0 = parcel1.createTypedArrayList(zzah.CREATOR);
        parcel1.recycle();
        return list0;
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final List zzs(String s, String s1, String s2) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(null);
        parcel0.writeString(s1);
        parcel0.writeString(s2);
        Parcel parcel1 = this.zzP(17, parcel0);
        List list0 = parcel1.createTypedArrayList(zzah.CREATOR);
        parcel1.recycle();
        return list0;
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzt(zzr zzr0) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, zzr0);
        this.zzc(18, parcel0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzu(Bundle bundle0, zzr zzr0) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, bundle0);
        zzbn.zzc(parcel0, zzr0);
        this.zzc(19, parcel0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzv(zzr zzr0) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, zzr0);
        this.zzc(20, parcel0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final zzao zzw(zzr zzr0) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, zzr0);
        Parcel parcel1 = this.zzP(21, parcel0);
        zzao zzao0 = (zzao)zzbn.zzb(parcel1, zzao.CREATOR);
        parcel1.recycle();
        return zzao0;
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final List zzx(zzr zzr0, Bundle bundle0) {
        throw null;
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzy(zzr zzr0) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, zzr0);
        this.zzc(25, parcel0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzz(zzr zzr0) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, zzr0);
        this.zzc(26, parcel0);
    }
}

