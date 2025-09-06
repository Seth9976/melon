package androidx.fragment.app;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.o;
import androidx.collection.f;
import c2.M;
import ie.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import je.p;
import je.u;

public final class q {
    public final ViewGroup a;
    public final ArrayList b;
    public final ArrayList c;
    public boolean d;
    public boolean e;
    public boolean f;

    public q(ViewGroup viewGroup0) {
        kotlin.jvm.internal.q.g(viewGroup0, "container");
        super();
        this.a = viewGroup0;
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    public final void a(L0 l00) {
        kotlin.jvm.internal.q.g(l00, "operation");
        if(l00.i) {
            int v = l00.a;
            View view0 = l00.c.requireView();
            kotlin.jvm.internal.q.f(view0, "operation.fragment.requireView()");
            o.a(v, view0, this.a);
            l00.i = false;
        }
    }

    public final void b(ArrayList arrayList0, boolean z) {
        Iterator iterator10;
        n n0;
        m m0;
        ArrayList arrayList17;
        ArrayList arrayList16;
        ArrayList arrayList15;
        G0 g02;
        ArrayList arrayList12;
        ArrayList arrayList11;
        Object object10;
        Object object7;
        ArrayList arrayList5;
        Object object1;
        if(l0.P(2)) {
            Log.v("FragmentManager", "Collecting Effects");
        }
        for(Object object0: arrayList0) {
            L0 l00 = (L0)object0;
            View view0 = l00.c.mView;
            kotlin.jvm.internal.q.f(view0, "operation.fragment.mView");
            if(view0.getAlpha() == 0.0f && view0.getVisibility() == 0) {
                continue;
            }
            int v = view0.getVisibility();
            switch(v) {
                case 0: {
                    if(l00.a != 2) {
                        break;
                    }
                    continue;
                }
                case 4: 
                case 8: {
                    continue;
                }
                default: {
                    throw new IllegalArgumentException("Unknown visibility " + v);
                }
            }
            goto label_15;
        }
        object0 = null;
    label_15:
        ListIterator listIterator0 = arrayList0.listIterator(arrayList0.size());
        while(listIterator0.hasPrevious()) {
            object1 = listIterator0.previous();
            L0 l01 = (L0)object1;
            View view1 = l01.c.mView;
            kotlin.jvm.internal.q.f(view1, "operation.fragment.mView");
            if(view1.getAlpha() != 0.0f || view1.getVisibility() != 0) {
                int v1 = view1.getVisibility();
                switch(v1) {
                    case 0: {
                        continue;
                    }
                    case 4: 
                    case 8: {
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException("Unknown visibility " + v1);
                    }
                }
            }
            if(l01.a != 2) {
                continue;
            }
            goto label_28;
        }
        object1 = null;
    label_28:
        if(l0.P(2)) {
            Log.v("FragmentManager", "Executing operations from " + ((L0)object0) + " to " + ((L0)object1));
        }
        ArrayList arrayList1 = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        I i0 = ((L0)p.s0(arrayList0)).c;
        for(Object object2: arrayList0) {
            F f0 = ((L0)object2).c.mAnimationInfo;
            f0.b = i0.mAnimationInfo.b;
            f0.c = i0.mAnimationInfo.c;
            f0.d = i0.mAnimationInfo.d;
            f0.e = i0.mAnimationInfo.e;
        }
        Iterator iterator2 = arrayList0.iterator();
        while(true) {
            boolean z1 = false;
            if(!iterator2.hasNext()) {
                break;
            }
            Object object3 = iterator2.next();
            L0 l02 = (L0)object3;
            arrayList1.add(new e(l02, z));
            if(!z) {
                if(l02 == ((L0)object1)) {
                    z1 = true;
                }
            }
            else if(l02 == ((L0)object0)) {
                z1 = true;
            }
            arrayList2.add(new androidx.fragment.app.o(l02, z, z1));
            J0 j00 = new J0(this, l02, 1);
            l02.d.add(j00);
        }
        ArrayList arrayList3 = new ArrayList();
        for(Object object4: arrayList2) {
            if(!((androidx.fragment.app.o)object4).a()) {
                arrayList3.add(object4);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        for(Object object5: arrayList3) {
            if(((androidx.fragment.app.o)object5).b() != null) {
                arrayList4.add(object5);
            }
        }
        G0 g00 = null;
        for(Object object6: arrayList4) {
            androidx.fragment.app.o o0 = (androidx.fragment.app.o)object6;
            G0 g01 = o0.b();
            if(g00 != null && g01 != g00) {
                StringBuilder stringBuilder0 = new StringBuilder("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                stringBuilder0.append(o0.a.c);
                stringBuilder0.append(" returned Transition ");
                throw new IllegalArgumentException(va.e.d(stringBuilder0, o0.b, " which uses a different Transition type than other Fragments.").toString());
            }
            g00 = g01;
        }
        if(g00 == null) {
            arrayList5 = arrayList1;
        }
        else {
            ArrayList arrayList6 = new ArrayList();
            ArrayList arrayList7 = new ArrayList();
            f f1 = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
            ArrayList arrayList8 = new ArrayList();
            ArrayList arrayList9 = new ArrayList();
            f f2 = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
            ArrayList arrayList10 = arrayList8;
            f f3 = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
            Iterator iterator6 = arrayList4.iterator();
            while(true) {
                object7 = null;
            label_98:
                if(!iterator6.hasNext()) {
                    goto label_214;
                }
                Object object8 = iterator6.next();
                Object object9 = ((androidx.fragment.app.o)object8).d;
                if(object9 == null || ((L0)object0) == null) {
                    goto label_205;
                }
                I i1 = ((L0)object0).c;
                if(((L0)object1) == null) {
                    goto label_200;
                }
                I i2 = ((L0)object1).c;
                object10 = g00.y(g00.h(object9));
                arrayList11 = i2.getSharedElementSourceNames();
                arrayList12 = arrayList1;
                kotlin.jvm.internal.q.f(arrayList11, "lastIn.fragment.sharedElementSourceNames");
                ArrayList arrayList13 = i1.getSharedElementSourceNames();
                g02 = g00;
                kotlin.jvm.internal.q.f(arrayList13, "firstOut.fragment.sharedElementSourceNames");
                ArrayList arrayList14 = i1.getSharedElementTargetNames();
                arrayList15 = arrayList6;
                kotlin.jvm.internal.q.f(arrayList14, "firstOut.fragment.sharedElementTargetNames");
                int v2 = arrayList14.size();
                arrayList16 = arrayList7;
                for(int v3 = 0; v3 < v2; ++v3) {
                    int v4 = arrayList11.indexOf(arrayList14.get(v3));
                    if(v4 != -1) {
                        arrayList11.set(v4, arrayList13.get(v3));
                    }
                }
                arrayList17 = i2.getSharedElementTargetNames();
                kotlin.jvm.internal.q.f(arrayList17, "lastIn.fragment.sharedElementTargetNames");
                if(z) {
                    i1.getEnterTransitionCallback();
                    i2.getExitTransitionCallback();
                }
                else {
                    i1.getExitTransitionCallback();
                    i2.getEnterTransitionCallback();
                }
                m0 = new m(null, null);
                if(m0.a != null || m0.b != null) {
                    throw new ClassCastException();
                }
                int v5 = arrayList11.size();
                for(int v6 = 0; v6 < v5; ++v6) {
                    Object object11 = arrayList11.get(v6);
                    kotlin.jvm.internal.q.f(object11, "exitingNames[i]");
                    Object object12 = arrayList17.get(v6);
                    kotlin.jvm.internal.q.f(object12, "enteringNames[i]");
                    f1.put(((String)object11), ((String)object12));
                }
                if(l0.P(2)) {
                    Log.v("FragmentManager", ">>> entering view names <<<");
                    for(Object object13: arrayList17) {
                        Log.v("FragmentManager", "Name: " + ((String)object13));
                    }
                    Log.v("FragmentManager", ">>> exiting view names <<<");
                    for(Object object14: arrayList11) {
                        Log.v("FragmentManager", "Name: " + ((String)object14));
                    }
                }
                View view2 = i1.mView;
                kotlin.jvm.internal.q.f(view2, "firstOut.fragment.mView");
                q.f(f2, view2);
                f2.retainAll(arrayList11);
                f1.retainAll(f2.keySet());
                View view3 = i2.mView;
                kotlin.jvm.internal.q.f(view3, "lastIn.fragment.mView");
                q.f(f3, view3);
                f3.retainAll(arrayList17);
                f3.retainAll(f1.values());
                for(int v7 = f1.size() - 1; -1 < v7; --v7) {
                    if(!f3.containsKey(((String)f1.valueAt(v7)))) {
                        f1.removeAt(v7);
                    }
                }
                Set set0 = f1.keySet();
                kotlin.jvm.internal.q.f(set0, "sharedElementNameMapping.keys");
                Set set1 = f2.entrySet();
                kotlin.jvm.internal.q.f(set1, "entries");
                u.W(set1, new androidx.fragment.app.p(0, set0), false);
                Collection collection0 = f1.values();
                kotlin.jvm.internal.q.f(collection0, "sharedElementNameMapping.values");
                Set set2 = f3.entrySet();
                kotlin.jvm.internal.q.f(set2, "entries");
                u.W(set2, new androidx.fragment.app.p(0, collection0), false);
                if(!f1.isEmpty()) {
                    break;
                }
                Log.i("FragmentManager", "Ignoring shared elements transition " + object10 + " between " + ((L0)object0) + " and " + ((L0)object1) + " as there are no matching elements in both the entering and exiting fragment. In order to run a SharedElementTransition, both fragments involved must have the element.");
                arrayList15.clear();
                arrayList16.clear();
                arrayList10 = arrayList17;
                arrayList9 = arrayList11;
                arrayList1 = arrayList12;
                g00 = g02;
                arrayList6 = arrayList15;
                arrayList7 = arrayList16;
            }
            arrayList10 = arrayList17;
            arrayList9 = arrayList11;
            object7 = object10;
            goto label_209;
        label_200:
            arrayList12 = arrayList1;
            g02 = g00;
            arrayList15 = arrayList6;
            arrayList16 = arrayList7;
            goto label_209;
        label_205:
            arrayList12 = arrayList1;
            g02 = g00;
            arrayList15 = arrayList6;
            arrayList16 = arrayList7;
        label_209:
            arrayList1 = arrayList12;
            g00 = g02;
            arrayList6 = arrayList15;
            arrayList7 = arrayList16;
            goto label_98;
        label_214:
            arrayList5 = arrayList1;
            if(object7 != null) {
                n0 = new n(arrayList4, ((L0)object0), ((L0)object1), g00, object7, arrayList6, arrayList7, f1, arrayList10, arrayList9, f2, f3, z);
                iterator10 = arrayList4.iterator();
            label_226:
                while(iterator10.hasNext()) {
                    Object object16 = iterator10.next();
                    ((androidx.fragment.app.o)object16).a.j.add(n0);
                }
            }
            else if(!arrayList4.isEmpty()) {
                for(Object object15: arrayList4) {
                    if(((androidx.fragment.app.o)object15).b == null) {
                        continue;
                    }
                    n0 = new n(arrayList4, ((L0)object0), ((L0)object1), g00, null, arrayList6, arrayList7, f1, arrayList10, arrayList9, f2, f3, z);
                    iterator10 = arrayList4.iterator();
                    goto label_226;
                }
            }
        }
        ArrayList arrayList18 = new ArrayList();
        ArrayList arrayList19 = new ArrayList();
        for(Object object17: arrayList5) {
            u.U(arrayList19, ((e)object17).a.k);
        }
        boolean z2 = arrayList19.isEmpty();
        boolean z3 = false;
        for(Object object18: arrayList5) {
            e e0 = (e)object18;
            Context context0 = this.a.getContext();
            L0 l03 = e0.a;
            kotlin.jvm.internal.q.f(context0, "context");
            N n1 = e0.b(context0);
            if(n1 == null) {
            }
            else if(((AnimatorSet)n1.b) == null) {
                arrayList18.add(e0);
            }
            else {
                I i3 = l03.c;
                if(l03.k.isEmpty()) {
                    if(l03.a == 3) {
                        l03.i = false;
                    }
                    g g0 = new g(e0);
                    l03.j.add(g0);
                    z3 = true;
                }
                else {
                    if(!l0.P(2)) {
                        continue;
                    }
                    Log.v("FragmentManager", "Ignoring Animator set on " + i3 + " as this Fragment was involved in a Transition.");
                }
            }
        }
        for(Object object19: arrayList18) {
            e e1 = (e)object19;
            L0 l04 = e1.a;
            I i4 = l04.c;
            if(!z2) {
                if(!l0.P(2)) {
                    continue;
                }
                Log.v("FragmentManager", "Ignoring Animation set on " + i4 + " as Animations cannot run alongside Transitions.");
            }
            else if(!z3) {
                d d0 = new d(e1);
                l04.j.add(d0);
            }
            else if(l0.P(2)) {
                Log.v("FragmentManager", "Ignoring Animation set on " + i4 + " as Animations cannot run alongside Animators.");
            }
        }
    }

    public final void c(List list0) {
        kotlin.jvm.internal.q.g(list0, "operations");
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            u.U(arrayList0, ((L0)object0).k);
        }
        List list1 = p.P0(p.T0(arrayList0));
        int v = list1.size();
        for(int v2 = 0; v2 < v; ++v2) {
            ((K0)list1.get(v2)).c(this.a);
        }
        int v3 = list0.size();
        for(int v4 = 0; v4 < v3; ++v4) {
            this.a(((L0)list0.get(v4)));
        }
        List list2 = p.P0(list0);
        int v5 = list2.size();
        for(int v1 = 0; v1 < v5; ++v1) {
            L0 l00 = (L0)list2.get(v1);
            if(l00.k.isEmpty()) {
                l00.b();
            }
        }
    }

    public final void d(int v, int v1, t0 t00) {
        synchronized(this.b) {
            kotlin.jvm.internal.q.f(t00.c, "fragmentStateManager.fragment");
            L0 l00 = this.g(t00.c);
            if(l00 == null) {
                l00 = t00.c.mTransitioning || t00.c.mRemoving ? this.h(t00.c) : null;
            }
            if(l00 != null) {
                l00.d(v, v1);
                return;
            }
            goto label_10;
        }
        return;
    label_10:
        L0 l01 = new L0(v, v1, t00);
        this.b.add(l01);
        J0 j00 = new J0(this, l01, 0);
        l01.d.add(j00);
        J0 j01 = new J0(this, l01, 2);
        l01.d.add(j01);
    }

    public final void e() {
        boolean z;
        if(this.f) {
            return;
        }
        if(!this.a.isAttachedToWindow()) {
            this.i();
            this.e = false;
            return;
        }
        ArrayList arrayList0 = this.b;
        __monitor_enter(arrayList0);
        try {
            ArrayList arrayList1 = p.Q0(this.c);
            this.c.clear();
            Iterator iterator0 = arrayList1.iterator();
            while(true) {
                z = true;
                if(!iterator0.hasNext()) {
                    break;
                }
                Object object0 = iterator0.next();
                if(this.b.isEmpty() || !((L0)object0).c.mTransitioning) {
                    z = false;
                }
                ((L0)object0).g = z;
            }
            for(Object object1: arrayList1) {
                L0 l00 = (L0)object1;
                if(this.d) {
                    if(l0.P(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Completing non-seekable operation " + l00);
                    }
                    l00.b();
                }
                else {
                    if(l0.P(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + l00);
                    }
                    l00.a(this.a);
                }
                this.d = false;
                if(!l00.f) {
                    this.c.add(l00);
                }
            }
            if(!this.b.isEmpty()) {
                this.n();
                ArrayList arrayList2 = p.Q0(this.b);
                if(arrayList2.isEmpty()) {
                    goto label_75;
                }
                this.b.clear();
                this.c.addAll(arrayList2);
                if(l0.P(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                }
                this.b(arrayList2, this.e);
                boolean z1 = q.k(arrayList2);
                boolean z2 = true;
                for(Object object2: arrayList2) {
                    if(!((L0)object2).c.mTransitioning) {
                        z2 = false;
                    }
                }
                if(!z2 || z1) {
                    z = false;
                }
                this.d = z;
                if(l0.P(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Operation seekable = " + z1 + " \ntransition = " + z2);
                }
                if(!z2) {
                    this.m(arrayList2);
                    this.c(arrayList2);
                }
                else if(z1) {
                    this.m(arrayList2);
                    int v = arrayList2.size();
                    for(int v1 = 0; v1 < v; ++v1) {
                        this.a(((L0)arrayList2.get(v1)));
                    }
                }
                this.e = false;
                if(l0.P(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                }
            }
            goto label_77;
        }
        catch(Throwable throwable0) {
        }
        __monitor_exit(arrayList0);
        throw throwable0;
    label_75:
        __monitor_exit(arrayList0);
        return;
    label_77:
        __monitor_exit(arrayList0);
    }

    public static void f(f f0, View view0) {
        String s = M.f(view0);
        if(s != null) {
            f0.put(s, view0);
        }
        if(view0 instanceof ViewGroup) {
            int v = ((ViewGroup)view0).getChildCount();
            for(int v1 = 0; v1 < v; ++v1) {
                View view1 = ((ViewGroup)view0).getChildAt(v1);
                if(view1.getVisibility() == 0) {
                    q.f(f0, view1);
                }
            }
        }
    }

    public final L0 g(I i0) {
        for(Object object0: this.b) {
            if(kotlin.jvm.internal.q.b(((L0)object0).c, i0) && !((L0)object0).e) {
                return (L0)object0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    public final L0 h(I i0) {
        for(Object object0: this.c) {
            if(kotlin.jvm.internal.q.b(((L0)object0).c, i0) && !((L0)object0).e) {
                return (L0)object0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    public final void i() {
        if(l0.P(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean z = this.a.isAttachedToWindow();
        synchronized(this.b) {
            this.n();
            this.m(this.b);
            ArrayList arrayList1 = p.Q0(this.c);
            for(Object object0: arrayList1) {
                ((L0)object0).g = false;
            }
            for(Object object1: arrayList1) {
                L0 l00 = (L0)object1;
                if(l0.P(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: " + (z ? "" : "Container " + this.a + " is not attached to window. ") + "Cancelling running operation " + l00);
                }
                l00.a(this.a);
            }
            ArrayList arrayList2 = p.Q0(this.b);
            for(Object object2: arrayList2) {
                ((L0)object2).g = false;
            }
            for(Object object3: arrayList2) {
                L0 l01 = (L0)object3;
                if(l0.P(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: " + (z ? "" : "Container " + this.a + " is not attached to window. ") + "Cancelling pending operation " + l01);
                }
                l01.a(this.a);
            }
        }
    }

    public static final q j(ViewGroup viewGroup0, l0 l00) {
        kotlin.jvm.internal.q.g(viewGroup0, "container");
        kotlin.jvm.internal.q.g(l00, "fragmentManager");
        kotlin.jvm.internal.q.f(l00.N(), "fragmentManager.specialEffectsControllerFactory");
        Object object0 = viewGroup0.getTag(0x7F0A0ACC);  // id:special_effects_controller_view_tag
        if(object0 instanceof q) {
            return (q)object0;
        }
        q q0 = new q(viewGroup0);
        viewGroup0.setTag(0x7F0A0ACC, q0);  // id:special_effects_controller_view_tag
        return q0;
    }

    public static boolean k(ArrayList arrayList0) {
        Iterator iterator1;
        ArrayList arrayList1;
        boolean z;
        Iterator iterator0 = arrayList0.iterator();
        do {
            do {
                z = true;
            label_2:
                if(!iterator0.hasNext()) {
                    goto label_14;
                }
                Object object0 = iterator0.next();
                L0 l00 = (L0)object0;
                if(l00.k.isEmpty()) {
                    z = false;
                    goto label_2;
                }
                arrayList1 = l00.k;
            }
            while(arrayList1 != null && arrayList1.isEmpty());
            iterator1 = arrayList1.iterator();
        label_9:
        }
        while(!iterator1.hasNext());
        Object object1 = iterator1.next();
        if(((K0)object1).a()) {
            goto label_9;
        }
        z = false;
        goto label_2;
    label_14:
        if(z) {
            ArrayList arrayList2 = new ArrayList();
            for(Object object2: arrayList0) {
                u.U(arrayList2, ((L0)object2).k);
            }
            return !arrayList2.isEmpty();
        }
        return false;
    }

    public final void l() {
        Object object0;
        I i0;
        synchronized(this.b) {
            this.n();
            ListIterator listIterator0 = this.b.listIterator(this.b.size());
            do {
                i0 = null;
                if(!listIterator0.hasPrevious()) {
                    goto label_21;
                }
                object0 = listIterator0.previous();
                View view0 = ((L0)object0).c.mView;
                kotlin.jvm.internal.q.f(view0, "operation.fragment.mView");
                int v1 = 4;
                if(Float.compare(view0.getAlpha(), 0.0f) != 0 || view0.getVisibility() != 0) {
                    int v2 = view0.getVisibility();
                    switch(v2) {
                        case 0: {
                            v1 = 2;
                            break;
                        }
                        case 4: {
                            break;
                        }
                        case 8: {
                            v1 = 3;
                            break;
                        }
                        default: {
                            throw new IllegalArgumentException("Unknown visibility " + v2);
                        }
                    }
                }
            }
            while(((L0)object0).a != 2 || v1 == 2);
            goto label_22;
        label_21:
            object0 = null;
        label_22:
            if(((L0)object0) != null) {
                i0 = ((L0)object0).c;
            }
            this.f = i0 == null ? false : i0.isPostponed();
        }
    }

    public final void m(List list0) {
        int v = list0.size();
        for(int v2 = 0; v2 < v; ++v2) {
            L0 l00 = (L0)list0.get(v2);
            t0 t00 = l00.l;
            if(!l00.h) {
                l00.h = true;
                int v3 = l00.b;
                if(v3 == 2) {
                    I i0 = t00.c;
                    kotlin.jvm.internal.q.f(i0, "fragmentStateManager.fragment");
                    View view0 = i0.mView.findFocus();
                    if(view0 != null) {
                        i0.setFocusedView(view0);
                        if(l0.P(2)) {
                            Log.v("FragmentManager", "requestFocus: Saved focused view " + view0 + " for Fragment " + i0);
                        }
                    }
                    View view1 = l00.c.requireView();
                    kotlin.jvm.internal.q.f(view1, "this.fragment.requireView()");
                    if(view1.getParent() == null) {
                        if(l0.P(2)) {
                            Log.v("FragmentManager", "Adding fragment " + i0 + " view " + view1 + " to container in onStart");
                        }
                        t00.b();
                        view1.setAlpha(0.0f);
                    }
                    if(view1.getAlpha() == 0.0f && view1.getVisibility() == 0) {
                        if(l0.P(2)) {
                            Log.v("FragmentManager", "Making view " + view1 + " INVISIBLE in onStart");
                        }
                        view1.setVisibility(4);
                    }
                    view1.setAlpha(i0.getPostOnViewCreatedAlpha());
                    if(l0.P(2)) {
                        Log.v("FragmentManager", "Setting view alpha to " + i0.getPostOnViewCreatedAlpha() + " in onStart");
                    }
                }
                else if(v3 == 3) {
                    I i1 = t00.c;
                    kotlin.jvm.internal.q.f(i1, "fragmentStateManager.fragment");
                    View view2 = i1.requireView();
                    kotlin.jvm.internal.q.f(view2, "fragment.requireView()");
                    if(l0.P(2)) {
                        Log.v("FragmentManager", "Clearing focus " + view2.findFocus() + " on view " + view2 + " for Fragment " + i1);
                    }
                    view2.clearFocus();
                }
            }
        }
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            u.U(arrayList0, ((L0)object0).k);
        }
        List list1 = p.P0(p.T0(arrayList0));
        int v4 = list1.size();
        for(int v1 = 0; v1 < v4; ++v1) {
            K0 k00 = (K0)list1.get(v1);
            k00.getClass();
            ViewGroup viewGroup0 = this.a;
            kotlin.jvm.internal.q.g(viewGroup0, "container");
            if(!k00.a) {
                k00.e(viewGroup0);
            }
            k00.a = true;
        }
    }

    public final void n() {
        for(Object object0: this.b) {
            L0 l00 = (L0)object0;
            int v = 2;
            if(l00.b == 2) {
                View view0 = l00.c.requireView();
                kotlin.jvm.internal.q.f(view0, "fragment.requireView()");
                int v1 = view0.getVisibility();
                switch(v1) {
                    case 0: {
                        break;
                    }
                    case 4: {
                        v = 4;
                        break;
                    }
                    case 8: {
                        v = 3;
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException("Unknown visibility " + v1);
                    }
                }
                l00.d(v, 1);
            }
        }
    }
}

