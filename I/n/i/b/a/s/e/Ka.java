package i.n.i.b.a.s.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ka extends ga {
    public static final Parcelable.Creator CREATOR;
    public final List a;

    static {
        ka.CREATOR = new t(16);
    }

    public ka(Parcel parcel0) {
        int v = parcel0.readInt();
        ArrayList arrayList0 = new ArrayList(v);
        for(int v1 = 0; v1 < v; ++v1) {
            arrayList0.add(new q5(parcel0));
        }
        this.a = Collections.unmodifiableList(arrayList0);
    }

    public ka(ArrayList arrayList0) {
        this.a = Collections.unmodifiableList(arrayList0);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        List list0 = this.a;
        int v1 = list0.size();
        parcel0.writeInt(v1);
        for(int v2 = 0; v2 < v1; ++v2) {
            q5 q50 = (q5)list0.get(v2);
            parcel0.writeLong(q50.a);
            parcel0.writeByte(((byte)q50.b));
            parcel0.writeByte(((byte)q50.c));
            parcel0.writeByte(((byte)q50.d));
            List list1 = q50.f;
            int v3 = list1.size();
            parcel0.writeInt(v3);
            for(int v4 = 0; v4 < v3; ++v4) {
                p5 p50 = (p5)list1.get(v4);
                parcel0.writeInt(p50.a);
                parcel0.writeLong(p50.b);
            }
            parcel0.writeLong(q50.e);
            parcel0.writeByte(((byte)q50.g));
            parcel0.writeLong(q50.h);
            parcel0.writeInt(q50.i);
            parcel0.writeInt(q50.j);
            parcel0.writeInt(q50.k);
        }
    }
}

