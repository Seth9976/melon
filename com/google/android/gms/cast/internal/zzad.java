package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.zzat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzad implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        double f = 0.0;
        double f1 = 0.0;
        ApplicationMetadata applicationMetadata0 = null;
        zzat zzat0 = null;
        boolean z = false;
        int v1 = 0;
        int v2 = 0;
        while(parcel0.dataPosition() < v) {
            int v3 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v3)) {
                case 2: {
                    f = SafeParcelReader.readDouble(parcel0, v3);
                    break;
                }
                case 3: {
                    z = SafeParcelReader.readBoolean(parcel0, v3);
                    break;
                }
                case 4: {
                    v1 = SafeParcelReader.readInt(parcel0, v3);
                    break;
                }
                case 5: {
                    applicationMetadata0 = (ApplicationMetadata)SafeParcelReader.createParcelable(parcel0, v3, ApplicationMetadata.CREATOR);
                    break;
                }
                case 6: {
                    v2 = SafeParcelReader.readInt(parcel0, v3);
                    break;
                }
                case 7: {
                    zzat0 = (zzat)SafeParcelReader.createParcelable(parcel0, v3, zzat.CREATOR);
                    break;
                }
                case 8: {
                    f1 = SafeParcelReader.readDouble(parcel0, v3);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v3);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzac(f, z, v1, applicationMetadata0, v2, zzat0, f1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzac[v];
    }
}

