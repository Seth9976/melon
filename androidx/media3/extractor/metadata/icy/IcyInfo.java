package androidx.media3.extractor.metadata.icy;

import A7.d;
import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.media3.common.Metadata.Entry;
import androidx.media3.common.c;
import java.util.Arrays;
import y.a;

public final class IcyInfo implements Entry {
    public static final Parcelable.Creator CREATOR;
    public final byte[] a;
    public final String b;
    public final String c;

    static {
        IcyInfo.CREATOR = new a(11);
    }

    public IcyInfo(Parcel parcel0) {
        byte[] arr_b = parcel0.createByteArray();
        arr_b.getClass();
        this.a = arr_b;
        this.b = parcel0.readString();
        this.c = parcel0.readString();
    }

    public IcyInfo(byte[] arr_b, String s, String s1) {
        this.a = arr_b;
        this.b = s;
        this.c = s1;
    }

    @Override  // androidx.media3.common.Metadata$Entry
    public final void M(c c0) {
        String s = this.b;
        if(s != null) {
            c0.a = s;
        }
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
            return IcyInfo.class == class0 ? Arrays.equals(this.a, ((IcyInfo)object0).a) : false;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(this.a);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("ICY: title=\"", this.b, "\", url=\"", this.c, "\", rawMetadata.length=\"");
        return x.g(this.a.length, "\"", stringBuilder0);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeByteArray(this.a);
        parcel0.writeString(this.b);
        parcel0.writeString(this.c);
    }
}

