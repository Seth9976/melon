package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.r0;
import com.iloen.melon.utils.a;
import java.util.ArrayList;

public class FlexboxItemDecoration extends r0 {
    public final Drawable a;
    public final int b;
    public static final int[] c;

    static {
        FlexboxItemDecoration.c = new int[]{0x1010214};
    }

    public FlexboxItemDecoration(Context context0) {
        TypedArray typedArray0 = context0.obtainStyledAttributes(FlexboxItemDecoration.c);
        this.a = typedArray0.getDrawable(0);
        typedArray0.recycle();
        this.b = 3;
    }

    @Override  // androidx.recyclerview.widget.r0
    public final void getItemOffsets(Rect rect0, View view0, RecyclerView recyclerView0, K0 k00) {
        int v = recyclerView0.getChildAdapterPosition(view0);
        if(v != 0) {
            if((this.b & 1) <= 0 && (this.b & 2) <= 0) {
                rect0.set(0, 0, 0, 0);
                return;
            }
            FlexboxLayoutManager flexboxLayoutManager0 = (FlexboxLayoutManager)recyclerView0.getLayoutManager();
            flexboxLayoutManager0.getClass();
            d d0 = flexboxLayoutManager0.h;
            ArrayList arrayList0 = new ArrayList(flexboxLayoutManager0.g.size());
            int v1 = flexboxLayoutManager0.g.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                b b0 = (b)flexboxLayoutManager0.g.get(v2);
                if(b0.h != 0) {
                    arrayList0.add(b0);
                }
            }
            int v3 = flexboxLayoutManager0.a;
            int v4 = d0.c[v];
            Drawable drawable0 = this.a;
            if((v4 == -1 || v4 >= flexboxLayoutManager0.g.size() || ((b)flexboxLayoutManager0.g.get(v4)).o != v) && v != 0 && (arrayList0.size() == 0 || ((b)a.i(1, arrayList0)).p != v - 1)) {
                if(!flexboxLayoutManager0.m()) {
                    if((this.b & 1) <= 0) {
                        rect0.top = 0;
                        rect0.bottom = 0;
                    }
                    else if(v3 == 3) {
                        rect0.bottom = drawable0.getIntrinsicHeight();
                        rect0.top = 0;
                    }
                    else {
                        rect0.top = drawable0.getIntrinsicHeight();
                        rect0.bottom = 0;
                    }
                }
                else if((this.b & 2) <= 0) {
                    rect0.left = 0;
                    rect0.right = 0;
                }
                else if(flexboxLayoutManager0.e) {
                    rect0.right = drawable0.getIntrinsicWidth();
                    rect0.left = 0;
                }
                else {
                    rect0.left = drawable0.getIntrinsicWidth();
                    rect0.right = 0;
                }
            }
            if(arrayList0.size() != 0 && d0.c[v] != 0) {
                if(flexboxLayoutManager0.m()) {
                    if((this.b & 1) > 0) {
                        rect0.top = drawable0.getIntrinsicHeight();
                        rect0.bottom = 0;
                        return;
                    }
                    rect0.top = 0;
                    rect0.bottom = 0;
                    return;
                }
                if((this.b & 2) > 0) {
                    if(flexboxLayoutManager0.e) {
                        rect0.right = drawable0.getIntrinsicWidth();
                        rect0.left = 0;
                        return;
                    }
                    rect0.left = drawable0.getIntrinsicWidth();
                    rect0.right = 0;
                }
            }
        }
    }

    @Override  // androidx.recyclerview.widget.r0
    public final void onDraw(Canvas canvas0, RecyclerView recyclerView0, K0 k00) {
        int v28;
        int v25;
        int v24;
        int v23;
        int v22;
        int v21;
        int v13;
        int v12;
        int v11;
        int v10;
        int v8;
        int v7;
        Drawable drawable0 = this.a;
        if((this.b & 1) > 0) {
            FlexboxLayoutManager flexboxLayoutManager0 = (FlexboxLayoutManager)recyclerView0.getLayoutManager();
            int v = flexboxLayoutManager0.a;
            int v1 = recyclerView0.getLeft();
            int v2 = recyclerView0.getPaddingLeft();
            int v3 = recyclerView0.getRight();
            int v4 = recyclerView0.getPaddingRight();
            int v5 = recyclerView0.getChildCount();
            int v6 = 0;
            while(v6 < v5) {
                View view0 = recyclerView0.getChildAt(v6);
                LayoutParams recyclerView$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                if(v == 3) {
                    v7 = view0.getBottom() + recyclerView$LayoutParams0.bottomMargin;
                    v8 = drawable0.getIntrinsicHeight() + v7;
                }
                else {
                    v8 = view0.getTop() - recyclerView$LayoutParams0.topMargin;
                    v7 = v8 - drawable0.getIntrinsicHeight();
                }
                if(flexboxLayoutManager0.m()) {
                    if(flexboxLayoutManager0.e) {
                        int v9 = view0.getRight() + recyclerView$LayoutParams0.rightMargin;
                        v10 = Math.min(drawable0.getIntrinsicWidth() + v9, v4 + v3);
                        v11 = view0.getLeft() - recyclerView$LayoutParams0.leftMargin;
                        goto label_33;
                    }
                    else {
                        v11 = Math.max(view0.getLeft() - recyclerView$LayoutParams0.leftMargin - drawable0.getIntrinsicWidth(), v1 - v2);
                        v12 = view0.getRight();
                        v13 = recyclerView$LayoutParams0.rightMargin;
                        goto label_32;
                    }
                    goto label_29;
                }
                else {
                label_29:
                    v11 = view0.getLeft() - recyclerView$LayoutParams0.leftMargin;
                    v12 = view0.getRight();
                    v13 = recyclerView$LayoutParams0.rightMargin;
                }
            label_32:
                v10 = v12 + v13;
            label_33:
                drawable0.setBounds(v11, v7, v10, v8);
                drawable0.draw(canvas0);
                ++v6;
            }
        }
        if((this.b & 2) > 0) {
            FlexboxLayoutManager flexboxLayoutManager1 = (FlexboxLayoutManager)recyclerView0.getLayoutManager();
            int v14 = recyclerView0.getTop();
            int v15 = recyclerView0.getPaddingTop();
            int v16 = recyclerView0.getBottom();
            int v17 = recyclerView0.getPaddingBottom();
            int v18 = recyclerView0.getChildCount();
            int v19 = flexboxLayoutManager1.a;
            int v20 = 0;
            while(v20 < v18) {
                View view1 = recyclerView0.getChildAt(v20);
                LayoutParams recyclerView$LayoutParams1 = (LayoutParams)view1.getLayoutParams();
                if(flexboxLayoutManager1.e) {
                    v21 = view1.getRight() + recyclerView$LayoutParams1.rightMargin;
                    v22 = drawable0.getIntrinsicWidth() + v21;
                }
                else {
                    v22 = view1.getLeft() - recyclerView$LayoutParams1.leftMargin;
                    v21 = v22 - drawable0.getIntrinsicWidth();
                }
                if(flexboxLayoutManager1.m()) {
                    v23 = view1.getTop() - recyclerView$LayoutParams1.topMargin;
                    v24 = view1.getBottom();
                    v25 = recyclerView$LayoutParams1.bottomMargin;
                }
                else if(v19 == 3) {
                    int v26 = view1.getBottom() + recyclerView$LayoutParams1.bottomMargin;
                    int v27 = Math.min(drawable0.getIntrinsicHeight() + v26, v17 + v16);
                    v23 = view1.getTop() - recyclerView$LayoutParams1.topMargin;
                    v28 = v27;
                    goto label_70;
                }
                else {
                    v23 = Math.max(view1.getTop() - recyclerView$LayoutParams1.topMargin - drawable0.getIntrinsicHeight(), v14 - v15);
                    v24 = view1.getBottom();
                    v25 = recyclerView$LayoutParams1.bottomMargin;
                }
                v28 = v24 + v25;
            label_70:
                drawable0.setBounds(v21, v23, v22, v28);
                drawable0.draw(canvas0);
                ++v20;
            }
        }
    }
}

