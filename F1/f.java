package f1;

import V3.d;
import androidx.appcompat.app.o;
import g1.a;

public final class f implements g {
    public final int a;
    public final int b;

    public f(int v, int v1) {
        this.a = v;
        this.b = v1;
        if(v < 0 || v1 < 0) {
            a.a(("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + v + " and " + v1 + " respectively."));
        }
    }

    @Override  // f1.g
    public final void a(d d0) {
        int v = 0;
        int v1 = 0;
        int v2 = 0;
        while(v1 < this.a) {
            int v3 = d0.b;
            if(v3 > v2 + 1) {
                v2 = !Character.isHighSurrogate(d0.e(v3 - v2 - 2)) || !Character.isLowSurrogate(d0.e(d0.b - (v2 + 1))) ? v2 + 1 : v2 + 2;
                ++v1;
            }
            else {
                v2 = v3;
                if(true) {
                    break;
                }
            }
        }
        int v4 = 0;
        while(v < this.b) {
            int v5 = d0.c;
            A3.g g0 = (A3.g)d0.f;
            if(v5 + (v4 + 1) < g0.l()) {
                v4 = !Character.isHighSurrogate(d0.e(d0.c + (v4 + 1) - 1)) || !Character.isLowSurrogate(d0.e(d0.c + (v4 + 1))) ? v4 + 1 : v4 + 2;
                ++v;
            }
            else {
                v4 = g0.l() - d0.c;
                if(true) {
                    break;
                }
            }
        }
        d0.d(d0.c, v4 + d0.c);
        d0.d(d0.b - v2, d0.b);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof f)) {
            return false;
        }
        return this.a == ((f)object0).a ? this.b == ((f)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.a * 0x1F + this.b;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("DeleteSurroundingTextInCodePointsCommand(lengthBeforeCursor=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", lengthAfterCursor=");
        return o.q(stringBuilder0, this.b, ')');
    }
}

