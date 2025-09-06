package androidx.media3.container;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.media3.common.Metadata.Entry;
import com.iloen.melon.sns.model.e;

public final class Mp4OrientationData implements Entry {
    public static final Parcelable.Creator CREATOR;
    public final int a;

    static {
        Mp4OrientationData.CREATOR = new e(18);
    }

    public Mp4OrientationData(Parcel parcel0) {
        this.a = parcel0.readInt();
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
        return object0 instanceof Mp4OrientationData ? this.a == ((Mp4OrientationData)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return this.a + 0x20F;
    }

    @Override
    public final String toString() {
        return "Orientation= " + this.a;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.a);
    }
}

