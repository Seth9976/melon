package i.n.i.b.a.s.e;

import java.util.concurrent.CopyOnWriteArrayList;

public final class ab {
    public final CopyOnWriteArrayList a;

    public ab(int v) {
        if(v != 1) {
            super();
            this.a = new CopyOnWriteArrayList();
            return;
        }
        super();
        this.a = new CopyOnWriteArrayList();
    }

    public void a(int v, long v1, long v2) {
        for(Object object0: this.a) {
            Za za0 = (Za)object0;
            if(!za0.c) {
                u9 u90 = new u9(za0, v, v1, v2);
                za0.a.post(u90);
            }
        }
    }

    public void b(S1 s10) {
        CopyOnWriteArrayList copyOnWriteArrayList0 = this.a;
        for(Object object0: copyOnWriteArrayList0) {
            Za za0 = (Za)object0;
            if(za0.b == s10) {
                za0.c = true;
                copyOnWriteArrayList0.remove(za0);
            }
        }
    }
}

