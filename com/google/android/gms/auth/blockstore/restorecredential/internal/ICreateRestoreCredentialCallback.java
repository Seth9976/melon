package com.google.android.gms.auth.blockstore.restorecredential.internal;

import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.blockstore.restorecredential.CreateRestoreCredentialResponse;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth_blockstore.zzb;
import com.google.android.gms.internal.auth_blockstore.zzc;

public interface ICreateRestoreCredentialCallback extends IInterface {
    public static abstract class Stub extends zzb implements ICreateRestoreCredentialCallback {
        public Stub() {
            super("com.google.android.gms.auth.blockstore.restorecredential.internal.ICreateRestoreCredentialCallback");
        }

        @Override  // com.google.android.gms.internal.auth_blockstore.zzb
        public boolean dispatchTransaction(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v == 1) {
                Status status0 = (Status)zzc.zza(parcel0, Status.CREATOR);
                CreateRestoreCredentialResponse createRestoreCredentialResponse0 = (CreateRestoreCredentialResponse)zzc.zza(parcel0, CreateRestoreCredentialResponse.CREATOR);
                this.enforceNoDataAvail(parcel0);
                this.onCreateRestoreCredential(status0, createRestoreCredentialResponse0);
                return true;
            }
            return false;
        }
    }

    void onCreateRestoreCredential(Status arg1, CreateRestoreCredentialResponse arg2);
}

