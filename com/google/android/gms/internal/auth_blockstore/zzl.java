package com.google.android.gms.internal.auth_blockstore;

import android.os.Parcel;
import com.google.android.gms.auth.blockstore.RetrieveBytesResponse;
import com.google.android.gms.common.api.Status;

public abstract class zzl extends zzb implements zzm {
    public zzl() {
        super("com.google.android.gms.auth.blockstore.internal.IRetrieveBytesCallback");
    }

    @Override  // com.google.android.gms.internal.auth_blockstore.zzb
    public final boolean dispatchTransaction(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 1: {
                Status status0 = (Status)zzc.zza(parcel0, Status.CREATOR);
                byte[] arr_b = parcel0.createByteArray();
                this.enforceNoDataAvail(parcel0);
                this.zza(status0, arr_b);
                return true;
            }
            case 2: {
                Status status1 = (Status)zzc.zza(parcel0, Status.CREATOR);
                RetrieveBytesResponse retrieveBytesResponse0 = (RetrieveBytesResponse)zzc.zza(parcel0, RetrieveBytesResponse.CREATOR);
                this.enforceNoDataAvail(parcel0);
                this.zzb(status1, retrieveBytesResponse0);
                return true;
            }
            default: {
                return false;
            }
        }
    }
}

