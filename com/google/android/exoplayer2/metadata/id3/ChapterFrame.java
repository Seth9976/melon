package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class ChapterFrame extends Id3Frame {
    public static final Parcelable.Creator CREATOR = null;
    public static final String ID = "CHAP";
    public final String chapterId;
    public final long endOffset;
    public final int endTimeMs;
    public final long startOffset;
    public final int startTimeMs;
    private final Id3Frame[] subFrames;

    static {
        ChapterFrame.CREATOR = new Parcelable.Creator() {
            public ChapterFrame createFromParcel(Parcel parcel0) {
                return new ChapterFrame(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public ChapterFrame[] newArray(int v) {
                return new ChapterFrame[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public ChapterFrame(Parcel parcel0) {
        super("CHAP");
        this.chapterId = (String)Util.castNonNull(parcel0.readString());
        this.startTimeMs = parcel0.readInt();
        this.endTimeMs = parcel0.readInt();
        this.startOffset = parcel0.readLong();
        this.endOffset = parcel0.readLong();
        int v = parcel0.readInt();
        this.subFrames = new Id3Frame[v];
        for(int v1 = 0; v1 < v; ++v1) {
            this.subFrames[v1] = (Id3Frame)parcel0.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public ChapterFrame(String s, int v, int v1, long v2, long v3, Id3Frame[] arr_id3Frame) {
        super("CHAP");
        this.chapterId = s;
        this.startTimeMs = v;
        this.endTimeMs = v1;
        this.startOffset = v2;
        this.endOffset = v3;
        this.subFrames = arr_id3Frame;
    }

    @Override  // com.google.android.exoplayer2.metadata.id3.Id3Frame
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
            return ChapterFrame.class == class0 && this.startTimeMs == ((ChapterFrame)object0).startTimeMs && this.endTimeMs == ((ChapterFrame)object0).endTimeMs && this.startOffset == ((ChapterFrame)object0).startOffset && this.endOffset == ((ChapterFrame)object0).endOffset && Util.areEqual(this.chapterId, ((ChapterFrame)object0).chapterId) && Arrays.equals(this.subFrames, ((ChapterFrame)object0).subFrames);
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
        int v = ((((this.startTimeMs + 0x20F) * 0x1F + this.endTimeMs) * 0x1F + ((int)this.startOffset)) * 0x1F + ((int)this.endOffset)) * 0x1F;
        return this.chapterId == null ? v : v + this.chapterId.hashCode();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.chapterId);
        parcel0.writeInt(this.startTimeMs);
        parcel0.writeInt(this.endTimeMs);
        parcel0.writeLong(this.startOffset);
        parcel0.writeLong(this.endOffset);
        parcel0.writeInt(this.subFrames.length);
        Id3Frame[] arr_id3Frame = this.subFrames;
        for(int v1 = 0; v1 < arr_id3Frame.length; ++v1) {
            parcel0.writeParcelable(arr_id3Frame[v1], 0);
        }
    }
}

