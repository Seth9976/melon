package com.google.android.exoplayer2.source.hls;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import b3.Z;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class HlsTrackMetadataEntry implements Entry {
    public static final class VariantInfo implements Parcelable {
        public static final Parcelable.Creator CREATOR;
        public final String audioGroupId;
        public final long bitrate;
        public final String captionGroupId;
        public final String subtitleGroupId;
        public final String videoGroupId;

        static {
            VariantInfo.CREATOR = new Parcelable.Creator() {
                public VariantInfo createFromParcel(Parcel parcel0) {
                    return new VariantInfo(parcel0);
                }

                @Override  // android.os.Parcelable$Creator
                public Object createFromParcel(Parcel parcel0) {
                    return this.createFromParcel(parcel0);
                }

                public VariantInfo[] newArray(int v) {
                    return new VariantInfo[v];
                }

                @Override  // android.os.Parcelable$Creator
                public Object[] newArray(int v) {
                    return this.newArray(v);
                }
            };
        }

        public VariantInfo(long v, String s, String s1, String s2, String s3) {
            this.bitrate = v;
            this.videoGroupId = s;
            this.audioGroupId = s1;
            this.subtitleGroupId = s2;
            this.captionGroupId = s3;
        }

        public VariantInfo(Parcel parcel0) {
            this.bitrate = parcel0.readLong();
            this.videoGroupId = parcel0.readString();
            this.audioGroupId = parcel0.readString();
            this.subtitleGroupId = parcel0.readString();
            this.captionGroupId = parcel0.readString();
        }

        @Override  // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            if(object0 != null) {
                Class class0 = object0.getClass();
                return VariantInfo.class == class0 && this.bitrate == ((VariantInfo)object0).bitrate && TextUtils.equals(this.videoGroupId, ((VariantInfo)object0).videoGroupId) && TextUtils.equals(this.audioGroupId, ((VariantInfo)object0).audioGroupId) && TextUtils.equals(this.subtitleGroupId, ((VariantInfo)object0).subtitleGroupId) && TextUtils.equals(this.captionGroupId, ((VariantInfo)object0).captionGroupId);
            }
            return false;
        }

        @Override
        public int hashCode() {
            int v = ((int)(this.bitrate ^ this.bitrate >>> 0x20)) * 0x1F;
            int v1 = 0;
            int v2 = this.videoGroupId == null ? 0 : this.videoGroupId.hashCode();
            int v3 = this.audioGroupId == null ? 0 : this.audioGroupId.hashCode();
            int v4 = this.subtitleGroupId == null ? 0 : this.subtitleGroupId.hashCode();
            String s = this.captionGroupId;
            if(s != null) {
                v1 = s.hashCode();
            }
            return (((v + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v1;
        }

        @Override  // android.os.Parcelable
        public void writeToParcel(Parcel parcel0, int v) {
            parcel0.writeLong(this.bitrate);
            parcel0.writeString(this.videoGroupId);
            parcel0.writeString(this.audioGroupId);
            parcel0.writeString(this.subtitleGroupId);
            parcel0.writeString(this.captionGroupId);
        }
    }

    public static final Parcelable.Creator CREATOR;
    public final String groupId;
    public final String name;
    public final List variantInfos;

    static {
        HlsTrackMetadataEntry.CREATOR = new Parcelable.Creator() {
            public HlsTrackMetadataEntry createFromParcel(Parcel parcel0) {
                return new HlsTrackMetadataEntry(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public HlsTrackMetadataEntry[] newArray(int v) {
                return new HlsTrackMetadataEntry[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public HlsTrackMetadataEntry(Parcel parcel0) {
        this.groupId = parcel0.readString();
        this.name = parcel0.readString();
        int v = parcel0.readInt();
        ArrayList arrayList0 = new ArrayList(v);
        for(int v1 = 0; v1 < v; ++v1) {
            arrayList0.add(((VariantInfo)parcel0.readParcelable(VariantInfo.class.getClassLoader())));
        }
        this.variantInfos = Collections.unmodifiableList(arrayList0);
    }

    public HlsTrackMetadataEntry(String s, String s1, List list0) {
        this.groupId = s;
        this.name = s1;
        this.variantInfos = Collections.unmodifiableList(new ArrayList(list0));
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return HlsTrackMetadataEntry.class == class0 && TextUtils.equals(this.groupId, ((HlsTrackMetadataEntry)object0).groupId) && TextUtils.equals(this.name, ((HlsTrackMetadataEntry)object0).name) && this.variantInfos.equals(((HlsTrackMetadataEntry)object0).variantInfos);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.groupId == null ? 0 : this.groupId.hashCode();
        String s = this.name;
        if(s != null) {
            v = s.hashCode();
        }
        return this.variantInfos.hashCode() + (v1 * 0x1F + v) * 0x1F;
    }

    @Override
    public String toString() {
        String s1;
        String s = this.groupId;
        if(s == null) {
            s1 = "";
        }
        else {
            StringBuilder stringBuilder0 = Z.o(Z.e(Z.e(5, s), this.name), " [", s, ", ", this.name);
            stringBuilder0.append("]");
            s1 = stringBuilder0.toString();
        }
        String s2 = String.valueOf(s1);
        return s2.length() == 0 ? new String("HlsTrackMetadataEntry") : "HlsTrackMetadataEntry" + s2;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.groupId);
        parcel0.writeString(this.name);
        int v1 = this.variantInfos.size();
        parcel0.writeInt(v1);
        for(int v2 = 0; v2 < v1; ++v2) {
            parcel0.writeParcelable(((Parcelable)this.variantInfos.get(v2)), 0);
        }
    }
}

