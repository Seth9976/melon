package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zzw implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        int v5 = 0;
        int v6 = 0;
        int v7 = 0;
        int v8 = 0;
        int v9 = 0;
        int v10 = 0;
        int v11 = 0;
        int v12 = 0;
        int v13 = 0;
        int v14 = 0;
        int v15 = 0;
        int v16 = 0;
        int v17 = 0;
        int v18 = 0;
        int v19 = 0;
        int v20 = 0;
        int v21 = 0;
        int v22 = 0;
        int v23 = 0;
        int v24 = 0;
        int v25 = 0;
        int v26 = 0;
        int v27 = 0;
        boolean z = false;
        boolean z1 = false;
        List list0 = null;
        int[] arr_v = null;
        String s = null;
        IBinder iBinder0 = null;
        long v28 = 0L;
        while(parcel0.dataPosition() < v) {
            int v29 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v29)) {
                case 2: {
                    list0 = SafeParcelReader.createStringList(parcel0, v29);
                    break;
                }
                case 3: {
                    arr_v = SafeParcelReader.createIntArray(parcel0, v29);
                    break;
                }
                case 4: {
                    v28 = SafeParcelReader.readLong(parcel0, v29);
                    break;
                }
                case 5: {
                    s = SafeParcelReader.createString(parcel0, v29);
                    break;
                }
                case 6: {
                    v1 = SafeParcelReader.readInt(parcel0, v29);
                    break;
                }
                case 7: {
                    v2 = SafeParcelReader.readInt(parcel0, v29);
                    break;
                }
                case 8: {
                    v3 = SafeParcelReader.readInt(parcel0, v29);
                    break;
                }
                case 9: {
                    v4 = SafeParcelReader.readInt(parcel0, v29);
                    break;
                }
                case 10: {
                    v5 = SafeParcelReader.readInt(parcel0, v29);
                    break;
                }
                case 11: {
                    v6 = SafeParcelReader.readInt(parcel0, v29);
                    break;
                }
                case 12: {
                    v7 = SafeParcelReader.readInt(parcel0, v29);
                    break;
                }
                case 13: {
                    v8 = SafeParcelReader.readInt(parcel0, v29);
                    break;
                }
                case 14: {
                    v9 = SafeParcelReader.readInt(parcel0, v29);
                    break;
                }
                case 15: {
                    v10 = SafeParcelReader.readInt(parcel0, v29);
                    break;
                }
                case 16: {
                    v11 = SafeParcelReader.readInt(parcel0, v29);
                    break;
                }
                case 17: {
                    v12 = SafeParcelReader.readInt(parcel0, v29);
                    break;
                }
                case 18: {
                    v13 = SafeParcelReader.readInt(parcel0, v29);
                    break;
                }
                case 19: {
                    v14 = SafeParcelReader.readInt(parcel0, v29);
                    break;
                }
                case 20: {
                    v15 = SafeParcelReader.readInt(parcel0, v29);
                    break;
                }
                case 21: {
                    v16 = SafeParcelReader.readInt(parcel0, v29);
                    break;
                }
                case 22: {
                    v17 = SafeParcelReader.readInt(parcel0, v29);
                    break;
                }
                case 23: {
                    v18 = SafeParcelReader.readInt(parcel0, v29);
                    break;
                }
                case 24: {
                    v19 = SafeParcelReader.readInt(parcel0, v29);
                    break;
                }
                case 25: {
                    v20 = SafeParcelReader.readInt(parcel0, v29);
                    break;
                }
                case 26: {
                    v21 = SafeParcelReader.readInt(parcel0, v29);
                    break;
                }
                case 27: {
                    v22 = SafeParcelReader.readInt(parcel0, v29);
                    break;
                }
                case 28: {
                    v23 = SafeParcelReader.readInt(parcel0, v29);
                    break;
                }
                case 29: {
                    v24 = SafeParcelReader.readInt(parcel0, v29);
                    break;
                }
                case 30: {
                    v25 = SafeParcelReader.readInt(parcel0, v29);
                    break;
                }
                case 0x1F: {
                    v26 = SafeParcelReader.readInt(parcel0, v29);
                    break;
                }
                case 0x20: {
                    v27 = SafeParcelReader.readInt(parcel0, v29);
                    break;
                }
                case 33: {
                    iBinder0 = SafeParcelReader.readIBinder(parcel0, v29);
                    break;
                }
                case 34: {
                    z = SafeParcelReader.readBoolean(parcel0, v29);
                    break;
                }
                case 35: {
                    z1 = SafeParcelReader.readBoolean(parcel0, v29);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v29);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new NotificationOptions(list0, arr_v, v28, s, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20, v21, v22, v23, v24, v25, v26, v27, iBinder0, z, z1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new NotificationOptions[v];
    }
}

