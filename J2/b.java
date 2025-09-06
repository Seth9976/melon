package j2;

import android.graphics.Rect;
import d2.d;
import e3.h;
import java.util.Comparator;

public final class b implements Comparator {
    public final Rect a;
    public final Rect b;
    public final boolean c;
    public final h d;

    public b(boolean z, h h0) {
        this.a = new Rect();
        this.b = new Rect();
        this.c = z;
        this.d = h0;
    }

    @Override
    public final int compare(Object object0, Object object1) {
        this.d.getClass();
        Rect rect0 = this.a;
        ((d)object0).f(rect0);
        Rect rect1 = this.b;
        ((d)object1).f(rect1);
        int v = rect0.top;
        int v1 = rect1.top;
        if(v >= v1) {
            if(v > v1) {
                return 1;
            }
            int v2 = rect0.left;
            int v3 = rect1.left;
            boolean z = this.c;
            if(v2 < v3) {
                return z ? 1 : -1;
            }
            if(v2 > v3) {
                return z ? -1 : 1;
            }
            int v4 = rect0.bottom;
            int v5 = rect1.bottom;
            if(v4 >= v5) {
                if(v4 <= v5) {
                    int v6 = rect0.right;
                    int v7 = rect1.right;
                    if(v6 < v7) {
                        return z ? 1 : -1;
                    }
                    if(v6 > v7) {
                        return z ? -1 : 1;
                    }
                    return 0;
                }
                return 1;
            }
        }
        return -1;
    }
}

