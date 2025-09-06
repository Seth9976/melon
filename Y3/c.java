package Y3;

import Ac.X3;
import Z3.h;
import h3.f;
import java.util.List;
import n3.b;

public final class c extends f implements d {
    public d e;
    public long f;
    public final int g;
    public Object h;

    public c() {
        this.g = 1;
        super(2);
    }

    public c(b b0) {
        this.g = 0;
        super(2);
        this.h = b0;
    }

    @Override  // Y3.d
    public final List getCues(long v) {
        d d0 = this.e;
        d0.getClass();
        return d0.getCues(v - this.f);
    }

    @Override  // Y3.d
    public final long getEventTime(int v) {
        d d0 = this.e;
        d0.getClass();
        return d0.getEventTime(v) + this.f;
    }

    @Override  // Y3.d
    public final int getEventTimeCount() {
        d d0 = this.e;
        d0.getClass();
        return d0.getEventTimeCount();
    }

    @Override  // Y3.d
    public final int getNextEventTimeIndex(long v) {
        d d0 = this.e;
        d0.getClass();
        return d0.getNextEventTimeIndex(v - this.f);
    }

    @Override  // h3.f
    public final void o() {
        this.b = 0;
        this.c = 0L;
        this.d = false;
        this.e = null;
    }

    @Override  // h3.f
    public final void p() {
        if(this.g != 0) {
            h h0 = (h)((X3)this.h).b;
            h0.getClass();
            this.o();
            h0.b.add(this);
            return;
        }
        ((b)this.h).h(this);
    }
}

