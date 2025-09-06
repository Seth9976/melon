package i.n.i.b.a.s.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;

public final class x8 implements Parcelable {
    public interface b extends Parcelable {
        default void V(L l0) {
        }

        default byte[] b() {
            return null;
        }

        default u c() {
            return null;
        }
    }

    public static final Parcelable.Creator CREATOR;
    public final b[] a;

    static {
        x8.CREATOR = new Tc(3);
    }

    public x8(Parcel parcel0) {
        this.a = new b[parcel0.readInt()];
        for(int v = 0; true; ++v) {
            b[] arr_x8$b = this.a;
            if(v >= arr_x8$b.length) {
                break;
            }
            arr_x8$b[v] = (b)parcel0.readParcelable(b.class.getClassLoader());
        }
    }

    public x8(ArrayList arrayList0) {
        this.a = (b[])arrayList0.toArray(new b[0]);
    }

    public x8(b[] arr_x8$b) {
        this.a = arr_x8$b;
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
            return x8.class == class0 ? Arrays.equals(this.a, ((x8)object0).a) : false;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return "entries=" + Arrays.toString(this.a);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        b[] arr_x8$b = this.a;
        parcel0.writeInt(arr_x8$b.length);
        for(int v1 = 0; v1 < arr_x8$b.length; ++v1) {
            parcel0.writeParcelable(arr_x8$b[v1], 0);
        }
    }
}

