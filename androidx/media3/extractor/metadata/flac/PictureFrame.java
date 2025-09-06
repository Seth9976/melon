package androidx.media3.extractor.metadata.flac;

import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.media3.common.Metadata.Entry;
import androidx.media3.common.c;
import b3.H;
import e3.p;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import y.a;

public final class PictureFrame implements Entry {
    public static final Parcelable.Creator CREATOR;
    public final int a;
    public final String b;
    public final String c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final byte[] h;

    static {
        PictureFrame.CREATOR = new a(8);
    }

    public PictureFrame(int v, String s, String s1, int v1, int v2, int v3, int v4, byte[] arr_b) {
        this.a = v;
        this.b = s;
        this.c = s1;
        this.d = v1;
        this.e = v2;
        this.f = v3;
        this.g = v4;
        this.h = arr_b;
    }

    public PictureFrame(Parcel parcel0) {
        this.a = parcel0.readInt();
        this.b = parcel0.readString();
        this.c = parcel0.readString();
        this.d = parcel0.readInt();
        this.e = parcel0.readInt();
        this.f = parcel0.readInt();
        this.g = parcel0.readInt();
        this.h = parcel0.createByteArray();
    }

    @Override  // androidx.media3.common.Metadata$Entry
    public final void M(c c0) {
        c0.a(this.a, this.h);
    }

    public static PictureFrame a(p p0) {
        int v = p0.g();
        String s = H.l(p0.s(p0.g(), StandardCharsets.US_ASCII));
        String s1 = p0.s(p0.g(), StandardCharsets.UTF_8);
        int v1 = p0.g();
        int v2 = p0.g();
        int v3 = p0.g();
        int v4 = p0.g();
        int v5 = p0.g();
        byte[] arr_b = new byte[v5];
        p0.e(arr_b, 0, v5);
        return new PictureFrame(v, s, s1, v1, v2, v3, v4, arr_b);
    }

    @Override  // android.os.Parcelable
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
            return PictureFrame.class == class0 && this.a == ((PictureFrame)object0).a && this.b.equals(((PictureFrame)object0).b) && this.c.equals(((PictureFrame)object0).c) && this.d == ((PictureFrame)object0).d && this.e == ((PictureFrame)object0).e && this.f == ((PictureFrame)object0).f && this.g == ((PictureFrame)object0).g && Arrays.equals(this.h, ((PictureFrame)object0).h);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(this.h) + ((((x.b(x.b((this.a + 0x20F) * 0x1F, 0x1F, this.b), 0x1F, this.c) + this.d) * 0x1F + this.e) * 0x1F + this.f) * 0x1F + this.g) * 0x1F;
    }

    @Override
    public final String toString() {
        return "Picture: mimeType=" + this.b + ", description=" + this.c;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.a);
        parcel0.writeString(this.b);
        parcel0.writeString(this.c);
        parcel0.writeInt(this.d);
        parcel0.writeInt(this.e);
        parcel0.writeInt(this.f);
        parcel0.writeInt(this.g);
        parcel0.writeByteArray(this.h);
    }
}

