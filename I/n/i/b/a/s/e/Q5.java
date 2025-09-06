package i.n.i.b.a.s.e;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class q5 {
    public final long a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final long e;
    public final List f;
    public final boolean g;
    public final long h;
    public final int i;
    public final int j;
    public final int k;

    public q5(long v, boolean z, boolean z1, boolean z2, ArrayList arrayList0, long v1, boolean z3, long v2, int v3, int v4, int v5) {
        this.a = v;
        this.b = z;
        this.c = z1;
        this.d = z2;
        this.f = Collections.unmodifiableList(arrayList0);
        this.e = v1;
        this.g = z3;
        this.h = v2;
        this.i = v3;
        this.j = v4;
        this.k = v5;
    }

    public q5(Parcel parcel0) {
        this.a = parcel0.readLong();
        boolean z = false;
        this.b = parcel0.readByte() == 1;
        this.c = parcel0.readByte() == 1;
        this.d = parcel0.readByte() == 1;
        int v = parcel0.readInt();
        ArrayList arrayList0 = new ArrayList(v);
        for(int v1 = 0; v1 < v; ++v1) {
            arrayList0.add(new p5(parcel0.readInt(), parcel0.readLong()));
        }
        this.f = Collections.unmodifiableList(arrayList0);
        this.e = parcel0.readLong();
        if(parcel0.readByte() == 1) {
            z = true;
        }
        this.g = z;
        this.h = parcel0.readLong();
        this.i = parcel0.readInt();
        this.j = parcel0.readInt();
        this.k = parcel0.readInt();
    }
}

