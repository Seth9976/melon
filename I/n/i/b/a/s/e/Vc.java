package i.n.i.b.a.s.e;

import A7.d;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.Arrays;

public final class vc implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final int a;
    public final u[] b;
    public int c;

    static {
        vc.CREATOR = new t(28);
    }

    public vc(Parcel parcel0) {
        int v = parcel0.readInt();
        this.a = v;
        this.b = new u[v];
        for(int v1 = 0; v1 < this.a; ++v1) {
            this.b[v1] = (u)parcel0.readParcelable(u.class.getClassLoader());
        }
    }

    public vc(u[] arr_u) {
        M7.J(arr_u.length > 0);
        this.b = arr_u;
        this.a = arr_u.length;
        String s = arr_u[0].c;
        if(s == null || s.equals("und")) {
            s = "";
        }
        int v1 = arr_u[0].e | 0x4000;
        for(int v = 1; v < arr_u.length; ++v) {
            String s1 = arr_u[v].c;
            if(s1 == null || s1.equals("und")) {
                s1 = "";
            }
            if(!s.equals(s1)) {
                vc.b(v, "languages", arr_u[0].c, arr_u[v].c);
                return;
            }
            if(v1 != (arr_u[v].e | 0x4000)) {
                vc.b(v, "role flags", Integer.toBinaryString(arr_u[0].e), Integer.toBinaryString(arr_u[v].e));
                return;
            }
        }
    }

    public final int a(u u0) {
        for(int v = 0; true; ++v) {
            u[] arr_u = this.b;
            if(v >= arr_u.length) {
                break;
            }
            if(u0 == arr_u[v]) {
                return v;
            }
        }
        return -1;
    }

    public static void b(int v, String s, String s1, String s2) {
        StringBuilder stringBuilder0 = d.o("Different ", s, " combined in one TrackGroup: \'", s1, "\' (track 0) and \'");
        stringBuilder0.append(s2);
        stringBuilder0.append("\' (track ");
        stringBuilder0.append(v);
        stringBuilder0.append(")");
        M7.H("TrackGroup", "", new IllegalStateException(stringBuilder0.toString()));
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
            return vc.class == class0 && this.a == ((vc)object0).a && Arrays.equals(this.b, ((vc)object0).b);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        if(this.c == 0) {
            this.c = Arrays.hashCode(this.b) + 0x20F;
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

