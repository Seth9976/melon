package androidx.media3.extractor.metadata.scte35;

import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import y.a;

public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator CREATOR;
    public final long a;
    public final long b;
    public final byte[] c;

    static {
        PrivateCommand.CREATOR = new a(26);
    }

    public PrivateCommand(long v, byte[] arr_b, long v1) {
        this.a = v1;
        this.b = v;
        this.c = arr_b;
    }

    public PrivateCommand(Parcel parcel0) {
        this.a = parcel0.readLong();
        this.b = parcel0.readLong();
        this.c = parcel0.createByteArray();
    }

    @Override  // androidx.media3.extractor.metadata.scte35.SpliceCommand
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("SCTE-35 PrivateCommand { ptsAdjustment=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", identifier= ");
        return x.h(this.b, " }", stringBuilder0);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeLong(this.a);
        parcel0.writeLong(this.b);
        parcel0.writeByteArray(this.c);
    }
}

