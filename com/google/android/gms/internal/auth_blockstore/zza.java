package com.google.android.gms.internal.auth_blockstore;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class zza implements IInterface {
    private final String mDescriptor;
    private final IBinder mRemote;

    public zza(IBinder iBinder0, String s) {
        this.mRemote = iBinder0;
        this.mDescriptor = s;
    }

    @Override  // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    public Parcel obtainAndWriteInterfaceToken() {
        Parcel parcel0 = Parcel.obtain();
        parcel0.writeInterfaceToken(this.mDescriptor);
        return parcel0;
    }

    public void transactAndReadExceptionReturnVoid(int v, Parcel parcel0) {
        Parcel parcel1 = Parcel.obtain();
        try {
            this.mRemote.transact(v, parcel0, parcel1, 0);
            parcel1.readException();
        }
        finally {
            parcel0.recycle();
            parcel1.recycle();
        }
    }
}

