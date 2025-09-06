package com.google.android.exoplayer2.offline;

import U4.x;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class DownloadRequest implements Parcelable {
    public static class UnsupportedRequestException extends IOException {
    }

    public static final Parcelable.Creator CREATOR = null;
    public static final String TYPE_DASH = "dash";
    public static final String TYPE_HLS = "hls";
    public static final String TYPE_PROGRESSIVE = "progressive";
    public static final String TYPE_SS = "ss";
    public final String customCacheKey;
    public final byte[] data;
    public final String id;
    public final List streamKeys;
    public final String type;
    public final Uri uri;

    static {
        DownloadRequest.CREATOR = new Parcelable.Creator() {
            public DownloadRequest createFromParcel(Parcel parcel0) {
                return new DownloadRequest(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public DownloadRequest[] newArray(int v) {
                return new DownloadRequest[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public DownloadRequest(Parcel parcel0) {
        this.id = (String)Util.castNonNull(parcel0.readString());
        this.type = (String)Util.castNonNull(parcel0.readString());
        this.uri = Uri.parse(((String)Util.castNonNull(parcel0.readString())));
        int v = parcel0.readInt();
        ArrayList arrayList0 = new ArrayList(v);
        for(int v1 = 0; v1 < v; ++v1) {
            arrayList0.add(((StreamKey)parcel0.readParcelable(StreamKey.class.getClassLoader())));
        }
        this.streamKeys = Collections.unmodifiableList(arrayList0);
        this.customCacheKey = parcel0.readString();
        this.data = (byte[])Util.castNonNull(parcel0.createByteArray());
    }

    public DownloadRequest(String s, String s1, Uri uri0, List list0, String s2, byte[] arr_b) {
        if("dash".equals(s1) || "hls".equals(s1) || "ss".equals(s1)) {
            String s3 = String.valueOf(s1);
            Assertions.checkArgument(s2 == null, (s3.length() == 0 ? new String("customCacheKey must be null for type: ") : "customCacheKey must be null for type: " + s3));
        }
        this.id = s;
        this.type = s1;
        this.uri = uri0;
        ArrayList arrayList0 = new ArrayList(list0);
        Collections.sort(arrayList0);
        this.streamKeys = Collections.unmodifiableList(arrayList0);
        this.customCacheKey = s2;
        this.data = arr_b == null ? Util.EMPTY_BYTE_ARRAY : Arrays.copyOf(arr_b, arr_b.length);
    }

    public DownloadRequest copyWithId(String s) {
        return new DownloadRequest(s, this.type, this.uri, this.streamKeys, this.customCacheKey, this.data);
    }

    public DownloadRequest copyWithMergedRequest(DownloadRequest downloadRequest0) {
        Assertions.checkArgument(this.id.equals(downloadRequest0.id));
        Assertions.checkArgument(this.type.equals(downloadRequest0.type));
        if(!this.streamKeys.isEmpty() && !downloadRequest0.streamKeys.isEmpty()) {
            List list0 = new ArrayList(this.streamKeys);
            for(int v = 0; v < downloadRequest0.streamKeys.size(); ++v) {
                StreamKey streamKey0 = (StreamKey)downloadRequest0.streamKeys.get(v);
                if(!((ArrayList)list0).contains(streamKey0)) {
                    ((ArrayList)list0).add(streamKey0);
                }
            }
            return new DownloadRequest(this.id, this.type, downloadRequest0.uri, list0, downloadRequest0.customCacheKey, downloadRequest0.data);
        }
        return new DownloadRequest(this.id, this.type, downloadRequest0.uri, Collections.EMPTY_LIST, downloadRequest0.customCacheKey, downloadRequest0.data);
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    // 去混淆评级： 中等(70)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof DownloadRequest ? this.id.equals(((DownloadRequest)object0).id) && this.type.equals(((DownloadRequest)object0).type) && this.uri.equals(((DownloadRequest)object0).uri) && this.streamKeys.equals(((DownloadRequest)object0).streamKeys) && Util.areEqual(this.customCacheKey, ((DownloadRequest)object0).customCacheKey) && Arrays.equals(this.data, ((DownloadRequest)object0).data) : false;
    }

    @Override
    public final int hashCode() {
        int v = x.b(x.b(this.type.hashCode() * 0x1F, 0x1F, this.id), 0x1F, this.type);
        int v1 = this.uri.hashCode();
        int v2 = this.streamKeys.hashCode();
        return this.customCacheKey == null ? Arrays.hashCode(this.data) + (v2 + (v1 + v) * 0x1F) * 961 : Arrays.hashCode(this.data) + ((v2 + (v1 + v) * 0x1F) * 0x1F + this.customCacheKey.hashCode()) * 0x1F;
    }

    @Override
    public String toString() {
        return this.type + ":" + this.id;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.id);
        parcel0.writeString(this.type);
        parcel0.writeString(this.uri.toString());
        parcel0.writeInt(this.streamKeys.size());
        for(int v1 = 0; v1 < this.streamKeys.size(); ++v1) {
            parcel0.writeParcelable(((Parcelable)this.streamKeys.get(v1)), 0);
        }
        parcel0.writeString(this.customCacheKey);
        parcel0.writeByteArray(this.data);
    }
}

