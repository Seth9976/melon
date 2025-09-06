package i.n.i.b.a.s.e;

import H4.b;
import java.util.ArrayList;
import java.util.Arrays;

public final class o0 extends b {
    public final long c;
    public final ArrayList d;
    public final ArrayList e;

    public o0(int v, long v1) {
        super(v, 3);
        this.c = v1;
        this.d = new ArrayList();
        this.e = new ArrayList();
    }

    public final o0 o(int v) {
        ArrayList arrayList0 = this.e;
        int v1 = arrayList0.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            o0 o00 = (o0)arrayList0.get(v2);
            if(o00.b == v) {
                return o00;
            }
        }
        return null;
    }

    public final p0 p(int v) {
        ArrayList arrayList0 = this.d;
        int v1 = arrayList0.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            p0 p00 = (p0)arrayList0.get(v2);
            if(p00.b == v) {
                return p00;
            }
        }
        return null;
    }

    @Override  // H4.b
    public final String toString() {
        return b.b(this.b) + " leaves: " + Arrays.toString(this.d.toArray()) + " containers: " + Arrays.toString(this.e.toArray());
    }
}

