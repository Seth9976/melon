package i.n.i.b.a.s.e;

import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;

public final class c3 implements Parcelable, Comparator {
    public static final class b implements Parcelable {
        public static final Parcelable.Creator CREATOR;
        public int a;
        public final UUID b;
        public final String c;
        public final String d;
        public final byte[] e;

        static {
            b.CREATOR = new m0();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public b(Parcel parcel0) {
            this.b = new UUID(parcel0.readLong(), parcel0.readLong());
            this.c = parcel0.readString();
            this.d = parcel0.readString();
            this.e = parcel0.createByteArray();
        }

        public b(UUID uUID0, String s, String s1, byte[] arr_b) {
            uUID0.getClass();
            this.b = uUID0;
            this.c = s;
            s1.getClass();
            this.d = s1;
            this.e = arr_b;
        }

        // 去混淆评级： 低(20)
        public final boolean a(UUID uUID0) {
            return b4.a.equals(this.b) || uUID0.equals(this.b);
        }

        public final boolean d() {
            return this.e != null;
        }

        @Override  // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        // 去混淆评级： 低(20)
        @Override
        public final boolean equals(Object object0) {
            if(!(object0 instanceof b)) {
                return false;
            }
            return object0 == this ? true : L7.p(this.c, ((b)object0).c) && L7.p(this.d, ((b)object0).d) && L7.p(this.b, ((b)object0).b) && Arrays.equals(this.e, ((b)object0).e);
        }

        @Override
        public final int hashCode() {
            if(this.a == 0) {
                this.a = Arrays.hashCode(this.e) + x.b((this.b.hashCode() * 0x1F + (this.c == null ? 0 : this.c.hashCode())) * 0x1F, 0x1F, this.d);
            }
            return this.a;
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(Parcel parcel0, int v) {
            parcel0.writeLong(this.b.getMostSignificantBits());
            parcel0.writeLong(this.b.getLeastSignificantBits());
            parcel0.writeString(this.c);
            parcel0.writeString(this.d);
            parcel0.writeByteArray(this.e);
        }
    }

    public static final Parcelable.Creator CREATOR;
    public final b[] a;
    public int b;
    public final String c;
    public final int d;

    static {
        c3.CREATOR = new t(2);
    }

    public c3(Parcel parcel0) {
        this.c = parcel0.readString();
        b[] arr_c3$b = (b[])parcel0.createTypedArray(b.CREATOR);
        this.a = arr_c3$b;
        this.d = arr_c3$b.length;
    }

    public c3(String s, ArrayList arrayList0) {
        this(s, false, ((b[])arrayList0.toArray(new b[0])));
    }

    public c3(String s, boolean z, b[] arr_c3$b) {
        this.c = s;
        if(z) {
            arr_c3$b = (b[])arr_c3$b.clone();
        }
        this.a = arr_c3$b;
        this.d = arr_c3$b.length;
        Arrays.sort(arr_c3$b, this);
    }

    public c3(b[] arr_c3$b) {
        this(null, true, arr_c3$b);
    }

    // 去混淆评级： 低(20)
    public final c3 a(String s) {
        return L7.p(this.c, s) ? this : new c3(s, false, this.a);
    }

    @Override
    public final int compare(Object object0, Object object1) {
        UUID uUID0 = b4.a;
        if(uUID0.equals(((b)object0).b)) {
            return uUID0.equals(((b)object1).b) ? 0 : 1;
        }
        return ((b)object0).b.compareTo(((b)object1).b);
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
            return c3.class == class0 && L7.p(this.c, ((c3)object0).c) && Arrays.equals(this.a, ((c3)object0).a);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        if(this.b == 0) {
            this.b = (this.c == null ? 0 : this.c.hashCode()) * 0x1F + Arrays.hashCode(this.a);
        }
        return this.b;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.c);
        parcel0.writeTypedArray(this.a, 0);
    }
}

