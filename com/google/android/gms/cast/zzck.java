package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zzck implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        MediaInfo mediaInfo0 = null;
        long[] arr_v = null;
        String s = null;
        List list0 = null;
        AdBreakStatus adBreakStatus0 = null;
        VideoInfo videoInfo0 = null;
        MediaLiveSeekableRange mediaLiveSeekableRange0 = null;
        MediaQueueData mediaQueueData0 = null;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        boolean z = false;
        int v4 = 0;
        int v5 = 0;
        int v6 = 0;
        boolean z1 = false;
        double f = 0.0;
        double f1 = 0.0;
        long v7 = 0L;
        long v8 = 0L;
        long v9 = 0L;
        while(parcel0.dataPosition() < v) {
            int v10 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v10)) {
                case 2: {
                    mediaInfo0 = (MediaInfo)SafeParcelReader.createParcelable(parcel0, v10, MediaInfo.CREATOR);
                    break;
                }
                case 3: {
                    v7 = SafeParcelReader.readLong(parcel0, v10);
                    break;
                }
                case 4: {
                    v1 = SafeParcelReader.readInt(parcel0, v10);
                    break;
                }
                case 5: {
                    f = SafeParcelReader.readDouble(parcel0, v10);
                    break;
                }
                case 6: {
                    v2 = SafeParcelReader.readInt(parcel0, v10);
                    break;
                }
                case 7: {
                    v3 = SafeParcelReader.readInt(parcel0, v10);
                    break;
                }
                case 8: {
                    v8 = SafeParcelReader.readLong(parcel0, v10);
                    break;
                }
                case 9: {
                    v9 = SafeParcelReader.readLong(parcel0, v10);
                    break;
                }
                case 10: {
                    f1 = SafeParcelReader.readDouble(parcel0, v10);
                    break;
                }
                case 11: {
                    z = SafeParcelReader.readBoolean(parcel0, v10);
                    break;
                }
                case 12: {
                    arr_v = SafeParcelReader.createLongArray(parcel0, v10);
                    break;
                }
                case 13: {
                    v4 = SafeParcelReader.readInt(parcel0, v10);
                    break;
                }
                case 14: {
                    v5 = SafeParcelReader.readInt(parcel0, v10);
                    break;
                }
                case 15: {
                    s = SafeParcelReader.createString(parcel0, v10);
                    break;
                }
                case 16: {
                    v6 = SafeParcelReader.readInt(parcel0, v10);
                    break;
                }
                case 17: {
                    list0 = SafeParcelReader.createTypedList(parcel0, v10, MediaQueueItem.CREATOR);
                    break;
                }
                case 18: {
                    z1 = SafeParcelReader.readBoolean(parcel0, v10);
                    break;
                }
                case 19: {
                    adBreakStatus0 = (AdBreakStatus)SafeParcelReader.createParcelable(parcel0, v10, AdBreakStatus.CREATOR);
                    break;
                }
                case 20: {
                    videoInfo0 = (VideoInfo)SafeParcelReader.createParcelable(parcel0, v10, VideoInfo.CREATOR);
                    break;
                }
                case 21: {
                    mediaLiveSeekableRange0 = (MediaLiveSeekableRange)SafeParcelReader.createParcelable(parcel0, v10, MediaLiveSeekableRange.CREATOR);
                    break;
                }
                case 22: {
                    mediaQueueData0 = (MediaQueueData)SafeParcelReader.createParcelable(parcel0, v10, MediaQueueData.CREATOR);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v10);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new MediaStatus(mediaInfo0, v7, v1, f, v2, v3, v8, v9, f1, z, arr_v, v4, v5, s, v6, list0, z1, adBreakStatus0, videoInfo0, mediaLiveSeekableRange0, mediaQueueData0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new MediaStatus[v];
    }
}

