package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzci implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        MediaInfo mediaInfo0 = null;
        long[] arr_v = null;
        String s = null;
        double f = 0.0;
        double f1 = 0.0;
        double f2 = 0.0;
        int v1 = 0;
        boolean z = false;
        while(parcel0.dataPosition() < v) {
            int v2 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v2)) {
                case 2: {
                    mediaInfo0 = (MediaInfo)SafeParcelReader.createParcelable(parcel0, v2, MediaInfo.CREATOR);
                    break;
                }
                case 3: {
                    v1 = SafeParcelReader.readInt(parcel0, v2);
                    break;
                }
                case 4: {
                    z = SafeParcelReader.readBoolean(parcel0, v2);
                    break;
                }
                case 5: {
                    f = SafeParcelReader.readDouble(parcel0, v2);
                    break;
                }
                case 6: {
                    f1 = SafeParcelReader.readDouble(parcel0, v2);
                    break;
                }
                case 7: {
                    f2 = SafeParcelReader.readDouble(parcel0, v2);
                    break;
                }
                case 8: {
                    arr_v = SafeParcelReader.createLongArray(parcel0, v2);
                    break;
                }
                case 9: {
                    s = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v2);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new MediaQueueItem(mediaInfo0, v1, z, f, f1, f2, arr_v, s);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new MediaQueueItem[v];
    }
}

