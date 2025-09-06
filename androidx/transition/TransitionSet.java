package androidx.transition;

import N4.L;
import N4.S;
import N4.T;
import N4.X;
import N4.b0;
import R1.a;
import U4.x;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import o9.b;

public class TransitionSet extends Transition {
    public ArrayList b0;
    public boolean c0;
    public int d0;
    public boolean e0;
    public int f0;

    public TransitionSet() {
        this.b0 = new ArrayList();
        this.c0 = true;
        this.e0 = false;
        this.f0 = 0;
    }

    public TransitionSet(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.b0 = new ArrayList();
        this.c0 = true;
        this.e0 = false;
        this.f0 = 0;
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, L.g);
        this.S(a.d(typedArray0, ((XmlResourceParser)attributeSet0), "transitionOrdering", 0, 0));
        typedArray0.recycle();
    }

    @Override  // androidx.transition.Transition
    public final Transition A(S s0) {
        super.A(s0);
        return this;
    }

    @Override  // androidx.transition.Transition
    public final void C(View view0) {
        for(int v = 0; v < this.b0.size(); ++v) {
            ((Transition)this.b0.get(v)).C(view0);
        }
        this.f.remove(view0);
    }

    @Override  // androidx.transition.Transition
    public final void D(View view0) {
        super.D(view0);
        int v = this.b0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            ((Transition)this.b0.get(v1)).D(view0);
        }
    }

    @Override  // androidx.transition.Transition
    public final void E() {
        if(this.b0.isEmpty()) {
            this.M();
            this.m();
            return;
        }
        X x0 = new X();
        x0.b = this;
        for(Object object0: this.b0) {
            ((Transition)object0).a(x0);
        }
        this.d0 = this.b0.size();
        if(this.c0) {
            for(Object object1: this.b0) {
                ((Transition)object1).E();
            }
        }
        else {
            for(int v = 1; v < this.b0.size(); ++v) {
                ((Transition)this.b0.get(v - 1)).a(new X(((Transition)this.b0.get(v)), 2));
            }
            Transition transition0 = (Transition)this.b0.get(0);
            if(transition0 != null) {
                transition0.E();
            }
        }
    }

    @Override  // androidx.transition.Transition
    public final void F(long v, long v1) {
        long v2 = this.S;
        if(this.i == null || (v >= 0L || v1 >= 0L) && (v <= v2 || v1 <= v2)) {
            int v3 = Long.compare(v, v1);
            int v5 = Long.compare(v, 0L);
            if(v5 >= 0 && v1 < 0L || v <= v2 && v1 > v2) {
                this.B = false;
                this.x(this, T.s, v3 < 0);
            }
            if(this.c0) {
                for(int v4 = 0; v4 < this.b0.size(); ++v4) {
                    ((Transition)this.b0.get(v4)).F(v, v1);
                }
            }
            else {
                int v6;
                for(v6 = 1; true; ++v6) {
                    if(v6 >= this.b0.size()) {
                        v6 = this.b0.size();
                        break;
                    }
                    if(((Transition)this.b0.get(v6)).V > v1) {
                        break;
                    }
                }
                int v7 = v6 - 1;
                if(v3 >= 0) {
                    while(v7 < this.b0.size()) {
                        Transition transition0 = (Transition)this.b0.get(v7);
                        long v8 = transition0.V;
                        long v9 = v - v8;
                        if(v9 < 0L) {
                            break;
                        }
                        transition0.F(v9, v1 - v8);
                        ++v7;
                    }
                }
                else {
                    while(v7 >= 0) {
                        Transition transition1 = (Transition)this.b0.get(v7);
                        long v10 = v - transition1.V;
                        transition1.F(v10, v1 - transition1.V);
                        if(v10 >= 0L) {
                            break;
                        }
                        --v7;
                    }
                }
            }
            if(this.i != null) {
                int v11 = Long.compare(v, v2);
                if(v11 > 0 && v1 <= v2 || v5 < 0 && v1 >= 0L) {
                    if(v11 > 0) {
                        this.B = true;
                    }
                    this.x(this, T.t, v3 < 0);
                }
            }
        }
    }

    @Override  // androidx.transition.Transition
    public final void G(long v) {
        this.Q(v);
    }

    @Override  // androidx.transition.Transition
    public final void H(L l0) {
        this.M = l0;
        this.f0 |= 8;
        int v = this.b0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            ((Transition)this.b0.get(v1)).H(l0);
        }
    }

    @Override  // androidx.transition.Transition
    public final void I(TimeInterpolator timeInterpolator0) {
        this.R(timeInterpolator0);
    }

    @Override  // androidx.transition.Transition
    public final void J(PathMotion pathMotion0) {
        super.J(pathMotion0);
        this.f0 |= 4;
        if(this.b0 != null) {
            for(int v = 0; v < this.b0.size(); ++v) {
                ((Transition)this.b0.get(v)).J(pathMotion0);
            }
        }
    }

    @Override  // androidx.transition.Transition
    public final void K(L l0) {
        this.I = l0;
        this.f0 |= 2;
        int v = this.b0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            ((Transition)this.b0.get(v1)).K(l0);
        }
    }

    @Override  // androidx.transition.Transition
    public final void L(long v) {
        this.b = v;
    }

    @Override  // androidx.transition.Transition
    public final String N(String s) {
        String s1 = super.N(s);
        for(int v = 0; v < this.b0.size(); ++v) {
            StringBuilder stringBuilder0 = x.p(s1, "\n");
            stringBuilder0.append(((Transition)this.b0.get(v)).N(s + "  "));
            s1 = stringBuilder0.toString();
        }
        return s1;
    }

    public final void O(Transition transition0) {
        this.b0.add(transition0);
        transition0.i = this;
        long v = this.c;
        if(v >= 0L) {
            transition0.G(v);
        }
        if((this.f0 & 1) != 0) {
            transition0.I(this.d);
        }
        if((this.f0 & 2) != 0) {
            transition0.K(this.I);
        }
        if((this.f0 & 4) != 0) {
            transition0.J(this.N);
        }
        if((this.f0 & 8) != 0) {
            transition0.H(this.M);
        }
    }

    public final Transition P(int v) {
        return v < 0 || v >= this.b0.size() ? null : ((Transition)this.b0.get(v));
    }

    public final void Q(long v) {
        this.c = v;
        if(v >= 0L) {
            ArrayList arrayList0 = this.b0;
            if(arrayList0 != null) {
                int v1 = arrayList0.size();
                for(int v2 = 0; v2 < v1; ++v2) {
                    ((Transition)this.b0.get(v2)).G(v);
                }
            }
        }
    }

    public final void R(TimeInterpolator timeInterpolator0) {
        this.f0 |= 1;
        ArrayList arrayList0 = this.b0;
        if(arrayList0 != null) {
            int v = arrayList0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                ((Transition)this.b0.get(v1)).I(timeInterpolator0);
            }
        }
        this.d = timeInterpolator0;
    }

    public final void S(int v) {
        switch(v) {
            case 0: {
                this.c0 = true;
                return;
            }
            case 1: {
                this.c0 = false;
                return;
            }
            default: {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + v);
            }
        }
    }

    @Override  // androidx.transition.Transition
    public final void b(View view0) {
        for(int v = 0; v < this.b0.size(); ++v) {
            ((Transition)this.b0.get(v)).b(view0);
        }
        this.f.add(view0);
    }

    @Override  // androidx.transition.Transition
    public final void cancel() {
        super.cancel();
        int v = this.b0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            ((Transition)this.b0.get(v1)).cancel();
        }
    }

    @Override  // androidx.transition.Transition
    public final Object clone() {
        return this.j();
    }

    @Override  // androidx.transition.Transition
    public final void d(b0 b00) {
        if(this.v(b00.b)) {
            for(Object object0: this.b0) {
                Transition transition0 = (Transition)object0;
                if(transition0.v(b00.b)) {
                    transition0.d(b00);
                    b00.c.add(transition0);
                }
            }
        }
    }

    @Override  // androidx.transition.Transition
    public final void f(b0 b00) {
        super.f(b00);
        int v = this.b0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            ((Transition)this.b0.get(v1)).f(b00);
        }
    }

    @Override  // androidx.transition.Transition
    public final void g(b0 b00) {
        if(this.v(b00.b)) {
            for(Object object0: this.b0) {
                Transition transition0 = (Transition)object0;
                if(transition0.v(b00.b)) {
                    transition0.g(b00);
                    b00.c.add(transition0);
                }
            }
        }
    }

    @Override  // androidx.transition.Transition
    public final Transition j() {
        TransitionSet transitionSet0 = (TransitionSet)super.j();
        transitionSet0.b0 = new ArrayList();
        int v = this.b0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            Transition transition0 = ((Transition)this.b0.get(v1)).j();
            transitionSet0.b0.add(transition0);
            transition0.i = transitionSet0;
        }
        return transitionSet0;
    }

    @Override  // androidx.transition.Transition
    public final void l(ViewGroup viewGroup0, b b0, b b1, ArrayList arrayList0, ArrayList arrayList1) {
        long v = this.b;
        int v1 = this.b0.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            Transition transition0 = (Transition)this.b0.get(v2);
            if(v > 0L && (this.c0 || v2 == 0)) {
                long v3 = transition0.b;
                if(v3 > 0L) {
                    transition0.L(v3 + v);
                }
                else {
                    transition0.L(v);
                }
            }
            transition0.l(viewGroup0, b0, b1, arrayList0, arrayList1);
        }
    }

    @Override  // androidx.transition.Transition
    public final boolean s() {
        for(int v = 0; v < this.b0.size(); ++v) {
            if(((Transition)this.b0.get(v)).s()) {
                return true;
            }
        }
        return false;
    }

    @Override  // androidx.transition.Transition
    public final boolean t() {
        int v = this.b0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            if(!((Transition)this.b0.get(v1)).t()) {
                return false;
            }
        }
        return true;
    }

    @Override  // androidx.transition.Transition
    public final void y(View view0) {
        super.y(view0);
        int v = this.b0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            ((Transition)this.b0.get(v1)).y(view0);
        }
    }

    @Override  // androidx.transition.Transition
    public final void z() {
        this.S = 0L;
        X x0 = new X(this, 0);
        for(int v = 0; v < this.b0.size(); ++v) {
            Transition transition0 = (Transition)this.b0.get(v);
            transition0.a(x0);
            transition0.z();
            long v1 = transition0.S;
            if(this.c0) {
                this.S = Math.max(this.S, v1);
            }
            else {
                transition0.V = this.S;
                this.S += v1;
            }
        }
    }
}

