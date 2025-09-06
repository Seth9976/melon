package androidx.fragment.app;

import E2.c;
import Y1.b;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.f;
import b.a;
import c2.M;
import ie.m;
import java.util.ArrayList;
import java.util.Iterator;
import je.p;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;

public final class n extends K0 {
    public final ArrayList c;
    public final L0 d;
    public final L0 e;
    public final G0 f;
    public final Object g;
    public final ArrayList h;
    public final ArrayList i;
    public final f j;
    public final ArrayList k;
    public final ArrayList l;
    public final f m;
    public final f n;
    public final boolean o;
    public final b p;
    public Object q;
    public boolean r;

    public n(ArrayList arrayList0, L0 l00, L0 l01, G0 g00, Object object0, ArrayList arrayList1, ArrayList arrayList2, f f0, ArrayList arrayList3, ArrayList arrayList4, f f1, f f2, boolean z) {
        this.c = arrayList0;
        this.d = l00;
        this.e = l01;
        this.f = g00;
        this.g = object0;
        this.h = arrayList1;
        this.i = arrayList2;
        this.j = f0;
        this.k = arrayList3;
        this.l = arrayList4;
        this.m = f1;
        this.n = f2;
        this.o = z;
        this.p = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // androidx.fragment.app.K0
    public final boolean a() {
        G0 g00 = this.f;
        if(g00.l()) {
            ArrayList arrayList0 = this.c;
            if(!arrayList0.isEmpty()) {
                for(Object object0: arrayList0) {
                    if(Build.VERSION.SDK_INT < 34) {
                        return false;
                    }
                    Object object1 = ((o)object0).b;
                    if(object1 == null || !g00.m(object1)) {
                        return false;
                    }
                }
            }
            return this.g == null || g00.m(this.g);
        }
        return false;
    }

    @Override  // androidx.fragment.app.K0
    public final void b(ViewGroup viewGroup0) {
        q.g(viewGroup0, "container");
        this.p.a();
    }

    @Override  // androidx.fragment.app.K0
    public final void c(ViewGroup viewGroup0) {
        q.g(viewGroup0, "container");
        boolean z = viewGroup0.isLaidOut();
        ArrayList arrayList0 = this.c;
        if(z && !this.r) {
            Object object0 = this.q;
            G0 g00 = this.f;
            L0 l00 = this.e;
            L0 l01 = this.d;
            if(object0 == null) {
                m m0 = this.g(viewGroup0, l00, l01);
                ArrayList arrayList1 = (ArrayList)m0.a;
                Object object1 = m0.b;
                ArrayList arrayList2 = new ArrayList(je.q.Q(10, arrayList0));
                for(Object object2: arrayList0) {
                    arrayList2.add(((o)object2).a);
                }
                for(Object object3: arrayList2) {
                    k k0 = new k(((L0)object3), this, 1);
                    g00.u(((L0)object3).c, object1, this.p, k0);
                }
                this.i(arrayList1, viewGroup0, new androidx.fragment.app.m(this, viewGroup0, object1));
                if(l0.P(2)) {
                    Log.v("FragmentManager", "Completed executing operations from " + l01 + " to " + l00);
                }
            }
            else {
                g00.c(object0);
                if(l0.P(2)) {
                    Log.v("FragmentManager", "Ending execution of operations from " + l01 + " to " + l00);
                    return;
                }
            }
            return;
        }
        for(Object object4: arrayList0) {
            L0 l02 = ((o)object4).a;
            if(l0.P(2)) {
                if(this.r) {
                    Log.v("FragmentManager", "SpecialEffectsController: TransitionSeekController was not created. Completing operation " + l02);
                }
                else {
                    Log.v("FragmentManager", "SpecialEffectsController: Container " + viewGroup0 + " has not been laid out. Completing operation " + l02);
                }
            }
            ((o)object4).a.c(this);
        }
        this.r = false;
    }

    @Override  // androidx.fragment.app.K0
    public final void d(a a0, ViewGroup viewGroup0) {
        q.g(viewGroup0, "container");
        Object object0 = this.q;
        if(object0 != null) {
            this.f.r(object0, a0.c);
        }
    }

    @Override  // androidx.fragment.app.K0
    public final void e(ViewGroup viewGroup0) {
        q.g(viewGroup0, "container");
        boolean z = viewGroup0.isLaidOut();
        ArrayList arrayList0 = this.c;
        if(!z) {
            for(Object object0: arrayList0) {
                L0 l00 = ((o)object0).a;
                if(l0.P(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Container " + viewGroup0 + " has not been laid out. Skipping onStart for operation " + l00);
                }
            }
            return;
        }
        boolean z1 = this.h();
        L0 l01 = this.e;
        L0 l02 = this.d;
        if(z1) {
            Object object1 = this.g;
            if(object1 != null && !this.a()) {
                Log.i("FragmentManager", "Ignoring shared elements transition " + object1 + " between " + l02 + " and " + l01 + " as neither fragment has set a Transition. In order to run a SharedElementTransition, you must also set either an enter or exit transition on a fragment involved in the transaction. The sharedElementTransition will run after the back gesture has been committed.");
            }
        }
        if(this.a() && this.h()) {
            H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
            m m0 = this.g(viewGroup0, l01, l02);
            ArrayList arrayList1 = (ArrayList)m0.a;
            Object object2 = m0.b;
            ArrayList arrayList2 = new ArrayList(je.q.Q(10, arrayList0));
            for(Object object3: arrayList0) {
                arrayList2.add(((o)object3).a);
            }
            for(Object object4: arrayList2) {
                x x0 = new x(h0, 1);
                k k0 = new k(((L0)object4), this, 0);
                this.f.v(object2, this.p, x0, k0);
            }
            this.i(arrayList1, viewGroup0, new c(this, viewGroup0, object2, h0, 2));
        }
    }

    public static void f(View view0, ArrayList arrayList0) {
        if(view0 instanceof ViewGroup) {
            if(!((ViewGroup)view0).isTransitionGroup()) {
                int v = ((ViewGroup)view0).getChildCount();
                for(int v1 = 0; v1 < v; ++v1) {
                    View view1 = ((ViewGroup)view0).getChildAt(v1);
                    if(view1.getVisibility() == 0) {
                        n.f(view1, arrayList0);
                    }
                }
            }
            else if(!arrayList0.contains(view0)) {
                arrayList0.add(view0);
            }
        }
        else if(!arrayList0.contains(view0)) {
            arrayList0.add(view0);
        }
    }

    public final m g(ViewGroup viewGroup0, L0 l00, L0 l01) {
        ArrayList arrayList7;
        Object object8;
        G0 g00;
        Object object0;
        ArrayList arrayList2;
        ArrayList arrayList1;
        View view0 = new View(viewGroup0.getContext());
        Rect rect0 = new Rect();
        ArrayList arrayList0 = this.c;
        Iterator iterator0 = arrayList0.iterator();
        View view1 = null;
        boolean z = false;
        while(true) {
            boolean z1 = iterator0.hasNext();
            arrayList1 = this.i;
            arrayList2 = this.h;
            object0 = this.g;
            g00 = this.f;
            if(!z1) {
                break;
            }
            Object object1 = iterator0.next();
            if(((o)object1).d != null && l01 != null && l00 != null && !this.j.isEmpty() && object0 != null) {
                I i0 = l00.c;
                I i1 = l01.c;
                q.g(i0, "inFragment");
                q.g(i1, "outFragment");
                if(this.o) {
                    i1.getEnterTransitionCallback();
                }
                else {
                    i0.getEnterTransitionCallback();
                }
                c2.x.a(viewGroup0, new I7.k(l00, l01, this, 9));
                f f0 = this.m;
                arrayList2.addAll(f0.values());
                ArrayList arrayList3 = this.l;
                if(!arrayList3.isEmpty()) {
                    Object object2 = arrayList3.get(0);
                    q.f(object2, "exitingNames[0]");
                    View view2 = (View)f0.get(((String)object2));
                    g00.s(view2, object0);
                    view1 = view2;
                }
                f f1 = this.n;
                arrayList1.addAll(f1.values());
                ArrayList arrayList4 = this.k;
                if(!arrayList4.isEmpty()) {
                    Object object3 = arrayList4.get(0);
                    q.f(object3, "enteringNames[0]");
                    View view3 = (View)f1.get(((String)object3));
                    if(view3 != null) {
                        c2.x.a(viewGroup0, new l(g00, view3, rect0));
                        z = true;
                    }
                }
                g00.w(object0, view0, arrayList2);
                g00.q(this.g, null, null, this.g, arrayList1);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        Object object4 = null;
        Object object5 = null;
        for(Object object6: arrayList0) {
            o o0 = (o)object6;
            L0 l02 = o0.a;
            Object object7 = g00.h(o0.b);
            if(object7 != null) {
                ArrayList arrayList6 = new ArrayList();
                I i2 = l02.c;
                View view4 = i2.mView;
                q.f(view4, "operation.fragment.mView");
                n.f(view4, arrayList6);
                if(object0 != null && (l02 == l01 || l02 == l00)) {
                    if(l02 == l01) {
                        arrayList6.removeAll(p.T0(arrayList2));
                    }
                    else {
                        arrayList6.removeAll(p.T0(arrayList1));
                    }
                }
                if(arrayList6.isEmpty()) {
                    g00.a(view0, object7);
                    object8 = object7;
                    arrayList7 = arrayList6;
                }
                else {
                    g00.b(object7, arrayList6);
                    g00.q(object7, object7, arrayList6, null, null);
                    object8 = object7;
                    arrayList7 = arrayList6;
                    if(l02.a == 3) {
                        l02.i = false;
                        ArrayList arrayList8 = new ArrayList(arrayList7);
                        arrayList8.remove(i2.mView);
                        g00.p(object8, i2.mView, arrayList8);
                        c2.x.a(viewGroup0, new x(arrayList7, 2));
                    }
                }
                if(l02.a == 2) {
                    arrayList5.addAll(arrayList7);
                    if(z) {
                        g00.t(object8, rect0);
                    }
                    if(l0.P(2)) {
                        Log.v("FragmentManager", "Entering Transition: " + object8);
                        Log.v("FragmentManager", ">>>>> EnteringViews <<<<<");
                        for(Object object9: arrayList7) {
                            q.f(object9, "transitioningViews");
                            Log.v("FragmentManager", "View: " + ((View)object9));
                        }
                    }
                }
                else {
                    g00.s(view1, object8);
                    if(l0.P(2)) {
                        Log.v("FragmentManager", "Exiting Transition: " + object8);
                        Log.v("FragmentManager", ">>>>> ExitingViews <<<<<");
                        for(Object object10: arrayList7) {
                            q.f(object10, "transitioningViews");
                            Log.v("FragmentManager", "View: " + ((View)object10));
                        }
                    }
                }
                if(o0.c) {
                    object4 = g00.o(object4, object8);
                }
                else {
                    object5 = g00.o(object5, object8);
                }
            }
        }
        Object object11 = g00.n(object4, object5, object0);
        if(l0.P(2)) {
            Log.v("FragmentManager", "Final merged transition: " + object11 + " for container " + viewGroup0);
        }
        return new m(arrayList5, object11);
    }

    public final boolean h() {
        ArrayList arrayList0 = this.c;
        if(!arrayList0.isEmpty()) {
            for(Object object0: arrayList0) {
                if(!((o)object0).a.c.mTransitioning) {
                    return false;
                }
                if(false) {
                    break;
                }
            }
        }
        return true;
    }

    public final void i(ArrayList arrayList0, ViewGroup viewGroup0, we.a a0) {
        z0.a(4, arrayList0);
        ArrayList arrayList1 = new ArrayList();
        ArrayList arrayList2 = this.i;
        int v = arrayList2.size();
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = (View)arrayList2.get(v1);
            arrayList1.add(M.f(view0));
            M.o(view0, null);
        }
        boolean z = l0.P(2);
        ArrayList arrayList3 = this.h;
        if(z) {
            Log.v("FragmentManager", ">>>>> Beginning transition <<<<<");
            Log.v("FragmentManager", ">>>>> SharedElementFirstOutViews <<<<<");
            for(Object object0: arrayList3) {
                q.f(object0, "sharedElementFirstOutViews");
                Log.v("FragmentManager", "View: " + ((View)object0) + " Name: " + M.f(((View)object0)));
            }
            Log.v("FragmentManager", ">>>>> SharedElementLastInViews <<<<<");
            for(Object object1: arrayList2) {
                q.f(object1, "sharedElementLastInViews");
                Log.v("FragmentManager", "View: " + ((View)object1) + " Name: " + M.f(((View)object1)));
            }
        }
        a0.invoke();
        int v2 = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for(int v3 = 0; v3 < v2; ++v3) {
            View view1 = (View)arrayList3.get(v3);
            String s = M.f(view1);
            arrayList4.add(s);
            if(s != null) {
                M.o(view1, null);
                String s1 = (String)this.j.get(s);
                for(int v4 = 0; v4 < v2; ++v4) {
                    if(s1.equals(arrayList1.get(v4))) {
                        M.o(((View)arrayList2.get(v4)), s);
                        break;
                    }
                }
            }
        }
        c2.x.a(viewGroup0, new F0(v2, arrayList2, arrayList1, arrayList3, arrayList4));
        z0.a(0, arrayList0);
        this.f.x(this.g, arrayList3, arrayList2);
    }
}

