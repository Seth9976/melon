package com.google.android.gms.internal.auth_blockstore;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

public abstract class zzn extends zzb implements zzo {
    public zzn() {
        super("com.google.android.gms.auth.blockstore.internal.IStoreBytesCallback");
    }

    @Override  // com.google.android.gms.internal.auth_blockstore.zzb
    public final boolean dispatchTransaction(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(v == 1) {
            Status status0 = (Status)zzc.zza(parcel0, Status.CREATOR);
            int v2 = parcel0.readInt();
            this.enforceNoDataAvail(parcel0);
            this.zza(status0, v2);
            return true;
        }
        return false;
    }
}

