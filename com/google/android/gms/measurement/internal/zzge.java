package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzbl;
import com.google.android.gms.internal.measurement.zzbn;

public final class zzge extends zzbl implements zzgg {
    public zzge(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.measurement.internal.IUploadBatchesCallback");
    }

    @Override  // com.google.android.gms.measurement.internal.zzgg
    public final void zze(zzop zzop0) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, zzop0);
        this.zzd(2, parcel0);
    }
}

