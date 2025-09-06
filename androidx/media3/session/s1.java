package androidx.media3.session;

import I6.V;
import I6.p0;
import I6.w;
import android.os.Bundle;
import android.text.TextUtils;
import e3.b;
import java.util.Arrays;

public final class s1 {
    public final int a;
    public final String b;
    public final Bundle c;
    public static final p0 d;
    public static final p0 e;
    public static final String f;
    public static final String g;
    public static final String h;

    static {
        s1.d = V.t(40010);
        Object[] arr_object = {50000, 50001, 50002, 50003, 50004, 50005, 50006};
        w.a(7, arr_object);
        s1.e = V.l(7, arr_object);
        s1.f = "0";
        s1.g = "1";
        s1.h = "2";
    }

    public s1(int v) {
        b.d(v != 0, "commandCode shouldn\'t be COMMAND_CODE_CUSTOM");
        this.a = v;
        this.b = "";
        this.c = Bundle.EMPTY;
    }

    public s1(String s, Bundle bundle0) {
        this.a = 0;
        s.getClass();
        this.b = s;
        bundle0.getClass();
        this.c = new Bundle(bundle0);
    }

    public static s1 a(Bundle bundle0) {
        int v = bundle0.getInt("0", 0);
        if(v != 0) {
            return new s1(v);
        }
        String s = bundle0.getString("1");
        s.getClass();
        Bundle bundle1 = bundle0.getBundle("2");
        if(bundle1 == null) {
            bundle1 = Bundle.EMPTY;
        }
        return new s1(s, bundle1);
    }

    public final Bundle b() {
        Bundle bundle0 = new Bundle();
        bundle0.putInt("0", this.a);
        bundle0.putString("1", this.b);
        bundle0.putBundle("2", this.c);
        return bundle0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof s1 ? this.a == ((s1)object0).a && TextUtils.equals(this.b, ((s1)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.a});
    }
}

