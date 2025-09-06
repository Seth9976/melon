package w0;

import M0.a;
import P0.f;
import P0.n;
import g0.e;
import we.k;

public final class p {
    public final e a;
    public static final p b;
    public static final p c;
    public static final p d;

    static {
        p.b = new p();
        p.c = new p();
        p.d = new p();
    }

    public p() {
        this.a = new e(new q[16]);
    }

    public final boolean a(k k0) {
        e e2;
        r0.p p1;
        if(this == p.b || this == p.c) {
            throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n");
        }
        e e0 = this.a;
        int v = e0.c;
        if(v == 0) {
            throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n");
        }
        Object[] arr_object = e0.a;
        int v1 = 0;
        boolean z = false;
        while(v1 < v) {
            q q0 = (q)arr_object[v1];
            if(!((r0.p)q0).getNode().isAttached()) {
                a.b("visitChildren called on an unattached node");
            }
            e e1 = new e(new r0.p[16]);
            r0.p p0 = ((r0.p)q0).getNode().getChild$ui_release();
            if(p0 == null) {
                f.b(e1, ((r0.p)q0).getNode());
            }
            else {
                e1.b(p0);
            }
        alab1:
            while(true) {
            alab2:
                while(true) {
                    int v2 = e1.c;
                    if(v2 == 0) {
                        break alab1;
                    }
                    p1 = (r0.p)e1.k(v2 - 1);
                    if((p1.getAggregateChildKindSet$ui_release() & 0x400) == 0) {
                        f.b(e1, p1);
                    }
                    else {
                        while(true) {
                            if(p1 == null) {
                                continue alab1;
                            }
                            if((p1.getKindSet$ui_release() & 0x400) == 0) {
                                p1 = p1.getChild$ui_release();
                                continue;
                            }
                            e2 = null;
                        label_28:
                            if(p1 == null) {
                                break;
                            }
                            break alab2;
                        }
                    }
                }
                if(!(p1 instanceof u)) {
                    if((p1.getKindSet$ui_release() & 0x400) != 0 && p1 instanceof n) {
                        r0.p p2 = ((n)p1).b;
                        int v3 = 0;
                        while(p2 != null) {
                            if((p2.getKindSet$ui_release() & 0x400) != 0) {
                                ++v3;
                                if(v3 == 1) {
                                    p1 = p2;
                                }
                                else {
                                    if(e2 == null) {
                                        e2 = new e(new r0.p[16]);
                                    }
                                    if(p1 != null) {
                                        e2.b(p1);
                                        p1 = null;
                                    }
                                    e2.b(p2);
                                }
                            }
                            p2 = p2.getChild$ui_release();
                        }
                        if(v3 != 1) {
                            p1 = f.f(e2);
                        }
                        goto label_28;
                    }
                }
                else if((((u)p1).n0().a ? ((Boolean)k0.invoke(((u)p1))).booleanValue() : w0.f.i(((u)p1), 7, k0))) {
                    z = true;
                    break;
                }
                p1 = f.f(e2);
                goto label_28;
            }
            ++v1;
        }
        return z;
    }

    public static boolean b(p p0) {
        p0.getClass();
        return p0.a(new m(1, 3));
    }
}

