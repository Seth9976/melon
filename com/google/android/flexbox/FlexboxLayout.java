package com.google.android.flexbox;

import P.z;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class FlexboxLayout extends ViewGroup implements a {
    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator CREATOR;
        public int a;
        public float b;
        public float c;
        public int d;
        public float e;
        public int f;
        public int g;
        public int h;
        public int i;
        public boolean j;

        static {
            LayoutParams.CREATOR = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public LayoutParams(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
            this.a = 1;
            this.b = 0.0f;
            this.c = 1.0f;
            this.d = -1;
            this.e = -1.0f;
            this.h = 0xFFFFFF;
            this.i = 0xFFFFFF;
            TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, j.b);
            this.a = typedArray0.getInt(8, 1);
            this.b = typedArray0.getFloat(2, 0.0f);
            this.c = typedArray0.getFloat(3, 1.0f);
            this.d = typedArray0.getInt(0, -1);
            this.e = typedArray0.getFraction(1, 1, 1, -1.0f);
            this.f = typedArray0.getDimensionPixelSize(7, 0);
            this.g = typedArray0.getDimensionPixelSize(6, 0);
            this.h = typedArray0.getDimensionPixelSize(5, 0xFFFFFF);
            this.i = typedArray0.getDimensionPixelSize(4, 0xFFFFFF);
            this.j = typedArray0.getBoolean(9, false);
            typedArray0.recycle();
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final float A() {
            return this.e;
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final boolean C() {
            return this.j;
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final int E() {
            return this.h;
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
            return this.g;
        }

        @Override  // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final int g0() {
            return this.i;
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final int getHeight() {
            return this.height;
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final int getOrder() {
            return this.a;
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final int getWidth() {
            return this.width;
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final int o() {
            return this.d;
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final float p() {
            return this.c;
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final int q() {
            return this.f;
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final int r() {
            return this.topMargin;
        }

        @Override  // com.google.android.flexbox.FlexItem
        public final float s() {
            return this.b;
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(Parcel parcel0, int v) {
            parcel0.writeInt(this.a);
            parcel0.writeFloat(this.b);
            parcel0.writeFloat(this.c);
            parcel0.writeInt(this.d);
            parcel0.writeFloat(this.e);
            parcel0.writeInt(this.f);
            parcel0.writeInt(this.g);
            parcel0.writeInt(this.h);
            parcel0.writeInt(this.i);
            parcel0.writeByte(((byte)this.j));
            parcel0.writeInt(this.bottomMargin);
            parcel0.writeInt(this.leftMargin);
            parcel0.writeInt(this.rightMargin);
            parcel0.writeInt(this.topMargin);
            parcel0.writeInt(this.height);
            parcel0.writeInt(this.width);
        }
    }

    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public Drawable g;
    public Drawable h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int[] m;
    public SparseIntArray n;
    public final d o;
    public List r;
    public final z w;

    public FlexboxLayout(Context context0) {
        this(context0, null);
    }

    public FlexboxLayout(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public FlexboxLayout(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.f = -1;
        this.o = new d(this);
        this.r = new ArrayList();
        this.w = new z();  // 初始化器: Ljava/lang/Object;-><init>()V
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, j.a, v, 0);
        this.a = typedArray0.getInt(5, 0);
        this.b = typedArray0.getInt(6, 0);
        this.c = typedArray0.getInt(7, 0);
        this.d = typedArray0.getInt(1, 4);
        this.e = typedArray0.getInt(0, 5);
        this.f = typedArray0.getInt(8, -1);
        Drawable drawable0 = typedArray0.getDrawable(2);
        if(drawable0 != null) {
            this.setDividerDrawableHorizontal(drawable0);
            this.setDividerDrawableVertical(drawable0);
        }
        Drawable drawable1 = typedArray0.getDrawable(3);
        if(drawable1 != null) {
            this.setDividerDrawableHorizontal(drawable1);
        }
        Drawable drawable2 = typedArray0.getDrawable(4);
        if(drawable2 != null) {
            this.setDividerDrawableVertical(drawable2);
        }
        int v1 = typedArray0.getInt(9, 0);
        if(v1 != 0) {
            this.j = v1;
            this.i = v1;
        }
        int v2 = typedArray0.getInt(11, 0);
        if(v2 != 0) {
            this.j = v2;
        }
        int v3 = typedArray0.getInt(10, 0);
        if(v3 != 0) {
            this.i = v3;
        }
        typedArray0.recycle();
    }

    @Override  // com.google.android.flexbox.a
    public final void a(View view0, int v, int v1, b b0) {
        if(this.p(v, v1)) {
            if(this.m()) {
                b0.e += this.l;
                b0.f += this.l;
                return;
            }
            b0.e += this.k;
            b0.f += this.k;
        }
    }

    @Override  // android.view.ViewGroup
    public final void addView(View view0, int v, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        if(this.n == null) {
            this.n = new SparseIntArray(this.getChildCount());
        }
        SparseIntArray sparseIntArray0 = this.n;
        a a0 = this.o.a;
        int v1 = a0.getFlexItemCount();
        ArrayList arrayList0 = this.o.f(v1);
        c c0 = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
        c0.b = view0 == null || !(viewGroup$LayoutParams0 instanceof FlexItem) ? 1 : ((FlexItem)viewGroup$LayoutParams0).getOrder();
        if(v == -1 || v == v1) {
            c0.a = v1;
        }
        else if(v < a0.getFlexItemCount()) {
            c0.a = v;
            for(int v2 = v; v2 < v1; ++v2) {
                c c1 = (c)arrayList0.get(v2);
                ++c1.a;
            }
        }
        else {
            c0.a = v1;
        }
        arrayList0.add(c0);
        this.m = d.r(v1 + 1, arrayList0, sparseIntArray0);
        super.addView(view0, v, viewGroup$LayoutParams0);
    }

    @Override  // com.google.android.flexbox.a
    public final int b(int v, int v1, int v2) {
        return ViewGroup.getChildMeasureSpec(v, v1, v2);
    }

    @Override  // com.google.android.flexbox.a
    public final View c(int v) {
        return this.getChildAt(v);
    }

    @Override  // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return viewGroup$LayoutParams0 instanceof LayoutParams;
    }

    @Override  // com.google.android.flexbox.a
    public final int d(int v, int v1, int v2) {
        return ViewGroup.getChildMeasureSpec(v, v1, v2);
    }

    @Override  // com.google.android.flexbox.a
    public final void e(View view0, int v) {
    }

    @Override  // com.google.android.flexbox.a
    public final int f(View view0) {
        return 0;
    }

    public final void g(Canvas canvas0, boolean z, boolean z1) {
        int v = this.getPaddingLeft();
        int v1 = this.getPaddingRight();
        int v2 = Math.max(0, this.getWidth() - v1 - v);
        int v3 = this.r.size();
        for(int v4 = 0; v4 < v3; ++v4) {
            b b0 = (b)this.r.get(v4);
            for(int v5 = 0; v5 < b0.h; ++v5) {
                int v6 = b0.o + v5;
                View view0 = this.o(v6);
                if(view0 != null && view0.getVisibility() != 8) {
                    LayoutParams flexboxLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                    if(this.p(v6, v5)) {
                        this.n(canvas0, (z ? view0.getRight() + flexboxLayout$LayoutParams0.rightMargin : view0.getLeft() - flexboxLayout$LayoutParams0.leftMargin - this.l), b0.b, b0.g);
                    }
                    if(v5 == b0.h - 1 && (this.j & 4) > 0) {
                        this.n(canvas0, (z ? view0.getLeft() - flexboxLayout$LayoutParams0.leftMargin - this.l : view0.getRight() + flexboxLayout$LayoutParams0.rightMargin), b0.b, b0.g);
                    }
                }
            }
            if(this.q(v4)) {
                this.l(canvas0, v, (z1 ? b0.d : b0.b - this.k), v2);
            }
            if(this.r(v4) && (this.i & 4) > 0) {
                this.l(canvas0, v, (z1 ? b0.b - this.k : b0.d), v2);
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return new LayoutParams(this.getContext(), attributeSet0);
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        if(viewGroup$LayoutParams0 instanceof LayoutParams) {
            ViewGroup.LayoutParams viewGroup$LayoutParams1 = new LayoutParams(((LayoutParams)viewGroup$LayoutParams0));  // 初始化器: Landroid/view/ViewGroup$MarginLayoutParams;-><init>(Landroid/view/ViewGroup$MarginLayoutParams;)V
            viewGroup$LayoutParams1.a = ((LayoutParams)viewGroup$LayoutParams0).a;
            viewGroup$LayoutParams1.b = ((LayoutParams)viewGroup$LayoutParams0).b;
            viewGroup$LayoutParams1.c = ((LayoutParams)viewGroup$LayoutParams0).c;
            viewGroup$LayoutParams1.d = ((LayoutParams)viewGroup$LayoutParams0).d;
            viewGroup$LayoutParams1.e = ((LayoutParams)viewGroup$LayoutParams0).e;
            viewGroup$LayoutParams1.f = ((LayoutParams)viewGroup$LayoutParams0).f;
            viewGroup$LayoutParams1.g = ((LayoutParams)viewGroup$LayoutParams0).g;
            viewGroup$LayoutParams1.h = ((LayoutParams)viewGroup$LayoutParams0).h;
            viewGroup$LayoutParams1.i = ((LayoutParams)viewGroup$LayoutParams0).i;
            viewGroup$LayoutParams1.j = ((LayoutParams)viewGroup$LayoutParams0).j;
            return viewGroup$LayoutParams1;
        }
        if(viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.LayoutParams viewGroup$LayoutParams2 = new LayoutParams(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0));  // 初始化器: Landroid/view/ViewGroup$MarginLayoutParams;-><init>(Landroid/view/ViewGroup$MarginLayoutParams;)V
            viewGroup$LayoutParams2.a = 1;
            viewGroup$LayoutParams2.b = 0.0f;
            viewGroup$LayoutParams2.c = 1.0f;
            viewGroup$LayoutParams2.d = -1;
            viewGroup$LayoutParams2.e = -1.0f;
            viewGroup$LayoutParams2.h = 0xFFFFFF;
            viewGroup$LayoutParams2.i = 0xFFFFFF;
            return viewGroup$LayoutParams2;
        }
        ViewGroup.LayoutParams viewGroup$LayoutParams3 = new LayoutParams(viewGroup$LayoutParams0);  // 初始化器: Landroid/view/ViewGroup$MarginLayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V
        viewGroup$LayoutParams3.a = 1;
        viewGroup$LayoutParams3.b = 0.0f;
        viewGroup$LayoutParams3.c = 1.0f;
        viewGroup$LayoutParams3.d = -1;
        viewGroup$LayoutParams3.e = -1.0f;
        viewGroup$LayoutParams3.h = 0xFFFFFF;
        viewGroup$LayoutParams3.i = 0xFFFFFF;
        return viewGroup$LayoutParams3;
    }

    @Override  // com.google.android.flexbox.a
    public int getAlignContent() {
        return this.e;
    }

    @Override  // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.d;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.g;
    }

    public Drawable getDividerDrawableVertical() {
        return this.h;
    }

    @Override  // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.a;
    }

    @Override  // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return this.getChildCount();
    }

    public List getFlexLines() {
        List list0 = new ArrayList(this.r.size());
        for(Object object0: this.r) {
            b b0 = (b)object0;
            if(b0.a() != 0) {
                ((ArrayList)list0).add(b0);
            }
        }
        return list0;
    }

    @Override  // com.google.android.flexbox.a
    public List getFlexLinesInternal() {
        return this.r;
    }

    @Override  // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.b;
    }

    public int getJustifyContent() {
        return this.c;
    }

    @Override  // com.google.android.flexbox.a
    public int getLargestMainSize() {
        int v = 0x80000000;
        for(Object object0: this.r) {
            v = Math.max(v, ((b)object0).e);
        }
        return v;
    }

    @Override  // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.f;
    }

    public int getShowDividerHorizontal() {
        return this.i;
    }

    public int getShowDividerVertical() {
        return this.j;
    }

    @Override  // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int v = this.r.size();
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            b b0 = (b)this.r.get(v1);
            if(this.q(v1)) {
                v2 += (this.m() ? this.k : this.l);
            }
            if(this.r(v1)) {
                v2 += (this.m() ? this.k : this.l);
            }
            v2 += b0.g;
        }
        return v2;
    }

    public final void h(Canvas canvas0, boolean z, boolean z1) {
        int v = this.getPaddingTop();
        int v1 = this.getPaddingBottom();
        int v2 = Math.max(0, this.getHeight() - v1 - v);
        int v3 = this.r.size();
        for(int v4 = 0; v4 < v3; ++v4) {
            b b0 = (b)this.r.get(v4);
            for(int v5 = 0; v5 < b0.h; ++v5) {
                int v6 = b0.o + v5;
                View view0 = this.o(v6);
                if(view0 != null && view0.getVisibility() != 8) {
                    LayoutParams flexboxLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                    if(this.p(v6, v5)) {
                        int v7 = z1 ? view0.getBottom() + flexboxLayout$LayoutParams0.bottomMargin : view0.getTop() - flexboxLayout$LayoutParams0.topMargin - this.k;
                        this.l(canvas0, b0.a, v7, b0.g);
                    }
                    if(v5 == b0.h - 1 && (this.i & 4) > 0) {
                        int v8 = z1 ? view0.getTop() - flexboxLayout$LayoutParams0.topMargin - this.k : view0.getBottom() + flexboxLayout$LayoutParams0.bottomMargin;
                        this.l(canvas0, b0.a, v8, b0.g);
                    }
                }
            }
            if(this.q(v4)) {
                this.n(canvas0, (z ? b0.c : b0.a - this.l), v, v2);
            }
            if(this.r(v4) && (this.j & 4) > 0) {
                this.n(canvas0, (z ? b0.a - this.l : b0.c), v, v2);
            }
        }
    }

    @Override  // com.google.android.flexbox.a
    public final void i(b b0) {
        if(this.m()) {
            if((this.j & 4) > 0) {
                b0.e += this.l;
                b0.f += this.l;
            }
        }
        else if((this.i & 4) > 0) {
            b0.e += this.k;
            b0.f += this.k;
        }
    }

    @Override  // com.google.android.flexbox.a
    public final View j(int v) {
        return this.o(v);
    }

    @Override  // com.google.android.flexbox.a
    public final int k(View view0, int v, int v1) {
        int v2 = 0;
        if(this.m()) {
            if(this.p(v, v1)) {
                v2 = this.l;
            }
            return (this.j & 4) <= 0 ? v2 : v2 + this.l;
        }
        if(this.p(v, v1)) {
            v2 = this.k;
        }
        return (this.i & 4) <= 0 ? v2 : v2 + this.k;
    }

    public final void l(Canvas canvas0, int v, int v1, int v2) {
        Drawable drawable0 = this.g;
        if(drawable0 == null) {
            return;
        }
        drawable0.setBounds(v, v1, v2 + v, this.k + v1);
        this.g.draw(canvas0);
    }

    @Override  // com.google.android.flexbox.a
    public final boolean m() {
        return this.a == 0 || this.a == 1;
    }

    public final void n(Canvas canvas0, int v, int v1, int v2) {
        Drawable drawable0 = this.h;
        if(drawable0 == null) {
            return;
        }
        drawable0.setBounds(v, v1, this.l + v, v2 + v1);
        this.h.draw(canvas0);
    }

    public final View o(int v) {
        if(v >= 0) {
            return v >= this.m.length ? null : this.getChildAt(this.m[v]);
        }
        return null;
    }

    @Override  // android.view.View
    public final void onDraw(Canvas canvas0) {
        if((this.h != null || this.g != null) && (this.i != 0 || this.j != 0)) {
            int v = this.getLayoutDirection();
            int v1 = this.a;
            boolean z = false;
            int v2 = 1;
            switch(v1) {
                case 0: {
                    if(this.b == 2) {
                        z = true;
                    }
                    this.g(canvas0, v == 1, z);
                    return;
                }
                case 1: {
                    if(this.b == 2) {
                        z = true;
                    }
                    this.g(canvas0, v != 1, z);
                    return;
                }
                case 2: {
                    if(v != 1) {
                        v2 = 0;
                    }
                    if(this.b == 2) {
                        v2 ^= 1;
                    }
                    this.h(canvas0, ((boolean)v2), false);
                    return;
                label_21:
                    if(v1 == 3) {
                        if(v == 1) {
                            z = true;
                        }
                        if(this.b == 2) {
                            z = !z;
                        }
                        this.h(canvas0, z, true);
                        return;
                    }
                    break;
                }
                default: {
                    goto label_21;
                }
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        int v4 = this.getLayoutDirection();
        int v5 = this.a;
        int v6 = 0;
        switch(v5) {
            case 0: {
                this.s(v, v1, v2, v3, v4 == 1);
                return;
            }
            case 1: {
                this.s(v, v1, v2, v3, v4 != 1);
                return;
            }
            default: {
                int v7 = 0;
                switch(v5) {
                    case 2: {
                        if(v4 == 1) {
                            v7 = 1;
                        }
                        if(this.b == 2) {
                            v7 ^= 1;
                        }
                        this.t(v, v1, v2, v3, ((boolean)v7), false);
                        return;
                    }
                    case 3: {
                        if(v4 == 1) {
                            v6 = 1;
                        }
                        if(this.b == 2) {
                            v6 ^= 1;
                        }
                        this.t(v, v1, v2, v3, ((boolean)v6), true);
                        return;
                    }
                    default: {
                        throw new IllegalStateException("Invalid flex direction is set: " + this.a);
                    }
                }
            }
        }
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        if(this.n == null) {
            this.n = new SparseIntArray(this.getChildCount());
        }
        SparseIntArray sparseIntArray0 = this.n;
        d d0 = this.o;
        a a0 = d0.a;
        int v2 = a0.getFlexItemCount();
        if(sparseIntArray0.size() == v2) {
            int v3 = 0;
            while(v3 < v2) {
                View view0 = a0.c(v3);
                if(view0 != null && ((FlexItem)view0.getLayoutParams()).getOrder() != sparseIntArray0.get(v3)) {
                    goto label_14;
                }
                ++v3;
            }
        }
        else {
        label_14:
            SparseIntArray sparseIntArray1 = this.n;
            int v4 = d0.a.getFlexItemCount();
            this.m = d.r(v4, d0.f(v4), sparseIntArray1);
        }
        int v5 = this.a;
        z z0 = this.w;
        if(v5 != 0) {
            switch(v5) {
                case 1: {
                    break;
                }
                case 2: 
                case 3: {
                    this.r.clear();
                    z0.b = null;
                    z0.a = 0;
                    this.o.b(this.w, v1, v, 0x7FFFFFFF, 0, -1, null);
                    this.r = z0.b;
                    d0.h(v, v1, 0);
                    int v6 = this.getPaddingLeft();
                    d0.g(v, v1, this.getPaddingRight() + v6);
                    d0.u(0);
                    this.u(this.a, v, v1, z0.a);
                    return;
                }
                default: {
                    throw new IllegalStateException("Invalid value for the flex direction is set: " + this.a);
                }
            }
        }
        this.r.clear();
        z0.b = null;
        z0.a = 0;
        this.o.b(this.w, v, v1, 0x7FFFFFFF, 0, -1, null);
        this.r = z0.b;
        d0.h(v, v1, 0);
        if(this.d == 3) {
            for(Object object0: this.r) {
                b b0 = (b)object0;
                int v7 = 0x80000000;
                for(int v8 = 0; v8 < b0.h; ++v8) {
                    View view1 = this.o(b0.o + v8);
                    if(view1 != null && view1.getVisibility() != 8) {
                        LayoutParams flexboxLayout$LayoutParams0 = (LayoutParams)view1.getLayoutParams();
                        if(this.b == 2) {
                            int v10 = b0.l;
                            int v11 = view1.getMeasuredHeight();
                            int v12 = Math.max(view1.getBaseline() + (v10 - v11), flexboxLayout$LayoutParams0.bottomMargin);
                            v7 = Math.max(v7, view1.getMeasuredHeight() + flexboxLayout$LayoutParams0.topMargin + v12);
                        }
                        else {
                            int v9 = Math.max(b0.l - view1.getBaseline(), flexboxLayout$LayoutParams0.topMargin);
                            v7 = Math.max(v7, view1.getMeasuredHeight() + v9 + flexboxLayout$LayoutParams0.bottomMargin);
                        }
                    }
                }
                b0.g = v7;
            }
        }
        int v13 = this.getPaddingTop();
        d0.g(v, v1, this.getPaddingBottom() + v13);
        d0.u(0);
        this.u(this.a, v, v1, z0.a);
    }

    public final boolean p(int v, int v1) {
        for(int v2 = 1; v2 <= v1; ++v2) {
            View view0 = this.o(v - v2);
            if(view0 != null && view0.getVisibility() != 8) {
                return this.m() ? (this.j & 2) != 0 : (this.i & 2) != 0;
            }
        }
        return this.m() ? (this.j & 1) != 0 : (this.i & 1) != 0;
    }

    public final boolean q(int v) {
        if(v >= 0 && v < this.r.size()) {
            for(int v1 = 0; v1 < v; ++v1) {
                if(((b)this.r.get(v1)).a() > 0) {
                    return this.m() ? (this.i & 2) != 0 : (this.j & 2) != 0;
                }
            }
            return this.m() ? (this.i & 1) != 0 : (this.j & 1) != 0;
        }
        return false;
    }

    public final boolean r(int v) {
        if(v >= 0 && v < this.r.size()) {
            for(int v1 = v + 1; v1 < this.r.size(); ++v1) {
                if(((b)this.r.get(v1)).a() > 0) {
                    return false;
                }
            }
            return this.m() ? (this.i & 4) != 0 : (this.j & 4) != 0;
        }
        return false;
    }

    public final void s(int v, int v1, int v2, int v3, boolean z) {
        int v19;
        int v18;
        b b1;
        View view1;
        int v20;
        float f2;
        float f1;
        float f;
        int v4 = this.getPaddingLeft();
        int v5 = this.getPaddingRight();
        int v6 = v2 - v;
        int v7 = v3 - v1 - this.getPaddingBottom();
        int v8 = this.getPaddingTop();
        int v9 = this.r.size();
        int v10 = 0;
        while(v10 < v9) {
            b b0 = (b)this.r.get(v10);
            if(this.q(v10)) {
                v7 -= this.k;
                v8 += this.k;
            }
            int v11 = v7;
            int v12 = this.c;
            switch(v12) {
                case 0: {
                    f1 = (float)v4;
                    f2 = (float)(v6 - v5);
                    break;
                }
                case 1: {
                    f2 = (float)(b0.e - v4);
                    f1 = (float)(v6 - b0.e + v5);
                    break;
                }
                default: {
                    if(v12 == 2) {
                        f1 = ((float)v4) + ((float)(v6 - b0.e)) / 2.0f;
                        f2 = ((float)(v6 - v5)) - ((float)(v6 - b0.e)) / 2.0f;
                        break;
                    }
                    else {
                        switch(v12) {
                            case 3: {
                                f1 = (float)v4;
                                int v14 = b0.a();
                                f = ((float)(v6 - b0.e)) / (v14 == 1 ? 1.0f : ((float)(v14 - 1)));
                                f2 = (float)(v6 - v5);
                                goto label_44;
                            }
                            case 4: {
                                int v15 = b0.a();
                                float f3 = v15 == 0 ? 0.0f : ((float)(v6 - b0.e)) / ((float)v15);
                                f1 = ((float)v4) + f3 / 2.0f;
                                f = f3;
                                f2 = ((float)(v6 - v5)) - f3 / 2.0f;
                                goto label_44;
                            }
                            default: {
                                if(v12 != 5) {
                                    throw new IllegalStateException("Invalid justifyContent is set: " + this.c);
                                }
                                int v13 = b0.a();
                                f = v13 == 0 ? 0.0f : ((float)(v6 - b0.e)) / ((float)(v13 + 1));
                                f1 = ((float)v4) + f;
                                f2 = ((float)(v6 - v5)) - f;
                                goto label_44;
                            }
                        }
                    }
                    f1 = (float)v4;
                    f2 = (float)(v6 - v5);
                    break;
                }
            }
            f = 0.0f;
        label_44:
            float f4 = Math.max(f, 0.0f);
            int v16 = 0;
            while(v16 < b0.h) {
                int v17 = b0.o + v16;
                View view0 = this.o(v17);
                if(view0 != null && view0.getVisibility() != 8) {
                    LayoutParams flexboxLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                    float f5 = f1 + ((float)flexboxLayout$LayoutParams0.leftMargin);
                    float f6 = f2 - ((float)flexboxLayout$LayoutParams0.rightMargin);
                    if(this.p(v17, v16)) {
                        f5 += (float)this.l;
                        f6 -= (float)this.l;
                        v20 = this.l;
                    }
                    else {
                        v20 = 0;
                    }
                    int v21 = v16 != b0.h - 1 || (this.j & 4) <= 0 ? 0 : this.l;
                    if(this.b == 2) {
                        if(z) {
                            int v22 = view0.getMeasuredWidth();
                            int v23 = view0.getMeasuredHeight();
                            v18 = v16;
                            view1 = view0;
                            this.o.o(view1, b0, Math.round(f6) - v22, v11 - v23, Math.round(f6), v11);
                        }
                        else {
                            v18 = v16;
                            view1 = view0;
                            int v24 = view1.getMeasuredHeight();
                            int v25 = view1.getMeasuredWidth();
                            this.o.o(view1, b0, Math.round(f5), v11 - v24, v25 + Math.round(f5), v11);
                        }
                        v19 = v11;
                    }
                    else {
                        v18 = v16;
                        view1 = view0;
                        v19 = v11;
                        if(z) {
                            int v26 = view1.getMeasuredWidth();
                            int v27 = view1.getMeasuredHeight();
                            this.o.o(view1, b0, Math.round(f6) - v26, v8, Math.round(f6), v27 + v8);
                        }
                        else {
                            int v28 = view1.getMeasuredWidth();
                            int v29 = view1.getMeasuredHeight();
                            this.o.o(view1, b0, Math.round(f5), v8, v28 + Math.round(f5), v29 + v8);
                        }
                    }
                    f1 = f5 + (((float)view1.getMeasuredWidth()) + f4 + ((float)flexboxLayout$LayoutParams0.rightMargin));
                    float f7 = f6 - (((float)view1.getMeasuredWidth()) + f4 + ((float)flexboxLayout$LayoutParams0.leftMargin));
                    if(z) {
                        b1 = b0;
                        b1.b(view1, v21, 0, v20, 0);
                    }
                    else {
                        b1 = b0;
                        b1.b(view1, v20, 0, v21, 0);
                    }
                    b0 = b1;
                    f2 = f7;
                }
                else {
                    v18 = v16;
                    v19 = v11;
                }
                v16 = v18 + 1;
                v11 = v19;
            }
            v8 += b0.g;
            v7 = v11 - b0.g;
            ++v10;
        }
    }

    public void setAlignContent(int v) {
        if(this.e != v) {
            this.e = v;
            this.requestLayout();
        }
    }

    public void setAlignItems(int v) {
        if(this.d != v) {
            this.d = v;
            this.requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable0) {
        this.setDividerDrawableHorizontal(drawable0);
        this.setDividerDrawableVertical(drawable0);
    }

    public void setDividerDrawableHorizontal(Drawable drawable0) {
        if(drawable0 == this.g) {
            return;
        }
        this.g = drawable0;
        this.k = drawable0 == null ? 0 : drawable0.getIntrinsicHeight();
        if(this.g != null || this.h != null) {
            this.setWillNotDraw(false);
        }
        else {
            this.setWillNotDraw(true);
        }
        this.requestLayout();
    }

    public void setDividerDrawableVertical(Drawable drawable0) {
        if(drawable0 == this.h) {
            return;
        }
        this.h = drawable0;
        this.l = drawable0 == null ? 0 : drawable0.getIntrinsicWidth();
        if(this.g != null || this.h != null) {
            this.setWillNotDraw(false);
        }
        else {
            this.setWillNotDraw(true);
        }
        this.requestLayout();
    }

    public void setFlexDirection(int v) {
        if(this.a != v) {
            this.a = v;
            this.requestLayout();
        }
    }

    @Override  // com.google.android.flexbox.a
    public void setFlexLines(List list0) {
        this.r = list0;
    }

    public void setFlexWrap(int v) {
        if(this.b != v) {
            this.b = v;
            this.requestLayout();
        }
    }

    public void setJustifyContent(int v) {
        if(this.c != v) {
            this.c = v;
            this.requestLayout();
        }
    }

    public void setMaxLine(int v) {
        if(this.f != v) {
            this.f = v;
            this.requestLayout();
        }
    }

    public void setShowDivider(int v) {
        this.setShowDividerVertical(v);
        this.setShowDividerHorizontal(v);
    }

    public void setShowDividerHorizontal(int v) {
        if(v != this.i) {
            this.i = v;
            this.requestLayout();
        }
    }

    public void setShowDividerVertical(int v) {
        if(v != this.j) {
            this.j = v;
            this.requestLayout();
        }
    }

    public final void t(int v, int v1, int v2, int v3, boolean z, boolean z1) {
        int v20;
        int v19;
        b b1;
        int v21;
        float f2;
        float f1;
        float f;
        int v4 = this.getPaddingTop();
        int v5 = this.getPaddingBottom();
        int v6 = this.getPaddingRight();
        int v7 = this.getPaddingLeft();
        int v8 = v3 - v1;
        int v9 = v2 - v - v6;
        int v10 = this.r.size();
        int v11 = 0;
        while(v11 < v10) {
            b b0 = (b)this.r.get(v11);
            if(this.q(v11)) {
                v7 += this.l;
                v9 -= this.l;
            }
            int v12 = v9;
            int v13 = this.c;
            switch(v13) {
                case 0: {
                    f1 = (float)v4;
                    f2 = (float)(v8 - v5);
                    break;
                }
                case 1: {
                    f2 = (float)(b0.e - v4);
                    f1 = (float)(v8 - b0.e + v5);
                    break;
                }
                default: {
                    if(v13 == 2) {
                        float f3 = ((float)(v8 - b0.e)) / 2.0f;
                        f1 = ((float)v4) + f3;
                        f2 = ((float)(v8 - v5)) - f3;
                        break;
                    }
                    else {
                        switch(v13) {
                            case 3: {
                                f1 = (float)v4;
                                int v15 = b0.a();
                                f = ((float)(v8 - b0.e)) / (v15 == 1 ? 1.0f : ((float)(v15 - 1)));
                                f2 = (float)(v8 - v5);
                                goto label_45;
                            }
                            case 4: {
                                int v16 = b0.a();
                                f = v16 == 0 ? 0.0f : ((float)(v8 - b0.e)) / ((float)v16);
                                f1 = ((float)v4) + f / 2.0f;
                                f2 = ((float)(v8 - v5)) - f / 2.0f;
                                goto label_45;
                            }
                            default: {
                                if(v13 != 5) {
                                    throw new IllegalStateException("Invalid justifyContent is set: " + this.c);
                                }
                                int v14 = b0.a();
                                f = v14 == 0 ? 0.0f : ((float)(v8 - b0.e)) / ((float)(v14 + 1));
                                f1 = ((float)v4) + f;
                                f2 = ((float)(v8 - v5)) - f;
                                goto label_45;
                            }
                        }
                    }
                    f1 = (float)v4;
                    f2 = (float)(v8 - v5);
                    break;
                }
            }
            f = 0.0f;
        label_45:
            float f4 = Math.max(f, 0.0f);
            int v17 = 0;
            while(v17 < b0.h) {
                int v18 = b0.o + v17;
                View view0 = this.o(v18);
                if(view0 != null && view0.getVisibility() != 8) {
                    LayoutParams flexboxLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                    float f5 = f1 + ((float)flexboxLayout$LayoutParams0.topMargin);
                    float f6 = f2 - ((float)flexboxLayout$LayoutParams0.bottomMargin);
                    if(this.p(v18, v17)) {
                        v21 = this.k;
                        f5 += (float)v21;
                        f6 -= (float)v21;
                    }
                    else {
                        v21 = 0;
                    }
                    int v22 = v17 != b0.h - 1 || (this.i & 4) <= 0 ? 0 : this.k;
                    if(z) {
                        if(z1) {
                            int v23 = view0.getMeasuredWidth();
                            int v24 = view0.getMeasuredHeight();
                            v19 = v17;
                            this.o.p(view0, b0, true, v12 - v23, Math.round(f6) - v24, v12, Math.round(f6));
                        }
                        else {
                            v19 = v17;
                            int v25 = view0.getMeasuredWidth();
                            int v26 = view0.getMeasuredHeight();
                            this.o.p(view0, b0, true, v12 - v25, Math.round(f5), v12, v26 + Math.round(f5));
                        }
                        v20 = v12;
                    }
                    else {
                        v19 = v17;
                        v20 = v12;
                        if(z1) {
                            int v27 = view0.getMeasuredHeight();
                            int v28 = view0.getMeasuredWidth();
                            this.o.p(view0, b0, false, v7, Math.round(f6) - v27, v28 + v7, Math.round(f6));
                        }
                        else {
                            int v29 = view0.getMeasuredWidth();
                            int v30 = view0.getMeasuredHeight();
                            this.o.p(view0, b0, false, v7, Math.round(f5), v29 + v7, v30 + Math.round(f5));
                        }
                    }
                    f1 = f5 + (((float)view0.getMeasuredHeight()) + f4 + ((float)flexboxLayout$LayoutParams0.bottomMargin));
                    float f7 = f6 - (((float)view0.getMeasuredHeight()) + f4 + ((float)flexboxLayout$LayoutParams0.topMargin));
                    if(z1) {
                        b1 = b0;
                        b1.b(view0, 0, v22, 0, v21);
                    }
                    else {
                        b1 = b0;
                        b1.b(view0, 0, v21, 0, v22);
                    }
                    b0 = b1;
                    f2 = f7;
                }
                else {
                    v19 = v17;
                    v20 = v12;
                }
                v17 = v19 + 1;
                v12 = v20;
            }
            v7 += b0.g;
            v9 = v12 - b0.g;
            ++v11;
        }
    }

    public final void u(int v, int v1, int v2, int v3) {
        int v15;
        int v14;
        int v11;
        int v10;
        int v4 = View.MeasureSpec.getMode(v1);
        int v5 = View.MeasureSpec.getSize(v1);
        int v6 = View.MeasureSpec.getMode(v2);
        int v7 = View.MeasureSpec.getSize(v2);
        switch(v) {
            case 0: 
            case 1: {
                int v8 = this.getSumOfCrossSize();
                int v9 = this.getPaddingTop();
                v10 = this.getPaddingBottom() + (v9 + v8);
                v11 = this.getLargestMainSize();
                break;
            }
            case 2: 
            case 3: {
                v10 = this.getLargestMainSize();
                int v12 = this.getSumOfCrossSize();
                int v13 = this.getPaddingLeft();
                v11 = this.getPaddingRight() + (v13 + v12);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid flex direction: " + v);
            }
        }
        switch(v4) {
            case 0x80000000: {
                if(v5 < v11) {
                    v3 = View.combineMeasuredStates(v3, 0x1000000);
                }
                else {
                    v5 = v11;
                }
                v14 = View.resolveSizeAndState(v5, v1, v3);
                break;
            }
            case 0: {
                v14 = View.resolveSizeAndState(v11, v1, v3);
                break;
            }
            case 0x40000000: {
                if(v5 < v11) {
                    v3 = View.combineMeasuredStates(v3, 0x1000000);
                }
                v14 = View.resolveSizeAndState(v5, v1, v3);
                break;
            }
            default: {
                throw new IllegalStateException("Unknown width mode is set: " + v4);
            }
        }
        switch(v6) {
            case 0x80000000: {
                if(v7 < v10) {
                    v3 = View.combineMeasuredStates(v3, 0x100);
                }
                else {
                    v7 = v10;
                }
                v15 = View.resolveSizeAndState(v7, v2, v3);
                break;
            }
            case 0: {
                v15 = View.resolveSizeAndState(v10, v2, v3);
                break;
            }
            case 0x40000000: {
                if(v7 < v10) {
                    v3 = View.combineMeasuredStates(v3, 0x100);
                }
                v15 = View.resolveSizeAndState(v7, v2, v3);
                break;
            }
            default: {
                throw new IllegalStateException("Unknown height mode is set: " + v6);
            }
        }
        this.setMeasuredDimension(v14, v15);
    }
}

