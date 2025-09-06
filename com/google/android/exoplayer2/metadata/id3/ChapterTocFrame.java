package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class ChapterTocFrame extends Id3Frame {
    public static final Parcelable.Creator CREATOR = null;
    public static final String ID = "CTOC";
    public final String[] children;
    public final String elementId;
    public final boolean isOrdered;
    public final boolean isRoot;
    private final Id3Frame[] subFrames;

    static {
        ChapterTocFrame.CREATOR = new Parcelable.Creator() {
            public ChapterTocFrame createFromParcel(Parcel parcel0) {
                return new ChapterTocFrame(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public ChapterTocFrame[] newArray(int v) {
                return new ChapterTocFrame[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public ChapterTocFrame(Parcel parcel0) {
        super("CTOC");
        this.elementId = (String)Util.castNonNull(parcel0.readString());
        boolean z = true;
        this.isRoot = parcel0.readByte() != 0;
        if(parcel0.readByte() == 0) {
            z = false;
        }
        this.isOrdered = z;
        this.children = (String[])Util.castNonNull(parcel0.createStringArray());
        int v1 = parcel0.readInt();
        this.subFrames = new Id3Frame[v1];
        for(int v = 0; v < v1; ++v) {
            this.subFrames[v] = (Id3Frame)parcel0.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public ChapterTocFrame(String s, boolean z, boolean z1, String[] arr_s, Id3Frame[] arr_id3Frame) {
        super("CTOC");
        this.elementId = s;
        this.isRoot = z;
        this.isOrdered = z1;
        this.children = arr_s;
        this.subFrames = arr_id3Frame;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return ChapterTocFrame.class == class0 && this.isRoot == ((ChapterTocFrame)object0).isRoot && this.isOrdered == ((ChapterTocFrame)object0).isOrdered && Util.areEqual(this.elementId, ((ChapterTocFrame)object0).elementId) && Arrays.equals(this.children, ((ChapterTocFrame)object0).children) && Arrays.equals(this.subFrames, ((ChapterTocFrame)object0).subFrames);
        }
        return false;
    }

    public Id3Frame getSubFrame(int v) {
        return this.subFrames[v];
    }

    public int getSubFrameCount() {
        return this.subFrames.length;
    }

    @Override
    public int hashCode() {
        int v = ((this.isRoot + 0x20F) * 0x1F + this.isOrdered) * 0x1F;
        return this.elementId == null ? v : v + this.elementId.hashCode();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.elementId);
        parcel0.writeByte(((byte)this.isRoot));
        parcel0.writeByte(((byte)this.isOrdered));
        parcel0.writeStringArray(this.children);
        parcel0.writeInt(this.subFrames.length);
        Id3Frame[] arr_id3Frame = this.subFrames;
        for(int v1 = 0; v1 < arr_id3Frame.length; ++v1) {
            parcel0.writeParcelable(arr_id3Frame[v1], 0);
        }
    }
}

