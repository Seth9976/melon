package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzdq implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        String s = null;
        String s1 = null;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        int v5 = 0;
        int v6 = 0;
        int v7 = 0;
        int v8 = 0;
        int v9 = 0;
        float f = 0.0f;
        while(parcel0.dataPosition() < v) {
            int v10 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v10)) {
                case 2: {
                    f = SafeParcelReader.readFloat(parcel0, v10);
                    break;
                }
                case 3: {
                    v1 = SafeParcelReader.readInt(parcel0, v10);
                    break;
                }
                case 4: {
                    v2 = SafeParcelReader.readInt(parcel0, v10);
                    break;
                }
                case 5: {
                    v3 = SafeParcelReader.readInt(parcel0, v10);
                    break;
                }
                case 6: {
                    v4 = SafeParcelReader.readInt(parcel0, v10);
                    break;
                }
                case 7: {
                    v5 = SafeParcelReader.readInt(parcel0, v10);
                    break;
                }
                case 8: {
                    v6 = SafeParcelReader.readInt(parcel0, v10);
                    break;
                }
                case 9: {
                    v7 = SafeParcelReader.readInt(parcel0, v10);
                    break;
                }
                case 10: {
                    s = SafeParcelReader.createString(parcel0, v10);
                    break;
                }
                case 11: {
                    v8 = SafeParcelReader.readInt(parcel0, v10);
                    break;
                }
                case 12: {
                    v9 = SafeParcelReader.readInt(parcel0, v10);
                    break;
                }
                case 13: {
                    s1 = SafeParcelReader.createString(parcel0, v10);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v10);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new TextTrackStyle(f, v1, v2, v3, v4, v5, v6, v7, s, v8, v9, s1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new TextTrackStyle[v];
    }
}

