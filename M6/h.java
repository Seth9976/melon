package M6;

public final class H extends g {
    public final boolean m(B b0) {
        d d0;
        b0.getClass();
        Object object0 = this.a;
        if(object0 != null) {
        label_19:
            if(object0 instanceof a) {
                b0.cancel(((a)object0).a);
            }
        }
        else if(b0.isDone()) {
            Object object1 = h.i(b0);
            if(q.g.m(this, null, object1)) {
                h.f(this, false);
                return true;
            }
        }
        else {
            b b1 = new b(this, b0);
            if(q.g.m(this, null, b1)) {
                try {
                    b0.addListener(b1, s.a);
                }
                catch(Throwable throwable0) {
                    try {
                        d0 = new d(throwable0);
                    }
                    catch(Exception | Error unused_ex) {
                        d0 = d.b;
                    }
                    q.g.m(this, b1, d0);
                }
                return true;
            }
            object0 = this.a;
            goto label_19;
        }
        return false;
    }
}

