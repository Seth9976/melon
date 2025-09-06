package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zzd implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        List list0 = null;
        Bundle bundle0 = null;
        int v1 = 0;
        long v2 = 0L;
        long v3 = 0L;
        while(parcel0.dataPosition() < v) {
            int v4 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v4)) {
                case 1: {
                    list0 = SafeParcelReader.createTypedList(parcel0, v4, DetectedActivity.CREATOR);
                    break;
                }
                case 2: {
                    v2 = SafeParcelReader.readLong(parcel0, v4);
                    break;
                }
                case 3: {
                    v3 = SafeParcelReader.readLong(parcel0, v4);
                    break;
                }
                case 4: {
                    v1 = SafeParcelReader.readInt(parcel0, v4);
                    break;
                }
                case 5: {
                    bundle0 = SafeParcelReader.createBundle(parcel0, v4);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v4);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new ActivityRecognitionResult(list0, v2, v3, v1, bundle0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new ActivityRecognitionResult[v];
    }
}

