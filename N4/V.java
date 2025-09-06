package N4;

import H7.c;
import Y1.b;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import androidx.fragment.app.G0;
import androidx.fragment.app.I;
import androidx.fragment.app.l;
import androidx.fragment.app.x;
import androidx.transition.Transition;
import androidx.transition.TransitionSet;
import java.util.ArrayList;
import jeb.synthetic.FIN;

public class v extends G0 {
    @Override  // androidx.fragment.app.G0
    public final void a(View view0, Object object0) {
        ((Transition)object0).b(view0);
    }

    @Override  // androidx.fragment.app.G0
    public final void b(Object object0, ArrayList arrayList0) {
        int v = 0;
        if(((Transition)object0) != null) {
            if(((Transition)object0) instanceof TransitionSet) {
                int v1 = ((TransitionSet)(((Transition)object0))).b0.size();
                while(v < v1) {
                    this.b(((TransitionSet)(((Transition)object0))).P(v), arrayList0);
                    ++v;
                }
                return;
            }
            if(G0.k(((Transition)object0).e) && G0.k(((Transition)object0).f)) {
                int v2 = arrayList0.size();
                while(v < v2) {
                    ((Transition)object0).b(((View)arrayList0.get(v)));
                    ++v;
                }
            }
        }
    }

    @Override  // androidx.fragment.app.G0
    public final void c(Object object0) {
        ((Q)object0).h();
        ((Q)object0).d.a(((float)(((Q)object0).g.S + 1L)));
    }

    @Override  // androidx.fragment.app.G0
    public final void d(Object object0, l l0) {
        ((Q)object0).f = l0;
        ((Q)object0).h();
        ((Q)object0).d.a(0.0f);
    }

    @Override  // androidx.fragment.app.G0
    public final void e(ViewGroup viewGroup0, Object object0) {
        W.a(viewGroup0, ((Transition)object0));
    }

    @Override  // androidx.fragment.app.G0
    public final boolean g(Object object0) {
        return object0 instanceof Transition;
    }

    @Override  // androidx.fragment.app.G0
    public final Object h(Object object0) {
        return object0 != null ? ((Transition)object0).j() : null;
    }

    @Override  // androidx.fragment.app.G0
    public final Object i(ViewGroup viewGroup0, Object object0) {
        ArrayList arrayList0 = W.c;
        if(!arrayList0.contains(viewGroup0) && viewGroup0.isLaidOut() && Build.VERSION.SDK_INT >= 34) {
            if(!((Transition)object0).t()) {
                throw new IllegalArgumentException("The Transition must support seeking.");
            }
            arrayList0.add(viewGroup0);
            Transition transition0 = ((Transition)object0).j();
            TransitionSet transitionSet0 = new TransitionSet();
            transitionSet0.O(transition0);
            W.c(viewGroup0, transitionSet0);
            viewGroup0.setTag(0x7F0A0BDF, null);  // id:transition_current_scene
            V v0 = new V();  // 初始化器: Ljava/lang/Object;-><init>()V
            v0.a = transitionSet0;
            v0.b = viewGroup0;
            viewGroup0.addOnAttachStateChangeListener(v0);
            viewGroup0.getViewTreeObserver().addOnPreDrawListener(v0);
            viewGroup0.invalidate();
            Q q0 = new Q(transitionSet0);
            transitionSet0.T = q0;
            transitionSet0.a(q0);
            return transitionSet0.T;
        }
        return null;
    }

    @Override  // androidx.fragment.app.G0
    public final boolean l() {
        return true;
    }

    @Override  // androidx.fragment.app.G0
    public final boolean m(Object object0) {
        boolean z = ((Transition)object0).t();
        if(!z) {
            Log.v("FragmentManager", "Predictive back not available for AndroidX Transition " + object0 + ". Please enable seeking support for the designated transition by overriding isSeekingSupported().");
        }
        return z;
    }

    @Override  // androidx.fragment.app.G0
    public final Object n(Object object0, Object object1, Object object2) {
        Transition transition0 = (Transition)object0;
        if(transition0 != null && ((Transition)object1) != null) {
            TransitionSet transitionSet0 = new TransitionSet();
            transitionSet0.O(transition0);
            transitionSet0.O(((Transition)object1));
            transitionSet0.S(1);
            transition0 = transitionSet0;
        }
        else if(transition0 == null) {
            transition0 = ((Transition)object1) == null ? null : ((Transition)object1);
        }
        if(((Transition)object2) != null) {
            TransitionSet transitionSet1 = new TransitionSet();
            if(transition0 != null) {
                transitionSet1.O(transition0);
            }
            transitionSet1.O(((Transition)object2));
            return transitionSet1;
        }
        return transition0;
    }

    @Override  // androidx.fragment.app.G0
    public final Object o(Object object0, Object object1) {
        TransitionSet transitionSet0 = new TransitionSet();
        if(object0 != null) {
            transitionSet0.O(((Transition)object0));
        }
        transitionSet0.O(((Transition)object1));
        return transitionSet0;
    }

    @Override  // androidx.fragment.app.G0
    public final void p(Object object0, View view0, ArrayList arrayList0) {
        ((Transition)object0).a(new s(view0, arrayList0));
    }

    @Override  // androidx.fragment.app.G0
    public final void q(Object object0, Object object1, ArrayList arrayList0, Object object2, ArrayList arrayList1) {
        ((Transition)object0).a(new t(this, object1, arrayList0, object2, arrayList1));
    }

    @Override  // androidx.fragment.app.G0
    public final void r(Object object0, float f) {
        if(((Q)object0).b) {
            TransitionSet transitionSet0 = ((Q)object0).g;
            long v = transitionSet0.S;
            long v1 = Long.compare(((long)(f * ((float)v))), 0L) == 0 ? 1L : ((long)(f * ((float)v)));
            if(v1 == v) {
                v1 = v - 1L;
            }
            if(((Q)object0).d != null) {
                throw new IllegalStateException("setCurrentPlayTimeMillis() called after animation has been started");
            }
            long v2 = ((Q)object0).a;
            if(v1 != v2) {
                if(!((Q)object0).c) {
                    if(v1 == 0L && v2 > 0L) {
                        v1 = -1L;
                    }
                    else if(v1 == v && v2 < v) {
                        v1 = v + 1L;
                    }
                    if(v1 != v2) {
                        transitionSet0.F(v1, v2);
                        ((Q)object0).a = v1;
                    }
                }
                long v3 = AnimationUtils.currentAnimationTimeMillis();
                int v4 = (((Q)object0).e.a + 1) % 20;
                ((Q)object0).e.a = v4;
                ((long[])((Q)object0).e.b)[v4] = v3;
                ((float[])((Q)object0).e.c)[v4] = (float)v1;
            }
        }
    }

    @Override  // androidx.fragment.app.G0
    public final void s(View view0, Object object0) {
        if(view0 != null) {
            Rect rect0 = new Rect();
            G0.j(view0, rect0);
            ((Transition)object0).H(new r(0, rect0));
        }
    }

    @Override  // androidx.fragment.app.G0
    public final void t(Object object0, Rect rect0) {
        ((Transition)object0).H(new r(1, rect0));
    }

    @Override  // androidx.fragment.app.G0
    public final void u(I i0, Object object0, b b0, Runnable runnable0) {
        this.v(object0, b0, null, runnable0);
    }

    @Override  // androidx.fragment.app.G0
    public final void v(Object object0, b b0, x x0, Runnable runnable0) {
        c c0 = new c(x0, ((Transition)object0), runnable0, 3);
        __monitor_enter(b0);
    label_2:
        int v = FIN.finallyOpen$NT();
        while(b0.b) {
            try {
                b0.wait();
            }
            catch(InterruptedException unused_ex) {
                goto label_2;
            }
        }
        if(((c)b0.c) == c0) {
            FIN.finallyExec$NT(v);
        }
        else {
            b0.c = c0;
            if(b0.a) {
                FIN.finallyCodeBegin$NT(v);
                __monitor_exit(b0);
                FIN.finallyCodeEnd$NT(v);
                Runnable runnable1 = (Runnable)c0.d;
                Transition transition0 = (Transition)c0.b;
                Runnable runnable2 = (Runnable)c0.c;
                if(runnable1 == null) {
                    transition0.cancel();
                    runnable2.run();
                }
                else {
                    runnable1.run();
                }
            }
            else {
                FIN.finallyExec$NT(v);
            }
        }
        ((Transition)object0).a(new u(runnable0));
    }

    @Override  // androidx.fragment.app.G0
    public final void w(Object object0, View view0, ArrayList arrayList0) {
        ArrayList arrayList1 = ((TransitionSet)object0).f;
        arrayList1.clear();
        int v = arrayList0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            G0.f(arrayList1, ((View)arrayList0.get(v1)));
        }
        arrayList1.add(view0);
        arrayList0.add(view0);
        this.b(((TransitionSet)object0), arrayList0);
    }

    @Override  // androidx.fragment.app.G0
    public final void x(Object object0, ArrayList arrayList0, ArrayList arrayList1) {
        if(((TransitionSet)object0) != null) {
            ((TransitionSet)object0).f.clear();
            ((TransitionSet)object0).f.addAll(arrayList1);
            this.z(((TransitionSet)object0), arrayList0, arrayList1);
        }
    }

    @Override  // androidx.fragment.app.G0
    public final Object y(Object object0) {
        if(object0 == null) {
            return null;
        }
        TransitionSet transitionSet0 = new TransitionSet();
        transitionSet0.O(((Transition)object0));
        return transitionSet0;
    }

    public final void z(Object object0, ArrayList arrayList0, ArrayList arrayList1) {
        int v = 0;
        if(((Transition)object0) instanceof TransitionSet) {
            int v1 = ((TransitionSet)(((Transition)object0))).b0.size();
            while(v < v1) {
                this.z(((TransitionSet)(((Transition)object0))).P(v), arrayList0, arrayList1);
                ++v;
            }
            return;
        }
        if(G0.k(((Transition)object0).e)) {
            ArrayList arrayList2 = ((Transition)object0).f;
            if(arrayList2.size() == arrayList0.size() && arrayList2.containsAll(arrayList0)) {
                int v2 = arrayList1 == null ? 0 : arrayList1.size();
                while(v < v2) {
                    ((Transition)object0).b(((View)arrayList1.get(v)));
                    ++v;
                }
                for(int v3 = arrayList0.size() - 1; v3 >= 0; --v3) {
                    ((Transition)object0).C(((View)arrayList0.get(v3)));
                }
            }
        }
    }
}

