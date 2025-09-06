package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzb implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        return zzb.zza(parcel0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new ApiMetadata[v];
    }

    public static final ApiMetadata zza(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        ComplianceOptions complianceOptions0 = null;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            if(((char)v1) == 1) {
                complianceOptions0 = (ComplianceOptions)SafeParcelReader.createParcelable(parcel0, v1, ComplianceOptions.CREATOR);
            }
            else {
                SafeParcelReader.skipUnknownField(parcel0, v1);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new ApiMetadata(complianceOptions0);
    }
}

