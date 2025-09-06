package i.n.i.b.a.s.e;

import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a4 extends Ja {
    public static g9 Z(wb wb0) {
        String s = wb0.x();
        s.getClass();
        String s1 = wb0.x();
        s1.getClass();
        return new g9(s, s1, wb0.A(), wb0.A(), Arrays.copyOfRange(wb0.a, wb0.b, wb0.c));
    }

    @Override  // i.n.i.b.a.s.e.Ja
    public final x8 p(s s0, ByteBuffer byteBuffer0) {
        return new x8(new b[]{a4.Z(new wb(byteBuffer0.array(), byteBuffer0.limit()))});
    }
}

