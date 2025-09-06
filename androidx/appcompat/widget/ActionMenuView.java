package androidx.appcompat.widget;

import Gf.l;
import R6.d;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import k.j;
import k.k;
import k.m;
import k.y;

public class ActionMenuView extends LinearLayoutCompat implements k, y {
    public static class LayoutParams extends androidx.appcompat.widget.LinearLayoutCompat.LayoutParams {
        public boolean a;
        public int b;
        public int c;
        public boolean d;
        public boolean e;
        public boolean f;

        public LayoutParams(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
        }
    }

    public int B;
    public boolean D;
    public ActionMenuPresenter E;
    public l G;
    public j I;
    public boolean M;
    public int N;
    public final int S;
    public final int T;
    public n V;
    public MenuBuilder r;
    public Context w;

    public ActionMenuView(Context context0) {
        this(context0, null);
    }

    public ActionMenuView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.setBaselineAligned(false);
        DisplayMetrics displayMetrics0 = context0.getResources().getDisplayMetrics();
        this.S = (int)(56.0f * displayMetrics0.density);
        this.T = (int)(displayMetrics0.density * 4.0f);
        this.w = context0;
        this.B = 0;
    }

    @Override  // k.y
    public final void a(MenuBuilder menuBuilder0) {
        this.r = menuBuilder0;
    }

    @Override  // k.k
    public final boolean b(m m0) {
        return this.r.q(m0, null, 0);
    }

    @Override  // androidx.appcompat.widget.LinearLayoutCompat
    public final boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return viewGroup$LayoutParams0 instanceof LayoutParams;
    }

    @Override  // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent0) {
        return false;
    }

    @Override  // androidx.appcompat.widget.LinearLayoutCompat
    public final androidx.appcompat.widget.LinearLayoutCompat.LayoutParams f() {
        return ActionMenuView.j();
    }

    @Override  // androidx.appcompat.widget.LinearLayoutCompat
    public final androidx.appcompat.widget.LinearLayoutCompat.LayoutParams g(AttributeSet attributeSet0) {
        return new LayoutParams(this.getContext(), attributeSet0);
    }

    @Override  // androidx.appcompat.widget.LinearLayoutCompat
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return ActionMenuView.j();
    }

    @Override  // androidx.appcompat.widget.LinearLayoutCompat
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return new LayoutParams(this.getContext(), attributeSet0);
    }

    @Override  // androidx.appcompat.widget.LinearLayoutCompat
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return ActionMenuView.k(viewGroup$LayoutParams0);
    }

    public Menu getMenu() {
        if(this.r == null) {
            Context context0 = this.getContext();
            MenuBuilder menuBuilder0 = new MenuBuilder(context0);
            this.r = menuBuilder0;
            menuBuilder0.e = new androidx.appcompat.widget.k(this);
            ActionMenuPresenter actionMenuPresenter0 = new ActionMenuPresenter(context0);
            this.E = actionMenuPresenter0;
            actionMenuPresenter0.m = true;
            actionMenuPresenter0.n = true;
            l l0 = this.G;
            if(l0 == null) {
                l0 = new d(14);
            }
            actionMenuPresenter0.e = l0;
            this.r.b(actionMenuPresenter0, this.w);
            this.E.h = this;
            this.r = this.E.c;
        }
        return this.r;
    }

    public Drawable getOverflowIcon() {
        this.getMenu();
        ActionMenuPresenter actionMenuPresenter0 = this.E;
        androidx.appcompat.widget.j j0 = actionMenuPresenter0.j;
        if(j0 != null) {
            return j0.getDrawable();
        }
        return actionMenuPresenter0.l ? actionMenuPresenter0.k : null;
    }

    public int getPopupTheme() {
        return this.B;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override  // androidx.appcompat.widget.LinearLayoutCompat
    public final androidx.appcompat.widget.LinearLayoutCompat.LayoutParams h(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return ActionMenuView.k(viewGroup$LayoutParams0);
    }

    public static LayoutParams j() {
        LayoutParams actionMenuView$LayoutParams0 = new LayoutParams(-2, -2);  // 初始化器: Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V
        actionMenuView$LayoutParams0.a = false;
        actionMenuView$LayoutParams0.gravity = 16;
        return actionMenuView$LayoutParams0;
    }

    public static LayoutParams k(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        LayoutParams actionMenuView$LayoutParams0;
        if(viewGroup$LayoutParams0 != null) {
            if(viewGroup$LayoutParams0 instanceof LayoutParams) {
                actionMenuView$LayoutParams0 = new LayoutParams(((LayoutParams)viewGroup$LayoutParams0));  // 初始化器: Landroid/widget/LinearLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V
                actionMenuView$LayoutParams0.a = ((LayoutParams)viewGroup$LayoutParams0).a;
            }
            else {
                actionMenuView$LayoutParams0 = new LayoutParams(viewGroup$LayoutParams0);  // 初始化器: Landroid/widget/LinearLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V
            }
            if(actionMenuView$LayoutParams0.gravity <= 0) {
                actionMenuView$LayoutParams0.gravity = 16;
            }
            return actionMenuView$LayoutParams0;
        }
        return ActionMenuView.j();
    }

    public final boolean l(int v) {
        boolean z = false;
        if(v == 0) {
            return false;
        }
        View view0 = this.getChildAt(v - 1);
        View view1 = this.getChildAt(v);
        if(v < this.getChildCount() && view0 instanceof androidx.appcompat.widget.m) {
            z = ((androidx.appcompat.widget.m)view0).a();
        }
        return v > 0 && view1 instanceof androidx.appcompat.widget.m ? ((androidx.appcompat.widget.m)view1).b() | z : z;
    }

    @Override  // android.view.View
    public final void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        ActionMenuPresenter actionMenuPresenter0 = this.E;
        if(actionMenuPresenter0 != null) {
            actionMenuPresenter0.i(false);
            if(this.E.m()) {
                this.E.l();
                this.E.o();
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter0 = this.E;
        if(actionMenuPresenter0 != null) {
            actionMenuPresenter0.l();
            f f0 = actionMenuPresenter0.G;
            if(f0 != null && f0.b()) {
                f0.i.dismiss();
            }
        }
    }

    @Override  // androidx.appcompat.widget.LinearLayoutCompat
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        int v15;
        int v14;
        if(!this.M) {
            super.onLayout(z, v, v1, v2, v3);
            return;
        }
        int v4 = this.getChildCount();
        int v5 = (v3 - v1) / 2;
        int v6 = this.getDividerWidth();
        int v7 = v2 - v;
        int v8 = v7 - this.getPaddingRight() - this.getPaddingLeft();
        boolean z1 = this.getLayoutDirection() == 1;
        int v10 = 0;
        int v11 = 0;
        for(int v9 = 0; v9 < v4; ++v9) {
            View view0 = this.getChildAt(v9);
            if(view0.getVisibility() != 8) {
                LayoutParams actionMenuView$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                if(actionMenuView$LayoutParams0.a) {
                    int v12 = view0.getMeasuredWidth();
                    if(this.l(v9)) {
                        v12 += v6;
                    }
                    int v13 = view0.getMeasuredHeight();
                    if(z1) {
                        v14 = this.getPaddingLeft() + actionMenuView$LayoutParams0.leftMargin;
                        v15 = v14 + v12;
                    }
                    else {
                        v15 = this.getWidth() - this.getPaddingRight() - actionMenuView$LayoutParams0.rightMargin;
                        v14 = v15 - v12;
                    }
                    int v16 = v5 - v13 / 2;
                    view0.layout(v14, v16, v15, v13 + v16);
                    v8 -= v12;
                    v10 = 1;
                }
                else {
                    v8 -= view0.getMeasuredWidth() + actionMenuView$LayoutParams0.leftMargin + actionMenuView$LayoutParams0.rightMargin;
                    this.l(v9);
                    ++v11;
                }
            }
        }
        if(v4 == 1 && v10 == 0) {
            View view1 = this.getChildAt(0);
            int v17 = view1.getMeasuredWidth();
            int v18 = view1.getMeasuredHeight();
            int v19 = v7 / 2 - v17 / 2;
            int v20 = v5 - v18 / 2;
            view1.layout(v19, v20, v17 + v19, v18 + v20);
            return;
        }
        int v21 = v11 - (v10 ^ 1);
        int v22 = Math.max(0, (v21 <= 0 ? 0 : v8 / v21));
        if(z1) {
            int v23 = this.getWidth() - this.getPaddingRight();
            for(int v24 = 0; v24 < v4; ++v24) {
                View view2 = this.getChildAt(v24);
                LayoutParams actionMenuView$LayoutParams1 = (LayoutParams)view2.getLayoutParams();
                if(view2.getVisibility() != 8 && !actionMenuView$LayoutParams1.a) {
                    int v25 = v23 - actionMenuView$LayoutParams1.rightMargin;
                    int v26 = view2.getMeasuredWidth();
                    int v27 = view2.getMeasuredHeight();
                    int v28 = v5 - v27 / 2;
                    view2.layout(v25 - v26, v28, v25, v27 + v28);
                    v23 = v25 - (v26 + actionMenuView$LayoutParams1.leftMargin + v22);
                }
            }
            return;
        }
        int v29 = this.getPaddingLeft();
        for(int v30 = 0; v30 < v4; ++v30) {
            View view3 = this.getChildAt(v30);
            LayoutParams actionMenuView$LayoutParams2 = (LayoutParams)view3.getLayoutParams();
            if(view3.getVisibility() != 8 && !actionMenuView$LayoutParams2.a) {
                int v31 = v29 + actionMenuView$LayoutParams2.leftMargin;
                int v32 = view3.getMeasuredWidth();
                int v33 = view3.getMeasuredHeight();
                int v34 = v5 - v33 / 2;
                view3.layout(v31, v34, v31 + v32, v33 + v34);
                v29 = v32 + actionMenuView$LayoutParams2.rightMargin + v22 + v31;
            }
        }
    }

    @Override  // androidx.appcompat.widget.LinearLayoutCompat
    public final void onMeasure(int v, int v1) {
        int v36;
        int v28;
        int v24;
        int v23;
        boolean z = this.M;
        boolean z1 = View.MeasureSpec.getMode(v) == 0x40000000;
        this.M = z1;
        if(z != z1) {
            this.N = 0;
        }
        int v2 = View.MeasureSpec.getSize(v);
        if(this.M) {
            MenuBuilder menuBuilder0 = this.r;
            if(menuBuilder0 != null && v2 != this.N) {
                this.N = v2;
                menuBuilder0.p(true);
            }
        }
        int v3 = this.getChildCount();
        if(this.M && v3 > 0) {
            int v4 = View.MeasureSpec.getMode(v1);
            int v5 = View.MeasureSpec.getSize(v);
            int v6 = View.MeasureSpec.getSize(v1);
            int v7 = this.getPaddingLeft();
            int v8 = this.getPaddingRight();
            int v9 = this.getPaddingTop();
            int v10 = this.getPaddingBottom() + v9;
            int v11 = ViewGroup.getChildMeasureSpec(v1, v10, -2);
            int v12 = v5 - (v8 + v7);
            int v13 = this.S;
            int v14 = v12 / v13;
            if(v14 == 0) {
                this.setMeasuredDimension(v12, 0);
                return;
            }
            int v15 = v12 % v13 / v14 + v13;
            int v16 = this.getChildCount();
            int v17 = 0;
            int v18 = 0;
            int v19 = 0;
            int v20 = 0;
            boolean z2 = false;
            int v21 = 0;
            long v22 = 0L;
            while(true) {
                v23 = this.T;
                if(v20 >= v16) {
                    break;
                }
                View view0 = this.getChildAt(v20);
                if(view0.getVisibility() == 8) {
                    v24 = v15;
                }
                else {
                    ++v18;
                    if(view0 instanceof ActionMenuItemView) {
                        view0.setPadding(v23, 0, v23, 0);
                    }
                    LayoutParams actionMenuView$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                    actionMenuView$LayoutParams0.f = false;
                    actionMenuView$LayoutParams0.c = 0;
                    actionMenuView$LayoutParams0.b = 0;
                    actionMenuView$LayoutParams0.d = false;
                    actionMenuView$LayoutParams0.leftMargin = 0;
                    actionMenuView$LayoutParams0.rightMargin = 0;
                    actionMenuView$LayoutParams0.e = view0 instanceof ActionMenuItemView && !TextUtils.isEmpty(((ActionMenuItemView)view0).getText());
                    int v25 = actionMenuView$LayoutParams0.a ? 1 : v14;
                    ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
                    v24 = v15;
                    int v26 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(v11) - v10, View.MeasureSpec.getMode(v11));
                    ActionMenuItemView actionMenuItemView0 = view0 instanceof ActionMenuItemView ? ((ActionMenuItemView)view0) : null;
                    boolean z3 = actionMenuItemView0 != null && !TextUtils.isEmpty(actionMenuItemView0.getText());
                    if(v25 <= 0 || z3 && v25 < 2) {
                        v28 = 0;
                    }
                    else {
                        view0.measure(View.MeasureSpec.makeMeasureSpec(v24 * v25, 0x80000000), v26);
                        int v27 = view0.getMeasuredWidth();
                        v28 = v27 / v24;
                        if(v27 % v24 != 0) {
                            ++v28;
                        }
                        if(z3 && v28 < 2) {
                            v28 = 2;
                        }
                    }
                    ((LayoutParams)viewGroup$LayoutParams0).d = !((LayoutParams)viewGroup$LayoutParams0).a && z3;
                    ((LayoutParams)viewGroup$LayoutParams0).b = v28;
                    view0.measure(View.MeasureSpec.makeMeasureSpec(v28 * v24, 0x40000000), v26);
                    v19 = Math.max(v19, v28);
                    if(actionMenuView$LayoutParams0.d) {
                        ++v21;
                    }
                    if(actionMenuView$LayoutParams0.a) {
                        z2 = true;
                    }
                    v14 -= v28;
                    v17 = Math.max(v17, view0.getMeasuredHeight());
                    if(v28 == 1) {
                        v22 |= (long)(1 << v20);
                    }
                }
                ++v20;
                v15 = v24;
            }
            int v29 = v14;
            int v30 = 0;
            while(true) {
                if(v21 <= 0 || v29 <= 0) {
                    goto label_127;
                }
                int v31 = 0x7FFFFFFF;
                long v32 = 0L;
                int v33 = 0;
                for(int v34 = 0; v34 < v16; ++v34) {
                    LayoutParams actionMenuView$LayoutParams1 = (LayoutParams)this.getChildAt(v34).getLayoutParams();
                    if(actionMenuView$LayoutParams1.d) {
                        int v35 = actionMenuView$LayoutParams1.b;
                        if(v35 < v31) {
                            v32 = 1L << v34;
                            v31 = v35;
                            v33 = 1;
                        }
                        else if(v35 == v31) {
                            v32 |= 1L << v34;
                            ++v33;
                        }
                    }
                }
                v36 = v17;
                v22 |= v32;
                if(v33 <= v29) {
                    int v37 = v31 + 1;
                    for(int v38 = 0; v38 < v16; ++v38) {
                        View view1 = this.getChildAt(v38);
                        LayoutParams actionMenuView$LayoutParams2 = (LayoutParams)view1.getLayoutParams();
                        if((v32 & ((long)(1 << v38))) != 0L) {
                            if(z2 && v18 == 2 && actionMenuView$LayoutParams2.e && v29 == 1) {
                                view1.setPadding(v23 + v15, 0, v23, 0);
                            }
                            ++actionMenuView$LayoutParams2.b;
                            actionMenuView$LayoutParams2.f = true;
                            --v29;
                        }
                        else if(actionMenuView$LayoutParams2.b == v37) {
                            v22 |= (long)(1 << v38);
                        }
                    }
                    v17 = v36;
                    v30 = 1;
                    continue;
                label_127:
                    v36 = v17;
                }
                break;
            }
            boolean z4 = !z2 && v18 == 1;
            if(v29 > 0 && v22 != 0L && (v29 < v18 - 1 || z4 || v19 > 1)) {
                float f = (float)Long.bitCount(v22);
                if(!z4) {
                    if(Long.compare(v22 & 1L, 0L) != 0 && !((LayoutParams)this.getChildAt(0).getLayoutParams()).e) {
                        f -= 0.5f;
                    }
                    if((v22 & ((long)(1 << v16 - 1))) != 0L && !((LayoutParams)this.getChildAt(v16 - 1).getLayoutParams()).e) {
                        f -= 0.5f;
                    }
                }
                int v39 = f > 0.0f ? ((int)(((float)(v29 * v15)) / f)) : 0;
                int v40 = v30;
                for(int v41 = 0; v41 < v16; ++v41) {
                    if((v22 & ((long)(1 << v41))) != 0L) {
                        View view2 = this.getChildAt(v41);
                        LayoutParams actionMenuView$LayoutParams3 = (LayoutParams)view2.getLayoutParams();
                        if(view2 instanceof ActionMenuItemView) {
                            actionMenuView$LayoutParams3.c = v39;
                            actionMenuView$LayoutParams3.f = true;
                            if(v41 == 0 && !actionMenuView$LayoutParams3.e) {
                                actionMenuView$LayoutParams3.leftMargin = -v39 / 2;
                            }
                            v40 = 1;
                        }
                        else if(actionMenuView$LayoutParams3.a) {
                            actionMenuView$LayoutParams3.c = v39;
                            actionMenuView$LayoutParams3.f = true;
                            actionMenuView$LayoutParams3.rightMargin = -v39 / 2;
                            v40 = 1;
                        }
                        else {
                            if(v41 != 0) {
                                actionMenuView$LayoutParams3.leftMargin = v39 / 2;
                            }
                            if(v41 != v16 - 1) {
                                actionMenuView$LayoutParams3.rightMargin = v39 / 2;
                            }
                        }
                    }
                }
                v30 = v40;
            }
            if(v30 != 0) {
                for(int v42 = 0; v42 < v16; ++v42) {
                    View view3 = this.getChildAt(v42);
                    LayoutParams actionMenuView$LayoutParams4 = (LayoutParams)view3.getLayoutParams();
                    if(actionMenuView$LayoutParams4.f) {
                        view3.measure(View.MeasureSpec.makeMeasureSpec(actionMenuView$LayoutParams4.b * v15 + actionMenuView$LayoutParams4.c, 0x40000000), v11);
                    }
                }
            }
            this.setMeasuredDimension(v12, (v4 == 0x40000000 ? v6 : v36));
            return;
        }
        for(int v43 = 0; v43 < v3; ++v43) {
            LayoutParams actionMenuView$LayoutParams5 = (LayoutParams)this.getChildAt(v43).getLayoutParams();
            actionMenuView$LayoutParams5.rightMargin = 0;
            actionMenuView$LayoutParams5.leftMargin = 0;
        }
        super.onMeasure(v, v1);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.E.B = z;
    }

    public void setOnMenuItemClickListener(n n0) {
        this.V = n0;
    }

    public void setOverflowIcon(Drawable drawable0) {
        this.getMenu();
        ActionMenuPresenter actionMenuPresenter0 = this.E;
        androidx.appcompat.widget.j j0 = actionMenuPresenter0.j;
        if(j0 != null) {
            j0.setImageDrawable(drawable0);
            return;
        }
        actionMenuPresenter0.l = true;
        actionMenuPresenter0.k = drawable0;
    }

    public void setOverflowReserved(boolean z) {
        this.D = z;
    }

    public void setPopupTheme(int v) {
        if(this.B != v) {
            this.B = v;
            if(v == 0) {
                this.w = this.getContext();
                return;
            }
            this.w = new ContextThemeWrapper(this.getContext(), v);
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter0) {
        this.E = actionMenuPresenter0;
        actionMenuPresenter0.h = this;
        this.r = actionMenuPresenter0.c;
    }
}

