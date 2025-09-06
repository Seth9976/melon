package androidx.media3.common;

import R3.e;
import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import b3.H;
import b3.h;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;

public final class DrmInitData implements Parcelable, Comparator {
    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator CREATOR;
        public int a;
        public final UUID b;
        public final String c;
        public final String d;
        public final byte[] e;

        static {
            SchemeData.CREATOR = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public SchemeData(Parcel parcel0) {
            this.b = new UUID(parcel0.readLong(), parcel0.readLong());
            this.c = parcel0.readString();
            this.d = parcel0.readString();
            this.e = parcel0.createByteArray();
        }

        public SchemeData(UUID uUID0, String s, String s1, byte[] arr_b) {
            uUID0.getClass();
            this.b = uUID0;
            this.c = s;
            s1.getClass();
            this.d = H.l(s1);
            this.e = arr_b;
        }

        // 去混淆评级： 低(20)
        public final boolean a(UUID uUID0) {
            return h.a.equals(this.b) || uUID0.equals(this.b);
        }

        @Override  // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        // 去混淆评级： 低(20)
        @Override
        public final boolean equals(Object object0) {
            if(!(object0 instanceof SchemeData)) {
                return false;
            }
            return object0 == this ? true : Objects.equals(this.c, ((SchemeData)object0).c) && Objects.equals(this.d, ((SchemeData)object0).d) && Objects.equals(this.b, ((SchemeData)object0).b) && Arrays.equals(this.e, ((SchemeData)object0).e);
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
    public final SchemeData[] a;
    public int b;
    public final String c;
    public final int d;

    static {
        DrmInitData.CREATOR = new e(2);
    }

    public DrmInitData(Parcel parcel0) {
        this.c = parcel0.readString();
        SchemeData[] arr_drmInitData$SchemeData = (SchemeData[])parcel0.createTypedArray(SchemeData.CREATOR);
        this.a = arr_drmInitData$SchemeData;
        this.d = arr_drmInitData$SchemeData.length;
    }

    public DrmInitData(String s, boolean z, SchemeData[] arr_drmInitData$SchemeData) {
        this.c = s;
        if(z) {
            arr_drmInitData$SchemeData = (SchemeData[])arr_drmInitData$SchemeData.clone();
        }
        this.a = arr_drmInitData$SchemeData;
        this.d = arr_drmInitData$SchemeData.length;
        Arrays.sort(arr_drmInitData$SchemeData, this);
    }

    // 去混淆评级： 低(20)
    public final DrmInitData a(String s) {
        return Objects.equals(this.c, s) ? this : new DrmInitData(s, false, this.a);
    }

    @Override
    public final int compare(Object object0, Object object1) {
        UUID uUID0 = h.a;
        if(uUID0.equals(((SchemeData)object0).b)) {
            return uUID0.equals(((SchemeData)object1).b) ? 0 : 1;
        }
        return ((SchemeData)object0).b.compareTo(((SchemeData)object1).b);
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
            return DrmInitData.class == class0 && Objects.equals(this.c, ((DrmInitData)object0).c) && Arrays.equals(this.a, ((DrmInitData)object0).a);
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

