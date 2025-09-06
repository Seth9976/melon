package com.google.android.flexbox;

import P.z;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View.MeasureSpec;
import android.view.View;
import androidx.appcompat.app.o;
import androidx.recyclerview.widget.D0;
import androidx.recyclerview.widget.I0;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.b0;
import androidx.recyclerview.widget.c0;
import androidx.recyclerview.widget.d0;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.v0;
import androidx.recyclerview.widget.w0;
import java.util.ArrayList;
import java.util.List;

public class FlexboxLayoutManager extends w0 implements I0, a {
    public static class LayoutParams extends androidx.recyclerview.widget.RecyclerView.LayoutParams implements FlexItem {
        public static final Parcelable.Creator CREATOR;
        public float e;
        public float f;
        public int g;
        public float h;
        public int i;
        public int j;
        public int k;
        public int l;
        public boolean m;

        static {
            LayoutParams.CREATOR = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public LayoutParams(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = -1;
            this.h = -1.0f;
            this.k = 0xFFFFFF;
            this.l = 0xFFFFFF;
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final float A() {
            return this.h;
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final boolean C() {
            return this.m;
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final int E() {
            return this.k;
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final int N() {
            return this.bottomMargin;
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final int P() {
            return this.leftMargin;
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final int b0() {
            return this.rightMargin;
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final int d0() {
            return this.j;
        }

        @Override  // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final int g0() {
            return this.l;
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final int getHeight() {
            return this.height;
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final int getOrder() {
            return 1;
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final int getWidth() {
            return this.width;
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final int o() {
            return this.g;
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final float p() {
            return this.f;
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final int q() {
            return this.i;
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final int r() {
            return this.topMargin;
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final float s() {
            return this.e;
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(Parcel parcel0, int v) {
            parcel0.writeFloat(this.e);
            parcel0.writeFloat(this.f);
            parcel0.writeInt(this.g);
            parcel0.writeFloat(this.h);
            parcel0.writeInt(this.i);
            parcel0.writeInt(this.j);
            parcel0.writeInt(this.k);
            parcel0.writeInt(this.l);
            parcel0.writeByte(((byte)this.m));
            parcel0.writeInt(this.bottomMargin);
            parcel0.writeInt(this.leftMargin);
            parcel0.writeInt(this.rightMargin);
            parcel0.writeInt(this.topMargin);
            parcel0.writeInt(this.height);
            parcel0.writeInt(this.width);
        }
    }

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator CREATOR;
        public int a;
        public int b;

        static {
            SavedState.CREATOR = new i();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        @Override  // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override
        public final String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("SavedState{mAnchorPosition=");
            stringBuilder0.append(this.a);
            stringBuilder0.append(", mAnchorOffset=");
            return o.q(stringBuilder0, this.b, '}');
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(Parcel parcel0, int v) {
            parcel0.writeInt(this.a);
            parcel0.writeInt(this.b);
        }
    }

    public int B;
    public int D;
    public final SparseArray E;
    public final Context G;
    public View I;
    public int M;
    public final z N;
    public static final Rect S;
    public int a;
    public int b;
    public final int c;
    public final int d;
    public boolean e;
    public boolean f;
    public List g;
    public final d h;
    public D0 i;
    public K0 j;
    public h k;
    public final f l;
    public d0 m;
    public d0 n;
    public SavedState o;
    public int r;
    public int w;

    static {
        FlexboxLayoutManager.S = new Rect();
    }

    public FlexboxLayoutManager(Context context0) {
        this.d = -1;
        this.g = new ArrayList();
        this.h = new d(this);
        this.l = new f(this);
        this.r = -1;
        this.w = 0x80000000;
        this.B = 0x80000000;
        this.D = 0x80000000;
        this.E = new SparseArray();
        this.M = -1;
        this.N = new z();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.H(0);
        this.I(1);
        if(this.c != 4) {
            this.removeAllViews();
            this.g.clear();
            f.b(this.l);
            this.l.d = 0;
            this.c = 4;
            this.requestLayout();
        }
        this.setAutoMeasureEnabled(true);
        this.G = context0;
    }

    public FlexboxLayoutManager(Context context0, AttributeSet attributeSet0, int v, int v1) {
        this.d = -1;
        this.g = new ArrayList();
        this.h = new d(this);
        this.l = new f(this);
        this.r = -1;
        this.w = 0x80000000;
        this.B = 0x80000000;
        this.D = 0x80000000;
        this.E = new SparseArray();
        this.M = -1;
        this.N = new z();  // 初始化器: Ljava/lang/Object;-><init>()V
        v0 v00 = w0.getProperties(context0, attributeSet0, v, v1);
        switch(v00.a) {
            case 0: {
                if(v00.c) {
                    this.H(1);
                }
                else {
                    this.H(0);
                }
                break;
            }
            case 1: {
                if(v00.c) {
                    this.H(3);
                }
                else {
                    this.H(2);
                }
            }
        }
        this.I(1);
        if(this.c != 4) {
            this.removeAllViews();
            this.g.clear();
            f.b(this.l);
            this.l.d = 0;
            this.c = 4;
            this.requestLayout();
        }
        this.setAutoMeasureEnabled(true);
        this.G = context0;
    }

    public final View A(int v, int v1, int v2) {
        this.t();
        int v3 = 1;
        if(this.k == null) {
            h h0 = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
            h0.h = 1;
            this.k = h0;
        }
        int v4 = this.m.k();
        int v5 = this.m.g();
        if(v1 <= v) {
            v3 = -1;
        }
        View view0 = null;
        View view1 = null;
        while(v != v1) {
            View view2 = this.getChildAt(v);
            int v6 = this.getPosition(view2);
            if(v6 >= 0 && v6 < v2) {
                if(!((androidx.recyclerview.widget.RecyclerView.LayoutParams)view2.getLayoutParams()).a.isRemoved()) {
                    if(this.m.e(view2) >= v4 && this.m.b(view2) <= v5) {
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
            v += v3;
        }
        return view0 == null ? view1 : view0;
    }

    public final int B(int v, D0 d00, K0 k00, boolean z) {
        int v2;
        if(this.m() || !this.e) {
            int v3 = this.m.g() - v;
            if(v3 > 0) {
                v2 = -this.D(-v3, d00, k00);
            label_8:
                if(z) {
                    int v4 = this.m.g() - (v + v2);
                    if(v4 > 0) {
                        this.m.p(v4);
                        return v4 + v2;
                    }
                }
                return v2;
            }
        }
        else {
            int v1 = v - this.m.k();
            if(v1 > 0) {
                v2 = this.D(v1, d00, k00);
                goto label_8;
            }
        }
        return 0;
    }

    public final int C(int v, D0 d00, K0 k00, boolean z) {
        int v2;
        if(this.m() || !this.e) {
            int v3 = v - this.m.k();
            if(v3 > 0) {
                v2 = -this.D(v3, d00, k00);
            label_8:
                if(z) {
                    int v4 = v + v2 - this.m.k();
                    if(v4 > 0) {
                        this.m.p(-v4);
                        return v2 - v4;
                    }
                }
                return v2;
            }
        }
        else {
            int v1 = this.m.g() - v;
            if(v1 > 0) {
                v2 = this.D(-v1, d00, k00);
                goto label_8;
            }
        }
        return 0;
    }

    public final int D(int v, D0 d00, K0 k00) {
        int v14;
        int v1;
        if(this.getChildCount() != 0 && v != 0) {
            this.t();
            this.k.i = true;
            boolean z = !this.m() && this.e;
            if(!z) {
                v1 = v <= 0 ? -1 : 1;
            }
            else if(v < 0) {
                v1 = 1;
            }
            else {
                v1 = -1;
            }
            int v2 = Math.abs(v);
            this.k.h = v1;
            boolean z1 = this.m();
            int v3 = View.MeasureSpec.makeMeasureSpec(this.getWidth(), this.getWidthMode());
            int v4 = View.MeasureSpec.makeMeasureSpec(this.getHeight(), this.getHeightMode());
            boolean z2 = !z1 && this.e;
            d d0 = this.h;
            if(v1 == 1) {
                View view0 = this.getChildAt(this.getChildCount() - 1);
                h h0 = this.k;
                h0.e = this.m.b(view0);
                int v5 = this.getPosition(view0);
                View view1 = this.y(view0, ((b)this.g.get(d0.c[v5])));
                h h1 = this.k;
                h1.getClass();
                h1.d = v5 + 1;
                int[] arr_v = d0.c;
                h1.c = arr_v.length <= v5 + 1 ? -1 : arr_v[v5 + 1];
                if(z2) {
                    h1.e = this.m.e(view1);
                    h h2 = this.k;
                    int v6 = this.m.e(view1);
                    h2.f = this.m.k() - v6;
                    this.k.f = this.k.f >= 0 ? this.k.f : 0;
                }
                else {
                    h1.e = this.m.b(view1);
                    h h3 = this.k;
                    h3.f = this.m.b(view1) - this.m.g();
                }
                int v7 = this.k.c;
                if((v7 == -1 || v7 > this.g.size() - 1) && this.k.d <= this.j.b()) {
                    h h4 = this.k;
                    int v8 = v2 - h4.f;
                    z z3 = this.N;
                    z3.b = null;
                    z3.a = 0;
                    if(v8 > 0) {
                        if(z1) {
                            this.h.b(z3, v3, v4, v8, h4.d, -1, this.g);
                        }
                        else {
                            this.h.b(z3, v4, v3, v8, h4.d, -1, this.g);
                        }
                        d0.h(v3, v4, this.k.d);
                        d0.u(this.k.d);
                    }
                }
            }
            else {
                View view2 = this.getChildAt(0);
                h h5 = this.k;
                h5.e = this.m.e(view2);
                int v9 = this.getPosition(view2);
                View view3 = this.w(view2, ((b)this.g.get(d0.c[v9])));
                h h6 = this.k;
                h6.getClass();
                int v10 = d0.c[v9];
                if(v10 == -1) {
                    v10 = 0;
                }
                if(v10 > 0) {
                    this.k.d = v9 - ((b)this.g.get(v10 - 1)).h;
                }
                else {
                    h6.d = -1;
                }
                h h7 = this.k;
                h7.c = v10 <= 0 ? 0 : v10 - 1;
                if(z2) {
                    h7.e = this.m.b(view3);
                    h h8 = this.k;
                    h8.f = this.m.b(view3) - this.m.g();
                    this.k.f = this.k.f >= 0 ? this.k.f : 0;
                }
                else {
                    h7.e = this.m.e(view3);
                    h h9 = this.k;
                    int v11 = this.m.e(view3);
                    h9.f = this.m.k() - v11;
                }
            }
            int v12 = this.k.f;
            this.k.a = v2 - v12;
            int v13 = this.u(d00, k00, this.k) + v12;
            if(v13 >= 0) {
                if(!z) {
                    v14 = v2 <= v13 ? v : v1 * v13;
                }
                else if(v2 > v13) {
                    v14 = -v1 * v13;
                }
                else {
                    v14 = v;
                }
                this.m.p(-v14);
                this.k.g = v14;
                return v14;
            }
        }
        return 0;
    }

    public final int E(int v) {
        if(this.getChildCount() != 0 && v != 0) {
            this.t();
            boolean z = this.m();
            View view0 = this.I;
            int v1 = z ? view0.getWidth() : view0.getHeight();
            int v2 = z ? this.getWidth() : this.getHeight();
            int v3 = this.getLayoutDirection();
            f f0 = this.l;
            if(v3 == 1) {
                int v4 = Math.abs(v);
                if(v < 0) {
                    return -Math.min(v2 + f0.d - v1, v4);
                }
                return f0.d + v <= 0 ? v : -f0.d;
            }
            if(v > 0) {
                return Math.min(v2 - f0.d - v1, v);
            }
            return f0.d + v < 0 ? -f0.d : v;
        }
        return 0;
    }

    public final void F(D0 d00, h h0) {
        if(h0.i) {
            d d0 = this.h;
            int v = -1;
            if(h0.h == -1) {
                if(h0.f >= 0) {
                    this.m.f();
                    int v1 = this.getChildCount();
                    if(v1 != 0) {
                        int v2 = v1 - 1;
                        View view0 = this.getChildAt(v2);
                        int[] arr_v = d0.c;
                        int v3 = arr_v[this.getPosition(view0)];
                        if(v3 != -1) {
                            b b0 = (b)this.g.get(v3);
                            int v4 = v2;
                            while(v4 >= 0) {
                                View view1 = this.getChildAt(v4);
                                int v5 = h0.f;
                                if(this.m() || !this.e) {
                                    if(this.m.e(view1) >= this.m.f() - v5) {
                                        goto label_22;
                                    }
                                    break;
                                }
                                else if(this.m.b(view1) > v5) {
                                    break;
                                }
                            label_22:
                                if(b0.o == this.getPosition(view1)) {
                                    if(v3 <= 0) {
                                        v1 = v4;
                                        break;
                                    }
                                    v3 += h0.h;
                                    b0 = (b)this.g.get(v3);
                                    v1 = v4;
                                }
                                --v4;
                            }
                            while(v2 >= v1) {
                                this.removeAndRecycleViewAt(v2, d00);
                                --v2;
                            }
                        }
                    }
                }
            }
            else if(h0.f >= 0) {
                int v6 = this.getChildCount();
                if(v6 != 0) {
                    int v7 = 0;
                    View view2 = this.getChildAt(0);
                    int[] arr_v1 = d0.c;
                    int v8 = arr_v1[this.getPosition(view2)];
                    if(v8 != -1) {
                        b b1 = (b)this.g.get(v8);
                        while(v7 < v6) {
                            View view3 = this.getChildAt(v7);
                            int v9 = h0.f;
                            if(this.m() || !this.e) {
                                if(this.m.b(view3) <= v9) {
                                    goto label_52;
                                }
                                break;
                            }
                            else if(this.m.f() - this.m.e(view3) > v9) {
                                break;
                            }
                        label_52:
                            if(b1.p == this.getPosition(view3)) {
                                if(v8 >= this.g.size() - 1) {
                                    v = v7;
                                    break;
                                }
                                v8 += h0.h;
                                b1 = (b)this.g.get(v8);
                                v = v7;
                            }
                            ++v7;
                        }
                        while(v >= 0) {
                            this.removeAndRecycleViewAt(v, d00);
                            --v;
                        }
                    }
                }
            }
        }
    }

    public final void G() {
        int v = this.m() ? this.getHeightMode() : this.getWidthMode();
        this.k.b = v == 0x80000000 || v == 0;
    }

    public final void H(int v) {
        if(this.a != v) {
            this.removeAllViews();
            this.a = v;
            this.m = null;
            this.n = null;
            this.g.clear();
            f.b(this.l);
            this.l.d = 0;
            this.requestLayout();
        }
    }

    public final void I(int v) {
        int v1 = this.b;
        if(v1 != 1) {
            if(v1 == 0) {
                this.removeAllViews();
                this.g.clear();
                f.b(this.l);
                this.l.d = 0;
            }
            this.b = 1;
            this.m = null;
            this.n = null;
            this.requestLayout();
        }
    }

    // 去混淆评级： 低(40)
    public final boolean J(View view0, int v, int v1, LayoutParams flexboxLayoutManager$LayoutParams0) {
        return view0.isLayoutRequested() || !this.isMeasurementCacheEnabled() || !FlexboxLayoutManager.o(view0.getWidth(), v, flexboxLayoutManager$LayoutParams0.width) || !FlexboxLayoutManager.o(view0.getHeight(), v1, flexboxLayoutManager$LayoutParams0.height);
    }

    public final void K(int v) {
        if(v < this.findLastVisibleItemPosition()) {
            int v1 = this.getChildCount();
            this.h.j(v1);
            this.h.k(v1);
            this.h.i(v1);
            if(v < this.h.c.length) {
                this.M = v;
                View view0 = this.getChildAt(0);
                if(view0 != null) {
                    this.r = this.getPosition(view0);
                    if(!this.m() && this.e) {
                        int v2 = this.m.b(view0);
                        this.w = this.m.h() + v2;
                        return;
                    }
                    this.w = this.m.e(view0) - this.m.k();
                }
            }
        }
    }

    public final void L(f f0, boolean z, boolean z1) {
        if(z1) {
            this.G();
        }
        else {
            this.k.b = false;
        }
        if(this.m() || !this.e) {
            h h1 = this.k;
            h1.a = this.m.g() - f0.c;
        }
        else {
            h h0 = this.k;
            h0.a = f0.c - this.getPaddingRight();
        }
        this.k.d = f0.a;
        this.k.h = 1;
        this.k.e = f0.c;
        this.k.f = 0x80000000;
        this.k.c = f0.b;
        if(z && this.g.size() > 1 && (f0.b >= 0 && f0.b < this.g.size() - 1)) {
            b b0 = (b)this.g.get(f0.b);
            ++this.k.c;
            this.k.d += b0.h;
        }
    }

    public final void M(f f0, boolean z, boolean z1) {
        if(z1) {
            this.G();
        }
        else {
            this.k.b = false;
        }
        if(this.m() || !this.e) {
            h h1 = this.k;
            h1.a = f0.c - this.m.k();
        }
        else {
            h h0 = this.k;
            h0.a = this.I.getWidth() - f0.c - this.m.k();
        }
        this.k.d = f0.a;
        this.k.h = -1;
        this.k.e = f0.c;
        this.k.f = 0x80000000;
        this.k.c = f0.b;
        if(z && f0.b > 0) {
            int v = f0.b;
            if(this.g.size() > v) {
                b b0 = (b)this.g.get(v);
                --this.k.c;
                this.k.d -= b0.h;
            }
        }
    }

    @Override  // com.google.android.flexbox.a
    public final void a(View view0, int v, int v1, b b0) {
        this.calculateItemDecorationsForChild(view0, FlexboxLayoutManager.S);
        if(this.m()) {
            int v2 = this.getLeftDecorationWidth(view0);
            int v3 = this.getRightDecorationWidth(view0) + v2;
            b0.e += v3;
            b0.f += v3;
            return;
        }
        int v4 = this.getTopDecorationHeight(view0);
        int v5 = this.getBottomDecorationHeight(view0) + v4;
        b0.e += v5;
        b0.f += v5;
    }

    @Override  // com.google.android.flexbox.a
    public final int b(int v, int v1, int v2) {
        return w0.getChildMeasureSpec(this.getWidth(), this.getWidthMode(), v1, v2, this.canScrollHorizontally());
    }

    @Override  // com.google.android.flexbox.a
    public final View c(int v) {
        View view0 = (View)this.E.get(v);
        return view0 == null ? this.i.k(v, 0x7FFFFFFFFFFFFFFFL).itemView : view0;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final boolean canScrollHorizontally() {
        if(this.b == 0) {
            return this.m();
        }
        return this.m() ? this.getWidth() > (this.I == null ? 0 : this.I.getWidth()) : true;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final boolean canScrollVertically() {
        if(this.b == 0) {
            return !this.m();
        }
        return this.m() ? true : this.getHeight() > (this.I == null ? 0 : this.I.getHeight());
    }

    @Override  // androidx.recyclerview.widget.w0
    public final boolean checkLayoutParams(androidx.recyclerview.widget.RecyclerView.LayoutParams recyclerView$LayoutParams0) {
        return recyclerView$LayoutParams0 instanceof LayoutParams;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final int computeHorizontalScrollExtent(K0 k00) {
        return this.q(k00);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final int computeHorizontalScrollOffset(K0 k00) {
        return this.r(k00);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final int computeHorizontalScrollRange(K0 k00) {
        return this.s(k00);
    }

    @Override  // androidx.recyclerview.widget.I0
    public final PointF computeScrollVectorForPosition(int v) {
        if(this.getChildCount() == 0) {
            return null;
        }
        int v1 = v >= this.getPosition(this.getChildAt(0)) ? 1 : -1;
        return this.m() ? new PointF(0.0f, ((float)v1)) : new PointF(((float)v1), 0.0f);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final int computeVerticalScrollExtent(K0 k00) {
        return this.q(k00);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final int computeVerticalScrollOffset(K0 k00) {
        return this.r(k00);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final int computeVerticalScrollRange(K0 k00) {
        return this.s(k00);
    }

    @Override  // com.google.android.flexbox.a
    public final int d(int v, int v1, int v2) {
        return w0.getChildMeasureSpec(this.getHeight(), this.getHeightMode(), v1, v2, this.canScrollVertically());
    }

    @Override  // com.google.android.flexbox.a
    public final void e(View view0, int v) {
        this.E.put(v, view0);
    }

    @Override  // com.google.android.flexbox.a
    public final int f(View view0) {
        int v;
        if(this.m()) {
            v = this.getTopDecorationHeight(view0);
            return this.getBottomDecorationHeight(view0) + v;
        }
        v = this.getLeftDecorationWidth(view0);
        return this.getRightDecorationWidth(view0) + v;
    }

    public final int findLastVisibleItemPosition() {
        View view0 = this.z(this.getChildCount() - 1, -1);
        return view0 == null ? -1 : this.getPosition(view0);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final androidx.recyclerview.widget.RecyclerView.LayoutParams generateDefaultLayoutParams() {
        androidx.recyclerview.widget.RecyclerView.LayoutParams recyclerView$LayoutParams0 = new LayoutParams(-2, -2);  // 初始化器: Landroidx/recyclerview/widget/RecyclerView$LayoutParams;-><init>(II)V
        recyclerView$LayoutParams0.e = 0.0f;
        recyclerView$LayoutParams0.f = 1.0f;
        recyclerView$LayoutParams0.g = -1;
        recyclerView$LayoutParams0.h = -1.0f;
        recyclerView$LayoutParams0.k = 0xFFFFFF;
        recyclerView$LayoutParams0.l = 0xFFFFFF;
        return recyclerView$LayoutParams0;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final androidx.recyclerview.widget.RecyclerView.LayoutParams generateLayoutParams(Context context0, AttributeSet attributeSet0) {
        return new LayoutParams(context0, attributeSet0);
    }

    @Override  // com.google.android.flexbox.a
    public final int getAlignContent() {
        return 5;
    }

    @Override  // com.google.android.flexbox.a
    public final int getAlignItems() {
        return this.c;
    }

    @Override  // com.google.android.flexbox.a
    public final int getFlexDirection() {
        return this.a;
    }

    @Override  // com.google.android.flexbox.a
    public final int getFlexItemCount() {
        return this.j.b();
    }

    @Override  // com.google.android.flexbox.a
    public final List getFlexLinesInternal() {
        return this.g;
    }

    @Override  // com.google.android.flexbox.a
    public final int getFlexWrap() {
        return this.b;
    }

    @Override  // com.google.android.flexbox.a
    public final int getLargestMainSize() {
        if(this.g.size() == 0) {
            return 0;
        }
        int v1 = this.g.size();
        int v2 = 0x80000000;
        for(int v = 0; v < v1; ++v) {
            v2 = Math.max(v2, ((b)this.g.get(v)).e);
        }
        return v2;
    }

    @Override  // com.google.android.flexbox.a
    public final int getMaxLine() {
        return this.d;
    }

    @Override  // com.google.android.flexbox.a
    public final int getSumOfCrossSize() {
        int v = this.g.size();
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += ((b)this.g.get(v1)).g;
        }
        return v2;
    }

    @Override  // com.google.android.flexbox.a
    public final void i(b b0) {
    }

    @Override  // com.google.android.flexbox.a
    public final View j(int v) {
        return this.c(v);
    }

    @Override  // com.google.android.flexbox.a
    public final int k(View view0, int v, int v1) {
        int v2;
        if(this.m()) {
            v2 = this.getLeftDecorationWidth(view0);
            return this.getRightDecorationWidth(view0) + v2;
        }
        v2 = this.getTopDecorationHeight(view0);
        return this.getBottomDecorationHeight(view0) + v2;
    }

    @Override  // com.google.android.flexbox.a
    public final boolean m() {
        return this.a == 0 || this.a == 1;
    }

    @Override  // androidx.recyclerview.widget.w0
    public static boolean o(int v, int v1, int v2) {
        int v3 = View.MeasureSpec.getMode(v1);
        int v4 = View.MeasureSpec.getSize(v1);
        if(v2 > 0 && v != v2) {
            return false;
        }
        switch(v3) {
            case 0x80000000: {
                return v4 >= v;
            }
            case 0: {
                return true;
            }
            default: {
                return v3 == 0x40000000 ? v4 == v : false;
            }
        }
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onAdapterChanged(j0 j00, j0 j01) {
        this.removeAllViews();
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onAttachedToWindow(RecyclerView recyclerView0) {
        super.onAttachedToWindow(recyclerView0);
        this.I = (View)recyclerView0.getParent();
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onDetachedFromWindow(RecyclerView recyclerView0, D0 d00) {
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onItemsAdded(RecyclerView recyclerView0, int v, int v1) {
        super.onItemsAdded(recyclerView0, v, v1);
        this.K(v);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onItemsMoved(RecyclerView recyclerView0, int v, int v1, int v2) {
        super.onItemsMoved(recyclerView0, v, v1, v2);
        this.K(Math.min(v, v1));
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onItemsRemoved(RecyclerView recyclerView0, int v, int v1) {
        super.onItemsRemoved(recyclerView0, v, v1);
        this.K(v);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onItemsUpdated(RecyclerView recyclerView0, int v, int v1) {
        super.onItemsUpdated(recyclerView0, v, v1);
        this.K(v);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onItemsUpdated(RecyclerView recyclerView0, int v, int v1, Object object0) {
        super.onItemsUpdated(recyclerView0, v, v1, object0);
        this.K(v);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onLayoutChildren(D0 d00, K0 k00) {
        int v23;
        int v22;
        int v18;
        boolean z;
        int v7;
        this.i = d00;
        this.j = k00;
        int v = k00.b();
        if(v != 0 || !k00.g) {
            int v1 = this.getLayoutDirection();
            int v2 = this.a;
            switch(v2) {
                case 0: {
                    this.e = v1 == 1;
                    this.f = this.b == 2;
                    break;
                }
                case 1: {
                    this.e = v1 != 1;
                    this.f = this.b == 2;
                    break;
                }
                case 2: {
                    this.e = v1 == 1;
                    if(this.b == 2) {
                        this.e = v1 != 1;
                    }
                    this.f = false;
                    break;
                }
                default: {
                    if(v2 == 3) {
                        this.e = v1 == 1;
                        if(this.b == 2) {
                            this.e = v1 != 1;
                        }
                        this.f = true;
                    }
                    else {
                        this.e = false;
                        this.f = false;
                    }
                }
            }
            this.t();
            if(this.k == null) {
                h h0 = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
                h0.h = 1;
                this.k = h0;
            }
            d d0 = this.h;
            d0.j(v);
            d0.k(v);
            d0.i(v);
            this.k.i = false;
            SavedState flexboxLayoutManager$SavedState0 = this.o;
            if(flexboxLayoutManager$SavedState0 != null) {
                int v3 = flexboxLayoutManager$SavedState0.a;
                if(v3 >= 0 && v3 < v) {
                    this.r = v3;
                }
            }
            f f0 = this.l;
            if(!f0.f || this.r != -1 || flexboxLayoutManager$SavedState0 != null) {
                f.b(f0);
                SavedState flexboxLayoutManager$SavedState1 = this.o;
                if(k00.g) {
                label_92:
                    if(this.getChildCount() == 0) {
                    label_123:
                        f.a(f0);
                        f0.a = 0;
                        f0.b = 0;
                    }
                    else {
                        View view1 = f0.e ? this.x(k00.b()) : this.v(k00.b());
                        if(view1 == null) {
                            goto label_123;
                        }
                        else {
                            FlexboxLayoutManager flexboxLayoutManager0 = f0.h;
                            d0 d01 = flexboxLayoutManager0.b == 0 ? flexboxLayoutManager0.n : flexboxLayoutManager0.m;
                            if(flexboxLayoutManager0.m() || !flexboxLayoutManager0.e) {
                                if(f0.e) {
                                    int v10 = d01.b(view1);
                                    f0.c = d01.m() + v10;
                                }
                                else {
                                    f0.c = d01.e(view1);
                                }
                            }
                            else if(f0.e) {
                                int v9 = d01.e(view1);
                                f0.c = d01.m() + v9;
                            }
                            else {
                                f0.c = d01.b(view1);
                            }
                            int v11 = flexboxLayoutManager0.getPosition(view1);
                            f0.a = v11;
                            f0.g = false;
                            int[] arr_v = flexboxLayoutManager0.h.c;
                            if(v11 == -1) {
                                v11 = 0;
                            }
                            int v12 = arr_v[v11];
                            if(v12 == -1) {
                                v12 = 0;
                            }
                            f0.b = v12;
                            int v13 = f0.b;
                            if(flexboxLayoutManager0.g.size() > v13) {
                                f0.a = ((b)flexboxLayoutManager0.g.get(v13)).o;
                            }
                        }
                    }
                }
                else {
                    int v4 = this.r;
                    if(v4 == -1) {
                        goto label_92;
                    }
                    else if(v4 >= 0 && v4 < k00.b()) {
                        f0.a = this.r;
                        f0.b = d0.c[this.r];
                        SavedState flexboxLayoutManager$SavedState2 = this.o;
                        if(flexboxLayoutManager$SavedState2 == null) {
                        label_59:
                            if(this.w == 0x80000000) {
                                View view0 = this.findViewByPosition(this.r);
                                if(view0 == null) {
                                    if(this.getChildCount() > 0) {
                                        int v8 = this.getPosition(this.getChildAt(0));
                                        f0.e = this.r < v8;
                                    }
                                    f.a(f0);
                                }
                                else if(this.m.c(view0) > this.m.l()) {
                                    f.a(f0);
                                }
                                else if(this.m.e(view0) - this.m.k() < 0) {
                                    f0.c = this.m.k();
                                    f0.e = false;
                                }
                                else if(this.m.g() - this.m.b(view0) < 0) {
                                    f0.c = this.m.g();
                                    f0.e = true;
                                }
                                else {
                                    if(f0.e) {
                                        int v6 = this.m.b(view0);
                                        v7 = this.m.m() + v6;
                                    }
                                    else {
                                        v7 = this.m.e(view0);
                                    }
                                    f0.c = v7;
                                }
                            }
                            else if(this.m() || !this.e) {
                                f0.c = this.m.k() + this.w;
                            }
                            else {
                                f0.c = this.w - this.m.h();
                            }
                        }
                        else {
                            int v5 = k00.b();
                            if(flexboxLayoutManager$SavedState2.a >= 0 && flexboxLayoutManager$SavedState2.a < v5) {
                                f0.c = this.m.k() + flexboxLayoutManager$SavedState1.b;
                                f0.g = true;
                                f0.b = -1;
                                goto label_126;
                            }
                            goto label_59;
                        }
                    }
                    else {
                        this.r = -1;
                        this.w = 0x80000000;
                        goto label_92;
                    }
                }
            label_126:
                f0.f = true;
            }
            this.detachAndScrapAttachedViews(d00);
            if(f0.e) {
                this.M(f0, false, true);
            }
            else {
                this.L(f0, false, true);
            }
            int v14 = View.MeasureSpec.makeMeasureSpec(this.getWidth(), this.getWidthMode());
            int v15 = View.MeasureSpec.makeMeasureSpec(this.getHeight(), this.getHeightMode());
            int v16 = this.getWidth();
            int v17 = this.getHeight();
            Context context0 = this.G;
            if(this.m()) {
                z = this.B != 0x80000000 && this.B != v16;
                h h1 = this.k;
                v18 = h1.b ? context0.getResources().getDisplayMetrics().heightPixels : h1.a;
            }
            else {
                z = this.D != 0x80000000 && this.D != v17;
                v18 = this.k.b ? context0.getResources().getDisplayMetrics().widthPixels : this.k.a;
            }
            this.B = v16;
            this.D = v17;
            int v19 = this.M;
            z z1 = this.N;
            if(v19 != -1 || this.r == -1 && !z) {
                int v21 = v19 == -1 ? f0.a : Math.min(v19, f0.a);
                z1.b = null;
                z1.a = 0;
                if(!this.m()) {
                    if(this.g.size() > 0) {
                        d0.d(v21, this.g);
                        this.h.b(this.N, v15, v14, v18, v21, f0.a, this.g);
                    }
                    else {
                        d0.i(v);
                        this.h.b(this.N, v15, v14, v18, 0, -1, this.g);
                    }
                }
                else if(this.g.size() > 0) {
                    d0.d(v21, this.g);
                    this.h.b(this.N, v14, v15, v18, v21, f0.a, this.g);
                }
                else {
                    d0.i(v);
                    this.h.b(this.N, v14, v15, v18, 0, -1, this.g);
                }
                this.g = z1.b;
                d0.h(v14, v15, v21);
                d0.u(v21);
            }
            else if(!f0.e) {
                this.g.clear();
                z1.b = null;
                z1.a = 0;
                if(this.m()) {
                    this.h.b(this.N, v14, v15, v18, 0, f0.a, this.g);
                }
                else {
                    this.h.b(this.N, v15, v14, v18, 0, f0.a, this.g);
                }
                this.g = z1.b;
                d0.h(v14, v15, 0);
                d0.u(0);
                int v20 = d0.c[f0.a];
                f0.b = v20;
                this.k.c = v20;
            }
            if(f0.e) {
                this.u(d00, k00, this.k);
                v22 = this.k.e;
                this.L(f0, true, false);
                this.u(d00, k00, this.k);
                v23 = this.k.e;
            }
            else {
                this.u(d00, k00, this.k);
                v23 = this.k.e;
                this.M(f0, true, false);
                this.u(d00, k00, this.k);
                v22 = this.k.e;
            }
            if(this.getChildCount() > 0) {
                if(f0.e) {
                    this.C(this.B(v23, d00, k00, true) + v22, d00, k00, false);
                    return;
                }
                this.B(this.C(v22, d00, k00, true) + v23, d00, k00, false);
            }
        }
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onLayoutCompleted(K0 k00) {
        this.o = null;
        this.r = -1;
        this.w = 0x80000000;
        this.M = -1;
        f.b(this.l);
        this.E.clear();
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        if(parcelable0 instanceof SavedState) {
            this.o = (SavedState)parcelable0;
            this.requestLayout();
        }
    }

    @Override  // androidx.recyclerview.widget.w0
    public final Parcelable onSaveInstanceState() {
        SavedState flexboxLayoutManager$SavedState0 = this.o;
        if(flexboxLayoutManager$SavedState0 != null) {
            Parcelable parcelable0 = new SavedState();  // 初始化器: Ljava/lang/Object;-><init>()V
            parcelable0.a = flexboxLayoutManager$SavedState0.a;
            parcelable0.b = flexboxLayoutManager$SavedState0.b;
            return parcelable0;
        }
        Parcelable parcelable1 = new SavedState();  // 初始化器: Ljava/lang/Object;-><init>()V
        if(this.getChildCount() > 0) {
            View view0 = this.getChildAt(0);
            parcelable1.a = this.getPosition(view0);
            parcelable1.b = this.m.e(view0) - this.m.k();
            return parcelable1;
        }
        parcelable1.a = -1;
        return parcelable1;
    }

    public final int q(K0 k00) {
        if(this.getChildCount() != 0) {
            int v = k00.b();
            this.t();
            View view0 = this.v(v);
            View view1 = this.x(v);
            if(k00.b() != 0 && view0 != null && view1 != null) {
                int v1 = this.m.b(view1);
                int v2 = this.m.e(view0);
                return Math.min(this.m.l(), v1 - v2);
            }
        }
        return 0;
    }

    public final int r(K0 k00) {
        if(this.getChildCount() != 0) {
            int v = k00.b();
            View view0 = this.v(v);
            View view1 = this.x(v);
            if(k00.b() != 0 && view0 != null && view1 != null) {
                int v1 = this.getPosition(view0);
                int v2 = this.getPosition(view1);
                int v3 = Math.abs(this.m.b(view1) - this.m.e(view0));
                int[] arr_v = this.h.c;
                int v4 = arr_v[v1];
                return v4 == -1 || v4 == 0 ? 0 : Math.round(((float)v4) * (((float)v3) / ((float)(arr_v[v2] - v4 + 1))) + ((float)(this.m.k() - this.m.e(view0))));
            }
        }
        return 0;
    }

    public final int s(K0 k00) {
        if(this.getChildCount() != 0) {
            int v = k00.b();
            View view0 = this.v(v);
            View view1 = this.x(v);
            if(k00.b() != 0 && view0 != null && view1 != null) {
                View view2 = this.z(0, this.getChildCount());
                int v1 = view2 == null ? -1 : this.getPosition(view2);
                int v2 = this.findLastVisibleItemPosition();
                return (int)(((float)Math.abs(this.m.b(view1) - this.m.e(view0))) / ((float)(v2 - v1 + 1)) * ((float)k00.b()));
            }
        }
        return 0;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final int scrollHorizontallyBy(int v, D0 d00, K0 k00) {
        if(this.m() && (this.b != 0 || !this.m())) {
            int v1 = this.E(v);
            this.l.d += v1;
            this.n.p(-v1);
            return v1;
        }
        int v2 = this.D(v, d00, k00);
        this.E.clear();
        return v2;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void scrollToPosition(int v) {
        this.r = v;
        this.w = 0x80000000;
        SavedState flexboxLayoutManager$SavedState0 = this.o;
        if(flexboxLayoutManager$SavedState0 != null) {
            flexboxLayoutManager$SavedState0.a = -1;
        }
        this.requestLayout();
    }

    @Override  // androidx.recyclerview.widget.w0
    public final int scrollVerticallyBy(int v, D0 d00, K0 k00) {
        if(!this.m() && (this.b != 0 || this.m())) {
            int v1 = this.E(v);
            this.l.d += v1;
            this.n.p(-v1);
            return v1;
        }
        int v2 = this.D(v, d00, k00);
        this.E.clear();
        return v2;
    }

    @Override  // com.google.android.flexbox.a
    public final void setFlexLines(List list0) {
        this.g = list0;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void smoothScrollToPosition(RecyclerView recyclerView0, K0 k00, int v) {
        LinearSmoothScroller linearSmoothScroller0 = new LinearSmoothScroller(recyclerView0.getContext());
        linearSmoothScroller0.setTargetPosition(v);
        this.startSmoothScroll(linearSmoothScroller0);
    }

    public final void t() {
        if(this.m != null) {
            return;
        }
        if(this.m()) {
            if(this.b == 0) {
                this.m = new b0(this);  // 初始化器: Landroidx/recyclerview/widget/d0;-><init>(Landroidx/recyclerview/widget/w0;)V
                this.n = new c0(this);  // 初始化器: Landroidx/recyclerview/widget/d0;-><init>(Landroidx/recyclerview/widget/w0;)V
                return;
            }
            this.m = new c0(this);  // 初始化器: Landroidx/recyclerview/widget/d0;-><init>(Landroidx/recyclerview/widget/w0;)V
            this.n = new b0(this);  // 初始化器: Landroidx/recyclerview/widget/d0;-><init>(Landroidx/recyclerview/widget/w0;)V
            return;
        }
        if(this.b == 0) {
            this.m = new c0(this);  // 初始化器: Landroidx/recyclerview/widget/d0;-><init>(Landroidx/recyclerview/widget/w0;)V
            this.n = new b0(this);  // 初始化器: Landroidx/recyclerview/widget/d0;-><init>(Landroidx/recyclerview/widget/w0;)V
            return;
        }
        this.m = new b0(this);  // 初始化器: Landroidx/recyclerview/widget/d0;-><init>(Landroidx/recyclerview/widget/w0;)V
        this.n = new c0(this);  // 初始化器: Landroidx/recyclerview/widget/d0;-><init>(Landroidx/recyclerview/widget/w0;)V
    }

    public final int u(D0 d00, K0 k00, h h0) {
        int v42;
        Rect rect3;
        float f7;
        int v41;
        int v40;
        int v35;
        int v30;
        boolean z2;
        Rect rect1;
        int v16;
        int v15;
        d d1;
        boolean z1;
        int v14;
        int v13;
        int v9;
        int v = h0.f;
        if(v != 0x80000000) {
            int v1 = h0.a;
            if(v1 < 0) {
                h0.f = v + v1;
            }
            this.F(d00, h0);
        }
        int v2 = h0.a;
        boolean z = this.m();
        int v3 = v2;
        int v4 = 0;
        while((v3 > 0 || this.k.b) && (h0.d >= 0 && h0.d < k00.b() && (h0.c >= 0 && h0.c < this.g.size()))) {
            b b0 = (b)this.g.get(h0.c);
            h0.d = b0.o;
            f f0 = this.l;
            Rect rect0 = FlexboxLayoutManager.S;
            d d0 = this.h;
            if(this.m()) {
                int v5 = this.getPaddingLeft();
                int v6 = this.getPaddingRight();
                int v7 = h0.d;
                float f1 = ((float)v5) - ((float)f0.d);
                float f2 = ((float)(this.getWidth() - v6)) - ((float)f0.d);
                int v8 = b0.h;
                v9 = v2;
                int v10 = h0.h == -1 ? h0.e - b0.g : h0.e;
                int v11 = v7;
                int v12 = 0;
                while(v11 < v7 + v8) {
                    View view0 = this.c(v11);
                    if(view0 == null) {
                        v13 = v12;
                        v14 = v11;
                        z1 = z;
                        d1 = d0;
                        v15 = v8;
                        v16 = v7;
                        rect1 = rect0;
                    }
                    else {
                        z1 = z;
                        if(h0.h == 1) {
                            this.calculateItemDecorationsForChild(view0, rect0);
                            this.addView(view0);
                        }
                        else {
                            this.calculateItemDecorationsForChild(view0, rect0);
                            this.addView(view0, v12);
                            ++v12;
                        }
                        d1 = d0;
                        long v17 = d0.d[v11];
                        int v18 = (int)v17;
                        int v19 = (int)(v17 >> 0x20);
                        LayoutParams flexboxLayoutManager$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                        if(this.J(view0, v18, v19, flexboxLayoutManager$LayoutParams0)) {
                            view0.measure(v18, v19);
                        }
                        int v20 = flexboxLayoutManager$LayoutParams0.leftMargin;
                        float f3 = f1 + ((float)(this.getLeftDecorationWidth(view0) + v20));
                        int v21 = flexboxLayoutManager$LayoutParams0.rightMargin;
                        float f4 = f2 - ((float)(this.getRightDecorationWidth(view0) + v21));
                        int v22 = this.getTopDecorationHeight(view0) + v10;
                        if(this.e) {
                            int v23 = view0.getMeasuredWidth();
                            int v24 = view0.getMeasuredHeight();
                            v15 = v8;
                            v16 = v7;
                            v14 = v11;
                            rect1 = rect0;
                            v13 = v12;
                            this.h.o(view0, b0, Math.round(f4) - v23, v22, Math.round(f4), v24 + v22);
                        }
                        else {
                            v13 = v12;
                            v15 = v8;
                            v16 = v7;
                            rect1 = rect0;
                            v14 = v11;
                            int v25 = view0.getMeasuredWidth();
                            int v26 = view0.getMeasuredHeight();
                            this.h.o(view0, b0, Math.round(f3), v22, v25 + Math.round(f3), v26 + v22);
                        }
                        int v27 = view0.getMeasuredWidth() + flexboxLayoutManager$LayoutParams0.rightMargin;
                        int v28 = this.getRightDecorationWidth(view0);
                        int v29 = view0.getMeasuredWidth() + flexboxLayoutManager$LayoutParams0.leftMargin;
                        f2 = f4 - (((float)(this.getLeftDecorationWidth(view0) + v29)) + 0.0f);
                        f1 = ((float)(v28 + v27)) + 0.0f + f3;
                    }
                    v11 = v14 + 1;
                    v7 = v16;
                    d0 = d1;
                    z = z1;
                    v12 = v13;
                    v8 = v15;
                    rect0 = rect1;
                }
                z2 = z;
            }
            else {
                v9 = v2;
                z2 = z;
                d d2 = d0;
                Rect rect2 = rect0;
                int v31 = this.getPaddingTop();
                int v32 = this.getPaddingBottom();
                int v33 = this.getHeight();
                int v34 = h0.e;
                if(h0.h == -1) {
                    v35 = v34 + b0.g;
                    v34 -= b0.g;
                }
                else {
                    v35 = v34;
                }
                int v36 = h0.d;
                float f5 = ((float)v31) - ((float)f0.d);
                float f6 = ((float)(v33 - v32)) - ((float)f0.d);
                int v37 = b0.h;
                int v38 = v36;
                int v39 = 0;
                while(v38 < v36 + v37) {
                    View view1 = this.c(v38);
                    if(view1 == null) {
                        v40 = v37;
                        v41 = v38;
                        f7 = f6;
                        rect3 = rect2;
                        v42 = v36;
                    }
                    else {
                        long v43 = d2.d[v38];
                        int v44 = (int)v43;
                        int v45 = (int)(v43 >> 0x20);
                        LayoutParams flexboxLayoutManager$LayoutParams1 = (LayoutParams)view1.getLayoutParams();
                        if(this.J(view1, v44, v45, flexboxLayoutManager$LayoutParams1)) {
                            view1.measure(v44, v45);
                        }
                        int v46 = flexboxLayoutManager$LayoutParams1.topMargin;
                        int v47 = this.getTopDecorationHeight(view1);
                        int v48 = flexboxLayoutManager$LayoutParams1.rightMargin;
                        float f8 = f5 + ((float)(v47 + v46));
                        float f9 = f6 - ((float)(this.getBottomDecorationHeight(view1) + v48));
                        if(h0.h == 1) {
                            rect3 = rect2;
                            this.calculateItemDecorationsForChild(view1, rect3);
                            this.addView(view1);
                        }
                        else {
                            rect3 = rect2;
                            this.calculateItemDecorationsForChild(view1, rect3);
                            this.addView(view1, v39);
                            ++v39;
                        }
                        int v49 = this.getLeftDecorationWidth(view1) + v34;
                        int v50 = v35 - this.getRightDecorationWidth(view1);
                        if(!this.e) {
                            v40 = v37;
                            v41 = v38;
                            v42 = v36;
                            if(this.f) {
                                int v55 = view1.getMeasuredHeight();
                                int v56 = view1.getMeasuredWidth();
                                this.h.p(view1, b0, false, v49, Math.round(f9) - v55, v56 + v49, Math.round(f9));
                            }
                            else {
                                int v57 = view1.getMeasuredWidth();
                                int v58 = view1.getMeasuredHeight();
                                this.h.p(view1, b0, false, v49, Math.round(f8), v57 + v49, v58 + Math.round(f8));
                            }
                        }
                        else if(this.f) {
                            int v51 = view1.getMeasuredWidth();
                            int v52 = view1.getMeasuredHeight();
                            v42 = v36;
                            v40 = v37;
                            v41 = v38;
                            this.h.p(view1, b0, true, v50 - v51, Math.round(f9) - v52, v50, Math.round(f9));
                        }
                        else {
                            v40 = v37;
                            v41 = v38;
                            v42 = v36;
                            int v53 = view1.getMeasuredWidth();
                            int v54 = view1.getMeasuredHeight();
                            this.h.p(view1, b0, true, v50 - v53, Math.round(f8), v50, v54 + Math.round(f8));
                        }
                        int v59 = view1.getMeasuredHeight() + flexboxLayoutManager$LayoutParams1.topMargin;
                        int v60 = this.getBottomDecorationHeight(view1);
                        int v61 = view1.getMeasuredHeight() + flexboxLayoutManager$LayoutParams1.bottomMargin;
                        f7 = f9 - (((float)(this.getTopDecorationHeight(view1) + v61)) + 0.0f);
                        f5 = ((float)(v60 + v59)) + 0.0f + f8;
                    }
                    v38 = v41 + 1;
                    v36 = v42;
                    rect2 = rect3;
                    f6 = f7;
                    v37 = v40;
                }
            }
            h0.c += this.k.h;
            v30 = b0.g;
            v4 += v30;
            if(z2 || !this.e) {
                h0.e = b0.g * h0.h + h0.e;
            }
            else {
                h0.e -= b0.g * h0.h;
            }
            v3 -= b0.g;
            v2 = v9;
            z = z2;
        }
        int v62 = h0.a - v4;
        h0.a = v62;
        int v63 = h0.f;
        if(v63 != 0x80000000) {
            int v64 = v63 + v4;
            h0.f = v64;
            if(v62 < 0) {
                h0.f = v64 + v62;
            }
            this.F(d00, h0);
        }
        return v2 - h0.a;
    }

    public final View v(int v) {
        View view0 = this.A(0, this.getChildCount(), v);
        if(view0 == null) {
            return null;
        }
        int v1 = this.h.c[this.getPosition(view0)];
        return v1 == -1 ? null : this.w(view0, ((b)this.g.get(v1)));
    }

    public final View w(View view0, b b0) {
        boolean z = this.m();
        int v = b0.h;
        for(int v1 = 1; v1 < v; ++v1) {
            View view1 = this.getChildAt(v1);
            if(view1 != null && view1.getVisibility() != 8) {
                if(!this.e || z) {
                    if(this.m.e(view0) > this.m.e(view1)) {
                        view0 = view1;
                    }
                }
                else if(this.m.b(view0) < this.m.b(view1)) {
                    view0 = view1;
                }
            }
        }
        return view0;
    }

    public final View x(int v) {
        View view0 = this.A(this.getChildCount() - 1, -1, v);
        if(view0 == null) {
            return null;
        }
        int v1 = this.getPosition(view0);
        return this.y(view0, ((b)this.g.get(this.h.c[v1])));
    }

    public final View y(View view0, b b0) {
        boolean z = this.m();
        int v = this.getChildCount() - 2;
        int v1 = this.getChildCount() - b0.h - 1;
        while(v > v1) {
            View view1 = this.getChildAt(v);
            if(view1 != null && view1.getVisibility() != 8) {
                if(!this.e || z) {
                    if(this.m.b(view0) < this.m.b(view1)) {
                        view0 = view1;
                    }
                }
                else if(this.m.e(view0) > this.m.e(view1)) {
                    view0 = view1;
                }
            }
            --v;
        }
        return view0;
    }

    public final View z(int v, int v1) {
        int v2 = v1 <= v ? -1 : 1;
        while(v != v1) {
            View view0 = this.getChildAt(v);
            int v3 = this.getPaddingLeft();
            int v4 = this.getPaddingTop();
            int v5 = this.getPaddingRight();
            int v6 = this.getPaddingBottom();
            androidx.recyclerview.widget.RecyclerView.LayoutParams recyclerView$LayoutParams0 = (androidx.recyclerview.widget.RecyclerView.LayoutParams)view0.getLayoutParams();
            int v7 = this.getDecoratedLeft(view0) - recyclerView$LayoutParams0.leftMargin;
            androidx.recyclerview.widget.RecyclerView.LayoutParams recyclerView$LayoutParams1 = (androidx.recyclerview.widget.RecyclerView.LayoutParams)view0.getLayoutParams();
            int v8 = this.getDecoratedTop(view0) - recyclerView$LayoutParams1.topMargin;
            androidx.recyclerview.widget.RecyclerView.LayoutParams recyclerView$LayoutParams2 = (androidx.recyclerview.widget.RecyclerView.LayoutParams)view0.getLayoutParams();
            int v9 = this.getDecoratedRight(view0) + recyclerView$LayoutParams2.rightMargin;
            androidx.recyclerview.widget.RecyclerView.LayoutParams recyclerView$LayoutParams3 = (androidx.recyclerview.widget.RecyclerView.LayoutParams)view0.getLayoutParams();
            boolean z = false;
            boolean z1 = v7 >= this.getWidth() - v5 || v9 >= v3;
            if(v8 >= this.getHeight() - v6 || this.getDecoratedBottom(view0) + recyclerView$LayoutParams3.bottomMargin >= v4) {
                z = true;
            }
            if(z1 && z) {
                return view0;
            }
            v += v2;
        }
        return null;
    }
}

