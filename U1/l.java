package u1;

import P0.f;
import Q0.u;
import android.graphics.Rect;
import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import ie.H;
import kotlin.jvm.internal.r;
import w0.a;
import we.k;

public final class l extends r implements k {
    public final int f;
    public final m g;

    public l(m m0, int v) {
        this.f = v;
        this.g = m0;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.f != 0) {
            m m0 = this.g;
            View view0 = j.e(m0);
            if(view0.hasFocus()) {
                w0.j j0 = ((u)f.w(m0)).getFocusOwner();
                View view1 = f.x(m0);
                if(view0 instanceof ViewGroup) {
                    Rect rect0 = j.d(j0, view1, view0);
                    Integer integer0 = w0.f.D(((a)object0).a);
                    int v = integer0 == null ? 130 : ((int)integer0);
                    FocusFinder focusFinder0 = FocusFinder.getInstance();
                    View view2 = m0.a;
                    View view3 = view2 == null ? focusFinder0.findNextFocusFromRect(((ViewGroup)view1), rect0, v) : focusFinder0.findNextFocus(((ViewGroup)view1), view2, v);
                    if(view3 != null && j.c(view0, view3)) {
                        view3.requestFocus(v, rect0);
                        ((a)object0).b = true;
                        return H.a;
                    }
                    if(!view1.requestFocus()) {
                        throw new IllegalStateException("host view did not take focus");
                    }
                }
                else if(!view1.requestFocus()) {
                    throw new IllegalStateException("host view did not take focus");
                }
            }
            return H.a;
        }
        m m1 = this.g;
        View view4 = j.e(m1);
        if(!view4.isFocused() && !view4.hasFocus()) {
            Rect rect1 = j.d(((u)f.w(m1)).getFocusOwner(), f.x(m1), view4);
            if(!w0.f.z(view4, w0.f.D(((a)object0).a), rect1)) {
                ((a)object0).b = true;
            }
        }
        return H.a;
    }
}

