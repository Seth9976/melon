package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class zzy extends zza implements IGmsCallbacks {
    public zzy(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override  // com.google.android.gms.common.internal.IGmsCallbacks
    public final void onPostInitComplete(int v, IBinder iBinder0, Bundle bundle0) {
        Parcel parcel0 = this.zza();
        parcel0.writeInt(v);
        parcel0.writeStrongBinder(iBinder0);
        zzc.zzc(parcel0, bundle0);
        this.zzD(1, parcel0);
    }

    @Override  // com.google.android.gms.common.internal.IGmsCallbacks
    public final void zzb(int v, Bundle bundle0) {
        throw null;
    }

    @Override  // com.google.android.gms.common.internal.IGmsCallbacks
    public final void zzc(int v, IBinder iBinder0, zzj zzj0) {
        throw null;
    }
}

