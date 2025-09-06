package androidx.constraintlayout.widget;

import F1.d;
import F1.e;
import F1.f;
import F1.k;
import F1.m;
import G1.b;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup;

public final class c implements G1.c {
    public final ConstraintLayout a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public final ConstraintLayout h;

    public c(ConstraintLayout constraintLayout0, ConstraintLayout constraintLayout1) {
        this.h = constraintLayout0;
        this.a = constraintLayout1;
    }

    @Override  // G1.c
    public final void a() {
        ConstraintLayout constraintLayout0 = this.a;
        int v = constraintLayout0.getChildCount();
        for(int v2 = 0; v2 < v; ++v2) {
            View view0 = constraintLayout0.getChildAt(v2);
            if(view0 instanceof Placeholder && ((Placeholder)view0).b != null) {
                LayoutParams constraintLayout$LayoutParams0 = (LayoutParams)((Placeholder)view0).getLayoutParams();
                LayoutParams constraintLayout$LayoutParams1 = (LayoutParams)((Placeholder)view0).b.getLayoutParams();
                e e0 = constraintLayout$LayoutParams1.q0;
                e0.j0 = 0;
                e e1 = constraintLayout$LayoutParams0.q0;
                d d0 = d.a;
                if(e1.V[0] != d0) {
                    e1.T(e0.s());
                }
                e e2 = constraintLayout$LayoutParams0.q0;
                if(e2.V[1] != d0) {
                    e2.O(constraintLayout$LayoutParams1.q0.m());
                }
                constraintLayout$LayoutParams1.q0.j0 = 8;
            }
        }
        int v3 = constraintLayout0.b.size();
        if(v3 > 0) {
            for(int v1 = 0; v1 < v3; ++v1) {
                ((ConstraintHelper)constraintLayout0.b.get(v1)).getClass();
            }
        }
    }

    @Override  // G1.c
    public final void b(e e0, b b0) {
        int v13;
        int v12;
        int v11;
        int v8;
        int v4;
        if(e0 != null) {
            F1.c c0 = e0.M;
            F1.c c1 = e0.K;
            if(e0.j0 == 8 && !e0.G) {
                b0.e = 0;
                b0.f = 0;
                b0.g = 0;
                return;
            }
            if(e0.W != null) {
                d d0 = b0.a;
                d d1 = b0.b;
                int v = b0.c;
                int v1 = b0.d;
                int v2 = this.b + this.c;
                int v3 = this.d;
                View view0 = (View)e0.i0;
                switch(d0.ordinal()) {
                    case 0: {
                        v4 = View.MeasureSpec.makeMeasureSpec(v, 0x40000000);
                        break;
                    }
                    case 1: {
                        v4 = ViewGroup.getChildMeasureSpec(this.f, v3, -2);
                        break;
                    }
                    case 2: {
                        v4 = ViewGroup.getChildMeasureSpec(this.f, v3, -2);
                        boolean z = e0.s == 1;
                        if(b0.j == 1 || b0.j == 2) {
                            boolean z1 = view0.getMeasuredHeight() == e0.m();
                            if(b0.j == 2 || !z || z1 || view0 instanceof Placeholder || e0.C()) {
                                v4 = View.MeasureSpec.makeMeasureSpec(e0.s(), 0x40000000);
                            }
                        }
                        break;
                    }
                    case 3: {
                        int v5 = this.f;
                        int v6 = c1 == null ? 0 : c1.g;
                        if(c0 != null) {
                            v6 += c0.g;
                        }
                        v4 = ViewGroup.getChildMeasureSpec(v5, v3 + v6, -1);
                        break;
                    }
                    default: {
                        v4 = 0;
                    }
                }
                int v7 = d1.ordinal();
                switch(v7) {
                    case 0: {
                        v8 = View.MeasureSpec.makeMeasureSpec(v1, 0x40000000);
                        break;
                    }
                    case 1: {
                        v8 = ViewGroup.getChildMeasureSpec(this.g, v2, -2);
                        break;
                    }
                    case 2: {
                        v8 = ViewGroup.getChildMeasureSpec(this.g, v2, -2);
                        boolean z2 = e0.t == 1;
                        if(b0.j == 1 || b0.j == 2) {
                            boolean z3 = view0.getMeasuredWidth() == e0.s();
                            if(b0.j == 2 || !z2 || z3 || view0 instanceof Placeholder || e0.D()) {
                                v8 = View.MeasureSpec.makeMeasureSpec(e0.m(), 0x40000000);
                            }
                        }
                        break;
                    }
                    default: {
                        if(v7 == 3) {
                            int v9 = this.g;
                            int v10 = c1 == null ? 0 : e0.L.g;
                            if(c0 != null) {
                                v10 += e0.N.g;
                            }
                            v8 = ViewGroup.getChildMeasureSpec(v9, v2 + v10, -1);
                        }
                        else {
                            v8 = 0;
                        }
                    }
                }
                f f0 = (f)e0.W;
                ConstraintLayout constraintLayout0 = this.h;
                if(f0 != null && k.c(constraintLayout0.g, 0x100) && view0.getMeasuredWidth() == e0.s() && view0.getMeasuredWidth() < f0.s() && view0.getMeasuredHeight() == e0.m() && view0.getMeasuredHeight() < f0.m() && view0.getBaseline() == e0.d0 && !e0.B() && c.c(e0.I, v4, e0.s()) && c.c(e0.J, v8, e0.m())) {
                    b0.e = e0.s();
                    b0.f = e0.m();
                    b0.g = e0.d0;
                    return;
                }
                boolean z4 = d0 == d.c;
                boolean z5 = d1 == d.c;
                boolean z6 = d1 == d.d || d1 == d.a;
                boolean z7 = d0 == d.d || d0 == d.a;
                boolean z8 = z4 && e0.Z > 0.0f;
                boolean z9 = z5 && e0.Z > 0.0f;
                if(view0 != null) {
                    LayoutParams constraintLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                    if(b0.j == 1 || b0.j == 2 || !z4 || e0.s != 0 || !z5 || e0.t != 0) {
                        if(!(view0 instanceof VirtualLayout) || !(e0 instanceof m)) {
                            view0.measure(v4, v8);
                        }
                        else {
                            ((VirtualLayout)view0).q(((m)e0), v4, v8);
                        }
                        e0.I = v4;
                        e0.J = v8;
                        e0.g = false;
                        int v14 = view0.getMeasuredWidth();
                        int v15 = view0.getMeasuredHeight();
                        int v16 = view0.getBaseline();
                        int v17 = e0.v <= 0 ? v14 : Math.max(e0.v, v14);
                        int v18 = e0.w;
                        if(v18 > 0) {
                            v17 = Math.min(v18, v17);
                        }
                        v13 = e0.y <= 0 ? v15 : Math.max(e0.y, v15);
                        int v19 = e0.z;
                        if(v19 > 0) {
                            v13 = Math.min(v19, v13);
                        }
                        if(!k.c(constraintLayout0.g, 1)) {
                            if(z8 && z6) {
                                v17 = (int)(((float)v13) * e0.Z + 0.5f);
                            }
                            else if(z9 && z7) {
                                v13 = (int)(((float)v17) / e0.Z + 0.5f);
                            }
                        }
                        if(v14 != v17 || v15 != v13) {
                            if(v14 != v17) {
                                v4 = View.MeasureSpec.makeMeasureSpec(v17, 0x40000000);
                            }
                            int v20 = v15 == v13 ? v8 : View.MeasureSpec.makeMeasureSpec(v13, 0x40000000);
                            view0.measure(v4, v20);
                            e0.I = v4;
                            e0.J = v20;
                            e0.g = false;
                            v11 = view0.getMeasuredWidth();
                            int v21 = view0.getMeasuredHeight();
                            v12 = view0.getBaseline();
                            v13 = v21;
                        }
                        else {
                            v12 = v16;
                            v11 = v17;
                        }
                    }
                    else {
                        v11 = 0;
                        v12 = 0;
                        v13 = 0;
                    }
                    b0.i = v11 != b0.c || v13 != b0.d;
                    boolean z10 = constraintLayout$LayoutParams0.c0 ? true : v12 != -1;
                    if(z10 && v12 != -1 && e0.d0 != v12) {
                        b0.i = true;
                    }
                    b0.e = v11;
                    b0.f = v13;
                    b0.h = z10;
                    b0.g = v12;
                }
            }
        }
    }

    public static boolean c(int v, int v1, int v2) {
        if(v != v1) {
            int v3 = View.MeasureSpec.getMode(v);
            return View.MeasureSpec.getMode(v1) == 0x40000000 && (v3 == 0x80000000 || v3 == 0) && v2 == View.MeasureSpec.getSize(v1);
        }
        return true;
    }
}

