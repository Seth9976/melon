package w1;

import df.v;

public final class g extends v {
    @Override  // df.v
    public final void H(h h0, h h1) {
        h0.b = h1;
    }

    @Override  // df.v
    public final void I(h h0, Thread thread0) {
        h0.a = thread0;
    }

    @Override  // df.v
    public final boolean o(i i0, d d0, d d1) {
        synchronized(i0) {
            if(i0.b == d0) {
                i0.b = d1;
                return true;
            }
        }
        return false;
    }

    @Override  // df.v
    public final boolean p(i i0, Object object0, Object object1) {
        synchronized(i0) {
            if(i0.a == object0) {
                i0.a = object1;
                return true;
            }
        }
        return false;
    }

    @Override  // df.v
    public final boolean q(i i0, h h0, h h1) {
        synchronized(i0) {
            if(i0.c == h0) {
                i0.c = h1;
                return true;
            }
        }
        return false;
    }
}

