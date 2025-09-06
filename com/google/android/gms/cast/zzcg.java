package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zzcg implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        boolean z = false;
        long v4 = 0L;
        String s = null;
        String s1 = null;
        String s2 = null;
        MediaQueueContainerMetadata mediaQueueContainerMetadata0 = null;
        List list0 = null;
        while(parcel0.dataPosition() < v) {
            int v5 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v5)) {
                case 2: {
                    s = SafeParcelReader.createString(parcel0, v5);
                    break;
                }
                case 3: {
                    s1 = SafeParcelReader.createString(parcel0, v5);
                    break;
                }
                case 4: {
                    v1 = SafeParcelReader.readInt(parcel0, v5);
                    break;
                }
                case 5: {
                    s2 = SafeParcelReader.createString(parcel0, v5);
                    break;
                }
                case 6: {
                    mediaQueueContainerMetadata0 = (MediaQueueContainerMetadata)SafeParcelReader.createParcelable(parcel0, v5, MediaQueueContainerMetadata.CREATOR);
                    break;
                }
                case 7: {
                    v2 = SafeParcelReader.readInt(parcel0, v5);
                    break;
                }
                case 8: {
                    list0 = SafeParcelReader.createTypedList(parcel0, v5, MediaQueueItem.CREATOR);
                    break;
                }
                case 9: {
                    v3 = SafeParcelReader.readInt(parcel0, v5);
                    break;
                }
                case 10: {
                    v4 = SafeParcelReader.readLong(parcel0, v5);
                    break;
                }
                case 11: {
                    z = SafeParcelReader.readBoolean(parcel0, v5);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v5);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new MediaQueueData(s, s1, v1, s2, mediaQueueContainerMetadata0, v2, list0, v3, v4, z);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new MediaQueueData[v];
    }
}

