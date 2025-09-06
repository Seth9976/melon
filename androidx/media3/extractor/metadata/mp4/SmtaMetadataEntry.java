package androidx.media3.extractor.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.media3.common.Metadata.Entry;
import y.a;

public final class SmtaMetadataEntry implements Entry {
    public static final Parcelable.Creator CREATOR;
    public final float a;
    public final int b;

    static {
        SmtaMetadataEntry.CREATOR = new a(25);
    }

    public SmtaMetadataEntry(float f, int v) {
        this.a = f;
        this.b = v;
    }

    public SmtaMetadataEntry(Parcel parcel0) {
        this.a = parcel0.readFloat();
        this.b = parcel0.readInt();
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
            return SmtaMetadataEntry.class == class0 && this.a == ((SmtaMetadataEntry)object0).a && this.b == ((SmtaMetadataEntry)object0).b;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return (this.a.hashCode() + 0x20F) * 0x1F + this.b;
    }

    @Override
    public final String toString() {
        return "smta: captureFrameRate=" + this.a + ", svcTemporalLayerCount=" + this.b;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeFloat(this.a);
        parcel0.writeInt(this.b);
    }
}

