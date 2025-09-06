package u1;

import N0.g0;
import P0.v;
import S1.d;
import androidx.datastore.preferences.protobuf.m;
import c2.B0;
import c2.l0;
import java.util.List;
import x9.c;

public final class b extends m {
    public final o c;

    public b(o o0) {
        this.c = o0;
        super(1);
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final B0 f(B0 b00, List list0) {
        return this.c.g(b00);
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final c g(l0 l00, c c0) {
        v v0 = (v)this.c.S.b0.c;
        if(v0.h()) {
            long v1 = e1.b.J(v0.j0(0L));
            int v2 = (int)(v1 >> 0x20);
            int v3 = 0;
            if(v2 < 0) {
                v2 = 0;
            }
            int v4 = ((int)(v1 & 0xFFFFFFFFL)) >= 0 ? ((int)(v1 & 0xFFFFFFFFL)) : 0;
            long v5 = g0.g(v0).l();
            long v6 = e1.b.J(v0.j0(((long)Float.floatToRawIntBits(((int)(v0.c >> 0x20)))) << 0x20 | ((long)Float.floatToRawIntBits(((int)(v0.c & 0xFFFFFFFFL)))) & 0xFFFFFFFFL));
            int v7 = ((int)(v5 >> 0x20)) - ((int)(v6 >> 0x20)) >= 0 ? ((int)(v5 >> 0x20)) - ((int)(v6 >> 0x20)) : 0;
            int v8 = ((int)(v5 & 0xFFFFFFFFL)) - ((int)(0xFFFFFFFFL & v6));
            if(v8 >= 0) {
                v3 = v8;
            }
            return v2 != 0 || v4 != 0 || v7 != 0 || v3 != 0 ? new c(6, i.f(((d)c0.b), v2, v4, v7, v3), i.f(((d)c0.c), v2, v4, v7, v3)) : c0;
        }
        return c0;
    }
}

