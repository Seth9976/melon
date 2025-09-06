package Y3;

import I6.S;
import I6.V;
import I6.m0;
import I6.p0;
import I6.v;
import e3.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class b implements d {
    public final V a;
    public final long[] b;
    public static final v c;

    static {
        b.c = new v(new T7.b(16), m0.a);
    }

    public b(p0 p00) {
        int v = p00.d;
        int v1 = 0;
        if(v == 1) {
            S s0 = p00.r(0);
            Object object0 = s0.next();
            if(!s0.hasNext()) {
                long v2 = ((a)object0).b;
                V v3 = ((a)object0).a;
                long v4 = ((a)object0).c;
                long v5 = v2 == 0x8000000000000001L ? 0L : v2;
                if(v4 == 0x8000000000000001L) {
                    this.a = V.t(v3);
                    this.b = new long[]{v5};
                    return;
                }
                this.a = V.u(v3, p0.e);
                this.b = new long[]{v5, v4 + v5};
                return;
            }
            StringBuilder stringBuilder0 = new StringBuilder("expected one element but was: <");
            stringBuilder0.append(object0);
            while(v1 < 4 && s0.hasNext()) {
                stringBuilder0.append(", ");
                stringBuilder0.append(s0.next());
                ++v1;
            }
            if(s0.hasNext()) {
                stringBuilder0.append(", ...");
            }
            stringBuilder0.append('>');
            throw new IllegalArgumentException(stringBuilder0.toString());
        }
        long[] arr_v = new long[v * 2];
        this.b = arr_v;
        Arrays.fill(arr_v, 0x7FFFFFFFFFFFFFFFL);
        ArrayList arrayList0 = new ArrayList();
        p0 p01 = V.w(b.c, p00);
        int v6 = 0;
        while(v1 < p01.d) {
            a a0 = (a)p01.get(v1);
            long v7 = a0.b;
            long v8 = a0.c;
            V v9 = a0.a;
            if(v7 == 0x8000000000000001L) {
                v7 = 0L;
            }
            if(v6 == 0) {
                this.b[v6] = v7;
                arrayList0.add(v9);
                ++v6;
            }
            else {
                int v10 = Long.compare(this.b[v6 - 1], v7);
                if(v10 >= 0) {
                    if(v10 != 0 || !((V)arrayList0.get(v6 - 1)).isEmpty()) {
                        e3.b.D("CuesWithTimingSubtitle", "Truncating unsupported overlapping cues.");
                        this.b[v6 - 1] = v7;
                    }
                    arrayList0.set(v6 - 1, v9);
                }
            }
            if(v8 != 0x8000000000000001L) {
                this.b[v6] = v7 + v8;
                arrayList0.add(p0.e);
                ++v6;
            }
            ++v1;
        }
        this.a = V.p(arrayList0);
    }

    @Override  // Y3.d
    public final List getCues(long v) {
        int v1 = x.e(this.b, v, false);
        return v1 == -1 ? p0.e : ((V)this.a.get(v1));
    }

    @Override  // Y3.d
    public final long getEventTime(int v) {
        e3.b.c(v < this.a.size());
        return this.b[v];
    }

    @Override  // Y3.d
    public final int getEventTimeCount() {
        return this.a.size();
    }

    @Override  // Y3.d
    public final int getNextEventTimeIndex(long v) {
        int v1 = x.a(this.b, v, false);
        return v1 >= this.a.size() ? -1 : v1;
    }
}

