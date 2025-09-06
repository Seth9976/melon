package androidx.fragment.app;

import A2.d;
import E4.e;
import N1.A;
import N1.B;
import P1.f;
import U4.F;
import U4.x;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.D;
import androidx.lifecycle.q0;
import androidx.lifecycle.r0;
import androidx.lifecycle.s;
import b.t;
import b.u;
import c2.m;
import e.g;
import e.h;
import e.i;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import jeb.synthetic.FIN;
import o9.b;

public abstract class l0 {
    public I A;
    public final b0 B;
    public final c0 C;
    public g D;
    public g E;
    public g F;
    public ArrayDeque G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public ArrayList M;
    public ArrayList N;
    public ArrayList O;
    public o0 P;
    public final r Q;
    public final ArrayList a;
    public boolean b;
    public final v0 c;
    public ArrayList d;
    public ArrayList e;
    public final V f;
    public t g;
    public a h;
    public boolean i;
    public final Z j;
    public final AtomicInteger k;
    public final Map l;
    public final Map m;
    public final Map n;
    public final ArrayList o;
    public final N p;
    public final CopyOnWriteArrayList q;
    public final X r;
    public final X s;
    public final X t;
    public final X u;
    public final a0 v;
    public int w;
    public S x;
    public P y;
    public I z;

    public l0() {
        this.a = new ArrayList();
        this.c = new v0();
        this.d = new ArrayList();
        this.f = new V(this);
        this.h = null;
        this.i = false;
        this.j = new Z(this);
        this.k = new AtomicInteger();
        this.l = Collections.synchronizedMap(new HashMap());
        this.m = Collections.synchronizedMap(new HashMap());
        this.n = Collections.synchronizedMap(new HashMap());
        this.o = new ArrayList();
        this.p = new N(this);
        this.q = new CopyOnWriteArrayList();
        this.r = new X(this, 0);
        this.s = new X(this, 1);
        this.t = new X(this, 2);
        this.u = new X(this, 3);
        this.v = new a0(this);
        this.w = -1;
        this.B = new b0(this);
        this.C = new c0();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.G = new ArrayDeque();
        this.Q = new r(this, 2);
    }

    public final void A(a a0, boolean z) {
        if(z && (this.x == null || this.K)) {
            return;
        }
        this.y(z);
        a a1 = this.h;
        if(a1 != null) {
            a1.s = false;
            a1.j();
            if(l0.P(3)) {
                Log.d("FragmentManager", "Reversing mTransitioningOp " + this.h + " as part of execSingleAction for action " + a0);
            }
            this.h.l(false, false);
            this.h.a(this.M, this.N);
            for(Object object0: this.h.a) {
                I i0 = ((x0)object0).b;
                if(i0 != null) {
                    i0.mTransitioning = false;
                }
            }
            this.h = null;
        }
        a0.a(this.M, this.N);
        this.b = true;
        try {
            this.c0(this.M, this.N);
        }
        finally {
            this.d();
        }
        this.q0();
        v0 v00 = this.c;
        if(this.L) {
            this.L = false;
            for(Object object1: v00.d()) {
                t0 t00 = (t0)object1;
                I i1 = t00.c;
                if(!i1.mDeferStart) {
                }
                else if(this.b) {
                    this.L = true;
                }
                else {
                    i1.mDeferStart = false;
                    t00.k();
                }
            }
        }
        v00.b.values().removeAll(Collections.singleton(null));
    }

    public final void B(ArrayList arrayList0, ArrayList arrayList1, int v, int v1) {
        int v21;
        int v12;
        int v11;
        int v7;
        int v10;
        int v6;
        boolean z = ((a)arrayList0.get(v)).p;
        ArrayList arrayList2 = this.O;
        if(arrayList2 == null) {
            this.O = new ArrayList();
        }
        else {
            arrayList2.clear();
        }
        v0 v00 = this.c;
        this.O.addAll(v00.f());
        I i0 = this.A;
        int v2 = v;
        int v3 = 0;
        while(v2 < v1) {
            a a0 = (a)arrayList0.get(v2);
            if(((Boolean)arrayList1.get(v2)).booleanValue()) {
                v11 = v2;
                v12 = v3;
                ArrayList arrayList5 = this.O;
                ArrayList arrayList6 = a0.a;
                for(int v13 = arrayList6.size() - 1; v13 >= 0; --v13) {
                    x0 x02 = (x0)arrayList6.get(v13);
                    switch(x02.a) {
                        case 3: 
                        case 6: {
                            arrayList5.add(x02.b);
                            break;
                        }
                        case 1: 
                        case 7: {
                            arrayList5.remove(x02.b);
                            break;
                        }
                        case 8: {
                            i0 = null;
                            break;
                        }
                        case 9: {
                            i0 = x02.b;
                            break;
                        }
                        case 10: {
                            x02.i = x02.h;
                        }
                    }
                }
            }
            else {
                ArrayList arrayList3 = this.O;
                ArrayList arrayList4 = a0.a;
                int v4 = 0;
                while(v4 < arrayList4.size()) {
                    x0 x00 = (x0)arrayList4.get(v4);
                    int v5 = x00.a;
                    if(v5 == 1) {
                        v6 = v2;
                    }
                    else {
                        v6 = v2;
                        switch(v5) {
                            case 2: {
                                I i2 = x00.b;
                                int v8 = i2.mContainerId;
                                int v9 = arrayList3.size() - 1;
                                boolean z1 = false;
                                while(v9 >= 0) {
                                    I i3 = (I)arrayList3.get(v9);
                                    if(i3.mContainerId != v8) {
                                        v10 = v8;
                                    }
                                    else if(i3 == i2) {
                                        v10 = v8;
                                        z1 = true;
                                    }
                                    else {
                                        if(i3 == i0) {
                                            v10 = v8;
                                            arrayList4.add(v4, new x0(i3, 9, 0));
                                            ++v4;
                                            i0 = null;
                                        }
                                        else {
                                            v10 = v8;
                                        }
                                        x0 x01 = new x0(i3, 3, 0);
                                        x01.d = x00.d;
                                        x01.f = x00.f;
                                        x01.e = x00.e;
                                        x01.g = x00.g;
                                        arrayList4.add(v4, x01);
                                        arrayList3.remove(i3);
                                        ++v4;
                                    }
                                    --v9;
                                    v8 = v10;
                                }
                                v7 = v3;
                                if(z1) {
                                    arrayList4.remove(v4);
                                    --v4;
                                }
                                else {
                                    x00.a = 1;
                                    x00.c = true;
                                    arrayList3.add(i2);
                                }
                                goto label_82;
                            }
                            case 3: 
                            case 6: {
                                arrayList3.remove(x00.b);
                                I i1 = x00.b;
                                if(i1 == i0) {
                                    arrayList4.add(v4, new x0(i1, 9));
                                    ++v4;
                                    v7 = v3;
                                    i0 = null;
                                    goto label_82;
                                }
                                v7 = v3;
                                goto label_82;
                            }
                            case 7: {
                                break;
                            }
                            case 8: {
                                arrayList4.add(v4, new x0(i0, 9, 0));
                                x00.c = true;
                                ++v4;
                                i0 = x00.b;
                                v7 = v3;
                                goto label_82;
                            }
                            default: {
                                v7 = v3;
                                goto label_82;
                            }
                        }
                    }
                    v7 = v3;
                    arrayList3.add(x00.b);
                label_82:
                    ++v4;
                    v2 = v6;
                    v3 = v7;
                }
                v11 = v2;
                v12 = v3;
            }
            v3 = v12 != 0 || a0.g ? 1 : 0;
            v2 = v11 + 1;
        }
        this.O.clear();
        if(!z && this.w >= 1) {
            for(int v14 = v; v14 < v1; ++v14) {
                for(Object object0: ((a)arrayList0.get(v14)).a) {
                    I i4 = ((x0)object0).b;
                    if(i4 != null && i4.mFragmentManager != null) {
                        v00.g(this.g(i4));
                    }
                }
            }
        }
        int v15 = v;
        while(v15 < v1) {
            a a1 = (a)arrayList0.get(v15);
            if(((Boolean)arrayList1.get(v15)).booleanValue()) {
                a1.i(-1);
                l0 l00 = a1.r;
                ArrayList arrayList7 = a1.a;
                for(int v16 = arrayList7.size() - 1; v16 >= 0; --v16) {
                    x0 x03 = (x0)arrayList7.get(v16);
                    I i5 = x03.b;
                    if(i5 != null) {
                        i5.mBeingSaved = false;
                        i5.setPopDirection(true);
                        int v17 = a1.f;
                        int v18 = 0x2002;
                        switch(v17) {
                            case 0x1001: {
                                i5.setNextTransition(v18);
                                i5.setSharedElementNames(a1.o, a1.n);
                                break;
                            }
                            case 0x2002: {
                                i5.setNextTransition(0x1001);
                                i5.setSharedElementNames(a1.o, a1.n);
                                break;
                            }
                            default: {
                                v18 = 4100;
                                switch(v17) {
                                    case 0x1003: {
                                        v18 = 0x1003;
                                        i5.setNextTransition(v18);
                                        i5.setSharedElementNames(a1.o, a1.n);
                                        break;
                                    }
                                    case 4100: {
                                        v18 = 0x2005;
                                        i5.setNextTransition(v18);
                                        i5.setSharedElementNames(a1.o, a1.n);
                                        break;
                                    }
                                    case 0x2005: {
                                        i5.setNextTransition(v18);
                                        i5.setSharedElementNames(a1.o, a1.n);
                                        break;
                                    }
                                    default: {
                                        v18 = 0;
                                        i5.setNextTransition(v18);
                                        i5.setSharedElementNames(a1.o, a1.n);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    switch(x03.a) {
                        case 1: {
                            i5.setAnimations(x03.d, x03.e, x03.f, x03.g);
                            l00.h0(i5, true);
                            l00.b0(i5);
                            break;
                        }
                        case 3: {
                            i5.setAnimations(x03.d, x03.e, x03.f, x03.g);
                            l00.a(i5);
                            break;
                        }
                        case 4: {
                            i5.setAnimations(x03.d, x03.e, x03.f, x03.g);
                            l00.getClass();
                            l0.n0(i5);
                            break;
                        }
                        case 5: {
                            i5.setAnimations(x03.d, x03.e, x03.f, x03.g);
                            l00.h0(i5, true);
                            l00.O(i5);
                            break;
                        }
                        case 6: {
                            i5.setAnimations(x03.d, x03.e, x03.f, x03.g);
                            l00.c(i5);
                            break;
                        }
                        case 7: {
                            i5.setAnimations(x03.d, x03.e, x03.f, x03.g);
                            l00.h0(i5, true);
                            l00.h(i5);
                            break;
                        }
                        case 8: {
                            l00.l0(null);
                            break;
                        }
                        case 9: {
                            l00.l0(i5);
                            break;
                        }
                        case 10: {
                            l00.k0(i5, x03.h);
                            break;
                        }
                        default: {
                            throw new IllegalArgumentException("Unknown cmd: " + x03.a);
                        }
                    }
                }
            }
            else {
                a1.i(1);
                l0 l01 = a1.r;
                ArrayList arrayList8 = a1.a;
                int v19 = arrayList8.size();
                int v20 = 0;
                while(v20 < v19) {
                    x0 x04 = (x0)arrayList8.get(v20);
                    I i6 = x04.b;
                    if(i6 != null) {
                        i6.mBeingSaved = false;
                        i6.setPopDirection(false);
                        i6.setNextTransition(a1.f);
                        i6.setSharedElementNames(a1.n, a1.o);
                    }
                    switch(x04.a) {
                        case 1: {
                            v21 = v15;
                            i6.setAnimations(x04.d, x04.e, x04.f, x04.g);
                            l01.h0(i6, false);
                            l01.a(i6);
                            ++v20;
                            v15 = v21;
                            continue;
                        }
                        case 3: {
                            v21 = v15;
                            i6.setAnimations(x04.d, x04.e, x04.f, x04.g);
                            l01.b0(i6);
                            ++v20;
                            v15 = v21;
                            continue;
                        }
                        case 4: {
                            v21 = v15;
                            i6.setAnimations(x04.d, x04.e, x04.f, x04.g);
                            l01.O(i6);
                            ++v20;
                            v15 = v21;
                            continue;
                        }
                        case 5: {
                            v21 = v15;
                            i6.setAnimations(x04.d, x04.e, x04.f, x04.g);
                            l01.h0(i6, false);
                            l0.n0(i6);
                            ++v20;
                            v15 = v21;
                            continue;
                        }
                        case 6: {
                            v21 = v15;
                            i6.setAnimations(x04.d, x04.e, x04.f, x04.g);
                            l01.h(i6);
                            ++v20;
                            v15 = v21;
                            continue;
                        }
                        case 7: {
                            v21 = v15;
                            i6.setAnimations(x04.d, x04.e, x04.f, x04.g);
                            l01.h0(i6, false);
                            l01.c(i6);
                            ++v20;
                            v15 = v21;
                            continue;
                        }
                        case 8: {
                            l01.l0(i6);
                            ++v20;
                            continue;
                        }
                        case 9: {
                            l01.l0(null);
                            ++v20;
                            continue;
                        }
                        case 10: {
                            break;
                        }
                        default: {
                            throw new IllegalArgumentException("Unknown cmd: " + x04.a);
                        }
                    }
                    l01.k0(i6, x04.i);
                    ++v20;
                }
            }
            ++v15;
        }
        boolean z2 = ((Boolean)arrayList1.get(v1 - 1)).booleanValue();
        ArrayList arrayList9 = this.o;
        if(v3 != 0 && !arrayList9.isEmpty()) {
            LinkedHashSet linkedHashSet0 = new LinkedHashSet();
            for(Object object1: arrayList0) {
                linkedHashSet0.addAll(l0.H(((a)object1)));
            }
            if(this.h == null) {
                for(Object object2: arrayList9) {
                    h0 h00 = (h0)object2;
                    for(Object object3: linkedHashSet0) {
                        h00.onBackStackChangeStarted(((I)object3), z2);
                    }
                }
                for(Object object4: arrayList9) {
                    h0 h01 = (h0)object4;
                    for(Object object5: linkedHashSet0) {
                        h01.onBackStackChangeCommitted(((I)object5), z2);
                    }
                }
            }
        }
        for(int v22 = v; v22 < v1; ++v22) {
            a a2 = (a)arrayList0.get(v22);
            if(z2) {
                for(int v23 = a2.a.size() - 1; v23 >= 0; --v23) {
                    I i7 = ((x0)a2.a.get(v23)).b;
                    if(i7 != null) {
                        this.g(i7).k();
                    }
                }
            }
            else {
                for(Object object6: a2.a) {
                    I i8 = ((x0)object6).b;
                    if(i8 != null) {
                        this.g(i8).k();
                    }
                }
            }
        }
        this.U(this.w, true);
        for(Object object7: this.f(arrayList0, v, v1)) {
            ((q)object7).e = z2;
            ((q)object7).l();
            ((q)object7).e();
        }
        while(v < v1) {
            a a3 = (a)arrayList0.get(v);
            if(((Boolean)arrayList1.get(v)).booleanValue() && a3.t >= 0) {
                a3.t = -1;
            }
            if(a3.q != null) {
                for(int v24 = 0; v24 < a3.q.size(); ++v24) {
                    ((Runnable)a3.q.get(v24)).run();
                }
                a3.q = null;
            }
            ++v;
        }
        if(v3 != 0) {
            for(int v25 = 0; v25 < arrayList9.size(); ++v25) {
                ((h0)arrayList9.get(v25)).onBackStackChanged();
            }
        }
    }

    public final void C() {
        this.z(true);
        this.G();
    }

    public final I D(int v) {
        v0 v00 = this.c;
        ArrayList arrayList0 = v00.a;
        for(int v1 = arrayList0.size() - 1; v1 >= 0; --v1) {
            I i0 = (I)arrayList0.get(v1);
            if(i0 != null && i0.mFragmentId == v) {
                return i0;
            }
        }
        for(Object object0: v00.b.values()) {
            t0 t00 = (t0)object0;
            if(t00 != null) {
                I i1 = t00.c;
                if(i1.mFragmentId == v) {
                    return i1;
                }
                if(false) {
                    break;
                }
            }
        }
        return null;
    }

    public final I E(String s) {
        v0 v00 = this.c;
        ArrayList arrayList0 = v00.a;
        if(s != null) {
            for(int v = arrayList0.size() - 1; v >= 0; --v) {
                I i0 = (I)arrayList0.get(v);
                if(i0 != null && s.equals(i0.mTag)) {
                    return i0;
                }
            }
        }
        if(s != null) {
            for(Object object0: v00.b.values()) {
                t0 t00 = (t0)object0;
                if(t00 != null) {
                    I i1 = t00.c;
                    if(s.equals(i1.mTag)) {
                        return i1;
                    }
                    if(false) {
                        break;
                    }
                }
            }
        }
        return null;
    }

    public static I F(View view0) {
        while(view0 != null) {
            Object object0 = view0.getTag(0x7F0A04DE);  // id:fragment_container_view_tag
            I i0 = object0 instanceof I ? ((I)object0) : null;
            if(i0 != null) {
                return i0;
            }
            ViewParent viewParent0 = view0.getParent();
            view0 = viewParent0 instanceof View ? ((View)viewParent0) : null;
        }
        return null;
    }

    public final void G() {
        for(Object object0: this.e()) {
            q q0 = (q)object0;
            if(q0.f) {
                if(l0.P(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
                }
                q0.f = false;
                q0.e();
            }
        }
    }

    public static HashSet H(a a0) {
        HashSet hashSet0 = new HashSet();
        for(int v = 0; v < a0.a.size(); ++v) {
            I i0 = ((x0)a0.a.get(v)).b;
            if(i0 != null && a0.g) {
                hashSet0.add(i0);
            }
        }
        return hashSet0;
    }

    public final a I(int v) {
        if(v == this.d.size()) {
            a a0 = this.h;
            if(a0 == null) {
                throw new IndexOutOfBoundsException();
            }
            return a0;
        }
        return (a)this.d.get(v);
    }

    public final int J() {
        int v = this.d.size();
        return this.h == null ? v : v + 1;
    }

    public final I K(Bundle bundle0, String s) {
        String s1 = bundle0.getString(s);
        if(s1 == null) {
            return null;
        }
        I i0 = this.c.b(s1);
        if(i0 != null) {
            return i0;
        }
        this.o0(new IllegalStateException("Fragment no longer exists for key " + s + ": unique id " + s1));
        throw null;
    }

    public final ViewGroup L(I i0) {
        ViewGroup viewGroup0 = i0.mContainer;
        if(viewGroup0 != null) {
            return viewGroup0;
        }
        if(i0.mContainerId > 0 && this.y.c()) {
            View view0 = this.y.b(i0.mContainerId);
            return view0 instanceof ViewGroup ? ((ViewGroup)view0) : null;
        }
        return null;
    }

    public final b0 M() {
        return this.z == null ? this.B : this.z.mFragmentManager.M();
    }

    public final c0 N() {
        return this.z == null ? this.C : this.z.mFragmentManager.N();
    }

    public final void O(I i0) {
        if(l0.P(2)) {
            Log.v("FragmentManager", "hide: " + i0);
        }
        if(!i0.mHidden) {
            i0.mHidden = true;
            i0.mHiddenChanged ^= true;
            this.m0(i0);
        }
    }

    public static boolean P(int v) {
        return Log.isLoggable("FragmentManager", v);
    }

    public static boolean Q(I i0) {
        if(!i0.mHasMenu || !i0.mMenuVisible) {
            boolean z = false;
            for(Object object0: i0.mChildFragmentManager.c.e()) {
                I i1 = (I)object0;
                if(i1 != null) {
                    z = l0.Q(i1);
                }
                if(!z) {
                    continue;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    // 去混淆评级： 低(30)
    public final boolean R() {
        return this.z == null ? true : this.z.isAdded() && this.z.getParentFragmentManager().R();
    }

    public static boolean S(I i0) {
        if(i0 != null) {
            l0 l00 = i0.mFragmentManager;
            return i0.equals(l00.A) && l0.S(l00.z);
        }
        return true;
    }

    // 去混淆评级： 低(20)
    public final boolean T() {
        return this.I || this.J;
    }

    public final void U(int v, boolean z) {
        if(this.x == null && v != -1) {
            throw new IllegalStateException("No activity");
        }
        if(z || v != this.w) {
            this.w = v;
            v0 v00 = this.c;
            HashMap hashMap0 = v00.b;
            for(Object object0: v00.a) {
                t0 t00 = (t0)hashMap0.get(((I)object0).mWho);
                if(t00 != null) {
                    t00.k();
                }
            }
            for(Object object1: hashMap0.values()) {
                t0 t01 = (t0)object1;
                if(t01 != null) {
                    t01.k();
                    I i0 = t01.c;
                    if(i0.mRemoving && !i0.isInBackStack()) {
                        if(i0.mBeingSaved && !v00.c.containsKey(i0.mWho)) {
                            String s = i0.mWho;
                            v00.i(t01.n(), s);
                        }
                        v00.h(t01);
                    }
                }
            }
            for(Object object2: v00.d()) {
                t0 t02 = (t0)object2;
                I i1 = t02.c;
                if(!i1.mDeferStart) {
                }
                else if(this.b) {
                    this.L = true;
                }
                else {
                    i1.mDeferStart = false;
                    t02.k();
                }
            }
            if(this.H) {
                S s1 = this.x;
                if(s1 != null && this.w == 7) {
                    ((M)s1).e.invalidateMenu();
                    this.H = false;
                }
            }
        }
    }

    public final void V() {
        if(this.x != null) {
            this.I = false;
            this.J = false;
            this.P.f = false;
            for(Object object0: this.c.f()) {
                I i0 = (I)object0;
                if(i0 != null) {
                    i0.noteStateNotSaved();
                }
            }
        }
    }

    public final void W(int v) {
        if(v < 0) {
            throw new IllegalArgumentException("Bad id: " + v);
        }
        this.Y(v, 1);
    }

    public final boolean X() {
        return this.Y(-1, 0);
    }

    public final boolean Y(int v, int v1) {
        this.z(false);
        this.y(true);
        if(this.A != null && v < 0 && this.A.getChildFragmentManager().X()) {
            return true;
        }
        boolean z = this.Z(this.M, this.N, v, v1);
        if(z) {
            try {
                this.b = true;
                this.c0(this.M, this.N);
            }
            finally {
                this.d();
            }
        }
        this.q0();
        v0 v00 = this.c;
        if(this.L) {
            this.L = false;
            for(Object object0: v00.d()) {
                t0 t00 = (t0)object0;
                I i0 = t00.c;
                if(!i0.mDeferStart) {
                }
                else if(this.b) {
                    this.L = true;
                }
                else {
                    i0.mDeferStart = false;
                    t00.k();
                }
            }
        }
        v00.b.values().removeAll(Collections.singleton(null));
        return z;
    }

    public final boolean Z(ArrayList arrayList0, ArrayList arrayList1, int v, int v1) {
        boolean z = (v1 & 1) != 0;
        int v2 = -1;
        if(!this.d.isEmpty()) {
            if(v >= 0) {
                int v3;
                for(v3 = this.d.size() - 1; v3 >= 0 && (v < 0 || v != ((a)this.d.get(v3)).t); --v3) {
                }
                if(v3 < 0) {
                    v2 = v3;
                }
                else if(z) {
                    for(v2 = v3; v2 > 0 && (v >= 0 && v == ((a)this.d.get(v2 - 1)).t); --v2) {
                    }
                }
                else if(v3 != this.d.size() - 1) {
                    v2 = v3 + 1;
                }
            }
            else if(z) {
                v2 = 0;
            }
            else {
                v2 = this.d.size() - 1;
            }
        }
        if(v2 < 0) {
            return false;
        }
        for(int v4 = this.d.size() - 1; v4 >= v2; --v4) {
            arrayList0.add(((a)this.d.remove(v4)));
            arrayList1.add(Boolean.TRUE);
        }
        return true;
    }

    public final t0 a(I i0) {
        String s = i0.mPreviousWho;
        if(s != null) {
            d.c(i0, s);
        }
        if(l0.P(2)) {
            Log.v("FragmentManager", "add: " + i0);
        }
        t0 t00 = this.g(i0);
        i0.mFragmentManager = this;
        v0 v00 = this.c;
        v00.g(t00);
        if(!i0.mDetached) {
            v00.a(i0);
            i0.mRemoving = false;
            if(i0.mView == null) {
                i0.mHiddenChanged = false;
            }
            if(l0.Q(i0)) {
                this.H = true;
            }
        }
        return t00;
    }

    public final void a0(Bundle bundle0, String s, I i0) {
        if(i0.mFragmentManager == this) {
            bundle0.putString(s, i0.mWho);
            return;
        }
        this.o0(new IllegalStateException("Fragment " + i0 + " is not currently in the FragmentManager"));
        throw null;
    }

    public final void b(S s0, P p0, I i0) {
        if(this.x != null) {
            throw new IllegalStateException("Already attached");
        }
        this.x = s0;
        this.y = p0;
        this.z = i0;
        CopyOnWriteArrayList copyOnWriteArrayList0 = this.q;
        if(i0 != null) {
            copyOnWriteArrayList0.add(new e0(i0));
        }
        else if(s0 instanceof p0) {
            copyOnWriteArrayList0.add(((p0)s0));
        }
        if(this.z != null) {
            this.q0();
        }
        if(s0 instanceof u) {
            u u0 = (u)s0;
            t t0 = u0.getOnBackPressedDispatcher();
            this.g = t0;
            if(i0 != null) {
                u0 = i0;
            }
            t0.a(u0, this.j);
        }
        if(i0 != null) {
            o0 o00 = i0.mFragmentManager.P;
            HashMap hashMap0 = o00.b;
            o0 o01 = (o0)hashMap0.get(i0.mWho);
            if(o01 == null) {
                o01 = new o0(o00.d);
                hashMap0.put(i0.mWho, o01);
            }
            this.P = o01;
        }
        else if(s0 instanceof r0) {
            q0 q00 = ((r0)s0).getViewModelStore();
            kotlin.jvm.internal.q.g(q00, "store");
            kotlin.jvm.internal.q.g(S2.a.b, "defaultCreationExtras");
            b b0 = new b(q00, o0.g, S2.a.b);
            De.d d0 = df.d.y(o0.class);
            String s1 = d0.l();
            if(s1 == null) {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            this.P = (o0)b0.s(d0, "androidx.lifecycle.ViewModelProvider.DefaultKey:" + s1);
        }
        else {
            this.P = new o0(false);
        }
        this.P.f = this.T();
        this.c.d = this.P;
        S s2 = this.x;
        if(s2 instanceof E4.g && i0 == null) {
            e e0 = ((E4.g)s2).getSavedStateRegistry();
            e0.c("android:support:fragments", new J(this, 1));
            Bundle bundle0 = e0.a("android:support:fragments");
            if(bundle0 != null) {
                this.d0(bundle0);
            }
        }
        S s3 = this.x;
        if(s3 instanceof i) {
            h h0 = ((i)s3).getActivityResultRegistry();
            String s4 = i0 == null ? "" : x.m(new StringBuilder(), i0.mWho, ":");
            this.D = h0.d("FragmentManager:" + s4 + "StartActivityForResult", new f0(2), new Y(this, 1));
            this.E = h0.d("FragmentManager:" + s4 + "StartIntentSenderForResult", new f0(0), new Y(this, 2));
            this.F = h0.d("FragmentManager:" + s4 + "RequestPermissions", new f0(1), new Y(this, 0));
        }
        S s5 = this.x;
        if(s5 instanceof f) {
            ((f)s5).addOnConfigurationChangedListener(this.r);
        }
        S s6 = this.x;
        if(s6 instanceof P1.g) {
            ((P1.g)s6).addOnTrimMemoryListener(this.s);
        }
        S s7 = this.x;
        if(s7 instanceof A) {
            ((A)s7).addOnMultiWindowModeChangedListener(this.t);
        }
        S s8 = this.x;
        if(s8 instanceof B) {
            ((B)s8).addOnPictureInPictureModeChangedListener(this.u);
        }
        S s9 = this.x;
        if(s9 instanceof m && i0 == null) {
            ((m)s9).addMenuProvider(this.v);
        }
    }

    public final void b0(I i0) {
        if(l0.P(2)) {
            Log.v("FragmentManager", "remove: " + i0 + " nesting=" + i0.mBackStackNesting);
        }
        boolean z = i0.isInBackStack();
        if(i0.mDetached && z) {
            return;
        }
        synchronized(this.c.a) {
            this.c.a.remove(i0);
        }
        i0.mAdded = false;
        if(l0.Q(i0)) {
            this.H = true;
        }
        i0.mRemoving = true;
        this.m0(i0);
    }

    public final void c(I i0) {
        if(l0.P(2)) {
            Log.v("FragmentManager", "attach: " + i0);
        }
        if(i0.mDetached) {
            i0.mDetached = false;
            if(!i0.mAdded) {
                this.c.a(i0);
                if(l0.P(2)) {
                    Log.v("FragmentManager", "add from attach: " + i0);
                }
                if(l0.Q(i0)) {
                    this.H = true;
                }
            }
        }
    }

    public final void c0(ArrayList arrayList0, ArrayList arrayList1) {
        if(!arrayList0.isEmpty()) {
            if(arrayList0.size() != arrayList1.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            int v = arrayList0.size();
            int v2 = 0;
            for(int v1 = 0; v1 < v; ++v1) {
                if(!((a)arrayList0.get(v1)).p) {
                    if(v2 != v1) {
                        this.B(arrayList0, arrayList1, v2, v1);
                    }
                    v2 = v1 + 1;
                    if(((Boolean)arrayList1.get(v1)).booleanValue()) {
                        while(v2 < v && ((Boolean)arrayList1.get(v2)).booleanValue() && !((a)arrayList0.get(v2)).p) {
                            ++v2;
                        }
                    }
                    this.B(arrayList0, arrayList1, v1, v2);
                    v1 = v2 - 1;
                }
            }
            if(v2 != v) {
                this.B(arrayList0, arrayList1, v2, v);
            }
        }
    }

    public final void d() {
        this.b = false;
        this.N.clear();
        this.M.clear();
    }

    public final void d0(Bundle bundle0) {
        t0 t00;
        N n0;
        for(Object object0: bundle0.keySet()) {
            String s = (String)object0;
            if(s.startsWith("result_")) {
                Bundle bundle1 = bundle0.getBundle(s);
                if(bundle1 != null) {
                    bundle1.setClassLoader(this.x.b.getClassLoader());
                    this.m.put(s.substring(7), bundle1);
                }
            }
        }
        HashMap hashMap0 = new HashMap();
        for(Object object1: bundle0.keySet()) {
            String s1 = (String)object1;
            if(s1.startsWith("fragment_")) {
                Bundle bundle2 = bundle0.getBundle(s1);
                if(bundle2 != null) {
                    bundle2.setClassLoader(this.x.b.getClassLoader());
                    hashMap0.put(s1.substring(9), bundle2);
                }
            }
        }
        v0 v00 = this.c;
        HashMap hashMap1 = v00.b;
        v00.c.clear();
        v00.c.putAll(hashMap0);
        FragmentManagerState fragmentManagerState0 = (FragmentManagerState)bundle0.getParcelable("state");
        if(fragmentManagerState0 == null) {
            return;
        }
        hashMap1.clear();
        Iterator iterator2 = fragmentManagerState0.a.iterator();
        while(true) {
            boolean z = iterator2.hasNext();
            n0 = this.p;
            if(!z) {
                break;
            }
            Object object2 = iterator2.next();
            Bundle bundle3 = v00.i(null, ((String)object2));
            if(bundle3 != null) {
                FragmentState fragmentState0 = (FragmentState)bundle3.getParcelable("state");
                I i0 = (I)this.P.a.get(fragmentState0.b);
                if(i0 == null) {
                    ClassLoader classLoader0 = this.x.b.getClassLoader();
                    b0 b00 = this.M();
                    t00 = new t0(this.p, this.c, classLoader0, b00, bundle3);
                }
                else {
                    if(l0.P(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + i0);
                    }
                    t00 = new t0(n0, v00, i0, bundle3);
                }
                I i1 = t00.c;
                i1.mSavedFragmentState = bundle3;
                i1.mFragmentManager = this;
                if(l0.P(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + i1.mWho + "): " + i1);
                }
                t00.l(this.x.b.getClassLoader());
                v00.g(t00);
                t00.e = this.w;
            }
        }
        o0 o00 = this.P;
        o00.getClass();
        for(Object object3: new ArrayList(o00.a.values())) {
            I i2 = (I)object3;
            if(hashMap1.get(i2.mWho) == null) {
                if(l0.P(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + i2 + " that was not found in the set of active Fragments " + fragmentManagerState0.a);
                }
                this.P.f(i2);
                i2.mFragmentManager = this;
                t0 t01 = new t0(n0, v00, i2);
                t01.e = 1;
                t01.k();
                i2.mRemoving = true;
                t01.k();
            }
        }
        ArrayList arrayList0 = fragmentManagerState0.b;
        v00.a.clear();
        if(arrayList0 != null) {
            for(Object object4: arrayList0) {
                String s2 = (String)object4;
                I i3 = v00.b(s2);
                if(i3 == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + s2 + ")");
                }
                if(l0.P(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + s2 + "): " + i3);
                }
                v00.a(i3);
            }
        }
        if(fragmentManagerState0.c == null) {
            this.d = new ArrayList();
        }
        else {
            this.d = new ArrayList(fragmentManagerState0.c.length);
            for(int v = 0; true; ++v) {
                BackStackRecordState[] arr_backStackRecordState = fragmentManagerState0.c;
                if(v >= arr_backStackRecordState.length) {
                    break;
                }
                BackStackRecordState backStackRecordState0 = arr_backStackRecordState[v];
                ArrayList arrayList1 = backStackRecordState0.b;
                a a0 = new a(this);
                int[] arr_v = backStackRecordState0.a;
                int v1 = 0;
                for(int v2 = 0; v1 < arr_v.length; ++v2) {
                    x0 x00 = new x0();  // 初始化器: Ljava/lang/Object;-><init>()V
                    x00.a = arr_v[v1];
                    if(l0.P(2)) {
                        Log.v("FragmentManager", "Instantiate " + a0 + " op #" + v2 + " base fragment #" + arr_v[v1 + 1]);
                    }
                    s[] arr_s = s.values();
                    x00.h = arr_s[backStackRecordState0.c[v2]];
                    s[] arr_s1 = s.values();
                    x00.i = arr_s1[backStackRecordState0.d[v2]];
                    x00.c = arr_v[v1 + 1] != 0;
                    int v3 = arr_v[v1 + 2];
                    x00.d = v3;
                    int v4 = arr_v[v1 + 3];
                    x00.e = v4;
                    int v5 = v1 + 5;
                    int v6 = arr_v[v1 + 4];
                    x00.f = v6;
                    v1 += 6;
                    int v7 = arr_v[v5];
                    x00.g = v7;
                    a0.b = v3;
                    a0.c = v4;
                    a0.d = v6;
                    a0.e = v7;
                    a0.b(x00);
                }
                a0.f = backStackRecordState0.e;
                a0.i = backStackRecordState0.f;
                a0.g = true;
                a0.j = backStackRecordState0.h;
                a0.k = backStackRecordState0.i;
                a0.l = backStackRecordState0.j;
                a0.m = backStackRecordState0.k;
                a0.n = backStackRecordState0.l;
                a0.o = backStackRecordState0.m;
                a0.p = backStackRecordState0.n;
                a0.t = backStackRecordState0.g;
                for(int v8 = 0; v8 < arrayList1.size(); ++v8) {
                    String s3 = (String)arrayList1.get(v8);
                    if(s3 != null) {
                        x0 x01 = (x0)a0.a.get(v8);
                        x01.b = v00.b(s3);
                    }
                }
                a0.i(1);
                if(l0.P(2)) {
                    StringBuilder stringBuilder0 = x.n(v, "restoreAllState: back stack #", " (index ");
                    stringBuilder0.append(a0.t);
                    stringBuilder0.append("): ");
                    stringBuilder0.append(a0);
                    Log.v("FragmentManager", stringBuilder0.toString());
                    PrintWriter printWriter0 = new PrintWriter(new I0());
                    a0.n("  ", printWriter0, false);
                    printWriter0.close();
                }
                this.d.add(a0);
            }
        }
        this.k.set(fragmentManagerState0.d);
        String s4 = fragmentManagerState0.e;
        if(s4 != null) {
            I i4 = v00.b(s4);
            this.A = i4;
            this.r(i4);
        }
        ArrayList arrayList2 = fragmentManagerState0.f;
        if(arrayList2 != null) {
            for(int v9 = 0; v9 < arrayList2.size(); ++v9) {
                String s5 = (String)arrayList2.get(v9);
                BackStackState backStackState0 = (BackStackState)fragmentManagerState0.g.get(v9);
                this.l.put(s5, backStackState0);
            }
        }
        this.G = new ArrayDeque(fragmentManagerState0.h);
    }

    public final HashSet e() {
        q q0;
        HashSet hashSet0 = new HashSet();
        for(Object object0: this.c.d()) {
            ViewGroup viewGroup0 = ((t0)object0).c.mContainer;
            if(viewGroup0 != null) {
                kotlin.jvm.internal.q.g(this.N(), "factory");
                Object object1 = viewGroup0.getTag(0x7F0A0ACC);  // id:special_effects_controller_view_tag
                if(object1 instanceof q) {
                    q0 = (q)object1;
                }
                else {
                    q0 = new q(viewGroup0);
                    viewGroup0.setTag(0x7F0A0ACC, q0);  // id:special_effects_controller_view_tag
                }
                hashSet0.add(q0);
            }
        }
        return hashSet0;
    }

    public final Bundle e0() {
        BackStackRecordState[] arr_backStackRecordState;
        ArrayList arrayList2;
        Bundle bundle0 = new Bundle();
        this.G();
        this.w();
        this.z(true);
        this.I = true;
        this.P.f = true;
        v0 v00 = this.c;
        v00.getClass();
        ArrayList arrayList0 = new ArrayList(v00.b.size());
        for(Object object0: v00.b.values()) {
            t0 t00 = (t0)object0;
            if(t00 != null) {
                I i0 = t00.c;
                String s = i0.mWho;
                v00.i(t00.n(), s);
                arrayList0.add(i0.mWho);
                if(l0.P(2)) {
                    Log.v("FragmentManager", "Saved state of " + i0 + ": " + i0.mSavedFragmentState);
                }
            }
        }
        HashMap hashMap0 = this.c.c;
        if(!hashMap0.isEmpty()) {
            v0 v01 = this.c;
            synchronized(v01.a) {
                if(v01.a.isEmpty()) {
                    goto label_41;
                }
                else {
                    arrayList2 = new ArrayList(v01.a.size());
                    for(Object object1: v01.a) {
                        I i1 = (I)object1;
                        arrayList2.add(i1.mWho);
                        if(l0.P(2)) {
                            Log.v("FragmentManager", "saveAllState: adding fragment (" + i1.mWho + "): " + i1);
                        }
                    }
                }
            }
            goto label_47;
        label_41:
            arrayList2 = null;
        label_47:
            int v = this.d.size();
            if(v > 0) {
                arr_backStackRecordState = new BackStackRecordState[v];
                for(int v1 = 0; v1 < v; ++v1) {
                    arr_backStackRecordState[v1] = new BackStackRecordState(((a)this.d.get(v1)));
                    if(l0.P(2)) {
                        StringBuilder stringBuilder0 = x.n(v1, "saveAllState: adding back stack #", ": ");
                        stringBuilder0.append(this.d.get(v1));
                        Log.v("FragmentManager", stringBuilder0.toString());
                    }
                }
            }
            else {
                arr_backStackRecordState = null;
            }
            FragmentManagerState fragmentManagerState0 = new FragmentManagerState();  // 初始化器: Ljava/lang/Object;-><init>()V
            fragmentManagerState0.e = null;
            ArrayList arrayList3 = new ArrayList();
            fragmentManagerState0.f = arrayList3;
            ArrayList arrayList4 = new ArrayList();
            fragmentManagerState0.g = arrayList4;
            fragmentManagerState0.a = arrayList0;
            fragmentManagerState0.b = arrayList2;
            fragmentManagerState0.c = arr_backStackRecordState;
            fragmentManagerState0.d = this.k.get();
            I i2 = this.A;
            if(i2 != null) {
                fragmentManagerState0.e = i2.mWho;
            }
            arrayList3.addAll(this.l.keySet());
            arrayList4.addAll(this.l.values());
            fragmentManagerState0.h = new ArrayList(this.G);
            bundle0.putParcelable("state", fragmentManagerState0);
            for(Object object2: this.m.keySet()) {
                bundle0.putBundle(va.e.b("result_", ((String)object2)), ((Bundle)this.m.get(((String)object2))));
            }
            for(Object object3: hashMap0.keySet()) {
                bundle0.putBundle(va.e.b("fragment_", ((String)object3)), ((Bundle)hashMap0.get(((String)object3))));
            }
        }
        else if(l0.P(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return bundle0;
        }
        return bundle0;
    }

    public final HashSet f(ArrayList arrayList0, int v, int v1) {
        HashSet hashSet0 = new HashSet();
        while(v < v1) {
            for(Object object0: ((a)arrayList0.get(v)).a) {
                I i0 = ((x0)object0).b;
                if(i0 != null) {
                    ViewGroup viewGroup0 = i0.mContainer;
                    if(viewGroup0 != null) {
                        hashSet0.add(q.j(viewGroup0, this));
                    }
                }
            }
            ++v;
        }
        return hashSet0;
    }

    public final Fragment.SavedState f0(I i0) {
        t0 t00 = (t0)this.c.b.get(i0.mWho);
        if(t00 != null) {
            I i1 = t00.c;
            if(i1.equals(i0)) {
                return i1.mState <= -1 ? null : new Fragment.SavedState(t00.n());
            }
        }
        this.o0(new IllegalStateException("Fragment " + i0 + " is not currently in the FragmentManager"));
        throw null;
    }

    public final t0 g(I i0) {
        v0 v00 = this.c;
        t0 t00 = (t0)v00.b.get(i0.mWho);
        if(t00 != null) {
            return t00;
        }
        t0 t01 = new t0(this.p, v00, i0);
        t01.l(this.x.b.getClassLoader());
        t01.e = this.w;
        return t01;
    }

    public final void g0() {
        synchronized(this.a) {
            if(this.a.size() == 1) {
                this.x.c.removeCallbacks(this.Q);
                this.x.c.post(this.Q);
                this.q0();
            }
        }
    }

    public final void h(I i0) {
        if(l0.P(2)) {
            Log.v("FragmentManager", "detach: " + i0);
        }
        if(!i0.mDetached) {
            i0.mDetached = true;
            if(i0.mAdded) {
                if(l0.P(2)) {
                    Log.v("FragmentManager", "remove from detach: " + i0);
                }
                synchronized(this.c.a) {
                    this.c.a.remove(i0);
                }
                i0.mAdded = false;
                if(l0.Q(i0)) {
                    this.H = true;
                }
                this.m0(i0);
            }
        }
    }

    public final void h0(I i0, boolean z) {
        ViewGroup viewGroup0 = this.L(i0);
        if(viewGroup0 != null && viewGroup0 instanceof FragmentContainerView) {
            ((FragmentContainerView)viewGroup0).setDrawDisappearingViewsLast(!z);
        }
    }

    public final void i(boolean z, Configuration configuration0) {
        if(z && this.x instanceof f) {
            this.o0(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
            throw null;
        }
        for(Object object0: this.c.f()) {
            I i0 = (I)object0;
            if(i0 != null) {
                i0.performConfigurationChanged(configuration0);
                if(z) {
                    i0.mChildFragmentManager.i(true, configuration0);
                }
            }
        }
    }

    public final void i0(Bundle bundle0, String s) {
        g0 g00 = (g0)this.n.get(s);
        if(g00 == null || g00.a.b().compareTo(s.d) < 0) {
            this.m.put(s, bundle0);
        }
        else {
            g00.b(bundle0, s);
        }
        if(l0.P(2)) {
            Log.v("FragmentManager", "Setting fragment result with key " + s + " and result " + bundle0);
        }
    }

    public final boolean j(MenuItem menuItem0) {
        if(this.w < 1) {
            return false;
        }
        for(Object object0: this.c.f()) {
            if(((I)object0) != null && ((I)object0).performContextItemSelected(menuItem0)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    public final void j0(String s, D d0, androidx.fragment.app.r0 r00) {
        androidx.lifecycle.t t0 = d0.getLifecycle();
        if(t0.b() == s.a) {
            return;
        }
        d0 d00 = new d0(this, s, r00, t0);
        g0 g00 = new g0(t0, r00, d00);
        g0 g01 = (g0)this.n.put(s, g00);
        if(g01 != null) {
            g01.a.c(g01.c);
        }
        if(l0.P(2)) {
            Log.v("FragmentManager", "Setting FragmentResultListener with key " + s + " lifecycleOwner " + t0 + " and listener " + r00);
        }
        t0.a(d00);
    }

    public final boolean k(Menu menu0, MenuInflater menuInflater0) {
        if(this.w < 1) {
            return false;
        }
        ArrayList arrayList0 = null;
        boolean z = false;
        for(Object object0: this.c.f()) {
            I i0 = (I)object0;
            if(i0 != null && i0.isMenuVisible() && i0.performCreateOptionsMenu(menu0, menuInflater0)) {
                if(arrayList0 == null) {
                    arrayList0 = new ArrayList();
                }
                arrayList0.add(i0);
                z = true;
            }
        }
        if(this.e != null) {
            for(int v = 0; v < this.e.size(); ++v) {
                boolean z1 = arrayList0 != null && arrayList0.contains(((I)this.e.get(v)));
            }
        }
        this.e = arrayList0;
        return z;
    }

    public final void k0(I i0, s s0) {
        if(!i0.equals(this.c.b(i0.mWho)) || i0.mHost != null && i0.mFragmentManager != this) {
            throw new IllegalArgumentException("Fragment " + i0 + " is not an active fragment of FragmentManager " + this);
        }
        i0.mMaxState = s0;
    }

    public final void l() {
        boolean z = true;
        this.K = true;
        this.z(true);
        this.w();
        S s0 = this.x;
        v0 v00 = this.c;
        if(s0 instanceof r0) {
            z = v00.d.e;
        }
        else {
            FragmentActivity fragmentActivity0 = s0.b;
            if(fragmentActivity0 != null) {
                z = true ^ fragmentActivity0.isChangingConfigurations();
            }
        }
        if(z) {
            for(Object object0: this.l.values()) {
                for(Object object1: ((BackStackState)object0).a) {
                    v00.d.d(((String)object1), false);
                }
            }
        }
        this.u(-1);
        S s1 = this.x;
        if(s1 instanceof P1.g) {
            ((P1.g)s1).removeOnTrimMemoryListener(this.s);
        }
        S s2 = this.x;
        if(s2 instanceof f) {
            ((f)s2).removeOnConfigurationChangedListener(this.r);
        }
        S s3 = this.x;
        if(s3 instanceof A) {
            ((A)s3).removeOnMultiWindowModeChangedListener(this.t);
        }
        S s4 = this.x;
        if(s4 instanceof B) {
            ((B)s4).removeOnPictureInPictureModeChangedListener(this.u);
        }
        S s5 = this.x;
        if(s5 instanceof m && this.z == null) {
            ((m)s5).removeMenuProvider(this.v);
        }
        this.x = null;
        this.y = null;
        this.z = null;
        if(this.g != null) {
            this.j.remove();
            this.g = null;
        }
        g g0 = this.D;
        if(g0 != null) {
            g0.c();
            this.E.c();
            this.F.c();
        }
    }

    public final void l0(I i0) {
        if(i0 != null && (!i0.equals(this.c.b(i0.mWho)) || i0.mHost != null && i0.mFragmentManager != this)) {
            throw new IllegalArgumentException("Fragment " + i0 + " is not an active fragment of FragmentManager " + this);
        }
        I i1 = this.A;
        this.A = i0;
        this.r(i1);
        this.r(this.A);
    }

    public final void m(boolean z) {
        if(z && this.x instanceof P1.g) {
            this.o0(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
            throw null;
        }
        for(Object object0: this.c.f()) {
            I i0 = (I)object0;
            if(i0 != null) {
                i0.performLowMemory();
                if(z) {
                    i0.mChildFragmentManager.m(true);
                }
            }
        }
    }

    public final void m0(I i0) {
        ViewGroup viewGroup0 = this.L(i0);
        if(viewGroup0 != null && i0.getPopExitAnim() + (i0.getPopEnterAnim() + (i0.getExitAnim() + i0.getEnterAnim())) > 0) {
            if(viewGroup0.getTag(0x7F0A0DD8) == null) {  // id:visible_removing_fragment_view_tag
                viewGroup0.setTag(0x7F0A0DD8, i0);  // id:visible_removing_fragment_view_tag
            }
            ((I)viewGroup0.getTag(0x7F0A0DD8)).setPopDirection(i0.getPopDirection());  // id:visible_removing_fragment_view_tag
        }
    }

    public final void n(boolean z, boolean z1) {
        if(z1 && this.x instanceof A) {
            this.o0(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
            throw null;
        }
        for(Object object0: this.c.f()) {
            I i0 = (I)object0;
            if(i0 != null && z1) {
                i0.mChildFragmentManager.n(z, true);
            }
        }
    }

    public static void n0(I i0) {
        if(l0.P(2)) {
            Log.v("FragmentManager", "show: " + i0);
        }
        if(i0.mHidden) {
            i0.mHidden = false;
            i0.mHiddenChanged = !i0.mHiddenChanged;
        }
    }

    public final void o() {
        for(Object object0: this.c.e()) {
            I i0 = (I)object0;
            if(i0 != null) {
                i0.onHiddenChanged(i0.isHidden());
                i0.mChildFragmentManager.o();
            }
        }
    }

    public final void o0(IllegalStateException illegalStateException0) {
        Log.e("FragmentManager", illegalStateException0.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter0 = new PrintWriter(new I0());
        S s0 = this.x;
        if(s0 == null) {
            try {
                this.v("  ", null, printWriter0, new String[0]);
            }
            catch(Exception exception1) {
                Log.e("FragmentManager", "Failed dumping state", exception1);
            }
        }
        else {
            try {
                ((M)s0).e.dump("  ", null, printWriter0, new String[0]);
            }
            catch(Exception exception0) {
                Log.e("FragmentManager", "Failed dumping state", exception0);
            }
        }
        throw illegalStateException0;
    }

    public final boolean p(MenuItem menuItem0) {
        if(this.w < 1) {
            return false;
        }
        for(Object object0: this.c.f()) {
            if(((I)object0) != null && ((I)object0).performOptionsItemSelected(menuItem0)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    public final void p0(F f0) {
        N n0 = this.p;
        n0.getClass();
        synchronized(((CopyOnWriteArrayList)n0.b)) {
            int v1 = ((CopyOnWriteArrayList)n0.b).size();
            for(int v2 = 0; v2 < v1; ++v2) {
                if(((W)((CopyOnWriteArrayList)n0.b).get(v2)).a == f0) {
                    ((CopyOnWriteArrayList)n0.b).remove(v2);
                    break;
                }
            }
        }
    }

    public final void q(Menu menu0) {
        if(this.w >= 1) {
            for(Object object0: this.c.f()) {
                I i0 = (I)object0;
                if(i0 != null) {
                    i0.performOptionsMenuClosed(menu0);
                }
            }
        }
    }

    public final void q0() {
        boolean z = true;
        synchronized(this.a) {
            if(!this.a.isEmpty()) {
                this.j.setEnabled(true);
                if(l0.P(3)) {
                    Log.d("FragmentManager", "FragmentManager " + this + " enabling OnBackPressedCallback, caused by non-empty pending actions");
                }
                return;
            }
        }
        if(this.J() <= 0 || !l0.S(this.z)) {
            z = false;
        }
        if(l0.P(3)) {
            Log.d("FragmentManager", "OnBackPressedCallback for FragmentManager " + this + " enabled state is " + z);
        }
        this.j.setEnabled(z);
    }

    public final void r(I i0) {
        if(i0 != null && i0.equals(this.c.b(i0.mWho))) {
            i0.performPrimaryNavigationFragmentChanged();
        }
    }

    public final void s(boolean z, boolean z1) {
        if(z1 && this.x instanceof B) {
            this.o0(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
            throw null;
        }
        for(Object object0: this.c.f()) {
            I i0 = (I)object0;
            if(i0 != null) {
                i0.performPictureInPictureModeChanged(z);
                if(z1) {
                    i0.mChildFragmentManager.s(z, true);
                }
            }
        }
    }

    public final boolean t(Menu menu0) {
        boolean z = false;
        if(this.w < 1) {
            return false;
        }
        for(Object object0: this.c.f()) {
            I i0 = (I)object0;
            if(i0 != null && i0.isMenuVisible() && i0.performPrepareOptionsMenu(menu0)) {
                z = true;
            }
        }
        return z;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder(0x80);
        stringBuilder0.append("FragmentManager{");
        stringBuilder0.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder0.append(" in ");
        I i0 = this.z;
        if(i0 == null) {
            S s0 = this.x;
            if(s0 == null) {
                stringBuilder0.append("null");
            }
            else {
                stringBuilder0.append(s0.getClass().getSimpleName());
                stringBuilder0.append("{");
                stringBuilder0.append(Integer.toHexString(System.identityHashCode(this.x)));
                stringBuilder0.append("}");
            }
        }
        else {
            stringBuilder0.append(i0.getClass().getSimpleName());
            stringBuilder0.append("{");
            stringBuilder0.append(Integer.toHexString(System.identityHashCode(this.z)));
            stringBuilder0.append("}");
        }
        stringBuilder0.append("}}");
        return stringBuilder0.toString();
    }

    public final void u(int v) {
        try {
            this.b = true;
            for(Object object0: this.c.b.values()) {
                t0 t00 = (t0)object0;
                if(t00 != null) {
                    t00.e = v;
                }
            }
            this.U(v, false);
            for(Object object1: this.e()) {
                ((q)object1).i();
            }
        }
        finally {
            this.b = false;
        }
        this.z(true);
    }

    public final void v(String s, FileDescriptor fileDescriptor0, PrintWriter printWriter0, String[] arr_s) {
        ArrayList arrayList0 = this.c.a;
        HashMap hashMap0 = this.c.b;
        if(!hashMap0.isEmpty()) {
            printWriter0.print(s);
            printWriter0.println("Active Fragments:");
            for(Object object0: hashMap0.values()) {
                t0 t00 = (t0)object0;
                printWriter0.print(s);
                if(t00 == null) {
                    printWriter0.println("null");
                }
                else {
                    printWriter0.println(t00.c);
                    t00.c.dump(s + "    ", fileDescriptor0, printWriter0, arr_s);
                }
            }
        }
        int v = arrayList0.size();
        if(v > 0) {
            printWriter0.print(s);
            printWriter0.println("Added Fragments:");
            for(int v2 = 0; v2 < v; ++v2) {
                I i0 = (I)arrayList0.get(v2);
                printWriter0.print(s);
                printWriter0.print("  #");
                printWriter0.print(v2);
                printWriter0.print(": ");
                printWriter0.println("I{1213fed} (cfa1ada5-7a2d-43e7-bbcf-3076131925f6)");
            }
        }
        ArrayList arrayList1 = this.e;
        if(arrayList1 != null) {
            int v3 = arrayList1.size();
            if(v3 > 0) {
                printWriter0.print(s);
                printWriter0.println("Fragments Created Menus:");
                for(int v4 = 0; v4 < v3; ++v4) {
                    I i1 = (I)this.e.get(v4);
                    printWriter0.print(s);
                    printWriter0.print("  #");
                    printWriter0.print(v4);
                    printWriter0.print(": ");
                    printWriter0.println("I{1213fed} (cfa1ada5-7a2d-43e7-bbcf-3076131925f6)");
                }
            }
        }
        int v5 = this.d.size();
        if(v5 > 0) {
            printWriter0.print(s);
            printWriter0.println("Back Stack:");
            for(int v6 = 0; v6 < v5; ++v6) {
                a a0 = (a)this.d.get(v6);
                printWriter0.print(s);
                printWriter0.print("  #");
                printWriter0.print(v6);
                printWriter0.print(": ");
                printWriter0.println(a0.toString());
                a0.n(s + "    ", printWriter0, true);
            }
        }
        printWriter0.print(s);
        printWriter0.println("Back Stack Index: " + this.k.get());
        synchronized(this.a) {
            int v8 = this.a.size();
            if(v8 > 0) {
                printWriter0.print(s);
                printWriter0.println("Pending Actions:");
                for(int v1 = 0; v1 < v8; ++v1) {
                    i0 i00 = (i0)this.a.get(v1);
                    printWriter0.print(s);
                    printWriter0.print("  #");
                    printWriter0.print(v1);
                    printWriter0.print(": ");
                    printWriter0.println(i00);
                }
            }
        }
        printWriter0.print(s);
        printWriter0.println("FragmentManager misc state:");
        printWriter0.print(s);
        printWriter0.print("  mHost=");
        printWriter0.println(this.x);
        printWriter0.print(s);
        printWriter0.print("  mContainer=");
        printWriter0.println(this.y);
        if(this.z != null) {
            printWriter0.print(s);
            printWriter0.print("  mParent=");
            printWriter0.println(this.z);
        }
        printWriter0.print(s);
        printWriter0.print("  mCurState=");
        printWriter0.print(this.w);
        printWriter0.print(" mStateSaved=");
        printWriter0.print(this.I);
        printWriter0.print(" mStopped=");
        printWriter0.print(this.J);
        printWriter0.print(" mDestroyed=");
        printWriter0.println(this.K);
        if(this.H) {
            printWriter0.print(s);
            printWriter0.print("  mNeedMenuInvalidate=");
            printWriter0.println(this.H);
        }
    }

    public final void w() {
        for(Object object0: this.e()) {
            ((q)object0).i();
        }
    }

    public final void x(i0 i00, boolean z) {
        if(!z) {
            if(this.x == null) {
                throw this.K ? new IllegalStateException("FragmentManager has been destroyed") : new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            if(this.T()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized(this.a) {
            if(this.x == null) {
                if(!z) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
                return;
            }
            this.a.add(i00);
            this.g0();
        }
    }

    public final void y(boolean z) {
        if(this.b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if(this.x == null) {
            throw this.K ? new IllegalStateException("FragmentManager has been destroyed") : new IllegalStateException("FragmentManager has not been attached to a host.");
        }
        if(Looper.myLooper() != this.x.c.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if(!z && this.T()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if(this.M == null) {
            this.M = new ArrayList();
            this.N = new ArrayList();
        }
    }

    public final boolean z(boolean z) {
        boolean z2;
        this.y(z);
        if(!this.i) {
            a a0 = this.h;
            if(a0 != null) {
                a0.s = false;
                a0.j();
                if(l0.P(3)) {
                    Log.d("FragmentManager", "Reversing mTransitioningOp " + this.h + " as part of execPendingActions for actions " + this.a);
                }
                this.h.l(false, false);
                this.a.add(0, this.h);
                for(Object object0: this.h.a) {
                    I i0 = ((x0)object0).b;
                    if(i0 != null) {
                        i0.mTransitioning = false;
                    }
                }
                this.h = null;
            }
        }
        boolean z1;
        for(z1 = false; true; z1 = true) {
            ArrayList arrayList0 = this.M;
            ArrayList arrayList1 = this.N;
            ArrayList arrayList2 = this.a;
            __monitor_enter(arrayList2);
            int v = FIN.finallyOpen$NT();
            if(this.a.isEmpty()) {
                FIN.finallyExec$NT(v);
                z2 = false;
            }
            else {
                try {
                    int v1 = this.a.size();
                    z2 = false;
                    for(int v2 = 0; v2 < v1; ++v2) {
                        z2 |= ((i0)this.a.get(v2)).a(arrayList0, arrayList1);
                    }
                }
                catch(Throwable throwable0) {
                    this.a.clear();
                    this.x.c.removeCallbacks(this.Q);
                    FIN.finallyExec$NT(v);
                    throw throwable0;
                }
                this.a.clear();
                this.x.c.removeCallbacks(this.Q);
                FIN.finallyCodeBegin$NT(v);
                __monitor_exit(arrayList2);
                FIN.finallyCodeEnd$NT(v);
            }
            if(!z2) {
                break;
            }
            try {
                this.b = true;
                this.c0(this.M, this.N);
            }
            finally {
                this.d();
            }
        }
        this.q0();
        if(this.L) {
            this.L = false;
            for(Object object1: this.c.d()) {
                t0 t00 = (t0)object1;
                I i1 = t00.c;
                if(!i1.mDeferStart) {
                }
                else if(this.b) {
                    this.L = true;
                }
                else {
                    i1.mDeferStart = false;
                    t00.k();
                }
            }
        }
        this.c.b.values().removeAll(Collections.singleton(null));
        return z1;
    }
}

