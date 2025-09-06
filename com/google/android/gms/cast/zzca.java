package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzca implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        long v1 = 0L;
        long v2 = 0L;
        MediaInfo mediaInfo0 = null;
        MediaQueueData mediaQueueData0 = null;
        Boolean boolean0 = null;
        long[] arr_v = null;
        String s = null;
        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        double f = 0.0;
        while(parcel0.dataPosition() < v) {
            int v3 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v3)) {
                case 2: {
                    mediaInfo0 = (MediaInfo)SafeParcelReader.createParcelable(parcel0, v3, MediaInfo.CREATOR);
                    break;
                }
                case 3: {
                    mediaQueueData0 = (MediaQueueData)SafeParcelReader.createParcelable(parcel0, v3, MediaQueueData.CREATOR);
                    break;
                }
                case 4: {
                    boolean0 = SafeParcelReader.readBooleanObject(parcel0, v3);
                    break;
                }
                case 5: {
                    v1 = SafeParcelReader.readLong(parcel0, v3);
                    break;
                }
                case 6: {
                    f = SafeParcelReader.readDouble(parcel0, v3);
                    break;
                }
                case 7: {
                    arr_v = SafeParcelReader.createLongArray(parcel0, v3);
                    break;
                }
                case 8: {
                    s = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 9: {
                    s1 = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 10: {
                    s2 = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 11: {
                    s3 = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 12: {
                    s4 = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 13: {
                    v2 = SafeParcelReader.readLong(parcel0, v3);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v3);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new MediaLoadRequestData(mediaInfo0, mediaQueueData0, boolean0, v1, f, arr_v, s, s1, s2, s3, s4, v2);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new MediaLoadRequestData[v];
    }
}

