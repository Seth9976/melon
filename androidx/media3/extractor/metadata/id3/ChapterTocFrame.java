package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.Objects;
import y.a;

public final class ChapterTocFrame extends Id3Frame {
    public static final Parcelable.Creator CREATOR;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final String[] e;
    public final Id3Frame[] f;

    static {
        ChapterTocFrame.CREATOR = new a(15);
    }

    public ChapterTocFrame(Parcel parcel0) {
        super("CTOC");
        this.b = parcel0.readString();
        boolean z = true;
        this.c = parcel0.readByte() != 0;
        if(parcel0.readByte() == 0) {
            z = false;
        }
        this.d = z;
        this.e = parcel0.createStringArray();
        int v1 = parcel0.readInt();
        this.f = new Id3Frame[v1];
        for(int v = 0; v < v1; ++v) {
            this.f[v] = (Id3Frame)parcel0.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public ChapterTocFrame(String s, boolean z, boolean z1, String[] arr_s, Id3Frame[] arr_id3Frame) {
        super("CTOC");
        this.b = s;
        this.c = z;
        this.d = z1;
        this.e = arr_s;
        this.f = arr_id3Frame;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return ChapterTocFrame.class == class0 && this.c == ((ChapterTocFrame)object0).c && this.d == ((ChapterTocFrame)object0).d && Objects.equals(this.b, ((ChapterTocFrame)object0).b) && Arrays.equals(this.e, ((ChapterTocFrame)object0).e) && Arrays.equals(this.f, ((ChapterTocFrame)object0).f);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = ((this.c + 0x20F) * 0x1F + this.d) * 0x1F;
        return this.b == null ? v : v + this.b.hashCode();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.b);
        parcel0.writeByte(((byte)this.c));
        parcel0.writeByte(((byte)this.d));
        parcel0.writeStringArray(this.e);
        Id3Frame[] arr_id3Frame = this.f;
        parcel0.writeInt(arr_id3Frame.length);
        for(int v1 = 0; v1 < arr_id3Frame.length; ++v1) {
            parcel0.writeParcelable(arr_id3Frame[v1], 0);
        }
    }
}

