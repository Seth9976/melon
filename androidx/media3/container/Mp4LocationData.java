package androidx.media3.container;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.media3.common.Metadata.Entry;
import com.iloen.melon.sns.model.e;
import e3.b;

public final class Mp4LocationData implements Entry {
    public static final Parcelable.Creator CREATOR;
    public final float a;
    public final float b;

    static {
        Mp4LocationData.CREATOR = new e(17);
    }

    public Mp4LocationData(float f, float f1) {
        b.d(f >= -90.0f && f <= 90.0f && f1 >= -180.0f && f1 <= 180.0f, "Invalid latitude or longitude");
        this.a = f;
        this.b = f1;
    }

    public Mp4LocationData(Parcel parcel0) {
        this.a = parcel0.readFloat();
        this.b = parcel0.readFloat();
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
            return Mp4LocationData.class == class0 && this.a == ((Mp4LocationData)object0).a && this.b == ((Mp4LocationData)object0).b;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() + 0x20F) * 0x1F;
    }

    @Override
    public final String toString() {
        return "xyz: latitude=" + this.a + ", longitude=" + this.b;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeFloat(this.a);
        parcel0.writeFloat(this.b);
    }
}

