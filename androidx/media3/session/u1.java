package androidx.media3.session;

import android.os.Bundle;
import e3.b;
import java.util.Objects;

public final class u1 {
    public final int a;
    public final String b;
    public final Bundle c;
    public static final String d;
    public static final String e;
    public static final String f;

    static {
        u1.d = "0";
        u1.e = "1";
        u1.f = "2";
    }

    public u1(int v, String s) {
        this(s, v, Bundle.EMPTY);
    }

    public u1(String s, int v, Bundle bundle0) {
        b.c(v < 0 || v == 1);
        this.a = v;
        this.b = s;
        this.c = bundle0;
    }

    public static u1 a(Bundle bundle0) {
        int v = bundle0.getInt(u1.d, 1000);
        String s = bundle0.getString(u1.e, "");
        Bundle bundle1 = bundle0.getBundle(u1.f);
        if(bundle1 == null) {
            bundle1 = Bundle.EMPTY;
        }
        return new u1(s, v, bundle1);
    }

    public final Bundle b() {
        Bundle bundle0 = new Bundle();
        bundle0.putInt("0", this.a);
        bundle0.putString("1", this.b);
        Bundle bundle1 = this.c;
        if(!bundle1.isEmpty()) {
            bundle0.putBundle("2", bundle1);
        }
        return bundle0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof u1 ? this.a == ((u1)object0).a && Objects.equals(this.b, ((u1)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(new Object[]{this.a, this.b});
    }
}

