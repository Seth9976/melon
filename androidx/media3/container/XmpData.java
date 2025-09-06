package androidx.media3.container;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.media3.common.Metadata.Entry;
import com.iloen.melon.sns.model.e;
import e3.x;
import java.util.Arrays;

public final class XmpData implements Entry {
    public static final Parcelable.Creator CREATOR;
    public final byte[] a;

    static {
        XmpData.CREATOR = new e(20);
    }

    public XmpData(Parcel parcel0) {
        this.a = parcel0.createByteArray();
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
            return XmpData.class == class0 ? Arrays.equals(this.a, ((XmpData)object0).a) : false;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return "XMP: " + x.X(this.a);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeByteArray(this.a);
    }
}

