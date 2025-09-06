package d3;

import android.os.Bundle;
import android.text.Spanned;

public abstract class d {
    public static final String a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final String e;

    static {
        d.a = "0";
        d.b = "1";
        d.c = "2";
        d.d = "3";
        d.e = "4";
    }

    public static Bundle a(Spanned spanned0, Object object0, int v, Bundle bundle0) {
        Bundle bundle1 = new Bundle();
        int v1 = spanned0.getSpanStart(object0);
        bundle1.putInt(d.a, v1);
        int v2 = spanned0.getSpanEnd(object0);
        bundle1.putInt(d.b, v2);
        int v3 = spanned0.getSpanFlags(object0);
        bundle1.putInt(d.c, v3);
        bundle1.putInt(d.d, v);
        if(bundle0 != null) {
            bundle1.putBundle(d.e, bundle0);
        }
        return bundle1;
    }
}

