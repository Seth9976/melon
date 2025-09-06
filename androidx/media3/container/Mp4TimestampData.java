package androidx.media3.container;

import B.a;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.media3.common.Metadata.Entry;
import com.iloen.melon.sns.model.e;

public final class Mp4TimestampData implements Entry {
    public static final Parcelable.Creator CREATOR;
    public final long a;
    public final long b;
    public final long c;

    static {
        Mp4TimestampData.CREATOR = new e(19);
    }

    public Mp4TimestampData(long v, long v1, long v2) {
        this.a = v;
        this.b = v1;
        this.c = v2;
    }

    public Mp4TimestampData(Parcel parcel0) {
        this.a = parcel0.readLong();
        this.b = parcel0.readLong();
        this.c = parcel0.readLong();
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
        return object0 instanceof Mp4TimestampData ? this.a == ((Mp4TimestampData)object0).a && this.b == ((Mp4TimestampData)object0).b && this.c == ((Mp4TimestampData)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return a.P(this.c) + (a.P(this.b) + (a.P(this.a) + 0x20F) * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        return "Mp4Timestamp: creation time=" + this.a + ", modification time=" + this.b + ", timescale=" + this.c;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeLong(this.a);
        parcel0.writeLong(this.b);
        parcel0.writeLong(this.c);
    }
}

