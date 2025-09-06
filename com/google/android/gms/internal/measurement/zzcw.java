package com.google.android.gms.internal.measurement;

import android.os.Parcel;

public abstract class zzcw extends zzbm implements zzcx {
    public zzcw() {
        super("com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
    }

    @Override  // com.google.android.gms.internal.measurement.zzbm
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(v == 2) {
            this.zze();
            return true;
        }
        return false;
    }
}

