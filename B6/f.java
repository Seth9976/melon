package B6;

import android.os.Handler;
import android.os.Looper;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import i.n.i.b.a.s.e.C2;
import i.n.i.b.a.s.e.Ja;
import i.n.i.b.a.s.e.ee;
import i.n.i.b.a.s.e.j3;
import java.util.HashMap;

public final class f implements j3 {
    public Object a;
    public static f b;

    public f(int v) {
        if(v != 3) {
            super();
            this.a = new Object();
            new Handler(Looper.getMainLooper(), new e(this, 0));
            return;
        }
        super();
        this.a = new Object();
    }

    public f(Object object0) {
        this.a = object0;
        super();
    }

    public static ee a(Ja ja0) {
        new d5.e(11);
        ja0.getClass();
        new HashMap();
        throw null;
    }

    @Override  // i.n.i.b.a.s.e.j3
    public C2 b(i.n.i.b.a.s.e.e e0) {
        e0.b.getClass();
        e0.b.getClass();
        return C2.a;
    }

    public static f c(int v, int v1, int v2, int v3, boolean z, boolean z1) {
        return new f(AccessibilityNodeInfo.CollectionItemInfo.obtain(v, v1, v2, v3, z, z1));
    }

    public static f d(int v, int v1, int v2, boolean z) {
        return new f(AccessibilityNodeInfo.CollectionInfo.obtain(v, v1, z, v2));
    }
}

