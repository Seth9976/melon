package androidx.media3.extractor.metadata.scte35;

import R3.c;
import R3.d;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import y.a;

public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator CREATOR;
    public final List a;

    static {
        SpliceScheduleCommand.CREATOR = new a(29);
    }

    public SpliceScheduleCommand(Parcel parcel0) {
        int v = parcel0.readInt();
        ArrayList arrayList0 = new ArrayList(v);
        for(int v1 = 0; v1 < v; ++v1) {
            arrayList0.add(new d(parcel0));
        }
        this.a = Collections.unmodifiableList(arrayList0);
    }

    public SpliceScheduleCommand(ArrayList arrayList0) {
        this.a = Collections.unmodifiableList(arrayList0);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        List list0 = this.a;
        int v1 = list0.size();
        parcel0.writeInt(v1);
        for(int v2 = 0; v2 < v1; ++v2) {
            d d0 = (d)list0.get(v2);
            parcel0.writeLong(d0.a);
            parcel0.writeByte(((byte)d0.b));
            parcel0.writeByte(((byte)d0.c));
            parcel0.writeByte(((byte)d0.d));
            List list1 = d0.f;
            int v3 = list1.size();
            parcel0.writeInt(v3);
            for(int v4 = 0; v4 < v3; ++v4) {
                c c0 = (c)list1.get(v4);
                parcel0.writeInt(c0.a);
                parcel0.writeLong(c0.b);
            }
            parcel0.writeLong(d0.e);
            parcel0.writeByte(((byte)d0.g));
            parcel0.writeLong(d0.h);
            parcel0.writeInt(d0.i);
            parcel0.writeInt(d0.j);
            parcel0.writeInt(d0.k);
        }
    }
}

