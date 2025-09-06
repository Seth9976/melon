package androidx.media3.extractor.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.media3.common.Metadata.Entry;
import y.a;

public final class MotionPhotoMetadata implements Entry {
    public static final Parcelable.Creator CREATOR;
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;

    static {
        MotionPhotoMetadata.CREATOR = new a(24);
    }

    public MotionPhotoMetadata(long v, long v1, long v2, long v3, long v4) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = v3;
        this.e = v4;
    }

    public MotionPhotoMetadata(Parcel parcel0) {
        this.a = parcel0.readLong();
        this.b = parcel0.readLong();
        this.c = parcel0.readLong();
        this.d = parcel0.readLong();
        this.e = parcel0.readLong();
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
            return MotionPhotoMetadata.class == class0 && this.a == ((MotionPhotoMetadata)object0).a && this.b == ((MotionPhotoMetadata)object0).b && this.c == ((MotionPhotoMetadata)object0).c && this.d == ((MotionPhotoMetadata)object0).d && this.e == ((MotionPhotoMetadata)object0).e;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return B.a.P(this.e) + (B.a.P(this.d) + (B.a.P(this.c) + (B.a.P(this.b) + (B.a.P(this.a) + 0x20F) * 0x1F) * 0x1F) * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.a + ", photoSize=" + this.b + ", photoPresentationTimestampUs=" + this.c + ", videoStartPosition=" + this.d + ", videoSize=" + this.e;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeLong(this.a);
        parcel0.writeLong(this.b);
        parcel0.writeLong(this.c);
        parcel0.writeLong(this.d);
        parcel0.writeLong(this.e);
    }
}

