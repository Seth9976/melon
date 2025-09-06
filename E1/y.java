package e1;

import androidx.appcompat.app.o;
import e.k;
import g1.a;
import java.util.List;
import kotlin.jvm.internal.q;

public final class y implements Comparable {
    public final int a;
    public static final y b;
    public static final y c;
    public static final y d;
    public static final y e;
    public static final y f;
    public static final y g;
    public static final y h;
    public static final y i;
    public static final List j;

    static {
        y y0 = new y(100);
        y y1 = new y(200);
        y y2 = new y(300);
        y y3 = new y(400);
        y.b = y3;
        y y4 = new y(500);
        y.c = y4;
        y y5 = new y(600);
        y.d = y5;
        y y6 = new y(700);
        y y7 = new y(800);
        y y8 = new y(900);
        y.e = y2;
        y.f = y3;
        y.g = y4;
        y.h = y5;
        y.i = y6;
        y.j = k.A(new y[]{y0, y1, y2, y3, y4, y5, y6, y7, y8});
    }

    public y(int v) {
        this.a = v;
        if(1 > v || v >= 1001) {
            a.a(("Font weight can be in range [1, 1000]. Current value: " + v));
        }
    }

    public final int a(y y0) {
        return q.h(this.a, y0.a);
    }

    @Override
    public final int compareTo(Object object0) {
        return this.a(((y)object0));
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof y ? this.a == ((y)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return o.q(new StringBuilder("FontWeight(weight="), this.a, ')');
    }
}

