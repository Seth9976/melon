package b3;

import A7.d;
import I6.p0;
import U4.x;
import android.os.Bundle;
import androidx.media3.common.b;
import java.util.ArrayList;
import java.util.Arrays;

public final class q0 {
    public final int a;
    public final String b;
    public final int c;
    public final b[] d;
    public int e;
    public static final String f;
    public static final String g;

    static {
        q0.f = "0";
        q0.g = "1";
    }

    public q0(String s, b[] arr_b) {
        e3.b.c(arr_b.length > 0);
        this.b = s;
        this.d = arr_b;
        this.a = arr_b.length;
        int v1 = H.g(arr_b[0].n);
        if(v1 == -1) {
            v1 = H.g(arr_b[0].m);
        }
        this.c = v1;
        String s1 = arr_b[0].d;
        if(s1 == null || s1.equals("und")) {
            s1 = "";
        }
        int v2 = arr_b[0].f | 0x4000;
        for(int v = 1; v < arr_b.length; ++v) {
            String s2 = arr_b[v].d;
            if(s2 == null || s2.equals("und")) {
                s2 = "";
            }
            if(!s1.equals(s2)) {
                q0.c(v, "languages", arr_b[0].d, arr_b[v].d);
                return;
            }
            if(v2 != (arr_b[v].f | 0x4000)) {
                q0.c(v, "role flags", Integer.toBinaryString(arr_b[0].f), Integer.toBinaryString(arr_b[v].f));
                return;
            }
        }
    }

    public static q0 a(Bundle bundle0) {
        ArrayList arrayList0 = bundle0.getParcelableArrayList(q0.f);
        if(arrayList0 == null) {
            return new q0(bundle0.getString("1", ""), ((b[])p0.e.toArray(new b[0])));
        }
        p0 p00 = e3.b.r(new z(5), arrayList0);
        return new q0(bundle0.getString("1", ""), ((b[])p00.toArray(new b[0])));
    }

    public final int b(b b0) {
        for(int v = 0; true; ++v) {
            b[] arr_b = this.d;
            if(v >= arr_b.length) {
                break;
            }
            if(b0 == arr_b[v]) {
                return v;
            }
        }
        return -1;
    }

    public static void c(int v, String s, String s1, String s2) {
        StringBuilder stringBuilder0 = d.o("Different ", s, " combined in one TrackGroup: \'", s1, "\' (track 0) and \'");
        stringBuilder0.append(s2);
        stringBuilder0.append("\' (track ");
        stringBuilder0.append(v);
        stringBuilder0.append(")");
        e3.b.q("TrackGroup", "", new IllegalStateException(stringBuilder0.toString()));
    }

    public final Bundle d() {
        Bundle bundle0 = new Bundle();
        b[] arr_b = this.d;
        ArrayList arrayList0 = new ArrayList(arr_b.length);
        for(int v = 0; v < arr_b.length; ++v) {
            arrayList0.add(arr_b[v].c(true));
        }
        bundle0.putParcelableArrayList(q0.f, arrayList0);
        bundle0.putString("1", this.b);
        return bundle0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return q0.class == class0 && this.b.equals(((q0)object0).b) && Arrays.equals(this.d, ((q0)object0).d);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        if(this.e == 0) {
            this.e = Arrays.hashCode(this.d) + x.b(0x20F, 0x1F, this.b);
        }
        return this.e;
    }
}

