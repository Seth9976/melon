package androidx.media3.extractor.metadata.dvbsi;

import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.media3.common.Metadata.Entry;
import y.a;

public final class AppInfoTable implements Entry {
    public static final Parcelable.Creator CREATOR;
    public final int a;
    public final String b;

    static {
        AppInfoTable.CREATOR = new a(6);
    }

    public AppInfoTable(int v, String s) {
        this.a = v;
        this.b = s;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Ait(controlCode=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(",url=");
        return x.m(stringBuilder0, this.b, ")");
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.b);
        parcel0.writeInt(this.a);
    }
}

