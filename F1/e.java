package f1;

import V3.d;
import androidx.appcompat.app.o;
import g1.a;

public final class e implements g {
    public final int a;
    public final int b;

    public e(int v, int v1) {
        this.a = v;
        this.b = v1;
        if(v < 0 || v1 < 0) {
            a.a(("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + v + " and " + v1 + " respectively."));
        }
    }

    @Override  // f1.g
    public final void a(d d0) {
        int v = d0.c;
        A3.g g0 = (A3.g)d0.f;
        int v1 = v + this.b;
        v1 = ((v ^ v1) & (this.b ^ v1)) >= 0 ? v + this.b : g0.l();
        d0.d(d0.c, Math.min(v1, g0.l()));
        d0.d(Math.max(0, (((d0.b ^ d0.b - this.a) & (this.a ^ d0.b)) >= 0 ? d0.b - this.a : 0)), d0.b);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof e)) {
            return false;
        }
        return this.a == ((e)object0).a ? this.b == ((e)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.a * 0x1F + this.b;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("DeleteSurroundingTextCommand(lengthBeforeCursor=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", lengthAfterCursor=");
        return o.q(stringBuilder0, this.b, ')');
    }
}

