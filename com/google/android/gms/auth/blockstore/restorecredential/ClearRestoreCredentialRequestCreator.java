package com.google.android.gms.auth.blockstore.restorecredential;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class ClearRestoreCredentialRequestCreator implements Parcelable.Creator {
    public ClearRestoreCredentialRequest createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        Bundle bundle0 = null;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            if(((char)v1) == 1) {
                bundle0 = SafeParcelReader.createBundle(parcel0, v1);
            }
            else {
                SafeParcelReader.skipUnknownField(parcel0, v1);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new ClearRestoreCredentialRequest(bundle0);
    }

    @Override  // android.os.Parcelable$Creator
    public Object createFromParcel(Parcel parcel0) {
        return this.createFromParcel(parcel0);
    }

    public ClearRestoreCredentialRequest[] newArray(int v) {
        return new ClearRestoreCredentialRequest[v];
    }

    @Override  // android.os.Parcelable$Creator
    public Object[] newArray(int v) {
        return this.newArray(v);
    }

    public static void writeToParcel(ClearRestoreCredentialRequest clearRestoreCredentialRequest0, Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeBundle(parcel0, 1, clearRestoreCredentialRequest0.getRequestBundle(), false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

