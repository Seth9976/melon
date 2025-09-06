package androidx.recyclerview.widget;

import B6.f;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import com.iloen.melon.utils.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

public class StaggeredGridLayoutManager extends w0 implements I0 {
    public static class LayoutParams extends androidx.recyclerview.widget.RecyclerView.LayoutParams {
        public W0 e;
        public boolean f;

        public LayoutParams(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator CREATOR;
        public int a;
        public int b;
        public int c;
        public int[] d;
        public int e;
        public int[] f;
        public ArrayList g;
        public boolean h;
        public boolean i;
        public boolean j;

        static {
            SavedState.CREATOR = new V0();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        @Override  // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(Parcel parcel0, int v) {
            parcel0.writeInt(this.a);
            parcel0.writeInt(this.b);
            parcel0.writeInt(this.c);
            if(this.c > 0) {
                parcel0.writeIntArray(this.d);
            }
            parcel0.writeInt(this.e);
            if(this.e > 0) {
                parcel0.writeIntArray(this.f);
            }
            parcel0.writeInt(((int)this.h));
            parcel0.writeInt(((int)this.i));
            parcel0.writeInt(((int)this.j));
            parcel0.writeList(this.g);
        }
    }

    public int B;
    public final Rect D;
    public final S0 E;
    public boolean G;
    public final boolean I;
    public int[] M;
    public final z N;
    public final int a;
    public final W0[] b;
    public final d0 c;
    public final d0 d;
    public final int e;
    public int f;
    public final T g;
    public boolean h;
    public boolean i;
    public final BitSet j;
    public int k;
    public int l;
    public final U0 m;
    public final int n;
    public boolean o;
    public boolean r;
    public SavedState w;

    public StaggeredGridLayoutManager(Context context0, AttributeSet attributeSet0, int v, int v1) {
        this.a = -1;
        this.h = false;
        this.i = false;
        this.k = -1;
        this.l = 0x80000000;
        U0 u00 = new U0();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.m = u00;
        this.n = 2;
        this.D = new Rect();
        this.E = new S0(this);
        this.G = false;
        this.I = true;
        this.N = new z(this, 2);
        v0 v00 = w0.getProperties(context0, attributeSet0, v, v1);
        int v2 = v00.a;
        if(v2 != 0 && v2 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        this.assertNotInLayoutOrScroll(null);
        if(v2 != this.e) {
            this.e = v2;
            this.c = this.d;
            this.d = this.c;
            this.requestLayout();
        }
        int v3 = v00.b;
        this.assertNotInLayoutOrScroll(null);
        if(v3 != this.a) {
            u00.b();
            this.requestLayout();
            this.a = v3;
            this.j = new BitSet(this.a);
            this.b = new W0[this.a];
            for(int v4 = 0; v4 < this.a; ++v4) {
                this.b[v4] = new W0(this, v4);
            }
            this.requestLayout();
        }
        boolean z = v00.c;
        this.assertNotInLayoutOrScroll(null);
        SavedState staggeredGridLayoutManager$SavedState0 = this.w;
        if(staggeredGridLayoutManager$SavedState0 != null && staggeredGridLayoutManager$SavedState0.h != z) {
            staggeredGridLayoutManager$SavedState0.h = z;
        }
        this.h = z;
        this.requestLayout();
        T t0 = new T();  // 初始化器: Ljava/lang/Object;-><init>()V
        t0.a = true;
        t0.f = 0;
        t0.g = 0;
        this.g = t0;
        this.c = d0.a(this, this.e);
        this.d = d0.a(this, 1 - this.e);
    }

    public final int A(int v) {
        int v1 = this.b[0].j(v);
        for(int v2 = 1; v2 < this.a; ++v2) {
            int v3 = this.b[v2].j(v);
            if(v3 < v1) {
                v1 = v3;
            }
        }
        return v1;
    }

    public final void B(int v, int v1, int v2) {
        int v5;
        int v4;
        int v3 = this.i ? this.y() : this.x();
        if(v2 != 8) {
            v4 = v + v1;
            v5 = v;
        }
        else if(v < v1) {
            v4 = v1 + 1;
            v5 = v;
        }
        else {
            v4 = v + 1;
            v5 = v1;
        }
        U0 u00 = this.m;
        u00.g(v5);
        if(v2 == 1) {
            u00.h(v, v1);
        }
        else {
            switch(v2) {
                case 2: {
                    u00.i(v, v1);
                    break;
                }
                case 8: {
                    u00.i(v, 1);
                    u00.h(v1, 1);
                }
            }
        }
        if(v4 > v3 && v5 <= (this.i ? this.x() : this.y())) {
            this.requestLayout();
        }
    }

    // This method was un-flattened
    public final View C() {
        int v5;
        int v = this.getChildCount();
        int v1 = v - 1;
        BitSet bitSet0 = new BitSet(this.a);
        bitSet0.set(0, this.a, true);
        int v2 = -1;
        int v3 = this.e != 1 || !this.isLayoutRTL() ? -1 : 1;
        if(this.i) {
            v = -1;
        }
        else {
            v1 = 0;
        }
        if(v1 < v) {
            v2 = 1;
        }
        while(v1 != v) {
            View view0 = this.getChildAt(v1);
            LayoutParams staggeredGridLayoutManager$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
            if(bitSet0.get(staggeredGridLayoutManager$LayoutParams0.e.e)) {
                W0 w00 = staggeredGridLayoutManager$LayoutParams0.e;
                if(this.i) {
                    int v4 = w00.c;
                    if(v4 == 0x80000000) {
                        w00.b();
                        v4 = w00.c;
                    }
                    if(v4 < this.c.g()) {
                        v5 = !((LayoutParams)((View)a.i(1, w00.a)).getLayoutParams()).f;
                        goto label_33;
                    }
                }
                else {
                    int v6 = w00.b;
                    if(v6 == 0x80000000) {
                        w00.c();
                        v6 = w00.b;
                    }
                    if(v6 > this.c.k()) {
                        v5 = !((LayoutParams)((View)w00.a.get(0)).getLayoutParams()).f;
                        goto label_33;
                    }
                }
                v5 = 0;
            label_33:
                if(v5 != 0) {
                    return view0;
                }
                bitSet0.clear(staggeredGridLayoutManager$LayoutParams0.e.e);
            }
            if(!staggeredGridLayoutManager$LayoutParams0.f) {
                int v7 = v1 + v2;
                if(v7 != v) {
                    View view1 = this.getChildAt(v7);
                    if(this.i) {
                        int v8 = this.c.b(view0);
                        int v9 = this.c.b(view1);
                        if(v8 < v9) {
                            return view0;
                        }
                        if(v8 == v9) {
                            goto label_49;
                        }
                    }
                    else {
                        int v10 = this.c.e(view0);
                        int v11 = this.c.e(view1);
                        if(v10 > v11) {
                            return view0;
                        }
                        if(v10 == v11) {
                        label_49:
                            LayoutParams staggeredGridLayoutManager$LayoutParams1 = (LayoutParams)view1.getLayoutParams();
                            if((staggeredGridLayoutManager$LayoutParams0.e.e - staggeredGridLayoutManager$LayoutParams1.e.e >= 0 ? 0 : 1) == (v3 >= 0 ? 0 : 1)) {
                                goto label_52;
                            }
                            return view0;
                        }
                    }
                }
            }
        label_52:
            v1 += v2;
        }
        return null;
    }

    public final void D(View view0, int v, int v1) {
        this.calculateItemDecorationsForChild(view0, this.D);
        LayoutParams staggeredGridLayoutManager$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        int v2 = StaggeredGridLayoutManager.P(v, staggeredGridLayoutManager$LayoutParams0.leftMargin + this.D.left, staggeredGridLayoutManager$LayoutParams0.rightMargin + this.D.right);
        int v3 = StaggeredGridLayoutManager.P(v1, staggeredGridLayoutManager$LayoutParams0.topMargin + this.D.top, staggeredGridLayoutManager$LayoutParams0.bottomMargin + this.D.bottom);
        if(this.shouldMeasureChild(view0, v2, v3, staggeredGridLayoutManager$LayoutParams0)) {
            view0.measure(v2, v3);
        }
    }

    public final void E(D0 d00, K0 k00, boolean z) {
        boolean z4;
        S0 s00 = this.E;
        if((this.w != null || this.k != -1) && k00.b() == 0) {
            this.removeAndRecycleAllViews(d00);
            s00.a();
            return;
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager0 = s00.g;
        boolean z1 = true;
        boolean z2 = !s00.e || this.k != -1 || this.w != null;
        U0 u00 = this.m;
        if(z2) {
            s00.a();
            SavedState staggeredGridLayoutManager$SavedState0 = this.w;
            if(staggeredGridLayoutManager$SavedState0 == null) {
                this.K();
                s00.c = this.i;
            }
            else {
                int v = staggeredGridLayoutManager$SavedState0.c;
                if(v > 0) {
                    if(v == this.a) {
                        for(int v1 = 0; v1 < this.a; ++v1) {
                            this.b[v1].d();
                            SavedState staggeredGridLayoutManager$SavedState1 = this.w;
                            int v2 = staggeredGridLayoutManager$SavedState1.d[v1];
                            if(v2 != 0x80000000) {
                                v2 += (staggeredGridLayoutManager$SavedState1.i ? this.c.g() : this.c.k());
                            }
                            W0 w00 = this.b[v1];
                            w00.b = v2;
                            w00.c = v2;
                        }
                    }
                    else {
                        staggeredGridLayoutManager$SavedState0.d = null;
                        staggeredGridLayoutManager$SavedState0.c = 0;
                        staggeredGridLayoutManager$SavedState0.e = 0;
                        staggeredGridLayoutManager$SavedState0.f = null;
                        staggeredGridLayoutManager$SavedState0.g = null;
                        staggeredGridLayoutManager$SavedState0.a = staggeredGridLayoutManager$SavedState0.b;
                    }
                }
                this.r = this.w.j;
                boolean z3 = this.w.h;
                this.assertNotInLayoutOrScroll(null);
                SavedState staggeredGridLayoutManager$SavedState2 = this.w;
                if(staggeredGridLayoutManager$SavedState2 != null && staggeredGridLayoutManager$SavedState2.h != z3) {
                    staggeredGridLayoutManager$SavedState2.h = z3;
                }
                this.h = z3;
                this.requestLayout();
                this.K();
                SavedState staggeredGridLayoutManager$SavedState3 = this.w;
                int v3 = staggeredGridLayoutManager$SavedState3.a;
                if(v3 == -1) {
                    s00.c = this.i;
                }
                else {
                    this.k = v3;
                    s00.c = staggeredGridLayoutManager$SavedState3.i;
                }
                if(staggeredGridLayoutManager$SavedState3.e > 1) {
                    u00.a = staggeredGridLayoutManager$SavedState3.f;
                    u00.b = staggeredGridLayoutManager$SavedState3.g;
                }
            }
            if(k00.g) {
            label_109:
                int v9 = 0;
                if(this.o) {
                    int v10 = k00.b();
                    for(int v11 = this.getChildCount() - 1; v11 >= 0; --v11) {
                        int v12 = this.getPosition(this.getChildAt(v11));
                        if(v12 >= 0 && v12 < v10) {
                            v9 = v12;
                            break;
                        }
                    }
                }
                else {
                    int v13 = k00.b();
                    int v14 = this.getChildCount();
                    for(int v15 = 0; v15 < v14; ++v15) {
                        int v16 = this.getPosition(this.getChildAt(v15));
                        if(v16 >= 0 && v16 < v13) {
                            v9 = v16;
                            break;
                        }
                    }
                }
                s00.a = v9;
                s00.b = 0x80000000;
            }
            else {
                int v4 = this.k;
                if(v4 == -1) {
                    goto label_109;
                }
                else if(v4 < 0 || v4 >= k00.b()) {
                    this.k = -1;
                    this.l = 0x80000000;
                    goto label_109;
                }
                else if(this.w != null && this.w.a != -1 && this.w.c >= 1) {
                    s00.b = 0x80000000;
                    s00.a = this.k;
                }
                else {
                    View view0 = this.findViewByPosition(this.k);
                    if(view0 == null) {
                        int v7 = this.k;
                        s00.a = v7;
                        int v8 = this.l;
                        if(v8 == 0x80000000) {
                            if(this.getChildCount() != 0) {
                                z4 = v7 < this.x() == this.i;
                            }
                            else if(this.i) {
                                z4 = true;
                            }
                            else {
                                z4 = false;
                            }
                            s00.c = z4;
                            s00.b = z4 ? staggeredGridLayoutManager0.c.g() : staggeredGridLayoutManager0.c.k();
                        }
                        else if(s00.c) {
                            s00.b = staggeredGridLayoutManager0.c.g() - v8;
                        }
                        else {
                            s00.b = staggeredGridLayoutManager0.c.k() + v8;
                        }
                        s00.d = true;
                    }
                    else {
                        s00.a = this.i ? this.y() : this.x();
                        if(this.l == 0x80000000) {
                            if(this.c.c(view0) > this.c.l()) {
                                s00.b = s00.c ? this.c.g() : this.c.k();
                            }
                            else {
                                int v5 = this.c.e(view0) - this.c.k();
                                if(v5 < 0) {
                                    s00.b = -v5;
                                }
                                else {
                                    int v6 = this.c.g() - this.c.b(view0);
                                    s00.b = v6 < 0 ? v6 : 0x80000000;
                                }
                            }
                        }
                        else if(s00.c) {
                            s00.b = this.c.g() - this.l - this.c.b(view0);
                        }
                        else {
                            s00.b = this.c.k() + this.l - this.c.e(view0);
                        }
                    }
                }
            }
            s00.e = true;
        }
        if(this.w == null && this.k == -1 && (s00.c != this.o || this.isLayoutRTL() != this.r)) {
            u00.b();
            s00.d = true;
        }
        if(this.getChildCount() > 0 && (this.w == null || this.w.c < 1)) {
            if(s00.d) {
                for(int v17 = 0; v17 < this.a; ++v17) {
                    this.b[v17].d();
                    int v18 = s00.b;
                    if(v18 != 0x80000000) {
                        W0 w01 = this.b[v17];
                        w01.b = v18;
                        w01.c = v18;
                    }
                }
            }
            else if(z2 || s00.f == null) {
                for(int v21 = 0; v21 < this.a; ++v21) {
                    W0 w03 = this.b[v21];
                    boolean z5 = this.i;
                    int v22 = s00.b;
                    int v23 = z5 ? w03.h(0x80000000) : w03.j(0x80000000);
                    w03.d();
                    if(v23 != 0x80000000 && (!z5 || v23 >= w03.f.c.g()) && (z5 || v23 <= w03.f.c.k())) {
                        if(v22 != 0x80000000) {
                            v23 += v22;
                        }
                        w03.c = v23;
                        w03.b = v23;
                    }
                }
                W0[] arr_w0 = this.b;
                if(s00.f == null || s00.f.length < arr_w0.length) {
                    s00.f = new int[staggeredGridLayoutManager0.b.length];
                }
                for(int v24 = 0; v24 < arr_w0.length; ++v24) {
                    int[] arr_v = s00.f;
                    arr_v[v24] = arr_w0[v24].j(0x80000000);
                }
            }
            else {
                for(int v19 = 0; v19 < this.a; ++v19) {
                    W0 w02 = this.b[v19];
                    w02.d();
                    int v20 = s00.f[v19];
                    w02.b = v20;
                    w02.c = v20;
                }
            }
        }
        this.detachAndScrapAttachedViews(d00);
        T t0 = this.g;
        t0.a = false;
        this.G = false;
        int v25 = this.d.l();
        this.f = v25 / this.a;
        this.B = View.MeasureSpec.makeMeasureSpec(v25, this.d.i());
        this.N(s00.a, k00);
        if(s00.c) {
            this.L(-1);
            this.s(d00, t0, k00);
            this.L(1);
        }
        else {
            this.L(1);
            this.s(d00, t0, k00);
            this.L(-1);
        }
        t0.c = s00.a + t0.d;
        this.s(d00, t0, k00);
        if(this.d.i() != 0x40000000) {
            int v26 = this.getChildCount();
            float f = 0.0f;
            for(int v27 = 0; v27 < v26; ++v27) {
                View view1 = this.getChildAt(v27);
                float f1 = (float)this.d.c(view1);
                if(f1 >= f) {
                    if(((LayoutParams)view1.getLayoutParams()).f) {
                        f1 = f1 * 1.0f / ((float)this.a);
                    }
                    f = Math.max(f, f1);
                }
            }
            int v28 = this.f;
            int v29 = this.d.i() == 0x80000000 ? Math.min(Math.round(f * ((float)this.a)), this.d.l()) : Math.round(f * ((float)this.a));
            this.f = v29 / this.a;
            this.B = View.MeasureSpec.makeMeasureSpec(v29, this.d.i());
            if(this.f != v28) {
                for(int v30 = 0; v30 < v26; ++v30) {
                    View view2 = this.getChildAt(v30);
                    LayoutParams staggeredGridLayoutManager$LayoutParams0 = (LayoutParams)view2.getLayoutParams();
                    if(!staggeredGridLayoutManager$LayoutParams0.f) {
                        if(!this.isLayoutRTL() || this.e != 1) {
                            int v32 = this.f * staggeredGridLayoutManager$LayoutParams0.e.e;
                            int v33 = staggeredGridLayoutManager$LayoutParams0.e.e * v28;
                            if(this.e == 1) {
                                view2.offsetLeftAndRight(v32 - v33);
                            }
                            else {
                                view2.offsetTopAndBottom(v32 - v33);
                            }
                        }
                        else {
                            int v31 = -(this.a - 1 - staggeredGridLayoutManager$LayoutParams0.e.e);
                            view2.offsetLeftAndRight(this.f * v31 - v31 * v28);
                        }
                    }
                }
            }
        }
        if(this.getChildCount() > 0) {
            if(this.i) {
                this.v(d00, k00, true);
                this.w(d00, k00, false);
            }
            else {
                this.w(d00, k00, true);
                this.v(d00, k00, false);
            }
        }
        if(!z || k00.g || this.n == 0 || this.getChildCount() <= 0 || !this.G && this.C() == null) {
            z1 = false;
        }
        else {
            this.removeCallbacks(this.N);
            if(!this.q()) {
                z1 = false;
            }
        }
        if(k00.g) {
            s00.a();
        }
        this.o = s00.c;
        this.r = this.isLayoutRTL();
        if(z1) {
            s00.a();
            this.E(d00, k00, false);
        }
    }

    public final boolean F(int v) {
        return this.e == 0 ? v == -1 != this.i : v == -1 == this.i == this.isLayoutRTL();
    }

    public final void G(int v, K0 k00) {
        int v2;
        int v1;
        if(v > 0) {
            v1 = this.y();
            v2 = 1;
        }
        else {
            v1 = this.x();
            v2 = -1;
        }
        this.g.a = true;
        this.N(v1, k00);
        this.L(v2);
        this.g.c = v1 + this.g.d;
        this.g.b = Math.abs(v);
    }

    public final void H(D0 d00, T t0) {
        int v = 1;
        if(t0.a && !t0.i) {
            if(t0.b == 0) {
                if(t0.e == -1) {
                    this.I(t0.g, d00);
                    return;
                }
                this.J(t0.f, d00);
                return;
            }
            if(t0.e == -1) {
                int v1 = t0.f;
                int v2 = this.b[0].j(v1);
                while(v < this.a) {
                    int v3 = this.b[v].j(v1);
                    if(v3 > v2) {
                        v2 = v3;
                    }
                    ++v;
                }
                int v4 = v1 - v2;
                this.I((v4 >= 0 ? t0.g - Math.min(v4, t0.b) : t0.g), d00);
                return;
            }
            int v5 = t0.g;
            int v6 = this.b[0].h(v5);
            while(v < this.a) {
                int v7 = this.b[v].h(v5);
                if(v7 < v6) {
                    v6 = v7;
                }
                ++v;
            }
            int v8 = v6 - t0.g;
            this.J((v8 >= 0 ? Math.min(v8, t0.b) + t0.f : t0.f), d00);
        }
    }

    public final void I(int v, D0 d00) {
        int v1 = this.getChildCount() - 1;
    alab1:
        while(v1 >= 0) {
            View view0 = this.getChildAt(v1);
            if(this.c.e(view0) < v || this.c.o(view0) < v) {
                break;
            }
            LayoutParams staggeredGridLayoutManager$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
            if(staggeredGridLayoutManager$LayoutParams0.f) {
                for(int v3 = 0; v3 < this.a; ++v3) {
                    if(this.b[v3].a.size() == 1) {
                        break alab1;
                    }
                }
                for(int v2 = 0; v2 < this.a; ++v2) {
                    this.b[v2].k();
                }
            }
            else {
                if(staggeredGridLayoutManager$LayoutParams0.e.a.size() == 1) {
                    break;
                }
                staggeredGridLayoutManager$LayoutParams0.e.k();
            }
            this.removeAndRecycleView(view0, d00);
            --v1;
        }
    }

    public final void J(int v, D0 d00) {
    alab1:
        while(this.getChildCount() > 0) {
            View view0 = this.getChildAt(0);
            if(this.c.b(view0) > v || this.c.n(view0) > v) {
                break;
            }
            LayoutParams staggeredGridLayoutManager$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
            if(staggeredGridLayoutManager$LayoutParams0.f) {
                for(int v2 = 0; v2 < this.a; ++v2) {
                    if(this.b[v2].a.size() == 1) {
                        break alab1;
                    }
                }
                for(int v1 = 0; v1 < this.a; ++v1) {
                    this.b[v1].l();
                }
            }
            else {
                if(staggeredGridLayoutManager$LayoutParams0.e.a.size() == 1) {
                    break;
                }
                staggeredGridLayoutManager$LayoutParams0.e.l();
            }
            this.removeAndRecycleView(view0, d00);
        }
    }

    public final void K() {
        if(this.e != 1 && this.isLayoutRTL()) {
            this.i = !this.h;
            return;
        }
        this.i = this.h;
    }

    public final void L(int v) {
        this.g.e = v;
        this.g.d = this.i == (v == -1) ? 1 : -1;
    }

    public final void M(int v, int v1) {
        for(int v2 = 0; v2 < this.a; ++v2) {
            if(!this.b[v2].a.isEmpty()) {
                this.O(this.b[v2], v, v1);
            }
        }
    }

    public final void N(int v, K0 k00) {
        int v3;
        int v2;
        T t0 = this.g;
        boolean z = false;
        t0.b = 0;
        t0.c = v;
        if(this.isSmoothScrolling()) {
            int v1 = k00.a;
            if(v1 == -1) {
                v2 = 0;
                v3 = 0;
            }
            else if(this.i == v1 < v) {
                v2 = this.c.l();
                v3 = 0;
            }
            else {
                v3 = this.c.l();
                v2 = 0;
            }
        }
        else {
            v2 = 0;
            v3 = 0;
        }
        if(this.getClipToPadding()) {
            t0.f = this.c.k() - v3;
            t0.g = this.c.g() + v2;
        }
        else {
            t0.g = this.c.f() + v2;
            t0.f = -v3;
        }
        t0.h = false;
        t0.a = true;
        if(this.c.i() == 0 && this.c.f() == 0) {
            z = true;
        }
        t0.i = z;
    }

    public final void O(W0 w00, int v, int v1) {
        int v2 = w00.d;
        int v3 = w00.e;
        if(v == -1) {
            int v4 = w00.b;
            if(v4 == 0x80000000) {
                w00.c();
                v4 = w00.b;
            }
            if(v4 + v2 <= v1) {
                this.j.set(v3, false);
            }
        }
        else {
            int v5 = w00.c;
            if(v5 == 0x80000000) {
                w00.b();
                v5 = w00.c;
            }
            if(v5 - v2 >= v1) {
                this.j.set(v3, false);
            }
        }
    }

    public static int P(int v, int v1, int v2) {
        if(v1 != 0 || v2 != 0) {
            int v3 = View.MeasureSpec.getMode(v);
            return v3 == 0x80000000 || v3 == 0x40000000 ? View.MeasureSpec.makeMeasureSpec(Math.max(0, View.MeasureSpec.getSize(v) - v1 - v2), v3) : v;
        }
        return v;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void assertNotInLayoutOrScroll(String s) {
        if(this.w == null) {
            super.assertNotInLayoutOrScroll(s);
        }
    }

    @Override  // androidx.recyclerview.widget.w0
    public final boolean canScrollHorizontally() {
        return this.e == 0;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final boolean canScrollVertically() {
        return this.e == 1;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final boolean checkLayoutParams(androidx.recyclerview.widget.RecyclerView.LayoutParams recyclerView$LayoutParams0) {
        return recyclerView$LayoutParams0 instanceof LayoutParams;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void collectAdjacentPrefetchPositions(int v, int v1, K0 k00, u0 u00) {
        int v6;
        int v5;
        T t0;
        if(this.e != 0) {
            v = v1;
        }
        if(this.getChildCount() != 0 && v != 0) {
            this.G(v, k00);
            if(this.M == null || this.M.length < this.a) {
                this.M = new int[this.a];
            }
            int v4 = 0;
            for(int v3 = 0; true; ++v3) {
                t0 = this.g;
                if(v3 >= this.a) {
                    break;
                }
                if(t0.d == -1) {
                    v5 = t0.f;
                    v6 = this.b[v3].j(v5);
                }
                else {
                    v5 = this.b[v3].h(t0.g);
                    v6 = t0.g;
                }
                int v7 = v5 - v6;
                if(v7 >= 0) {
                    this.M[v4] = v7;
                    ++v4;
                }
            }
            Arrays.sort(this.M, 0, v4);
            for(int v2 = 0; v2 < v4 && (t0.c >= 0 && t0.c < k00.b()); ++v2) {
                ((D)u00).a(t0.c, this.M[v2]);
                t0.c += t0.d;
            }
        }
    }

    @Override  // androidx.recyclerview.widget.w0
    public final int computeHorizontalScrollExtent(K0 k00) {
        if(this.getChildCount() == 0) {
            return 0;
        }
        View view0 = this.u(!this.I);
        View view1 = this.t(!this.I);
        return d.b(k00, this.c, view0, view1, this, this.I);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final int computeHorizontalScrollOffset(K0 k00) {
        return this.r(k00);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final int computeHorizontalScrollRange(K0 k00) {
        if(this.getChildCount() == 0) {
            return 0;
        }
        View view0 = this.u(!this.I);
        View view1 = this.t(!this.I);
        return d.d(k00, this.c, view0, view1, this, this.I);
    }

    @Override  // androidx.recyclerview.widget.I0
    public final PointF computeScrollVectorForPosition(int v) {
        int v1 = -1;
        if(this.getChildCount() != 0) {
            if(v < this.x() == this.i) {
                v1 = 1;
            }
        }
        else if(this.i) {
            v1 = 1;
        }
        PointF pointF0 = new PointF();
        if(this.e == 0) {
            pointF0.x = (float)v1;
            pointF0.y = 0.0f;
            return pointF0;
        }
        pointF0.x = 0.0f;
        pointF0.y = (float)v1;
        return pointF0;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final int computeVerticalScrollExtent(K0 k00) {
        if(this.getChildCount() == 0) {
            return 0;
        }
        View view0 = this.u(!this.I);
        View view1 = this.t(!this.I);
        return d.b(k00, this.c, view0, view1, this, this.I);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final int computeVerticalScrollOffset(K0 k00) {
        return this.r(k00);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final int computeVerticalScrollRange(K0 k00) {
        if(this.getChildCount() == 0) {
            return 0;
        }
        View view0 = this.u(!this.I);
        View view1 = this.t(!this.I);
        return d.d(k00, this.c, view0, view1, this, this.I);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final androidx.recyclerview.widget.RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return this.e == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);  // 初始化器: Landroidx/recyclerview/widget/RecyclerView$LayoutParams;-><init>(II)V / 初始化器: Landroidx/recyclerview/widget/RecyclerView$LayoutParams;-><init>(II)V
    }

    @Override  // androidx.recyclerview.widget.w0
    public final androidx.recyclerview.widget.RecyclerView.LayoutParams generateLayoutParams(Context context0, AttributeSet attributeSet0) {
        return new LayoutParams(context0, attributeSet0);
    }

    // 去混淆评级： 低(20)
    @Override  // androidx.recyclerview.widget.w0
    public final androidx.recyclerview.widget.RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams ? new LayoutParams(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0)) : new LayoutParams(viewGroup$LayoutParams0);  // 初始化器: Landroidx/recyclerview/widget/RecyclerView$LayoutParams;-><init>(Landroid/view/ViewGroup$MarginLayoutParams;)V / 初始化器: Landroidx/recyclerview/widget/RecyclerView$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V
    }

    @Override  // androidx.recyclerview.widget.w0
    public final int getColumnCountForAccessibility(D0 d00, K0 k00) {
        if(this.e == 1) {
            int v = k00.b();
            return Math.min(this.a, v);
        }
        return -1;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final int getRowCountForAccessibility(D0 d00, K0 k00) {
        if(this.e == 0) {
            int v = k00.b();
            return Math.min(this.a, v);
        }
        return -1;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final boolean isAutoMeasureEnabled() {
        return this.n != 0;
    }

    public final boolean isLayoutRTL() {
        return this.getLayoutDirection() == 1;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final boolean isLayoutReversed() {
        return this.h;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void offsetChildrenHorizontal(int v) {
        super.offsetChildrenHorizontal(v);
        for(int v1 = 0; v1 < this.a; ++v1) {
            W0 w00 = this.b[v1];
            int v2 = w00.b;
            if(v2 != 0x80000000) {
                w00.b = v2 + v;
            }
            int v3 = w00.c;
            if(v3 != 0x80000000) {
                w00.c = v3 + v;
            }
        }
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void offsetChildrenVertical(int v) {
        super.offsetChildrenVertical(v);
        for(int v1 = 0; v1 < this.a; ++v1) {
            W0 w00 = this.b[v1];
            int v2 = w00.b;
            if(v2 != 0x80000000) {
                w00.b = v2 + v;
            }
            int v3 = w00.c;
            if(v3 != 0x80000000) {
                w00.c = v3 + v;
            }
        }
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onAdapterChanged(j0 j00, j0 j01) {
        this.m.b();
        for(int v = 0; v < this.a; ++v) {
            this.b[v].d();
        }
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onDetachedFromWindow(RecyclerView recyclerView0, D0 d00) {
        this.removeCallbacks(this.N);
        for(int v = 0; v < this.a; ++v) {
            this.b[v].d();
        }
        recyclerView0.requestLayout();
    }

    @Override  // androidx.recyclerview.widget.w0
    public final View onFocusSearchFailed(View view0, int v, D0 d00, K0 k00) {
        int v1;
        if(this.getChildCount() != 0) {
            View view1 = this.findContainingItemView(view0);
            if(view1 != null) {
                this.K();
                switch(v) {
                    case 1: {
                        v1 = this.e == 1 || !this.isLayoutRTL() ? -1 : 1;
                        break;
                    }
                    case 2: {
                        v1 = this.e == 1 || !this.isLayoutRTL() ? 1 : -1;
                        break;
                    }
                    case 17: {
                        v1 = this.e == 0 ? -1 : 0x80000000;
                        break;
                    }
                    case 33: {
                        v1 = this.e == 1 ? -1 : 0x80000000;
                        break;
                    }
                    case 66: {
                        v1 = this.e == 0 ? 1 : 0x80000000;
                        break;
                    }
                    case 130: {
                        v1 = this.e == 1 ? 1 : 0x80000000;
                        break;
                    }
                    default: {
                        v1 = 0x80000000;
                    }
                }
                if(v1 != 0x80000000) {
                    LayoutParams staggeredGridLayoutManager$LayoutParams0 = (LayoutParams)view1.getLayoutParams();
                    boolean z = staggeredGridLayoutManager$LayoutParams0.f;
                    W0 w00 = staggeredGridLayoutManager$LayoutParams0.e;
                    int v2 = v1 == 1 ? this.y() : this.x();
                    this.N(v2, k00);
                    this.L(v1);
                    this.g.c = this.g.d + v2;
                    this.g.b = (int)(((float)this.c.l()) * 0.333333f);
                    this.g.h = true;
                    this.g.a = false;
                    this.s(d00, this.g, k00);
                    this.o = this.i;
                    if(!z) {
                        View view2 = w00.i(v2, v1);
                        if(view2 != null && view2 != view1) {
                            return view2;
                        }
                    }
                    if(this.F(v1)) {
                        for(int v4 = this.a - 1; v4 >= 0; --v4) {
                            View view3 = this.b[v4].i(v2, v1);
                            if(view3 != null && view3 != view1) {
                                return view3;
                            }
                        }
                    }
                    else {
                        for(int v5 = 0; v5 < this.a; ++v5) {
                            View view4 = this.b[v5].i(v2, v1);
                            if(view4 != null && view4 != view1) {
                                return view4;
                            }
                        }
                    }
                    boolean z1 = !this.h == (v1 == -1 ? 1 : 0);
                    if(!z) {
                        View view5 = this.findViewByPosition((z1 ? w00.e() : w00.f()));
                        if(view5 != null && view5 != view1) {
                            return view5;
                        }
                    }
                    if(this.F(v1)) {
                        for(int v6 = this.a - 1; v6 >= 0; --v6) {
                            if(v6 != w00.e) {
                                View view6 = this.findViewByPosition((z1 ? this.b[v6].e() : this.b[v6].f()));
                                if(view6 != null && view6 != view1) {
                                    return view6;
                                }
                            }
                        }
                        return null;
                    }
                    for(int v3 = 0; v3 < this.a; ++v3) {
                        View view7 = this.findViewByPosition((z1 ? this.b[v3].e() : this.b[v3].f()));
                        if(view7 != null && view7 != view1) {
                            return view7;
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent0) {
        super.onInitializeAccessibilityEvent(accessibilityEvent0);
        if(this.getChildCount() > 0) {
            View view0 = this.u(false);
            View view1 = this.t(false);
            if(view0 != null && view1 != null) {
                int v = this.getPosition(view0);
                int v1 = this.getPosition(view1);
                if(v < v1) {
                    accessibilityEvent0.setFromIndex(v);
                    accessibilityEvent0.setToIndex(v1);
                    return;
                }
                accessibilityEvent0.setFromIndex(v1);
                accessibilityEvent0.setToIndex(v);
            }
        }
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onInitializeAccessibilityNodeInfo(D0 d00, K0 k00, d2.d d0) {
        super.onInitializeAccessibilityNodeInfo(d00, k00, d0);
        d0.l("androidx.recyclerview.widget.StaggeredGridLayoutManager");
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onInitializeAccessibilityNodeInfoForItem(D0 d00, K0 k00, View view0, d2.d d0) {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        if(!(viewGroup$LayoutParams0 instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view0, d0);
            return;
        }
        int v = -1;
        int v1 = 1;
        if(this.e == 0) {
            W0 w00 = ((LayoutParams)viewGroup$LayoutParams0).e;
            if(w00 != null) {
                v = w00.e;
            }
            if(((LayoutParams)viewGroup$LayoutParams0).f) {
                v1 = this.a;
            }
            d0.n(f.c(v, v1, -1, -1, false, false));
            return;
        }
        W0 w01 = ((LayoutParams)viewGroup$LayoutParams0).e;
        if(w01 != null) {
            v = w01.e;
        }
        if(((LayoutParams)viewGroup$LayoutParams0).f) {
            v1 = this.a;
        }
        d0.n(f.c(-1, -1, v, v1, false, false));
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onItemsAdded(RecyclerView recyclerView0, int v, int v1) {
        this.B(v, v1, 1);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onItemsChanged(RecyclerView recyclerView0) {
        this.m.b();
        this.requestLayout();
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onItemsMoved(RecyclerView recyclerView0, int v, int v1, int v2) {
        this.B(v, v1, 8);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onItemsRemoved(RecyclerView recyclerView0, int v, int v1) {
        this.B(v, v1, 2);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onItemsUpdated(RecyclerView recyclerView0, int v, int v1, Object object0) {
        this.B(v, v1, 4);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onLayoutChildren(D0 d00, K0 k00) {
        this.E(d00, k00, true);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onLayoutCompleted(K0 k00) {
        this.k = -1;
        this.l = 0x80000000;
        this.w = null;
        this.E.a();
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        if(parcelable0 instanceof SavedState) {
            this.w = (SavedState)parcelable0;
            if(this.k != -1) {
                ((SavedState)parcelable0).a = -1;
                ((SavedState)parcelable0).b = -1;
                ((SavedState)parcelable0).d = null;
                ((SavedState)parcelable0).c = 0;
                ((SavedState)parcelable0).e = 0;
                ((SavedState)parcelable0).f = null;
                ((SavedState)parcelable0).g = null;
            }
            this.requestLayout();
        }
    }

    @Override  // androidx.recyclerview.widget.w0
    public final Parcelable onSaveInstanceState() {
        int v2;
        SavedState staggeredGridLayoutManager$SavedState0 = this.w;
        if(staggeredGridLayoutManager$SavedState0 != null) {
            Parcelable parcelable0 = new SavedState();  // 初始化器: Ljava/lang/Object;-><init>()V
            parcelable0.c = staggeredGridLayoutManager$SavedState0.c;
            parcelable0.a = staggeredGridLayoutManager$SavedState0.a;
            parcelable0.b = staggeredGridLayoutManager$SavedState0.b;
            parcelable0.d = staggeredGridLayoutManager$SavedState0.d;
            parcelable0.e = staggeredGridLayoutManager$SavedState0.e;
            parcelable0.f = staggeredGridLayoutManager$SavedState0.f;
            parcelable0.h = staggeredGridLayoutManager$SavedState0.h;
            parcelable0.i = staggeredGridLayoutManager$SavedState0.i;
            parcelable0.j = staggeredGridLayoutManager$SavedState0.j;
            parcelable0.g = staggeredGridLayoutManager$SavedState0.g;
            return parcelable0;
        }
        Parcelable parcelable1 = new SavedState();  // 初始化器: Ljava/lang/Object;-><init>()V
        parcelable1.h = this.h;
        parcelable1.i = this.o;
        parcelable1.j = this.r;
        U0 u00 = this.m;
        if(u00 == null) {
            parcelable1.e = 0;
        }
        else {
            int[] arr_v = u00.a;
            if(arr_v == null) {
                parcelable1.e = 0;
            }
            else {
                parcelable1.f = arr_v;
                parcelable1.e = arr_v.length;
                parcelable1.g = u00.b;
            }
        }
        int v1 = -1;
        if(this.getChildCount() > 0) {
            parcelable1.a = this.o ? this.y() : this.x();
            View view0 = this.i ? this.t(true) : this.u(true);
            if(view0 != null) {
                v1 = this.getPosition(view0);
            }
            parcelable1.b = v1;
            parcelable1.c = this.a;
            parcelable1.d = new int[this.a];
            for(int v = 0; v < this.a; ++v) {
                if(this.o) {
                    v2 = this.b[v].h(0x80000000);
                    if(v2 != 0x80000000) {
                        v2 -= this.c.g();
                    }
                }
                else {
                    v2 = this.b[v].j(0x80000000);
                    if(v2 != 0x80000000) {
                        v2 -= this.c.k();
                    }
                }
                parcelable1.d[v] = v2;
            }
            return parcelable1;
        }
        parcelable1.a = -1;
        parcelable1.b = -1;
        parcelable1.c = 0;
        return parcelable1;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void onScrollStateChanged(int v) {
        if(v == 0) {
            this.q();
        }
    }

    public final boolean q() {
        int v1;
        int v;
        if(this.getChildCount() != 0 && this.n != 0 && this.isAttachedToWindow()) {
            if(this.i) {
                v = this.y();
                v1 = this.x();
            }
            else {
                v = this.x();
                v1 = this.y();
            }
            U0 u00 = this.m;
            if(v == 0 && this.C() != null) {
                u00.b();
                this.requestSimpleAnimationsInNextLayout();
                this.requestLayout();
                return true;
            }
            if(this.G) {
                int v2 = this.i ? -1 : 1;
                StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0 = u00.e(v, v1 + 1, v2);
                if(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0 == null) {
                    this.G = false;
                    u00.d(v1 + 1);
                    return false;
                }
                StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem1 = u00.e(v, staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0.a, -v2);
                if(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem1 == null) {
                    u00.d(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0.a);
                }
                else {
                    u00.d(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem1.a + 1);
                }
                this.requestSimpleAnimationsInNextLayout();
                this.requestLayout();
                return true;
            }
        }
        return false;
    }

    public final int r(K0 k00) {
        if(this.getChildCount() == 0) {
            return 0;
        }
        View view0 = this.u(!this.I);
        View view1 = this.t(!this.I);
        return d.c(k00, this.c, view0, view1, this, this.I, this.i);
    }

    // This method was un-flattened
    public final int s(D0 d00, T t0, K0 k00) {
        int v35;
        int v32;
        int v31;
        int v22;
        int v21;
        int v16;
        int v7;
        int v6;
        int v5;
        W0 w00;
        int v;
        this.j.set(0, this.a, true);
        T t1 = this.g;
        if(!t1.i) {
            v = t0.e == 1 ? t0.g + t0.b : t0.f - t0.b;
        }
        else if(t0.e == 1) {
            v = 0x7FFFFFFF;
        }
        else {
            v = 0x80000000;
        }
        this.M(t0.e, v);
        int v1 = this.i ? this.c.g() : this.c.k();
        boolean z = false;
        while(t0.c >= 0 && t0.c < k00.b() && (t1.i || !this.j.isEmpty())) {
            View view0 = d00.k(t0.c, 0x7FFFFFFFFFFFFFFFL).itemView;
            t0.c += t0.d;
            LayoutParams staggeredGridLayoutManager$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
            int v2 = staggeredGridLayoutManager$LayoutParams0.a.getLayoutPosition();
            U0 u00 = this.m;
            int v3 = u00.a == null || v2 >= u00.a.length ? -1 : u00.a[v2];
            int v4 = v3 == -1 ? 1 : 0;
            if(v4 == 0) {
                w00 = this.b[v3];
            }
            else {
                if(staggeredGridLayoutManager$LayoutParams0.f) {
                    w00 = this.b[0];
                }
                else {
                    if(this.F(t0.e)) {
                        v5 = this.a - 1;
                        v6 = -1;
                        v7 = -1;
                    }
                    else {
                        v6 = this.a;
                        v5 = 0;
                        v7 = 1;
                    }
                    W0 w01 = null;
                    if(t0.e == 1) {
                        int v8 = this.c.k();
                        int v9 = 0x7FFFFFFF;
                        while(v5 != v6) {
                            W0 w02 = this.b[v5];
                            int v10 = w02.h(v8);
                            if(v10 < v9) {
                                v9 = v10;
                                w01 = w02;
                            }
                            v5 += v7;
                        }
                    }
                    else {
                        int v11 = this.c.g();
                        int v12 = 0x80000000;
                        while(v5 != v6) {
                            W0 w03 = this.b[v5];
                            int v13 = w03.j(v11);
                            if(v13 > v12) {
                                v12 = v13;
                                w01 = w03;
                            }
                            v5 += v7;
                        }
                    }
                    w00 = w01;
                }
                u00.c(v2);
                u00.a[v2] = w00.e;
            }
            staggeredGridLayoutManager$LayoutParams0.e = w00;
            if(t0.e == 1) {
                this.addView(view0);
            }
            else {
                this.addView(view0, 0);
            }
            if(!staggeredGridLayoutManager$LayoutParams0.f) {
                v16 = v4;
                if(this.e == 1) {
                    int v18 = w0.getChildMeasureSpec(this.f, this.getWidthMode(), 0, staggeredGridLayoutManager$LayoutParams0.width, false);
                    int v19 = this.getPaddingTop();
                    this.D(view0, v18, w0.getChildMeasureSpec(this.getHeight(), this.getHeightMode(), this.getPaddingBottom() + v19, staggeredGridLayoutManager$LayoutParams0.height, true));
                }
                else {
                    int v20 = this.getPaddingLeft();
                    this.D(view0, w0.getChildMeasureSpec(this.getWidth(), this.getWidthMode(), this.getPaddingRight() + v20, staggeredGridLayoutManager$LayoutParams0.width, true), w0.getChildMeasureSpec(this.f, this.getHeightMode(), 0, staggeredGridLayoutManager$LayoutParams0.height, false));
                }
            }
            else if(this.e == 1) {
                int v14 = this.B;
                int v15 = this.getPaddingTop();
                v16 = v4;
                this.D(view0, v14, w0.getChildMeasureSpec(this.getHeight(), this.getHeightMode(), this.getPaddingBottom() + v15, staggeredGridLayoutManager$LayoutParams0.height, true));
            }
            else {
                v16 = v4;
                int v17 = this.getPaddingLeft();
                this.D(view0, w0.getChildMeasureSpec(this.getWidth(), this.getWidthMode(), this.getPaddingRight() + v17, staggeredGridLayoutManager$LayoutParams0.width, true), this.B);
            }
            if(t0.e == 1) {
                v21 = staggeredGridLayoutManager$LayoutParams0.f ? this.z(v1) : w00.h(v1);
                v22 = this.c.c(view0) + v21;
                if(v16 != 0 && staggeredGridLayoutManager$LayoutParams0.f) {
                    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0 = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();  // 初始化器: Ljava/lang/Object;-><init>()V
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0.c = new int[this.a];
                    for(int v23 = 0; v23 < this.a; ++v23) {
                        int[] arr_v = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0.c;
                        arr_v[v23] = v21 - this.b[v23].h(v21);
                    }
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0.b = -1;
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0.a = v2;
                    u00.a(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0);
                }
            }
            else {
                v22 = staggeredGridLayoutManager$LayoutParams0.f ? this.A(v1) : w00.j(v1);
                v21 = v22 - this.c.c(view0);
                if(v16 != 0 && staggeredGridLayoutManager$LayoutParams0.f) {
                    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem1 = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();  // 初始化器: Ljava/lang/Object;-><init>()V
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem1.c = new int[this.a];
                    for(int v24 = 0; v24 < this.a; ++v24) {
                        int[] arr_v1 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem1.c;
                        arr_v1[v24] = this.b[v24].j(v22) - v22;
                    }
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem1.b = 1;
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem1.a = v2;
                    u00.a(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem1);
                }
            }
            if(staggeredGridLayoutManager$LayoutParams0.f && t0.d == -1) {
                if(v16 == 0) {
                    if(t0.e == 1) {
                        int v25 = this.b[0].h(0x80000000);
                        int v26 = 1;
                        while(v26 < this.a) {
                            if(this.b[v26].h(0x80000000) != v25) {
                                goto label_132;
                            }
                            ++v26;
                        }
                        goto label_138;
                    }
                    else {
                        int v27 = this.b[0].j(0x80000000);
                        int v28 = 1;
                        while(true) {
                            if(v28 >= this.a) {
                                goto label_138;
                            }
                            if(this.b[v28].j(0x80000000) != v27) {
                                break;
                            }
                            ++v28;
                        }
                    }
                label_132:
                    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2 = u00.f(v2);
                    if(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2 != null) {
                        staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2.d = true;
                    }
                }
                this.G = true;
            }
        label_138:
            if(t0.e == 1) {
                if(staggeredGridLayoutManager$LayoutParams0.f) {
                    for(int v29 = this.a - 1; v29 >= 0; --v29) {
                        this.b[v29].a(view0);
                    }
                }
                else {
                    staggeredGridLayoutManager$LayoutParams0.e.a(view0);
                }
            }
            else if(staggeredGridLayoutManager$LayoutParams0.f) {
                for(int v30 = this.a - 1; v30 >= 0; --v30) {
                    this.b[v30].m(view0);
                }
            }
            else {
                staggeredGridLayoutManager$LayoutParams0.e.m(view0);
            }
            if(!this.isLayoutRTL() || this.e != 1) {
                if(staggeredGridLayoutManager$LayoutParams0.f) {
                    v32 = this.d.k();
                }
                else {
                    int v33 = w00.e * this.f;
                    v32 = this.d.k() + v33;
                }
                v31 = this.d.c(view0) + v32;
            }
            else {
                v31 = staggeredGridLayoutManager$LayoutParams0.f ? this.d.g() : this.d.g() - (this.a - 1 - w00.e) * this.f;
                v32 = v31 - this.d.c(view0);
            }
            if(this.e == 1) {
                this.layoutDecoratedWithMargins(view0, v32, v21, v31, v22);
            }
            else {
                this.layoutDecoratedWithMargins(view0, v21, v32, v22, v31);
            }
            if(staggeredGridLayoutManager$LayoutParams0.f) {
                this.M(t1.e, v);
            }
            else {
                this.O(w00, t1.e, v);
            }
            this.H(d00, t1);
            if(t1.h && view0.hasFocusable()) {
                if(staggeredGridLayoutManager$LayoutParams0.f) {
                    this.j.clear();
                }
                else {
                    this.j.set(w00.e, false);
                }
            }
            z = true;
        }
        if(!z) {
            this.H(d00, t1);
        }
        if(t1.e == -1) {
            int v34 = this.A(this.c.k());
            v35 = this.c.k() - v34;
            return v35 <= 0 ? 0 : Math.min(t0.b, v35);
        }
        v35 = this.z(this.c.g()) - this.c.g();
        return v35 <= 0 ? 0 : Math.min(t0.b, v35);
    }

    public final int scrollBy(int v, D0 d00, K0 k00) {
        if(this.getChildCount() != 0 && v != 0) {
            this.G(v, k00);
            T t0 = this.g;
            int v1 = this.s(d00, t0, k00);
            if(t0.b >= v1) {
                v = v >= 0 ? v1 : -v1;
            }
            this.c.p(-v);
            this.o = this.i;
            t0.b = 0;
            this.H(d00, t0);
            return v;
        }
        return 0;
    }

    @Override  // androidx.recyclerview.widget.w0
    public final int scrollHorizontallyBy(int v, D0 d00, K0 k00) {
        return this.scrollBy(v, d00, k00);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void scrollToPosition(int v) {
        SavedState staggeredGridLayoutManager$SavedState0 = this.w;
        if(staggeredGridLayoutManager$SavedState0 != null && staggeredGridLayoutManager$SavedState0.a != v) {
            staggeredGridLayoutManager$SavedState0.d = null;
            staggeredGridLayoutManager$SavedState0.c = 0;
            staggeredGridLayoutManager$SavedState0.a = -1;
            staggeredGridLayoutManager$SavedState0.b = -1;
        }
        this.k = v;
        this.l = 0x80000000;
        this.requestLayout();
    }

    @Override  // androidx.recyclerview.widget.w0
    public final int scrollVerticallyBy(int v, D0 d00, K0 k00) {
        return this.scrollBy(v, d00, k00);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void setMeasuredDimension(Rect rect0, int v, int v1) {
        int v7;
        int v6;
        int v2 = this.getPaddingLeft();
        int v3 = this.getPaddingRight() + v2;
        int v4 = this.getPaddingTop();
        int v5 = this.getPaddingBottom() + v4;
        if(this.e == 1) {
            v6 = w0.chooseSize(v1, rect0.height() + v5, this.getMinimumHeight());
            v7 = w0.chooseSize(v, this.f * this.a + v3, this.getMinimumWidth());
        }
        else {
            v7 = w0.chooseSize(v, rect0.width() + v3, this.getMinimumWidth());
            v6 = w0.chooseSize(v1, this.f * this.a + v5, this.getMinimumHeight());
        }
        this.setMeasuredDimension(v7, v6);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final void smoothScrollToPosition(RecyclerView recyclerView0, K0 k00, int v) {
        LinearSmoothScroller linearSmoothScroller0 = new LinearSmoothScroller(recyclerView0.getContext());
        linearSmoothScroller0.setTargetPosition(v);
        this.startSmoothScroll(linearSmoothScroller0);
    }

    @Override  // androidx.recyclerview.widget.w0
    public final boolean supportsPredictiveItemAnimations() {
        return this.w == null;
    }

    public final View t(boolean z) {
        int v = this.c.k();
        int v1 = this.c.g();
        int v2 = this.getChildCount() - 1;
        View view0 = null;
        while(v2 >= 0) {
            View view1 = this.getChildAt(v2);
            int v3 = this.c.e(view1);
            int v4 = this.c.b(view1);
            if(v4 > v && v3 < v1) {
                if(v4 <= v1 || !z) {
                    return view1;
                }
                if(view0 == null) {
                    view0 = view1;
                }
            }
            --v2;
        }
        return view0;
    }

    public final View u(boolean z) {
        int v = this.c.k();
        int v1 = this.c.g();
        int v2 = this.getChildCount();
        View view0 = null;
        for(int v3 = 0; v3 < v2; ++v3) {
            View view1 = this.getChildAt(v3);
            int v4 = this.c.e(view1);
            if(this.c.b(view1) > v && v4 < v1) {
                if(v4 >= v || !z) {
                    return view1;
                }
                if(view0 == null) {
                    view0 = view1;
                }
            }
        }
        return view0;
    }

    public final void v(D0 d00, K0 k00, boolean z) {
        int v = this.z(0x80000000);
        if(v != 0x80000000) {
            int v1 = this.c.g() - v;
            if(v1 > 0) {
                int v2 = v1 - -this.scrollBy(-v1, d00, k00);
                if(z && v2 > 0) {
                    this.c.p(v2);
                }
            }
        }
    }

    public final void w(D0 d00, K0 k00, boolean z) {
        int v = this.A(0x7FFFFFFF);
        if(v != 0x7FFFFFFF) {
            int v1 = v - this.c.k();
            if(v1 > 0) {
                int v2 = v1 - this.scrollBy(v1, d00, k00);
                if(z && v2 > 0) {
                    this.c.p(-v2);
                }
            }
        }
    }

    public final int x() {
        return this.getChildCount() == 0 ? 0 : this.getPosition(this.getChildAt(0));
    }

    public final int y() {
        int v = this.getChildCount();
        return v == 0 ? 0 : this.getPosition(this.getChildAt(v - 1));
    }

    public final int z(int v) {
        int v1 = this.b[0].h(v);
        for(int v2 = 1; v2 < this.a; ++v2) {
            int v3 = this.b[v2].h(v);
            if(v3 > v1) {
                v1 = v3;
            }
        }
        return v1;
    }
}

