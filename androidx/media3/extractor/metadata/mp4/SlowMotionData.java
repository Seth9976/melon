package androidx.media3.extractor.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import androidx.media3.common.Metadata.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import k8.Y;

public final class SlowMotionData implements Entry {
    public static final class Segment implements Parcelable {
        public static final Parcelable.Creator CREATOR;
        public final long a;
        public final long b;
        public final int c;

        static {
            Segment.CREATOR = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public Segment(long v, long v1, int v2) {
            e3.b.c(v < v1);
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
                return Segment.class == class0 && this.a == ((Segment)object0).a && this.b == ((Segment)object0).b && this.c == ((Segment)object0).c;
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
        SlowMotionData.CREATOR = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public SlowMotionData(ArrayList arrayList0) {
        this.a = arrayList0;
        int v = 0;
        if(!arrayList0.isEmpty()) {
            long v1 = ((Segment)arrayList0.get(0)).b;
            for(int v2 = 1; v2 < arrayList0.size(); ++v2) {
                if(((Segment)arrayList0.get(v2)).a < v1) {
                    v = 1;
                    break;
                }
                v1 = ((Segment)arrayList0.get(v2)).b;
            }
        }
        e3.b.c(((boolean)(v ^ 1)));
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
            return SlowMotionData.class == class0 ? this.a.equals(((SlowMotionData)object0).a) : false;
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

