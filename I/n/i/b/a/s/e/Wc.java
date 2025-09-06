package i.n.i.b.a.s.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.Arrays;

public final class wc implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final int a;
    public final vc[] b;
    public int c;
    public static final wc d;

    static {
        wc.d = new wc(new vc[0]);
        wc.CREATOR = new Tc(2);
    }

    public wc(Parcel parcel0) {
        int v = parcel0.readInt();
        this.a = v;
        this.b = new vc[v];
        for(int v1 = 0; v1 < this.a; ++v1) {
            this.b[v1] = (vc)parcel0.readParcelable(vc.class.getClassLoader());
        }
    }

    public wc(vc[] arr_vc) {
        this.b = arr_vc;
        this.a = arr_vc.length;
    }

    public final int a(vc vc0) {
        for(int v = 0; v < this.a; ++v) {
            if(this.b[v] == vc0) {
                return v;
            }
        }
        return -1;
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
            return wc.class == class0 && this.a == ((wc)object0).a && Arrays.equals(this.b, ((wc)object0).b);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        if(this.c == 0) {
            this.c = Arrays.hashCode(this.b);
        }
        return this.c;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = this.a;
        parcel0.writeInt(v1);
        for(int v2 = 0; v2 < v1; ++v2) {
            parcel0.writeParcelable(this.b[v2], 0);
        }
    }
}

