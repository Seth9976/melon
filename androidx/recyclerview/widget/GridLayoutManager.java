package androidx.recyclerview.widget;

import B6.f;
import U4.x;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.appcompat.app.o;
import d2.c;
import d2.d;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

public class GridLayoutManager extends LinearLayoutManager {
    public static class LayoutParams extends androidx.recyclerview.widget.RecyclerView.LayoutParams {
        public int e;
        public int f;

        public LayoutParams(int v, int v1) {
            super(v, v1);
            this.e = -1;
            this.f = 0;
        }

        public LayoutParams(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
            this.e = -1;
            this.f = 0;
        }
    }

    public boolean a;
    public int b;
    public int[] c;
    public View[] d;
    public final SparseIntArray e;
    public final SparseIntArray f;
    public H g;
    public final Rect h;
    public int i;
    public int j;
    public int k;
    public static final Set l;

    static {
        GridLayoutManager.l = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[]{17, 66, 33, 130})));
    }

    public GridLayoutManager(int v) {
        super(1, false);
        this.a = false;
        this.b = -1;
        this.e = new SparseIntArray();
        this.f = new SparseIntArray();
        this.g = new G();  // 初始化器: Landroidx/recyclerview/widget/H;-><init>()V
        this.h = new Rect();
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.P(v);
    }

    public GridLayoutManager(Context context0, int v) {
        super(context0);
        this.a = false;
        this.b = -1;
        this.e = new SparseIntArray();
        this.f = new SparseIntArray();
        this.g = new G();  // 初始化器: Landroidx/recyclerview/widget/H;-><init>()V
        this.h = new Rect();
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.P(v);
    }

    public GridLayoutManager(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
        this.a = false;
        this.b = -1;
        this.e = new SparseIntArray();
        this.f = new SparseIntArray();
        this.g = new G();  // 初始化器: Landroidx/recyclerview/widget/H;-><init>()V
        this.h = new Rect();
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.P(w0.getProperties(context0, attributeSet0, v, v1).b);
    }

    public final void E(int v) {
        int v7;
        int[] arr_v = this.c;
        int v1 = this.b;
        if(arr_v == null || arr_v.length != v1 + 1 || arr_v[arr_v.length - 1] != v) {
            arr_v = new int[v1 + 1];
        }
        int v3 = 0;
        arr_v[0] = 0;
        int v4 = v / v1;
        int v5 = v % v1;
        int v6 = 0;
        for(int v2 = 1; v2 <= v1; ++v2) {
            v3 += v5;
            if(v3 <= 0 || v1 - v3 >= v5) {
                v7 = v4;
            }
            else {
                v7 = v4 + 1;
                v3 -= v1;
            }
            v6 += v7;
            arr_v[v2] = v6;
        }
        this.c = arr_v;
    }

    public final void F() {
        if(this.d != null && this.d.length == this.b) {
            return;
        }
        this.d = new View[this.b];
    }

    public final int G(int v) {
        return this.mOrientation == 0 ? this.L(v, this.mRecyclerView.c, this.mRecyclerView.D0) : this.M(v, this.mRecyclerView.c, this.mRecyclerView.D0);
    }

    public final int H(int v) {
        return this.mOrientation == 1 ? this.L(v, this.mRecyclerView.c, this.mRecyclerView.D0) : this.M(v, this.mRecyclerView.c, this.mRecyclerView.D0);
    }

    public final HashSet I(int v) {
        return this.J(this.H(v), v);
    }

    public final HashSet J(int v, int v1) {
        HashSet hashSet0 = new HashSet();
        int v2 = this.N(v1, this.mRecyclerView.c, this.mRecyclerView.D0);
        for(int v3 = v; v3 < v + v2; ++v3) {
            hashSet0.add(v3);
        }
        return hashSet0;
    }

    public final int K(int v, int v1) {
        return this.mOrientation != 1 || !this.isLayoutRTL() ? this.c[v1 + v] - this.c[v] : this.c[this.b - v] - this.c[this.b - v - v1];
    }

    public final int L(int v, D0 d00, K0 k00) {
        if(!k00.g) {
            return this.g.getCachedSpanGroupIndex(v, this.b);
        }
        int v1 = d00.b(v);
        if(v1 == -1) {
            x.u(v, "Cannot find span size for pre layout position. ", "GridLayoutManager");
            return 0;
        }
        return this.g.getCachedSpanGroupIndex(v1, this.b);
    }

    public final int M(int v, D0 d00, K0 k00) {
        if(!k00.g) {
            return this.g.getCachedSpanIndex(v, this.b);
        }
        int v1 = this.f.get(v, -1);
        if(v1 != -1) {
            return v1;
        }
        int v2 = d00.b(v);
        if(v2 == -1) {
            x.u(v, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:", "GridLayoutManager");
            return 0;
        }
        return this.g.getCachedSpanIndex(v2, this.b);
    }

    public final int N(int v, D0 d00, K0 k00) {
        if(!k00.g) {
            return this.g.getSpanSize(v);
        }
        int v1 = this.e.get(v, -1);
        if(v1 != -1) {
            return v1;
        }
        int v2 = d00.b(v);
        if(v2 == -1) {
            x.u(v, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:", "GridLayoutManager");
            return 1;
        }
        return this.g.getSpanSize(v2);
    }

    public final void O(View view0, int v, boolean z) {
        int v5;
        int v4;
        LayoutParams gridLayoutManager$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        int v1 = gridLayoutManager$LayoutParams0.b.top + gridLayoutManager$LayoutParams0.b.bottom + gridLayoutManager$LayoutParams0.topMargin + gridLayoutManager$LayoutParams0.bottomMargin;
        int v2 = gridLayoutManager$LayoutParams0.b.left + gridLayoutManager$LayoutParams0.b.right + gridLayoutManager$LayoutParams0.leftMargin + gridLayoutManager$LayoutParams0.rightMargin;
        int v3 = this.K(gridLayoutManager$LayoutParams0.e, gridLayoutManager$LayoutParams0.f);
        if(this.mOrientation == 1) {
            v4 = w0.getChildMeasureSpec(v3, v, v2, gridLayoutManager$LayoutParams0.width, false);
            v5 = w0.getChildMeasureSpec(this.mOrientationHelper.l(), this.getHeightMode(), v1, gridLayoutManager$LayoutParams0.height, true);
        }
        else {
            v5 = w0.getChildMeasureSpec(v3, v, v1, gridLayoutManager$LayoutParams0.height, false);
            v4 = w0.getChildMeasureSpec(this.mOrientationHelper.l(), this.getWidthMode(), v2, gridLayoutManager$LayoutParams0.width, true);
        }
        androidx.recyclerview.widget.RecyclerView.LayoutParams recyclerView$LayoutParams0 = (androidx.recyclerview.widget.RecyclerView.LayoutParams)view0.getLayoutParams();
        if((z ? this.shouldReMeasureChild(view0, v4, v5, recyclerView$LayoutParams0) : this.shouldMeasureChild(view0, v4, v5, recyclerView$LayoutParams0))) {
            view0.measure(v4, v5);
        }
    }

    public final void P(int v) {
        if(v == this.b) {
            return;
        }
        this.a = true;
        if(v < 1) {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + v);
        }
        this.b = v;
        this.g.invalidateSpanIndexCache();
        this.requestLayout();
    }

    public final void Q() {
        int v1;
        int v;
        if(this.getOrientation() == 1) {
            v = this.getWidth() - this.getPaddingRight();
            v1 = this.getPaddingLeft();
        }
        else {
            v = this.getHeight() - this.getPaddingBottom();
            v1 = this.getPaddingTop();
        }
        this.E(v - v1);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final boolean checkLayoutParams(androidx.recyclerview.widget.RecyclerView.LayoutParams recyclerView$LayoutParams0) {
        return recyclerView$LayoutParams0 instanceof LayoutParams;
    }

    @Override  // androidx.recyclerview.widget.LinearLayoutManager
    public final void collectPrefetchPositionsForLayoutState(K0 k00, W w0, u0 u00) {
        int v = this.b;
        for(int v1 = 0; v1 < this.b && (w0.d >= 0 && w0.d < k00.b() && v > 0); ++v1) {
            int v2 = w0.d;
            ((D)u00).a(v2, Math.max(0, w0.g));
            v -= this.g.getSpanSize(v2);
            w0.d += w0.e;
        }
    }

    @Override  // androidx.recyclerview.widget.LinearLayoutManager
    public final View findReferenceChild(D0 d00, K0 k00, boolean z, boolean z1) {
        int v3;
        int v2;
        int v = this.getChildCount();
        int v1 = 1;
        if(z1) {
            v2 = this.getChildCount() - 1;
            v3 = -1;
            v1 = -1;
        }
        else {
            v3 = v;
            v2 = 0;
        }
        int v4 = k00.b();
        this.ensureLayoutState();
        int v5 = this.mOrientationHelper.k();
        int v6 = this.mOrientationHelper.g();
        View view0 = null;
        View view1 = null;
        while(v2 != v3) {
            View view2 = this.getChildAt(v2);
            int v7 = this.getPosition(view2);
            if(v7 >= 0 && v7 < v4 && this.M(v7, d00, k00) == 0) {
                if(!((androidx.recyclerview.widget.RecyclerView.LayoutParams)view2.getLayoutParams()).a.isRemoved()) {
                    if(this.mOrientationHelper.e(view2) < v6 && this.mOrientationHelper.b(view2) >= v5) {
                        return view2;
                    }
                    if(view0 == null) {
                        view0 = view2;
                    }
                }
                else if(view1 == null) {
                    view1 = view2;
                }
            }
            v2 += v1;
        }
        return view0 == null ? view1 : view0;
    }

    @Override  // androidx.recyclerview.widget.LinearLayoutManager
    public final androidx.recyclerview.widget.RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final androidx.recyclerview.widget.RecyclerView.LayoutParams generateLayoutParams(Context context0, AttributeSet attributeSet0) {
        return new LayoutParams(context0, attributeSet0);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final androidx.recyclerview.widget.RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        if(viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams) {
            androidx.recyclerview.widget.RecyclerView.LayoutParams recyclerView$LayoutParams0 = new LayoutParams(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0));  // 初始化器: Landroidx/recyclerview/widget/RecyclerView$LayoutParams;-><init>(Landroid/view/ViewGroup$MarginLayoutParams;)V
            recyclerView$LayoutParams0.e = -1;
            recyclerView$LayoutParams0.f = 0;
            return recyclerView$LayoutParams0;
        }
        androidx.recyclerview.widget.RecyclerView.LayoutParams recyclerView$LayoutParams1 = new LayoutParams(viewGroup$LayoutParams0);  // 初始化器: Landroidx/recyclerview/widget/RecyclerView$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V
        recyclerView$LayoutParams1.e = -1;
        recyclerView$LayoutParams1.f = 0;
        return recyclerView$LayoutParams1;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final int getColumnCountForAccessibility(D0 d00, K0 k00) {
        if(this.mOrientation == 1) {
            return Math.min(this.b, this.getItemCount());
        }
        return k00.b() >= 1 ? this.L(k00.b() - 1, d00, k00) + 1 : 0;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final int getRowCountForAccessibility(D0 d00, K0 k00) {
        if(this.mOrientation == 0) {
            return Math.min(this.b, this.getItemCount());
        }
        return k00.b() >= 1 ? this.L(k00.b() - 1, d00, k00) + 1 : 0;
    }

    @Override  // androidx.recyclerview.widget.LinearLayoutManager
    public final void layoutChunk(D0 d00, K0 k00, W w0, V v0) {
        int v28;
        int v27;
        int v26;
        int v25;
        int v22;
        int v21;
        int v9;
        int v8;
        int v7;
        int v1 = this.mOrientationHelper.j();
        int v2 = this.getChildCount() <= 0 ? 0 : this.c[this.b];
        if(v1 != 0x40000000) {
            this.Q();
        }
        boolean z = w0.e == 1;
        int v3 = z ? this.b : this.M(w0.d, d00, k00) + this.N(w0.d, d00, k00);
        int v4 = 0;
        while(v4 < this.b && (w0.d >= 0 && w0.d < k00.b() && v3 > 0)) {
            int v5 = w0.d;
            int v6 = this.N(v5, d00, k00);
            if(v6 <= this.b) {
                v3 -= v6;
                if(v3 < 0) {
                    break;
                }
                View view0 = w0.b(d00);
                if(view0 == null) {
                    break;
                }
                this.d[v4] = view0;
                ++v4;
                continue;
            }
            StringBuilder stringBuilder0 = o.t(v5, v6, "Item at position ", " requires ", " spans but GridLayoutManager has only ");
            throw new IllegalArgumentException(x.g(this.b, " spans.", stringBuilder0));
        }
        if(v4 == 0) {
            v0.b = true;
            return;
        }
        if(z) {
            v7 = 1;
            v8 = v4;
            v9 = 0;
        }
        else {
            v9 = v4 - 1;
            v8 = -1;
            v7 = -1;
        }
        int v10 = 0;
        while(v9 != v8) {
            View view1 = this.d[v9];
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = view1.getLayoutParams();
            int v11 = this.N(this.getPosition(view1), d00, k00);
            ((LayoutParams)viewGroup$LayoutParams0).f = v11;
            ((LayoutParams)viewGroup$LayoutParams0).e = v10;
            v10 += v11;
            v9 += v7;
        }
        float f = 0.0f;
        int v13 = 0;
        for(int v12 = 0; v12 < v4; ++v12) {
            View view2 = this.d[v12];
            if(w0.k == null) {
                if(z) {
                    this.addView(view2);
                }
                else {
                    this.addView(view2, 0);
                }
            }
            else if(z) {
                this.addDisappearingView(view2);
            }
            else {
                this.addDisappearingView(view2, 0);
            }
            this.calculateItemDecorationsForChild(view2, this.h);
            this.O(view2, v1, false);
            int v14 = this.mOrientationHelper.c(view2);
            if(v14 > v13) {
                v13 = v14;
            }
            LayoutParams gridLayoutManager$LayoutParams0 = (LayoutParams)view2.getLayoutParams();
            float f1 = ((float)this.mOrientationHelper.d(view2)) * 1.0f / ((float)gridLayoutManager$LayoutParams0.f);
            if(f1 > f) {
                f = f1;
            }
        }
        if(v1 != 0x40000000) {
            this.E(Math.max(Math.round(f * ((float)this.b)), v2));
            v13 = 0;
            for(int v15 = 0; v15 < v4; ++v15) {
                View view3 = this.d[v15];
                this.O(view3, 0x40000000, true);
                int v16 = this.mOrientationHelper.c(view3);
                if(v16 > v13) {
                    v13 = v16;
                }
            }
        }
        for(int v17 = 0; v17 < v4; ++v17) {
            View view4 = this.d[v17];
            if(this.mOrientationHelper.c(view4) != v13) {
                LayoutParams gridLayoutManager$LayoutParams1 = (LayoutParams)view4.getLayoutParams();
                int v18 = gridLayoutManager$LayoutParams1.b.top + gridLayoutManager$LayoutParams1.b.bottom + gridLayoutManager$LayoutParams1.topMargin + gridLayoutManager$LayoutParams1.bottomMargin;
                int v19 = gridLayoutManager$LayoutParams1.b.left + gridLayoutManager$LayoutParams1.b.right + gridLayoutManager$LayoutParams1.leftMargin + gridLayoutManager$LayoutParams1.rightMargin;
                int v20 = this.K(gridLayoutManager$LayoutParams1.e, gridLayoutManager$LayoutParams1.f);
                if(this.mOrientation == 1) {
                    v21 = w0.getChildMeasureSpec(v20, 0x40000000, v19, gridLayoutManager$LayoutParams1.width, false);
                    v22 = View.MeasureSpec.makeMeasureSpec(v13 - v18, 0x40000000);
                }
                else {
                    int v23 = View.MeasureSpec.makeMeasureSpec(v13 - v19, 0x40000000);
                    v22 = w0.getChildMeasureSpec(v20, 0x40000000, v18, gridLayoutManager$LayoutParams1.height, false);
                    v21 = v23;
                }
                if(this.shouldReMeasureChild(view4, v21, v22, ((androidx.recyclerview.widget.RecyclerView.LayoutParams)view4.getLayoutParams()))) {
                    view4.measure(v21, v22);
                }
            }
        }
        v0.a = v13;
        if(this.mOrientation != 1) {
            if(w0.f == -1) {
                v27 = w0.b - v13;
                v28 = w0.b;
            }
            else {
                v28 = w0.b + v13;
                v27 = w0.b;
            }
            v26 = 0;
            v25 = 0;
        }
        else if(w0.f == -1) {
            v25 = w0.b;
            v26 = v25 - v13;
            v27 = 0;
            v28 = 0;
        }
        else {
            v26 = w0.b;
            v28 = 0;
            v25 = w0.b + v13;
            v27 = 0;
        }
        for(int v24 = 0; v24 < v4; ++v24) {
            View view5 = this.d[v24];
            LayoutParams gridLayoutManager$LayoutParams2 = (LayoutParams)view5.getLayoutParams();
            if(this.mOrientation != 1) {
                v26 = this.getPaddingTop() + this.c[gridLayoutManager$LayoutParams2.e];
                v25 = this.mOrientationHelper.d(view5) + v26;
            }
            else if(this.isLayoutRTL()) {
                int v29 = this.getPaddingLeft();
                v28 = this.c[this.b - gridLayoutManager$LayoutParams2.e] + v29;
                v27 = v28 - this.mOrientationHelper.d(view5);
            }
            else {
                v27 = this.getPaddingLeft() + this.c[gridLayoutManager$LayoutParams2.e];
                v28 = this.mOrientationHelper.d(view5) + v27;
            }
            this.layoutDecoratedWithMargins(view5, v27, v26, v28, v25);
            if(gridLayoutManager$LayoutParams2.a.isRemoved() || gridLayoutManager$LayoutParams2.a.isUpdated()) {
                v0.c = true;
            }
            boolean z1 = v0.d;
            v0.d = view5.hasFocusable() | z1;
        }
        Arrays.fill(this.d, null);
    }

    @Override  // androidx.recyclerview.widget.LinearLayoutManager
    public final void onAnchorReady(D0 d00, K0 k00, U u0, int v) {
        super.onAnchorReady(d00, k00, u0, v);
        this.Q();
        if(k00.b() > 0 && !k00.g) {
            int v1 = this.M(u0.b, d00, k00);
            if(v == 1) {
                while(v1 > 0) {
                    int v2 = u0.b;
                    if(v2 <= 0) {
                        break;
                    }
                    u0.b = v2 - 1;
                    v1 = this.M(v2 - 1, d00, k00);
                }
            }
            else {
                int v3 = k00.b();
                int v4 = u0.b;
                while(v4 < v3 - 1) {
                    int v5 = this.M(v4 + 1, d00, k00);
                    if(v5 <= v1) {
                        break;
                    }
                    ++v4;
                    v1 = v5;
                }
                u0.b = v4;
            }
        }
        this.F();
    }

    @Override  // androidx.recyclerview.widget.LinearLayoutManager
    public final View onFocusSearchFailed(View view0, int v, D0 d00, K0 k00) {
        int v16;
        int v15;
        int v14;
        View view6;
        View view5;
        int v5;
        int v4;
        int v3;
        View view1 = this.findContainingItemView(view0);
        View view2 = null;
        if(view1 == null) {
            return null;
        }
        LayoutParams gridLayoutManager$LayoutParams0 = (LayoutParams)view1.getLayoutParams();
        int v1 = gridLayoutManager$LayoutParams0.e;
        int v2 = gridLayoutManager$LayoutParams0.f + v1;
        if(super.onFocusSearchFailed(view0, v, d00, k00) == null) {
            return null;
        }
        if(this.convertFocusDirectionToLayoutDirection(v) == 1 == this.mShouldReverseLayout) {
            v4 = this.getChildCount();
            v5 = 1;
            v3 = 0;
        }
        else {
            v3 = this.getChildCount() - 1;
            v4 = -1;
            v5 = -1;
        }
        int v6 = this.mOrientation != 1 || !this.isLayoutRTL() ? 0 : 1;
        int v7 = this.L(v3, d00, k00);
        int v8 = -1;
        int v9 = -1;
        int v10 = 0;
        int v11 = 0;
        int v12 = v3;
        View view3 = null;
        while(v12 != v4) {
            int v13 = this.L(v12, d00, k00);
            View view4 = this.getChildAt(v12);
            if(view4 == view1) {
                break;
            }
            if(!view4.hasFocusable() || v13 == v7) {
                LayoutParams gridLayoutManager$LayoutParams1 = (LayoutParams)view4.getLayoutParams();
                int v17 = gridLayoutManager$LayoutParams1.e;
                int v18 = gridLayoutManager$LayoutParams1.f + v17;
                if(view4.hasFocusable() && v17 == v1 && v18 == v2) {
                    return view4;
                }
                if((!view4.hasFocusable() || view2 != null) && (view4.hasFocusable() || view3 != null)) {
                    view5 = view2;
                    int v19 = Math.min(v18, v2) - Math.max(v17, v1);
                    if(view4.hasFocusable()) {
                        if(v19 <= v10 && (v19 != v10 || v6 != (v17 <= v8 ? 0 : 1))) {
                            view6 = view3;
                            v14 = v10;
                            v15 = v9;
                            v16 = v11;
                            goto label_94;
                        }
                        else {
                        label_49:
                            view6 = view3;
                            v14 = v10;
                            v15 = v9;
                            v16 = v11;
                            goto label_73;
                        }
                        goto label_59;
                    }
                    else {
                    label_59:
                        if(view5 == null) {
                            view6 = view3;
                            v14 = v10;
                            int v20 = 1;
                            if(this.isViewPartiallyVisible(view4, false, true)) {
                                v16 = v11;
                                if(v19 > v16) {
                                    v15 = v9;
                                    goto label_73;
                                }
                                else if(v19 == v16) {
                                    v15 = v9;
                                    if(v17 <= v15) {
                                        v20 = 0;
                                    }
                                    if(v6 == v20) {
                                    label_73:
                                        if(view4.hasFocusable()) {
                                            v9 = v15;
                                            v11 = v16;
                                            v8 = gridLayoutManager$LayoutParams1.e;
                                            view3 = view6;
                                            view2 = view4;
                                            v10 = Math.min(v18, v2) - Math.max(v17, v1);
                                            goto label_99;
                                        }
                                        else {
                                            v11 = Math.min(v18, v2) - Math.max(v17, v1);
                                            view3 = view4;
                                            v9 = gridLayoutManager$LayoutParams1.e;
                                            goto label_97;
                                        }
                                        goto label_85;
                                    }
                                }
                                else {
                                label_85:
                                    v15 = v9;
                                }
                            }
                            else {
                                v15 = v9;
                                v16 = v11;
                            }
                        }
                        else {
                            view6 = view3;
                            v14 = v10;
                            v15 = v9;
                            v16 = v11;
                        }
                    }
                }
                else {
                    view5 = view2;
                    goto label_49;
                }
            }
            else {
                if(view2 != null) {
                    break;
                }
                view5 = null;
                view6 = view3;
                v14 = v10;
                v15 = v9;
                v16 = v11;
            }
        label_94:
            v9 = v15;
            v11 = v16;
            view3 = view6;
        label_97:
            v10 = v14;
            view2 = view5;
        label_99:
            v12 += v5;
        }
        return view2 == null ? view3 : view2;
    }

    @Override  // androidx.recyclerview.widget.LinearLayoutManager
    public final void onInitializeAccessibilityNodeInfo(D0 d00, K0 k00, d d0) {
        super.onInitializeAccessibilityNodeInfo(d00, k00, d0);
        d0.l("android.widget.GridView");
        j0 j00 = this.mRecyclerView.m;
        if(j00 != null && j00.getItemCount() > 1) {
            d0.b(c.u);
        }
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onInitializeAccessibilityNodeInfoForItem(D0 d00, K0 k00, View view0, d d0) {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        if(!(viewGroup$LayoutParams0 instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view0, d0);
            return;
        }
        int v = this.L(((LayoutParams)viewGroup$LayoutParams0).a.getLayoutPosition(), d00, k00);
        if(this.mOrientation == 0) {
            d0.n(f.c(((LayoutParams)viewGroup$LayoutParams0).e, ((LayoutParams)viewGroup$LayoutParams0).f, v, 1, false, false));
            return;
        }
        d0.n(f.c(v, 1, ((LayoutParams)viewGroup$LayoutParams0).e, ((LayoutParams)viewGroup$LayoutParams0).f, false, false));
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onItemsAdded(RecyclerView recyclerView0, int v, int v1) {
        this.g.invalidateSpanIndexCache();
        this.g.invalidateSpanGroupIndexCache();
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onItemsChanged(RecyclerView recyclerView0) {
        this.g.invalidateSpanIndexCache();
        this.g.invalidateSpanGroupIndexCache();
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onItemsMoved(RecyclerView recyclerView0, int v, int v1, int v2) {
        this.g.invalidateSpanIndexCache();
        this.g.invalidateSpanGroupIndexCache();
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onItemsRemoved(RecyclerView recyclerView0, int v, int v1) {
        this.g.invalidateSpanIndexCache();
        this.g.invalidateSpanGroupIndexCache();
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onItemsUpdated(RecyclerView recyclerView0, int v, int v1, Object object0) {
        this.g.invalidateSpanIndexCache();
        this.g.invalidateSpanGroupIndexCache();
    }

    @Override  // androidx.recyclerview.widget.LinearLayoutManager
    public void onLayoutChildren(D0 d00, K0 k00) {
        SparseIntArray sparseIntArray0 = this.f;
        SparseIntArray sparseIntArray1 = this.e;
        if(k00.g) {
            int v = this.getChildCount();
            for(int v1 = 0; v1 < v; ++v1) {
                LayoutParams gridLayoutManager$LayoutParams0 = (LayoutParams)this.getChildAt(v1).getLayoutParams();
                int v2 = gridLayoutManager$LayoutParams0.a.getLayoutPosition();
                sparseIntArray1.put(v2, gridLayoutManager$LayoutParams0.f);
                sparseIntArray0.put(v2, gridLayoutManager$LayoutParams0.e);
            }
        }
        super.onLayoutChildren(d00, k00);
        sparseIntArray1.clear();
        sparseIntArray0.clear();
    }

    @Override  // androidx.recyclerview.widget.LinearLayoutManager
    public final void onLayoutCompleted(K0 k00) {
        super.onLayoutCompleted(k00);
        this.a = false;
        int v = this.i;
        if(v != -1) {
            View view0 = this.findViewByPosition(v);
            if(view0 != null) {
                view0.sendAccessibilityEvent(0x4000000);
                this.i = -1;
            }
        }
    }

    @Override  // androidx.recyclerview.widget.LinearLayoutManager
    public final boolean performAccessibilityAction(int v, Bundle bundle0) {
        int v8;
        View view0;
        if(v == c.u.a() && v != -1) {
            for(int v1 = 0; true; ++v1) {
                view0 = null;
                if(v1 >= this.getChildCount()) {
                    break;
                }
                View view1 = this.getChildAt(v1);
                Objects.requireNonNull(view1);
                if(view1.isAccessibilityFocused()) {
                    view0 = this.getChildAt(v1);
                    break;
                }
            }
            if(view0 == null || bundle0 == null) {
                return false;
            }
            int v2 = bundle0.getInt("android.view.accessibility.action.ARGUMENT_DIRECTION_INT", -1);
            if(!GridLayoutManager.l.contains(v2)) {
                return false;
            }
            O0 o00 = this.mRecyclerView.getChildViewHolder(view0);
            if(o00 == null) {
                return false;
            }
            int v3 = o00.getAbsoluteAdapterPosition();
            int v4 = this.H(v3);
            int v5 = this.G(v3);
            if(v4 < 0 || v5 < 0) {
                return false;
            }
            if(!this.I(v3).contains(this.j) || !this.J(this.G(v3), v3).contains(this.k)) {
                this.j = v4;
                this.k = v5;
            }
            int v6 = this.j == -1 ? v4 : this.j;
            int v7 = this.k;
            if(v7 != -1) {
                v5 = v7;
            }
            if(v2 == 17) {
                v8 = v3 - 1;
                while(v8 >= 0) {
                    int v15 = this.H(v8);
                    int v16 = this.G(v8);
                    if(v15 < 0 || v16 < 0) {
                        break;
                    }
                    if(this.mOrientation != 1) {
                        if(this.I(v8).contains(v6) && v16 < v5) {
                            this.k = v16;
                            goto label_93;
                        }
                    }
                    else if(v15 == v6 && v16 < v5 || v15 < v6) {
                        this.j = v15;
                        this.k = v16;
                        goto label_93;
                    }
                    --v8;
                }
            }
            else {
                switch(v2) {
                    case 33: {
                        v8 = v3 - 1;
                        while(v8 >= 0) {
                            int v11 = this.H(v8);
                            int v12 = this.G(v8);
                            if(v11 < 0 || v12 < 0) {
                                break;
                            }
                            if(this.mOrientation != 1) {
                                if(v11 < v6 && v12 == v5) {
                                    this.j = (int)(((Integer)Collections.max(this.I(v8))));
                                    goto label_93;
                                }
                            }
                            else if(v11 < v6 && this.J(this.G(v8), v8).contains(v5)) {
                                this.j = v11;
                                goto label_93;
                            }
                            --v8;
                        }
                        break;
                    }
                    case 66: {
                        v8 = v3 + 1;
                        while(v8 < this.getItemCount()) {
                            int v13 = this.H(v8);
                            int v14 = this.G(v8);
                            if(v13 < 0 || v14 < 0) {
                                break;
                            }
                            if(this.mOrientation != 1) {
                                if(v14 > v5 && this.I(v8).contains(v6)) {
                                    this.k = v14;
                                    goto label_93;
                                }
                            }
                            else if(v13 == v6 && v14 > v5 || v13 > v6) {
                                this.j = v13;
                                this.k = v14;
                                goto label_93;
                            }
                            ++v8;
                        }
                        break;
                    }
                    default: {
                        if(v2 != 130) {
                            return false;
                        }
                        v8 = v3 + 1;
                        while(v8 < this.getItemCount()) {
                            int v9 = this.H(v8);
                            int v10 = this.G(v8);
                            if(v9 < 0 || v10 < 0) {
                                break;
                            }
                            if(this.mOrientation != 1) {
                                if(v9 > v6 && v10 == v5) {
                                    this.j = this.H(v8);
                                    goto label_93;
                                }
                            }
                            else if(v9 > v6 && (v10 == v5 || this.J(this.G(v8), v8).contains(v5))) {
                                this.j = v9;
                                goto label_93;
                            }
                            ++v8;
                        }
                    }
                }
            }
            v8 = -1;
        label_93:
            if(v8 == -1 && this.mOrientation == 0) {
                if(v2 == 17) {
                    if(v4 >= 0) {
                        TreeMap treeMap0 = new TreeMap(Collections.reverseOrder());
                        int v17 = 0;
                        while(v17 < this.getItemCount()) {
                            for(Object object0: this.I(v17)) {
                                if(((int)(((Integer)object0))) < 0) {
                                    goto label_117;
                                }
                                treeMap0.put(((Integer)object0), v17);
                            }
                            ++v17;
                        }
                        for(Object object1: treeMap0.keySet()) {
                            Integer integer0 = (Integer)object1;
                            int v18 = (int)integer0;
                            if(v18 >= v4) {
                                continue;
                            }
                            v8 = (int)(((Integer)treeMap0.get(integer0)));
                            this.j = v18;
                            this.k = this.G(v8);
                            goto label_145;
                        }
                    }
                label_117:
                    v8 = -1;
                }
                else if(v2 == 66) {
                    if(v4 >= 0) {
                        TreeMap treeMap1 = new TreeMap();
                        int v19 = 0;
                        while(v19 < this.getItemCount()) {
                            for(Object object2: this.I(v19)) {
                                Integer integer1 = (Integer)object2;
                                if(((int)integer1) < 0) {
                                    goto label_144;
                                }
                                if(!treeMap1.containsKey(integer1)) {
                                    treeMap1.put(integer1, v19);
                                }
                            }
                            ++v19;
                        }
                        for(Object object3: treeMap1.keySet()) {
                            Integer integer2 = (Integer)object3;
                            int v20 = (int)integer2;
                            if(v20 <= v4) {
                                continue;
                            }
                            v8 = (int)(((Integer)treeMap1.get(integer2)));
                            this.j = v20;
                            this.k = 0;
                            goto label_145;
                        }
                    }
                label_144:
                    v8 = -1;
                }
            }
        label_145:
            if(v8 == -1) {
                return false;
            }
            this.scrollToPosition(v8);
            this.i = v8;
            return true;
        }
        if(v == 0x1020037 && bundle0 != null) {
            int v21 = bundle0.getInt("android.view.accessibility.action.ARGUMENT_ROW_INT", -1);
            int v22 = bundle0.getInt("android.view.accessibility.action.ARGUMENT_COLUMN_INT", -1);
            if(v21 != -1 && v22 != -1) {
                int v23 = this.mRecyclerView.m.getItemCount();
                int v24;
                for(v24 = 0; true; ++v24) {
                    if(v24 >= v23) {
                        v24 = -1;
                        break;
                    }
                    int v25 = this.M(v24, this.mRecyclerView.c, this.mRecyclerView.D0);
                    int v26 = this.L(v24, this.mRecyclerView.c, this.mRecyclerView.D0);
                    if((this.mOrientation == 1 ? v25 == v22 && v26 == v21 : v25 == v21 && v26 == v22)) {
                        break;
                    }
                }
                if(v24 > -1) {
                    this.scrollToPositionWithOffset(v24, 0);
                    return true;
                }
            }
            return false;
        }
        return super.performAccessibilityAction(v, bundle0);
    }

    @Override  // androidx.recyclerview.widget.LinearLayoutManager
    public final int scrollHorizontallyBy(int v, D0 d00, K0 k00) {
        this.Q();
        this.F();
        return super.scrollHorizontallyBy(v, d00, k00);
    }

    @Override  // androidx.recyclerview.widget.LinearLayoutManager
    public final int scrollVerticallyBy(int v, D0 d00, K0 k00) {
        this.Q();
        this.F();
        return super.scrollVerticallyBy(v, d00, k00);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void setMeasuredDimension(Rect rect0, int v, int v1) {
        int v7;
        int v6;
        if(this.c == null) {
            super.setMeasuredDimension(rect0, v, v1);
        }
        int v2 = this.getPaddingLeft();
        int v3 = this.getPaddingRight() + v2;
        int v4 = this.getPaddingTop();
        int v5 = this.getPaddingBottom() + v4;
        if(this.mOrientation == 1) {
            v6 = w0.chooseSize(v1, rect0.height() + v5, this.getMinimumHeight());
            v7 = w0.chooseSize(v, this.c[this.c.length - 1] + v3, this.getMinimumWidth());
        }
        else {
            v7 = w0.chooseSize(v, rect0.width() + v3, this.getMinimumWidth());
            v6 = w0.chooseSize(v1, this.c[this.c.length - 1] + v5, this.getMinimumHeight());
        }
        this.setMeasuredDimension(v7, v6);
    }

    @Override  // androidx.recyclerview.widget.LinearLayoutManager
    public final void setStackFromEnd(boolean z) {
        if(z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(false);
    }

    @Override  // androidx.recyclerview.widget.LinearLayoutManager
    public final boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.a;
    }
}

