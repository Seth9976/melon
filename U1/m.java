package u1;

import M0.a;
import P0.f;
import P0.n;
import P0.r0;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalFocusChangeListener;
import android.view.ViewTreeObserver;
import g0.e;
import r0.p;
import w0.k;
import w0.o;
import w0.u;

public final class m extends p implements ViewTreeObserver.OnGlobalFocusChangeListener, o {
    public View a;
    public ViewTreeObserver b;
    public final l c;
    public final l d;

    public m() {
        this.c = new l(this, 0);
        this.d = new l(this, 1);
    }

    @Override  // w0.o
    public final void X(w0.l l0) {
        l0.a(false);
        l0.d(this.c);
        l0.b(this.d);
    }

    public final u m0() {
        if(!this.getNode().isAttached()) {
            a.b("visitLocalDescendants called on an unattached node");
        }
        p p0 = this.getNode();
        if((p0.getAggregateChildKindSet$ui_release() & 0x400) != 0) {
            p p1 = p0.getChild$ui_release();
            boolean z = false;
            while(p1 != null) {
                if((p1.getKindSet$ui_release() & 0x400) != 0) {
                    p p2 = p1;
                    e e0 = null;
                    while(p2 != null) {
                        if(p2 instanceof u) {
                            if(z) {
                                return (u)p2;
                            }
                            z = true;
                        }
                        else if((p2.getKindSet$ui_release() & 0x400) != 0 && p2 instanceof n) {
                            p p3 = ((n)p2).b;
                            int v = 0;
                            while(p3 != null) {
                                if((p3.getKindSet$ui_release() & 0x400) != 0) {
                                    ++v;
                                    if(v == 1) {
                                        p2 = p3;
                                    }
                                    else {
                                        if(e0 == null) {
                                            e0 = new e(new p[16]);
                                        }
                                        if(p2 != null) {
                                            e0.b(p2);
                                            p2 = null;
                                        }
                                        e0.b(p3);
                                    }
                                }
                                p3 = p3.getChild$ui_release();
                            }
                            if(v != 1) {
                                goto label_34;
                            }
                            continue;
                        }
                    label_34:
                        p2 = f.f(e0);
                    }
                }
                p1 = p1.getChild$ui_release();
            }
        }
        throw new IllegalStateException("Could not find focus target of embedded view wrapper");
    }

    @Override  // r0.p
    public final void onAttach() {
        super.onAttach();
        ViewTreeObserver viewTreeObserver0 = f.x(this).getViewTreeObserver();
        this.b = viewTreeObserver0;
        viewTreeObserver0.addOnGlobalFocusChangeListener(this);
    }

    @Override  // r0.p
    public final void onDetach() {
        ViewTreeObserver viewTreeObserver0 = this.b;
        if(viewTreeObserver0 != null && viewTreeObserver0.isAlive()) {
            viewTreeObserver0.removeOnGlobalFocusChangeListener(this);
        }
        this.b = null;
        f.x(this).getViewTreeObserver().removeOnGlobalFocusChangeListener(this);
        this.a = null;
        super.onDetach();
    }

    @Override  // android.view.ViewTreeObserver$OnGlobalFocusChangeListener
    public final void onGlobalFocusChanged(View view0, View view1) {
        if(f.v(this).n != null) {
            View view2 = j.e(this);
            w0.j j0 = ((Q0.u)f.w(this)).getFocusOwner();
            r0 r00 = f.w(this);
            boolean z = true;
            boolean z1 = view0 != null && !view0.equals(r00) && j.c(view2, view0);
            if(view1 == null || view1.equals(r00) || !j.c(view2, view1)) {
                z = false;
            }
            if(z1 && z) {
                this.a = view1;
                return;
            }
            if(z) {
                this.a = view1;
                u u0 = this.m0();
                if(!u0.o0().a()) {
                    w0.f.w(u0);
                }
            }
            else {
                if(!z1) {
                    this.a = null;
                    return;
                }
                this.a = null;
                if(this.m0().o0().b()) {
                    ((k)j0).c(8, false, false);
                }
            }
        }
    }
}

