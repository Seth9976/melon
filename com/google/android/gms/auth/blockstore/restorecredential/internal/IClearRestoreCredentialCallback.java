package com.google.android.gms.auth.blockstore.restorecredential.internal;

import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth_blockstore.zzb;
import com.google.android.gms.internal.auth_blockstore.zzc;

public interface IClearRestoreCredentialCallback extends IInterface {
    public static abstract class Stub extends zzb implements IClearRestoreCredentialCallback {
        public Stub() {
            super("com.google.android.gms.auth.blockstore.restorecredential.internal.IClearRestoreCredentialCallback");
        }

        @Override  // com.google.android.gms.internal.auth_blockstore.zzb
        public boolean dispatchTransaction(int v, Parcel parcel0, Parcel parcel1, int v1) {
            if(v == 1) {
                Status status0 = (Status)zzc.zza(parcel0, Status.CREATOR);
                boolean z = zzc.zzd(parcel0);
                this.enforceNoDataAvail(parcel0);
                this.onClearRestoreCredential(status0, z);
                return true;
            }
            return false;
        }
    }

    void onClearRestoreCredential(Status arg1, boolean arg2);
}

