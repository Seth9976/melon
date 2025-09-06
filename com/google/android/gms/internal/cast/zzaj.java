package com.google.android.gms.internal.cast;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.media.internal.zzg;
import com.google.android.gms.cast.framework.media.internal.zzh;
import com.google.android.gms.cast.framework.media.internal.zzj;
import com.google.android.gms.cast.framework.zzag;
import com.google.android.gms.cast.framework.zzai;
import com.google.android.gms.cast.framework.zzal;
import com.google.android.gms.cast.framework.zzas;
import com.google.android.gms.cast.framework.zzat;
import com.google.android.gms.cast.framework.zzav;
import com.google.android.gms.cast.framework.zzaw;
import com.google.android.gms.cast.framework.zzbe;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

public final class zzaj extends zza implements zzak {
    public zzaj(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.cast.framework.internal.ICastDynamiteModule");
    }

    @Override  // com.google.android.gms.internal.cast.zzak
    public final int zze() {
        Parcel parcel0 = this.zzb(8, this.zza());
        int v = parcel0.readInt();
        parcel0.recycle();
        return v;
    }

    @Override  // com.google.android.gms.internal.cast.zzak
    public final com.google.android.gms.cast.framework.zzaj zzf(IObjectWrapper iObjectWrapper0, CastOptions castOptions0, zzam zzam0, Map map0) {
        Parcel parcel0 = this.zza();
        zzc.zze(parcel0, iObjectWrapper0);
        zzc.zzc(parcel0, castOptions0);
        zzc.zze(parcel0, zzam0);
        parcel0.writeMap(map0);
        Parcel parcel1 = this.zzb(1, parcel0);
        com.google.android.gms.cast.framework.zzaj zzaj0 = zzai.zzb(parcel1.readStrongBinder());
        parcel1.recycle();
        return zzaj0;
    }

    @Override  // com.google.android.gms.internal.cast.zzak
    public final com.google.android.gms.cast.framework.zzam zzg(CastOptions castOptions0, IObjectWrapper iObjectWrapper0, zzag zzag0) {
        Parcel parcel0 = this.zza();
        zzc.zzc(parcel0, castOptions0);
        zzc.zze(parcel0, iObjectWrapper0);
        zzc.zze(parcel0, zzag0);
        Parcel parcel1 = this.zzb(3, parcel0);
        com.google.android.gms.cast.framework.zzam zzam0 = zzal.zzb(parcel1.readStrongBinder());
        parcel1.recycle();
        return zzam0;
    }

    @Override  // com.google.android.gms.internal.cast.zzak
    public final zzat zzh(IObjectWrapper iObjectWrapper0, IObjectWrapper iObjectWrapper1, IObjectWrapper iObjectWrapper2) {
        Parcel parcel0 = this.zza();
        zzc.zze(parcel0, iObjectWrapper0);
        zzc.zze(parcel0, iObjectWrapper1);
        zzc.zze(parcel0, iObjectWrapper2);
        Parcel parcel1 = this.zzb(5, parcel0);
        zzat zzat0 = zzas.zzb(parcel1.readStrongBinder());
        parcel1.recycle();
        return zzat0;
    }

    @Override  // com.google.android.gms.internal.cast.zzak
    public final zzaw zzi(String s, String s1, zzbe zzbe0) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        parcel0.writeString(s1);
        zzc.zze(parcel0, zzbe0);
        Parcel parcel1 = this.zzb(2, parcel0);
        zzaw zzaw0 = zzav.zzb(parcel1.readStrongBinder());
        parcel1.recycle();
        return zzaw0;
    }

    @Override  // com.google.android.gms.internal.cast.zzak
    public final zzh zzj(IObjectWrapper iObjectWrapper0, zzj zzj0, int v, int v1, boolean z, long v2, int v3, int v4, int v5) {
        Parcel parcel0 = this.zza();
        zzc.zze(parcel0, iObjectWrapper0);
        zzc.zze(parcel0, zzj0);
        parcel0.writeInt(v);
        parcel0.writeInt(v1);
        parcel0.writeInt(0);
        parcel0.writeLong(0x200000L);
        parcel0.writeInt(5);
        parcel0.writeInt(333);
        parcel0.writeInt(10000);
        Parcel parcel1 = this.zzb(6, parcel0);
        zzh zzh0 = zzg.zzb(parcel1.readStrongBinder());
        parcel1.recycle();
        return zzh0;
    }

    @Override  // com.google.android.gms.internal.cast.zzak
    public final zzh zzk(IObjectWrapper iObjectWrapper0, IObjectWrapper iObjectWrapper1, zzj zzj0, int v, int v1, boolean z, long v2, int v3, int v4, int v5) {
        Parcel parcel0 = this.zza();
        zzc.zze(parcel0, iObjectWrapper0);
        zzc.zze(parcel0, iObjectWrapper1);
        zzc.zze(parcel0, zzj0);
        parcel0.writeInt(v);
        parcel0.writeInt(v1);
        parcel0.writeInt(0);
        parcel0.writeLong(0x200000L);
        parcel0.writeInt(5);
        parcel0.writeInt(333);
        parcel0.writeInt(10000);
        Parcel parcel1 = this.zzb(7, parcel0);
        zzh zzh0 = zzg.zzb(parcel1.readStrongBinder());
        parcel1.recycle();
        return zzh0;
    }
}

