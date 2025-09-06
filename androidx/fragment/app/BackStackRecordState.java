package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
final class BackStackRecordState implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final int[] a;
    public final ArrayList b;
    public final int[] c;
    public final int[] d;
    public final int e;
    public final String f;
    public final int g;
    public final int h;
    public final CharSequence i;
    public final int j;
    public final CharSequence k;
    public final ArrayList l;
    public final ArrayList m;
    public final boolean n;

    static {
        BackStackRecordState.CREATOR = new b(0);
    }

    public BackStackRecordState(Parcel parcel0) {
        this.a = parcel0.createIntArray();
        this.b = parcel0.createStringArrayList();
        this.c = parcel0.createIntArray();
        this.d = parcel0.createIntArray();
        this.e = parcel0.readInt();
        this.f = parcel0.readString();
        this.g = parcel0.readInt();
        this.h = parcel0.readInt();
        Parcelable.Creator parcelable$Creator0 = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.i = (CharSequence)parcelable$Creator0.createFromParcel(parcel0);
        this.j = parcel0.readInt();
        this.k = (CharSequence)parcelable$Creator0.createFromParcel(parcel0);
        this.l = parcel0.createStringArrayList();
        this.m = parcel0.createStringArrayList();
        this.n = parcel0.readInt() != 0;
    }

    public BackStackRecordState(a a0) {
        int v = a0.a.size();
        this.a = new int[v * 6];
        if(!a0.g) {
            throw new IllegalStateException("Not on back stack");
        }
        this.b = new ArrayList(v);
        this.c = new int[v];
        this.d = new int[v];
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            x0 x00 = (x0)a0.a.get(v1);
            this.a[v2] = x00.a;
            this.b.add((x00.b == null ? null : x00.b.mWho));
            this.a[v2 + 1] = x00.c;
            this.a[v2 + 2] = x00.d;
            this.a[v2 + 3] = x00.e;
            int v3 = v2 + 5;
            this.a[v2 + 4] = x00.f;
            v2 += 6;
            this.a[v3] = x00.g;
            this.c[v1] = x00.h.ordinal();
            this.d[v1] = x00.i.ordinal();
        }
        this.e = a0.f;
        this.f = a0.i;
        this.g = a0.t;
        this.h = a0.j;
        this.i = a0.k;
        this.j = a0.l;
        this.k = a0.m;
        this.l = a0.n;
        this.m = a0.o;
        this.n = a0.p;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeIntArray(this.a);
        parcel0.writeStringList(this.b);
        parcel0.writeIntArray(this.c);
        parcel0.writeIntArray(this.d);
        parcel0.writeInt(this.e);
        parcel0.writeString(this.f);
        parcel0.writeInt(this.g);
        parcel0.writeInt(this.h);
        TextUtils.writeToParcel(this.i, parcel0, 0);
        parcel0.writeInt(this.j);
        TextUtils.writeToParcel(this.k, parcel0, 0);
        parcel0.writeStringList(this.l);
        parcel0.writeStringList(this.m);
        parcel0.writeInt(((int)this.n));
    }
}

