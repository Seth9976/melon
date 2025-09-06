package androidx.transition;

import A6.h;
import G6.c;
import N4.L;
import N4.M;
import N4.N;
import N4.O;
import N4.Q;
import N4.S;
import N4.T;
import N4.b0;
import R1.a;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.collection.f;
import androidx.collection.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import o9.b;

public abstract class Transition implements Cloneable {
    public boolean B;
    public Transition D;
    public ArrayList E;
    public ArrayList G;
    public L I;
    public L M;
    public PathMotion N;
    public long S;
    public Q T;
    public long V;
    public static final Animator[] W;
    public static final int[] X;
    public static final M Y;
    public static final ThreadLocal Z;
    public final String a;
    public long b;
    public long c;
    public TimeInterpolator d;
    public final ArrayList e;
    public final ArrayList f;
    public b g;
    public b h;
    public TransitionSet i;
    public final int[] j;
    public ArrayList k;
    public ArrayList l;
    public S[] m;
    public final ArrayList n;
    public Animator[] o;
    public int r;
    public boolean w;

    static {
        Transition.W = new Animator[0];
        Transition.X = new int[]{2, 1, 3, 4};
        Transition.Y = new M();  // 初始化器: Ljava/lang/Object;-><init>()V
        Transition.Z = new ThreadLocal();
    }

    public Transition() {
        this.a = this.getClass().getName();
        this.b = -1L;
        this.c = -1L;
        this.d = null;
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new b(4);
        this.h = new b(4);
        this.i = null;
        this.j = Transition.X;
        this.n = new ArrayList();
        this.o = Transition.W;
        this.r = 0;
        this.w = false;
        this.B = false;
        this.D = null;
        this.E = null;
        this.G = new ArrayList();
        this.N = Transition.Y;
    }

    public Transition(Context context0, AttributeSet attributeSet0) {
        this.a = this.getClass().getName();
        this.b = -1L;
        this.c = -1L;
        this.d = null;
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new b(4);
        this.h = new b(4);
        this.i = null;
        int[] arr_v = Transition.X;
        this.j = arr_v;
        this.n = new ArrayList();
        this.o = Transition.W;
        this.r = 0;
        this.w = false;
        this.B = false;
        this.D = null;
        this.E = null;
        this.G = new ArrayList();
        this.N = Transition.Y;
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, L.a);
        int v = -1;
        long v1 = (long)a.d(typedArray0, ((XmlResourceParser)attributeSet0), "duration", 1, -1);
        if(v1 >= 0L) {
            this.G(v1);
        }
        if(((XmlResourceParser)attributeSet0).getAttributeValue("http://schemas.android.com/apk/res/android", "startDelay") != null) {
            v = typedArray0.getInt(2, -1);
        }
        if(((long)v) > 0L) {
            this.L(((long)v));
        }
        int v2 = ((XmlResourceParser)attributeSet0).getAttributeValue("http://schemas.android.com/apk/res/android", "interpolator") == null ? 0 : typedArray0.getResourceId(0, 0);
        if(v2 > 0) {
            this.I(AnimationUtils.loadInterpolator(context0, v2));
        }
        String s = a.e(typedArray0, ((XmlResourceParser)attributeSet0), "matchOrder", 3);
        if(s != null) {
            StringTokenizer stringTokenizer0 = new StringTokenizer(s, ",");
            int[] arr_v1 = new int[stringTokenizer0.countTokens()];
            for(int v3 = 0; stringTokenizer0.hasMoreTokens(); ++v3) {
                String s1 = stringTokenizer0.nextToken().trim();
                if("id".equalsIgnoreCase(s1)) {
                    arr_v1[v3] = 3;
                }
                else if("instance".equalsIgnoreCase(s1)) {
                    arr_v1[v3] = 1;
                }
                else if("name".equalsIgnoreCase(s1)) {
                    arr_v1[v3] = 2;
                }
                else if("itemId".equalsIgnoreCase(s1)) {
                    arr_v1[v3] = 4;
                }
                else {
                    if(!s1.isEmpty()) {
                        throw new InflateException("Unknown match type in matchOrder: \'" + s1 + "\'");
                    }
                    int[] arr_v2 = new int[arr_v1.length - 1];
                    System.arraycopy(arr_v1, 0, arr_v2, 0, v3);
                    --v3;
                    arr_v1 = arr_v2;
                }
            }
            if(arr_v1.length == 0) {
                this.j = arr_v;
            }
            else {
                for(int v4 = 0; v4 < arr_v1.length; ++v4) {
                    int v5 = arr_v1[v4];
                    if(v5 < 1 || v5 > 4) {
                        throw new IllegalArgumentException("matches contains invalid value");
                    }
                    for(int v6 = 0; v6 < v4; ++v6) {
                        if(arr_v1[v6] == v5) {
                            throw new IllegalArgumentException("matches contains a duplicate value");
                        }
                    }
                }
                this.j = (int[])arr_v1.clone();
            }
        }
        typedArray0.recycle();
    }

    public Transition A(S s0) {
        ArrayList arrayList0 = this.E;
        if(arrayList0 != null) {
            if(!arrayList0.remove(s0)) {
                Transition transition0 = this.D;
                if(transition0 != null) {
                    transition0.A(s0);
                }
            }
            if(this.E.size() == 0) {
                this.E = null;
            }
        }
        return this;
    }

    public void C(View view0) {
        this.f.remove(view0);
    }

    public void D(View view0) {
        if(this.w) {
            if(!this.B) {
                Animator[] arr_animator = (Animator[])this.n.toArray(this.o);
                this.o = Transition.W;
                for(int v = this.n.size() - 1; v >= 0; --v) {
                    Animator animator0 = arr_animator[v];
                    arr_animator[v] = null;
                    animator0.resume();
                }
                this.o = arr_animator;
                this.x(this, T.x, false);
            }
            this.w = false;
        }
    }

    public void E() {
        this.M();
        f f0 = Transition.p();
        for(Object object0: this.G) {
            Animator animator0 = (Animator)object0;
            if(f0.containsKey(animator0)) {
                this.M();
                if(animator0 != null) {
                    animator0.addListener(new c(this, f0));
                    long v = this.c;
                    if(v >= 0L) {
                        animator0.setDuration(v);
                    }
                    long v1 = this.b;
                    if(v1 >= 0L) {
                        animator0.setStartDelay(animator0.getStartDelay() + v1);
                    }
                    TimeInterpolator timeInterpolator0 = this.d;
                    if(timeInterpolator0 != null) {
                        animator0.setInterpolator(timeInterpolator0);
                    }
                    animator0.addListener(new h(this, 2));
                    animator0.start();
                }
            }
        }
        this.G.clear();
        this.m();
    }

    public void F(long v, long v1) {
        long v2 = this.S;
        boolean z = Long.compare(v, v1) < 0;
        int v4 = Long.compare(v1, 0L);
        if(v4 < 0 && v >= 0L || v1 > v2 && v <= v2) {
            this.B = false;
            this.x(this, T.s, z);
        }
        int v5 = this.n.size();
        Animator[] arr_animator = (Animator[])this.n.toArray(this.o);
        this.o = Transition.W;
        for(int v3 = 0; v3 < v5; ++v3) {
            Animator animator0 = arr_animator[v3];
            arr_animator[v3] = null;
            O.b(animator0, Math.min(Math.max(0L, v), O.a(animator0)));
        }
        this.o = arr_animator;
        int v6 = Long.compare(v, v2);
        if(v6 > 0 && v1 <= v2 || v < 0L && v4 >= 0) {
            if(v6 > 0) {
                this.B = true;
            }
            this.x(this, T.t, z);
        }
    }

    public void G(long v) {
        this.c = v;
    }

    public void H(L l0) {
        this.M = l0;
    }

    public void I(TimeInterpolator timeInterpolator0) {
        this.d = timeInterpolator0;
    }

    public void J(PathMotion pathMotion0) {
        if(pathMotion0 == null) {
            this.N = Transition.Y;
            return;
        }
        this.N = pathMotion0;
    }

    public void K(L l0) {
        this.I = l0;
    }

    public void L(long v) {
        this.b = v;
    }

    public final void M() {
        if(this.r == 0) {
            this.x(this, T.s, false);
            this.B = false;
        }
        ++this.r;
    }

    public String N(String s) [...] // 潜在的解密器

    public void a(S s0) {
        if(this.E == null) {
            this.E = new ArrayList();
        }
        this.E.add(s0);
    }

    public void b(View view0) {
        this.f.add(view0);
    }

    public static void c(b b0, View view0, b0 b00) {
        f f0 = (f)b0.a;
        f f1 = (f)b0.d;
        SparseArray sparseArray0 = (SparseArray)b0.b;
        s s0 = (s)b0.c;
        f0.put(view0, b00);
        int v = view0.getId();
        if(v >= 0) {
            if(sparseArray0.indexOfKey(v) >= 0) {
                sparseArray0.put(v, null);
            }
            else {
                sparseArray0.put(v, view0);
            }
        }
        String s1 = c2.M.f(view0);
        if(s1 != null) {
            if(f1.containsKey(s1)) {
                f1.put(s1, null);
            }
            else {
                f1.put(s1, view0);
            }
        }
        if(view0.getParent() instanceof ListView) {
            ListView listView0 = (ListView)view0.getParent();
            if(listView0.getAdapter().hasStableIds()) {
                long v1 = listView0.getItemIdAtPosition(listView0.getPositionForView(view0));
                if(s0.c(v1) >= 0) {
                    View view1 = (View)s0.b(v1);
                    if(view1 != null) {
                        view1.setHasTransientState(false);
                        s0.f(v1, null);
                    }
                }
                else {
                    view0.setHasTransientState(true);
                    s0.f(v1, view0);
                }
            }
        }
    }

    public void cancel() {
        Animator[] arr_animator = (Animator[])this.n.toArray(this.o);
        this.o = Transition.W;
        for(int v = this.n.size() - 1; v >= 0; --v) {
            Animator animator0 = arr_animator[v];
            arr_animator[v] = null;
            animator0.cancel();
        }
        this.o = arr_animator;
        this.x(this, T.u, false);
    }

    @Override
    public Object clone() {
        return this.j();
    }

    public abstract void d(b0 arg1);

    public final void e(View view0, boolean z) {
        if(view0 != null) {
            view0.getId();
            if(view0.getParent() instanceof ViewGroup) {
                b0 b00 = new b0(view0);
                if(z) {
                    this.g(b00);
                }
                else {
                    this.d(b00);
                }
                b00.c.add(this);
                this.f(b00);
                if(z) {
                    Transition.c(this.g, view0, b00);
                }
                else {
                    Transition.c(this.h, view0, b00);
                }
            }
            if(view0 instanceof ViewGroup) {
                for(int v = 0; v < ((ViewGroup)view0).getChildCount(); ++v) {
                    this.e(((ViewGroup)view0).getChildAt(v), z);
                }
            }
        }
    }

    public void f(b0 b00) {
        if(this.I != null) {
            HashMap hashMap0 = b00.a;
            if(!hashMap0.isEmpty()) {
                this.I.getClass();
                String[] arr_s = L.j;
                for(int v = 0; v < 2; ++v) {
                    if(!hashMap0.containsKey(arr_s[v])) {
                        this.I.getClass();
                        View view0 = b00.b;
                        Integer integer0 = (Integer)hashMap0.get("android:visibility:visibility");
                        if(integer0 == null) {
                            integer0 = view0.getVisibility();
                        }
                        hashMap0.put("android:visibilityPropagation:visibility", integer0);
                        int[] arr_v = new int[2];
                        view0.getLocationOnScreen(arr_v);
                        int v1 = arr_v[0];
                        int v2 = Math.round(view0.getTranslationX()) + v1;
                        arr_v[0] = v2;
                        arr_v[0] = view0.getWidth() / 2 + v2;
                        int v3 = arr_v[1];
                        int v4 = Math.round(view0.getTranslationY()) + v3;
                        arr_v[1] = v4;
                        arr_v[1] = view0.getHeight() / 2 + v4;
                        hashMap0.put("android:visibilityPropagation:center", arr_v);
                        return;
                    }
                }
            }
        }
    }

    public abstract void g(b0 arg1);

    public final void h(ViewGroup viewGroup0, boolean z) {
        this.i(z);
        ArrayList arrayList0 = this.e;
        ArrayList arrayList1 = this.f;
        if(arrayList0.size() <= 0 && arrayList1.size() <= 0) {
            this.e(viewGroup0, z);
            return;
        }
        for(int v1 = 0; v1 < arrayList0.size(); ++v1) {
            View view0 = viewGroup0.findViewById(((int)(((Integer)arrayList0.get(v1)))));
            if(view0 != null) {
                b0 b00 = new b0(view0);
                if(z) {
                    this.g(b00);
                }
                else {
                    this.d(b00);
                }
                b00.c.add(this);
                this.f(b00);
                if(z) {
                    Transition.c(this.g, view0, b00);
                }
                else {
                    Transition.c(this.h, view0, b00);
                }
            }
        }
        for(int v = 0; v < arrayList1.size(); ++v) {
            View view1 = (View)arrayList1.get(v);
            b0 b01 = new b0(view1);
            if(z) {
                this.g(b01);
            }
            else {
                this.d(b01);
            }
            b01.c.add(this);
            this.f(b01);
            if(z) {
                Transition.c(this.g, view1, b01);
            }
            else {
                Transition.c(this.h, view1, b01);
            }
        }
    }

    public final void i(boolean z) {
        if(z) {
            ((f)this.g.a).clear();
            ((SparseArray)this.g.b).clear();
            ((s)this.g.c).a();
            return;
        }
        ((f)this.h.a).clear();
        ((SparseArray)this.h.b).clear();
        ((s)this.h.c).a();
    }

    public Transition j() {
        try {
            Transition transition0 = (Transition)super.clone();
            transition0.G = new ArrayList();
            transition0.g = new b(4);
            transition0.h = new b(4);
            transition0.k = null;
            transition0.l = null;
            transition0.T = null;
            transition0.D = this;
            transition0.E = null;
            return transition0;
        }
        catch(CloneNotSupportedException cloneNotSupportedException0) {
            throw new RuntimeException(cloneNotSupportedException0);
        }
    }

    public Animator k(ViewGroup viewGroup0, b0 b00, b0 b01) {
        return null;
    }

    public void l(ViewGroup viewGroup0, b b0, b b1, ArrayList arrayList0, ArrayList arrayList1) {
        int v4;
        b0 b02;
        View view0;
        f f0 = Transition.p();
        SparseIntArray sparseIntArray0 = new SparseIntArray();
        int v = arrayList0.size();
        int v1 = this.o().T == null ? 0 : 1;
        long v2 = 0x7FFFFFFFFFFFFFFFL;
        int v3 = 0;
        while(v3 < v) {
            b0 b00 = (b0)arrayList0.get(v3);
            b0 b01 = (b0)arrayList1.get(v3);
            if(b00 != null && !b00.c.contains(this)) {
                b00 = null;
            }
            if(b01 != null && !b01.c.contains(this)) {
                b01 = null;
            }
            if(b00 == null && b01 == null) {
                v4 = v3;
            }
            else if(b00 == null || b01 == null || this.u(b00, b01)) {
                Animator animator0 = this.k(viewGroup0, b00, b01);
                if(animator0 == null) {
                    v4 = v3;
                }
                else {
                    String s = this.a;
                    if(b01 == null) {
                    label_45:
                        v4 = v3;
                        view0 = b00.b;
                    }
                    else {
                        view0 = b01.b;
                        String[] arr_s = this.q();
                        if(arr_s == null || arr_s.length <= 0) {
                            v4 = v3;
                            goto label_47;
                        }
                        else {
                            b02 = new b0(view0);
                            v4 = v3;
                            b0 b03 = (b0)((f)b1.a).get(view0);
                            if(b03 != null) {
                                for(int v5 = 0; v5 < arr_s.length; ++v5) {
                                    String s1 = arr_s[v5];
                                    Object object0 = b03.a.get(s1);
                                    b02.a.put(s1, object0);
                                }
                            }
                            int v6 = f0.size();
                            for(int v7 = 0; v7 < v6; ++v7) {
                                N n0 = (N)f0.get(((Animator)f0.keyAt(v7)));
                                if(n0.c != null && n0.a == view0 && n0.b.equals(s) && n0.c.equals(b02)) {
                                    animator0 = null;
                                    break;
                                }
                            }
                            goto label_48;
                        }
                        goto label_45;
                    }
                label_47:
                    b02 = null;
                label_48:
                    if(animator0 != null) {
                        L l0 = this.I;
                        if(l0 != null) {
                            long v8 = l0.f(viewGroup0, this, b00, b01);
                            sparseIntArray0.put(this.G.size(), ((int)v8));
                            v2 = Math.min(v8, v2);
                        }
                        WindowId windowId0 = viewGroup0.getWindowId();
                        N n1 = new N();  // 初始化器: Ljava/lang/Object;-><init>()V
                        n1.a = view0;
                        n1.b = s;
                        n1.c = b02;
                        n1.d = windowId0;
                        n1.e = this;
                        n1.f = animator0;
                        if(v1 != 0) {
                            AnimatorSet animatorSet0 = new AnimatorSet();
                            animatorSet0.play(animator0);
                            animator0 = animatorSet0;
                        }
                        f0.put(animator0, n1);
                        this.G.add(animator0);
                    }
                }
            }
            else {
                v4 = v3;
            }
            v3 = v4 + 1;
        }
        if(sparseIntArray0.size() != 0) {
            for(int v9 = 0; v9 < sparseIntArray0.size(); ++v9) {
                int v10 = sparseIntArray0.keyAt(v9);
                N n2 = (N)f0.get(((Animator)this.G.get(v10)));
                long v11 = ((long)sparseIntArray0.valueAt(v9)) - v2;
                long v12 = n2.f.getStartDelay();
                n2.f.setStartDelay(v12 + v11);
            }
        }
    }

    public final void m() {
        int v = this.r - 1;
        this.r = v;
        if(v == 0) {
            this.x(this, T.t, false);
            for(int v1 = 0; v1 < ((s)this.g.c).h(); ++v1) {
                View view0 = (View)((s)this.g.c).i(v1);
                if(view0 != null) {
                    view0.setHasTransientState(false);
                }
            }
            for(int v2 = 0; v2 < ((s)this.h.c).h(); ++v2) {
                View view1 = (View)((s)this.h.c).i(v2);
                if(view1 != null) {
                    view1.setHasTransientState(false);
                }
            }
            this.B = true;
        }
    }

    public final b0 n(View view0, boolean z) {
        TransitionSet transitionSet0 = this.i;
        if(transitionSet0 != null) {
            return transitionSet0.n(view0, z);
        }
        ArrayList arrayList0 = z ? this.k : this.l;
        if(arrayList0 != null) {
            int v = arrayList0.size();
            int v1 = 0;
            while(v1 < v) {
                b0 b00 = (b0)arrayList0.get(v1);
                if(b00 == null) {
                    return null;
                }
                if(b00.b == view0) {
                    goto label_14;
                }
                ++v1;
            }
            v1 = -1;
        label_14:
            if(v1 >= 0) {
                return z ? ((b0)this.l.get(v1)) : ((b0)this.k.get(v1));
            }
        }
        return null;
    }

    public final Transition o() {
        return this.i == null ? this : this.i.o();
    }

    public static f p() {
        ThreadLocal threadLocal0 = Transition.Z;
        f f0 = (f)threadLocal0.get();
        if(f0 == null) {
            f0 = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
            threadLocal0.set(f0);
        }
        return f0;
    }

    public String[] q() {
        return null;
    }

    public final b0 r(View view0, boolean z) {
        TransitionSet transitionSet0 = this.i;
        if(transitionSet0 != null) {
            return transitionSet0.r(view0, z);
        }
        return z ? ((b0)((f)this.g.a).get(view0)) : ((b0)((f)this.h.a).get(view0));
    }

    public boolean s() {
        return !this.n.isEmpty();
    }

    public boolean t() {
        return this instanceof ChangeBounds;
    }

    // 去混淆评级： 低(20)
    @Override
    public final String toString() {
        return "Transition@787b7a8f: ";
    }

    public boolean u(b0 b00, b0 b01) {
        if(b00 != null && b01 != null) {
            String[] arr_s = this.q();
            if(arr_s == null) {
                Iterator iterator0 = b00.a.keySet().iterator();
                while(true) {
                    if(!iterator0.hasNext()) {
                        return false;
                    }
                    Object object0 = iterator0.next();
                    if(Transition.w(b00, b01, ((String)object0))) {
                        break;
                    }
                }
            }
            else {
                for(int v = 0; v < arr_s.length; ++v) {
                    if(Transition.w(b00, b01, arr_s[v])) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public final boolean v(View view0) {
        int v = view0.getId();
        return this.e.size() == 0 && this.f.size() == 0 || this.e.contains(v) || this.f.contains(view0);
    }

    public static boolean w(b0 b00, b0 b01, String s) {
        Object object0 = b00.a.get(s);
        Object object1 = b01.a.get(s);
        if(object0 == null && object1 == null) {
            return false;
        }
        return object0 == null || object1 == null ? true : !object0.equals(object1);
    }

    public final void x(Transition transition0, T t0, boolean z) {
        Transition transition1 = this.D;
        if(transition1 != null) {
            transition1.x(transition0, t0, z);
        }
        if(this.E != null && !this.E.isEmpty()) {
            int v = this.E.size();
            S[] arr_s = this.m == null ? new S[v] : this.m;
            this.m = null;
            S[] arr_s1 = (S[])this.E.toArray(arr_s);
            for(int v1 = 0; v1 < v; ++v1) {
                t0.a(arr_s1[v1], transition0, z);
                arr_s1[v1] = null;
            }
            this.m = arr_s1;
        }
    }

    public void y(View view0) {
        if(!this.B) {
            Animator[] arr_animator = (Animator[])this.n.toArray(this.o);
            this.o = Transition.W;
            for(int v = this.n.size() - 1; v >= 0; --v) {
                Animator animator0 = arr_animator[v];
                arr_animator[v] = null;
                animator0.pause();
            }
            this.o = arr_animator;
            this.x(this, T.v, false);
            this.w = true;
        }
    }

    public void z() {
        f f0 = Transition.p();
        this.S = 0L;
        for(int v = 0; v < this.G.size(); ++v) {
            Animator animator0 = (Animator)this.G.get(v);
            N n0 = (N)f0.get(animator0);
            if(animator0 != null && n0 != null) {
                Animator animator1 = n0.f;
                long v1 = this.c;
                if(v1 >= 0L) {
                    animator1.setDuration(v1);
                }
                long v2 = this.b;
                if(v2 >= 0L) {
                    animator1.setStartDelay(animator1.getStartDelay() + v2);
                }
                TimeInterpolator timeInterpolator0 = this.d;
                if(timeInterpolator0 != null) {
                    animator1.setInterpolator(timeInterpolator0);
                }
                this.n.add(animator0);
                this.S = Math.max(this.S, O.a(animator0));
            }
        }
        this.G.clear();
    }
}

