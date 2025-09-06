package com.google.android.gms.internal.auth_blockstore;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

public abstract class zzh extends zzb implements zzi {
    public zzh() {
        super("com.google.android.gms.auth.blockstore.internal.IDeleteBytesCallback");
    }

    @Override  // com.google.android.gms.internal.auth_blockstore.zzb
    public final boolean dispatchTransaction(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(v == 1) {
            Status status0 = (Status)zzc.zza(parcel0, Status.CREATOR);
            boolean z = zzc.zzd(parcel0);
            this.enforceNoDataAvail(parcel0);
            this.zza(status0, z);
            return true;
        }
        return false;
    }
}

