package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.Objects;
import y.a;

public final class ChapterFrame extends Id3Frame {
    public static final Parcelable.Creator CREATOR;
    public final String b;
    public final int c;
    public final int d;
    public final long e;
    public final long f;
    public final Id3Frame[] g;

    static {
        ChapterFrame.CREATOR = new a(14);
    }

    public ChapterFrame(Parcel parcel0) {
        super("CHAP");
        this.b = parcel0.readString();
        this.c = parcel0.readInt();
        this.d = parcel0.readInt();
        this.e = parcel0.readLong();
        this.f = parcel0.readLong();
        int v = parcel0.readInt();
        this.g = new Id3Frame[v];
        for(int v1 = 0; v1 < v; ++v1) {
            this.g[v1] = (Id3Frame)parcel0.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public ChapterFrame(String s, int v, int v1, long v2, long v3, Id3Frame[] arr_id3Frame) {
        super("CHAP");
        this.b = s;
        this.c = v;
        this.d = v1;
        this.e = v2;
        this.f = v3;
        this.g = arr_id3Frame;
    }

    @Override  // androidx.media3.extractor.metadata.id3.Id3Frame
    public final int describeContents() {
        return 0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return ChapterFrame.class == class0 && this.c == ((ChapterFrame)object0).c && this.d == ((ChapterFrame)object0).d && this.e == ((ChapterFrame)object0).e && this.f == ((ChapterFrame)object0).f && Objects.equals(this.b, ((ChapterFrame)object0).b) && Arrays.equals(this.g, ((ChapterFrame)object0).g);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = ((((this.c + 0x20F) * 0x1F + this.d) * 0x1F + ((int)this.e)) * 0x1F + ((int)this.f)) * 0x1F;
        return this.b == null ? v : v + this.b.hashCode();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.b);
        parcel0.writeInt(this.c);
        parcel0.writeInt(this.d);
        parcel0.writeLong(this.e);
        parcel0.writeLong(this.f);
        Id3Frame[] arr_id3Frame = this.g;
        parcel0.writeInt(arr_id3Frame.length);
        for(int v1 = 0; v1 < arr_id3Frame.length; ++v1) {
            parcel0.writeParcelable(arr_id3Frame[v1], 0);
        }
    }
}

