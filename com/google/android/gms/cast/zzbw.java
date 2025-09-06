package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zzbw implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        String s = null;
        String s1 = null;
        MediaMetadata mediaMetadata0 = null;
        List list0 = null;
        TextTrackStyle textTrackStyle0 = null;
        String s2 = null;
        List list1 = null;
        List list2 = null;
        String s3 = null;
        VastAdsRequest vastAdsRequest0 = null;
        String s4 = null;
        String s5 = null;
        String s6 = null;
        String s7 = null;
        long v1 = 0L;
        long v2 = 0L;
        int v3 = 0;
        while(parcel0.dataPosition() < v) {
            int v4 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v4)) {
                case 2: {
                    s = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 3: {
                    v3 = SafeParcelReader.readInt(parcel0, v4);
                    break;
                }
                case 4: {
                    s1 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 5: {
                    mediaMetadata0 = (MediaMetadata)SafeParcelReader.createParcelable(parcel0, v4, MediaMetadata.CREATOR);
                    break;
                }
                case 6: {
                    v1 = SafeParcelReader.readLong(parcel0, v4);
                    break;
                }
                case 7: {
                    list0 = SafeParcelReader.createTypedList(parcel0, v4, MediaTrack.CREATOR);
                    break;
                }
                case 8: {
                    textTrackStyle0 = (TextTrackStyle)SafeParcelReader.createParcelable(parcel0, v4, TextTrackStyle.CREATOR);
                    break;
                }
                case 9: {
                    s2 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 10: {
                    list1 = SafeParcelReader.createTypedList(parcel0, v4, AdBreakInfo.CREATOR);
                    break;
                }
                case 11: {
                    list2 = SafeParcelReader.createTypedList(parcel0, v4, AdBreakClipInfo.CREATOR);
                    break;
                }
                case 12: {
                    s3 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 13: {
                    vastAdsRequest0 = (VastAdsRequest)SafeParcelReader.createParcelable(parcel0, v4, VastAdsRequest.CREATOR);
                    break;
                }
                case 14: {
                    v2 = SafeParcelReader.readLong(parcel0, v4);
                    break;
                }
                case 15: {
                    s4 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 16: {
                    s5 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 17: {
                    s6 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                case 18: {
                    s7 = SafeParcelReader.createString(parcel0, v4);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v4);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new MediaInfo(s, v3, s1, mediaMetadata0, v1, list0, textTrackStyle0, s2, list1, list2, s3, vastAdsRequest0, v2, s4, s5, s6, s7);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new MediaInfo[v];
    }
}

