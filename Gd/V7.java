package gd;

import com.melon.ui.K4;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.q;
import we.k;

public final class v7 implements k {
    public final h7 a;
    public final boolean b;
    public final List c;
    public final ArrayList d;
    public final boolean e;
    public final String f;
    public final List g;

    public v7(h7 h70, boolean z, List list0, ArrayList arrayList0, boolean z1, String s, List list1) {
        this.a = h70;
        this.b = z;
        this.c = list0;
        this.d = arrayList0;
        this.e = z1;
        this.f = s;
        this.g = list1;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((K4)object0), "it");
        return h7.a(this.a, true, this.b, this.c, this.d, this.e, this.f, this.g, 0, 0x110);
    }
}

