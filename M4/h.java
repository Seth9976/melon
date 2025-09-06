package m4;

import android.util.SparseBooleanArray;
import androidx.collection.f;
import java.util.ArrayList;
import java.util.List;

public final class h {
    public final List a;
    public final List b;
    public final f c;
    public final SparseBooleanArray d;
    public final g e;
    public static final c f;

    static {
        h.f = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public h(List list0, ArrayList arrayList0) {
        this.a = list0;
        this.b = arrayList0;
        this.d = new SparseBooleanArray();
        this.c = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        int v1 = list0.size();
        int v2 = 0x80000000;
        g g0 = null;
        for(int v = 0; v < v1; ++v) {
            g g1 = (g)list0.get(v);
            int v3 = g1.e;
            if(v3 > v2) {
                g0 = g1;
                v2 = v3;
            }
        }
        this.e = g0;
    }

    public final g a(i i0) {
        return (g)this.c.get(i0);
    }
}

