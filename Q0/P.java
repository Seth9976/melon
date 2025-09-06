package Q0;

import H0.c;
import H0.e;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import ie.H;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineScope;
import w0.d;
import w0.f;
import we.a;
import we.k;
import y0.M;

public final class p extends r implements k {
    public final int f;
    public final u g;

    public p(u u0, int v) {
        this.f = v;
        this.g = u0;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        boolean z1;
        d d0;
        switch(this.f) {
            case 0: {
                KeyEvent keyEvent0 = ((H0.d)object0).a;
                u u0 = this.g;
                int[] arr_v = u0.n0;
                long v = e.J(keyEvent0);
                boolean z = true;
                if(c.a(v, c.g)) {
                    d0 = new d((keyEvent0.isShiftPressed() ? 2 : 1));
                }
                else if(c.a(v, c.e)) {
                    d0 = new d(4);
                }
                else if(c.a(v, c.d)) {
                    d0 = new d(3);
                }
                else if((c.a(v, c.b) ? true : c.a(v, c.k))) {
                    d0 = new d(5);
                }
                else if((c.a(v, c.c) ? true : c.a(v, c.l))) {
                    d0 = new d(6);
                }
                else if(((c.a(v, c.f) ? true : c.a(v, c.i)) ? true : c.a(v, c.m))) {
                    d0 = new d(7);
                }
                else {
                    d0 = (c.a(v, c.a) ? true : c.a(v, c.j)) ? new d(8) : null;
                }
                if(d0 != null) {
                    int v1 = d0.a;
                    if(e.K(keyEvent0) == 2) {
                        Integer integer0 = f.D(v1);
                        x0.c c0 = u0.y();
                        Boolean boolean0 = ((w0.k)u0.getFocusOwner()).e(v1, c0, new o(d0, 1));
                        if((boolean0 == null ? true : boolean0.booleanValue())) {
                            return true;
                        }
                        switch(v1) {
                            case 1: {
                                z1 = true;
                                break;
                            }
                            case 2: {
                                z1 = true;
                                break;
                            }
                            default: {
                                z1 = false;
                            }
                        }
                        if(!z1) {
                            return false;
                        }
                        if(integer0 != null) {
                            int v2 = (int)integer0;
                            FocusFinder focusFinder0 = FocusFinder.getInstance();
                            View view0 = u0;
                            while(view0 != null) {
                                View view1 = u0.getRootView();
                                q.e(view1, "null cannot be cast to non-null type android.view.ViewGroup");
                                view0 = focusFinder0.findNextFocus(((ViewGroup)view1), view0, v2);
                                if(view0 == null) {
                                    continue;
                                }
                                if(view0.equals(u0)) {
                                    goto label_58;
                                }
                                ViewParent viewParent0 = view0.getParent();
                            label_53:
                                if(viewParent0 == null) {
                                    goto label_58;
                                }
                                if(viewParent0 == u0) {
                                    continue;
                                }
                                viewParent0 = viewParent0.getParent();
                                goto label_53;
                            }
                            view0 = null;
                        label_58:
                            if(q.b(view0, u0)) {
                                view0 = null;
                            }
                            if(view0 != null) {
                                Rect rect0 = c0 == null ? null : M.w(c0);
                                if(rect0 == null) {
                                    throw new IllegalStateException("Invalid rect");
                                }
                                view0.getLocationInWindow(arr_v);
                                int v3 = arr_v[0];
                                int v4 = arr_v[1];
                                u0.getLocationInWindow(arr_v);
                                rect0.offset(arr_v[0] - v3, arr_v[1] - v4);
                                if(f.z(view0, integer0, rect0)) {
                                    return true;
                                }
                            }
                        }
                        if(!((w0.k)u0.getFocusOwner()).c(v1, false, false)) {
                            return true;
                        }
                        Boolean boolean1 = ((w0.k)u0.getFocusOwner()).e(v1, null, new o(d0, 0));
                        if(boolean1 != null) {
                            z = boolean1.booleanValue();
                        }
                        return Boolean.valueOf(z);
                    }
                }
                return false;
            }
            case 1: {
                u u1 = this.g;
                Handler handler0 = u1.getHandler();
                if((handler0 == null ? null : handler0.getLooper()) == Looper.myLooper()) {
                    ((a)object0).invoke();
                    return H.a;
                }
                Handler handler1 = u1.getHandler();
                if(handler1 != null) {
                    handler1.post(new s(0, ((a)object0)));
                }
                return H.a;
            }
            default: {
                return new V(this.g, this.g.getTextInputService(), ((CoroutineScope)object0));
            }
        }
    }
}

