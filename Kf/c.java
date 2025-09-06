package kf;

import jf.l;
import jf.m;
import qf.b;
import vf.f;

public final class c implements l {
    public final int a;
    public final e b;

    public c(e e0, int v) {
        this.a = v;
        this.b = e0;
        super();
    }

    private final void a(qf.e e0, Object object0) {
    }

    private final void b(qf.e e0, f f0) {
    }

    private final void c(qf.e e0, f f0) {
    }

    private final void d(qf.e e0, f f0) {
    }

    private final void e() {
    }

    private final void f() {
    }

    private final void g() {
    }

    private final void h(qf.e e0, b b0, qf.e e1) {
    }

    private final void i(qf.e e0, b b0, qf.e e1) {
    }

    private final void j(qf.e e0, b b0, qf.e e1) {
    }

    @Override  // jf.l
    public final void k() {
    }

    @Override  // jf.l
    public final m l(qf.e e0) {
        switch(this.a) {
            case 0: {
                String s1 = e0.b();
                if("d1".equals(s1)) {
                    return new kf.b(this, 0);
                }
                return "d2".equals(s1) ? new kf.b(this, 1) : null;
            }
            case 1: {
                return "b".equals(e0.b()) ? new kf.b(this, 2) : null;
            }
            default: {
                String s = e0.b();
                if(!"data".equals(s) && !"filePartClassNames".equals(s)) {
                    return "strings".equals(s) ? new d(this, 1) : null;
                }
                return new d(this, 0);
            }
        }
    }

    @Override  // jf.l
    public final l m(b b0, qf.e e0) {
        switch(this.a) {
            case 0: {
                return null;
            }
            case 1: {
                return null;
            }
            default: {
                return null;
            }
        }
    }

    @Override  // jf.l
    public final void n(qf.e e0, b b0, qf.e e1) {
    }

    @Override  // jf.l
    public final void o(qf.e e0, Object object0) {
        switch(this.a) {
            case 0: {
                String s = e0.b();
                e e1 = this.b;
                if("k".equals(s)) {
                    if(object0 instanceof Integer) {
                        a.b.getClass();
                        a a0 = (a)a.c.get(((Integer)object0));
                        if(a0 == null) {
                            a0 = a.d;
                        }
                        e1.g = a0;
                        return;
                    }
                }
                else if("mv".equals(s)) {
                    if(object0 instanceof int[]) {
                        e1.a = (int[])object0;
                        return;
                    }
                }
                else if("xs".equals(s)) {
                    if(object0 instanceof String && !((String)object0).isEmpty()) {
                        e1.b = (String)object0;
                        return;
                    }
                }
                else if("xi".equals(s)) {
                    if(object0 instanceof Integer) {
                        e1.c = (int)(((Integer)object0));
                        return;
                    }
                }
                else if("pn".equals(s) && object0 instanceof String) {
                    ((String)object0).isEmpty();
                }
                return;
            label_27:
                String s1 = e0.b();
                e e2 = this.b;
                if("version".equals(s1)) {
                    if(object0 instanceof int[]) {
                        e2.a = (int[])object0;
                        return;
                    }
                }
                else if("multifileClassName".equals(s1)) {
                    e2.b = object0 instanceof String ? ((String)object0) : null;
                }
                break;
            }
            case 1: {
                break;
            }
            default: {
                goto label_27;
            }
        }
    }

    @Override  // jf.l
    public final void p(qf.e e0, f f0) {
    }
}

