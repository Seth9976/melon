package com.google.android.gms.auth.blockstore.restorecredential.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.blockstore.restorecredential.ClearRestoreCredentialRequest;
import com.google.android.gms.auth.blockstore.restorecredential.CreateRestoreCredentialRequest;
import com.google.android.gms.auth.blockstore.restorecredential.GetRestoreCredentialRequest;
import com.google.android.gms.internal.auth_blockstore.zza;
import com.google.android.gms.internal.auth_blockstore.zzb;
import com.google.android.gms.internal.auth_blockstore.zzc;

public interface IRestoreCredentialService extends IInterface {
    public static abstract class Stub extends zzb implements IRestoreCredentialService {
        public static class Proxy extends zza implements IRestoreCredentialService {
            public Proxy(IBinder iBinder0) {
                super(iBinder0, "com.google.android.gms.auth.blockstore.restorecredential.internal.IRestoreCredentialService");
            }

            @Override  // com.google.android.gms.auth.blockstore.restorecredential.internal.IRestoreCredentialService
            public void clearRestoreCredential(ClearRestoreCredentialRequest clearRestoreCredentialRequest0, IClearRestoreCredentialCallback iClearRestoreCredentialCallback0) {
                Parcel parcel0 = this.obtainAndWriteInterfaceToken();
                zzc.zzb(parcel0, clearRestoreCredentialRequest0);
                zzc.zzc(parcel0, iClearRestoreCredentialCallback0);
                this.transactAndReadExceptionReturnVoid(4, parcel0);
            }

            @Override  // com.google.android.gms.auth.blockstore.restorecredential.internal.IRestoreCredentialService
            public void createRestoreCredential(CreateRestoreCredentialRequest createRestoreCredentialRequest0, ICreateRestoreCredentialCallback iCreateRestoreCredentialCallback0) {
                Parcel parcel0 = this.obtainAndWriteInterfaceToken();
                zzc.zzb(parcel0, createRestoreCredentialRequest0);
                zzc.zzc(parcel0, iCreateRestoreCredentialCallback0);
                this.transactAndReadExceptionReturnVoid(3, parcel0);
            }

            @Override  // com.google.android.gms.auth.blockstore.restorecredential.internal.IRestoreCredentialService
            public void getRestoreCredential(GetRestoreCredentialRequest getRestoreCredentialRequest0, IGetRestoreCredentialCallback iGetRestoreCredentialCallback0) {
                Parcel parcel0 = this.obtainAndWriteInterfaceToken();
                zzc.zzb(parcel0, getRestoreCredentialRequest0);
                zzc.zzc(parcel0, iGetRestoreCredentialCallback0);
                this.transactAndReadExceptionReturnVoid(2, parcel0);
            }
        }

        public static IRestoreCredentialService asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.auth.blockstore.restorecredential.internal.IRestoreCredentialService");
            return iInterface0 instanceof IRestoreCredentialService ? ((IRestoreCredentialService)iInterface0) : new Proxy(iBinder0);
        }
    }

    void clearRestoreCredential(ClearRestoreCredentialRequest arg1, IClearRestoreCredentialCallback arg2);

    void createRestoreCredential(CreateRestoreCredentialRequest arg1, ICreateRestoreCredentialCallback arg2);

    void getRestoreCredential(GetRestoreCredentialRequest arg1, IGetRestoreCredentialCallback arg2);
}

