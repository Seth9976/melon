package i.n.i.b.a.s.e;

import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import com.iloen.melon.utils.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class hf implements b {
    public static final class i.n.i.b.a.s.e.hf.b implements Parcelable {
        public static final Parcelable.Creator CREATOR;
        public final int a;
        public final int b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;

        static {
            i.n.i.b.a.s.e.hf.b.CREATOR = new h4();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public i.n.i.b.a.s.e.hf.b(int v, int v1, String s, String s1, String s2, String s3) {
            this.a = v;
            this.b = v1;
            this.c = s;
            this.d = s1;
            this.e = s2;
            this.f = s3;
        }

        public i.n.i.b.a.s.e.hf.b(Parcel parcel0) {
            this.a = parcel0.readInt();
            this.b = parcel0.readInt();
            this.c = parcel0.readString();
            this.d = parcel0.readString();
            this.e = parcel0.readString();
            this.f = parcel0.readString();
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
                return i.n.i.b.a.s.e.hf.b.class == class0 && this.a == ((i.n.i.b.a.s.e.hf.b)object0).a && this.b == ((i.n.i.b.a.s.e.hf.b)object0).b && TextUtils.equals(this.c, ((i.n.i.b.a.s.e.hf.b)object0).c) && TextUtils.equals(this.d, ((i.n.i.b.a.s.e.hf.b)object0).d) && TextUtils.equals(this.e, ((i.n.i.b.a.s.e.hf.b)object0).e) && TextUtils.equals(this.f, ((i.n.i.b.a.s.e.hf.b)object0).f);
            }
            return false;
        }

        @Override
        public final int hashCode() {
            int v = (this.a * 0x1F + this.b) * 0x1F;
            int v1 = 0;
            int v2 = this.c == null ? 0 : this.c.hashCode();
            int v3 = this.d == null ? 0 : this.d.hashCode();
            int v4 = this.e == null ? 0 : this.e.hashCode();
            String s = this.f;
            if(s != null) {
                v1 = s.hashCode();
            }
            return (((v + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v1;
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(Parcel parcel0, int v) {
            parcel0.writeInt(this.a);
            parcel0.writeInt(this.b);
            parcel0.writeString(this.c);
            parcel0.writeString(this.d);
            parcel0.writeString(this.e);
            parcel0.writeString(this.f);
        }
    }

    public static final Parcelable.Creator CREATOR;
    public final String a;
    public final String b;
    public final List c;

    static {
        hf.CREATOR = new t(10);
    }

    public hf(Parcel parcel0) {
        this.a = parcel0.readString();
        this.b = parcel0.readString();
        int v = parcel0.readInt();
        ArrayList arrayList0 = new ArrayList(v);
        for(int v1 = 0; v1 < v; ++v1) {
            arrayList0.add(((i.n.i.b.a.s.e.hf.b)parcel0.readParcelable(i.n.i.b.a.s.e.hf.b.class.getClassLoader())));
        }
        this.c = Collections.unmodifiableList(arrayList0);
    }

    public hf(String s, String s1, List list0) {
        this.a = s;
        this.b = s1;
        this.c = Collections.unmodifiableList(new ArrayList(list0));
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
            return hf.class == class0 && TextUtils.equals(this.a, ((hf)object0).a) && TextUtils.equals(this.b, ((hf)object0).b) && this.c.equals(((hf)object0).c);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        String s = this.b;
        if(s != null) {
            v = s.hashCode();
        }
        return this.c.hashCode() + (v1 * 0x1F + v) * 0x1F;
    }

    @Override
    public final String toString() {
        return "HlsTrackMetadataEntry" + (this.a == null ? "" : x.m(a.n(" [", this.a, ", "), this.b, "]"));
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        List list0 = this.c;
        int v1 = list0.size();
        parcel0.writeInt(v1);
        for(int v2 = 0; v2 < v1; ++v2) {
            parcel0.writeParcelable(((Parcelable)list0.get(v2)), 0);
        }
    }
}

