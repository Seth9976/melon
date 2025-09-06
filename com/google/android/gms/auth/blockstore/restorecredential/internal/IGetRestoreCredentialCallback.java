package com.google.android.gms.auth.blockstore.restorecredential.internal;

import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.blockstore.restorecredential.GetRestoreCredentialResponse;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth_blockstore.zzb;
import com.google.android.gms.internal.auth_blockstore.zzc;

public interface IGetRestoreCredentialCallback extends IInterface {
    public static abstract class Stub extends zzb implements IGetRestoreCredentialCallback {
        public Stub() {
            super("com.google.android.gms.auth.blockstore.restorecredential.internal.IGetRestoreCredentialCallback");
        }

        @Override  // com.google.android.gms.internal.auth_blockstore.zzb
        public boolean dispatchTransaction(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v == 1) {
                Status status0 = (Status)zzc.zza(parcel0, Status.CREATOR);
                GetRestoreCredentialResponse getRestoreCredentialResponse0 = (GetRestoreCredentialResponse)zzc.zza(parcel0, GetRestoreCredentialResponse.CREATOR);
                this.enforceNoDataAvail(parcel0);
                this.onGetRestoreCredential(status0, getRestoreCredentialResponse0);
                return true;
            }
            return false;
        }
    }

    void onGetRestoreCredential(Status arg1, GetRestoreCredentialResponse arg2);
}

