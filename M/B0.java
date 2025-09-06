package M;

import P0.u0;
import r0.p;
import r1.c;

public final class b0 extends p implements u0 {
    public float a;
    public boolean b;

    @Override  // P0.u0
    public final Object b0(c c0, Object object0) {
        m0 m00 = object0 instanceof m0 ? ((m0)object0) : null;
        if(m00 == null) {
            m00 = new m0();
        }
        m00.a = this.a;
        m00.b = this.b;
        return m00;
    }
}

