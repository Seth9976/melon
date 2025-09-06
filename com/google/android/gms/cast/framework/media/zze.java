package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zza;
import java.util.List;

public final class zze extends zza implements zzg {
    public zze(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.cast.framework.media.INotificationActionsProvider");
    }

    @Override  // com.google.android.gms.cast.framework.media.zzg
    public final IObjectWrapper zze() {
        throw null;
    }

    @Override  // com.google.android.gms.cast.framework.media.zzg
    public final List zzf() {
        Parcel parcel0 = this.zzb(3, this.zza());
        List list0 = parcel0.createTypedArrayList(NotificationAction.CREATOR);
        parcel0.recycle();
        return list0;
    }

    @Override  // com.google.android.gms.cast.framework.media.zzg
    public final int[] zzg() {
        Parcel parcel0 = this.zzb(4, this.zza());
        int[] arr_v = parcel0.createIntArray();
        parcel0.recycle();
        return arr_v;
    }
}

