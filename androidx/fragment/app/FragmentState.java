package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final String a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final int e;
    public final int f;
    public final String g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final int l;
    public final String m;
    public final int n;
    public final boolean o;

    static {
        FragmentState.CREATOR = new b(4);
    }

    public FragmentState(Parcel parcel0) {
        this.a = parcel0.readString();
        this.b = parcel0.readString();
        boolean z = false;
        this.c = parcel0.readInt() != 0;
        this.d = parcel0.readInt() != 0;
        this.e = parcel0.readInt();
        this.f = parcel0.readInt();
        this.g = parcel0.readString();
        this.h = parcel0.readInt() != 0;
        this.i = parcel0.readInt() != 0;
        this.j = parcel0.readInt() != 0;
        this.k = parcel0.readInt() != 0;
        this.l = parcel0.readInt();
        this.m = parcel0.readString();
        this.n = parcel0.readInt();
        if(parcel0.readInt() != 0) {
            z = true;
        }
        this.o = z;
    }

    public FragmentState(I i0) {
        this.a = i0.getClass().getName();
        this.b = i0.mWho;
        this.c = i0.mFromLayout;
        this.d = i0.mInDynamicContainer;
        this.e = i0.mFragmentId;
        this.f = i0.mContainerId;
        this.g = i0.mTag;
        this.h = i0.mRetainInstance;
        this.i = i0.mRemoving;
        this.j = i0.mDetached;
        this.k = i0.mHidden;
        this.l = i0.mMaxState.ordinal();
        this.m = i0.mTargetWho;
        this.n = i0.mTargetRequestCode;
        this.o = i0.mUserVisibleHint;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder(0x80);
        stringBuilder0.append("FragmentState{");
        stringBuilder0.append(this.a);
        stringBuilder0.append(" (");
        stringBuilder0.append(this.b);
        stringBuilder0.append(")}:");
        if(this.c) {
            stringBuilder0.append(" fromLayout");
        }
        if(this.d) {
            stringBuilder0.append(" dynamicContainer");
        }
        int v = this.f;
        if(v != 0) {
            stringBuilder0.append(" id=0x");
            stringBuilder0.append(Integer.toHexString(v));
        }
        String s = this.g;
        if(s != null && !s.isEmpty()) {
            stringBuilder0.append(" tag=");
            stringBuilder0.append(s);
        }
        if(this.h) {
            stringBuilder0.append(" retainInstance");
        }
        if(this.i) {
            stringBuilder0.append(" removing");
        }
        if(this.j) {
            stringBuilder0.append(" detached");
        }
        if(this.k) {
            stringBuilder0.append(" hidden");
        }
        String s1 = this.m;
        if(s1 != null) {
            stringBuilder0.append(" targetWho=");
            stringBuilder0.append(s1);
            stringBuilder0.append(" targetRequestCode=");
            stringBuilder0.append(this.n);
        }
        if(this.o) {
            stringBuilder0.append(" userVisibleHint");
        }
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        parcel0.writeInt(((int)this.c));
        parcel0.writeInt(((int)this.d));
        parcel0.writeInt(this.e);
        parcel0.writeInt(this.f);
        parcel0.writeString(this.g);
        parcel0.writeInt(((int)this.h));
        parcel0.writeInt(((int)this.i));
        parcel0.writeInt(((int)this.j));
        parcel0.writeInt(((int)this.k));
        parcel0.writeInt(this.l);
        parcel0.writeString(this.m);
        parcel0.writeInt(this.n);
        parcel0.writeInt(((int)this.o));
    }
}

