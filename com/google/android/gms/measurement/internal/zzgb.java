package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzbl;
import java.util.List;

public final class zzgb extends zzbl implements zzgd {
    public zzgb(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.measurement.internal.ITriggerUrisCallback");
    }

    @Override  // com.google.android.gms.measurement.internal.zzgd
    public final void zze(List list0) {
        Parcel parcel0 = this.zza();
        parcel0.writeTypedList(list0);
        this.zzd(2, parcel0);
    }
}

