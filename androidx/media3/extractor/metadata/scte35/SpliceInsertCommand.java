package androidx.media3.extractor.metadata.scte35;

import R3.b;
import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import y.a;

public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator CREATOR;
    public final long a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final long f;
    public final long g;
    public final List h;
    public final boolean i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;

    static {
        SpliceInsertCommand.CREATOR = new a(27);
    }

    public SpliceInsertCommand(long v, boolean z, boolean z1, boolean z2, boolean z3, long v1, long v2, List list0, boolean z4, long v3, int v4, int v5, int v6) {
        this.a = v;
        this.b = z;
        this.c = z1;
        this.d = z2;
        this.e = z3;
        this.f = v1;
        this.g = v2;
        this.h = Collections.unmodifiableList(list0);
        this.i = z4;
        this.j = v3;
        this.k = v4;
        this.l = v5;
        this.m = v6;
    }

    public SpliceInsertCommand(Parcel parcel0) {
        this.a = parcel0.readLong();
        boolean z = false;
        this.b = parcel0.readByte() == 1;
        this.c = parcel0.readByte() == 1;
        this.d = parcel0.readByte() == 1;
        this.e = parcel0.readByte() == 1;
        this.f = parcel0.readLong();
        this.g = parcel0.readLong();
        int v = parcel0.readInt();
        ArrayList arrayList0 = new ArrayList(v);
        for(int v1 = 0; v1 < v; ++v1) {
            arrayList0.add(new b(parcel0.readInt(), parcel0.readLong(), parcel0.readLong()));
        }
        this.h = Collections.unmodifiableList(arrayList0);
        if(parcel0.readByte() == 1) {
            z = true;
        }
        this.i = z;
        this.j = parcel0.readLong();
        this.k = parcel0.readInt();
        this.l = parcel0.readInt();
        this.m = parcel0.readInt();
    }

    @Override  // androidx.media3.extractor.metadata.scte35.SpliceCommand
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("SCTE-35 SpliceInsertCommand { programSplicePts=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", programSplicePlaybackPositionUs= ");
        return x.h(this.g, " }", stringBuilder0);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeLong(this.a);
        parcel0.writeByte(((byte)this.b));
        parcel0.writeByte(((byte)this.c));
        parcel0.writeByte(((byte)this.d));
        parcel0.writeByte(((byte)this.e));
        parcel0.writeLong(this.f);
        parcel0.writeLong(this.g);
        List list0 = this.h;
        int v1 = list0.size();
        parcel0.writeInt(v1);
        for(int v2 = 0; v2 < v1; ++v2) {
            b b0 = (b)list0.get(v2);
            parcel0.writeInt(b0.a);
            parcel0.writeLong(b0.b);
            parcel0.writeLong(b0.c);
        }
        parcel0.writeByte(((byte)this.i));
        parcel0.writeLong(this.j);
        parcel0.writeInt(this.k);
        parcel0.writeInt(this.l);
        parcel0.writeInt(this.m);
    }
}

