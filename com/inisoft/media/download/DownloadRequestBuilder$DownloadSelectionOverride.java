package com.inisoft.media.download;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import y.a;

public final class DownloadRequestBuilder.DownloadSelectionOverride implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final int a;
    public final int[] b;

    static {
        DownloadRequestBuilder.DownloadSelectionOverride.CREATOR = new a(4);
    }

    public DownloadRequestBuilder.DownloadSelectionOverride(Parcel parcel0) {
        this.a = parcel0.readInt();
        int v = parcel0.readInt();
        this.b = new int[v];
        for(int v1 = 0; v1 < v; ++v1) {
            this.b[v1] = parcel0.readInt();
        }
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.a);
        int[] arr_v = this.b;
        parcel0.writeInt(arr_v.length);
        for(int v1 = 0; v1 < arr_v.length; ++v1) {
            parcel0.writeInt(arr_v[v1]);
        }
    }
}

