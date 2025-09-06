package f3;

import H4.b;
import java.util.ArrayList;
import java.util.Arrays;

public final class a extends b {
    public final long c;
    public final ArrayList d;
    public final ArrayList e;

    public a(int v, long v1) {
        super(v, 1);
        this.c = v1;
        this.d = new ArrayList();
        this.e = new ArrayList();
    }

    public final a o(int v) {
        ArrayList arrayList0 = this.e;
        int v1 = arrayList0.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            a a0 = (a)arrayList0.get(v2);
            if(a0.b == v) {
                return a0;
            }
        }
        return null;
    }

    public final f3.b p(int v) {
        ArrayList arrayList0 = this.d;
        int v1 = arrayList0.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            f3.b b0 = (f3.b)arrayList0.get(v2);
            if(b0.b == v) {
                return b0;
            }
        }
        return null;
    }

    @Override  // H4.b
    public final String toString() {
        return b.h(this.b) + " leaves: " + Arrays.toString(this.d.toArray()) + " containers: " + Arrays.toString(this.e.toArray());
    }
}

