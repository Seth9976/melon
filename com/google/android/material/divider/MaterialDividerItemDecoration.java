package com.google.android.material.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import com.google.android.material.internal.B;
import d6.a;
import e1.n;

public class MaterialDividerItemDecoration extends r0 {
    public final ShapeDrawable a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final boolean g;
    public final Rect h;

    public MaterialDividerItemDecoration(Context context0, AttributeSet attributeSet0, int v) {
        this.h = new Rect();
        TypedArray typedArray0 = B.m(context0, attributeSet0, a.G, 0x7F04040C, 0x7F1404C2, new int[0]);  // attr:materialDividerStyle
        this.c = n.r(context0, typedArray0, 0).getDefaultColor();
        this.b = typedArray0.getDimensionPixelSize(3, context0.getResources().getDimensionPixelSize(0x7F0702DF));  // dimen:material_divider_thickness
        this.e = typedArray0.getDimensionPixelOffset(2, 0);
        this.f = typedArray0.getDimensionPixelOffset(1, 0);
        this.g = typedArray0.getBoolean(4, true);
        typedArray0.recycle();
        ShapeDrawable shapeDrawable0 = new ShapeDrawable();
        this.c = this.c;
        this.a = shapeDrawable0;
        shapeDrawable0.setTint(this.c);
        if(v != 0 && v != 1) {
            throw new IllegalArgumentException("Invalid orientation: " + v + ". It should be either HORIZONTAL or VERTICAL");
        }
        this.d = v;
    }

    public final boolean c(RecyclerView recyclerView0, View view0) {
        int v = recyclerView0.getChildAdapterPosition(view0);
        j0 j00 = recyclerView0.getAdapter();
        return v != -1 && (j00 == null || v != j00.getItemCount() - 1 || this.g);
    }

    @Override  // androidx.recyclerview.widget.r0
    public final void getItemOffsets(Rect rect0, View view0, RecyclerView recyclerView0, K0 k00) {
        rect0.set(0, 0, 0, 0);
        if(this.c(recyclerView0, view0)) {
            int v = this.b;
            if(this.d == 1) {
                rect0.bottom = v;
                return;
            }
            if(B.l(recyclerView0)) {
                rect0.left = v;
                return;
            }
            rect0.right = v;
        }
    }

    @Override  // androidx.recyclerview.widget.r0
    public final void onDraw(Canvas canvas0, RecyclerView recyclerView0, K0 k00) {
        int v16;
        int v15;
        int v12;
        int v11;
        int v5;
        int v4;
        if(recyclerView0.getLayoutManager() == null) {
            return;
        }
        int v = this.b;
        int v1 = 0;
        int v2 = this.f;
        int v3 = this.e;
        Rect rect0 = this.h;
        if(this.d == 1) {
            canvas0.save();
            if(recyclerView0.getClipToPadding()) {
                v4 = recyclerView0.getPaddingLeft();
                v5 = recyclerView0.getWidth() - recyclerView0.getPaddingRight();
                canvas0.clipRect(v4, recyclerView0.getPaddingTop(), v5, recyclerView0.getHeight() - recyclerView0.getPaddingBottom());
            }
            else {
                v5 = recyclerView0.getWidth();
                v4 = 0;
            }
            boolean z = B.l(recyclerView0);
            int v6 = z ? v2 : v3;
            if(z) {
                v2 = v3;
            }
            int v7 = recyclerView0.getChildCount();
            while(v1 < v7) {
                View view0 = recyclerView0.getChildAt(v1);
                if(this.c(recyclerView0, view0)) {
                    recyclerView0.getLayoutManager().getDecoratedBoundsWithMargins(view0, rect0);
                    int v8 = rect0.bottom;
                    int v9 = Math.round(view0.getTranslationY());
                    this.a.setBounds(v4 + v6, v9 + v8 - v, v5 - v2, v9 + v8);
                    int v10 = Math.round(view0.getAlpha() * 255.0f);
                    this.a.setAlpha(v10);
                    this.a.draw(canvas0);
                }
                ++v1;
            }
            canvas0.restore();
            return;
        }
        canvas0.save();
        if(recyclerView0.getClipToPadding()) {
            v11 = recyclerView0.getPaddingTop();
            v12 = recyclerView0.getHeight() - recyclerView0.getPaddingBottom();
            canvas0.clipRect(recyclerView0.getPaddingLeft(), v11, recyclerView0.getWidth() - recyclerView0.getPaddingRight(), v12);
        }
        else {
            v12 = recyclerView0.getHeight();
            v11 = 0;
        }
        boolean z1 = B.l(recyclerView0);
        int v13 = recyclerView0.getChildCount();
        while(v1 < v13) {
            View view1 = recyclerView0.getChildAt(v1);
            if(this.c(recyclerView0, view1)) {
                recyclerView0.getLayoutManager().getDecoratedBoundsWithMargins(view1, rect0);
                int v14 = Math.round(view1.getTranslationX());
                if(z1) {
                    v15 = rect0.left + v14;
                    v16 = v15 + v;
                }
                else {
                    v16 = v14 + rect0.right;
                    v15 = v16 - v;
                }
                this.a.setBounds(v15, v11 + v3, v16, v12 - v2);
                int v17 = Math.round(view1.getAlpha() * 255.0f);
                this.a.setAlpha(v17);
                this.a.draw(canvas0);
            }
            ++v1;
        }
        canvas0.restore();
    }
}

