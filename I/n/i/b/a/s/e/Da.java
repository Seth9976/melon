package i.n.i.b.a.s.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import k8.Y;

public final class da implements b {
    public static final class i.n.i.b.a.s.e.da.b implements Parcelable {
        public static final Parcelable.Creator CREATOR;
        public final long a;
        public final long b;
        public final int c;

        static {
            i.n.i.b.a.s.e.da.b.CREATOR = new m1();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public i.n.i.b.a.s.e.da.b(long v, long v1, int v2) {
            M7.u(v < v1);
            this.a = v;
            this.b = v1;
            this.c = v2;
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
                return i.n.i.b.a.s.e.da.b.class == class0 && this.a == ((i.n.i.b.a.s.e.da.b)object0).a && this.b == ((i.n.i.b.a.s.e.da.b)object0).b && this.c == ((i.n.i.b.a.s.e.da.b)object0).c;
            }
            return false;
        }

        @Override
        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.a, this.b, this.c});
        }

        @Override
        public final String toString() {
            StringBuilder stringBuilder0 = Y.o(this.a, "Segment: startTimeMs=", ", endTimeMs=");
            stringBuilder0.append(this.b);
            stringBuilder0.append(", speedDivisor=");
            stringBuilder0.append(this.c);
            return stringBuilder0.toString();
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(Parcel parcel0, int v) {
            parcel0.writeLong(this.a);
            parcel0.writeLong(this.b);
            parcel0.writeInt(this.c);
        }
    }

    public static final Parcelable.Creator CREATOR;
    public final ArrayList a;

    static {
        da.CREATOR = new l1();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public da(ArrayList arrayList0) {
        this.a = arrayList0;
        int v = 0;
        if(!arrayList0.isEmpty()) {
            long v1 = ((i.n.i.b.a.s.e.da.b)arrayList0.get(0)).b;
            for(int v2 = 1; v2 < arrayList0.size(); ++v2) {
                if(((i.n.i.b.a.s.e.da.b)arrayList0.get(v2)).a < v1) {
                    v = 1;
                    break;
                }
                v1 = ((i.n.i.b.a.s.e.da.b)arrayList0.get(v2)).b;
            }
        }
        M7.u(((boolean)(v ^ 1)));
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
            return da.class == class0 ? this.a.equals(((da)object0).a) : false;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "SlowMotion: segments=" + this.a;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeList(this.a);
    }
}

