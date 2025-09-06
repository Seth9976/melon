package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public final class zzcy extends zzbl implements zzda {
    public zzcy(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override  // com.google.android.gms.internal.measurement.zzda
    public final void zze(String s, String s1, Bundle bundle0, long v) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        parcel0.writeString(s1);
        zzbn.zzc(parcel0, bundle0);
        parcel0.writeLong(v);
        this.zzc(1, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzda
    public final int zzf() {
        Parcel parcel0 = this.zzP(2, this.zza());
        int v = parcel0.readInt();
        parcel0.recycle();
        return v;
    }
}

