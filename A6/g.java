package A6;

import E9.h;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import e.k;
import java.util.LinkedHashSet;

public final class g extends k {
    public final int f;
    public final Behavior g;

    public g(Behavior coordinatorLayout$Behavior0, int v) {
        this.f = v;
        this.g = coordinatorLayout$Behavior0;
        super();
    }

    @Override  // e.k
    public final void G(int v) {
        if(this.f != 0) {
            if(v == 1) {
                BottomSheetBehavior bottomSheetBehavior0 = (BottomSheetBehavior)this.g;
                if(bottomSheetBehavior0.g0) {
                    bottomSheetBehavior0.N(1);
                }
            }
            return;
        }
        if(v == 1) {
            SideSheetBehavior sideSheetBehavior0 = (SideSheetBehavior)this.g;
            if(sideSheetBehavior0.g) {
                sideSheetBehavior0.x(1);
            }
        }
    }

    @Override  // e.k
    public final void H(View view0, int v, int v1) {
        if(this.f != 0) {
            ((BottomSheetBehavior)this.g).B(v1);
            return;
        }
        SideSheetBehavior sideSheetBehavior0 = (SideSheetBehavior)this.g;
        View view1 = sideSheetBehavior0.w == null ? null : ((View)sideSheetBehavior0.w.get());
        if(view1 != null) {
            ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)view1.getLayoutParams();
            if(viewGroup$MarginLayoutParams0 != null) {
                sideSheetBehavior0.a.d0(viewGroup$MarginLayoutParams0, view0.getLeft(), view0.getRight());
                view1.setLayoutParams(viewGroup$MarginLayoutParams0);
            }
        }
        LinkedHashSet linkedHashSet0 = sideSheetBehavior0.I;
        if(!linkedHashSet0.isEmpty()) {
            sideSheetBehavior0.a.p(v);
            for(Object object0: linkedHashSet0) {
                ((j)object0).getClass();
            }
        }
    }

    @Override  // e.k
    public final void I(View view0, float f, float f1) {
        int v5;
        if(this.f != 0) {
            BottomSheetBehavior bottomSheetBehavior0 = (BottomSheetBehavior)this.g;
            int v = 6;
            if(Float.compare(f1, 0.0f) >= 0) {
                if(!bottomSheetBehavior0.e0 || !bottomSheetBehavior0.O(view0, f1)) {
                    if(Float.compare(f1, 0.0f) == 0 || Math.abs(f) > Math.abs(f1)) {
                        int v3 = view0.getTop();
                        if(!bottomSheetBehavior0.b) {
                            int v4 = bottomSheetBehavior0.Z;
                            if(v3 >= v4) {
                                if(Math.abs(v3 - v4) < Math.abs(v3 - bottomSheetBehavior0.c0)) {
                                    bottomSheetBehavior0.getClass();
                                }
                                else {
                                    v = 4;
                                }
                            }
                            else if(v3 >= Math.abs(v3 - bottomSheetBehavior0.c0)) {
                                bottomSheetBehavior0.getClass();
                            }
                            else {
                                v = 3;
                            }
                        }
                        else if(Math.abs(v3 - bottomSheetBehavior0.Y) >= Math.abs(v3 - bottomSheetBehavior0.c0)) {
                            v = 4;
                        }
                        else {
                            v = 3;
                        }
                    }
                    else if(!bottomSheetBehavior0.b) {
                        int v2 = view0.getTop();
                        if(Math.abs(v2 - bottomSheetBehavior0.Z) < Math.abs(v2 - bottomSheetBehavior0.c0)) {
                            bottomSheetBehavior0.getClass();
                        }
                        else {
                            v = 4;
                        }
                    }
                    else {
                        v = 4;
                    }
                }
                else if(Math.abs(f) < Math.abs(f1) && f1 > ((float)bottomSheetBehavior0.d) || view0.getTop() > (bottomSheetBehavior0.F() + bottomSheetBehavior0.p0) / 2) {
                    v = 5;
                }
                else if(bottomSheetBehavior0.b || Math.abs(view0.getTop() - bottomSheetBehavior0.F()) < Math.abs(view0.getTop() - bottomSheetBehavior0.Z)) {
                    v = 3;
                }
            }
            else if(!bottomSheetBehavior0.b) {
                int v1 = view0.getTop();
                bottomSheetBehavior0.getClass();
                if(v1 <= bottomSheetBehavior0.Z) {
                    v = 3;
                }
            }
            else {
                v = 3;
            }
            bottomSheetBehavior0.getClass();
            bottomSheetBehavior0.P(view0, v, true);
            return;
        }
        SideSheetBehavior sideSheetBehavior0 = (SideSheetBehavior)this.g;
        if(sideSheetBehavior0.a.O(f)) {
            v5 = 3;
        }
        else if(!sideSheetBehavior0.a.U(view0, f)) {
            if(f != 0.0f && Math.abs(f) > Math.abs(f1)) {
                v5 = 5;
            }
            else {
                int v6 = view0.getLeft();
                v5 = Math.abs(v6 - sideSheetBehavior0.a.C()) >= Math.abs(v6 - sideSheetBehavior0.a.D()) ? 5 : 3;
            }
        }
        else if(sideSheetBehavior0.a.S(f, f1) || sideSheetBehavior0.a.R(view0)) {
            v5 = 5;
        }
        else {
            v5 = 3;
        }
        sideSheetBehavior0.z(view0, v5, true);
    }

    @Override  // e.k
    public final boolean P(View view0, int v) {
        if(this.f != 0) {
            BottomSheetBehavior bottomSheetBehavior0 = (BottomSheetBehavior)this.g;
            int v1 = bottomSheetBehavior0.h0;
            if(v1 != 1 && !bottomSheetBehavior0.y0) {
                if(v1 == 3 && bottomSheetBehavior0.w0 == v) {
                    View view1 = bottomSheetBehavior0.s0 == null ? null : ((View)bottomSheetBehavior0.s0.get());
                    return view1 != null && view1.canScrollVertically(-1) ? false : bottomSheetBehavior0.q0 != null && bottomSheetBehavior0.q0.get() == view0;
                }
                return bottomSheetBehavior0.q0 != null && bottomSheetBehavior0.q0.get() == view0;
            }
            return false;
        }
        SideSheetBehavior sideSheetBehavior0 = (SideSheetBehavior)this.g;
        return sideSheetBehavior0.h != 1 && (sideSheetBehavior0.r != null && sideSheetBehavior0.r.get() == view0);
    }

    @Override  // e.k
    public final int j(View view0, int v) {
        return this.f == 0 ? h.r(v, ((SideSheetBehavior)this.g).a.F(), ((SideSheetBehavior)this.g).a.E()) : view0.getLeft();
    }

    @Override  // e.k
    public final int k(View view0, int v) {
        return this.f == 0 ? view0.getTop() : h.r(v, ((BottomSheetBehavior)this.g).F(), this.w());
    }

    @Override  // e.k
    public int v(View view0) {
        return this.f == 0 ? ((SideSheetBehavior)this.g).l + ((SideSheetBehavior)this.g).o : super.v(view0);
    }

    @Override  // e.k
    public int w() {
        if(this.f != 1) {
            return super.w();
        }
        BottomSheetBehavior bottomSheetBehavior0 = (BottomSheetBehavior)this.g;
        return bottomSheetBehavior0.e0 ? bottomSheetBehavior0.p0 : bottomSheetBehavior0.c0;
    }
}

