package androidx.fragment.app;

import N4.v;
import android.view.View;
import java.util.ArrayList;
import kotlin.jvm.internal.q;

public abstract class z0 {
    public static final E0 a;
    public static final G0 b;

    static {
        z0.a = new E0();  // 初始化器: Ljava/lang/Object;-><init>()V
        G0 g00 = null;
        try {
            g00 = new v();
        }
        catch(Exception unused_ex) {
        }
        z0.b = g00;
    }

    public static final void a(int v, ArrayList arrayList0) {
        q.g(arrayList0, "views");
        for(Object object0: arrayList0) {
            ((View)object0).setVisibility(v);
        }
    }
}

