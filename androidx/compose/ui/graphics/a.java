package androidx.compose.ui.graphics;

import r0.q;
import we.k;
import y0.B;
import y0.M;
import y0.Q;
import y0.U;

public abstract class a {
    public static final q a(q q0, k k0) {
        return q0.then(new BlockGraphicsLayerElement(k0));
    }

    public static q b(q q0, float f, float f1, float f2, float f3, float f4, Q q1, boolean z, int v) {
        float f5 = (v & 1) == 0 ? f : 1.0f;
        float f6 = (v & 2) == 0 ? f1 : 1.0f;
        float f7 = (v & 4) == 0 ? f2 : 1.0f;
        float f8 = (v & 0x20) == 0 ? f3 : 0.0f;
        float f9 = (v & 0x100) == 0 ? f4 : 0.0f;
        long v1 = U.b;
        Q q2 = (v & 0x800) == 0 ? q1 : M.a;
        boolean z1 = (v & 0x1000) == 0 ? z : false;
        return (v & 0x10000) == 0 ? q0.then(new GraphicsLayerElement(f5, f6, f7, f8, f9, v1, q2, z1, B.a, B.a, 1)) : q0.then(new GraphicsLayerElement(f5, f6, f7, f8, f9, v1, q2, z1, B.a, B.a, 0));
    }
}

