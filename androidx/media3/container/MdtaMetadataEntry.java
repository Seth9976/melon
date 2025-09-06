package androidx.media3.container;

import B3.q;
import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.media3.common.Metadata.Entry;
import com.iloen.melon.sns.model.e;
import com.iloen.melon.utils.a;
import e3.b;
import e3.p;
import java.util.ArrayList;
import java.util.Arrays;
import k8.Y;

public final class MdtaMetadataEntry implements Entry {
    public static final Parcelable.Creator CREATOR;
    public final String a;
    public final byte[] b;
    public final int c;
    public final int d;

    static {
        MdtaMetadataEntry.CREATOR = new e(16);
    }

    public MdtaMetadataEntry(Parcel parcel0) {
        String s = parcel0.readString();
        this.a = s;
        byte[] arr_b = parcel0.createByteArray();
        this.b = arr_b;
        this.c = parcel0.readInt();
        int v = parcel0.readInt();
        this.d = v;
        MdtaMetadataEntry.b(v, s, arr_b);
    }

    public MdtaMetadataEntry(String s, byte[] arr_b, int v, int v1) {
        MdtaMetadataEntry.b(v1, s, arr_b);
        this.a = s;
        this.b = arr_b;
        this.c = v;
        this.d = v1;
    }

    public final ArrayList a() {
        b.i("Metadata is not an editable tracks map", this.a.equals("editable.tracks.map"));
        byte[] arr_b = this.b;
        int v = arr_b[1];
        ArrayList arrayList0 = new ArrayList();
        for(int v1 = 0; v1 < v; v1 = a.d(arr_b[v1 + 2], v1, 1, arrayList0)) {
        }
        return arrayList0;
    }

    public static void b(int v, String s, byte[] arr_b) {
        s.getClass();
        boolean z = false;
        switch(s) {
            case "com.android.capture.fps": {
                if(v == 23 && arr_b.length == 4) {
                    z = true;
                }
                b.c(z);
                return;
            }
            case "editable.tracks.length": 
            case "editable.tracks.offset": {
                if(v == 78 && arr_b.length == 8) {
                    z = true;
                }
                b.c(z);
                return;
            }
            case "editable.tracks.map": {
                if(v == 0) {
                    z = true;
                }
                b.c(z);
                return;
            }
            case "editable.tracks.samples.location": {
                if(v == 75 && arr_b.length == 1) {
                    switch(arr_b[0]) {
                        case 0: 
                        case 1: {
                            z = true;
                        }
                    }
                }
                b.c(z);
            }
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
            return MdtaMetadataEntry.class == class0 && this.a.equals(((MdtaMetadataEntry)object0).a) && Arrays.equals(this.b, ((MdtaMetadataEntry)object0).b) && this.c == ((MdtaMetadataEntry)object0).c && this.d == ((MdtaMetadataEntry)object0).d;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return ((Arrays.hashCode(this.b) + x.b(0x20F, 0x1F, this.a)) * 0x1F + this.c) * 0x1F + this.d;
    }

    @Override
    public final String toString() {
        String s = this.a;
        byte[] arr_b = this.b;
        switch(this.d) {
            case 0: {
                if(s.equals("editable.tracks.map")) {
                    ArrayList arrayList0 = this.a();
                    StringBuilder stringBuilder0 = Y.p("track types = ");
                    new q(",").b(stringBuilder0, arrayList0.iterator());
                    return "mdta: key=" + s + ", value=" + stringBuilder0.toString();
                }
                return "mdta: key=" + s + ", value=" + e3.x.X(arr_b);
            }
            case 1: {
                return "mdta: key=" + s + ", value=" + e3.x.m(arr_b);
            }
            case 23: {
                return "mdta: key=" + s + ", value=" + Float.intBitsToFloat(ye.a.A(arr_b));
            }
            case 67: {
                return "mdta: key=" + s + ", value=" + ye.a.A(arr_b);
            }
            case 75: {
                return "mdta: key=" + s + ", value=" + Byte.toUnsignedInt(arr_b[0]);
            }
            case 78: {
                return "mdta: key=" + s + ", value=" + new p(arr_b).z();
            }
            default: {
                return "mdta: key=" + s + ", value=" + e3.x.X(arr_b);
            }
        }
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeByteArray(this.b);
        parcel0.writeInt(this.c);
        parcel0.writeInt(this.d);
    }
}

